package kj;

import androidx.lifecycle.g0;
import androidx.lifecycle.u;
import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k implements androidx.lifecycle.f {
    public static final k a = new k();
    private static boolean b;

    private k() {
    }

    public final void a() {
        g0.i.a().getLifecycle().a(this);
    }

    public final boolean b() {
        return b;
    }

    public final void c(boolean z) {
        b = z;
    }

    public /* synthetic */ void onCreate(u uVar) {
        androidx.lifecycle.e.a(this, uVar);
    }

    public /* synthetic */ void onDestroy(u uVar) {
        androidx.lifecycle.e.b(this, uVar);
    }

    public /* synthetic */ void onPause(u uVar) {
        androidx.lifecycle.e.c(this, uVar);
    }

    public /* synthetic */ void onResume(u uVar) {
        androidx.lifecycle.e.d(this, uVar);
    }

    public /* synthetic */ void onStart(u uVar) {
        androidx.lifecycle.e.e(this, uVar);
    }

    public void onStop(u uVar) {
        Intrinsics.h(uVar, "owner");
        a.a.f(wf.a.a, "DialogSessionManager", "onStop 重置标记为false", false, 4, (Object) null);
        b = false;
    }
}
