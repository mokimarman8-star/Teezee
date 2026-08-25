package com.transsion.edcation.history;

import android.view.View;
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
import kotlinx.coroutines.u0;
import kotlinx.coroutines.y0;
import t6.f;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.edcation.history.EducationHistoryFragment$onResume$1", f = "EducationHistoryFragment.kt", l = {93, 94, 96}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class EducationHistoryFragment$onResume$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EducationHistoryFragment this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.edcation.history.EducationHistoryFragment$onResume$1$1", f = "EducationHistoryFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.edcation.history.EducationHistoryFragment$onResume$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<VideoDetailPlayBean> $list;
        int label;
        final /* synthetic */ EducationHistoryFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EducationHistoryFragment educationHistoryFragment, List<VideoDetailPlayBean> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = educationHistoryFragment;
            this.$list = list;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$list, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0041, code lost:
        
            r4 = r3.this$0.mAdapter;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            EducationHistoryAdapter educationHistoryAdapter;
            View j0;
            int i2;
            EducationHistoryAdapter educationHistoryAdapter2;
            f h0;
            EducationHistoryAdapter educationHistoryAdapter3;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            i = this.this$0.mOffset;
            if (i > 0) {
                educationHistoryAdapter3 = this.this$0.mAdapter;
                if (educationHistoryAdapter3 != null) {
                    educationHistoryAdapter3.n1(this.$list);
                }
            } else {
                educationHistoryAdapter = this.this$0.mAdapter;
                if (educationHistoryAdapter != null) {
                    j0 = this.this$0.j0();
                    educationHistoryAdapter.Y0(j0);
                }
            }
            int size = this.$list.size();
            i2 = this.this$0.mLimit;
            if (size < i2 && educationHistoryAdapter2 != null && (h0 = educationHistoryAdapter2.h0()) != null) {
                f.u(h0, false, 1, (Object) null);
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EducationHistoryFragment$onResume$1(EducationHistoryFragment educationHistoryFragment, Continuation<? super EducationHistoryFragment$onResume$1> continuation) {
        super(2, continuation);
        this.this$0 = educationHistoryFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EducationHistoryFragment$onResume$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0054 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        a2 c;
        AnonymousClass1 anonymousClass1;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            this.label = 1;
            if (u0.a(1000L, this) == f) {
                return f;
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.a;
                }
                ResultKt.b(obj);
                c = y0.c();
                anonymousClass1 = new AnonymousClass1(this.this$0, (List) obj, null);
                this.label = 3;
                if (i.g(c, anonymousClass1, this) == f) {
                    return f;
                }
                return Unit.a;
            }
            ResultKt.b(obj);
        }
        EducationHistoryFragment educationHistoryFragment = this.this$0;
        this.label = 2;
        obj = educationHistoryFragment.i0(true, this);
        if (obj == f) {
            return f;
        }
        c = y0.c();
        anonymousClass1 = new AnonymousClass1(this.this$0, (List) obj, null);
        this.label = 3;
        if (i.g(c, anonymousClass1, this) == f) {
        }
        return Unit.a;
    }
}
