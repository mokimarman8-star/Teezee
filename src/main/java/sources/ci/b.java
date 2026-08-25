package ci;

import android.view.View;
import android.widget.TextView;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(TextView textView) {
        String valueOf;
        try {
            Result.Companion companion = Result.Companion;
            String lowerCase = textView.getText().toString().toLowerCase(Locale.ROOT);
            Intrinsics.g(lowerCase, "toLowerCase(...)");
            if (a.b(lowerCase)) {
                if (lowerCase.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    char charAt = lowerCase.charAt(0);
                    if (Character.isLowerCase(charAt)) {
                        Locale locale = Locale.getDefault();
                        Intrinsics.g(locale, "getDefault(...)");
                        valueOf = CharsKt.d(charAt, locale);
                    } else {
                        valueOf = String.valueOf(charAt);
                    }
                    sb.append((Object) valueOf);
                    String substring = lowerCase.substring(1);
                    Intrinsics.g(substring, "substring(...)");
                    sb.append(substring);
                    lowerCase = sb.toString();
                }
                textView.setText(lowerCase);
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    public final boolean b(String str) {
        Intrinsics.h(str, "string");
        return new Regex("[a-zA-Z]+").matches(str);
    }

    public final boolean c() {
        return com.transsion.ad.strategy.e.a.c().getBoolean("key_downloading_play_bubble_guide", true);
    }

    public final void d() {
        com.transsion.ad.strategy.e.a.c().putBoolean("key_downloading_play_bubble_guide", false);
    }

    public final void e(View view, int i) {
        Intrinsics.h(view, "layout");
        View findViewById = view.findViewById(i);
        if (findViewById != null && (findViewById instanceof TextView)) {
            final TextView textView = (TextView) findViewById;
            textView.post(new Runnable() { // from class: ci.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.f(textView);
                }
            });
        }
    }
}
