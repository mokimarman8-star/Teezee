package com.transsion.lib_web.download_render.init;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import kotlin.jvm.internal.Intrinsics;
import yg.k;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements c {
    private final Context a;

    public d(Context context) {
        Intrinsics.h(context, "context");
        this.a = context;
    }

    @Override // com.transsion.lib_web.download_render.init.c
    public void invoke() {
        Object systemService = this.a.getSystemService("connectivity");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (Build.VERSION.SDK_INT >= 24) {
            e2.b.a(connectivityManager, k.g.a());
        } else {
            connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), (ConnectivityManager.NetworkCallback) k.g.a());
        }
        com.transsion.lib_web.download_render.utils.d.a.d();
        yl.e.a.d();
    }
}
