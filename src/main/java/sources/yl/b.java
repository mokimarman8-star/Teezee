package yl;

import android.net.Network;
import android.net.NetworkCapabilities;
import com.transsion.lib_web.download_render.FileDownloadTaskManager;
import com.transsion.lib_web.download_render.FileRemoteDataManager;
import kotlin.jvm.internal.Intrinsics;
import pl.h;
import yg.l;
import yg.m;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements m {
    public static final b a = new b();

    private b() {
    }

    private final String a() {
        String simpleName = b.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void b() {
        l.a.l(this);
    }

    public void onConnected() {
        m.a.a(this);
    }

    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        com.transsion.lib_web.download_render.utils.d.a.b();
        FileDownloadTaskManager.a.l();
        FileRemoteDataManager.a.k();
        h.a.c(a() + " --> onConnected() --> 网络重新链接的时候检查一下字幕下载 --> 延迟5秒，优化网络抖动 .....");
    }

    public void onDisconnected() {
        com.transsion.lib_web.download_render.utils.d.a.c();
    }
}
