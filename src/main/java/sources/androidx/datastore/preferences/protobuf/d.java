package androidx.datastore.preferences.protobuf;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f7591a;

    /* renamed from: b, reason: collision with root package name */
    private static final Class f7592b = a("libcore.io.Memory");

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f7593c;

    static {
        f7593c = (f7591a || a("org.robolectric.Robolectric") == null) ? false : true;
    }

    private static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static Class b() {
        return f7592b;
    }

    static boolean c() {
        return f7591a || !(f7592b == null || f7593c);
    }
}
