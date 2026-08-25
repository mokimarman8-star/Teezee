package com.transsion.moviedetail.fragment;

import androidx.fragment.app.FragmentActivity;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.moviedetail.fragment.MovieDetailFragment$initViewModel$1$1$1", f = "MovieDetailFragment.kt", l = {246}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MovieDetailFragment$initViewModel$1$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MovieDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MovieDetailFragment$initViewModel$1$1$1(MovieDetailFragment movieDetailFragment, Continuation<? super MovieDetailFragment$initViewModel$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = movieDetailFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MovieDetailFragment$initViewModel$1$1$1(this.this$0, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            this.label = 1;
            if (kotlinx.coroutines.u0.a(1500L, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        return Unit.a;
    }
}
