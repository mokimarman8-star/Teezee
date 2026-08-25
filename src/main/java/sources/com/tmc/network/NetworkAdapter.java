package com.tmc.network;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rf.c;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/tmc/network/NetworkAdapter;", TtmlNode.ANONYMOUS_REGION_ID, "()V", "MAX_PRE_CONNECT", TtmlNode.ANONYMOUS_REGION_ID, "isInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "init", TtmlNode.ANONYMOUS_REGION_ID, "startPreConnect", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class NetworkAdapter {
    private static final int MAX_PRE_CONNECT = 3;
    public static final NetworkAdapter INSTANCE = new NetworkAdapter();
    private static final AtomicBoolean isInit = new AtomicBoolean(false);

    private NetworkAdapter() {
    }

    private final void startPreConnect() {
        NetworkConfig networkConfig = NetworkConfig.INSTANCE;
        if (!networkConfig.isNetworkImproveEnable()) {
            rf.b.a.c("isNetworkImprove is disable.");
            return;
        }
        if (networkConfig.getPreConnectList().isEmpty()) {
            rf.b.a.c("preConnectList is empty");
            return;
        }
        c a = c.c.a();
        if (a == null) {
            return;
        }
        a.a(new Runnable() { // from class: com.tmc.network.a
            @Override // java.lang.Runnable
            public final void run() {
                NetworkAdapter.m76startPreConnect$lambda0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: startPreConnect$lambda-0, reason: not valid java name */
    public static final void m76startPreConnect$lambda0() {
        Iterator<String> it = NetworkConfig.INSTANCE.getPreConnectList().iterator();
        int i = 0;
        while (it.hasNext()) {
            String next = it.next();
            if (i >= 3) {
                return;
            }
            Intrinsics.g(next, "url");
            new com.tmc.network.strategy.c(next).a();
            i++;
        }
    }

    public final void init() {
        rf.b.a.c("NetworkAdapter init");
        if (isInit.compareAndSet(false, true)) {
            startPreConnect();
        }
    }
}
