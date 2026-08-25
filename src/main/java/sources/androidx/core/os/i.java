package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i {

    /* renamed from: b, reason: collision with root package name */
    private static final i f7021b = a(new Locale[0]);

    /* renamed from: a, reason: collision with root package name */
    private final k f7022a;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final Locale[] f7023a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    static class b {
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }
    }

    private i(k kVar) {
        this.f7022a = kVar;
    }

    public static i a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? j(b.a(localeArr)) : new i(new j(localeArr));
    }

    static Locale b(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else {
            if (!str.contains("_")) {
                return new Locale(str);
            }
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static i c(String str) {
        if (str == null || str.isEmpty()) {
            return e();
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i5 = 0; i5 < length; i5++) {
            localeArr[i5] = a.a(split[i5]);
        }
        return a(localeArr);
    }

    public static i e() {
        return f7021b;
    }

    public static i j(LocaleList localeList) {
        return new i(new p(localeList));
    }

    public Locale d(int i5) {
        return this.f7022a.get(i5);
    }

    public boolean equals(Object obj) {
        return (obj instanceof i) && this.f7022a.equals(((i) obj).f7022a);
    }

    public boolean f() {
        return this.f7022a.isEmpty();
    }

    public int g() {
        return this.f7022a.size();
    }

    public String h() {
        return this.f7022a.a();
    }

    public int hashCode() {
        return this.f7022a.hashCode();
    }

    public Object i() {
        return this.f7022a.b();
    }

    public String toString() {
        return this.f7022a.toString();
    }
}
