package androidx.core.os;

import android.os.Build;
import android.os.ext.SdkExtensions;
import androidx.media3.common.PlaybackException;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f7009a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final int f7010b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f7011c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f7012d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f7013e;

    /* renamed from: androidx.core.os.a$a, reason: collision with other inner class name */
    private static final class C0048a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0048a f7014a = new C0048a();

        private C0048a() {
        }

        public final int a(int i5) {
            return SdkExtensions.getExtensionVersion(i5);
        }
    }

    static {
        int i5 = Build.VERSION.SDK_INT;
        f7010b = i5 >= 30 ? C0048a.f7014a.a(30) : 0;
        f7011c = i5 >= 30 ? C0048a.f7014a.a(31) : 0;
        f7012d = i5 >= 30 ? C0048a.f7014a.a(33) : 0;
        f7013e = i5 >= 30 ? C0048a.f7014a.a(PlaybackException.CUSTOM_ERROR_CODE_BASE) : 0;
    }

    private a() {
    }

    public static final boolean a(String str, String str2) {
        Intrinsics.h(str, "codename");
        Intrinsics.h(str2, "buildCodename");
        if (Intrinsics.c("REL", str2)) {
            return false;
        }
        Integer b5 = b(str2);
        Integer b6 = b(str);
        if (b5 != null && b6 != null) {
            return b5.intValue() >= b6.intValue();
        }
        if (b5 != null || b6 != null) {
            return b5 != null;
        }
        Locale locale = Locale.ROOT;
        String upperCase = str2.toUpperCase(locale);
        Intrinsics.g(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = str.toUpperCase(locale);
        Intrinsics.g(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase.compareTo(upperCase2) >= 0;
    }

    private static final Integer b(String str) {
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.g(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return Intrinsics.c(upperCase, "BAKLAVA") ? 0 : null;
    }

    public static final boolean c() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 34) {
            if (i5 >= 33) {
                String str = Build.VERSION.CODENAME;
                Intrinsics.g(str, "CODENAME");
                if (a("UpsideDownCake", str)) {
                }
            }
            return false;
        }
        return true;
    }

    public static final boolean d() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 35) {
            if (i5 >= 34) {
                String str = Build.VERSION.CODENAME;
                Intrinsics.g(str, "CODENAME");
                if (a("VanillaIceCream", str)) {
                }
            }
            return false;
        }
        return true;
    }
}
