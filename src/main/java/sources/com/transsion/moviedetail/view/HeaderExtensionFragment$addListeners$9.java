package com.transsion.moviedetail.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.transsion.edcation.CourseManager;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Subject;
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
import kotlinx.coroutines.flow.w0;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.moviedetail.view.HeaderExtensionFragment$addListeners$9", f = "HeaderExtensionFragment.kt", l = {203}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class HeaderExtensionFragment$addListeners$9 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HeaderExtensionFragment this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetail.view.HeaderExtensionFragment$addListeners$9$1", f = "HeaderExtensionFragment.kt", l = {204}, m = "invokeSuspend")
    /* renamed from: com.transsion.moviedetail.view.HeaderExtensionFragment$addListeners$9$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ HeaderExtensionFragment this$0;

        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Lcom/transsion/edcation/bean/CourseBean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.transsion.moviedetail.view.HeaderExtensionFragment$addListeners$9$1$1", f = "HeaderExtensionFragment.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.transsion.moviedetail.view.HeaderExtensionFragment$addListeners$9$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00411 extends SuspendLambda implements Function2<CourseBean, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ HeaderExtensionFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00411(HeaderExtensionFragment headerExtensionFragment, Continuation<? super C00411> continuation) {
                super(2, continuation);
                this.this$0 = headerExtensionFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00411 c00411 = new C00411(this.this$0, continuation);
                c00411.L$0 = obj;
                return c00411;
            }

            public final Object invoke(CourseBean courseBean, Continuation<? super Unit> continuation) {
                return create(courseBean, continuation).invokeSuspend(Unit.a);
            }

            public final Object invokeSuspend(Object obj) {
                Subject subject;
                Subject subject2;
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                CourseBean courseBean = (CourseBean) this.L$0;
                String subjectId = courseBean.getSubjectId();
                subject = this.this$0.subject;
                if (Intrinsics.c(subjectId, subject != null ? subject.getSubjectId() : null)) {
                    subject2 = this.this$0.subject;
                    if (subject2 != null) {
                        subject2.setSeenStatus(Boxing.d(courseBean.getSeenStatus()));
                    }
                    this.this$0.O0(Boxing.d(courseBean.getSeenStatus()));
                }
                return Unit.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(HeaderExtensionFragment headerExtensionFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = headerExtensionFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                w0 j = CourseManager.a.j();
                C00411 c00411 = new C00411(this.this$0, null);
                this.label = 1;
                if (kotlinx.coroutines.flow.c.h(j, c00411, this) == f) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HeaderExtensionFragment$addListeners$9(HeaderExtensionFragment headerExtensionFragment, Continuation<? super HeaderExtensionFragment$addListeners$9> continuation) {
        super(2, continuation);
        this.this$0 = headerExtensionFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HeaderExtensionFragment$addListeners$9(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            HeaderExtensionFragment headerExtensionFragment = this.this$0;
            Lifecycle.State state = Lifecycle.State.RESUMED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(headerExtensionFragment, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(headerExtensionFragment, state, anonymousClass1, this) == f) {
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
