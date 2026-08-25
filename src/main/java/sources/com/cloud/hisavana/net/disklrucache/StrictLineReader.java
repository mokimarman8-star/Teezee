package com.cloud.hisavana.net.disklrucache;

import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class StrictLineReader implements Closeable {
    private final InputStream a;
    private final Charset b;
    private byte[] c;
    private int d;
    private int e;

    public StrictLineReader(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(DiskLruCacheUtil.a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.a = inputStream;
        this.b = charset;
        this.c = new byte[i];
    }

    public StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void d() {
        InputStream inputStream = this.a;
        byte[] bArr = this.c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.d = 0;
        this.e = read;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.a) {
            try {
                if (this.c != null) {
                    this.c = null;
                    this.a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean h() {
        return this.e == -1;
    }

    public String k() {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.a) {
            try {
                if (this.c == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.d >= this.e) {
                    d();
                }
                for (int i3 = this.d; i3 != this.e; i3++) {
                    byte[] bArr2 = this.c;
                    if (bArr2[i3] == 10) {
                        int i4 = this.d;
                        if (i3 != i4) {
                            i2 = i3 - 1;
                            if (bArr2[i2] == 13) {
                                String str = new String(bArr2, i4, i2 - i4, this.b.name());
                                this.d = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(bArr2, i4, i2 - i4, this.b.name());
                        this.d = i3 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.e - this.d) + 80) { // from class: com.cloud.hisavana.net.disklrucache.StrictLineReader.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i8 = ((ByteArrayOutputStream) this).count;
                        if (i8 > 0 && ((ByteArrayOutputStream) this).buf[i8 - 1] == 13) {
                            i8--;
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i8, StrictLineReader.this.b.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.c;
                    int i8 = this.d;
                    byteArrayOutputStream.write(bArr3, i8, this.e - i8);
                    this.e = -1;
                    d();
                    i = this.d;
                    while (i != this.e) {
                        bArr = this.c;
                        if (bArr[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                int i9 = this.d;
                if (i != i9) {
                    byteArrayOutputStream.write(bArr, i9, i - i9);
                }
                this.d = i + 1;
                return byteArrayOutputStream.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
