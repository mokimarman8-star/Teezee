package y4;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final b f18685a;

    /* renamed from: b, reason: collision with root package name */
    private p4.a f18686b;

    /* renamed from: c, reason: collision with root package name */
    protected Object f18687c;

    public c() {
        this.f18685a = new b();
        this.f18687c = null;
    }

    public c(Object obj) {
        this.f18685a = new b();
        this.f18687c = obj;
    }

    public Object a(b bVar) {
        return this.f18687c;
    }

    public final Object b(float f5, float f6, Object obj, Object obj2, float f7, float f8, float f9) {
        return a(this.f18685a.h(f5, f6, obj, obj2, f7, f8, f9));
    }

    public final void c(p4.a aVar) {
        this.f18686b = aVar;
    }
}
