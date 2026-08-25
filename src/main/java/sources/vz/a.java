package vz;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public abstract class a {
    protected final int a;
    protected a b;

    public a(int i) {
        this(i, null);
    }

    public a(int i, a aVar) {
        if (i != 393216 && i != 327680 && i != 262144 && i != 458752) {
            throw new IllegalArgumentException();
        }
        this.a = i;
        this.b = aVar;
    }

    public abstract void a(String str, Object obj);

    public abstract a b(String str, String str2);

    public abstract a c(String str);

    public abstract void d();

    public abstract void e(String str, String str2, String str3);
}
