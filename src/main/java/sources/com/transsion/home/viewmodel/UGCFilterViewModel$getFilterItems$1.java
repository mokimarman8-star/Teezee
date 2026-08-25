package com.transsion.home.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.ugc.UGCFilterItem;
import com.transsion.home.bean.ugc.UGCFilterResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.UGCFilterViewModel$getFilterItems$1", f = "UGCFilterViewModel.kt", l = {55}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class UGCFilterViewModel$getFilterItems$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $category;
    int label;
    final /* synthetic */ UGCFilterViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UGCFilterViewModel$getFilterItems$1(String str, UGCFilterViewModel uGCFilterViewModel, Continuation<? super UGCFilterViewModel$getFilterItems$1> continuation) {
        super(2, continuation);
        this.$category = str;
        this.this$0 = uGCFilterViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCFilterViewModel$getFilterItems$1(this.$category, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        yk.c cVar;
        List<UGCFilterItem> items;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                wf.a.a.c("UGCFilterViewModel", "getFilterItems: category=" + this.$category, false);
                cVar = this.this$0.e;
                String a = gg.a.a.a();
                String str = this.$category;
                this.label = 1;
                obj = cVar.c(a, str, this);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            this.this$0.k().n(baseDto);
            a.a aVar = wf.a.a;
            UGCFilterResponse uGCFilterResponse = (UGCFilterResponse) baseDto.getData();
            aVar.c("UGCFilterViewModel", "getFilterItems success: items size=" + ((uGCFilterResponse == null || (items = uGCFilterResponse.getItems()) == null) ? 0 : items.size()), false);
        } catch (Exception e) {
            e.printStackTrace();
            this.this$0.k().n((Object) null);
            wf.a.a.i("UGCFilterViewModel", "getFilterItems error: " + e.getMessage() + ", category=" + this.$category, true);
        }
        return Unit.a;
    }
}
