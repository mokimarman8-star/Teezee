package com.transsion.ad.test.ad_config;

import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.manager.AdPlansStorageManager;
import com.transsion.ad.test.ad_config.TestAdPlansActivity;
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
import sh.t;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.test.ad_config.TestAdPlansActivity$onCreate$4", f = "TestAdPlansActivity.kt", l = {64}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class TestAdPlansActivity$onCreate$4 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ TestAdPlansActivity.AdPlansAdapter $mAdPlanAdapter;
    int label;
    final /* synthetic */ TestAdPlansActivity this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.ad.test.ad_config.TestAdPlansActivity$onCreate$4$1", f = "TestAdPlansActivity.kt", l = {65, 66}, m = "invokeSuspend")
    /* renamed from: com.transsion.ad.test.ad_config.TestAdPlansActivity$onCreate$4$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ TestAdPlansActivity.AdPlansAdapter $mAdPlanAdapter;
        int label;
        final /* synthetic */ TestAdPlansActivity this$0;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
        @DebugMetadata(c = "com.transsion.ad.test.ad_config.TestAdPlansActivity$onCreate$4$1$1", f = "TestAdPlansActivity.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.transsion.ad.test.ad_config.TestAdPlansActivity$onCreate$4$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00061 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<MbAdDbPlans> $allAdPlans;
            final /* synthetic */ TestAdPlansActivity.AdPlansAdapter $mAdPlanAdapter;
            int label;
            final /* synthetic */ TestAdPlansActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00061(TestAdPlansActivity.AdPlansAdapter adPlansAdapter, List<MbAdDbPlans> list, TestAdPlansActivity testAdPlansActivity, Continuation<? super C00061> continuation) {
                super(2, continuation);
                this.$mAdPlanAdapter = adPlansAdapter;
                this.$allAdPlans = list;
                this.this$0 = testAdPlansActivity;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00061(this.$mAdPlanAdapter, this.$allAdPlans, this.this$0, continuation);
            }

            public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
                return create(n0Var, continuation).invokeSuspend(Unit.a);
            }

            public final Object invokeSuspend(Object obj) {
                t tVar;
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.$mAdPlanAdapter.n1(this.$allAdPlans);
                List<MbAdDbPlans> list = this.$allAdPlans;
                t tVar2 = null;
                String str = "计划数量 = " + (list != null ? Boxing.d(list.size()) : null);
                tVar = this.this$0.binding;
                if (tVar == null) {
                    Intrinsics.y("binding");
                } else {
                    tVar2 = tVar;
                }
                tVar2.d.setText(str);
                return Unit.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TestAdPlansActivity.AdPlansAdapter adPlansAdapter, TestAdPlansActivity testAdPlansActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$mAdPlanAdapter = adPlansAdapter;
            this.this$0 = testAdPlansActivity;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$mAdPlanAdapter, this.this$0, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.a;
                this.label = 1;
                obj = adPlansStorageManager.g(this);
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
            C00061 c00061 = new C00061(this.$mAdPlanAdapter, (List) obj, this.this$0, null);
            this.label = 2;
            if (i.g(c, c00061, this) == f) {
                return f;
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TestAdPlansActivity$onCreate$4(TestAdPlansActivity.AdPlansAdapter adPlansAdapter, TestAdPlansActivity testAdPlansActivity, Continuation<? super TestAdPlansActivity$onCreate$4> continuation) {
        super(2, continuation);
        this.$mAdPlanAdapter = adPlansAdapter;
        this.this$0 = testAdPlansActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdPlansActivity$onCreate$4(this.$mAdPlanAdapter, this.this$0, continuation);
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
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$mAdPlanAdapter, this.this$0, null);
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
