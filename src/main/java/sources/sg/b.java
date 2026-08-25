package sg;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class b implements Application.ActivityLifecycleCallbacks {
    public static final a b = new a((DefaultConstructorMarker) null);
    private static final Lazy c = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: sg.a
        public final Object invoke() {
            b d;
            d = b.d();
            return d;
        }
    });
    private Stack a = new Stack();

    /* JADX INFO: Access modifiers changed from: private */
    public static final b d() {
        return new b();
    }

    public final String c() {
        Stack stack = this.a;
        return (stack == null || stack.size() <= 1) ? "" : stack.get(stack.size() - 2).getClass().getSimpleName();
    }

    public final void e(Application application) {
        Intrinsics.h(application, "app");
        application.registerActivityLifecycleCallbacks(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.h(activity, "activity");
        Stack stack = this.a;
        if (stack != null) {
            stack.add(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.h(activity, "activity");
        Stack stack = this.a;
        if (stack != null) {
            stack.remove(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.h(activity, "activity");
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
