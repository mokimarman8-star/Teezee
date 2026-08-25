package com.transsion.ad.strategy;

import android.net.Network;
import android.net.NetworkCapabilities;
import com.transsion.ad.ps.attribution.AttributionConsumeManager;
import com.transsion.gslb.BuildConfig;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import yg.m;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class AdObserveNetworkState implements yg.m {
    private String a = BuildConfig.FLAVOR;
    private AtomicBoolean b = new AtomicBoolean(false);
    private boolean c;

    /* JADX INFO: Access modifiers changed from: private */
    public final String e() {
        String simpleName = AdObserveNetworkState.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void f(String str) {
        Intrinsics.h(str, "adConfigUrl");
        this.a = str;
        xh.a.c(xh.a.a, e() + " --> registerNetworkStatusChangedListener() --> 网络变化监听 success", 0, false, 6, null);
        yg.l.a.l(this);
    }

    public void onConnected() {
        m.a.a(this);
    }

    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new AdObserveNetworkState$onConnected$1(null), 3, (Object) null);
        AttributionConsumeManager.c.n();
        if (this.b.get()) {
            xh.a.e(xh.a.a, null, e() + " --> onConnected() --> isLoading == true", 5, false, 9, null);
            return;
        }
        this.b.set(true);
        if (!this.c) {
            kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new AdObserveNetworkState$onConnected$2(this, null), 3, (Object) null);
            return;
        }
        xh.a.e(xh.a.a, null, e() + " --> onConnected() --> result == true --> 生命周期内已经请求成功", 5, false, 9, null);
    }

    public void onDisconnected() {
    }
}
