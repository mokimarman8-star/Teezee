package g2;

import java.util.NoSuchElementException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class b implements n {

    /* renamed from: b, reason: collision with root package name */
    private final long f15358b;

    /* renamed from: c, reason: collision with root package name */
    private final long f15359c;

    /* renamed from: d, reason: collision with root package name */
    private long f15360d;

    public b(long j5, long j6) {
        this.f15358b = j5;
        this.f15359c = j6;
        f();
    }

    protected final void c() {
        long j5 = this.f15360d;
        if (j5 < this.f15358b || j5 > this.f15359c) {
            throw new NoSuchElementException();
        }
    }

    protected final long d() {
        return this.f15360d;
    }

    public boolean e() {
        return this.f15360d > this.f15359c;
    }

    public void f() {
        this.f15360d = this.f15358b - 1;
    }

    @Override // g2.n
    public boolean next() {
        this.f15360d++;
        return !e();
    }
}
