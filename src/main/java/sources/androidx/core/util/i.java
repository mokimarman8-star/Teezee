package androidx.core.util;

import android.text.TextUtils;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class i {
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

    public static int c(int i5, int i6, int i7, String str) {
        if (i5 < i6) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", str, Integer.valueOf(i6), Integer.valueOf(i7)));
        }
        if (i5 <= i7) {
            return i5;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", str, Integer.valueOf(i6), Integer.valueOf(i7)));
    }

    public static int d(int i5) {
        if (i5 >= 0) {
            return i5;
        }
        throw new IllegalArgumentException();
    }

    public static int e(int i5, String str) {
        if (i5 >= 0) {
            return i5;
        }
        throw new IllegalArgumentException(str);
    }

    public static int f(int i5, int i6) {
        if ((i5 & i6) == i5) {
            return i5;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i5) + ", but only 0x" + Integer.toHexString(i6) + " are allowed");
    }

    public static Object g(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object h(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static void i(boolean z5, String str) {
        if (!z5) {
            throw new IllegalStateException(str);
        }
    }

    public static CharSequence j(CharSequence charSequence, Object obj) {
        if (TextUtils.isEmpty(charSequence)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return charSequence;
    }
}
