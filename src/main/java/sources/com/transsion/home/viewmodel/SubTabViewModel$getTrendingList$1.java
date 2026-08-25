package com.transsion.home.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.TrendingRequestEntity;
import com.transsion.home.bean.TrendingRespData;
import com.transsion.home.bean.TrendingRespItem;
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
@DebugMetadata(c = "com.transsion.home.viewmodel.SubTabViewModel$getTrendingList$1", f = "SubTabViewModel.kt", l = {215, 217}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubTabViewModel$getTrendingList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ TrendingRequestEntity $requestEntity;
    final /* synthetic */ String $tabCode;
    final /* synthetic */ int $tabId;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SubTabViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubTabViewModel$getTrendingList$1(TrendingRequestEntity trendingRequestEntity, SubTabViewModel subTabViewModel, String str, int i, Continuation<? super SubTabViewModel$getTrendingList$1> continuation) {
        super(2, continuation);
        this.$requestEntity = trendingRequestEntity;
        this.this$0 = subTabViewModel;
        this.$tabCode = str;
        this.$tabId = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SubTabViewModel$getTrendingList$1 subTabViewModel$getTrendingList$1 = new SubTabViewModel$getTrendingList$1(this.$requestEntity, this.this$0, this.$tabCode, this.$tabId, continuation);
        subTabViewModel$getTrendingList$1.L$0 = obj;
        return subTabViewModel$getTrendingList$1;
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        n0 n0Var;
        boolean z;
        String valueOf;
        boolean z2;
        yk.e eVar;
        SubTabViewModel subTabViewModel;
        yk.e eVar2;
        BaseDto baseDto;
        boolean z3;
        List<TrendingRespItem> l;
        List<OperateItem> l2;
        List<TrendingRespItem> l3;
        List<TrendingRespItem> items;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
        } catch (Exception e) {
            a.a.f(wf.a.a, "SubTabViewModel", String.valueOf(e.getMessage()), false, 4, (Object) null);
            e.printStackTrace();
            this.this$0.s().n((Object) null);
        }
        if (i == 0) {
            ResultKt.b(obj);
            n0Var = (n0) this.L$0;
            TrendingRequestEntity trendingRequestEntity = this.$requestEntity;
            z = this.this$0.g;
            if (z) {
                valueOf = this.$tabCode;
                if (valueOf == null) {
                    valueOf = BuildConfig.FLAVOR;
                }
            } else {
                valueOf = String.valueOf(this.$tabId);
            }
            trendingRequestEntity.setTabId(valueOf);
            this.$requestEntity.setDisablePlaylist(Boxing.a(false));
            b.a aVar = mg.b.a;
            String j = com.blankj.utilcode.util.o.j(this.$requestEntity);
            Intrinsics.g(j, "toJson(...)");
            RequestBody a = aVar.a(j);
            if (a != null) {
                SubTabViewModel subTabViewModel2 = this.this$0;
                z2 = subTabViewModel2.g;
                if (z2) {
                    eVar2 = subTabViewModel2.e;
                    String a2 = gg.a.a.a();
                    this.L$0 = n0Var;
                    this.L$1 = subTabViewModel2;
                    this.label = 1;
                    obj = eVar2.d(a2, a, this);
                    if (obj == f) {
                        return f;
                    }
                    subTabViewModel = subTabViewModel2;
                    baseDto = (BaseDto) obj;
                } else {
                    eVar = subTabViewModel2.e;
                    String a3 = gg.a.a.a();
                    this.L$0 = n0Var;
                    this.L$1 = subTabViewModel2;
                    this.label = 2;
                    obj = eVar.b(a3, a, this);
                    if (obj == f) {
                        return f;
                    }
                    subTabViewModel = subTabViewModel2;
                    baseDto = (BaseDto) obj;
                }
            }
            return Unit.a;
        }
        if (i == 1) {
            subTabViewModel = (SubTabViewModel) this.L$1;
            n0Var = (n0) this.L$0;
            ResultKt.b(obj);
            baseDto = (BaseDto) obj;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            subTabViewModel = (SubTabViewModel) this.L$1;
            n0Var = (n0) this.L$0;
            ResultKt.b(obj);
            baseDto = (BaseDto) obj;
        }
        if (Intrinsics.c(baseDto.getCode(), "0")) {
            a.a aVar2 = wf.a.a;
            TrendingRespData trendingRespData = (TrendingRespData) baseDto.getData();
            a.a.f(aVar2, "SubTabViewModel", "success " + ((trendingRespData == null || (items = trendingRespData.getItems()) == null) ? null : Boxing.d(items.size())) + " " + n0Var + "@PostListViewModel", false, 4, (Object) null);
            z3 = subTabViewModel.g;
            if (z3) {
                TrendingRespData trendingRespData2 = (TrendingRespData) baseDto.getData();
                if (trendingRespData2 == null || (l3 = trendingRespData2.getItems()) == null) {
                    l3 = CollectionsKt.l();
                }
                l2 = subTabViewModel.m(l3);
            } else {
                TrendingRespData trendingRespData3 = (TrendingRespData) baseDto.getData();
                if (trendingRespData3 == null || (l = trendingRespData3.getItems()) == null) {
                    l = CollectionsKt.l();
                }
                l2 = subTabViewModel.l(l);
            }
            TrendingRespData trendingRespData4 = (TrendingRespData) baseDto.getData();
            if (trendingRespData4 != null) {
                trendingRespData4.setTransferData(l2);
            }
            subTabViewModel.s().n(baseDto.getData());
        } else {
            a.a.f(wf.a.a, "SubTabViewModel", "code " + baseDto.getCode() + " message " + baseDto.getMsg(), false, 4, (Object) null);
        }
        return Unit.a;
    }
}
