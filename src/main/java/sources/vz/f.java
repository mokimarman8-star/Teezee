package vz;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public abstract class f {
    protected final int a;
    protected f b;

    public f(int i) {
        this(i, null);
    }

    public f(int i, f fVar) {
        if (i != 393216 && i != 327680 && i != 262144 && i != 458752) {
            throw new IllegalArgumentException();
        }
        this.a = i;
        this.b = fVar;
    }

    public abstract void a(int i, int i2, String str, String str2, String str3, String[] strArr);

    public abstract a b(String str, boolean z);

    public abstract void c(c cVar);

    public abstract void d();

    public abstract l e(int i, String str, String str2, String str3, Object obj);

    public abstract void f(String str, String str2, String str3, int i);

    public abstract r g(int i, String str, String str2, String str3, String[] strArr);

    public abstract t h(String str, int i, String str2);

    public abstract void i(String str);

    public abstract void j(String str);

    public abstract void k(String str, String str2, String str3);

    public abstract void l(String str, String str2);

    public abstract a m(int i, z zVar, String str, boolean z);
}
