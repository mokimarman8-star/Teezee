package org.apache.tools.ant.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class n extends InputStream {
    private Reader a;
    private String b;
    private byte[] c;
    private int d;

    public n(Reader reader) {
        this.b = System.getProperty("file.encoding");
        this.a = reader;
    }

    public n(Reader reader, String str) {
        this(reader);
        if (str == null) {
            throw new IllegalArgumentException("encoding must not be null");
        }
        this.b = str;
    }

    @Override // java.io.InputStream
    public synchronized int available() {
        Reader reader = this.a;
        if (reader == null) {
            throw new IOException("Stream Closed");
        }
        byte[] bArr = this.c;
        if (bArr != null) {
            return bArr.length - this.d;
        }
        return reader.ready() ? 1 : 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        Reader reader = this.a;
        if (reader != null) {
            reader.close();
            this.c = null;
            this.a = null;
        }
    }

    @Override // java.io.InputStream
    public synchronized void mark(int i) {
        try {
            this.a.mark(i);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public synchronized int read() {
        byte b;
        int i;
        try {
            if (this.a == null) {
                throw new IOException("Stream Closed");
            }
            byte[] bArr = this.c;
            if (bArr == null || (i = this.d) >= bArr.length) {
                byte[] bArr2 = new byte[1];
                if (read(bArr2, 0, 1) <= 0) {
                    return -1;
                }
                b = bArr2[0];
            } else {
                b = bArr[i];
                int i2 = i + 1;
                this.d = i2;
                if (i2 == bArr.length) {
                    this.c = null;
                }
            }
            return b & 255;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        try {
            if (this.a == null) {
                throw new IOException("Stream Closed");
            }
            if (i2 == 0) {
                return 0;
            }
            while (true) {
                byte[] bArr2 = this.c;
                if (bArr2 != null) {
                    int length = bArr2.length;
                    int i3 = this.d;
                    if (i2 > length - i3) {
                        i2 = bArr2.length - i3;
                    }
                    System.arraycopy(bArr2, i3, bArr, i, i2);
                    int i4 = this.d + i2;
                    this.d = i4;
                    if (i4 >= this.c.length) {
                        this.c = null;
                    }
                    return i2;
                }
                char[] cArr = new char[i2];
                int read = this.a.read(cArr);
                if (read == -1) {
                    return -1;
                }
                if (read > 0) {
                    this.c = new String(cArr, 0, read).getBytes(this.b);
                    this.d = 0;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        Reader reader = this.a;
        if (reader == null) {
            throw new IOException("Stream Closed");
        }
        this.c = null;
        reader.reset();
    }
}
