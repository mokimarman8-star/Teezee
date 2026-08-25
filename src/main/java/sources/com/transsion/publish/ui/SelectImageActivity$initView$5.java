package com.transsion.publish.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
/* synthetic */ class SelectImageActivity$initView$5 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    SelectImageActivity$initView$5(Object obj) {
        super(1, obj, SelectImageActivity.class, "checkSelectNum", "checkSelectNum(I)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        ((SelectImageActivity) ((CallableReference) this).receiver).w0(i);
    }
}
