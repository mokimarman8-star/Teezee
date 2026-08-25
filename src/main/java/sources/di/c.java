package di;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import y0.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    public final SpannableString a(String str, String str2, int i) {
        Intrinsics.h(str, "fullText");
        Intrinsics.h(str2, "colorText");
        SpannableString spannableString = new SpannableString(str);
        int o0 = StringsKt.o0(str, str2, 0, false, 6, (Object) null);
        if (o0 == -1) {
            return spannableString;
        }
        spannableString.setSpan(new ForegroundColorSpan(i), o0, str2.length() + o0, 33);
        return spannableString;
    }

    public final SpannableString b(String str, String str2, int i, int i2) {
        Intrinsics.h(str, "fullText");
        Intrinsics.h(str2, "gradientText");
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, str.length(), 33);
        int o0 = StringsKt.o0(str, str2, 0, false, 6, (Object) null);
        if (o0 == -1) {
            return spannableString;
        }
        spannableString.setSpan(new b(i, i2, str2), o0, str2.length() + o0, 33);
        return spannableString;
    }

    public final SpannableString c(Context context, String str, int i, Integer num, String str2, int i2, Integer num2) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "firstText");
        Intrinsics.h(str2, "secondText");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Typeface g = h.g(context, i);
        if (g == null) {
            g = Typeface.DEFAULT;
        }
        spannableStringBuilder.append((CharSequence) str);
        Intrinsics.e(g);
        spannableStringBuilder.setSpan(new a(g), 0, str.length(), 33);
        if (num != null) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, str.length(), 33);
        }
        Typeface g2 = h.g(context, i2);
        if (g2 == null) {
            g2 = Typeface.DEFAULT;
        }
        int length = str.length();
        spannableStringBuilder.append((CharSequence) str2);
        Intrinsics.e(g2);
        spannableStringBuilder.setSpan(new a(g2), length, str2.length() + length, 33);
        if (num2 != null) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num2.intValue()), length, str2.length() + length, 33);
        }
        SpannableString valueOf = SpannableString.valueOf(spannableStringBuilder);
        Intrinsics.g(valueOf, "valueOf(...)");
        return valueOf;
    }
}
