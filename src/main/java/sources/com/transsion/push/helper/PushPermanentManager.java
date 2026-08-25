package com.transsion.push.helper;

import android.app.Application;
import android.text.format.DateUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.bean.PermanentConfig;
import com.transsion.push.bean.PermanentItemBean;
import com.transsion.push.bean.PushConfigHelper;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class PushPermanentManager {
    private static PermanentConfig d;
    private static String e;
    private static t1 g;
    private static long i;
    public static final PushPermanentManager a = new PushPermanentManager();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.push.helper.f
        public final Object invoke() {
            to.b u;
            u = PushPermanentManager.u();
            return u;
        }
    });
    private static CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    private static boolean f = true;
    private static String h = BuildConfig.FLAVOR;

    private PushPermanentManager() {
    }

    private final void n(long j) {
        wf.a.a.c("PUSH_SHOW", "checkRequest time:" + j + ", lastTime:" + (System.currentTimeMillis() - i) + ", hash:" + PushConfigHelper.INSTANCE.getHashTime(), true);
        if (System.currentTimeMillis() - i >= j) {
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final to.b r() {
        return (to.b) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean t() {
        return DateUtils.isToday(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final to.b u() {
        return (to.b) kg.c.e.a().h(to.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        PermanentConfig permanentConfig = d;
        if (permanentConfig != null) {
            if (!permanentConfig.getEnable() || !w(permanentConfig)) {
                return;
            }
            if (permanentConfig.getInterval() > 0) {
                n((long) ((permanentConfig.getInterval() + PushConfigHelper.INSTANCE.getHashTime()) * 60 * 1000));
            }
        }
        PushPermanentShowHelper pushPermanentShowHelper = PushPermanentShowHelper.a;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        pushPermanentShowHelper.p(a2, CollectionsKt.f0(c));
    }

    private final boolean w(PermanentConfig permanentConfig) {
        List l;
        try {
            Result.Companion companion = Result.Companion;
            String startTime = permanentConfig.getStartTime();
            if (startTime == null) {
                return true;
            }
            List split = new Regex(":").split(startTime, 0);
            if (!split.isEmpty()) {
                ListIterator listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (((String) listIterator.previous()).length() != 0) {
                        l = CollectionsKt.K0(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            l = CollectionsKt.l();
            String[] strArr = (String[]) l.toArray(new String[0]);
            int parseInt = Integer.parseInt(strArr[0]);
            int parseInt2 = Integer.parseInt(strArr[1]);
            Calendar calendar = Calendar.getInstance();
            int i2 = calendar.get(11);
            int i3 = calendar.get(12);
            a.a.f(wf.a.a, "PUSH_SHOW", "timeReady, cur:" + i2 + ":" + i3 + ",time:" + parseInt, false, 4, (Object) null);
            if (i2 <= parseInt) {
                return i2 == parseInt && i3 >= parseInt2;
            }
            return true;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
            return true;
        }
    }

    public final void o() {
        if (PushConfigHelper.INSTANCE.isAbType()) {
            kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PushPermanentManager$checkShow$1(null), 3, (Object) null);
        }
    }

    public final void p(String str) {
        Object obj;
        Intrinsics.h(str, "deepLink");
        wf.a.a.c("PUSH_SHOW", "clickMsg deeplink:" + str + ",pushCacheList:" + c.size(), true);
        Iterator it = c.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            PermanentItemBean permanentItemBean = (PermanentItemBean) obj;
            if (Intrinsics.c(permanentItemBean != null ? permanentItemBean.getDeeplink() : null, str)) {
                break;
            }
        }
        PermanentItemBean permanentItemBean2 = (PermanentItemBean) obj;
        if (permanentItemBean2 == null) {
            return;
        }
        c.remove(permanentItemBean2);
        if (c.size() < 10) {
            q();
        } else {
            v();
        }
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PushPermanentManager$clickMsg$1(permanentItemBean2, null), 3, (Object) null);
    }

    public final void q() {
        t1 t1Var = g;
        if (t1Var != null) {
            t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
        }
        g = kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new PushPermanentManager$fetchPushData$1(null), 3, (Object) null);
    }

    public final String s() {
        return h;
    }
}
