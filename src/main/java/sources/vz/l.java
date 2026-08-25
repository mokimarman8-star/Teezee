package vz;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public abstract class l {
    protected final int a;
    protected l b;

    public l(int i) {
        this(i, null);
    }

    public l(int i, l lVar) {
        if (i != 393216 && i != 327680 && i != 262144 && i != 458752) {
            throw new IllegalArgumentException();
        }
        this.a = i;
        this.b = lVar;
    }

    public abstract a a(String str, boolean z);

    public abstract void b(c cVar);

    public abstract void c();

    public abstract a d(int i, z zVar, String str, boolean z);
}
