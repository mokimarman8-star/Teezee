package org.apache.commons.compress.archivers.zip;

import java.util.zip.CRC32;
import java.util.zip.ZipException;
import okhttp3.HttpUrl;
import org.apache.tools.zip.UnixStat;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class b implements t, Cloneable {
    private static final ZipShort g = new ZipShort(30062);
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private String d = HttpUrl.FRAGMENT_ENCODE_SET;
    private boolean e = false;
    private CRC32 f = new CRC32();

    public String a() {
        return this.d;
    }

    protected int b(int i) {
        return (i & UnixStat.PERM_MASK) | (e() ? UnixStat.LINK_FLAG : c() ? 16384 : UnixStat.FILE_FLAG);
    }

    public boolean c() {
        return this.e && !e();
    }

    public Object clone() {
        try {
            b bVar = (b) super.clone();
            bVar.f = new CRC32();
            return bVar;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean e() {
        return a().length() != 0;
    }

    public void g(boolean z) {
        this.e = z;
        this.a = b(this.a);
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public ZipShort getHeaderId() {
        return g;
    }

    public void h(int i) {
        this.a = b(i);
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromCentralDirectoryData(byte[] bArr, int i, int i2) {
        parseFromLocalFileData(bArr, i, i2);
    }

    @Override // org.apache.commons.compress.archivers.zip.t
    public void parseFromLocalFileData(byte[] bArr, int i, int i2) {
        long value = ZipLong.getValue(bArr, i);
        int i3 = i2 - 4;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i + 4, bArr2, 0, i3);
        this.f.reset();
        this.f.update(bArr2);
        long value2 = this.f.getValue();
        if (value != value2) {
            throw new ZipException("Bad CRC checksum, expected " + Long.toHexString(value) + " instead of " + Long.toHexString(value2));
        }
        int value3 = ZipShort.getValue(bArr2, 0);
        int value4 = (int) ZipLong.getValue(bArr2, 2);
        byte[] bArr3 = new byte[value4];
        this.b = ZipShort.getValue(bArr2, 6);
        this.c = ZipShort.getValue(bArr2, 8);
        if (value4 == 0) {
            this.d = HttpUrl.FRAGMENT_ENCODE_SET;
        } else {
            if (value4 > i2 - 14) {
                throw new ZipException("Bad symbolic link name length " + value4 + " in ASI extra field");
            }
            System.arraycopy(bArr2, 10, bArr3, 0, value4);
            this.d = new String(bArr3);
        }
        g((value3 & 16384) != 0);
        h(value3);
    }
}
