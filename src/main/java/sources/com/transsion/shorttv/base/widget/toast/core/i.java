package com.transsion.shorttv.base.widget.toast.core;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.j0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i implements Application.ActivityLifecycleCallbacks {
    private Activity a;
    private ToastImpl b;

    public i(Activity activity) {
        this.a = activity;
    }

    public final Activity a() {
        return this.a;
    }

    public final void b(ToastImpl toastImpl) {
        this.b = toastImpl;
        Activity activity = this.a;
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Intrinsics.e(activity);
            j0.a(activity, this);
        } else {
            Intrinsics.e(activity);
            activity.getApplication().registerActivityLifecycleCallbacks(this);
        }
    }

    public final void c() {
        this.b = null;
        Activity activity = this.a;
        if (activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            Intrinsics.e(activity);
            com.cloud.tmc.miniapp.dialog.b.a(activity, this);
        } else {
            Intrinsics.e(activity);
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.h(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.h(activity, "activity");
        if (this.a != activity) {
            return;
        }
        ToastImpl toastImpl = this.b;
        if (toastImpl != null) {
            Intrinsics.e(toastImpl);
            toastImpl.e();
        }
        c();
        this.a = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        ToastImpl toastImpl;
        Intrinsics.h(activity, "activity");
        if (this.a == activity && (toastImpl = this.b) != null) {
            Intrinsics.e(toastImpl);
            toastImpl.e();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.h(activity, "activity");
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
