package com.transsion.home.adapter.suboperate.provider;

import com.transsion.edcation.CourseManager;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.OperateItem;
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
import kotlinx.coroutines.a2;
import kotlinx.coroutines.flow.w0;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.provider.SubRankingProvider$registerCourse$1", f = "SubRankingProvider.kt", l = {113}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubRankingProvider$registerCourse$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SubRankingProvider this$0;

    /* renamed from: com.transsion.home.adapter.suboperate.provider.SubRankingProvider$registerCourse$1$1, reason: invalid class name */
    static final class AnonymousClass1 implements kotlinx.coroutines.flow.b {
        final /* synthetic */ SubRankingProvider a;

        AnonymousClass1(SubRankingProvider subRankingProvider) {
            this.a = subRankingProvider;
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
            SubRankingProvider$registerCourse$1$1$emit$1 subRankingProvider$registerCourse$1$1$emit$1;
            int i;
            OperateItem operateItem;
            List<Subject> rankings;
            int i2;
            Iterator it;
            SubRankingProvider subRankingProvider;
            if (continuation instanceof SubRankingProvider$registerCourse$1$1$emit$1) {
                subRankingProvider$registerCourse$1$1$emit$1 = (SubRankingProvider$registerCourse$1$1$emit$1) continuation;
                int i3 = subRankingProvider$registerCourse$1$1$emit$1.label;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    subRankingProvider$registerCourse$1$1$emit$1.label = i3 - Integer.MIN_VALUE;
                    Object obj = subRankingProvider$registerCourse$1$1$emit$1.result;
                    Object f = IntrinsicsKt.f();
                    i = subRankingProvider$registerCourse$1$1$emit$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        operateItem = this.a.g;
                        if (operateItem != null && (rankings = operateItem.getRankings()) != null) {
                            SubRankingProvider subRankingProvider2 = this.a;
                            i2 = 0;
                            it = rankings.iterator();
                            subRankingProvider = subRankingProvider2;
                            while (it.hasNext()) {
                            }
                        }
                        return Unit.a;
                    }
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i4 = subRankingProvider$registerCourse$1$1$emit$1.I$0;
                    it = (Iterator) subRankingProvider$registerCourse$1$1$emit$1.L$2;
                    SubRankingProvider subRankingProvider3 = (SubRankingProvider) subRankingProvider$registerCourse$1$1$emit$1.L$1;
                    CourseBean courseBean2 = (CourseBean) subRankingProvider$registerCourse$1$1$emit$1.L$0;
                    ResultKt.b(obj);
                    subRankingProvider = subRankingProvider3;
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
                            a2 c = y0.c();
                            SubRankingProvider$registerCourse$1$1$1$1 subRankingProvider$registerCourse$1$1$1$1 = new SubRankingProvider$registerCourse$1$1$1$1(subRankingProvider, i2, courseBean, null);
                            subRankingProvider$registerCourse$1$1$emit$1.L$0 = courseBean;
                            subRankingProvider$registerCourse$1$1$emit$1.L$1 = subRankingProvider;
                            subRankingProvider$registerCourse$1$1$emit$1.L$2 = it;
                            subRankingProvider$registerCourse$1$1$emit$1.I$0 = i5;
                            subRankingProvider$registerCourse$1$1$emit$1.label = 1;
                            if (kotlinx.coroutines.i.g(c, subRankingProvider$registerCourse$1$1$1$1, subRankingProvider$registerCourse$1$1$emit$1) == f) {
                                return f;
                            }
                            courseBean2 = courseBean;
                            subRankingProvider3 = subRankingProvider;
                            i4 = i5;
                            subRankingProvider = subRankingProvider3;
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
            subRankingProvider$registerCourse$1$1$emit$1 = new SubRankingProvider$registerCourse$1$1$emit$1(this, continuation);
            Object obj2 = subRankingProvider$registerCourse$1$1$emit$1.result;
            Object f2 = IntrinsicsKt.f();
            i = subRankingProvider$registerCourse$1$1$emit$1.label;
            if (i != 0) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubRankingProvider$registerCourse$1(SubRankingProvider subRankingProvider, Continuation<? super SubRankingProvider$registerCourse$1> continuation) {
        super(2, continuation);
        this.this$0 = subRankingProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubRankingProvider$registerCourse$1(this.this$0, continuation);
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
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0);
            this.label = 1;
            if (j.a(anonymousClass1, this) == f) {
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
