package com.transsion.search.viewmodel;

import androidx.lifecycle.b0;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.widget.R;
import com.tn.lib.widget.toast.core.h;
import com.transsion.gslb.BuildConfig;
import com.transsion.search.net.RequestSearchEntity;
import cq.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import yg.l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.search.viewmodel.SearchViewModel$searchWorkV2$1", f = "SearchViewModel.kt", l = {97}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SearchViewModel$searchWorkV2$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ RequestSearchEntity $request;
    int label;
    final /* synthetic */ SearchViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchViewModel$searchWorkV2$1(SearchViewModel searchViewModel, RequestSearchEntity requestSearchEntity, Continuation<? super SearchViewModel$searchWorkV2$1> continuation) {
        super(2, continuation);
        this.this$0 = searchViewModel;
        this.$request = requestSearchEntity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchViewModel$searchWorkV2$1(this.this$0, this.$request, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        b0 b0Var;
        b0 b0Var2;
        c l;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.b(obj);
                SearchViewModel searchViewModel = this.this$0;
                RequestSearchEntity requestSearchEntity = this.$request;
                Result.Companion companion = Result.Companion;
                l = searchViewModel.l();
                this.label = 1;
                obj = l.h(requestSearchEntity, this);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            obj2 = Result.constructor-impl((BaseDto) obj);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        SearchViewModel searchViewModel2 = this.this$0;
        if (Result.isSuccess-impl(obj2)) {
            b0Var2 = searchViewModel2.d;
            b0Var2.n(((BaseDto) obj2).getData());
        }
        if (Result.exceptionOrNull-impl(obj2) != null) {
            if (l.a.e()) {
                h.a.l(Utils.a().getString(R.string.no_error_content));
            } else {
                h.a.l(Utils.a().getString(R.string.no_network_toast));
            }
            b0Var = searchViewModel2.d;
            b0Var.n((Object) null);
        }
        return Unit.a;
    }
}
