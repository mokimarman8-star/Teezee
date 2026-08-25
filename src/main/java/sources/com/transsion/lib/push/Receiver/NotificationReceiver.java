package com.transsion.lib.push.Receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.transsion.baselib.report.k;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.utils.NotificationUtil;
import com.transsion.push.utils.l;
import com.transsion.pushapi.TriggerSource;
import kotlin.Metadata;
import wf.a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/transsion/lib/push/Receiver/NotificationReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", BuildConfig.FLAVOR, "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "handler", "b", "push_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class NotificationReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: from kotlin metadata */
    private final Handler handler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Context context) {
        NotificationUtil.a.P(context, TriggerSource.UNLOCK);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x012a, code lost:
    
        if (r2.equals("android.intent.action.USER_UNLOCKED") == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x013b, code lost:
    
        r21.handler.postDelayed(new ol.a(r22), 10000);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0137, code lost:
    
        if (r2.equals("android.intent.action.USER_PRESENT") == false) goto L22;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(final Context context, Intent intent) {
        a.a aVar = a.a;
        aVar.c("NotificationReceiver", "onReceiver， context:" + context + " action " + (intent != null ? intent.getAction() : null), true);
        if (context != null) {
            k.a.s(intent != null ? intent.getAction() : null);
            l.a.a(intent != null ? intent.getAction() : null);
            String action = intent != null ? intent.getAction() : null;
            if (action != null) {
                switch (action.hashCode()) {
                    case -2128145023:
                        if (!action.equals("android.intent.action.SCREEN_OFF")) {
                        }
                        a.a.f(aVar, "NotificationReceiver", "onReceiver， " + intent.getAction(), false, 4, (Object) null);
                        break;
                    case -1886648615:
                        if (!action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        }
                        a.a.f(aVar, "NotificationReceiver", "onReceiver， " + intent.getAction(), false, 4, (Object) null);
                        break;
                    case -1454123155:
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            NotificationUtil.a.P(context, TriggerSource.SCREEN_ON);
                            break;
                        }
                        break;
                    case 823795052:
                        break;
                    case 833559602:
                        break;
                    case 1019184907:
                        if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                            a.a.f(aVar, "NotificationReceiver", "onReceiver， " + intent.getAction(), false, 4, (Object) null);
                            break;
                        }
                        break;
                    case 1083601606:
                        if (action.equals("com.community.oneroom.last_permanent_msg")) {
                            String stringExtra = intent.getStringExtra("extra_channel_id");
                            String stringExtra2 = intent.getStringExtra("MESSAGE_TYPE");
                            String stringExtra3 = intent.getStringExtra("extra_source");
                            String stringExtra4 = intent.getStringExtra("extra_message_id");
                            if (stringExtra4 != null) {
                                NotificationUtil.a.X(context, stringExtra4);
                                com.transsion.push.helper.a.a.a(stringExtra4, stringExtra, stringExtra3, stringExtra2, intent.getData(), true, (r23 & 64) != 0 ? BuildConfig.FLAVOR : "notification_last", (r23 & 128) != 0 ? BuildConfig.FLAVOR : null, (r23 & 256) != 0 ? BuildConfig.FLAVOR : null);
                                break;
                            }
                        }
                        break;
                    case 1884162848:
                        if (action.equals("com.community.oneroom.notification_delete")) {
                            String stringExtra5 = intent.getStringExtra("extra_channel_id");
                            String stringExtra6 = intent.getStringExtra("extra_notification_group_tag");
                            int intExtra = intent.getIntExtra("extra_notification_id", 0);
                            String stringExtra7 = intent.getStringExtra("MESSAGE_TYPE");
                            String stringExtra8 = intent.getStringExtra("extra_source");
                            String stringExtra9 = intent.getStringExtra("extra_message_id");
                            NotificationUtil.a.q(context, stringExtra6, intExtra);
                            com.transsion.push.helper.a.a.a(stringExtra9, stringExtra5, stringExtra8, stringExtra7, intent.getData(), true, (r23 & 64) != 0 ? BuildConfig.FLAVOR : "notification_close", (r23 & 128) != 0 ? BuildConfig.FLAVOR : null, (r23 & 256) != 0 ? BuildConfig.FLAVOR : null);
                            break;
                        }
                        break;
                    case 1950024803:
                        if (action.equals("com.community.oneroom.next_permanent_msg")) {
                            String stringExtra10 = intent.getStringExtra("extra_channel_id");
                            String stringExtra11 = intent.getStringExtra("MESSAGE_TYPE");
                            String stringExtra12 = intent.getStringExtra("extra_source");
                            String stringExtra13 = intent.getStringExtra("extra_message_id");
                            if (stringExtra13 != null) {
                                NotificationUtil.Z(NotificationUtil.a, context, stringExtra13, false, 4, (Object) null);
                                com.transsion.push.helper.a.a.a(stringExtra13, stringExtra10, stringExtra12, stringExtra11, intent.getData(), true, (r23 & 64) != 0 ? BuildConfig.FLAVOR : "notification_next", (r23 & 128) != 0 ? BuildConfig.FLAVOR : null, (r23 & 256) != 0 ? BuildConfig.FLAVOR : null);
                                break;
                            }
                        }
                        break;
                }
            }
        }
    }
}
