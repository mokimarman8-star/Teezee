package com.transsion.baselib.locale;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.appcompat.app.h;
import androidx.appcompat.app.j;
import androidx.appcompat.app.l;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n0.d;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d$b {
    private d$b() {
    }

    public /* synthetic */ d$b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Locale h(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return new Locale(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i() {
        return com.transsion.baselib.report.launch.b.a.b().getString("k_language_short_name", (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String str) {
        if (str != null) {
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.j(str.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            if (str.subSequence(i, length + 1).toString().length() != 0) {
                com.transsion.baselib.report.launch.b.a.b().putString("k_language_short_name", str);
                return;
            }
        }
        com.transsion.baselib.report.launch.b.a.b().remove("k_language_short_name");
    }

    public final Locale d(Context context) {
        Intrinsics.h(context, "context");
        a.a.f(a.a, "LocaleManager", "getContextLocale()-> context = " + context, false, 4, (Object) null);
        Configuration configuration = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            Locale a = d.a(h.a(configuration), 0);
            Intrinsics.e(a);
            return a;
        }
        Locale locale = configuration.locale;
        Intrinsics.e(locale);
        return locale;
    }

    public final d e() {
        return (d) d.c().getValue();
    }

    public final String[] f() {
        return d.d();
    }

    public final String[] g() {
        return d.e();
    }

    public final Context k(Context context, Locale locale) {
        Intrinsics.h(context, "context");
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        if (Build.VERSION.SDK_INT >= 24) {
            e.a();
            LocaleList a = androidx.compose.ui.text.platform.extensions.a.a(new Locale[]{locale});
            j.a(configuration, a);
            l.a(a);
        } else {
            configuration.setLocale(locale);
        }
        Context createConfigurationContext = context.createConfigurationContext(configuration);
        Intrinsics.g(createConfigurationContext, "createConfigurationContext(...)");
        return createConfigurationContext;
    }
}
