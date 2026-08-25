package com.transsion.edcation;

import android.util.Log;
import com.transsion.edcation.bean.CourseBody;
import com.transsion.edcation.c;
import com.transsion.gslb.BuildConfig;
import com.transsion.moviedetailapi.bean.Subject;
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
@DebugMetadata(c = "com.transsion.edcation.CourseManager$subscribeCourse$1", f = "CourseManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class CourseManager$subscribeCourse$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Subject $course;
    final /* synthetic */ Boolean $subscribeStatus;
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
        final /* synthetic */ Subject d;
        final /* synthetic */ int e;

        b(Subject subject, int i) {
            this.d = subject;
            this.e = i;
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
            this.d.setSeenStatus(Integer.valueOf(this.e));
            CourseManager.a.p(dk.a.a(this.d));
            if (this.e == 1) {
                com.tn.lib.widget.toast.core.h.a.k(R$string.course_add_success);
            } else {
                com.tn.lib.widget.toast.core.h.a.k(R$string.course_remove_success);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CourseManager$subscribeCourse$1(Subject subject, Boolean bool, Continuation<? super CourseManager$subscribeCourse$1> continuation) {
        super(2, continuation);
        this.$course = subject;
        this.$subscribeStatus = bool;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CourseManager$subscribeCourse$1(this.$course, this.$subscribeStatus, continuation);
    }

    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return create(n0Var, continuation).invokeSuspend(Unit.a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String subjectId;
        c k;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Subject subject = this.$course;
        Boolean bool = this.$subscribeStatus;
        try {
            Result.Companion companion = Result.Companion;
            subjectId = subject.getSubjectId();
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.a(th2));
        }
        if (subjectId == null) {
            return Unit.a;
        }
        ?? r3 = 0;
        r3 = 0;
        if (bool != null) {
            r3 = bool.booleanValue();
        } else {
            Integer seenStatus = subject.getSeenStatus();
            if (seenStatus != null && seenStatus.intValue() == 0) {
                r3 = 1;
            }
        }
        k = CourseManager.a.k();
        c.a.d(k, null, new CourseBody(subjectId, r3), 1, null).v(ey.a.c()).x(a.a).f(d.a.c()).subscribe(new b(subject, r3));
        obj2 = Result.constructor-impl(Unit.a);
        Unit unit = (Unit) (Result.isFailure-impl(obj2) ? null : obj2);
        if (unit != null) {
            Log.e("subscribeCourse", "error: " + unit);
        }
        return Unit.a;
    }
}
