package androidx.media3.common.util;

import android.text.TextUtils;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a {
    public static void a(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z5, Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int c(int i5, int i6, int i7) {
        if (i5 < i6 || i5 >= i7) {
            throw new IndexOutOfBoundsException();
        }
        return i5;
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    public static Object e(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object f(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static void g(boolean z5) {
        if (!z5) {
            throw new IllegalStateException();
        }
    }

    public static void h(boolean z5, Object obj) {
        if (!z5) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static Object i(Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException();
    }

    public static Object j(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException(String.valueOf(obj2));
    }
}
