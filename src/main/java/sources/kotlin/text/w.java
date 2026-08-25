package kotlin.text;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class w extends v {
    public static String t1(String str, int i) {
        Intrinsics.h(str, "<this>");
        if (i >= 0) {
            String substring = str.substring(RangesKt.h(i, str.length()));
            Intrinsics.g(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }

    public static char u1(CharSequence charSequence) {
        Intrinsics.h(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static Character v1(CharSequence charSequence, int i) {
        Intrinsics.h(charSequence, "<this>");
        if (i < 0 || i >= charSequence.length()) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i));
    }

    public static char w1(CharSequence charSequence) {
        Intrinsics.h(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(StringsKt.i0(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char x1(CharSequence charSequence) {
        Intrinsics.h(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    public static String y1(String str, int i) {
        Intrinsics.h(str, "<this>");
        if (i >= 0) {
            String substring = str.substring(0, RangesKt.h(i, str.length()));
            Intrinsics.g(substring, "substring(...)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }
}
