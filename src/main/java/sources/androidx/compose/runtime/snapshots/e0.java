package androidx.compose.runtime.snapshots;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class e0 {

    /* renamed from: a, reason: collision with root package name */
    private int f2975a = SnapshotKt.H().f();

    /* renamed from: b, reason: collision with root package name */
    private e0 f2976b;

    public abstract void c(e0 e0Var);

    public abstract e0 d();

    public final e0 e() {
        return this.f2976b;
    }

    public final int f() {
        return this.f2975a;
    }

    public final void g(e0 e0Var) {
        this.f2976b = e0Var;
    }

    public final void h(int i5) {
        this.f2975a = i5;
    }
}
