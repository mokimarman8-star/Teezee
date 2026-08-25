package com.transsion.home.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.flow.bean.RoomItem;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.RoomEntranceResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import yk.e;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.TrendingUGCViewModel$fetchGroupInfo$1", f = "TrendingUGCViewModel.kt", l = {368}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TrendingUGCViewModel$fetchGroupInfo$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $useCache;
    int label;
    final /* synthetic */ TrendingUGCViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TrendingUGCViewModel$fetchGroupInfo$1(TrendingUGCViewModel trendingUGCViewModel, Function0<Unit> function0, Continuation<? super TrendingUGCViewModel$fetchGroupInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = trendingUGCViewModel;
        this.$useCache = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrendingUGCViewModel$fetchGroupInfo$1(this.this$0, this.$useCache, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        yk.e C;
        List<RoomItem> groups;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                C = this.this$0.C();
                this.label = 1;
                obj = e.a.c(C, null, 3, this, 1, null);
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
            RoomEntranceResponse roomEntranceResponse = (RoomEntranceResponse) baseDto.getData();
            if (roomEntranceResponse == null || (groups = roomEntranceResponse.getGroups()) == null || !(!groups.isEmpty())) {
                this.$useCache.invoke();
            } else {
                this.this$0.B().n(baseDto.getData());
                zk.e.a.b().putString("trending_room_entrance_cache_v2", com.blankj.utilcode.util.o.j(baseDto.getData()));
            }
        } catch (Exception e) {
            this.$useCache.invoke();
            e.printStackTrace();
        }
        return Unit.a;
    }
}
