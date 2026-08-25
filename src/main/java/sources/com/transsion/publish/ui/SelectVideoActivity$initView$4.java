package com.transsion.publish.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
/* synthetic */ class SelectVideoActivity$initView$4 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    SelectVideoActivity$initView$4(Object obj) {
        super(1, obj, SelectVideoActivity.class, "checkSelect", "checkSelect(I)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        ((SelectVideoActivity) ((CallableReference) this).receiver).p0(i);
    }
}
