package com.transsion.moviedetail.fragment;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.transsion.edcation.CourseManager;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.moviedetail.fragment.ForYouFragment$initData$1", f = "ForYouFragment.kt", l = {252}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class ForYouFragment$initData$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ForYouFragment this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.moviedetail.fragment.ForYouFragment$initData$1$1", f = "ForYouFragment.kt", l = {253}, m = "invokeSuspend")
    /* renamed from: com.transsion.moviedetail.fragment.ForYouFragment$initData$1$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ForYouFragment this$0;

        /* renamed from: com.transsion.moviedetail.fragment.ForYouFragment$initData$1$1$1, reason: invalid class name and collision with other inner class name */
        static final class C00391 implements kotlinx.coroutines.flow.b {
            final /* synthetic */ ForYouFragment a;

            C00391(ForYouFragment forYouFragment) {
                this.a = forYouFragment;
            }

            /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0040  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00a4 -> B:10:0x00a7). Please report as a decompilation issue!!! */
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object emit(CourseBean courseBean, Continuation continuation) {
                ForYouFragment$initData$1$1$1$emit$1 forYouFragment$initData$1$1$1$emit$1;
                int i;
                BaseQuickAdapter baseQuickAdapter;
                List data;
                int i2;
                Iterator it;
                ForYouFragment forYouFragment;
                if (continuation instanceof ForYouFragment$initData$1$1$1$emit$1) {
                    forYouFragment$initData$1$1$1$emit$1 = (ForYouFragment$initData$1$1$1$emit$1) continuation;
                    int i3 = forYouFragment$initData$1$1$1$emit$1.label;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        forYouFragment$initData$1$1$1$emit$1.label = i3 - Integer.MIN_VALUE;
                        Object obj = forYouFragment$initData$1$1$1$emit$1.result;
                        Object f = IntrinsicsKt.f();
                        i = forYouFragment$initData$1$1$1$emit$1.label;
                        if (i != 0) {
                            ResultKt.b(obj);
                            baseQuickAdapter = this.a.forYouAdapter;
                            if (baseQuickAdapter != null && (data = baseQuickAdapter.getData()) != null) {
                                ForYouFragment forYouFragment2 = this.a;
                                i2 = 0;
                                it = data.iterator();
                                forYouFragment = forYouFragment2;
                                while (it.hasNext()) {
                                }
                            }
                            return Unit.a;
                        }
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        int i4 = forYouFragment$initData$1$1$1$emit$1.I$0;
                        it = (Iterator) forYouFragment$initData$1$1$1$emit$1.L$2;
                        ForYouFragment forYouFragment3 = (ForYouFragment) forYouFragment$initData$1$1$1$emit$1.L$1;
                        CourseBean courseBean2 = (CourseBean) forYouFragment$initData$1$1$1$emit$1.L$0;
                        ResultKt.b(obj);
                        forYouFragment = forYouFragment3;
                        i2 = i4;
                        courseBean = courseBean2;
                        while (it.hasNext()) {
                            Object next = it.next();
                            int i5 = i2 + 1;
                            if (i2 < 0) {
                                CollectionsKt.u();
                            }
                            Subject subject = (Subject) next;
                            if (Intrinsics.c(courseBean.getSubjectId(), subject.getSubjectId())) {
                                subject.setSeenStatus(Boxing.d(courseBean.getSeenStatus()));
                                kotlinx.coroutines.a2 c = kotlinx.coroutines.y0.c();
                                ForYouFragment$initData$1$1$1$1$1 forYouFragment$initData$1$1$1$1$1 = new ForYouFragment$initData$1$1$1$1$1(forYouFragment, i2, courseBean, null);
                                forYouFragment$initData$1$1$1$emit$1.L$0 = courseBean;
                                forYouFragment$initData$1$1$1$emit$1.L$1 = forYouFragment;
                                forYouFragment$initData$1$1$1$emit$1.L$2 = it;
                                forYouFragment$initData$1$1$1$emit$1.I$0 = i5;
                                forYouFragment$initData$1$1$1$emit$1.label = 1;
                                if (kotlinx.coroutines.i.g(c, forYouFragment$initData$1$1$1$1$1, forYouFragment$initData$1$1$1$emit$1) == f) {
                                    return f;
                                }
                                courseBean2 = courseBean;
                                forYouFragment3 = forYouFragment;
                                i4 = i5;
                                forYouFragment = forYouFragment3;
                                i2 = i4;
                                courseBean = courseBean2;
                                while (it.hasNext()) {
                                }
                            } else {
                                i2 = i5;
                            }
                        }
                        return Unit.a;
                    }
                }
                forYouFragment$initData$1$1$1$emit$1 = new ForYouFragment$initData$1$1$1$emit$1(this, continuation);
                Object obj2 = forYouFragment$initData$1$1$1$emit$1.result;
                Object f2 = IntrinsicsKt.f();
                i = forYouFragment$initData$1$1$1$emit$1.label;
                if (i != 0) {
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ForYouFragment forYouFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = forYouFragment;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            Object f = IntrinsicsKt.f();
            int i = this.label;
            if (i == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.w0 j = CourseManager.a.j();
                C00391 c00391 = new C00391(this.this$0);
                this.label = 1;
                if (j.a(c00391, this) == f) {
                    return f;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ForYouFragment$initData$1(ForYouFragment forYouFragment, Continuation<? super ForYouFragment$initData$1> continuation) {
        super(2, continuation);
        this.this$0 = forYouFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ForYouFragment$initData$1(this.this$0, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            ForYouFragment forYouFragment = this.this$0;
            Lifecycle.State state = Lifecycle.State.CREATED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(forYouFragment, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(forYouFragment, state, anonymousClass1, this) == f) {
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
