package com.tmc.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rf.c;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/tmc/network/NetworkMonitor$mReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", TtmlNode.ANONYMOUS_REGION_ID, "c", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class NetworkMonitor$mReceiver$1 extends BroadcastReceiver {
    NetworkMonitor$mReceiver$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onReceive$lambda-0, reason: not valid java name */
    public static final void m77onReceive$lambda0(Context context) {
        Intrinsics.h(context, "$c");
        NetworkMonitor.INSTANCE.checkNetworkStatus(context);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context c, Intent intent) {
        Intrinsics.h(c, "c");
        Intrinsics.h(intent, "intent");
        c a = c.c.a();
        if (a == null) {
            return;
        }
        a.a(new Runnable() { // from class: com.tmc.network.b
            @Override // java.lang.Runnable
            public final void run() {
                NetworkMonitor$mReceiver$1.m77onReceive$lambda0(c);
            }
        });
    }
}
