package com.transsion.home.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.UGCRankAllData;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.push.bean.MsgStyle;
import com.transsion.ugcvideodetail.api.bean.UGCContent;
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
import kotlinx.coroutines.n0;
import wf.a;
import yk.d;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.UGCRankingViewModel$startRequest$1", f = "UGCRankingViewModel.kt", l = {52}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class UGCRankingViewModel$startRequest$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLoadMore;
    int label;
    final /* synthetic */ UGCRankingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UGCRankingViewModel$startRequest$1(boolean z, UGCRankingViewModel uGCRankingViewModel, Continuation<? super UGCRankingViewModel$startRequest$1> continuation) {
        super(2, continuation);
        this.$isLoadMore = z;
        this.this$0 = uGCRankingViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCRankingViewModel$startRequest$1(this.$isLoadMore, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        String str3;
        yk.d dVar;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Pager pager;
        String page;
        Pager pager2;
        String str9;
        Pager pager3;
        Pager pager4;
        List<UGCContent> items;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                a.a aVar = wf.a.a;
                boolean z = this.$isLoadMore;
                str = this.this$0.c;
                str2 = this.this$0.e;
                str3 = this.this$0.f;
                a.a.f(aVar, "UGCRankingViewModel", "startRequest: isLoadMore=" + z + ", page=" + str + ", category=" + str2 + ", tabId=" + str3, false, 4, (Object) null);
                dVar = this.this$0.d;
                str4 = this.this$0.e;
                str5 = this.this$0.f;
                str6 = this.this$0.c;
                this.label = 1;
                obj = d.a.b(dVar, null, str5, str4, str6, 0, this, 17, null);
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
            a.a aVar2 = wf.a.a;
            UGCRankAllData uGCRankAllData = (UGCRankAllData) baseDto.getData();
            Integer d = (uGCRankAllData == null || (items = uGCRankAllData.getItems()) == null) ? null : Boxing.d(items.size());
            UGCRankAllData uGCRankAllData2 = (UGCRankAllData) baseDto.getData();
            a.a.f(aVar2, "UGCRankingViewModel", "startRequest: received data, items size=" + d + ", hasMore=" + ((uGCRankAllData2 == null || (pager4 = uGCRankAllData2.getPager()) == null) ? null : pager4.getHasMore()), false, 4, (Object) null);
            this.this$0.o((UGCRankAllData) baseDto.getData());
            this.this$0.i((UGCRankAllData) baseDto.getData());
            if (this.$isLoadMore) {
                this.this$0.j().n(baseDto.getData());
                UGCRankingViewModel uGCRankingViewModel = this.this$0;
                UGCRankAllData uGCRankAllData3 = (UGCRankAllData) baseDto.getData();
                if (uGCRankAllData3 == null || (pager3 = uGCRankAllData3.getPager()) == null || (page = pager3.getNextPage()) == null) {
                    UGCRankAllData uGCRankAllData4 = (UGCRankAllData) baseDto.getData();
                    page = (uGCRankAllData4 == null || (pager2 = uGCRankAllData4.getPager()) == null) ? null : pager2.getPage();
                    if (page == null) {
                        page = this.this$0.c;
                    }
                }
                uGCRankingViewModel.c = page;
                str9 = this.this$0.c;
                a.a.f(aVar2, "UGCRankingViewModel", "startRequest: loadMore completed, nextPage=" + str9, false, 4, (Object) null);
            } else {
                this.this$0.k().n(baseDto.getData());
                UGCRankingViewModel uGCRankingViewModel2 = this.this$0;
                UGCRankAllData uGCRankAllData5 = (UGCRankAllData) baseDto.getData();
                if (uGCRankAllData5 == null || (pager = uGCRankAllData5.getPager()) == null || (str7 = pager.getNextPage()) == null) {
                    str7 = MsgStyle.CUSTOM_LEFT_PIC;
                }
                uGCRankingViewModel2.c = str7;
                str8 = this.this$0.c;
                a.a.f(aVar2, "UGCRankingViewModel", "startRequest: initial load completed, nextPage=" + str8, false, 4, (Object) null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            wf.a.a.i("UGCRankingViewModel", "startRequest: exception " + e.getMessage(), true);
            if (this.$isLoadMore) {
                this.this$0.j().n((Object) null);
            } else {
                this.this$0.k().n((Object) null);
            }
        }
        return Unit.a;
    }
}
