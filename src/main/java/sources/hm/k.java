package hm;

import android.os.Handler;
import android.os.Looper;
import com.blankj.utilcode.util.Utils;
import com.tencent.mmkv.MMKV;
import com.therouter.TheRouter;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadException;
import com.transsion.member.constants.TaskType;
import com.transsion.member.w;
import com.transsion.memberapi.MemberTaskGroup;
import com.transsion.memberapi.MemberTaskInfo;
import com.transsion.memberapi.MemberTaskItem;
import com.transsnet.downloader.manager.p;
import com.transsnet.loginapi.bean.UserInfo;
import ij.a0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import qx.b;
import ui.m0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k {
    public static final k a;
    private static final qx.a b;
    private static final List c;
    private static long d;
    private static long e;
    private static long f;
    private static long g;
    private static final List h;
    private static final kk.a i;
    private static boolean j;
    private static MemberTaskItem k;
    private static long l;
    private static final b m;
    private static final c n;
    private static final Handler o;
    private static final Runnable p;
    public static final int q;

    public static final class a implements com.transsion.baselib.report.k$a {
        final /* synthetic */ MemberTaskItem a;

        a(MemberTaskItem memberTaskItem) {
            this.a = memberTaskItem;
        }

        @Override // com.transsion.baselib.report.k$a
        public void onBackgroundStatusChange(boolean z) {
            if (z) {
                return;
            }
            hm.c cVar = new hm.c();
            Integer rewardAmount = this.a.getRewardAmount();
            cVar.g(rewardAmount != null ? rewardAmount.intValue() : 0);
            com.transsion.baselib.report.k.a.t(this);
        }
    }

    public static final class b implements m0 {
        b() {
        }

        @Override // ui.m0
        public void a(DownloadBean downloadBean, DownloadException downloadException) {
            Intrinsics.h(downloadBean, "bean");
        }

        @Override // ui.m0
        public void b(DownloadBean downloadBean) {
            Intrinsics.h(downloadBean, "bean");
        }

        @Override // ui.m0
        public void c(DownloadBean downloadBean, long j, long j2) {
            Intrinsics.h(downloadBean, "bean");
        }

        @Override // ui.m0
        public void d(DownloadBean downloadBean) {
            Intrinsics.h(downloadBean, "bean");
        }

        @Override // ui.m0
        public void e(DownloadBean downloadBean, String str) {
            Intrinsics.h(downloadBean, "bean");
            a.a.f(wf.a.a, "TaskManager", "download success " + downloadBean, false, 4, (Object) null);
            k kVar = k.a;
            kVar.m();
            kVar.c0(downloadBean.getSubjectType());
        }

        @Override // ui.m0
        public void f(DownloadBean downloadBean) {
            Intrinsics.h(downloadBean, "bean");
        }

        @Override // ui.m0
        public void g(DownloadBean downloadBean) {
            Intrinsics.h(downloadBean, "bean");
        }
    }

    public static final class c implements qx.b {
        c() {
        }

        public void onLogin(UserInfo userInfo) {
            Intrinsics.h(userInfo, "user");
            k kVar = k.a;
            kVar.x();
            kVar.K();
            kVar.y();
        }

        public void onLogout() {
            k kVar = k.a;
            kVar.x();
            kVar.K();
            kVar.y();
        }

        public void onUpdateUserInfo(UserInfo userInfo) {
            b.a.c(this, userInfo);
        }
    }

    static {
        k kVar = new k();
        a = kVar;
        b = (qx.a) TheRouter.d(qx.a.class, new Object[0]);
        c = new ArrayList();
        h = new ArrayList();
        i = (kk.a) TheRouter.d(kk.a.class, new Object[0]);
        kVar.K();
        m = new b();
        n = new c();
        o = new Handler(Looper.getMainLooper());
        p = new Runnable() { // from class: hm.d
            @Override // java.lang.Runnable
            public final void run() {
                k.A();
            }
        };
        q = 8;
    }

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A() {
        a.z();
    }

    private final boolean B(String str, boolean z) {
        UserInfo i2;
        MMKV b2 = w.a.b();
        qx.a aVar = b;
        return b2.getBoolean(str + "_" + ((aVar == null || (i2 = aVar.i()) == null) ? null : i2.getUserId()), z);
    }

    private final int E(String str, int i2) {
        UserInfo i3;
        MMKV b2 = w.a.b();
        qx.a aVar = b;
        return b2.getInt(str + "_" + ((aVar == null || (i3 = aVar.i()) == null) ? null : i3.getUserId()), i2);
    }

    private final long F(String str, long j2) {
        UserInfo i2;
        MMKV b2 = w.a.b();
        qx.a aVar = b;
        return b2.getLong(str + "_" + ((aVar == null || (i2 = aVar.i()) == null) ? null : i2.getUserId()), j2);
    }

    private final long J() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(11, 4);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        a0.b.a().d(new Runnable() { // from class: hm.g
            @Override // java.lang.Runnable
            public final void run() {
                k.L();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L() {
        k kVar = a;
        long J = kVar.J();
        if (kVar.F("kv_watch_remember_time", 0L) > J) {
            e = J;
            long F = kVar.F("kv_watch_today_time", 0L);
            d = F;
            g = F;
            a.a.f(wf.a.a, "TaskManager", "init watch time " + d, false, 4, (Object) null);
        }
    }

    private final void M() {
        kk.a aVar = i;
        if (aVar != null) {
            aVar.b(j);
        }
    }

    private final void P(String str, boolean z) {
        UserInfo i2;
        MMKV b2 = w.a.b();
        qx.a aVar = b;
        b2.putBoolean(str + "_" + ((aVar == null || (i2 = aVar.i()) == null) ? null : i2.getUserId()), z);
    }

    private final void Q(String str, int i2) {
        UserInfo i3;
        MMKV b2 = w.a.b();
        qx.a aVar = b;
        b2.putInt(str + "_" + ((aVar == null || (i3 = aVar.i()) == null) ? null : i3.getUserId()), i2);
    }

    private final void R(String str, long j2) {
        UserInfo i2;
        MMKV b2 = w.a.b();
        qx.a aVar = b;
        b2.putLong(str + "_" + ((aVar == null || (i2 = aVar.i()) == null) ? null : i2.getUserId()), j2);
    }

    private final void U() {
        a0.b.a().d(new Runnable() { // from class: hm.f
            @Override // java.lang.Runnable
            public final void run() {
                k.V();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V() {
        k kVar = a;
        long J = kVar.J();
        long F = kVar.F("kv_watch_remember_time", 0L);
        if (1 <= F && F < J) {
            a.a.f(wf.a.a, "TaskManager", "clear last day time " + d, false, 4, (Object) null);
            d = 30000L;
        }
        kVar.s();
        e = J;
        g = d;
        kVar.R("kv_watch_remember_time", System.currentTimeMillis());
        kVar.R("kv_watch_today_time", d);
        a.a.f(wf.a.a, "TaskManager", "save watch time " + d, false, 4, (Object) null);
    }

    private final void Z() {
        p.a aVar = p.a;
        com.transsnet.downloader.manager.g a2 = aVar.a(Utils.a());
        b bVar = m;
        a2.k(bVar);
        aVar.a(Utils.a()).g(bVar);
        qx.a aVar2 = b;
        if (aVar2 != null) {
            aVar2.j(n);
        }
        if (aVar2 != null) {
            aVar2.e(n);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
    
        if (r2.intValue() == 1) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void b0(MemberTaskItem memberTaskItem) {
        Integer status = memberTaskItem.getStatus();
        boolean z = status != null;
        j = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(int i2) {
        kk.a aVar;
        if (j && (aVar = i) != null) {
            aVar.f(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        a0.b.a().d(new Runnable() { // from class: hm.i
            @Override // java.lang.Runnable
            public final void run() {
                k.n();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n() {
        k kVar = a;
        long J = kVar.J();
        long F = kVar.F("kv_watch_download_save_time", 0L);
        int i2 = 0;
        int E = kVar.E("kv_watch_download_count", 0);
        if (1 > F || F >= J) {
            i2 = E;
        } else {
            a.a.f(wf.a.a, "TaskManager", "clear download count", false, 4, (Object) null);
        }
        kVar.q(i2);
        kVar.R("kv_watch_download_save_time", System.currentTimeMillis());
        kVar.Q("kv_watch_download_count", i2 + 1);
        a.a.f(wf.a.a, "TaskManager", "save download count " + d, false, 4, (Object) null);
    }

    private final void o() {
        MemberTaskItem memberTaskItem;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = l;
        long j3 = currentTimeMillis - j2;
        long j4 = 0;
        if (j2 <= 0 || j3 <= 0) {
            return;
        }
        long J = J();
        long F = F("kv_game_browse_remember_time", 0L);
        long F2 = j3 + F("kv_game_browse_today_time", 0L);
        boolean B = B("kv_game_browse_complete", false);
        if (J > F) {
            P("kv_game_browse_complete", false);
            B = false;
        } else {
            j4 = F2;
        }
        R("kv_game_browse_remember_time", System.currentTimeMillis());
        if (B || ((memberTaskItem = k) != null && memberTaskItem.isClaimCompleted())) {
            a.a.v(wf.a.a, "TaskManager", "游戏，统计浏览时长任务已经完成", false, 4, (Object) null);
            o.removeCallbacksAndMessages(null);
            return;
        }
        MemberTaskItem memberTaskItem2 = k;
        if (memberTaskItem2 != null) {
            long j5 = j4 / 1000;
            Intrinsics.e(memberTaskItem2);
            if (j5 >= (memberTaskItem2.getDurationCondition() != null ? r2.intValue() : 300000)) {
                P("kv_game_browse_complete", true);
                a.a.r(wf.a.a, "TaskManager", new String[]{"游戏，统计浏览时长，任务完成"}, false, 4, (Object) null);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: hm.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        k.p();
                    }
                });
                o.removeCallbacksAndMessages(null);
                R("kv_game_browse_today_time", j4);
            }
        }
        a.a aVar = wf.a.a;
        long j6 = j4 / 1000;
        MemberTaskItem memberTaskItem3 = k;
        a.a.r(aVar, "TaskManager", new String[]{"游戏，统计浏览时长，任务未完成，curDuration:" + j6 + ", target:" + (memberTaskItem3 != null ? memberTaskItem3.getDurationCondition() : null)}, false, 4, (Object) null);
        P("kv_game_browse_complete", false);
        R("kv_game_browse_today_time", j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p() {
        Integer rewardAmount;
        hm.c cVar = new hm.c();
        MemberTaskItem memberTaskItem = k;
        cVar.g((memberTaskItem == null || (rewardAmount = memberTaskItem.getRewardAmount()) == null) ? 0 : rewardAmount.intValue());
    }

    private final void q(int i2) {
        for (final MemberTaskItem memberTaskItem : h) {
            if (i2 == (memberTaskItem.getTimesCondition() != null ? r2.intValue() : 0) - 1) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: hm.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        k.r(MemberTaskItem.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(MemberTaskItem memberTaskItem) {
        com.transsion.baselib.report.k kVar = com.transsion.baselib.report.k.a;
        if (kVar.q()) {
            kVar.g(new a(memberTaskItem));
            return;
        }
        hm.c cVar = new hm.c();
        Integer rewardAmount = memberTaskItem.getRewardAmount();
        cVar.g(rewardAmount != null ? rewardAmount.intValue() : 0);
    }

    private final void s() {
        if (f == 0) {
            return;
        }
        for (final MemberTaskItem memberTaskItem : c) {
            Integer durationCondition = memberTaskItem.getDurationCondition();
            long j2 = 1000;
            long intValue = durationCondition != null ? durationCondition.intValue() : 0;
            if (g / j2 < intValue && d / j2 >= intValue) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: hm.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        k.t(MemberTaskItem.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(MemberTaskItem memberTaskItem) {
        hm.c cVar = new hm.c();
        Integer rewardAmount = memberTaskItem.getRewardAmount();
        cVar.g(rewardAmount != null ? rewardAmount.intValue() : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        d = 0L;
        e = 0L;
        f = 0L;
        g = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        im.b bVar = (im.b) TheRouter.d(im.b.class, new Object[0]);
        if (bVar != null) {
            bVar.f();
        }
    }

    private final void z() {
        o();
        l = System.currentTimeMillis();
        o.postDelayed(p, 15000L);
    }

    public final int C() {
        int i2 = 0;
        int E = E("kv_game_download_app_claim", 0);
        if (E <= 0) {
            return E;
        }
        long J = J();
        long F = F("kv_game_download_app_remember_time", 0L);
        if (1 > F || F >= J) {
            i2 = E;
        } else {
            a.a.v(wf.a.a, "TaskManager", "游戏app下载，跨天了，重置状态", false, 4, (Object) null);
        }
        R("kv_game_download_app_remember_time", System.currentTimeMillis());
        return i2;
    }

    public final long D() {
        long currentTimeMillis = System.currentTimeMillis() - l;
        long F = F("kv_game_browse_today_time", 0L);
        if (l <= 0 || currentTimeMillis <= 0) {
            currentTimeMillis = 0;
        }
        return (currentTimeMillis + F) / 60000;
    }

    public final int G() {
        long F = F("kv_watch_download_save_time", 0L);
        int E = E("kv_watch_download_count", 0);
        if (J() <= F) {
            return E;
        }
        u();
        return 0;
    }

    public final int H() {
        long F = F("kv_play_save_game_time", 0L);
        long F2 = F("kv_play_game_time", 0L);
        if (J() <= F) {
            return (int) (F2 / 1000);
        }
        w();
        return 0;
    }

    public final int I() {
        if (e != J()) {
            return 0;
        }
        return (int) (d / 60000);
    }

    public final void N(long j2) {
        d += j2 - f;
        f = 0L;
        U();
    }

    public final void O(long j2) {
        long j3 = f;
        if (j2 > j3) {
            d += j2 - j3;
        }
        f = j2;
        if (d - g > 60000) {
            U();
        }
    }

    public final void S(MemberTaskInfo memberTaskInfo) {
        List<MemberTaskGroup> arrayList;
        c.clear();
        h.clear();
        if (memberTaskInfo == null || (arrayList = memberTaskInfo.getList()) == null) {
            arrayList = new ArrayList<>();
        }
        Iterator<MemberTaskGroup> it = arrayList.iterator();
        while (it.hasNext()) {
            for (MemberTaskItem memberTaskItem : it.next().getTaskItems()) {
                Integer taskSubType = memberTaskItem.getTaskSubType();
                int value = TaskType.WATCH.getValue();
                if (taskSubType != null && taskSubType.intValue() == value) {
                    c.add(memberTaskItem);
                } else {
                    int value2 = TaskType.DOWNLOAD_MOVIE.getValue();
                    if (taskSubType != null && taskSubType.intValue() == value2) {
                        h.add(memberTaskItem);
                    } else {
                        int value3 = TaskType.GAME_RES_BROWSE.getValue();
                        if (taskSubType != null && taskSubType.intValue() == value3) {
                            k = memberTaskItem;
                        }
                    }
                }
            }
        }
        Z();
    }

    public final void T(List list) {
        c.clear();
        h.clear();
        if (list == null) {
            list = new ArrayList();
        }
        for (MemberTaskItem memberTaskItem : list) {
            Integer taskSubType = memberTaskItem.getTaskSubType();
            int value = TaskType.WATCH.getValue();
            if (taskSubType != null && taskSubType.intValue() == value) {
                c.add(memberTaskItem);
            } else {
                int value2 = TaskType.DOWNLOAD_MOVIE.getValue();
                if (taskSubType != null && taskSubType.intValue() == value2) {
                    h.add(memberTaskItem);
                } else {
                    int value3 = TaskType.PALM_PAY.getValue();
                    if (taskSubType != null && taskSubType.intValue() == value3) {
                        b0(memberTaskItem);
                    } else {
                        int value4 = TaskType.GAME_RES_BROWSE.getValue();
                        if (taskSubType != null && taskSubType.intValue() == value4) {
                            k = memberTaskItem;
                        } else {
                            a.a.f(wf.a.a, "TaskManager", "taskItem: " + memberTaskItem + " that is not support now, please check it.", false, 4, (Object) null);
                        }
                    }
                }
            }
        }
        M();
        Z();
    }

    public final void W() {
        a.a.f(wf.a.a, "TaskManager", "游戏下载任务完成", false, 4, (Object) null);
        R("kv_game_download_app_remember_time", System.currentTimeMillis());
        Q("kv_game_download_app_claim", 1);
    }

    public final void X(long j2) {
        if (j2 > H()) {
            R("kv_play_save_game_time", System.currentTimeMillis());
            R("kv_play_game_time", j2);
        }
    }

    public final void Y() {
        if (k == null) {
            return;
        }
        a.a.f(wf.a.a, "TaskManager", "游戏，startGameResDurationTracking", false, 4, (Object) null);
        l = System.currentTimeMillis();
        o.post(p);
    }

    public final void a0() {
        if (k == null) {
            return;
        }
        a.a.f(wf.a.a, "TaskManager", "游戏，stopGameResDurationTracking", false, 4, (Object) null);
        o();
        o.removeCallbacksAndMessages(null);
    }

    public final void u() {
        R("kv_watch_download_save_time", System.currentTimeMillis());
        Q("kv_watch_download_count", 0);
    }

    public final void v() {
        R("kv_game_download_app_remember_time", System.currentTimeMillis());
        Q("kv_game_download_app_claim", 0);
    }

    public final void w() {
        R("kv_play_save_game_time", System.currentTimeMillis());
        R("kv_play_game_time", 0L);
    }
}
