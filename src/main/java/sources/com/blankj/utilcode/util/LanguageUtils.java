package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.app.h;
import com.blankj.utilcode.util.Utils;
import java.util.Locale;
import n0.d;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class LanguageUtils {
    static void a(Activity activity) {
        String c = e0.r().c("KEY_LOCALE");
        if (TextUtils.isEmpty(c)) {
            return;
        }
        Locale b = "VALUE_FOLLOW_SYSTEM".equals(c) ? b(Resources.getSystem().getConfiguration()) : g(c);
        if (b == null) {
            return;
        }
        i(activity, b);
        i(Utils.a(), b);
    }

    private static Locale b(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? d.a(h.a(configuration), 0) : configuration.locale;
    }

    private static boolean c(String str) {
        int i = 0;
        for (char c : str.toCharArray()) {
            if (c == '$') {
                if (i >= 1) {
                    return false;
                }
                i++;
            }
        }
        return i == 1;
    }

    private static boolean d(Locale locale, Locale locale2) {
        return e0.e(locale2.getLanguage(), locale.getLanguage()) && e0.e(locale2.getCountry(), locale.getCountry());
    }

    static void e(Locale locale, int i, Utils.b bVar) {
        Resources resources = Utils.a().getResources();
        Configuration configuration = resources.getConfiguration();
        Locale b = b(configuration);
        f(configuration, locale);
        Utils.a().getResources().updateConfiguration(configuration, resources.getDisplayMetrics());
        if (bVar == null) {
            return;
        }
        if (d(b, locale)) {
            bVar.accept(Boolean.TRUE);
        } else if (i < 20) {
            e0.K(new 2(locale, i, bVar), 16L);
        } else {
            Log.e("LanguageUtils", "appLocal didn't update.");
            bVar.accept(Boolean.FALSE);
        }
    }

    private static void f(Configuration configuration, Locale locale) {
        configuration.setLocale(locale);
    }

    private static Locale g(String str) {
        Locale h = h(str);
        if (h == null) {
            Log.e("LanguageUtils", "The string of " + str + " is not in the correct format.");
            e0.r().h("KEY_LOCALE");
        }
        return h;
    }

    private static Locale h(String str) {
        if (!c(str)) {
            return null;
        }
        try {
            int indexOf = str.indexOf("$");
            return new Locale(str.substring(0, indexOf), str.substring(indexOf + 1));
        } catch (Exception unused) {
            return null;
        }
    }

    private static void i(Context context, Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        f(configuration, locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
