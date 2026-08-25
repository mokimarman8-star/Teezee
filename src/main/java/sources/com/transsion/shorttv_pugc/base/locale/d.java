package com.transsion.shorttv_pugc.base.locale;

import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import androidx.appcompat.app.h;
import androidx.appcompat.app.j;
import androidx.appcompat.app.l;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.shorttv_pugc.base.locale.d;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class d {
    public static final b f = new b(null);
    private static final String[] g = {null, "English", "Bahasa Indonesia", "Français", "Português", "العربية", "বাংলা", "Русский", "ਪੰਜਾਬੀ", "اردو", "Filipino"};
    private static final String[] h = {null, Locale.ENGLISH.getLanguage(), "in", "fr", "pt", "ar", "bn", "ru", "pa", "ur", "fil"};
    private static final Lazy i = LazyKt.b(new Function0() { // from class: com.transsion.shorttv_pugc.base.locale.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            d i2;
            i2 = d.i();
            return i2;
        }
    });
    private Locale a;
    private Locale b;
    private String c;
    private final Context d;
    private final e e;

    public static final class a implements ComponentCallbacks2 {
        final /* synthetic */ Context b;

        a(Context context) {
            this.b = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(d dVar, Locale locale, Locale locale2, Context context) {
            if (dVar.h() == locale) {
                String country = locale2.getCountry();
                Intrinsics.g(country, "getCountry(...)");
                dVar.k(null, country, true);
            } else {
                Intrinsics.e(context);
                dVar.m(context, dVar.h());
            }
            a.a.f(wf.a.a, "LocaleManager", "onConfigurationChanged()-> locale = " + locale2, false, 4, (Object) null);
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration newConfig) {
            Intrinsics.h(newConfig, "newConfig");
            final Locale a = Build.VERSION.SDK_INT >= 24 ? n0.d.a(h.a(newConfig), 0) : newConfig.locale;
            final Locale locale = d.this.b;
            if (Intrinsics.c(a, locale)) {
                return;
            }
            d dVar = d.this;
            Intrinsics.e(a);
            dVar.b = a;
            final d dVar2 = d.this;
            final Context context = this.b;
            ThreadUtils.j(new Runnable() { // from class: com.transsion.shorttv_pugc.base.locale.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.a.b(d.this, locale, a, context);
                }
            });
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Locale f(String str, String str2) {
            if (str == null || str.length() == 0) {
                return null;
            }
            return new Locale(str, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String g() {
            return com.transsion.shorttv_pugc.utils.h.a.g().getString("k_language_short_name", (String) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h(String str) {
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
                    com.transsion.shorttv_pugc.utils.h.a.g().putString("k_language_short_name", str);
                    return;
                }
            }
            com.transsion.shorttv_pugc.utils.h.a.g().remove("k_language_short_name");
        }

        public final Locale d(Context context) {
            Intrinsics.h(context, "context");
            a.a.f(wf.a.a, "LocaleManager", "getContextLocale()-> context = " + context, false, 4, (Object) null);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 24) {
                Locale a = n0.d.a(h.a(configuration), 0);
                Intrinsics.e(a);
                return a;
            }
            Locale locale = configuration.locale;
            Intrinsics.e(locale);
            return locale;
        }

        public final d e() {
            return (d) d.i.getValue();
        }

        public final Context i(Context context, Locale locale) {
            Intrinsics.h(context, "context");
            Configuration configuration = new Configuration(context.getResources().getConfiguration());
            if (Build.VERSION.SDK_INT >= 24) {
                com.transsion.baselib.locale.e.a();
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

    private d(Context context) {
        e eVar = new e();
        this.e = eVar;
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
        application.registerActivityLifecycleCallbacks(eVar);
        application.registerComponentCallbacks(new a(baseContext));
        String g2 = bVar.g();
        Intrinsics.e(country);
        k(g2, country, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d i() {
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return new d(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(String str, String str2, boolean z) {
        jg.b.a.l(str);
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
            final Locale f2 = bVar.f(str, str2);
            if (f2 == null) {
                f2 = this.b;
            }
            a.a.f(wf.a.a, "LocaleManager", "setLocale()-> locale = " + f2 + " , language = " + ((Object) str), false, 4, (Object) null);
            synchronized (this) {
                this.c = str;
                this.a = f2;
                Locale.setDefault(f2);
                Unit unit = Unit.a;
            }
            m(context, f2);
            bVar.h(str);
            ThreadUtils.j(new Runnable() { // from class: com.transsion.shorttv_pugc.base.locale.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.l(d.this, f2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(d dVar, Locale locale) {
        a.a.f(wf.a.a, "LocaleManager", "notify changed()-> ", false, 4, (Object) null);
        dVar.e.e(locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(Context context, Locale locale) {
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

    public final synchronized Locale h() {
        return this.a;
    }

    public final void j(String str) {
        if (Build.VERSION.SDK_INT == 23 && Intrinsics.c("ur", str)) {
            k(str, "PK", false);
            return;
        }
        String country = this.b.getCountry();
        Intrinsics.g(country, "getCountry(...)");
        k(str, country, false);
    }
}
