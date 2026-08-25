package com.cloud.hisavana.net.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class ByteBufferUtil {
    private static final AtomicReference a = new AtomicReference();

    private static class ByteBufferStream extends InputStream {
        private final ByteBuffer a;
        private int b;

        @Override // java.io.InputStream
        public int available() {
            return this.a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.b = this.a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.a.hasRemaining()) {
                return this.a.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (!this.a.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i2, available());
            this.a.get(bArr, i, min);
            return min;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            int i = this.b;
            if (i == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.a.position(i);
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (!this.a.hasRemaining()) {
                return -1L;
            }
            long min = Math.min(j, available());
            this.a.position((int) (r0.position() + min));
            return min;
        }
    }

    public static class ContentLengthInputStream extends InputStream {
        private final InputStream a;
        private final int b;

        @Override // java.io.InputStream
        public int available() {
            return this.b;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.a.close();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.a.mark(i);
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.a.markSupported();
        }

        @Override // java.io.InputStream
        public int read() {
            return this.a.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) {
            return this.a.read(bArr);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            return this.a.read(bArr, i, i2);
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            this.a.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            return this.a.skip(j);
        }
    }

    static final class SafeArray {
        private final int a;
        private final int b;
        private final byte[] c;

        public SafeArray(byte[] bArr, int i, int i2) {
            this.c = bArr;
            this.a = i;
            this.b = i2;
        }
    }

    private ByteBufferUtil() {
    }

    public static ByteBuffer a(File file) {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                fileChannel = randomAccessFile.getChannel();
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, file.length()).load();
                try {
                    fileChannel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
                return load;
            } catch (Throwable th) {
                th = th;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    private static SafeArray b(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new SafeArray(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    public static byte[] c(ByteBuffer byteBuffer) {
        SafeArray b = b(byteBuffer);
        if (b != null && b.a == 0 && b.b == b.c.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }
}
