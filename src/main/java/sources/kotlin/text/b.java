package kotlin.text;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class b {
    public static int a(int i) {
        if (2 <= i && i < 37) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new IntRange(2, 36));
    }

    public static final int b(char c, int i) {
        return Character.digit((int) c, i);
    }

    public static boolean c(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    public static String d(char c, Locale locale) {
        Intrinsics.h(locale, "locale");
        String e = e(c, locale);
        if (e.length() <= 1) {
            String valueOf = String.valueOf(c);
            Intrinsics.f(valueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = valueOf.toUpperCase(Locale.ROOT);
            Intrinsics.g(upperCase, "toUpperCase(...)");
            return !Intrinsics.c(e, upperCase) ? e : String.valueOf(Character.toTitleCase(c));
        }
        if (c == 329) {
            return e;
        }
        char charAt = e.charAt(0);
        Intrinsics.f(e, "null cannot be cast to non-null type java.lang.String");
        String substring = e.substring(1);
        Intrinsics.g(substring, "substring(...)");
        Intrinsics.f(substring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = substring.toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "toLowerCase(...)");
        return charAt + lowerCase;
    }

    public static final String e(char c, Locale locale) {
        Intrinsics.h(locale, "locale");
        String valueOf = String.valueOf(c);
        Intrinsics.f(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(locale);
        Intrinsics.g(upperCase, "toUpperCase(...)");
        return upperCase;
    }
}
