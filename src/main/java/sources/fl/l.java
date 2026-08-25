package fl;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
class l implements Closeable {
    private final InputStream a;
    private final Charset b;
    private byte[] c;
    private int d;
    private int e;

    class a extends ByteArrayOutputStream {
        a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            if (i > 0) {
                int i2 = i - 1;
                if (((ByteArrayOutputStream) this).buf[i2] == 13) {
                    i = i2;
                }
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i, l.this.b.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public l(InputStream inputStream, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (!charset.equals(d.a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.a = inputStream;
        this.b = charset;
        this.c = new byte[8192];
    }

    private void k() {
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
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean d() {
        return this.e == -1;
    }

    public String h() {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.a) {
            try {
                if (this.c == null) {
                    throw new IOException("LineReader is closed");
                }
                if (this.d >= this.e) {
                    k();
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
                a aVar = new a((this.e - this.d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.c;
                    int i5 = this.d;
                    aVar.write(bArr3, i5, this.e - i5);
                    this.e = -1;
                    k();
                    i = this.d;
                    while (i != this.e) {
                        bArr = this.c;
                        if (bArr[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                int i6 = this.d;
                if (i != i6) {
                    aVar.write(bArr, i6, i - i6);
                }
                this.d = i + 1;
                return aVar.toString();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
