package cz;

import java.io.InputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class b extends InputStream {
    private final byte[] a = new byte[1];
    private long b = 0;

    protected void b(int i) {
        f(i);
    }

    protected void f(long j) {
        if (j != -1) {
            this.b += j;
        }
    }

    public long h() {
        return this.b;
    }

    protected void j(long j) {
        this.b -= j;
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.a, 0, 1) == -1) {
            return -1;
        }
        return this.a[0] & 255;
    }
}
