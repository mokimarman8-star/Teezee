package com.transsion.home.adapter.suboperate.provider;

import com.transsion.edcation.CourseManager;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.adapter.suboperate.provider.SubFeedsEducationProvider;
import com.transsion.home.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.provider.SubFeedsEducationProvider$MyViewHolder$registerCourse$1", f = "SubFeedsEducationProvider.kt", l = {168}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubFeedsEducationProvider$MyViewHolder$registerCourse$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SubFeedsEducationProvider.MyViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubFeedsEducationProvider$MyViewHolder$registerCourse$1(SubFeedsEducationProvider.MyViewHolder myViewHolder, Continuation<? super SubFeedsEducationProvider$MyViewHolder$registerCourse$1> continuation) {
        super(2, continuation);
        this.this$0 = myViewHolder;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubFeedsEducationProvider$MyViewHolder$registerCourse$1(this.this$0, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            w0 j = CourseManager.a.j();
            final SubFeedsEducationProvider.MyViewHolder myViewHolder = this.this$0;
            kotlinx.coroutines.flow.b bVar = new kotlinx.coroutines.flow.b() { // from class: com.transsion.home.adapter.suboperate.provider.SubFeedsEducationProvider$MyViewHolder$registerCourse$1.1

                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
                @DebugMetadata(c = "com.transsion.home.adapter.suboperate.provider.SubFeedsEducationProvider$MyViewHolder$registerCourse$1$1$1", f = "SubFeedsEducationProvider.kt", l = {}, m = "invokeSuspend")
                /* renamed from: com.transsion.home.adapter.suboperate.provider.SubFeedsEducationProvider$MyViewHolder$registerCourse$1$1$1, reason: invalid class name and collision with other inner class name */
                static final class C00291 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
                    int label;
                    final /* synthetic */ SubFeedsEducationProvider.MyViewHolder this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00291(SubFeedsEducationProvider.MyViewHolder myViewHolder, Continuation<? super C00291> continuation) {
                        super(2, continuation);
                        this.this$0 = myViewHolder;
                    }

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C00291(this.this$0, continuation);
                    }

                    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
                        return create(n0Var, continuation).invokeSuspend(Unit.a);
                    }

                    public final Object invokeSuspend(Object obj) {
                        IntrinsicsKt.f();
                        if (this.label != 0) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                        this.this$0.k();
                        return Unit.a;
                    }
                }

                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(CourseBean courseBean, Continuation continuation) {
                    OperateItem operateItem;
                    OperateItem operateItem2;
                    Subject feedsSubject;
                    Subject feedsSubject2;
                    operateItem = SubFeedsEducationProvider.MyViewHolder.this.mCurrentItem;
                    if (!Intrinsics.c((operateItem == null || (feedsSubject2 = operateItem.getFeedsSubject()) == null) ? null : feedsSubject2.getSubjectId(), courseBean.getSubjectId())) {
                        return Unit.a;
                    }
                    operateItem2 = SubFeedsEducationProvider.MyViewHolder.this.mCurrentItem;
                    if (operateItem2 != null && (feedsSubject = operateItem2.getFeedsSubject()) != null) {
                        feedsSubject.setSeenStatus(Boxing.d(courseBean.getSeenStatus()));
                    }
                    Object g = kotlinx.coroutines.i.g(y0.c(), new C00291(SubFeedsEducationProvider.MyViewHolder.this, null), continuation);
                    return g == IntrinsicsKt.f() ? g : Unit.a;
                }
            };
            this.label = 1;
            if (j.a(bVar, this) == f) {
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
