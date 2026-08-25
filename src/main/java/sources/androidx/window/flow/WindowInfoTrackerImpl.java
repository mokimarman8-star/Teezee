package androidx.window.flow;

import android.app.Activity;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.a;
import kotlinx.coroutines.flow.c;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class WindowInfoTrackerImpl implements x {
    public static final a d = new a((DefaultConstructorMarker) null);
    private final c0 b;
    private final v c;

    public WindowInfoTrackerImpl(c0 c0Var, v vVar) {
        Intrinsics.h(c0Var, "windowMetricsCalculator");
        Intrinsics.h(vVar, "windowBackend");
        this.b = c0Var;
        this.c = vVar;
    }

    public a a(Activity activity) {
        Intrinsics.h(activity, "activity");
        return c.r(new b(this, activity, null));
    }
}
