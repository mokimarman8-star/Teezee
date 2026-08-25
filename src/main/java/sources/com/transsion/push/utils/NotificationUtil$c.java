package com.transsion.push.utils;

import android.content.Context;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.transsion.pushapi.TriggerSource;
import kotlin.jvm.internal.Intrinsics;
import yg.m;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class NotificationUtil$c implements yg.m {
    final /* synthetic */ Context a;

    NotificationUtil$c(Context context) {
        this.a = context;
    }

    public void onConnected() {
        m.a.a(this);
    }

    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        NotificationUtil.a.P(this.a, TriggerSource.NETWORK_CONNECTED);
    }

    public void onDisconnected() {
    }
}
