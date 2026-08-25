package com.transsion.home.viewmodel;

import com.tencent.mmkv.MMKV;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.TrendingRequestEntity;
import com.transsion.home.bean.TrendingRespData;
import com.transsion.home.bean.TrendingRespItem;
import com.transsion.push.bean.MsgStyle;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.transsion.home.viewmodel.TrendingViewModel$getTrendingList$1", f = "TrendingViewModel.kt", l = {87}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TrendingViewModel$getTrendingList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $nextPage;
    final /* synthetic */ TrendingRequestEntity $requestEntity;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TrendingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TrendingViewModel$getTrendingList$1(TrendingRequestEntity trendingRequestEntity, TrendingViewModel trendingViewModel, String str, Continuation<? super TrendingViewModel$getTrendingList$1> continuation) {
        super(2, continuation);
        this.$requestEntity = trendingRequestEntity;
        this.this$0 = trendingViewModel;
        this.$nextPage = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TrendingViewModel$getTrendingList$1 trendingViewModel$getTrendingList$1 = new TrendingViewModel$getTrendingList$1(this.$requestEntity, this.this$0, this.$nextPage, continuation);
        trendingViewModel$getTrendingList$1.L$0 = obj;
        return trendingViewModel$getTrendingList$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        n0 n0Var;
        TrendingViewModel trendingViewModel;
        String str;
        Integer perRow;
        List<TrendingRespItem> items;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        boolean z = true;
        try {
        } catch (Exception e) {
            a.a.f(wf.a.a, "TrendingViewModel", String.valueOf(e.getMessage()), false, 4, (Object) null);
            e.printStackTrace();
            this.this$0.X().n((Object) null);
        }
        if (i == 0) {
            ResultKt.b(obj);
            n0Var = (n0) this.L$0;
            b.a aVar = mg.b.a;
            String j = com.blankj.utilcode.util.o.j(this.$requestEntity);
            Intrinsics.g(j, "toJson(...)");
            RequestBody a = aVar.a(j);
            if (a != null) {
                trendingViewModel = this.this$0;
                String str2 = this.$nextPage;
                yk.e S = TrendingViewModel.S(trendingViewModel);
                String a2 = gg.a.a.a();
                this.L$0 = n0Var;
                this.L$1 = trendingViewModel;
                this.L$2 = str2;
                this.label = 1;
                obj = S.b(a2, a, this);
                if (obj == f) {
                    return f;
                }
                str = str2;
            }
            return Unit.a;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str = (String) this.L$2;
        trendingViewModel = (TrendingViewModel) this.L$1;
        n0Var = (n0) this.L$0;
        ResultKt.b(obj);
        BaseDto baseDto = (BaseDto) obj;
        if (Intrinsics.c(baseDto.getCode(), "0")) {
            a.a aVar2 = wf.a.a;
            TrendingRespData trendingRespData = (TrendingRespData) baseDto.getData();
            a.a.f(aVar2, "TrendingViewModel", "success " + ((trendingRespData == null || (items = trendingRespData.getItems()) == null) ? null : Boxing.d(items.size())) + " " + n0Var + "@PostListViewModel", false, 4, (Object) null);
            trendingViewModel.X().n(baseDto.getData());
            if (Intrinsics.c(str, MsgStyle.CUSTOM_LEFT_PIC)) {
                MMKV b = zk.e.a.b();
                TrendingRespData trendingRespData2 = (TrendingRespData) baseDto.getData();
                if (trendingRespData2 != null && (perRow = trendingRespData2.getPerRow()) != null && perRow.intValue() == 1) {
                    z = false;
                }
                b.putBoolean("trending_operation_grid_feeds", z);
            }
        } else {
            a.a.f(wf.a.a, "TrendingViewModel", "code " + baseDto.getCode() + " message " + baseDto.getMsg(), false, 4, (Object) null);
            trendingViewModel.X().n(baseDto.getData());
        }
        return Unit.a;
    }
}
