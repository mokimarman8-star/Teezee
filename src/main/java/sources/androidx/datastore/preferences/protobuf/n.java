package androidx.datastore.preferences.protobuf;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class n {

    /* renamed from: a, reason: collision with root package name */
    static final Class f7726a = c();

    public static o a() {
        o b5 = b("getEmptyRegistry");
        return b5 != null ? b5 : o.f7728c;
    }

    private static final o b(String str) {
        Class cls = f7726a;
        if (cls == null) {
            return null;
        }
        try {
            return (o) cls.getDeclaredMethod(str, null).invoke(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    static Class c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
