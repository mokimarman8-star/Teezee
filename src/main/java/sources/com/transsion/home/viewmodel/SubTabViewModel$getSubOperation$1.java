package com.transsion.home.viewmodel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.transsion.home.viewmodel.SubTabViewModel", f = "SubTabViewModel.kt", l = {149, 151}, m = "getSubOperation")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubTabViewModel$getSubOperation$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SubTabViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubTabViewModel$getSubOperation$1(SubTabViewModel subTabViewModel, Continuation<? super SubTabViewModel$getSubOperation$1> continuation) {
        super(continuation);
        this.this$0 = subTabViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object r;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        r = this.this$0.r(0, null, this);
        return r;
    }
}
