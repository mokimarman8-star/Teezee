package com.transsion.rewardscenter.task.ad;

import com.tencent.mmkv.MMKV;
import com.transsion.rewardscenter.task.ad.v;
import com.transsion.rewardscenterapi.MemberTaskItem;
import com.transsion.rewardscenterapi.TaskType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class u {
    private static v.c c;
    private static MemberTaskItem f;
    private static MemberTaskItem g;
    private static MemberTaskItem h;
    private static MemberTaskItem i;
    private static MemberTaskItem j;
    public static final u a = new u();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.task.ad.t
        public final Object invoke() {
            MMKV o;
            o = u.o();
            return o;
        }
    });
    private static List d = CollectionsKt.l();
    private static List e = CollectionsKt.l();
    public static final int k = 8;

    private u() {
    }

    private final MMKV f() {
        return (MMKV) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV o() {
        return MMKV.I("StageTaskAdCache");
    }

    public final void b(v vVar, MemberTaskItem memberTaskItem) {
        if (memberTaskItem == null) {
            return;
        }
        MemberTaskItem memberTaskItem2 = f;
        Pair a2 = TuplesKt.a(memberTaskItem2 != null ? memberTaskItem2.getTaskId() : null, f);
        MemberTaskItem memberTaskItem3 = g;
        Pair a3 = TuplesKt.a(memberTaskItem3 != null ? memberTaskItem3.getTaskId() : null, g);
        MemberTaskItem memberTaskItem4 = h;
        Pair a4 = TuplesKt.a(memberTaskItem4 != null ? memberTaskItem4.getTaskId() : null, h);
        MemberTaskItem memberTaskItem5 = j;
        Pair a5 = TuplesKt.a(memberTaskItem5 != null ? memberTaskItem5.getTaskId() : null, j);
        MemberTaskItem memberTaskItem6 = i;
        MemberTaskItem memberTaskItem7 = (MemberTaskItem) MapsKt.l(new Pair[]{a2, a3, a4, a5, TuplesKt.a(memberTaskItem6 != null ? memberTaskItem6.getTaskId() : null, i)}).get(memberTaskItem.getTaskId());
        if (memberTaskItem7 != null) {
            memberTaskItem7.setProgress(memberTaskItem.getProgress());
            memberTaskItem7.setTotalProgress(memberTaskItem.getTotalProgress());
            memberTaskItem7.setStatus(memberTaskItem.getStatus());
        }
        Integer totalProgress = memberTaskItem.getTotalProgress();
        if (totalProgress != null) {
            int intValue = totalProgress.intValue();
            Integer progress = memberTaskItem.getProgress();
            r0 = intValue - (progress != null ? progress.intValue() : 0);
        }
        if (r0 <= 0) {
            p(vVar);
        }
    }

    public final boolean c(String str, String str2) {
        Intrinsics.h(str, "sceneId");
        Intrinsics.h(str2, "packageName");
        int hashCode = str.hashCode();
        if (hashCode != 1154212438) {
            if (hashCode != 1383510840) {
                if (hashCode == 2139474598 && str.equals("MemberCenterStageNativeScene")) {
                    v.c cVar = c;
                    List e2 = CollectionsKt.e(cVar != null ? cVar.i() : null);
                    if (!(e2 instanceof Collection) || !e2.isEmpty()) {
                        Iterator it = e2.iterator();
                        while (it.hasNext()) {
                            if (Intrinsics.c((String) it.next(), str2)) {
                                return true;
                            }
                        }
                    }
                    List list = e;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : list) {
                        if (((v.a) obj).k()) {
                            arrayList.add(obj);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            if (Intrinsics.c(((v.a) it2.next()).i(), str2)) {
                                return true;
                            }
                        }
                    }
                }
            } else if (str.equals("MemberTaskRegularNativeScene")) {
                v.c cVar2 = c;
                List e3 = CollectionsKt.e(cVar2 != null ? cVar2.i() : null);
                if (!(e3 instanceof Collection) || !e3.isEmpty()) {
                    Iterator it3 = e3.iterator();
                    while (it3.hasNext()) {
                        if (Intrinsics.c((String) it3.next(), str2)) {
                            return true;
                        }
                    }
                }
                List list2 = d;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator it4 = list2.iterator();
                    while (it4.hasNext()) {
                        if (Intrinsics.c(((v.c) it4.next()).i(), str2)) {
                            return true;
                        }
                    }
                }
                List list3 = e;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : list3) {
                    if (((v.a) obj2).k()) {
                        arrayList2.add(obj2);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    Iterator it5 = arrayList2.iterator();
                    while (it5.hasNext()) {
                        if (Intrinsics.c(((v.a) it5.next()).i(), str2)) {
                            return true;
                        }
                    }
                }
            }
        } else if (str.equals("MemberTaskStageNativeScene")) {
            List list4 = d;
            if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                Iterator it6 = list4.iterator();
                while (it6.hasNext()) {
                    if (Intrinsics.c(((v.c) it6.next()).i(), str2)) {
                        return true;
                    }
                }
            }
            List list5 = e;
            ArrayList arrayList3 = new ArrayList();
            for (Object obj3 : list5) {
                if (((v.a) obj3).k()) {
                    arrayList3.add(obj3);
                }
            }
            if (!arrayList3.isEmpty()) {
                Iterator it7 = arrayList3.iterator();
                while (it7.hasNext()) {
                    if (Intrinsics.c(((v.a) it7.next()).i(), str2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final List d() {
        return e;
    }

    public final List e() {
        return d;
    }

    public final MemberTaskItem g() {
        return i;
    }

    public final MemberTaskItem h() {
        return h;
    }

    public final MemberTaskItem i() {
        return j;
    }

    public final MemberTaskItem j() {
        return f;
    }

    public final MemberTaskItem k() {
        return g;
    }

    public final AdTaskState l(String str) {
        if (str == null) {
            return null;
        }
        int i2 = f().getInt("task_state_" + str, -1);
        if (i2 != -1) {
            return (AdTaskState) AdTaskState.getEntries().get(i2);
        }
        return null;
    }

    public final boolean m(String str, String str2) {
        boolean z;
        Intrinsics.h(str, "sceneId");
        boolean z2 = true;
        boolean z3 = false;
        if (str2 != null) {
            u uVar = a;
            boolean c2 = uVar.c(str, str2);
            z = uVar.n(str2);
            if (!StringsKt.q0(str2) && !c2 && !z) {
                z2 = false;
            }
            z3 = c2;
        } else {
            z = false;
        }
        a.a.f(wf.a.a, "StageTaskAd", "isFiltered = " + z2 + ", packageName: " + str2 + ", isDuplicate: " + z3 + ", isInCooldown: " + z, false, 4, (Object) null);
        return z2;
    }

    public final boolean n(String str) {
        Intrinsics.h(str, "packageName");
        MMKV f2 = f();
        StringBuilder sb = new StringBuilder();
        sb.append("package_cooldown_");
        sb.append(str);
        return System.currentTimeMillis() < f2.getLong(sb.toString(), 0L);
    }

    public final void p(v vVar) {
        ArrayList arrayList;
        AdTaskState e2;
        if (vVar instanceof v.c) {
            v.c cVar = c;
            if (cVar != null && (e2 = cVar.e()) != null && e2.ordinal() < AdTaskState.CLAIMED_STAGE1.ordinal()) {
                c = null;
            }
            List list = d;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (((v.c) obj).e().ordinal() >= AdTaskState.CLAIMED_STAGE1.ordinal()) {
                    arrayList2.add(obj);
                }
            }
            d = arrayList2;
            return;
        }
        if (vVar instanceof v.a) {
            if (((v.a) vVar).k()) {
                List list2 = e;
                arrayList = new ArrayList();
                for (Object obj2 : list2) {
                    if (!((v.a) obj2).k()) {
                        arrayList.add(obj2);
                    }
                }
            } else {
                List list3 = e;
                arrayList = new ArrayList();
                for (Object obj3 : list3) {
                    if (((v.a) obj3).k()) {
                        arrayList.add(obj3);
                    }
                }
            }
            e = arrayList;
        }
    }

    public final void q(v.a aVar) {
        Intrinsics.h(aVar, "item");
        List list = e;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!Intrinsics.c((v.a) obj, aVar)) {
                arrayList.add(obj);
            }
        }
        e = arrayList;
    }

    public final void r(List list) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Intrinsics.h(list, "taskInfos");
        List list2 = list;
        Iterator it = list2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            Integer taskSubType = ((MemberTaskItem) obj2).getTaskSubType();
            int value = TaskType.AD_STAGE_1ST.getValue();
            if (taskSubType != null && taskSubType.intValue() == value) {
                break;
            }
        }
        f = (MemberTaskItem) obj2;
        Iterator it2 = list2.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it2.next();
            Integer taskSubType2 = ((MemberTaskItem) obj3).getTaskSubType();
            int value2 = TaskType.AD_STAGE_2ND.getValue();
            if (taskSubType2 != null && taskSubType2.intValue() == value2) {
                break;
            }
        }
        g = (MemberTaskItem) obj3;
        Iterator it3 = list2.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj4 = null;
                break;
            }
            obj4 = it3.next();
            Integer taskSubType3 = ((MemberTaskItem) obj4).getTaskSubType();
            int value3 = TaskType.AD_REGULAR_PULL_NEW.getValue();
            if (taskSubType3 != null && taskSubType3.intValue() == value3) {
                break;
            }
        }
        h = (MemberTaskItem) obj4;
        Iterator it4 = list2.iterator();
        while (true) {
            if (!it4.hasNext()) {
                obj5 = null;
                break;
            }
            obj5 = it4.next();
            Integer taskSubType4 = ((MemberTaskItem) obj5).getTaskSubType();
            int value4 = TaskType.AD_REGULAR_PULL_LIVE.getValue();
            if (taskSubType4 != null && taskSubType4.intValue() == value4) {
                break;
            }
        }
        i = (MemberTaskItem) obj5;
        Iterator it5 = list2.iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            Integer taskSubType5 = ((MemberTaskItem) next).getTaskSubType();
            int value5 = TaskType.AD_REWARD.getValue();
            if (taskSubType5 != null && taskSubType5.intValue() == value5) {
                obj = next;
                break;
            }
        }
        j = (MemberTaskItem) obj;
    }

    public final void s(List list) {
        Intrinsics.h(list, "<set-?>");
        e = list;
    }

    public final void t(List list) {
        Intrinsics.h(list, "<set-?>");
        d = list;
    }

    public final void u(String str, Integer num) {
        Intrinsics.h(str, "packageName");
        long j2 = 60;
        long currentTimeMillis = System.currentTimeMillis() + ((num != null ? num.intValue() : 3L) * 24 * j2 * j2 * 1000);
        f().putLong("package_cooldown_" + str, currentTimeMillis);
    }

    public final void v(String str, AdTaskState adTaskState) {
        Intrinsics.h(adTaskState, "adTaskState");
        if (str == null) {
            return;
        }
        f().putInt("task_state_" + str, adTaskState.ordinal());
    }
}
