package com.transsion.push.notification;

import android.app.Application;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.util.g0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.a0;
import com.therouter.TheRouter;
import com.tn.lib.widget.R;
import com.transsion.gslb.BuildConfig;
import com.transsion.lib.push.R$drawable;
import com.transsion.lib.push.R$id;
import com.transsion.lib.push.R$layout;
import com.transsion.lib.push.R$mipmap;
import com.transsion.lib.push.R$string;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.bean.MsgType;
import com.transsion.push.bean.ToolbarNoticeConfig;
import com.transsion.push.bean.ToolbarNoticeItem;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ni.f;
import qi.h;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ToolbarNotificationUtils {
    public static final ToolbarNotificationUtils a = new ToolbarNotificationUtils();
    private static final int b = 790343710;
    private static final Map c = new LinkedHashMap();
    private static final NotificationManager d;
    private static ToolbarNoticeConfig e;
    private static boolean f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NoticeIntentType.values().length];
            try {
                iArr[NoticeIntentType.SEARCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NoticeIntentType.TOP_10.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NoticeIntentType.SETTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NoticeIntentType.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    static {
        Object systemService = Utils.a().getSystemService("notification");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        d = notificationManager;
        if (Build.VERSION.SDK_INT >= 26) {
            g0.a();
            m.c.a(notificationManager, m.f.a("mbx_tool_notice", Utils.a().getString(R$string.tool_notice_name), 2));
        }
    }

    private ToolbarNotificationUtils() {
    }

    private final void A() {
        h.a.z("toolbar_notice", new LinkedHashMap());
    }

    private final void B(RemoteViews remoteViews, Pair pair) {
        if (((ToolbarNoticeItem) pair.getFirst()).getIsDefault()) {
            a.a.f(wf.a.a, "ToolbarNo", "setButtonText 默认本地文案", false, 4, (Object) null);
            remoteViews.setTextViewText(R$id.notice_tv_left, Utils.a().getString(R$string.tool_notice_top_10));
            remoteViews.setTextViewText(R$id.notice_tv_right, Utils.a().getString(R$string.tool_notice_search));
            return;
        }
        a.a.f(wf.a.a, "ToolbarNo", "setButtonText 配置文案", false, 4, (Object) null);
        String text = ((ToolbarNoticeItem) pair.getFirst()).getText();
        if (text != null) {
            remoteViews.setTextViewText(R$id.notice_tv_left, text);
        }
        String text2 = ((ToolbarNoticeItem) pair.getSecond()).getText();
        if (text2 != null) {
            remoteViews.setTextViewText(R$id.notice_tv_right, text2);
        }
    }

    private final void C(RemoteViews remoteViews, Pair pair) {
        int i = R$id.notice_ll_left;
        String deeplink = ((ToolbarNoticeItem) pair.getFirst()).getDeeplink();
        if (deeplink == null) {
            deeplink = k(NoticeIntentType.TOP_10);
        }
        remoteViews.setOnClickPendingIntent(i, m(deeplink, "left"));
        int i2 = R$id.notice_ll_right;
        String deeplink2 = ((ToolbarNoticeItem) pair.getSecond()).getDeeplink();
        if (deeplink2 == null) {
            deeplink2 = k(NoticeIntentType.SEARCH);
        }
        remoteViews.setOnClickPendingIntent(i2, m(deeplink2, "right"));
        remoteViews.setOnClickPendingIntent(R$id.notice_v_setting, m(k(NoticeIntentType.SETTING), "setting"));
    }

    private final void D(RemoteViews remoteViews, Pair pair) {
        if (pair == null) {
            a.a.f(wf.a.a, "ToolbarNo", "setIconCover 默认本地图", false, 4, (Object) null);
            remoteViews.setImageViewResource(R$id.notice_iv_left, R$mipmap.ic_notification_top_10);
            remoteViews.setImageViewResource(R$id.notice_iv_right, R$mipmap.ic_notification_search);
            return;
        }
        a.a.f(wf.a.a, "ToolbarNo", "setIconCover 配置图", false, 4, (Object) null);
        Bitmap bitmap = (Bitmap) pair.getFirst();
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R$id.notice_iv_left, bitmap);
        }
        Bitmap bitmap2 = (Bitmap) pair.getSecond();
        if (bitmap2 != null) {
            remoteViews.setImageViewBitmap(R$id.notice_iv_right, bitmap2);
        }
    }

    /*  JADX ERROR: NullPointerException in pass: BlockProcessor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.blocks.BlockSplitter.removeConnection(BlockSplitter.java:165)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.removeExcHandler(BlockExceptionHandler.java:324)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.lambda$prepareTryBlocks$2(BlockExceptionHandler.java:207)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.prepareTryBlocks(BlockExceptionHandler.java:207)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.process(BlockExceptionHandler.java:60)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.independentBlockTreeMod(BlockProcessor.java:372)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:56)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:49)
        */
    /* JADX WARN: Unreachable blocks removed: 9, instructions: 35 */
    private final void E() {
        /*
            r8 = this;
            return
            kotlin.Pair r0 = r8.o()
            boolean r1 = r8.r()
            if (r1 == 0) goto L3d
            wf.a$a r2 = wf.a.a
            r6 = 4
            r7 = 0
            java.lang.String r3 = "ToolbarNo"
            java.lang.String r4 = "showNotice, 本地默认数据"
            r5 = 0
            wf.a.a.f(r2, r3, r4, r5, r6, r7)
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L2f
            android.app.NotificationManager r1 = com.transsion.push.notification.ToolbarNotificationUtils.d     // Catch: java.lang.Throwable -> L2f
            int r2 = com.transsion.push.notification.ToolbarNotificationUtils.b     // Catch: java.lang.Throwable -> L2f
            r3 = 0
            androidx.core.app.NotificationCompat$m r0 = r8.q(r0, r3)     // Catch: java.lang.Throwable -> L2f
            android.app.Notification r0 = r0.c()     // Catch: java.lang.Throwable -> L2f
            r1.notify(r2, r0)     // Catch: java.lang.Throwable -> L2f
            kotlin.Unit r0 = kotlin.Unit.a     // Catch: java.lang.Throwable -> L2f
            kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> L2f
            goto L39
        L2f:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            kotlin.Result.constructor-impl(r0)
        L39:
            r8.A()
            goto L51
        L3d:
            wf.a$a r1 = wf.a.a
            r5 = 4
            r6 = 0
            java.lang.String r2 = "ToolbarNo"
            java.lang.String r3 = "showNotice, 配置数据，加载图片"
            r4 = 0
            wf.a.a.f(r1, r2, r3, r4, r5, r6)
            com.transsion.push.notification.l r1 = new com.transsion.push.notification.l
            r1.<init>()
            r8.u(r0, r1)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.push.notification.ToolbarNotificationUtils.E():void");
    }

    /*  JADX ERROR: NullPointerException in pass: BlockProcessor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.blocks.BlockSplitter.removeConnection(BlockSplitter.java:165)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.removeExcHandler(BlockExceptionHandler.java:324)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.lambda$prepareTryBlocks$2(BlockExceptionHandler.java:207)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.prepareTryBlocks(BlockExceptionHandler.java:207)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.process(BlockExceptionHandler.java:60)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.independentBlockTreeMod(BlockProcessor.java:372)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:56)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:49)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 12, instructions: 41 */
    public static final kotlin.Unit F(kotlin.Pair r6, android.graphics.Bitmap r7, android.graphics.Bitmap r8) {
        /*
            kotlin.Unit r0 = kotlin.Unit.a
            return r0
            wf.a$a r0 = wf.a.a
            r1 = 0
            r2 = 1
            if (r7 == 0) goto Lb
            r3 = r2
            goto Lc
        Lb:
            r3 = r1
        Lc:
            if (r8 == 0) goto Lf
            r1 = r2
        Lf:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "showNotice, 加载图片成功， "
            r2.append(r4)
            r2.append(r3)
            java.lang.String r3 = ",  "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            r4 = 4
            r5 = 0
            java.lang.String r1 = "ToolbarNo"
            r3 = 0
            wf.a.a.f(r0, r1, r2, r3, r4, r5)
            com.transsion.push.notification.ToolbarNotificationUtils r0 = com.transsion.push.notification.ToolbarNotificationUtils.a
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L4e
            android.app.NotificationManager r1 = com.transsion.push.notification.ToolbarNotificationUtils.d     // Catch: java.lang.Throwable -> L4e
            int r2 = com.transsion.push.notification.ToolbarNotificationUtils.b     // Catch: java.lang.Throwable -> L4e
            kotlin.Pair r3 = new kotlin.Pair     // Catch: java.lang.Throwable -> L4e
            r3.<init>(r7, r8)     // Catch: java.lang.Throwable -> L4e
            androidx.core.app.NotificationCompat$m r6 = r0.q(r6, r3)     // Catch: java.lang.Throwable -> L4e
            android.app.Notification r6 = r6.c()     // Catch: java.lang.Throwable -> L4e
            r1.notify(r2, r6)     // Catch: java.lang.Throwable -> L4e
            kotlin.Unit r6 = kotlin.Unit.a     // Catch: java.lang.Throwable -> L4e
            kotlin.Result.constructor-impl(r6)     // Catch: java.lang.Throwable -> L4e
            goto L58
        L4e:
            r6 = move-exception
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.a(r6)
            kotlin.Result.constructor-impl(r6)
        L58:
            com.transsion.push.notification.ToolbarNotificationUtils r6 = com.transsion.push.notification.ToolbarNotificationUtils.a
            r6.A()
            kotlin.Unit r6 = kotlin.Unit.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.push.notification.ToolbarNotificationUtils.F(kotlin.Pair, android.graphics.Bitmap, android.graphics.Bitmap):kotlin.Unit");
    }

    private final void h(RemoteViews remoteViews, boolean z) {
        int color = Utils.a().getResources().getColor(z ? R.color.white : R.color.gray_light_70);
        remoteViews.setTextColor(R$id.notice_tv_left, color);
        remoteViews.setTextColor(R$id.notice_tv_right, color);
        int i = z ? R$drawable.shape_toolbar_btn_bg_dark : R$drawable.shape_toolbar_btn_bg_light;
        remoteViews.setInt(R$id.notice_ll_left, "setBackgroundResource", i);
        remoteViews.setInt(R$id.notice_ll_right, "setBackgroundResource", i);
        remoteViews.setInt(R$id.notice_iv_left, "setColorFilter", color);
        remoteViews.setInt(R$id.notice_iv_right, "setColorFilter", color);
    }

    private final boolean j(long j, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.add(5, i);
        long timeInMillis = calendar.getTimeInMillis();
        wf.a.a.c("ToolbarNo", "isNeedShowNotice, currentTimeMillis:" + currentTimeMillis + ", daysAgo:" + timeInMillis, true);
        return currentTimeMillis > timeInMillis;
    }

    private final int l() {
        return Build.VERSION.SDK_INT >= 31 ? 67108864 : 134217728;
    }

    private final PendingIntent m(String str, String str2) {
        Intent intent;
        to.a aVar = (to.a) TheRouter.d(to.a.class, new Object[0]);
        if (aVar != null) {
            Application a2 = Utils.a();
            Intrinsics.g(a2, "getApp(...)");
            intent = aVar.a(a2);
            if (intent != null) {
                int i = b;
                intent.putExtra("extra_notification_id", String.valueOf(i));
                intent.putExtra("extra_source", MsgStyle.SOURCE_PUSH);
                intent.putExtra("MESSAGE_TYPE", MsgType.TOP10_PUSH.getType());
                intent.putExtra("extra_message_id", String.valueOf(i));
                intent.putExtra("extra_toolbar_notice_name", str2);
                intent.addFlags(603979776);
                intent.setData(Uri.parse(str));
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(268435456);
                }
                PendingIntent activity = PendingIntent.getActivity(Utils.a(), 0, intent, l());
                Intrinsics.g(activity, "getActivity(...)");
                return activity;
            }
        }
        intent = null;
        PendingIntent activity2 = PendingIntent.getActivity(Utils.a(), 0, intent, l());
        Intrinsics.g(activity2, "getActivity(...)");
        return activity2;
    }

    private final int n() {
        return Build.VERSION.SDK_INT < 31 ? R$layout.layout_ongoing_notification : R$layout.layout_ongoing_notification_expend_s;
    }

    private final Pair o() {
        if (r()) {
            ToolbarNoticeItem toolbarNoticeItem = new ToolbarNoticeItem(null, null, k(NoticeIntentType.TOP_10), 3, null);
            toolbarNoticeItem.setDefault(true);
            ToolbarNoticeItem toolbarNoticeItem2 = new ToolbarNoticeItem(null, null, k(NoticeIntentType.SEARCH), 3, null);
            toolbarNoticeItem2.setDefault(true);
            return new Pair(toolbarNoticeItem, toolbarNoticeItem2);
        }
        ToolbarNoticeConfig toolbarNoticeConfig = e;
        Intrinsics.e(toolbarNoticeConfig);
        List<ToolbarNoticeItem> list = toolbarNoticeConfig.getList();
        Intrinsics.e(list);
        ToolbarNoticeItem toolbarNoticeItem3 = list.get(0);
        ToolbarNoticeConfig toolbarNoticeConfig2 = e;
        Intrinsics.e(toolbarNoticeConfig2);
        List<ToolbarNoticeItem> list2 = toolbarNoticeConfig2.getList();
        Intrinsics.e(list2);
        return new Pair(toolbarNoticeItem3, list2.get(1));
    }

    private final int p() {
        return Build.VERSION.SDK_INT < 31 ? R$layout.layout_ongoing_notification : R$layout.layout_ongoing_notification_s;
    }

    private final NotificationCompat.m q(Pair pair, Pair pair2) {
        boolean z = (Utils.a().getResources().getConfiguration().uiMode & 48) == 32;
        RemoteViews remoteViews = new RemoteViews(Utils.a().getPackageName(), p());
        ToolbarNotificationUtils toolbarNotificationUtils = a;
        toolbarNotificationUtils.C(remoteViews, pair);
        toolbarNotificationUtils.D(remoteViews, pair2);
        toolbarNotificationUtils.B(remoteViews, pair);
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            toolbarNotificationUtils.h(remoteViews, z);
        }
        RemoteViews remoteViews2 = new RemoteViews(Utils.a().getPackageName(), n());
        toolbarNotificationUtils.C(remoteViews2, pair);
        toolbarNotificationUtils.D(remoteViews2, pair2);
        toolbarNotificationUtils.B(remoteViews2, pair);
        if (i >= 31) {
            toolbarNotificationUtils.h(remoteViews2, z);
        }
        NotificationCompat.m s = new NotificationCompat.m(Utils.a(), "mbx_tool_notice").J(R$drawable.push_small_logo).t(remoteViews).p(m(k(NoticeIntentType.CONTENT), "content")).E(true).l(false).F(true).s(remoteViews2);
        Intrinsics.g(s, "setCustomBigContentView(...)");
        return s;
    }

    private final boolean r() {
        List<ToolbarNoticeItem> list;
        ToolbarNoticeConfig toolbarNoticeConfig = e;
        if (toolbarNoticeConfig != null) {
            if (((toolbarNoticeConfig == null || (list = toolbarNoticeConfig.getList()) == null) ? 0 : list.size()) >= 2) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean s(int i) {
        Long x;
        if (!com.transsion.baselib.report.k.a.q()) {
            a.a.f(wf.a.a, "ToolbarNo", "isNeedShowNotice,当前在前台，无需处理", false, 4, (Object) null);
            return false;
        }
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        if (!bVar.b().getBoolean("k_is_show_ongoing_tool_notice", true)) {
            a.a.f(wf.a.a, "ToolbarNo", "isNeedShowNotice,设置页已主动关闭", false, 4, (Object) null);
            return false;
        }
        String string = bVar.b().getString("k_last_open_time", BuildConfig.FLAVOR);
        long longValue = (string == null || (x = StringsKt.x(string)) == null) ? 0L : x.longValue();
        if (longValue > 0) {
            if (j(longValue, i)) {
                wf.a.a.c("ToolbarNo", "isNeedShowNotice, true currentDayKey:" + System.currentTimeMillis() + ", appOpenTime:" + longValue + ", " + i + " ", true);
                return true;
            }
            wf.a.a.c("ToolbarNo", "isNeedShowNotice, false currentDayKey:" + System.currentTimeMillis() + ", appOpenTime:" + longValue + ", " + i + " ", true);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object t(String str, Continuation continuation) {
        return TimeoutKt.c(5000L, new ToolbarNotificationUtils$loadImageAsBitmap$2(str, a0.a(20.0f), null), continuation);
    }

    private final void u(Pair pair, Function2 function2) {
        kotlinx.coroutines.i.d(o0.a(y0.c()), (CoroutineContext) null, (CoroutineStart) null, new ToolbarNotificationUtils$loadImages$1(function2, pair, null), 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(ToolbarNoticeConfig toolbarNoticeConfig) {
        List<ToolbarNoticeItem> list;
        if (toolbarNoticeConfig == null || (list = toolbarNoticeConfig.getList()) == null || list.isEmpty() || toolbarNoticeConfig.getList().size() < 2) {
            return;
        }
        int a2 = a0.a(20.0f);
        Iterator<T> it = toolbarNoticeConfig.getList().iterator();
        while (it.hasNext()) {
            String cover = ((ToolbarNoticeItem) it.next()).getCover();
            if (cover != null) {
                Map map = c;
                if (!map.containsKey(cover)) {
                    a.a.f(wf.a.a, "ToolbarNo", "preloadImage, url :" + cover, false, 4, (Object) null);
                    map.put(cover, BuildConfig.FLAVOR);
                    f.a aVar = ni.f.a;
                    aVar.i(f.a.e(aVar, cover, a2, false, true, 4, null), cover, a2, new Function1() { // from class: com.transsion.push.notification.k
                        public final Object invoke(Object obj) {
                            Unit x;
                            x = ToolbarNotificationUtils.x(((Boolean) obj).booleanValue());
                            return x;
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(boolean z) {
        a.a.v(wf.a.a, "ToolbarNo", "preloadImage, result:" + z, false, 4, (Object) null);
        return Unit.a;
    }

    private final void z(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("name", str);
        h.a.o("toolbar_notice", linkedHashMap);
    }

    /*  JADX ERROR: NullPointerException in pass: BlockProcessor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.blocks.BlockSplitter.removeConnection(BlockSplitter.java:165)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.removeExcHandler(BlockExceptionHandler.java:324)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.lambda$prepareTryBlocks$2(BlockExceptionHandler.java:207)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.prepareTryBlocks(BlockExceptionHandler.java:207)
        	at jadx.core.dex.visitors.blocks.BlockExceptionHandler.process(BlockExceptionHandler.java:60)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.independentBlockTreeMod(BlockProcessor.java:372)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:56)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:49)
        */
    /* JADX WARN: Unreachable blocks removed: 15, instructions: 58 */
    public final void G() {
        /*
            r7 = this;
            return
            cf.c r0 = cf.c.a
            android.app.Application r1 = com.blankj.utilcode.util.Utils.a()
            java.lang.String r2 = "getApp(...)"
            kotlin.jvm.internal.Intrinsics.g(r1, r2)
            boolean r0 = r0.b(r1)
            if (r0 != 0) goto L1f
            wf.a$a r1 = wf.a.a
            r5 = 4
            r6 = 0
            java.lang.String r2 = "ToolbarNo"
            java.lang.String r3 = "showToolbarNotification 没有通知权限"
            r4 = 0
            wf.a.a.f(r1, r2, r3, r4, r5, r6)
            return
        L1f:
            boolean r0 = com.transsion.push.notification.ToolbarNotificationUtils.f
            if (r0 != 0) goto L30
            wf.a$a r1 = wf.a.a
            r5 = 4
            r6 = 0
            java.lang.String r2 = "ToolbarNo"
            java.lang.String r3 = "showToolbarNotification，当前不需要展示通知"
            r4 = 0
            wf.a.a.f(r1, r2, r3, r4, r5, r6)
            return
        L30:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch: java.lang.Throwable -> L51
            android.app.NotificationManager r0 = com.transsion.push.notification.ToolbarNotificationUtils.d     // Catch: java.lang.Throwable -> L51
            int r1 = com.transsion.push.notification.ToolbarNotificationUtils.b     // Catch: java.lang.Throwable -> L51
            r0.cancel(r1)     // Catch: java.lang.Throwable -> L51
            com.transsion.push.notification.ToolbarNotificationUtils r0 = com.transsion.push.notification.ToolbarNotificationUtils.a     // Catch: java.lang.Throwable -> L51
            r0.E()     // Catch: java.lang.Throwable -> L51
            wf.a$a r1 = wf.a.a     // Catch: java.lang.Throwable -> L51
            java.lang.String r2 = "ToolbarNo"
            java.lang.String r3 = "showToolbarNotification"
            r5 = 4
            r6 = 0
            r4 = 0
            wf.a.a.f(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L51
            kotlin.Unit r0 = kotlin.Unit.a     // Catch: java.lang.Throwable -> L51
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)     // Catch: java.lang.Throwable -> L51
            goto L5c
        L51:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.constructor-impl(r0)
        L5c:
            java.lang.Throwable r0 = kotlin.Result.exceptionOrNull-impl(r0)
            if (r0 == 0) goto L7d
            wf.a$a r1 = wf.a.a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "showToolbarNotification error:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = r2.toString()
            r5 = 4
            r6 = 0
            java.lang.String r2 = "ToolbarNo"
            r4 = 0
            wf.a.a.l(r1, r2, r3, r4, r5, r6)
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.push.notification.ToolbarNotificationUtils.G():void");
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 11 */
    public final void i() {
    }

    public final String k(NoticeIntentType noticeIntentType) {
        Intrinsics.h(noticeIntentType, "type");
        int i = a.a[noticeIntentType.ordinal()];
        if (i == 1) {
            return "oneroom://com.community.oneroom?type=/search/activity/search_manager&channel=os_search&type=3";
        }
        if (i == 2) {
            return "oneroom://com.community.oneroom?type=/rank/all";
        }
        if (i == 3) {
            return "oneroom://com.community.oneroom?type=/profile/setting_notice";
        }
        if (i == 4) {
            return "oneroom://com.community.oneroom?type=/main/tab";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void v(Intent intent) {
        String stringExtra;
        String stringExtra2;
        if (intent == null || (stringExtra = intent.getStringExtra("extra_notification_id")) == null || !Intrinsics.c(stringExtra, String.valueOf(b)) || (stringExtra2 = intent.getStringExtra("extra_toolbar_notice_name")) == null) {
            return;
        }
        z(stringExtra2);
    }

    public final void y() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            d.cancel(b);
            obj = Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.a(th2));
        }
        Throwable th3 = Result.exceptionOrNull-impl(obj);
        if (th3 != null) {
            a.a.f(wf.a.a, "ToolbarNo", "removeOngoingToolNotification error:" + th3, false, 4, (Object) null);
        }
    }
}
