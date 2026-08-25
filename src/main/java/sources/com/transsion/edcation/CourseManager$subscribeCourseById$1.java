package com.transsion.edcation;

import android.util.Log;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.edcation.bean.CourseBody;
import com.transsion.edcation.c;
import com.transsion.gslb.BuildConfig;
import dg.d;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.m;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import yx.h;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", BuildConfig.FLAVOR, "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.edcation.CourseManager$subscribeCourseById$1", f = "CourseManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class CourseManager$subscribeCourseById$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $status;
    final /* synthetic */ String $subjectId;
    int label;

    static final class a implements h {
        public static final a a = new a();

        a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m apply(Throwable th2) {
            Intrinsics.h(th2, "it");
            return j.l(th2);
        }
    }

    public static final class b extends dg.a {
        final /* synthetic */ int d;
        final /* synthetic */ String e;

        b(int i, String str) {
            this.d = i;
            this.e = str;
        }

        public void a(String str, String str2) {
            StringBuilder sb = new StringBuilder();
            sb.append("error: ");
            sb.append(str);
            sb.append(", msg:");
            sb.append(str2);
            com.tn.lib.widget.toast.core.h.a.k(R$string.course_default_failed);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(String str) {
            super.c(str);
            StringBuilder sb = new StringBuilder();
            sb.append("data:");
            sb.append(str);
            int i = this.d;
            if (i == 0) {
                CourseManager.a.p(new CourseBean(this.e, null, i, null, null, null, null, null, null, 0L, null, 2042, null));
                com.tn.lib.widget.toast.core.h.a.k(R$string.course_remove_success);
            } else {
                CourseManager.r(CourseManager.a, null, this.e, 1, null);
                com.tn.lib.widget.toast.core.h.a.k(R$string.course_add_success);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CourseManager$subscribeCourseById$1(Integer num, String str, Continuation<? super CourseManager$subscribeCourseById$1> continuation) {
        super(2, continuation);
        this.$status = num;
        this.$subjectId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CourseManager$subscribeCourseById$1(this.$status, this.$subjectId, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Unit unit;
        int i;
        c k;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Integer num = this.$status;
        String str = this.$subjectId;
        try {
            Result.Companion companion = Result.Companion;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        if (num != null && num.intValue() == 0) {
            i = 1;
            k = CourseManager.a.k();
            c.a.d(k, null, new CourseBody(str, i), 1, null).v(ey.a.c()).x(a.a).f(d.a.c()).subscribe(new b(i, str));
            obj2 = Result.constructor-impl(Unit.a);
            unit = (Unit) (Result.isFailure-impl(obj2) ? null : obj2);
            if (unit != null) {
                Log.e("subscribeCourse", "error: " + unit);
            }
            return Unit.a;
        }
        i = 0;
        k = CourseManager.a.k();
        c.a.d(k, null, new CourseBody(str, i), 1, null).v(ey.a.c()).x(a.a).f(d.a.c()).subscribe(new b(i, str));
        obj2 = Result.constructor-impl(Unit.a);
        unit = (Unit) (Result.isFailure-impl(obj2) ? null : obj2);
        if (unit != null) {
        }
        return Unit.a;
    }
}
