package com.transsnet.downloader.proxy;

import android.content.Context;
import com.danikula.videocache.HttpProxyCacheServer;
import com.danikula.videocache.q;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import ui.m0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    private HttpProxyCacheServer a;
    private DownloadFileCache b;
    private boolean c;
    private String d = HttpUrl.FRAGMENT_ENCODE_SET;

    public final void a(String resourceId, c callback) {
        Intrinsics.h(resourceId, "resourceId");
        Intrinsics.h(callback, "callback");
        DownloadFileCache downloadFileCache = this.b;
        if (downloadFileCache != null) {
            downloadFileCache.f(resourceId, callback);
        }
    }

    public final void b() {
        DownloadFileCache downloadFileCache = this.b;
        if (downloadFileCache != null) {
            downloadFileCache.B();
        }
    }

    public final void c() {
        HttpProxyCacheServer httpProxyCacheServer = this.a;
        if (httpProxyCacheServer != null) {
            httpProxyCacheServer.g();
        }
    }

    public final DownloadBean d() {
        DownloadFileCache downloadFileCache;
        DownloadFileCache downloadFileCache2 = this.b;
        if ((downloadFileCache2 == null || !downloadFileCache2.l()) && (downloadFileCache = this.b) != null) {
            return downloadFileCache.i();
        }
        return null;
    }

    public final m0 e() {
        DownloadFileCache downloadFileCache = this.b;
        if (downloadFileCache != null) {
            return downloadFileCache.j();
        }
        return null;
    }

    public final String f(DownloadBean bean) {
        DownloadFileCache downloadFileCache;
        String j;
        Intrinsics.h(bean, "bean");
        DownloadFileCache downloadFileCache2 = this.b;
        DownloadBean i = downloadFileCache2 != null ? downloadFileCache2.i() : null;
        if ((i == null || !Intrinsics.c(i.getResourceId(), bean.getResourceId())) && (downloadFileCache = this.b) != null) {
            downloadFileCache.q(bean);
        }
        String resourceId = bean.getResourceId();
        if (resourceId == null) {
            resourceId = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        this.d = resourceId;
        HttpProxyCacheServer httpProxyCacheServer = this.a;
        return (httpProxyCacheServer == null || (j = httpProxyCacheServer.j(bean.getUrl(), bean.getPath(), true)) == null) ? bean.getUrl() : j;
    }

    public final void g(Context context) {
        Intrinsics.h(context, "context");
        if (this.c) {
            return;
        }
        this.c = true;
        q.d(false);
        this.b = new DownloadFileCache();
        this.a = new HttpProxyCacheServer.a(context).c(new File(DownloadEsHelper.m.a().h().getAbsolutePath())).d(this.b).a();
    }

    public final void h() {
        this.d = HttpUrl.FRAGMENT_ENCODE_SET;
        DownloadFileCache downloadFileCache = this.b;
        if (downloadFileCache != null) {
            downloadFileCache.o();
        }
    }

    public final void i(String resourceId) {
        Intrinsics.h(resourceId, "resourceId");
        DownloadFileCache downloadFileCache = this.b;
        if (downloadFileCache != null) {
            downloadFileCache.n(resourceId);
        }
    }

    public final void j(String contentType, String resourceId) {
        Intrinsics.h(contentType, "contentType");
        Intrinsics.h(resourceId, "resourceId");
        if (this.d.length() <= 0 || Intrinsics.c(this.d, resourceId)) {
            DownloadFileCache downloadFileCache = this.b;
            if (downloadFileCache != null) {
                downloadFileCache.p(contentType);
            }
            q.a("setCurDownloadContentType, contentType = " + contentType);
        }
    }
}
