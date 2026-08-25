package com.transsion.ad.test.ad_config;

import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.pslink.PsLinkAdPlan;
import com.transsion.ad.test.ad_config.TestAdPsOfferActivity;
import com.transsion.gslb.BuildConfig;
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
import kotlinx.coroutines.a2;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import sh.u;
import vh.l;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.test.ad_config.TestAdPsOfferActivity$onCreate$2", f = "TestAdPsOfferActivity.kt", l = {46}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TestAdPsOfferActivity$onCreate$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ TestAdPsOfferActivity.a $mAdPlanAdapter;
    int label;
    final /* synthetic */ TestAdPsOfferActivity this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ad.test.ad_config.TestAdPsOfferActivity$onCreate$2$1", f = "TestAdPsOfferActivity.kt", l = {49, 50}, m = "invokeSuspend")
    /* renamed from: com.transsion.ad.test.ad_config.TestAdPsOfferActivity$onCreate$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ TestAdPsOfferActivity.a $mAdPlanAdapter;
        int label;
        final /* synthetic */ TestAdPsOfferActivity this$0;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
        @DebugMetadata(c = "com.transsion.ad.test.ad_config.TestAdPsOfferActivity$onCreate$2$1$1", f = "TestAdPsOfferActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.transsion.ad.test.ad_config.TestAdPsOfferActivity$onCreate$2$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00071 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<PsLinkAdPlan> $allPslink;
            final /* synthetic */ TestAdPsOfferActivity.a $mAdPlanAdapter;
            int label;
            final /* synthetic */ TestAdPsOfferActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00071(TestAdPsOfferActivity.a aVar, List<PsLinkAdPlan> list, TestAdPsOfferActivity testAdPsOfferActivity, Continuation<? super C00071> continuation) {
                super(2, continuation);
                this.$mAdPlanAdapter = aVar;
                this.$allPslink = list;
                this.this$0 = testAdPsOfferActivity;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00071(this.$mAdPlanAdapter, this.$allPslink, this.this$0, continuation);
            }

            public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
                return create(n0Var, continuation).invokeSuspend(Unit.a);
            }

            public final Object invokeSuspend(Object obj) {
                u uVar;
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.$mAdPlanAdapter.n1(this.$allPslink);
                List<PsLinkAdPlan> list = this.$allPslink;
                u uVar2 = null;
                String str = "计划数量 = " + (list != null ? Boxing.d(list.size()) : null);
                uVar = this.this$0.binding;
                if (uVar == null) {
                    Intrinsics.y("binding");
                } else {
                    uVar2 = uVar;
                }
                uVar2.f.setText(str);
                return Unit.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TestAdPsOfferActivity testAdPsOfferActivity, TestAdPsOfferActivity.a aVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = testAdPsOfferActivity;
            this.$mAdPlanAdapter = aVar;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$mAdPlanAdapter, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                l z0 = MbAdDatabase.INSTANCE.b(this.this$0).z0();
                this.label = 1;
                obj = z0.a(this);
                if (obj == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.a;
                }
                ResultKt.b(obj);
            }
            a2 c = y0.c();
            C00071 c00071 = new C00071(this.$mAdPlanAdapter, (List) obj, this.this$0, null);
            this.label = 2;
            if (i.g(c, c00071, this) == f) {
                return f;
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TestAdPsOfferActivity$onCreate$2(TestAdPsOfferActivity testAdPsOfferActivity, TestAdPsOfferActivity.a aVar, Continuation<? super TestAdPsOfferActivity$onCreate$2> continuation) {
        super(2, continuation);
        this.this$0 = testAdPsOfferActivity;
        this.$mAdPlanAdapter = aVar;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdPsOfferActivity$onCreate$2(this.this$0, this.$mAdPlanAdapter, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            i0 b = y0.b();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$mAdPlanAdapter, null);
            this.label = 1;
            if (i.g(b, anonymousClass1, this) == f) {
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
