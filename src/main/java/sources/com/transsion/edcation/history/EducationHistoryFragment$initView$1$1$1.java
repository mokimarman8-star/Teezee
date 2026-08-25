package com.transsion.edcation.history;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.gslb.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import t6.f;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.edcation.history.EducationHistoryFragment$initView$1$1$1", f = "EducationHistoryFragment.kt", l = {55, DownloadBean.STATUS_COMPLETED_REMOVED}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class EducationHistoryFragment$initView$1$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EducationHistoryFragment this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.edcation.history.EducationHistoryFragment$initView$1$1$1$1", f = "EducationHistoryFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.edcation.history.EducationHistoryFragment$initView$1$1$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<VideoDetailPlayBean> $list;
        int label;
        final /* synthetic */ EducationHistoryFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<VideoDetailPlayBean> list, EducationHistoryFragment educationHistoryFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$list = list;
            this.this$0 = educationHistoryFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$list, this.this$0, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            EducationHistoryAdapter educationHistoryAdapter;
            f h0;
            EducationHistoryAdapter educationHistoryAdapter2;
            EducationHistoryAdapter educationHistoryAdapter3;
            f h02;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (this.$list.isEmpty()) {
                educationHistoryAdapter = this.this$0.mAdapter;
                if (educationHistoryAdapter != null && (h0 = educationHistoryAdapter.h0()) != null) {
                    f.u(h0, false, 1, (Object) null);
                }
            } else {
                educationHistoryAdapter2 = this.this$0.mAdapter;
                if (educationHistoryAdapter2 != null) {
                    educationHistoryAdapter2.q(this.$list);
                }
                educationHistoryAdapter3 = this.this$0.mAdapter;
                if (educationHistoryAdapter3 != null && (h02 = educationHistoryAdapter3.h0()) != null) {
                    h02.s();
                }
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EducationHistoryFragment$initView$1$1$1(EducationHistoryFragment educationHistoryFragment, Continuation<? super EducationHistoryFragment$initView$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = educationHistoryFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EducationHistoryFragment$initView$1$1$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            EducationHistoryFragment educationHistoryFragment = this.this$0;
            this.label = 1;
            obj = educationHistoryFragment.i0(false, this);
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
        AnonymousClass1 anonymousClass1 = new AnonymousClass1((List) obj, this.this$0, null);
        this.label = 2;
        if (i.g(c, anonymousClass1, this) == f) {
            return f;
        }
        return Unit.a;
    }
}
