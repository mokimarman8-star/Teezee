package com.transsion.baselib.helper;

import android.content.Context;
import android.os.Handler;
import android.provider.Settings;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ScreenRotationHelper {
    private final Context a;
    private final Function0 b;
    private final Function1 c;
    private boolean d;
    private final Lazy e;
    private final Lazy f;

    public ScreenRotationHelper(Context context, Function0 function0, Function1 function1) {
        Intrinsics.h(context, "context");
        Intrinsics.h(function0, "isCloseAutoRotationCallback");
        Intrinsics.h(function1, "rotationCallback");
        this.a = context;
        this.b = function0;
        this.c = function1;
        this.e = LazyKt.b(new Function0() { // from class: com.transsion.baselib.helper.g
            public final Object invoke() {
                f k;
                k = ScreenRotationHelper.k(ScreenRotationHelper.this);
                return k;
            }
        });
        this.f = LazyKt.b(new Function0() { // from class: com.transsion.baselib.helper.h
            public final Object invoke() {
                j i;
                i = ScreenRotationHelper.i(ScreenRotationHelper.this);
                return i;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(boolean z) {
        if (!((Boolean) this.b.invoke()).booleanValue() && this.d && com.blankj.utilcode.util.c.j()) {
            this.c.invoke(Boolean.valueOf(z));
        }
    }

    private final j f() {
        return (j) this.f.getValue();
    }

    private final f g() {
        return (f) this.e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final j i(final ScreenRotationHelper screenRotationHelper) {
        return new j(new Handler(), new WeakReference(screenRotationHelper.a), new Function1() { // from class: com.transsion.baselib.helper.i
            public final Object invoke(Object obj) {
                Unit j;
                j = ScreenRotationHelper.j(ScreenRotationHelper.this, ((Boolean) obj).booleanValue());
                return j;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(ScreenRotationHelper screenRotationHelper, boolean z) {
        screenRotationHelper.d = z;
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final f k(ScreenRotationHelper screenRotationHelper) {
        return new f(screenRotationHelper.a, new ScreenRotationHelper$orientationListener$2$1(screenRotationHelper));
    }

    public final void h() {
        this.a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, f());
        this.d = f().a(this.a);
        f g = g();
        if (g.canDetectOrientation()) {
            g.enable();
        }
    }

    public final void l() {
        try {
            Result.Companion companion = Result.Companion;
            this.a.getContentResolver().unregisterContentObserver(f());
            g().disable();
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }
}
