package com.transsion.baselib.locale;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.appcompat.app.h;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import java.util.Locale;
import jg.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class d {
    public static final b f = new b((DefaultConstructorMarker) null);
    private static final String[] g = {null, "English", "Bahasa Indonesia", "Français", "Português", "العربية", "বাংলা", "Русский", "ਪੰਜਾਬੀ", "اردو", "Filipino", "Bahasa Melayu", "Español"};
    private static final String[] h = {null, Locale.ENGLISH.getLanguage(), "in", "fr", "pt", "ar", "bn", "ru", "pa", "ur", "fil", "ms", "es"};
    private static final Lazy i = LazyKt.b(new Function0() { // from class: com.transsion.baselib.locale.a
        public final Object invoke() {
            d m;
            m = d.m();
            return m;
        }
    });
    private Locale a;
    private Locale b;
    private String c;
    private final Context d;
    private final f e;

    private d(Context context) {
        Application.ActivityLifecycleCallbacks fVar = new f();
        this.e = fVar;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.f(applicationContext, "null cannot be cast to non-null type android.app.Application");
        Application application = (Application) applicationContext;
        Context baseContext = application.getBaseContext();
        Intrinsics.e(baseContext);
        this.d = baseContext;
        b bVar = f;
        Locale d = bVar.d(baseContext);
        this.b = d;
        String country = d.getCountry();
        a.a.f(wf.a.a, "LocaleManager", "LocaleManager()->  system locale =" + this.b + ", countryCode = " + country, false, 4, (Object) null);
        application.registerActivityLifecycleCallbacks(fVar);
        application.registerComponentCallbacks(new a(this, baseContext));
        String b = b.b(bVar);
        Intrinsics.e(country);
        o(b, country, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d m() {
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return new d(a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String str, String str2, boolean z) {
        b.a.l(str);
        Context context = this.d;
        if (str != null) {
            int length = str.length() - 1;
            int i2 = 0;
            boolean z2 = false;
            while (i2 <= length) {
                boolean z3 = Intrinsics.j(str.charAt(!z2 ? i2 : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z3) {
                    i2++;
                } else {
                    z2 = true;
                }
            }
            if (str.subSequence(i2, length + 1).toString().length() == 0) {
                str = null;
            }
        }
        if (z || !TextUtils.equals(str, this.c)) {
            b bVar = f;
            Locale a = b.a(bVar, str, str2);
            if (a == null) {
                a = this.b;
            }
            a.a.f(wf.a.a, "LocaleManager", "setLocale()-> locale = " + a + " , language = " + ((Object) str), false, 4, (Object) null);
            synchronized (this) {
                this.c = str;
                this.a = a;
                Locale.setDefault(a);
                Unit unit = Unit.a;
            }
            r(context, a);
            b.c(bVar, str);
            ThreadUtils.j(new b(this, a));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(d dVar, Locale locale) {
        a.a.f(wf.a.a, "LocaleManager", "notify changed()-> ", false, 4, (Object) null);
        dVar.e.e(locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(Context context, Locale locale) {
        Locale locale2;
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= 24) {
            locale2 = n0.d.a(h.a(configuration), 0);
            Intrinsics.e(locale2);
        } else {
            locale2 = configuration.locale;
            Intrinsics.e(locale2);
        }
        a.a.f(wf.a.a, "LocaleManager", "updateConfig()-> old app locale = " + locale2 + " , new app locale = " + locale, false, 4, (Object) null);
        Configuration configuration2 = new Configuration(configuration);
        configuration2.setLocale(locale);
        resources.updateConfiguration(configuration2, resources.getDisplayMetrics());
    }

    public final synchronized Locale j() {
        return this.a;
    }

    public final Locale k() {
        return this.a;
    }

    public final Locale l() {
        return this.b;
    }

    public final void n(String str) {
        if (Build.VERSION.SDK_INT == 23 && Intrinsics.c("ur", str)) {
            o(str, "PK", false);
            return;
        }
        String country = this.b.getCountry();
        Intrinsics.g(country, "getCountry(...)");
        o(str, country, false);
    }

    public final boolean q(Locale locale) {
        Intrinsics.h(locale, "locale");
        return this.b == locale;
    }
}
