package com.google.firebase.sessions;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a0 implements Application.ActivityLifecycleCallbacks {
    public static final a0 a = new a0();
    private static boolean b;
    private static SessionLifecycleClient c;

    private a0() {
    }

    public final void a(SessionLifecycleClient sessionLifecycleClient) {
        c = sessionLifecycleClient;
        if (sessionLifecycleClient == null || !b) {
            return;
        }
        b = false;
        sessionLifecycleClient.k();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.h(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.h(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.h(activity, "activity");
        SessionLifecycleClient sessionLifecycleClient = c;
        if (sessionLifecycleClient != null) {
            sessionLifecycleClient.h();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Unit unit;
        Intrinsics.h(activity, "activity");
        SessionLifecycleClient sessionLifecycleClient = c;
        if (sessionLifecycleClient != null) {
            sessionLifecycleClient.k();
            unit = Unit.a;
        } else {
            unit = null;
        }
        if (unit == null) {
            b = true;
        }
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
