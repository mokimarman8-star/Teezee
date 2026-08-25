package com.transsion.baselib.helper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
/* synthetic */ class ScreenRotationHelper$orientationListener$2$1 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    ScreenRotationHelper$orientationListener$2$1(Object obj) {
        super(1, obj, ScreenRotationHelper.class, "autoScreenRotation", "autoScreenRotation(Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z) {
        ((ScreenRotationHelper) ((CallableReference) this).receiver).e(z);
    }
}
