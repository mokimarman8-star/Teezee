package com.transsion.home.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.TrendingRequestEntity;
import com.transsion.home.bean.TrendingRespData;
import com.transsion.home.bean.TrendingRespItem;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.push.bean.MsgStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import mg.b;
import okhttp3.RequestBody;
import wf.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.TrendingUGCViewModel$requestFeedsList$1", f = "TrendingUGCViewModel.kt", l = {274}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TrendingUGCViewModel$requestFeedsList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ TrendingRequestEntity $requestEntity;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TrendingUGCViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TrendingUGCViewModel$requestFeedsList$1(TrendingRequestEntity trendingRequestEntity, TrendingUGCViewModel trendingUGCViewModel, Continuation<? super TrendingUGCViewModel$requestFeedsList$1> continuation) {
        super(2, continuation);
        this.$requestEntity = trendingRequestEntity;
        this.this$0 = trendingUGCViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TrendingUGCViewModel$requestFeedsList$1 trendingUGCViewModel$requestFeedsList$1 = new TrendingUGCViewModel$requestFeedsList$1(this.$requestEntity, this.this$0, continuation);
        trendingUGCViewModel$requestFeedsList$1.L$0 = obj;
        return trendingUGCViewModel$requestFeedsList$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        n0 n0Var;
        yk.e C;
        TrendingUGCViewModel trendingUGCViewModel;
        List<OperateItem> t;
        String str;
        Integer perPage;
        List<TrendingRespItem> items;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            try {
            } catch (Exception e) {
                a.a.f(wf.a.a, "TrendingUGCFragment", String.valueOf(e.getMessage()), false, 4, (Object) null);
                e.printStackTrace();
                this.this$0.E().n((Object) null);
            }
            if (i == 0) {
                ResultKt.b(obj);
                n0Var = (n0) this.L$0;
                b.a aVar = mg.b.a;
                String j = com.blankj.utilcode.util.o.j(this.$requestEntity);
                Intrinsics.g(j, "toJson(...)");
                RequestBody a = aVar.a(j);
                if (a != null) {
                    TrendingUGCViewModel trendingUGCViewModel2 = this.this$0;
                    C = trendingUGCViewModel2.C();
                    String a2 = gg.a.a.a();
                    this.L$0 = n0Var;
                    this.L$1 = trendingUGCViewModel2;
                    this.label = 1;
                    obj = C.i(a2, a, this);
                    if (obj == f) {
                        return f;
                    }
                    trendingUGCViewModel = trendingUGCViewModel2;
                }
                return Unit.a;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            trendingUGCViewModel = (TrendingUGCViewModel) this.L$1;
            n0Var = (n0) this.L$0;
            ResultKt.b(obj);
            BaseDto baseDto = (BaseDto) obj;
            TrendingRespData trendingRespData = (TrendingRespData) baseDto.getData();
            if (Intrinsics.c(baseDto.getCode(), "0")) {
                a.a.f(wf.a.a, "TrendingUGCFragment", "success " + ((trendingRespData == null || (items = trendingRespData.getItems()) == null) ? null : Boxing.d(items.size())) + " " + n0Var + "@PostListViewModel", false, 4, (Object) null);
                if ((trendingRespData != null ? trendingRespData.getPager() : null) != null) {
                    Pager pager = trendingRespData.getPager();
                    if (pager == null || (str = pager.getNextPage()) == null) {
                        str = MsgStyle.CUSTOM_LEFT_PIC;
                    }
                    trendingUGCViewModel.b = str;
                    Pager pager2 = trendingRespData.getPager();
                    trendingUGCViewModel.c = (pager2 == null || (perPage = pager2.getPerPage()) == null) ? 14 : perPage.intValue();
                }
            } else {
                a.a.f(wf.a.a, "TrendingUGCFragment", "code " + baseDto.getCode() + " message " + baseDto.getMsg(), false, 4, (Object) null);
            }
            if (trendingRespData != null) {
                List<TrendingRespItem> items2 = trendingRespData.getItems();
                if (items2 == null) {
                    items2 = CollectionsKt.l();
                }
                t = trendingUGCViewModel.t(items2);
                trendingRespData.setTransferData(t);
            }
            trendingUGCViewModel.E().n(trendingRespData);
            return Unit.a;
        } finally {
            this.this$0.d = false;
        }
    }
}
