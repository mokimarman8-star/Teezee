package mw;

import com.therouter.TheRouter;
import com.transsion.memberapi.MemberAdTaskInfo;
import com.transsion.memberapi.MemberTaskInfo;
import com.transsion.memberapi.MemberTaskItem;
import com.transsion.memberapi.MemberTaskRewardInfo;
import com.transsion.memberapi.TaskRewards;
import im.d;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f {
    public static final f a = new f();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: mw.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            im.b o;
            o = f.o();
            return o;
        }
    });

    public static final class a implements im.d {
        final /* synthetic */ Function1 a;

        a(Function1 function1) {
            this.a = function1;
        }

        public void a(MemberAdTaskInfo memberAdTaskInfo, boolean z) {
            MemberTaskItem memberTaskItem;
            List list;
            Object obj;
            if (memberAdTaskInfo == null || (list = memberAdTaskInfo.getList()) == null) {
                memberTaskItem = null;
            } else {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    Integer taskSubType = ((MemberTaskItem) obj).getTaskSubType();
                    if (taskSubType != null && taskSubType.intValue() == 19) {
                        break;
                    }
                }
                memberTaskItem = (MemberTaskItem) obj;
            }
            a.a aVar = wf.a.a;
            f fVar = f.a;
            a.a.g(aVar, fVar.l() + " --> fetchAdTaskInfo() --> 获取任务列表 -- taskId = " + (memberTaskItem != null ? memberTaskItem.getTaskId() : null), false, 2, (Object) null);
            if (memberTaskItem != null) {
                String taskId = memberTaskItem.getTaskId();
                if (taskId == null) {
                    taskId = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                fVar.h(taskId, this.a);
                return;
            }
            Function1 function1 = this.a;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        }

        public void b(MemberTaskInfo memberTaskInfo, boolean z) {
            d.a.b(this, memberTaskInfo, z);
        }
    }

    private f() {
    }

    private final void g(Function1 function1) {
        im.b m = m();
        if (m != null) {
            m.s(new a(function1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String str, final Function1 function1) {
        MemberTaskItem memberTaskItem = new MemberTaskItem(str, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (List) null, (List) null, (MemberTaskRewardInfo) null, (Integer) null, (Integer) null, (String) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (Object) null, 16777214, (DefaultConstructorMarker) null);
        a.a.g(wf.a.a, l() + " --> fetchAdTaskReward() --> 领取激活广告任务奖励 -- taskId = " + str, false, 2, (Object) null);
        im.b m = m();
        if (m != null) {
            m.k(memberTaskItem, new Function2() { // from class: mw.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit i;
                    i = f.i(Function1.this, (String) obj, (String) obj2);
                    return i;
                }
            }, new Function1() { // from class: mw.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit k;
                    k = f.k(Function1.this, (TaskRewards) obj);
                    return k;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(final Function1 function1, String str, String str2) {
        new Function0() { // from class: mw.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit j;
                j = f.j(Function1.this);
                return j;
            }
        };
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Function1 function1) {
        if (function1 == null) {
            return null;
        }
        function1.invoke(Boolean.FALSE);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Function1 function1, TaskRewards taskRewards) {
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l() {
        String simpleName = f.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final im.b m() {
        return (im.b) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final im.b o() {
        return (im.b) TheRouter.d(im.b.class, new Object[0]);
    }

    public final void n(Function1 function1) {
        g(function1);
    }
}
