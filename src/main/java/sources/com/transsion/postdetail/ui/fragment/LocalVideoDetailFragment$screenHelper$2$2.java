package com.transsion.postdetail.ui.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
/* synthetic */ class LocalVideoDetailFragment$screenHelper$2$2 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
    LocalVideoDetailFragment$screenHelper$2$2(Object obj) {
        super(1, obj, LocalVideoDetailFragment.class, "autoScreenRotation", "autoScreenRotation(Z)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z) {
        ((LocalVideoDetailFragment) ((CallableReference) this).receiver).V1(z);
    }
}
