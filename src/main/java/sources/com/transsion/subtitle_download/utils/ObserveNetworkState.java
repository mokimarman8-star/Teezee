package com.transsion.subtitle_download.utils;

import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import yg.l;
import yg.m;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class ObserveNetworkState implements m {
    public static final ObserveNetworkState a = new ObserveNetworkState();

    private ObserveNetworkState() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String b() {
        String simpleName = ObserveNetworkState.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void c(String str) {
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new ObserveNetworkState$retryDownload$1(str, null), 3, (Object) null);
    }

    public final void d() {
        l.a.l(this);
        c("冷启动");
    }

    public void onConnected() {
        m.a.a(this);
    }

    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        b.a.a(b() + " --> onConnected() --> 网络重新链接的时候检查一下字幕下载 --> 延迟5秒，优化网络抖动 .....");
        c("网络重新连接");
    }

    public void onDisconnected() {
    }
}
