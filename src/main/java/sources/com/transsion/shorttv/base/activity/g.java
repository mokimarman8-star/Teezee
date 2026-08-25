package com.transsion.shorttv.base.activity;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import com.transsion.gslb.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class g {
    public static final void a(String str, Activity activity) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(activity, "activity");
        wf.a.a.p(str, new String[]{activity.getLocalClassName() + " onDestroy"}, true);
    }

    public static /* synthetic */ void b(String str, Activity activity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "CommonInfo";
        }
        a(str, activity);
    }

    public static final void c(String str, Fragment fragment, boolean z, String str2) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(str2, "other");
        wf.a.a.p(str, new String[]{fragment.getClass().getSimpleName() + " hidden=" + z + " " + str2}, true);
    }

    public static /* synthetic */ void d(String str, Fragment fragment, boolean z, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "CommonInfo";
        }
        if ((i & 8) != 0) {
            str2 = BuildConfig.FLAVOR;
        }
        c(str, fragment, z, str2);
    }

    public static final void e(String str, Activity activity) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(activity, "activity");
        wf.a.a.p(str, new String[]{activity.getLocalClassName() + " onPause"}, true);
    }

    public static final void f(String str, Fragment fragment, String str2) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(str2, "other");
        wf.a.a.p(str, new String[]{fragment.getClass().getSimpleName() + " onPause " + str2}, true);
    }

    public static /* synthetic */ void g(String str, Activity activity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "CommonInfo";
        }
        e(str, activity);
    }

    public static /* synthetic */ void h(String str, Fragment fragment, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "CommonInfo";
        }
        if ((i & 4) != 0) {
            str2 = BuildConfig.FLAVOR;
        }
        f(str, fragment, str2);
    }

    public static final void i(String str, Activity activity) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(activity, "activity");
        wf.a.a.p(str, new String[]{activity.getLocalClassName() + " onResume"}, true);
    }

    public static final void j(String str, Fragment fragment, String str2) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(str2, "other");
        wf.a.a.p(str, new String[]{fragment.getClass().getSimpleName() + " onResume " + str2}, true);
    }

    public static /* synthetic */ void k(String str, Activity activity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "CommonInfo";
        }
        i(str, activity);
    }

    public static /* synthetic */ void l(String str, Fragment fragment, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "CommonInfo";
        }
        if ((i & 4) != 0) {
            str2 = BuildConfig.FLAVOR;
        }
        j(str, fragment, str2);
    }
}
