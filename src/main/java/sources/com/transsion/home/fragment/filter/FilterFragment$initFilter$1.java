package com.transsion.home.fragment.filter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
/* synthetic */ class FilterFragment$initFilter$1 extends FunctionReferenceImpl implements Function1<bl.a, Unit> {
    FilterFragment$initFilter$1(Object obj) {
        super(1, obj, FilterFragment.class, "reportClick", "reportClick(Lcom/transsion/home/view/filter/item/FilterItem;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((bl.a) obj);
        return Unit.a;
    }

    public final void invoke(bl.a aVar) {
        Intrinsics.h(aVar, "p0");
        ((FilterFragment) ((CallableReference) this).receiver).y1(aVar);
    }
}
