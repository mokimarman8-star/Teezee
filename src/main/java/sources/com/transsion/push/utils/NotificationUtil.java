package com.transsion.push.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.coroutines.ExistingPeriodicWorkPolicy;
import androidx.coroutines.NetworkType;
import androidx.coroutines.WorkManager;
import androidx.media3.common.util.g0;
import androidx.work.b;
import androidx.work.m;
import cm.f;
import com.blankj.utilcode.util.o;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.therouter.TheRouter;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.baselib.db.notification.MsgConfig;
import com.transsion.baselib.db.notification.PullMsgResp;
import com.transsion.lib.push.R;
import com.transsion.lib.push.Receiver.NotificationReceiver;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.player.mediasession.g;
import com.transsion.push.bean.MsgStatus;
import com.transsion.push.bean.MsgType;
import com.transsion.push.bean.PushConfigHelper;
import com.transsion.push.bean.ShowOrder;
import com.transsion.push.helper.NotificationRefreshService;
import com.transsion.push.helper.NotificationShowHelper;
import com.transsion.push.helper.PushPermanentManager;
import com.transsion.push.helper.e;
import com.transsion.push.notification.ToolbarNotificationUtils;
import com.transsion.push.worker.PullWorker;
import com.transsion.push.worker.ReportWorker;
import com.transsion.push.worker.a;
import com.transsion.pushapi.TriggerSource;
import ij.v;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kg.c;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;
import to.b;
import wf.a;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class NotificationUtil {
    private static MsgConfig b;
    private static a c;
    public static final NotificationUtil a = new NotificationUtil();
    private static final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.push.utils.b0
        public final Object invoke() {
            c n;
            n = NotificationUtil.n();
            return n;
        }
    });
    private static final Lazy e = LazyKt.b(new Function0() { // from class: com.transsion.push.utils.c0
        public final Object invoke() {
            b S;
            S = NotificationUtil.S();
            return S;
        }
    });

    private NotificationUtil() {
    }

    public static /* synthetic */ void A(NotificationUtil notificationUtil, Context context, ShowOrder showOrder, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            showOrder = ShowOrder.CURRENT;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        notificationUtil.z(context, showOrder, str, z);
    }

    private final int B(List list, String str) {
        if (list.size() == 1) {
            return 0;
        }
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            MsgBean msgBean = (MsgBean) obj;
            if (msgBean != null && Intrinsics.c(msgBean.getMessageId(), str)) {
                return ((i + list.size()) - 1) % list.size();
            }
            i = i2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(Context context, TriggerSource triggerSource) {
        a.a.f(wf.a.a, "NotificationUtil", "get local notification begin", false, 4, (Object) null);
        i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new getLocalNotifications.1(context, (Continuation) null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b E() {
        return (b) e.getValue();
    }

    private final MsgBean F(int i, List list) {
        String startTime;
        String pushGap;
        if (list.isEmpty()) {
            return null;
        }
        MsgConfig msgConfig = b;
        int parseInt = (msgConfig == null || (pushGap = msgConfig.getPushGap()) == null) ? 2 : Integer.parseInt(pushGap);
        MsgConfig msgConfig2 = b;
        int parseInt2 = ((i - ((msgConfig2 == null || (startTime = msgConfig2.getStartTime()) == null) ? 7 : Integer.parseInt(startTime))) / parseInt) % list.size();
        if (parseInt2 < 0 || parseInt2 >= list.size()) {
            return null;
        }
        return (MsgBean) list.get(parseInt2);
    }

    private final int H(List list, String str) {
        if (list.size() == 1) {
            return 0;
        }
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            MsgBean msgBean = (MsgBean) obj;
            if (msgBean != null && Intrinsics.c(msgBean.getMessageId(), str)) {
                return ((i + list.size()) + 1) % list.size();
            }
            i = i2;
        }
        return 0;
    }

    public static /* synthetic */ String K(NotificationUtil notificationUtil, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = e.a.d();
        }
        return notificationUtil.J(str, i);
    }

    public static /* synthetic */ void Q(NotificationUtil notificationUtil, Context context, TriggerSource triggerSource, int i, Object obj) {
        if ((i & 2) != 0) {
            triggerSource = TriggerSource.APP_INNER;
        }
        notificationUtil.P(context, triggerSource);
    }

    private final void R(Context context, TriggerSource triggerSource) {
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new loadSeekSubjectMsg.1(context, triggerSource, (Continuation) null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b S() {
        return (b) c.e.a().h(b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(Context context, PullMsgResp pullMsgResp) {
        List<MsgBean> items = pullMsgResp.getItems();
        if (items != null) {
            for (MsgBean msgBean : items) {
                if (msgBean != null && !msgBean.getBuiltIn()) {
                    List i = NotificationShowHelper.a.i(msgBean);
                    if (!i.isEmpty()) {
                        a.V(context, (String) i.get(0));
                    }
                }
            }
        }
    }

    private final void V(Context context, String str) {
        Glide.with(context).m19load(K(this, str, 0, 2, null)).diskCacheStrategy(DiskCacheStrategy.DATA).addListener(new d()).preload();
    }

    public static /* synthetic */ void Z(NotificationUtil notificationUtil, Context context, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        notificationUtil.Y(context, str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(Context context, PullMsgResp pullMsgResp, TriggerSource triggerSource) {
        List items;
        MsgConfig config = pullMsgResp.getConfig();
        if (config != null ? Intrinsics.c(config.getEnable(), Boolean.TRUE) : false) {
            if (triggerSource == TriggerSource.SCREEN_ON) {
                MsgConfig config2 = pullMsgResp.getConfig();
                if (!(config2 != null ? Intrinsics.c(config2.getBrightScreen(), Boolean.TRUE) : false)) {
                    return;
                }
            }
            if (triggerSource == TriggerSource.UNLOCK) {
                MsgConfig config3 = pullMsgResp.getConfig();
                if (!(config3 != null ? Intrinsics.c(config3.getUnlock(), Boolean.TRUE) : false)) {
                    return;
                }
            }
            int i = Calendar.getInstance().get(11);
            if (!p(i) || (items = pullMsgResp.getItems()) == null) {
                return;
            }
            List<MsgBean> list = items;
            ArrayList arrayList = new ArrayList(CollectionsKt.v(list, 10));
            for (MsgBean msgBean : list) {
                arrayList.add(msgBean != null ? msgBean.getMessageId() : null);
            }
            wf.a.a.c("PUSH_SHOW", "local push, list:" + items.size() + "-ids:" + arrayList + ", \n config:" + pullMsgResp.getConfig(), true);
            MsgBean F = a.F(i, items);
            if (F != null) {
                if (F.getForceShow() && triggerSource == TriggerSource.UNLOCK) {
                    return;
                }
                if ((F.getHasScreenOn() && triggerSource == TriggerSource.SCREEN_ON) || F.getMsgStatus() == MsgStatus.CLICKED.ordinal()) {
                    return;
                }
                if (triggerSource == TriggerSource.APP_INNER && F.getMsgStatus() == MsgStatus.SHOWED.ordinal()) {
                    return;
                }
                if (triggerSource == TriggerSource.NETWORK_CONNECTED && F.getMsgStatus() == MsgStatus.SHOWED.ordinal()) {
                    return;
                }
                F.setTriggerSource(triggerSource.ordinal());
                e.a.j(context, F);
            }
        }
    }

    private final void b0(Context context, MsgBean msgBean) {
        if (msgBean == null) {
            return;
        }
        msgBean.setPermanent(true);
        e.a.i(context, msgBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c0(Context context, List list, ShowOrder showOrder, String str) {
        if (list == null || CollectionsKt.f0(list).size() <= 3 || PushConfigHelper.INSTANCE.isAbType()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (MsgBean msgBean : CollectionsKt.L0(list, 3)) {
            if (msgBean == null) {
                return;
            }
            if (msgBean.getPermanentMsgStatus() != MsgStatus.CLICKED.ordinal()) {
                arrayList.add(msgBean);
            }
        }
        if (arrayList.isEmpty()) {
            q(context, "oneroom.group.tag.permanent", 111);
            return;
        }
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.u();
            }
            MsgBean msgBean2 = (MsgBean) obj;
            msgBean2.setType(MsgType.PERMANENT.getType());
            msgBean2.setPermanentMsgPosition(i2);
            msgBean2.setPermanentMsgSize(arrayList.size());
            i = i2;
        }
        if (str == null) {
            b0(context, (MsgBean) arrayList.get(0));
            return;
        }
        int i3 = a.a[showOrder.ordinal()];
        if (i3 == 1) {
            int B = B(arrayList, str);
            if (B < 0 || B >= arrayList.size()) {
                return;
            }
            b0(context, (MsgBean) arrayList.get(B));
            return;
        }
        if (i3 != 2) {
            b0(context, (MsgBean) arrayList.get(0));
            return;
        }
        int H = H(arrayList, str);
        if (H < 0 || H >= arrayList.size()) {
            return;
        }
        b0(context, (MsgBean) arrayList.get(H));
    }

    static /* synthetic */ void d0(NotificationUtil notificationUtil, Context context, List list, ShowOrder showOrder, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            showOrder = ShowOrder.CURRENT;
        }
        if ((i & 8) != 0) {
            str = null;
        }
        notificationUtil.c0(context, list, showOrder, str);
    }

    private final void l(Context context) {
        String value;
        Boolean m1;
        boolean z = false;
        ConfigBean d2 = f.d(f.c.a(), "key_report_request_off", false, 2, null);
        if (d2 != null && (value = d2.getValue()) != null && (m1 = StringsKt.m1(value)) != null) {
            z = m1.booleanValue();
        }
        if (z) {
            return;
        }
        m b2 = new m.a(ReportWorker.class, 15L, TimeUnit.MINUTES).i(new b.a().b(NetworkType.CONNECTED).a()).a("report").b();
        try {
            Result.Companion companion = Result.Companion;
            if (Build.VERSION.SDK_INT >= 24) {
                context = androidx.profileinstaller.b.a(context);
            }
            Result.m34constructorimpl(WorkManager.f(context).e("unique_report", ExistingPeriodicWorkPolicy.REPLACE, b2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m34constructorimpl(ResultKt.a(th));
        }
    }

    private final void m(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            ConfigBean d2 = f.d(f.c.a(), "sa_notification_refresh", false, 2, null);
            if (Intrinsics.c(d2 != null ? d2.getValue() : null, "false")) {
                return;
            }
            context.bindService(new Intent(context, (Class<?>) NotificationRefreshService.class), (ServiceConnection) new b(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c n() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean o() {
        String value;
        Boolean m1;
        ConfigBean d2 = f.d(f.c.a(), "permanent_notification_switch", false, 2, null);
        return ((d2 == null || (value = d2.getValue()) == null || (m1 = StringsKt.m1(value)) == null) ? false : m1.booleanValue()) && Calendar.getInstance().get(11) >= 8;
    }

    private final boolean p(int i) {
        String endTime;
        String startTime;
        int i2 = 8;
        int i3 = 22;
        try {
            MsgConfig msgConfig = b;
            if (msgConfig != null && (startTime = msgConfig.getStartTime()) != null) {
                i2 = Integer.parseInt(startTime);
            }
            MsgConfig msgConfig2 = b;
            if (msgConfig2 != null && (endTime = msgConfig2.getEndTime()) != null) {
                i3 = Integer.parseInt(endTime);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return i2 <= i && i < i3;
    }

    private final void t(ArrayList arrayList, String str, String str2, int i, boolean z, boolean z2, boolean z3, boolean z4) {
        g0.a();
        NotificationChannel a2 = m.f.a(str, str2, i);
        w.a(a2, z3);
        if (!z) {
            g.a(a2, (Uri) null, (AudioAttributes) null);
        }
        x.a(a2, z2);
        if (z2) {
            y.a(a2, new long[]{0, 300, 100, 300});
        }
        z.a(a2, z4);
        if (z4) {
            a0.a(a2, 1);
        }
        arrayList.add(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c w() {
        return (c) d.getValue();
    }

    public final Intent C(Context context, String str, int i, String str2, String str3, String str4, String str5, String str6) {
        Uri parse;
        String host;
        Intrinsics.h(context, "context");
        to.a aVar = (to.a) TheRouter.d(to.a.class, new Object[0]);
        if (aVar == null) {
            return null;
        }
        Intent a2 = aVar.a(context);
        if (str6 != null && str6.length() != 0 && (parse = Uri.parse(str6)) != null && ((host = parse.getHost()) == null || !host.equals("com.community.oneroom"))) {
            a2 = new Intent("android.intent.action.VIEW", parse);
        }
        a2.putExtra("extra_notification_id", i);
        a2.putExtra("extra_source", str2);
        a2.putExtra("MESSAGE_TYPE", str3);
        a2.putExtra("extra_message_id", str5);
        a2.putExtra("extra_channel_id", str);
        a2.putExtra("extra_message_style", str4);
        a2.putExtra("extra_screen_status", String.valueOf(v.a.a()));
        a2.addFlags(603979776);
        a2.setAction("android.intent.action.VIEW");
        return a2;
    }

    public final MsgConfig G() {
        String string = u.a.b().getString("push_config", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return (MsgConfig) o.d(string, MsgConfig.class);
    }

    public final String I() {
        return "oneroom_notice_Permanent";
    }

    public final String J(String str, int i) {
        Intrinsics.h(str, "url");
        return f.a.e(ni.f.a, str, i, true, false, 8, (Object) null);
    }

    public final void L(Context context) {
        Intrinsics.h(context, "context");
        try {
            m b2 = new m.a(PullWorker.class, Random.INSTANCE.nextLong(15L, 30L), TimeUnit.MINUTES).i(new b.a().b(NetworkType.CONNECTED).a()).a("pull").b();
            try {
                Result.Companion companion = Result.Companion;
                Result.m34constructorimpl(WorkManager.f(Build.VERSION.SDK_INT >= 24 ? androidx.profileinstaller.b.a(context) : context).e("unique_pull", ExistingPeriodicWorkPolicy.KEEP, b2));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m34constructorimpl(ResultKt.a(th));
            }
            MsgConfig G = G();
            if (G != null) {
                a.u(context, G);
            } else {
                G = null;
            }
            b = G;
            M(context);
            l(context);
            ToolbarNotificationUtils.a.i();
            m(context);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void M(Context context) {
        Intrinsics.h(context, "context");
        a.a.f(wf.a.a, "NotificationUtil", "NotificationUtil initListener ", false, 4, (Object) null);
        l.a.l(new c(context));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("com.community.oneroom.notification_delete");
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            intentFilter.addAction("android.intent.action.USER_UNLOCKED");
        }
        if (i >= 33) {
            com.bytedance.sdk.openadsdk.core.settings.a.a(context, new NotificationReceiver(), intentFilter, 2);
        } else {
            context.registerReceiver(new NotificationReceiver(), intentFilter);
        }
        l.a.b();
    }

    public final boolean N() {
        return Build.VERSION.SDK_INT >= 31;
    }

    public final boolean O() {
        return Build.VERSION.SDK_INT <= 24;
    }

    public final void P(Context context, TriggerSource triggerSource) {
        Intrinsics.h(context, "context");
        Intrinsics.h(triggerSource, "triggerSource");
        R(context, triggerSource);
        PushPermanentManager.a.o();
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new loadNotificationMsg.1(triggerSource, context, (Continuation) null), 3, (Object) null);
    }

    public final String T(String str, String str2) {
        Intrinsics.h(str, "deeplink");
        Intrinsics.h(str2, "paramKey");
        try {
            String queryParameter = Uri.parse(StringsKt.Q(str, "%%", "%25%25", false, 4, (Object) null)).getQueryParameter(str2);
            return queryParameter != null ? URLDecoder.decode(queryParameter, StandardCharsets.UTF_8.name()) : queryParameter;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public final void W(com.transsion.push.worker.a aVar) {
        c = aVar;
    }

    public final void X(Context context, String str) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "currentMsgId");
        A(this, context, ShowOrder.LAST, str, false, 8, null);
    }

    public final void Y(Context context, String str, boolean z) {
        Intrinsics.h(context, "context");
        z(context, ShowOrder.NEXT, str, z);
    }

    public final String e0(String str) {
        Long x;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd HH:mm", Locale.CHINA);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        if (str == null || (x = StringsKt.x(str)) == null) {
            return "00/00 00:00";
        }
        String format = simpleDateFormat.format(new Date(x.longValue()));
        Intrinsics.e(format);
        return format;
    }

    public final void q(Context context, String str, int i) {
        if (context == null) {
            a.a.f(wf.a.a, "NotificationUtil", "bad parameter.", false, 4, (Object) null);
            return;
        }
        Object systemService = context.getSystemService("notification");
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        if (notificationManager == null) {
            a.a.f(wf.a.a, "NotificationUtil", "NotificationManager is not available", false, 4, (Object) null);
            return;
        }
        try {
            notificationManager.cancel(i);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final int r(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return new java.util.Random().nextInt();
        }
        return ((str != null ? str.hashCode() : 0) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final Bitmap s(Bitmap bitmap, int i, float f, int i2) {
        Intrinsics.h(bitmap, "sourceBitmap");
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i, true);
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        float f2 = i - f;
        RectF rectF = new RectF(f, f, f2, f2);
        canvas.drawOval(rectF, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        int i3 = (int) f;
        int i4 = (int) f2;
        canvas.drawBitmap(createScaledBitmap, new Rect(i3, i3, i4, i4), rectF, paint);
        if (f > 0.0f) {
            Paint paint2 = new Paint();
            paint2.setAntiAlias(true);
            paint2.setColor(i2);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(f);
            canvas.drawOval(rectF, paint2);
        }
        if (!createScaledBitmap.isRecycled()) {
            createScaledBitmap.recycle();
        }
        return createBitmap;
    }

    public final void u(Context context, MsgConfig msgConfig) {
        Boolean shock;
        Boolean ring;
        Intrinsics.h(context, "context");
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        Object systemService = context.getSystemService("notification");
        NotificationManager notificationManager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        ArrayList arrayList = new ArrayList();
        String string = context.getString(R.string.importance_foreground);
        Intrinsics.g(string, "getString(...)");
        t(arrayList, "oneroom_notice_Foreground", string, msgConfig != null ? Intrinsics.c(msgConfig.getFloatingWindow(), Boolean.TRUE) : false ? 4 : 3, false, false, true, true);
        String string2 = context.getString(R.string.importance_background);
        Intrinsics.g(string2, "getString(...)");
        t(arrayList, "oneroom_notice_Background", string2, 4, (msgConfig == null || (ring = msgConfig.getRing()) == null) ? true : ring.booleanValue(), (msgConfig == null || (shock = msgConfig.getShock()) == null) ? true : shock.booleanValue(), true, true);
        String string3 = context.getString(R.string.permanent);
        Intrinsics.g(string3, "getString(...)");
        t(arrayList, "oneroom_notice_Permanent", string3, 4, false, false, false, false);
        if (notificationManager != null) {
            v.a(notificationManager, arrayList);
        }
    }

    public final void v() {
        com.transsion.push.worker.a aVar = c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final String x(boolean z) {
        return z ? "oneroom_notice_Foreground" : "oneroom_notice_Background";
    }

    public final float y() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(11) + (calendar.get(12) / 60.0f);
    }

    public final void z(Context context, ShowOrder showOrder, String str, boolean z) {
        Intrinsics.h(context, "context");
        Intrinsics.h(showOrder, "showOrder");
        if (o()) {
            i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new getLast3MsgForPermanent.1(z, context, showOrder, str, (Continuation) null), 3, (Object) null);
        }
    }
}
