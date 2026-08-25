package com.bytedance.sdk.component.HiB.TKC.Sj.Sj;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class TKC implements Closeable {
    private int EjP;
    private int HiB;
    private final InputStream Sj;
    private byte[] TKC;
    private final Charset sP;

    public TKC(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(EjP.Sj)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.Sj = inputStream;
        this.sP = charset;
        this.TKC = new byte[i];
    }

    public TKC(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void TKC() throws IOException {
        InputStream inputStream = this.Sj;
        byte[] bArr = this.TKC;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.EjP = 0;
        this.HiB = read;
    }

    public String Sj() throws IOException {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.Sj) {
            try {
                if (this.TKC == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.EjP >= this.HiB) {
                    TKC();
                }
                for (int i3 = this.EjP; i3 != this.HiB; i3++) {
                    byte[] bArr2 = this.TKC;
                    if (bArr2[i3] == 10) {
                        int i4 = this.EjP;
                        if (i3 != i4) {
                            i2 = i3 - 1;
                            if (bArr2[i2] == 13) {
                                String str = new String(bArr2, i4, i2 - i4, this.sP.name());
                                this.EjP = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(bArr2, i4, i2 - i4, this.sP.name());
                        this.EjP = i3 + 1;
                        return str2;
                    }
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((this.HiB - this.EjP) + 80) { // from class: com.bytedance.sdk.component.HiB.TKC.Sj.Sj.TKC.1
                    @Override // java.io.ByteArrayOutputStream
                    public String toString() {
                        int i8 = ((ByteArrayOutputStream) this).count;
                        if (i8 > 0 && ((ByteArrayOutputStream) this).buf[i8 - 1] == 13) {
                            i8--;
                        }
                        try {
                            return new String(((ByteArrayOutputStream) this).buf, 0, i8, TKC.this.sP.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1: while (true) {
                    byte[] bArr3 = this.TKC;
                    int i8 = this.EjP;
                    byteArrayOutputStream.write(bArr3, i8, this.HiB - i8);
                    this.HiB = -1;
                    TKC();
                    i = this.EjP;
                    while (i != this.HiB) {
                        bArr = this.TKC;
                        if (bArr[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                int i9 = this.EjP;
                if (i != i9) {
                    byteArrayOutputStream.write(bArr, i9, i - i9);
                }
                this.EjP = i + 1;
                return byteArrayOutputStream.toString();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.Sj) {
            try {
                if (this.TKC != null) {
                    this.TKC = null;
                    this.Sj.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean sP() {
        return this.HiB == -1;
    }
}
