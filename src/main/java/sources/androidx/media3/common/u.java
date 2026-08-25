package androidx.media3.common;

import java.util.HashSet;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    private static final HashSet f9019a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private static String f9020b = "media3.common";

    public static synchronized void a(String str) {
        synchronized (u.class) {
            if (f9019a.add(str)) {
                f9020b += ", " + str;
            }
        }
    }

    public static synchronized String b() {
        String str;
        synchronized (u.class) {
            str = f9020b;
        }
        return str;
    }
}
