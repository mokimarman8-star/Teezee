package com.transsion.home.viewmodel;

import com.transsion.home.bean.SubOperateData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "Lcom/transsion/home/bean/SubOperateData;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Lcom/transsion/home/bean/SubOperateData;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.SubTabViewModel$fetchOperateData$1$1$operationTask$1", f = "SubTabViewModel.kt", l = {73}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubTabViewModel$fetchOperateData$1$1$operationTask$1 extends SuspendLambda implements Function2<n0, Continuation<? super SubOperateData>, Object> {
    final /* synthetic */ String $grade;
    final /* synthetic */ int $tabId;
    int label;
    final /* synthetic */ SubTabViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubTabViewModel$fetchOperateData$1$1$operationTask$1(SubTabViewModel subTabViewModel, int i, String str, Continuation<? super SubTabViewModel$fetchOperateData$1$1$operationTask$1> continuation) {
        super(2, continuation);
        this.this$0 = subTabViewModel;
        this.$tabId = i;
        this.$grade = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubTabViewModel$fetchOperateData$1$1$operationTask$1(this.this$0, this.$tabId, this.$grade, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super SubOperateData> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            SubTabViewModel subTabViewModel = this.this$0;
            int i2 = this.$tabId;
            String str = this.$grade;
            this.label = 1;
            obj = subTabViewModel.r(i2, str, this);
            if (obj == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return obj;
    }
}
