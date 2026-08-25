package com.transsion.home.adapter.suboperate.provider;

import com.transsion.edcation.CourseManager;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.RankingListData;
import com.transsion.home.bean.RankingListItem;
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
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.provider.SubRankListProvider$registerCourse$1", f = "SubRankListProvider.kt", l = {147}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class SubRankListProvider$registerCourse$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SubRankListProvider this$0;

    /* renamed from: com.transsion.home.adapter.suboperate.provider.SubRankListProvider$registerCourse$1$1, reason: invalid class name */
    static final class AnonymousClass1 implements kotlinx.coroutines.flow.b {
        final /* synthetic */ SubRankListProvider a;

        AnonymousClass1(SubRankListProvider subRankListProvider) {
            this.a = subRankListProvider;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007e -> B:10:0x008b). Please report as a decompilation issue!!! */
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(CourseBean courseBean, Continuation continuation) {
            SubRankListProvider$registerCourse$1$1$emit$1 subRankListProvider$registerCourse$1$1$emit$1;
            int i;
            OperateItem operateItem;
            RankingListData rankingListData;
            List<RankingListItem> items;
            SubRankListProvider subRankListProvider;
            Iterator it;
            int i2;
            if (continuation instanceof SubRankListProvider$registerCourse$1$1$emit$1) {
                subRankListProvider$registerCourse$1$1$emit$1 = (SubRankListProvider$registerCourse$1$1$emit$1) continuation;
                int i3 = subRankListProvider$registerCourse$1$1$emit$1.label;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    subRankListProvider$registerCourse$1$1$emit$1.label = i3 - Integer.MIN_VALUE;
                    Object obj = subRankListProvider$registerCourse$1$1$emit$1.result;
                    Object f = IntrinsicsKt.f();
                    i = subRankListProvider$registerCourse$1$1$emit$1.label;
                    if (i != 0) {
                        ResultKt.b(obj);
                        operateItem = this.a.g;
                        if (operateItem != null && (rankingListData = operateItem.getRankingListData()) != null && (items = rankingListData.getItems()) != null) {
                            subRankListProvider = this.a;
                            it = items.iterator();
                            i2 = 0;
                            while (it.hasNext()) {
                            }
                        }
                        return Unit.a;
                    }
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i4 = subRankListProvider$registerCourse$1$1$emit$1.I$1;
                    int i5 = subRankListProvider$registerCourse$1$1$emit$1.I$0;
                    Iterator it2 = (Iterator) subRankListProvider$registerCourse$1$1$emit$1.L$3;
                    Iterator it3 = (Iterator) subRankListProvider$registerCourse$1$1$emit$1.L$2;
                    SubRankListProvider subRankListProvider2 = (SubRankListProvider) subRankListProvider$registerCourse$1$1$emit$1.L$1;
                    CourseBean courseBean2 = (CourseBean) subRankListProvider$registerCourse$1$1$emit$1.L$0;
                    ResultKt.b(obj);
                    while (it2.hasNext()) {
                        Subject subject = (Subject) it2.next();
                        if (Intrinsics.c(courseBean2.getSubjectId(), subject.getSubjectId())) {
                            subject.setSeenStatus(Boxing.d(courseBean2.getSeenStatus()));
                            a2 c = y0.c();
                            SubRankListProvider$registerCourse$1$1$1$1$1 subRankListProvider$registerCourse$1$1$1$1$1 = new SubRankListProvider$registerCourse$1$1$1$1$1(subRankListProvider2, i4, subject, null);
                            subRankListProvider$registerCourse$1$1$emit$1.L$0 = courseBean2;
                            subRankListProvider$registerCourse$1$1$emit$1.L$1 = subRankListProvider2;
                            subRankListProvider$registerCourse$1$1$emit$1.L$2 = it3;
                            subRankListProvider$registerCourse$1$1$emit$1.L$3 = it2;
                            subRankListProvider$registerCourse$1$1$emit$1.I$0 = i5;
                            subRankListProvider$registerCourse$1$1$emit$1.I$1 = i4;
                            subRankListProvider$registerCourse$1$1$emit$1.label = 1;
                            if (kotlinx.coroutines.i.g(c, subRankListProvider$registerCourse$1$1$1$1$1, subRankListProvider$registerCourse$1$1$emit$1) == f) {
                                return f;
                            }
                        }
                    }
                    i2 = i5;
                    it = it3;
                    subRankListProvider = subRankListProvider2;
                    courseBean = courseBean2;
                    while (it.hasNext()) {
                        Object next = it.next();
                        int i6 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt.u();
                        }
                        List<Subject> subjects = ((RankingListItem) next).getSubjects();
                        if (subjects != null) {
                            courseBean2 = courseBean;
                            i4 = i2;
                            it2 = subjects.iterator();
                            it3 = it;
                            subRankListProvider2 = subRankListProvider;
                            i5 = i6;
                            while (it2.hasNext()) {
                            }
                            i2 = i5;
                            it = it3;
                            subRankListProvider = subRankListProvider2;
                            courseBean = courseBean2;
                            while (it.hasNext()) {
                            }
                        } else {
                            i2 = i6;
                        }
                    }
                    return Unit.a;
                }
            }
            subRankListProvider$registerCourse$1$1$emit$1 = new SubRankListProvider$registerCourse$1$1$emit$1(this, continuation);
            Object obj2 = subRankListProvider$registerCourse$1$1$emit$1.result;
            Object f2 = IntrinsicsKt.f();
            i = subRankListProvider$registerCourse$1$1$emit$1.label;
            if (i != 0) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SubRankListProvider$registerCourse$1(SubRankListProvider subRankListProvider, Continuation<? super SubRankListProvider$registerCourse$1> continuation) {
        super(2, continuation);
        this.this$0 = subRankListProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubRankListProvider$registerCourse$1(this.this$0, continuation);
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
