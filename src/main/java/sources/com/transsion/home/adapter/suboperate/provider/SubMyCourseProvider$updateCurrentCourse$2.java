package com.transsion.home.adapter.suboperate.provider;

import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.gslb.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.provider.SubMyCourseProvider$updateCurrentCourse$2", f = "SubMyCourseProvider.kt", l = {140, 148}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubMyCourseProvider$updateCurrentCourse$2 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SubMyCourseProvider this$0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.home.adapter.suboperate.provider.SubMyCourseProvider$updateCurrentCourse$2$1", f = "SubMyCourseProvider.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.home.adapter.suboperate.provider.SubMyCourseProvider$updateCurrentCourse$2$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $percent;
        int label;
        final /* synthetic */ SubMyCourseProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SubMyCourseProvider subMyCourseProvider, float f, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = subMyCourseProvider;
            this.$percent = f;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$percent, continuation);
        }

        public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
            return create(n0Var, continuation).invokeSuspend(Unit.a);
        }

        public final Object invokeSuspend(Object obj) {
            BaseViewHolder baseViewHolder;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            SubMyCourseProvider subMyCourseProvider = this.this$0;
            baseViewHolder = subMyCourseProvider.g;
            subMyCourseProvider.U(baseViewHolder, RangesKt.g(this.$percent, 100.0f));
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubMyCourseProvider$updateCurrentCourse$2(SubMyCourseProvider subMyCourseProvider, Continuation<? super SubMyCourseProvider$updateCurrentCourse$2> continuation) {
        super(2, continuation);
        this.this$0 = subMyCourseProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubMyCourseProvider$updateCurrentCourse$2(this.this$0, continuation);
    }

    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        VideoDetailPlayDao O;
        CourseBean courseBean;
        String str;
        CourseBean courseBean2;
        Integer durationSeconds;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            O = this.this$0.O();
            courseBean = this.this$0.h;
            if (courseBean == null || (str = courseBean.getSubjectId()) == null) {
                str = BuildConfig.FLAVOR;
            }
            this.label = 1;
            obj = O.g(str, this);
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
        Long l = (Long) obj;
        long longValue = l != null ? l.longValue() : 0L;
        courseBean2 = this.this$0.h;
        int intValue = (courseBean2 == null || (durationSeconds = courseBean2.getDurationSeconds()) == null) ? 0 : durationSeconds.intValue();
        float f2 = intValue > 0 ? ((longValue * 1.0f) / intValue) / 10.0f : 0.0f;
        a2 c = y0.c();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, f2, null);
        this.label = 2;
        if (kotlinx.coroutines.i.g(c, anonymousClass1, this) == f) {
            return f;
        }
        return Unit.a;
    }
}
