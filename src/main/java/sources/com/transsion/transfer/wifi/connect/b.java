package com.transsion.transfer.wifi.connect;

import android.net.Network;
import java.net.InetAddress;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface b {

    public static final class a {
        public static void a(b bVar, int i) {
        }

        public static void b(b bVar, Network network) {
            Intrinsics.h(network, "network");
        }

        public static void c(b bVar, String ip) {
            Intrinsics.h(ip, "ip");
        }

        public static void d(b bVar) {
        }

        public static void e(b bVar, InetAddress inetAddress) {
        }
    }

    void a(Network network);

    void b(int i);

    void c(InetAddress inetAddress);

    void d(int i);

    void e(String str);

    void onStart();
}
