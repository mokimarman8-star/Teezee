package com.google.firebase.sessions;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.google.android.gms.common.util.ProcessUtils;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class q {
    public static final q a = new q();

    private q() {
    }

    private final p a(String str, int i, int i2, boolean z) {
        return new p(str, i, i2, z);
    }

    static /* synthetic */ p b(q qVar, String str, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        if ((i3 & 8) != 0) {
            z = false;
        }
        return qVar.a(str, i, i2, z);
    }

    public final List c(Context context) {
        Intrinsics.h(context, "context");
        int i = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? activityManager.getRunningAppProcesses() : null;
        if (runningAppProcesses == null) {
            runningAppProcesses = CollectionsKt.l();
        }
        List f0 = CollectionsKt.f0(runningAppProcesses);
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList = new ArrayList();
        for (Object obj : f0) {
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(arrayList, 10));
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList) {
            String str2 = runningAppProcessInfo.processName;
            Intrinsics.g(str2, "runningAppProcessInfo.processName");
            arrayList2.add(new p(str2, runningAppProcessInfo.pid, runningAppProcessInfo.importance, Intrinsics.c(runningAppProcessInfo.processName, str)));
        }
        return arrayList2;
    }

    public final p d(Context context) {
        Object obj;
        Intrinsics.h(context, "context");
        int myPid = Process.myPid();
        Iterator it = c(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((p) obj).b() == myPid) {
                break;
            }
        }
        p pVar = (p) obj;
        return pVar == null ? b(this, e(), myPid, 0, false, 12, null) : pVar;
    }

    public final String e() {
        String a2;
        String myProcessName;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            myProcessName = Process.myProcessName();
            Intrinsics.g(myProcessName, "myProcessName()");
            return myProcessName;
        }
        if (i >= 28 && (a2 = com.apm.insight.l.o.a()) != null) {
            return a2;
        }
        String myProcessName2 = ProcessUtils.getMyProcessName();
        return myProcessName2 != null ? myProcessName2 : TtmlNode.ANONYMOUS_REGION_ID;
    }
}
