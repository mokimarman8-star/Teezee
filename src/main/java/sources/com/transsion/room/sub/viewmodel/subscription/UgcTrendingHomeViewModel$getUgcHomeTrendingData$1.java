package com.transsion.room.sub.viewmodel.subscription;

import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import mg.b;
import okhttp3.RequestBody;
import pp.c;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.sub.viewmodel.subscription.UgcTrendingHomeViewModel$getUgcHomeTrendingData$1", f = "UgcTrendingHomeViewModel.kt", l = {56}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class UgcTrendingHomeViewModel$getUgcHomeTrendingData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $page;
    final /* synthetic */ String $sort;
    Object L$0;
    int label;
    final /* synthetic */ UgcTrendingHomeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UgcTrendingHomeViewModel$getUgcHomeTrendingData$1(Integer num, UgcTrendingHomeViewModel ugcTrendingHomeViewModel, String str, Continuation<? super UgcTrendingHomeViewModel$getUgcHomeTrendingData$1> continuation) {
        super(2, continuation);
        this.$page = num;
        this.this$0 = ugcTrendingHomeViewModel;
        this.$sort = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UgcTrendingHomeViewModel$getUgcHomeTrendingData$1(this.$page, this.this$0, this.$sort, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Integer num;
        c cVar;
        UgcTrendingHomeViewModel ugcTrendingHomeViewModel;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Exception e) {
            e.printStackTrace();
            a.a aVar = wf.a.a;
            String simpleName = UgcTrendingHomeViewModel.class.getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            aVar.i(simpleName, "exceptionHandler " + e.getMessage(), true);
        }
        if (i == 0) {
            ResultKt.b(obj);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("page", this.$page);
            num = this.this$0.c;
            jsonObject.addProperty("perPage", num);
            jsonObject.addProperty("sort", this.$sort);
            b.a aVar2 = b.a;
            String jsonElement = jsonObject.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            RequestBody a = aVar2.a(jsonElement);
            if (a != null) {
                UgcTrendingHomeViewModel ugcTrendingHomeViewModel2 = this.this$0;
                cVar = ugcTrendingHomeViewModel2.d;
                String a2 = gg.a.a.a();
                this.L$0 = ugcTrendingHomeViewModel2;
                this.label = 1;
                obj = cVar.a(a2, a, this);
                if (obj == f) {
                    return f;
                }
                ugcTrendingHomeViewModel = ugcTrendingHomeViewModel2;
            }
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ugcTrendingHomeViewModel = (UgcTrendingHomeViewModel) this.L$0;
        ResultKt.b(obj);
        BaseDto baseDto = (BaseDto) obj;
        a.a.f(wf.a.a, "UgcTrendingHomeViewModel", "Feed Home Trending: " + baseDto, false, 4, (Object) null);
        ugcTrendingHomeViewModel.f().n(baseDto.getData());
        return Unit.a;
    }
}
