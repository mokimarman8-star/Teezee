package com.transsion.edcation.list;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.edcation.CourseManager;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.push.bean.MsgStyle;
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
@DebugMetadata(c = "com.transsion.edcation.list.MyCourseListFragment$initViewModel$2", f = "MyCourseListFragment.kt", l = {71}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MyCourseListFragment$initViewModel$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MyCourseListFragment this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.edcation.list.MyCourseListFragment$initViewModel$2$1", f = "MyCourseListFragment.kt", l = {73}, m = "invokeSuspend")
    /* renamed from: com.transsion.edcation.list.MyCourseListFragment$initViewModel$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MyCourseListFragment this$0;

        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Lcom/transsion/moviedetailapi/bean/Pager;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.transsion.edcation.list.MyCourseListFragment$initViewModel$2$1$1", f = "MyCourseListFragment.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.transsion.edcation.list.MyCourseListFragment$initViewModel$2$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00251 extends SuspendLambda implements Function2<Pager, Continuation<? super Unit>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MyCourseListFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00251(MyCourseListFragment myCourseListFragment, Continuation<? super C00251> continuation) {
                super(2, continuation);
                this.this$0 = myCourseListFragment;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C00251 c00251 = new C00251(this.this$0, continuation);
                c00251.L$0 = obj;
                return c00251;
            }

            public final Object invoke(Pager pager, Continuation<? super Unit> continuation) {
                return create(pager, continuation).invokeSuspend(Unit.a);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                Pager pager = (Pager) this.L$0;
                if (pager != null) {
                    MyCourseListFragment myCourseListFragment = this.this$0;
                    if (Intrinsics.c(pager.getHasMore(), Boxing.a(true))) {
                        String nextPage = pager.getNextPage();
                        if (nextPage == null) {
                            nextPage = MsgStyle.CUSTOM_LEFT_PIC;
                        }
                        myCourseListFragment.mPageNum = nextPage;
                        myCourseListFragment.B0();
                    } else {
                        BaseListFragment.D0(myCourseListFragment, false, 1, null);
                    }
                }
                if (this.this$0.A0()) {
                    this.this$0.I0(false);
                }
                return Unit.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MyCourseListFragment myCourseListFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = myCourseListFragment;
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
                w0 i2 = CourseManager.a.i();
                C00251 c00251 = new C00251(this.this$0, null);
                this.label = 1;
                if (kotlinx.coroutines.flow.c.h(i2, c00251, this) == f) {
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
    MyCourseListFragment$initViewModel$2(MyCourseListFragment myCourseListFragment, Continuation<? super MyCourseListFragment$initViewModel$2> continuation) {
        super(2, continuation);
        this.this$0 = myCourseListFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MyCourseListFragment$initViewModel$2(this.this$0, continuation);
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
