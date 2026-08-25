package androidx.compose.runtime;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private int f2671a;

    public c(int i5) {
        this.f2671a = i5;
    }

    public final int a() {
        return this.f2671a;
    }

    public final boolean b() {
        return this.f2671a != Integer.MIN_VALUE;
    }

    public final void c(int i5) {
        this.f2671a = i5;
    }

    public final int d(j2 j2Var) {
        return j2Var.c(this);
    }

    public final int e(m2 m2Var) {
        return m2Var.F(this);
    }

    public String toString() {
        return super.toString() + "{ location = " + this.f2671a + " }";
    }
}
