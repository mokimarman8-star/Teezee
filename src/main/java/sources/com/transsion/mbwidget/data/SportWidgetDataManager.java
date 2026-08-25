package com.transsion.mbwidget.data;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.blankj.utilcode.util.o;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.gslb.GslbSdk;
import com.transsion.mbwidget.data.a;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.h1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.x0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class SportWidgetDataManager {
    private static volatile long b;
    private static volatile boolean c;
    private static SportMatch e;
    private static final x0 f;
    private static final h1 g;
    public static final SportWidgetDataManager a = new SportWidgetDataManager();
    private static final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.mbwidget.data.e
        public final Object invoke() {
            a n;
            n = SportWidgetDataManager.n();
            return n;
        }
    });

    static {
        x0 a2 = i1.a((Object) null);
        f = a2;
        g = a2;
    }

    private SportWidgetDataManager() {
    }

    private final void d() {
        b = 0L;
        int i = Build.VERSION.SDK_INT;
        Context a2 = i >= 24 ? androidx.profileinstaller.b.a(GslbSdk.context) : GslbSdk.context;
        Intent intent = new Intent(a2, (Class<?>) SportWidgetRefreshReceiver.class);
        intent.setAction("com.transsion.mbwidget.ACTION_MATCH_REFRESH");
        PendingIntent broadcast = PendingIntent.getBroadcast(a2, 202603051, intent, i >= 31 ? 201326592 : 134217728);
        Object systemService = a2.getSystemService("alarm");
        AlarmManager alarmManager = systemService instanceof AlarmManager ? (AlarmManager) systemService : null;
        if (alarmManager != null) {
            alarmManager.cancel(broadcast);
        }
        wf.a.a.c("SportWidget", "Cancel match refresh alarm", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        e = null;
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new SportWidgetDataManager$forceRefresh$1(null), 3, (Object) null);
    }

    private final SportMatch i() {
        try {
            String string = com.transsion.mbwidget.d.a.k().getString("sport_widget_match_cache", (String) null);
            if (string != null) {
                return (SportMatch) o.d(string, SportMatch.class);
            }
            return null;
        } catch (Exception e2) {
            a.a.k(wf.a.a, "SportWidget", "Get cached match error: " + e2.getMessage(), e2, false, 8, (Object) null);
            return null;
        }
    }

    private final a j() {
        return (a) d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a n() {
        return (a) kg.c.e.a().h(a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a0 A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:12:0x003a, B:13:0x008d, B:17:0x00a0, B:19:0x00aa, B:21:0x00b2, B:22:0x00b6, B:24:0x00d4, B:26:0x00dc, B:27:0x011a, B:40:0x0104, B:42:0x0111), top: B:11:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00aa A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:12:0x003a, B:13:0x008d, B:17:0x00a0, B:19:0x00aa, B:21:0x00b2, B:22:0x00b6, B:24:0x00d4, B:26:0x00dc, B:27:0x011a, B:40:0x0104, B:42:0x0111), top: B:11:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0111 A[Catch: all -> 0x003e, TryCatch #1 {all -> 0x003e, blocks: (B:12:0x003a, B:13:0x008d, B:17:0x00a0, B:19:0x00aa, B:21:0x00b2, B:22:0x00b6, B:24:0x00d4, B:26:0x00dc, B:27:0x011a, B:40:0x0104, B:42:0x0111), top: B:11:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object q(Continuation continuation) {
        SportWidgetDataManager$requestMatch$1 sportWidgetDataManager$requestMatch$1;
        int i;
        Ref.ObjectRef objectRef;
        Ref.BooleanRef booleanRef;
        SportWidgetDataManager sportWidgetDataManager;
        Object obj;
        Throwable th2;
        BaseDto baseDto;
        BffMatchData bffMatchData;
        if (continuation instanceof SportWidgetDataManager$requestMatch$1) {
            sportWidgetDataManager$requestMatch$1 = (SportWidgetDataManager$requestMatch$1) continuation;
            int i2 = sportWidgetDataManager$requestMatch$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                sportWidgetDataManager$requestMatch$1.label = i2 - Integer.MIN_VALUE;
                SportWidgetDataManager$requestMatch$1 sportWidgetDataManager$requestMatch$12 = sportWidgetDataManager$requestMatch$1;
                Object obj2 = sportWidgetDataManager$requestMatch$12.result;
                Object f2 = IntrinsicsKt.f();
                i = sportWidgetDataManager$requestMatch$12.label;
                if (i != 0) {
                    ResultKt.b(obj2);
                    if (c) {
                        a.a.f(wf.a.a, "SportWidget", "[Lab] requestMatch started (laboratory trigger)", false, 4, (Object) null);
                        c = false;
                    }
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                    try {
                        Result.Companion companion = Result.Companion;
                        wf.a.a.c("SportWidget", "Request match from API...", true);
                        a j = j();
                        sportWidgetDataManager$requestMatch$12.L$0 = objectRef2;
                        sportWidgetDataManager$requestMatch$12.L$1 = booleanRef2;
                        sportWidgetDataManager$requestMatch$12.L$2 = this;
                        sportWidgetDataManager$requestMatch$12.label = 1;
                        obj2 = a.C0037a.a(j, null, null, sportWidgetDataManager$requestMatch$12, 3, null);
                        if (obj2 == f2) {
                            return f2;
                        }
                        sportWidgetDataManager = this;
                        objectRef = objectRef2;
                        booleanRef = booleanRef2;
                    } catch (Throwable th3) {
                        th = th3;
                        objectRef = objectRef2;
                        booleanRef = booleanRef2;
                        Result.Companion companion2 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.a(th));
                        th2 = Result.exceptionOrNull-impl(obj);
                        if (th2 != null) {
                        }
                        if (objectRef.element == null) {
                        }
                        return objectRef.element;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    sportWidgetDataManager = (SportWidgetDataManager) sportWidgetDataManager$requestMatch$12.L$2;
                    booleanRef = (Ref.BooleanRef) sportWidgetDataManager$requestMatch$12.L$1;
                    objectRef = (Ref.ObjectRef) sportWidgetDataManager$requestMatch$12.L$0;
                    try {
                        ResultKt.b(obj2);
                    } catch (Throwable th4) {
                        th = th4;
                        Result.Companion companion22 = Result.Companion;
                        obj = Result.constructor-impl(ResultKt.a(th));
                        th2 = Result.exceptionOrNull-impl(obj);
                        if (th2 != null) {
                        }
                        if (objectRef.element == null) {
                        }
                        return objectRef.element;
                    }
                }
                baseDto = (BaseDto) obj2;
                if (Intrinsics.c(baseDto.getCode(), "0")) {
                    baseDto = null;
                }
                bffMatchData = baseDto == null ? (BffMatchData) baseDto.getData() : null;
                if (bffMatchData == null) {
                    a.a aVar = wf.a.a;
                    List<ServerMatchItem> list = bffMatchData.getList();
                    aVar.c("SportWidget", "API request success, data list size: " + (list != null ? list.size() : 0), true);
                    ServerMatchItem a2 = c.a(bffMatchData.getList());
                    SportMatch b2 = a2 != null ? c.b(a2) : null;
                    if (b2 != null) {
                        sportWidgetDataManager.r(b2);
                        e = b2;
                        f.setValue(b2);
                        aVar.c("SportWidget", "Request match success: " + b2.getMatchId(), true);
                        sportWidgetDataManager.s(b2);
                        objectRef.element = b2;
                    } else {
                        aVar.c("SportWidget", "No valid match from API response (conversion failed or empty list)", true);
                        e = null;
                        f.setValue((Object) null);
                    }
                } else {
                    wf.a.a.c("SportWidget", "API response failed, need fallback", true);
                    booleanRef.element = true;
                }
                obj = Result.constructor-impl(Unit.a);
                th2 = Result.exceptionOrNull-impl(obj);
                if (th2 != null) {
                    a.a.k(wf.a.a, "SportWidget", "Request match error: " + th2.getMessage(), th2, false, 8, (Object) null);
                    booleanRef.element = true;
                }
                if (objectRef.element == null && booleanRef.element) {
                    wf.a.a.c("SportWidget", "API failed, use fallback data (cache > mock)", true);
                    objectRef.element = t();
                }
                return objectRef.element;
            }
        }
        sportWidgetDataManager$requestMatch$1 = new SportWidgetDataManager$requestMatch$1(this, continuation);
        SportWidgetDataManager$requestMatch$1 sportWidgetDataManager$requestMatch$122 = sportWidgetDataManager$requestMatch$1;
        Object obj22 = sportWidgetDataManager$requestMatch$122.result;
        Object f22 = IntrinsicsKt.f();
        i = sportWidgetDataManager$requestMatch$122.label;
        if (i != 0) {
        }
        baseDto = (BaseDto) obj22;
        if (Intrinsics.c(baseDto.getCode(), "0")) {
        }
        if (baseDto == null) {
        }
        if (bffMatchData == null) {
        }
        obj = Result.constructor-impl(Unit.a);
        th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
        }
        if (objectRef.element == null) {
            wf.a.a.c("SportWidget", "API failed, use fallback data (cache > mock)", true);
            objectRef.element = t();
        }
        return objectRef.element;
    }

    private final void r(SportMatch sportMatch) {
        try {
            com.transsion.mbwidget.d.a.k().putString("sport_widget_match_cache", o.j(sportMatch));
        } catch (Exception e2) {
            a.a.k(wf.a.a, "SportWidget", "Save cache error: " + e2.getMessage(), e2, false, 8, (Object) null);
        }
    }

    private final void s(SportMatch sportMatch) {
        if (sportMatch.getStatus() == MatchStatus.NOT_START && sportMatch.getMatchTime() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long matchTime = sportMatch.getMatchTime() + 300000;
            long j = matchTime - currentTimeMillis;
            if (j <= 0) {
                wf.a.a.c("SportWidget", "Skip scheduleMatchRefresh: triggerAt=" + matchTime + ", now=" + currentTimeMillis + ", delta=" + j + ", matchId=" + sportMatch.getMatchId() + ", status=" + sportMatch.getStatus(), true);
                return;
            }
            long j2 = b;
            if (currentTimeMillis + 1 <= j2 && j2 < matchTime) {
                wf.a.a.c("SportWidget", "Skip scheduleMatchRefresh: keep earlier alarm at " + j2 + ", new trigger " + matchTime + " is later, matchId=" + sportMatch.getMatchId(), true);
                return;
            }
            int i = Build.VERSION.SDK_INT;
            Context a2 = i >= 24 ? androidx.profileinstaller.b.a(GslbSdk.context) : GslbSdk.context;
            Intent intent = new Intent(a2, (Class<?>) SportWidgetRefreshReceiver.class);
            intent.setAction("com.transsion.mbwidget.ACTION_MATCH_REFRESH");
            PendingIntent broadcast = PendingIntent.getBroadcast(a2, 202603051, intent, i >= 31 ? 201326592 : 134217728);
            Object systemService = a2.getSystemService("alarm");
            AlarmManager alarmManager = systemService instanceof AlarmManager ? (AlarmManager) systemService : null;
            if (alarmManager != null) {
                alarmManager.setAndAllowWhileIdle(0, matchTime, broadcast);
                b = matchTime;
            }
            wf.a.a.c("SportWidget", "Schedule match refresh at " + matchTime + " (in " + j + "ms), matchId=" + sportMatch.getMatchId(), true);
        }
    }

    private final SportMatch t() {
        a.a aVar = wf.a.a;
        aVar.c("SportWidget", "Using fallback data...", true);
        SportMatch i = i();
        if (i == null) {
            aVar.c("SportWidget", "Mock fallback disabled, return null to show Fallback UI", true);
            return null;
        }
        aVar.c("SportWidget", "Use cached match as fallback: " + i.getMatchId(), true);
        e = i;
        f.setValue(i);
        s(i);
        return i;
    }

    public final void e() {
        e = null;
        f.setValue((Object) null);
    }

    public final Object g(Continuation continuation) {
        wf.a.a.c("SportWidget", "Force refresh for match change (periodic or after match start)", true);
        Object q = q(continuation);
        return q == IntrinsicsKt.f() ? q : Unit.a;
    }

    public final void h() {
        c = true;
        wf.a.a.c("SportWidget", "[Lab] forceRefresh triggered from Laboratory", true);
        f();
    }

    public final Object k(Continuation continuation) {
        if (e == null) {
            return q(continuation);
        }
        a.a aVar = wf.a.a;
        SportMatch sportMatch = e;
        aVar.c("SportWidget", "Return memory cached match: " + (sportMatch != null ? sportMatch.getMatchId() : null), true);
        return e;
    }

    public final boolean l(SportMatch sportMatch) {
        return sportMatch != null && d.a.a(sportMatch);
    }

    public final boolean m(SportMatch sportMatch) {
        return sportMatch != null && d.a.b(sportMatch);
    }

    public final void o() {
        wf.a.a.c("SportWidget", "All sport widgets removed, clear memory and persistent cache", true);
        d();
        e = null;
        f.setValue((Object) null);
        try {
            com.transsion.mbwidget.d.a.k().remove("sport_widget_match_cache");
        } catch (Exception e2) {
            a.a.k(wf.a.a, "SportWidget", "Clear persistent cache error: " + e2.getMessage(), e2, false, 8, (Object) null);
        }
    }

    public final void p() {
        wf.a.a.c("SportWidget", "Refresh on user click (likely viewing live match)", true);
        kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new SportWidgetDataManager$refreshOnUserClick$1(null), 3, (Object) null);
    }
}
