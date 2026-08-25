package com.transsion.push.helper;

import android.app.Application;
import android.app.NotificationManager;
import android.os.Handler;
import android.service.notification.StatusBarNotification;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.gslb.BuildConfig;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/transsion/push/helper/NotificationRefreshService$runnable$1", "Ljava/lang/Runnable;", "run", BuildConfig.FLAVOR, "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class NotificationRefreshService$runnable$1 implements Runnable {
    final /* synthetic */ NotificationRefreshService this$0;

    NotificationRefreshService$runnable$1(NotificationRefreshService notificationRefreshService) {
        this.this$0 = notificationRefreshService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean run$lambda$0(SoftReference softReference) {
        return softReference.get() == null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        StatusBarNotification[] statusBarNotificationArr;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        int i;
        int length;
        Handler handler;
        CopyOnWriteArrayList copyOnWriteArrayList3;
        StatusBarNotification statusBarNotification;
        NotificationManager notificationManager;
        copyOnWriteArrayList = this.this$0.msgList;
        CollectionsKt.I(copyOnWriteArrayList, new Function1() { // from class: com.transsion.push.helper.c
            public final Object invoke(Object obj) {
                boolean run$lambda$0;
                run$lambda$0 = NotificationRefreshService$runnable$1.run$lambda$0((SoftReference) obj);
                return Boolean.valueOf(run$lambda$0);
            }
        });
        try {
            notificationManager = this.this$0.manager;
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (notificationManager != null) {
            statusBarNotificationArr = notificationManager.getActiveNotifications();
            a.a aVar = wf.a.a;
            Integer valueOf = statusBarNotificationArr == null ? Integer.valueOf(statusBarNotificationArr.length) : null;
            copyOnWriteArrayList2 = this.this$0.msgList;
            a.a.f(aVar, "NoticeRefreshHelper", "onRepeat, currentNotifications: " + valueOf + " msgList: " + copyOnWriteArrayList2.size(), false, 4, (Object) null);
            length = statusBarNotificationArr == null ? statusBarNotificationArr.length : 0;
            for (i = 0; i < length; i++) {
                Integer valueOf2 = (statusBarNotificationArr == null || (statusBarNotification = statusBarNotificationArr[i]) == null) ? null : Integer.valueOf(statusBarNotification.getId());
                copyOnWriteArrayList3 = this.this$0.msgList;
                Iterator it = copyOnWriteArrayList3.iterator();
                Intrinsics.g(it, "iterator(...)");
                MsgBean msgBean = null;
                while (it.hasNext()) {
                    MsgBean msgBean2 = (MsgBean) ((SoftReference) it.next()).get();
                    if (msgBean2 != null) {
                        int l = NotificationShowHelper.a.l(msgBean2.getMessageId());
                        if (valueOf2 != null && l == valueOf2.intValue()) {
                            msgBean2.setRefresh(true);
                            Application a = Utils.a();
                            if (a != null) {
                                e.a.j(a, msgBean2);
                            }
                        }
                    }
                    if (msgBean2 != null && msgBean2.getIsPermanent()) {
                        int o = NotificationShowHelper.a.o();
                        if (valueOf2 != null && o == valueOf2.intValue()) {
                            msgBean = msgBean2;
                        }
                    }
                }
                if (msgBean != null) {
                    msgBean.setRefresh(true);
                    Application a2 = Utils.a();
                    if (a2 != null) {
                        e.a.j(a2, msgBean);
                    }
                }
            }
            handler = this.this$0.handler;
            if (handler == null) {
                handler.postDelayed(this, 30000L);
                return;
            }
            return;
        }
        statusBarNotificationArr = null;
        a.a aVar2 = wf.a.a;
        if (statusBarNotificationArr == null) {
        }
        copyOnWriteArrayList2 = this.this$0.msgList;
        a.a.f(aVar2, "NoticeRefreshHelper", "onRepeat, currentNotifications: " + valueOf + " msgList: " + copyOnWriteArrayList2.size(), false, 4, (Object) null);
        if (statusBarNotificationArr == null) {
        }
        while (i < length) {
        }
        handler = this.this$0.handler;
        if (handler == null) {
        }
    }
}
