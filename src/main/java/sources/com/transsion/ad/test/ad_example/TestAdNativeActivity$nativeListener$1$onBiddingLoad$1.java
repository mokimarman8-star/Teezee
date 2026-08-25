package com.transsion.ad.test.ad_example;

import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
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
import kotlinx.coroutines.a2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.test.ad_example.TestAdNativeActivity$nativeListener$1$onBiddingLoad$1", f = "TestAdNativeActivity.kt", l = {31}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TestAdNativeActivity$nativeListener$1$onBiddingLoad$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ BiddingIntermediateMaterialBean $maxEcpmObject;
    int label;
    final /* synthetic */ TestAdNativeActivity this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ad.test.ad_example.TestAdNativeActivity$nativeListener$1$onBiddingLoad$1$1", f = "TestAdNativeActivity.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.ad.test.ad_example.TestAdNativeActivity$nativeListener$1$onBiddingLoad$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ BiddingIntermediateMaterialBean $maxEcpmObject;
        int label;
        final /* synthetic */ TestAdNativeActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TestAdNativeActivity testAdNativeActivity, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = testAdNativeActivity;
            this.$maxEcpmObject = biddingIntermediateMaterialBean;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$maxEcpmObject, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            sh.o oVar;
            BiddingNativeManager biddingNativeManager;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            s sVar = new s(this.this$0);
            oVar = this.this$0.binding;
            BiddingNativeManager biddingNativeManager2 = null;
            if (oVar == null) {
                Intrinsics.y("binding");
                oVar = null;
            }
            NativeWrapperAdView nativeWrapperAdView = oVar.c;
            biddingNativeManager = this.this$0.nativeManager;
            if (biddingNativeManager == null) {
                Intrinsics.y("nativeManager");
            } else {
                biddingNativeManager2 = biddingNativeManager;
            }
            nativeWrapperAdView.bindNativeView(biddingNativeManager2, sVar, this.$maxEcpmObject);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TestAdNativeActivity$nativeListener$1$onBiddingLoad$1(TestAdNativeActivity testAdNativeActivity, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, Continuation<? super TestAdNativeActivity$nativeListener$1$onBiddingLoad$1> continuation) {
        super(2, continuation);
        this.this$0 = testAdNativeActivity;
        this.$maxEcpmObject = biddingIntermediateMaterialBean;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdNativeActivity$nativeListener$1$onBiddingLoad$1(this.this$0, this.$maxEcpmObject, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            a2 c = y0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$maxEcpmObject, null);
            this.label = 1;
            if (kotlinx.coroutines.i.g(c, anonymousClass1, this) == f) {
                return f;
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
