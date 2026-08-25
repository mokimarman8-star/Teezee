package v;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final Object f18028a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f18029b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a() {
        this(r0, r0);
        w.c cVar = w.c.f18079a;
    }

    public a(Object obj) {
        this(obj, w.c.f18079a);
    }

    public a(Object obj, Object obj2) {
        this.f18028a = obj;
        this.f18029b = obj2;
    }

    public final boolean a() {
        return this.f18029b != w.c.f18079a;
    }

    public final boolean b() {
        return this.f18028a != w.c.f18079a;
    }

    public final Object c() {
        return this.f18029b;
    }

    public final Object d() {
        return this.f18028a;
    }

    public final a e(Object obj) {
        return new a(this.f18028a, obj);
    }

    public final a f(Object obj) {
        return new a(obj, this.f18029b);
    }
}
