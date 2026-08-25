package com.transsion.commercialization.task;

import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.commercialization.task.MemberPageVideoTaskDialog;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.commercialization.task.MemberPageVideoTaskDialog$onViewCreated$1", f = "MemberPageVideoTaskDialog.kt", l = {71}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MemberPageVideoTaskDialog$onViewCreated$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MemberPageVideoTaskDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MemberPageVideoTaskDialog$onViewCreated$1(MemberPageVideoTaskDialog memberPageVideoTaskDialog, Continuation<? super MemberPageVideoTaskDialog$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = memberPageVideoTaskDialog;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemberPageVideoTaskDialog$onViewCreated$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        MemberPageVideoTaskDialog.a aVar;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            this.this$0.videoManager = new BiddingVideoManager();
            BiddingVideoManager biddingVideoManager = this.this$0.videoManager;
            if (biddingVideoManager != null) {
                biddingVideoManager.L0("MemberPageVideoTaskScene");
            }
            BiddingVideoManager biddingVideoManager2 = this.this$0.videoManager;
            if (biddingVideoManager2 != null) {
                aVar = this.this$0.videoListener;
                biddingVideoManager2.K0(aVar);
            }
            BiddingVideoManager biddingVideoManager3 = this.this$0.videoManager;
            if (biddingVideoManager3 != null) {
                this.label = 1;
                if (AbsAdBidding.t0(biddingVideoManager3, 0, false, this, 3, (Object) null) == f) {
                    return f;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.a;
    }
}
