package com.transsion.transfer.wifi.util;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i {
    public static final i a = new i();

    public static final class a implements WifiP2pManager.ActionListener {
        a() {
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onFailure(int i) {
            g gVar = g.a;
            i iVar = i.a;
            g.b(gVar, iVar.c() + " --> release() --> clearLocalServices() --> onFailure() --> reason = " + iVar.b(i), false, 2, null);
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onSuccess() {
            g.b(g.a, i.a.c() + " --> release() --> clearLocalServices() --> onSuccess()", false, 2, null);
        }
    }

    public static final class b implements WifiP2pManager.ActionListener {
        b() {
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onFailure(int i) {
            g gVar = g.a;
            i iVar = i.a;
            g.b(gVar, iVar.c() + " --> release() --> removeGroup() --> onFailure() --> reason = " + iVar.b(i), false, 2, null);
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onSuccess() {
            g.b(g.a, i.a.c() + " --> release() --> removeGroup() --> onSuccess()", false, 2, null);
        }
    }

    public static final class c implements WifiP2pManager.ActionListener {
        c() {
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onFailure(int i) {
            g gVar = g.a;
            i iVar = i.a;
            g.b(gVar, iVar.c() + " --> release() --> cancelConnect() --> onFailure() --> reason = " + iVar.b(i), false, 2, null);
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onSuccess() {
            g.b(g.a, i.a.c() + " --> release() --> cancelConnect() --> onSuccess()", false, 2, null);
        }
    }

    public static final class d implements WifiP2pManager.ActionListener {
        d() {
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onFailure(int i) {
            g gVar = g.a;
            i iVar = i.a;
            g.b(gVar, iVar.c() + " --> release() --> stopPeerDiscovery() --> onFailure() --> reason = " + iVar.b(i), false, 2, null);
        }

        @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
        public void onSuccess() {
            g.b(g.a, i.a.c() + " --> release() --> stopPeerDiscovery() --> onSuccess()", false, 2, null);
        }
    }

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c() {
        String simpleName = i.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final String b(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "unknown" : "3 -- 表示 {@link discoveryServices} 失败，因为没有添加服务请求。使用 {@link addServiceRequest} 添加服务请求。" : "2 -- 表示操作失败，因为框架正忙，无法处理请求" : "1 -- 表示操作失败，因为设备不支持 p2p。" : "0 -- 表示操作由于内部错误而失败。";
    }

    public final void d(WifiP2pManager wifiP2pManager, WifiP2pManager.Channel channel, boolean z, boolean z2, boolean z3, boolean z4) {
        if (channel != null) {
            if (Build.VERSION.SDK_INT > 26) {
                channel.close();
                g.b(g.a, a.c() + " --> release() --> WifiP2pManager.close() --> API27才有这个方法 --> 成功", false, 2, null);
            }
            if (z4 && wifiP2pManager != null) {
                wifiP2pManager.clearLocalServices(channel, new a());
            }
            if (z && wifiP2pManager != null) {
                wifiP2pManager.removeGroup(channel, new b());
            }
            if (z2 && wifiP2pManager != null) {
                wifiP2pManager.cancelConnect(channel, new c());
            }
            if (!z3 || wifiP2pManager == null) {
                return;
            }
            wifiP2pManager.stopPeerDiscovery(channel, new d());
        }
    }
}
