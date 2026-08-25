package com.transsion.shorttv.base.locale;

import android.R;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e implements Application.ActivityLifecycleCallbacks {
    public static final a d = new a(null);
    private final SparseArray a = new SparseArray(4);
    private int b;
    private Integer c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final class b {
        private final Activity a;
        private Locale b;
        private Locale c;

        public b(Activity activity) {
            Intrinsics.h(activity, "activity");
            this.a = activity;
        }

        public final Activity a() {
            return this.a;
        }

        public final Locale b() {
            return this.c;
        }

        public final Locale c() {
            return this.b;
        }

        public final void d(Locale locale) {
            this.c = locale;
        }

        public final void e(Locale locale) {
            this.b = locale;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void a(View view) {
        if (view instanceof fr.a) {
            ((fr.a) view).changeLocal();
        } else if (view instanceof ViewGroup) {
            Iterator it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
            while (it.hasNext()) {
                a((View) it.next());
            }
        }
    }

    private final void b(Activity activity) {
        a.a.f(wf.a.a, "LocaleManagerCB", "notifyActivityChangedLocale()-> activity = " + activity + " , waitChangedCount = " + this.b, false, 4, (Object) null);
        if (this.b <= 0) {
            return;
        }
        b bVar = (b) this.a.get(System.identityHashCode(activity));
        if ((bVar != null ? bVar.c() : null) == null) {
            return;
        }
        this.b--;
        boolean z = TextUtils.getLayoutDirectionFromLocale(bVar.b()) == TextUtils.getLayoutDirectionFromLocale(bVar.c());
        bVar.d(bVar.c());
        bVar.e(null);
        if (z) {
            return;
        }
        d(activity);
    }

    private final void c() {
        Integer num = this.c;
        if (num == null) {
            return;
        }
        SparseArray sparseArray = this.a;
        Intrinsics.e(num);
        b bVar = (b) sparseArray.get(num.intValue());
        if (bVar == null) {
            return;
        }
        b(bVar.a());
    }

    private final void d(Activity activity) {
        activity.finish();
        Intent intent = activity.getIntent();
        intent.putExtra("extra_language_activity_restart", true);
        activity.startActivity(intent);
    }

    public final void e(Locale locale) {
        int i;
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new UnsupportedOperationException();
        }
        int size = this.a.size();
        boolean z = false;
        if (size <= 0) {
            this.b = 0;
            return;
        }
        int i2 = this.b;
        int i3 = 0;
        while (i3 < size) {
            b bVar = (b) this.a.valueAt(i3);
            a.a aVar = wf.a.a;
            a.a.f(aVar, "LocaleManagerCB", "setLocaleChanged()-> localeState = " + bVar, false, 4, (Object) null);
            if (bVar != null) {
                Activity a2 = bVar.a();
                boolean z2 = (a2.isFinishing() || a2.isDestroyed()) ? true : z;
                boolean z3 = z2;
                a.a.f(aVar, "LocaleManagerCB", "setLocaleChanged()-> activityFinished = " + z2, false, 4, (Object) null);
                if (!z3) {
                    Locale b2 = bVar.b();
                    Intrinsics.e(b2);
                    String language = b2.getLanguage();
                    Intrinsics.e(locale);
                    String language2 = locale.getLanguage();
                    Locale c = bVar.c();
                    boolean z4 = TextUtils.getLayoutDirectionFromLocale(b2) != TextUtils.getLayoutDirectionFromLocale(locale) ? z : true;
                    i = size;
                    a.a.f(aVar, "LocaleManagerCB", "setLocaleChanged()-> locale = " + locale + " , activityLocale = " + b2 + " , expectLocale = " + c + " , isSameDirection = " + z4, false, 4, (Object) null);
                    if (Intrinsics.c(language, language2)) {
                        bVar.e(null);
                        if (c != null) {
                            i2--;
                            a.a.f(aVar, "LocaleManagerCB", "setLocaleChanged()-> waitChangedCount--", false, 4, (Object) null);
                        }
                    } else {
                        bVar.e(locale);
                        if (c == null) {
                            i2++;
                            a.a.f(aVar, "LocaleManagerCB", "setLocaleChanged()-> waitChangedCount++", false, 4, (Object) null);
                        }
                        if (z4) {
                            Configuration configuration = a2.getResources().getConfiguration();
                            Intrinsics.g(configuration, "getConfiguration(...)");
                            Resources resources = a2.getResources();
                            Intrinsics.g(resources, "getResources(...)");
                            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                            Intrinsics.g(displayMetrics, "getDisplayMetrics(...)");
                            bVar.d(locale);
                            bVar.e(null);
                            configuration.setLocale(locale);
                            resources.updateConfiguration(configuration, displayMetrics);
                            View findViewById = a2.getWindow().getDecorView().findViewById(R.id.content);
                            if (findViewById != null) {
                                a(findViewById);
                            }
                        }
                    }
                    i3++;
                    size = i;
                    z = false;
                }
            }
            i = size;
            i3++;
            size = i;
            z = false;
        }
        this.b = i2;
        c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.h(activity, "activity");
        int identityHashCode = System.identityHashCode(activity);
        b bVar = new b(activity);
        bVar.d(d.f.d(activity));
        a.a.f(wf.a.a, "LocaleManagerCB", "onActivityCreated()-> " + activity + " , curLocale = " + bVar.b(), false, 4, (Object) null);
        this.a.put(identityHashCode, bVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.h(activity, "activity");
        int identityHashCode = System.identityHashCode(activity);
        b bVar = (b) this.a.get(identityHashCode);
        if ((bVar != null ? bVar.c() : null) != null) {
            bVar.e(null);
            this.b--;
        }
        this.a.remove(identityHashCode);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.h(activity, "activity");
        int identityHashCode = System.identityHashCode(activity);
        Integer num = this.c;
        if (num == null || num == null || identityHashCode != num.intValue()) {
            return;
        }
        this.c = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.h(activity, "activity");
        a.a.f(wf.a.a, "LocaleManagerCB", "onActivityResumed()-> " + activity, false, 4, (Object) null);
        this.c = Integer.valueOf(System.identityHashCode(activity));
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(bundle, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.h(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.h(activity, "activity");
    }
}
