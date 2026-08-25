package com.transsion.push.helper;

import android.app.Application;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.gslb.BuildConfig;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import wf.a;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0005*\u0002+.\u0018\u0000 12\u00020\u0001:\u0002\u0019\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\u0003J)\u0010\u0011\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0003R \u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010)R\u0014\u0010-\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010/¨\u00062"}, d2 = {"Lcom/transsion/push/helper/NotificationRefreshService;", "Landroid/app/Service;", "<init>", "()V", "Lcom/transsion/baselib/db/notification/MsgBean;", "msgBean", BuildConfig.FLAVOR, "e", "(Lcom/transsion/baselib/db/notification/MsgBean;)V", "f", "g", "onCreate", "Landroid/content/Intent;", "intent", BuildConfig.FLAVOR, "flags", "startId", "onStartCommand", "(Landroid/content/Intent;II)I", "Landroid/os/IBinder;", "onBind", "(Landroid/content/Intent;)Landroid/os/IBinder;", "onDestroy", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/lang/ref/SoftReference;", "a", "Ljava/util/concurrent/CopyOnWriteArrayList;", "msgList", "Landroid/app/NotificationManager;", "b", "Landroid/app/NotificationManager;", "manager", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "handler", BuildConfig.FLAVOR, "d", "Z", "isRepeating", "Lcom/transsion/push/helper/NotificationRefreshService$b;", "Lcom/transsion/push/helper/NotificationRefreshService$b;", "binder", "com/transsion/push/helper/NotificationRefreshService$localReceiver$1", "Lcom/transsion/push/helper/NotificationRefreshService$localReceiver$1;", "localReceiver", "com/transsion/push/helper/NotificationRefreshService$runnable$1", "Lcom/transsion/push/helper/NotificationRefreshService$runnable$1;", "runnable", "h", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class NotificationRefreshService extends Service {

    /* renamed from: b, reason: from kotlin metadata */
    private NotificationManager manager;

    /* renamed from: c, reason: from kotlin metadata */
    private Handler handler;

    /* renamed from: d, reason: from kotlin metadata */
    private boolean isRepeating;

    /* renamed from: a, reason: from kotlin metadata */
    private final CopyOnWriteArrayList msgList = new CopyOnWriteArrayList();

    /* renamed from: e, reason: from kotlin metadata */
    private final b binder = new b();

    /* renamed from: f, reason: from kotlin metadata */
    private final NotificationRefreshService$localReceiver$1 localReceiver = new BroadcastReceiver() { // from class: com.transsion.push.helper.NotificationRefreshService$localReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MsgBean msgBean = intent != null ? (MsgBean) intent.getParcelableExtra("newMsg") : null;
            wf.a.a.c("NoticeRefreshHelper", "receive message: " + msgBean, true);
            NotificationRefreshService.this.e(msgBean);
        }
    };

    /* renamed from: g, reason: from kotlin metadata */
    private final NotificationRefreshService$runnable$1 runnable = new NotificationRefreshService$runnable$1(this);

    public static final class b extends Binder {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(MsgBean msgBean) {
        String messageId;
        if (msgBean == null || (messageId = msgBean.getMessageId()) == null || messageId.length() == 0) {
            return;
        }
        Object obj = null;
        if (msgBean.getIsPermanent()) {
            Iterator it = this.msgList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                MsgBean msgBean2 = (MsgBean) ((SoftReference) next).get();
                if (msgBean2 != null && msgBean2.getIsPermanent()) {
                    obj = next;
                    break;
                }
            }
            SoftReference softReference = (SoftReference) obj;
            if (softReference != null) {
                this.msgList.remove(softReference);
            }
            this.msgList.add(new SoftReference(msgBean));
            return;
        }
        Iterator it2 = this.msgList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            String messageId2 = msgBean.getMessageId();
            MsgBean msgBean3 = (MsgBean) ((SoftReference) next2).get();
            if (Intrinsics.c(messageId2, msgBean3 != null ? msgBean3.getMessageId() : null)) {
                obj = next2;
                break;
            }
        }
        if (obj == null) {
            this.msgList.add(new SoftReference(msgBean));
        }
        if (this.msgList.size() >= 4) {
            MsgBean msgBean4 = (MsgBean) ((SoftReference) this.msgList.get(0)).get();
            if (msgBean4 == null || !msgBean4.getIsPermanent()) {
            }
        }
    }

    private final void f() {
        if (Build.VERSION.SDK_INT < 26 || this.isRepeating) {
            return;
        }
        a.a.f(wf.a.a, "NoticeRefreshHelper", "startRepeat", false, 4, (Object) null);
        if (this.manager == null) {
            Application a = Utils.a();
            Object systemService = a != null ? a.getSystemService("notification") : null;
            this.manager = systemService instanceof NotificationManager ? (NotificationManager) systemService : null;
        }
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacks(this.runnable);
        }
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.postDelayed(this.runnable, 30000L);
        }
        this.isRepeating = true;
    }

    private final void g() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.isRepeating = false;
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacks(this.runnable);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f();
        IntentFilter intentFilter = new IntentFilter(getPackageName());
        intentFilter.addAction("ACTION_NEW_MESSAGE");
        r1.a.b(this).c(this.localReceiver, intentFilter);
    }

    @Override // android.app.Service
    public void onDestroy() {
        g();
        r1.a.b(this).e(this.localReceiver);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        return 1;
    }
}
