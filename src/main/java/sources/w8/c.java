package w8;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class c implements b {
    private static final c b = new c(null);
    private final Object a;

    private c(Object obj) {
        this.a = obj;
    }

    public static b a(Object obj) {
        return new c(d.c(obj, "instance cannot be null"));
    }

    public Object get() {
        return this.a;
    }
}
