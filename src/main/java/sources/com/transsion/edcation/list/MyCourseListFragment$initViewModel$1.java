package com.transsion.edcation.list;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.edcation.CourseManager;
import com.transsion.edcation.bean.CourseBean;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.x0;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.edcation.list.MyCourseListFragment$initViewModel$1", f = "MyCourseListFragment.kt", l = {62}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MyCourseListFragment$initViewModel$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MyCourseListFragment this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.edcation.list.MyCourseListFragment$initViewModel$1$1", f = "MyCourseListFragment.kt", l = {63}, m = "invokeSuspend")
    /* renamed from: com.transsion.edcation.list.MyCourseListFragment$initViewModel$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MyCourseListFragment this$0;

        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", BuildConfig.FLAVOR, "Lcom/transsion/edcation/bean/CourseBean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.transsion.edcation.list.MyCourseListFragment$initViewModel$1$1$1", f = "MyCourseListFragment.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.transsion.edcation.list.MyCourseListFragment$initViewModel$1$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00241 extends SuspendLambda implements Function2<List<CourseBean>, Continuation<? super Unit>, Object> {
            final /* synthetic */ n0 $$this$repeatOnLifecycle;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MyCourseListFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00241(n0 n0Var, MyCourseListFragment myCourseListFragment, Continuation<? super C00241> continuation) {
                super(2, continuation);
                this.$$this$repeatOnLifecycle = n0Var;
                this.this$0 = myCourseListFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00241 c00241 = new C00241(this.$$this$repeatOnLifecycle, this.this$0, continuation);
                c00241.L$0 = obj;
                return c00241;
            }

            public final Object invoke(List<CourseBean> list, Continuation<? super Unit> continuation) {
                return create(list, continuation).invokeSuspend(Unit.a);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                List list = (List) this.L$0;
                String.valueOf(this.$$this$repeatOnLifecycle);
                StringBuilder sb = new StringBuilder();
                sb.append("list: ");
                sb.append(list);
                BaseQuickAdapter mBaseAdapter = this.this$0.getMBaseAdapter();
                if (mBaseAdapter != null) {
                    mBaseAdapter.n1(list);
                }
                this.this$0.showContentView();
                return Unit.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MyCourseListFragment myCourseListFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = myCourseListFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                n0 n0Var = (n0) this.L$0;
                x0 h = CourseManager.a.h();
                C00241 c00241 = new C00241(n0Var, this.this$0, null);
                this.label = 1;
                if (kotlinx.coroutines.flow.c.h(h, c00241, this) == f) {
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
    MyCourseListFragment$initViewModel$1(MyCourseListFragment myCourseListFragment, Continuation<? super MyCourseListFragment$initViewModel$1> continuation) {
        super(2, continuation);
        this.this$0 = myCourseListFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MyCourseListFragment$initViewModel$1(this.this$0, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            Lifecycle lifecycle = this.this$0.getLifecycle();
            Intrinsics.g(lifecycle, "<get-lifecycle>(...)");
            Lifecycle.State state = Lifecycle.State.RESUMED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.a(lifecycle, state, anonymousClass1, this) == f) {
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
