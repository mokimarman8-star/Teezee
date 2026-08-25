package com.transsion.home.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.RankAllData;
import com.transsion.moviedetailapi.bean.Pager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.n0;
import wf.a;
import yk.d;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.RankAllViewModel$startRequest$1", f = "RankAllViewModel.kt", l = {48}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class RankAllViewModel$startRequest$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isLoadMore;
    int label;
    final /* synthetic */ RankAllViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RankAllViewModel$startRequest$1(boolean z, RankAllViewModel rankAllViewModel, Continuation<? super RankAllViewModel$startRequest$1> continuation) {
        super(2, continuation);
        this.$isLoadMore = z;
        this.this$0 = rankAllViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RankAllViewModel$startRequest$1(this.$isLoadMore, this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        int i;
        yk.d dVar;
        String str;
        int i2;
        String str2;
        int i3;
        int i4;
        int i5;
        Pager pager;
        String page;
        Integer v;
        Object f = IntrinsicsKt.f();
        int i6 = this.label;
        try {
            if (i6 == 0) {
                ResultKt.b(obj);
                if (this.$isLoadMore) {
                    i3 = this.this$0.c;
                    i = i3 + 1;
                } else {
                    i = this.this$0.c;
                }
                int i7 = i;
                dVar = this.this$0.d;
                str = this.this$0.e;
                i2 = this.this$0.f;
                str2 = this.this$0.g;
                this.label = 1;
                obj = d.a.a(dVar, null, i2, str, i7, 0, str2, this, 17, null);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i6 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            this.this$0.m((RankAllData) baseDto.getData());
            if (this.$isLoadMore) {
                this.this$0.i().n((RankAllData) baseDto.getData());
                RankAllViewModel rankAllViewModel = this.this$0;
                RankAllData rankAllData = (RankAllData) baseDto.getData();
                if (rankAllData == null || (pager = rankAllData.getPager()) == null || (page = pager.getPage()) == null || (v = StringsKt.v(page)) == null) {
                    i4 = this.this$0.c;
                    i5 = i4 + 1;
                } else {
                    i5 = v.intValue();
                }
                rankAllViewModel.c = i5;
            } else {
                this.this$0.j().n(baseDto.getData());
            }
        } catch (Exception e) {
            e.printStackTrace();
            a.a aVar = wf.a.a;
            String simpleName = RankAllViewModel.class.getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            aVar.i(simpleName, "exceptionHandler " + e.getMessage(), true);
            if (this.$isLoadMore) {
                this.this$0.i().n((Object) null);
            } else {
                this.this$0.j().n((Object) null);
            }
        }
        return Unit.a;
    }
}
