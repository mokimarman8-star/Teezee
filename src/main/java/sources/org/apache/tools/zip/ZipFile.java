package org.apache.tools.zip;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class ZipFile {
    private static final int BYTE_SHIFT = 8;
    private static final int CFD_LOCATOR_OFFSET = 16;
    private static final int CFH_LEN = 42;
    private static final int HASH_SIZE = 509;
    private static final long LFH_OFFSET_FOR_FILENAME_LENGTH = 26;
    private static final int MIN_EOCD_SIZE = 22;
    private static final int NIBLET_MASK = 15;
    private static final int POS_0 = 0;
    private static final int POS_1 = 1;
    private static final int POS_2 = 2;
    private static final int POS_3 = 3;
    private static final int SHORT = 2;
    private static final int WORD = 4;
    private RandomAccessFile archive;
    private String encoding;
    private Hashtable entries;
    private Hashtable nameMap;

    private class BoundedInputStream extends InputStream {
        private boolean addDummyByte = false;
        private long loc;
        private long remaining;

        BoundedInputStream(long j, long j2) {
            this.remaining = j2;
            this.loc = j;
        }

        void addDummy() {
            this.addDummyByte = true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int read;
            long j = this.remaining;
            this.remaining = j - 1;
            if (j <= 0) {
                if (!this.addDummyByte) {
                    return -1;
                }
                this.addDummyByte = false;
                return 0;
            }
            synchronized (ZipFile.this.archive) {
                RandomAccessFile randomAccessFile = ZipFile.this.archive;
                long j2 = this.loc;
                this.loc = 1 + j2;
                randomAccessFile.seek(j2);
                read = ZipFile.this.archive.read();
            }
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read;
            long j = this.remaining;
            if (j <= 0) {
                if (!this.addDummyByte) {
                    return -1;
                }
                this.addDummyByte = false;
                bArr[i] = 0;
                return 1;
            }
            if (i2 <= 0) {
                return 0;
            }
            if (i2 > j) {
                i2 = (int) j;
            }
            synchronized (ZipFile.this.archive) {
                ZipFile.this.archive.seek(this.loc);
                read = ZipFile.this.archive.read(bArr, i, i2);
            }
            if (read > 0) {
                long j2 = read;
                this.loc += j2;
                this.remaining -= j2;
            }
            return read;
        }
    }

    private static final class OffsetEntry {
        private long dataOffset;
        private long headerOffset;

        private OffsetEntry() {
            this.headerOffset = -1L;
            this.dataOffset = -1L;
        }
    }

    public ZipFile(File file) throws IOException {
        this(file, (String) null);
    }

    public ZipFile(File file, String str) throws IOException {
        this.entries = new Hashtable(HASH_SIZE);
        this.nameMap = new Hashtable(HASH_SIZE);
        this.encoding = str;
        this.archive = new RandomAccessFile(file, "r");
        try {
            populateFromCentralDirectory();
            resolveLocalFileHeaderData();
        } catch (IOException e) {
            try {
                this.archive.close();
            } catch (IOException unused) {
            }
            throw e;
        }
    }

    public ZipFile(String str) throws IOException {
        this(new File(str), (String) null);
    }

    public ZipFile(String str, String str2) throws IOException {
        this(new File(str), str2);
    }

    public static void closeQuietly(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused) {
            }
        }
    }

    private static long dosToJavaTime(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, ((int) ((j >> 25) & 127)) + 1980);
        calendar.set(2, ((int) ((j >> 21) & 15)) - 1);
        calendar.set(5, ((int) (j >> 16)) & 31);
        calendar.set(11, ((int) (j >> 11)) & 31);
        calendar.set(12, ((int) (j >> 5)) & 63);
        calendar.set(13, ((int) (j << 1)) & 62);
        return calendar.getTime().getTime();
    }

    protected static Date fromDosTime(ZipLong zipLong) {
        return new Date(dosToJavaTime(zipLong.getValue()));
    }

    private void populateFromCentralDirectory() throws IOException {
        positionAtCentralDirectory();
        byte[] bArr = new byte[42];
        byte[] bArr2 = new byte[4];
        this.archive.readFully(bArr2);
        long value = ZipLong.getValue(ZipOutputStream.CFH_SIG);
        for (long value2 = ZipLong.getValue(bArr2); value2 == value; value2 = ZipLong.getValue(bArr2)) {
            this.archive.readFully(bArr);
            ZipEntry zipEntry = new ZipEntry();
            zipEntry.setPlatform((ZipShort.getValue(bArr, 0) >> 8) & 15);
            zipEntry.setMethod(ZipShort.getValue(bArr, 6));
            zipEntry.setTime(dosToJavaTime(ZipLong.getValue(bArr, 8)));
            zipEntry.setCrc(ZipLong.getValue(bArr, 12));
            zipEntry.setCompressedSize(ZipLong.getValue(bArr, 16));
            zipEntry.setSize(ZipLong.getValue(bArr, 20));
            int value3 = ZipShort.getValue(bArr, 24);
            int value4 = ZipShort.getValue(bArr, 26);
            int value5 = ZipShort.getValue(bArr, 28);
            zipEntry.setInternalAttributes(ZipShort.getValue(bArr, 32));
            zipEntry.setExternalAttributes(ZipLong.getValue(bArr, 34));
            byte[] bArr3 = new byte[value3];
            this.archive.readFully(bArr3);
            zipEntry.setName(getString(bArr3));
            OffsetEntry offsetEntry = new OffsetEntry();
            offsetEntry.headerOffset = ZipLong.getValue(bArr, 38);
            this.entries.put(zipEntry, offsetEntry);
            this.nameMap.put(zipEntry.getName(), zipEntry);
            this.archive.skipBytes(value4);
            byte[] bArr4 = new byte[value5];
            this.archive.readFully(bArr4);
            zipEntry.setComment(getString(bArr4));
            this.archive.readFully(bArr2);
        }
    }

    private void positionAtCentralDirectory() throws IOException {
        long length = this.archive.length() - 22;
        boolean z = false;
        if (length >= 0) {
            this.archive.seek(length);
            byte[] bArr = ZipOutputStream.EOCD_SIG;
            int read = this.archive.read();
            while (true) {
                if (read != -1) {
                    if (read == bArr[0] && this.archive.read() == bArr[1] && this.archive.read() == bArr[2] && this.archive.read() == bArr[3]) {
                        z = true;
                        break;
                    } else {
                        length--;
                        this.archive.seek(length);
                        read = this.archive.read();
                    }
                } else {
                    break;
                }
            }
        }
        if (!z) {
            throw new ZipException("archive is not a ZIP archive");
        }
        this.archive.seek(length + 16);
        byte[] bArr2 = new byte[4];
        this.archive.readFully(bArr2);
        this.archive.seek(ZipLong.getValue(bArr2));
    }

    private void resolveLocalFileHeaderData() throws IOException {
        Enumeration entries = getEntries();
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            OffsetEntry offsetEntry = (OffsetEntry) this.entries.get(zipEntry);
            long j = offsetEntry.headerOffset;
            this.archive.seek(LFH_OFFSET_FOR_FILENAME_LENGTH + j);
            byte[] bArr = new byte[2];
            this.archive.readFully(bArr);
            int value = ZipShort.getValue(bArr);
            this.archive.readFully(bArr);
            int value2 = ZipShort.getValue(bArr);
            this.archive.skipBytes(value);
            byte[] bArr2 = new byte[value2];
            this.archive.readFully(bArr2);
            zipEntry.setExtra(bArr2);
            offsetEntry.dataOffset = j + 30 + value + value2;
        }
    }

    public void close() throws IOException {
        this.archive.close();
    }

    public String getEncoding() {
        return this.encoding;
    }

    public Enumeration getEntries() {
        return this.entries.keys();
    }

    public ZipEntry getEntry(String str) {
        return (ZipEntry) this.nameMap.get(str);
    }

    public InputStream getInputStream(ZipEntry zipEntry) throws IOException, ZipException {
        OffsetEntry offsetEntry = (OffsetEntry) this.entries.get(zipEntry);
        if (offsetEntry == null) {
            return null;
        }
        BoundedInputStream boundedInputStream = new BoundedInputStream(offsetEntry.dataOffset, zipEntry.getCompressedSize());
        int method = zipEntry.getMethod();
        if (method == 0) {
            return boundedInputStream;
        }
        if (method == 8) {
            boundedInputStream.addDummy();
            return new InflaterInputStream(boundedInputStream, new Inflater(true));
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Found unsupported compression method ");
        stringBuffer.append(zipEntry.getMethod());
        throw new ZipException(stringBuffer.toString());
    }

    protected String getString(byte[] bArr) throws ZipException {
        String str = this.encoding;
        if (str == null) {
            return new String(bArr);
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            throw new ZipException(e.getMessage());
        }
    }
}
