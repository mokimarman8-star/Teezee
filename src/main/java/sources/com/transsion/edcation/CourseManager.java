package com.transsion.edcation;

import androidx.fragment.app.FragmentManager;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.edcation.bean.CourseListResp;
import com.transsion.edcation.c;
import com.transsion.edcation.dialog.InterestSelectDialog;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.push.bean.MsgStyle;
import dg.d;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.w0;
import kotlinx.coroutines.flow.x0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import yx.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class CourseManager implements n0 {
    private static t1 i;
    public static final CourseManager a = new CourseManager();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.edcation.a
        public final Object invoke() {
            c o;
            o = CourseManager.o();
            return o;
        }
    });
    private static final Lazy c = LazyKt.b(new Function0() { // from class: com.transsion.edcation.b
        public final Object invoke() {
            boolean n;
            n = CourseManager.n();
            return Boolean.valueOf(n);
        }
    });
    private static boolean d = true;
    private static final w0 e = c1.b(0, 0, (BufferOverflow) null, 7, (Object) null);
    private static final x0 f = i1.a((Object) null);
    private static final x0 g = i1.a(new ArrayList());
    private static final w0 h = c1.b(0, 0, (BufferOverflow) null, 7, (Object) null);
    private static final CoroutineContext j = y0.b().plus(l2.b((t1) null, 1, (Object) null));

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

    private CourseManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c k() {
        return (c) b.getValue();
    }

    private final boolean m() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n() {
        return com.transsion.baselib.report.launch.b.a.b().getBoolean("edu_interest_dialog", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c o() {
        return (c) kg.c.e.a().h(c.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(CourseBean courseBean) {
        t1 t1Var = i;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        i = i.d(this, (CoroutineContext) null, (CoroutineStart) null, new CourseManager$notifyCourse$1(courseBean, null), 3, (Object) null);
    }

    public static /* synthetic */ void r(CourseManager courseManager, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = MsgStyle.CUSTOM_LEFT_PIC;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        courseManager.q(str, str2);
    }

    public static /* synthetic */ void u(CourseManager courseManager, Subject subject, Boolean bool, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bool = null;
        }
        courseManager.t(subject, bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object w(CourseBean courseBean, Continuation continuation) {
        CourseManager$updateCourse$1 courseManager$updateCourse$1;
        Object f2;
        int i2;
        CourseBean courseBean2;
        List list;
        Object obj;
        x0 x0Var;
        CourseBean courseBean3;
        if (continuation instanceof CourseManager$updateCourse$1) {
            courseManager$updateCourse$1 = (CourseManager$updateCourse$1) continuation;
            int i3 = courseManager$updateCourse$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                courseManager$updateCourse$1.label = i3 - Integer.MIN_VALUE;
                Object obj2 = courseManager$updateCourse$1.result;
                f2 = IntrinsicsKt.f();
                i2 = courseManager$updateCourse$1.label;
                if (i2 != 0) {
                    ResultKt.b(obj2);
                    List list2 = (List) g.getValue();
                    if (list2 != null) {
                        Iterator it = list2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            }
                            obj = it.next();
                            if (Intrinsics.c(((CourseBean) obj).getSubjectId(), courseBean.getSubjectId())) {
                                break;
                            }
                        }
                        courseBean2 = (CourseBean) obj;
                    } else {
                        courseBean2 = null;
                    }
                    if (courseBean2 != null) {
                        Boxing.a(list2.remove(courseBean2));
                    }
                    if (courseBean.getSeenStatus() == 1 && list2 != null) {
                        list2.add(0, courseBean);
                    }
                    x0 x0Var2 = g;
                    courseManager$updateCourse$1.L$0 = list2;
                    courseManager$updateCourse$1.label = 1;
                    if (x0Var2.emit(list2, courseManager$updateCourse$1) == f2) {
                        return f2;
                    }
                    list = list2;
                } else {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj2);
                        return Unit.a;
                    }
                    list = (List) courseManager$updateCourse$1.L$0;
                    ResultKt.b(obj2);
                }
                x0Var = f;
                courseBean3 = list == null ? (CourseBean) CollectionsKt.k0(list) : null;
                courseManager$updateCourse$1.L$0 = null;
                courseManager$updateCourse$1.label = 2;
                if (x0Var.emit(courseBean3, courseManager$updateCourse$1) == f2) {
                    return f2;
                }
                return Unit.a;
            }
        }
        courseManager$updateCourse$1 = new CourseManager$updateCourse$1(this, continuation);
        Object obj22 = courseManager$updateCourse$1.result;
        f2 = IntrinsicsKt.f();
        i2 = courseManager$updateCourse$1.label;
        if (i2 != 0) {
        }
        x0Var = f;
        if (list == null) {
        }
        courseManager$updateCourse$1.L$0 = null;
        courseManager$updateCourse$1.label = 2;
        if (x0Var.emit(courseBean3, courseManager$updateCourse$1) == f2) {
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(List list, String str) {
        i.d(this, (CoroutineContext) null, (CoroutineStart) null, new CourseManager$updateCourseList$1(str, list, null), 3, (Object) null);
    }

    public final void g(FragmentManager fragmentManager) {
        Intrinsics.h(fragmentManager, "fragmentManager");
        if (m() && d) {
            new InterestSelectDialog().show(fragmentManager, "InterestSelectDialog");
        }
    }

    public CoroutineContext getCoroutineContext() {
        return j;
    }

    public final x0 h() {
        return g;
    }

    public final w0 i() {
        return h;
    }

    public final w0 j() {
        return e;
    }

    public final x0 l() {
        return f;
    }

    public final void q(final String str, final String str2) {
        Intrinsics.h(str, "page");
        c.a.b(k(), null, str, 0, 5, null).v(ey.a.c()).x(a.a).f(d.a.c()).subscribe(new dg.a() { // from class: com.transsion.edcation.CourseManager$refreshCourseList$2
            public void a(String str3, String str4) {
                StringBuilder sb = new StringBuilder();
                sb.append("error: ");
                sb.append(str3);
                sb.append(", msg:");
                sb.append(str4);
            }

            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void c(CourseListResp courseListResp) {
                List<CourseBean> items;
                List<CourseBean> items2;
                super.c(courseListResp);
                List list = null;
                Integer valueOf = (courseListResp == null || (items2 = courseListResp.getItems()) == null) ? null : Integer.valueOf(items2.size());
                StringBuilder sb = new StringBuilder();
                sb.append("list is empty: ");
                sb.append(valueOf);
                CourseManager courseManager = CourseManager.a;
                i.d(courseManager, (CoroutineContext) null, (CoroutineStart) null, new CourseManager$refreshCourseList$2$onSuccess$1(courseListResp, str2, null), 3, (Object) null);
                if (courseListResp != null && (items = courseListResp.getItems()) != null) {
                    list = CollectionsKt.U0(items);
                }
                courseManager.x(list, str);
            }
        });
    }

    public final void s(boolean z) {
        d = z;
    }

    public final void t(Subject subject, Boolean bool) {
        if (subject == null) {
            return;
        }
        i.d(this, (CoroutineContext) null, (CoroutineStart) null, new CourseManager$subscribeCourse$1(subject, bool, null), 3, (Object) null);
    }

    public final void v(String str, Integer num) {
        if (str == null) {
            return;
        }
        i.d(this, (CoroutineContext) null, (CoroutineStart) null, new CourseManager$subscribeCourseById$1(num, str, null), 3, (Object) null);
    }
}
