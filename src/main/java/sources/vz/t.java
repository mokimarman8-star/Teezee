package vz;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public abstract class t {
    protected final int a;
    protected t b;

    public t(int i) {
        this(i, null);
    }

    public t(int i, t tVar) {
        if (i != 393216 && i != 458752) {
            throw new IllegalArgumentException();
        }
        this.a = i;
        this.b = tVar;
    }

    public abstract void a();

    public abstract void b(String str, int i, String... strArr);

    public abstract void c(String str);

    public abstract void d(String str, int i, String... strArr);

    public abstract void e(String str);

    public abstract void f(String str, String... strArr);

    public abstract void g(String str, int i, String str2);

    public abstract void h(String str);
}
