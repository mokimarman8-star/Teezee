package x9;

import java.util.NoSuchElementException;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public abstract class b implements o {
    private final long b;
    private final long c;
    private long d;

    public b(long j, long j2) {
        this.b = j;
        this.c = j2;
        f();
    }

    protected final void c() {
        long j = this.d;
        if (j < this.b || j > this.c) {
            throw new NoSuchElementException();
        }
    }

    protected final long d() {
        return this.d;
    }

    public boolean e() {
        return this.d > this.c;
    }

    public void f() {
        this.d = this.b - 1;
    }

    @Override // x9.o
    public boolean next() {
        this.d++;
        return !e();
    }
}
