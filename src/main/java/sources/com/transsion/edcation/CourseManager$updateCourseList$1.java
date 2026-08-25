package com.transsion.edcation;

import com.transsion.edcation.bean.CourseBean;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.MsgStyle;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.x0;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.edcation.CourseManager$updateCourseList$1", f = "CourseManager.kt", l = {220, 221}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class CourseManager$updateCourseList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<CourseBean> $list;
    final /* synthetic */ String $page;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CourseManager$updateCourseList$1(String str, List<CourseBean> list, Continuation<? super CourseManager$updateCourseList$1> continuation) {
        super(2, continuation);
        this.$page = str;
        this.$list = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CourseManager$updateCourseList$1(this.$page, this.$list, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    public final Object invokeSuspend(Object obj) {
        List<CourseBean> list;
        List<CourseBean> list2;
        Object f = IntrinsicsKt.f();
        int i = this.label;
        if (i == 0) {
            ResultKt.b(obj);
            if (Intrinsics.c(this.$page, MsgStyle.CUSTOM_LEFT_PIC)) {
                list = this.$list;
            } else {
                list = (List) CourseManager.a.h().getValue();
                if (list == null) {
                    list = new ArrayList<>();
                }
                List<CourseBean> list3 = this.$list;
                if (list3 != null) {
                    list.addAll(list3);
                }
            }
            list2 = list;
            x0 h = CourseManager.a.h();
            this.L$0 = list2;
            this.label = 1;
            if (h.emit(list2, this) == f) {
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
            list2 = (List) this.L$0;
            ResultKt.b(obj);
        }
        x0 l = CourseManager.a.l();
        CourseBean courseBean = list2 != null ? (CourseBean) CollectionsKt.k0(list2) : null;
        this.L$0 = null;
        this.label = 2;
        if (l.emit(courseBean, this) == f) {
            return f;
        }
        return Unit.a;
    }
}
