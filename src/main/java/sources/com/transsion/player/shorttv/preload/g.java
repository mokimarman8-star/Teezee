package com.transsion.player.shorttv.preload;

import android.content.Context;
import android.util.Log;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.scheduler.Requirements;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g {
    public static final a g = new a(null);
    private final Context a;
    private final List b;
    private int c;
    private String d;
    private final b e;
    private final ConcurrentHashMap f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final class b implements DownloadManager.d {
        b() {
        }

        public void a(DownloadManager downloadManager, boolean z) {
            Intrinsics.h(downloadManager, "downloadManager");
        }

        public void b(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c cVar) {
            Intrinsics.h(downloadManager, "downloadManager");
            Intrinsics.h(cVar, "download");
        }

        public void c(DownloadManager downloadManager, boolean z) {
            Intrinsics.h(downloadManager, "downloadManager");
        }

        public void d(DownloadManager downloadManager) {
            Intrinsics.h(downloadManager, "downloadManager");
            Log.e("VideoPreloadHelper", "onIdle:");
            g.this.m();
        }

        public void e(DownloadManager downloadManager, Requirements requirements, int i) {
            Intrinsics.h(downloadManager, "downloadManager");
            Intrinsics.h(requirements, "requirements");
        }

        public void f(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c cVar, Exception exc) {
            Intrinsics.h(downloadManager, "downloadManager");
            Intrinsics.h(cVar, "download");
            Log.e("VideoPreloadHelper", "onDownloadChanged:  download.requestId:" + cVar.a.id + "     bytesDownloaded:" + cVar.a() + "  contentLength:" + cVar.e + "  percentDownloaded:" + cVar.b());
            com.transsion.player.shorttv.preload.a aVar = (com.transsion.player.shorttv.preload.a) g.this.f.get(cVar.a.id);
            if (aVar != null) {
                aVar.h(cVar.a());
                aVar.g(cVar.e);
            }
            if (Intrinsics.c(cVar.a.id, g.this.d)) {
                int i = cVar.b;
                if (i == 1 || i == 3 || i == 4) {
                    g.this.d = null;
                    g.this.m();
                }
            }
        }

        public void g(DownloadManager downloadManager) {
            Intrinsics.h(downloadManager, "downloadManager");
        }
    }

    public g(Context context) {
        Intrinsics.h(context, "context");
        this.a = context;
        this.b = new CopyOnWriteArrayList();
        b bVar = new b();
        this.e = bVar;
        this.f = new ConcurrentHashMap();
        in.a.h(context).d(bVar);
    }

    private final void i(int i) {
        gn.e eVar;
        if (i < 0 || i >= this.b.size() || (eVar = (gn.e) this.b.get(i)) == null) {
            return;
        }
        Log.e("VideoPreloadHelper", "checkToPause   position:" + i + "  shortTVItem:" + eVar);
        q.a.D(eVar.f());
    }

    private final void j(int i) {
        final gn.e eVar;
        if (i < 0 || i >= this.b.size() || (eVar = (gn.e) this.b.get(i)) == null) {
            return;
        }
        q.a.z(new Runnable() { // from class: com.transsion.player.shorttv.preload.f
            @Override // java.lang.Runnable
            public final void run() {
                g.k(gn.e.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(gn.e eVar, g gVar) {
        gVar.f.put(eVar.f(), q.a.w(eVar));
    }

    private final com.transsion.player.shorttv.preload.a l(int i, gn.e eVar) {
        com.transsion.player.shorttv.preload.a aVar = (com.transsion.player.shorttv.preload.a) this.f.get(eVar.f());
        if (aVar != null) {
            Log.e("VideoPreloadHelper", "createDownloadRequest [from map] position:" + i + "  shortTVItem:" + eVar);
            return aVar;
        }
        String f = eVar.f();
        com.transsion.player.shorttv.preload.a n = q.a.n(eVar);
        this.f.put(f, n);
        Log.e("VideoPreloadHelper", "createDownloadRequest [from new] position:" + i + "  shortTVItem:" + eVar);
        return n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(g gVar, int i) {
        int size = gVar.b.size();
        Log.e("VideoPreloadHelper", "loadNext， position:" + i + "   size:" + size);
        int h = RangesKt.h(i + 6, size);
        for (int i2 = i + 1; i2 < h; i2++) {
            gn.e eVar = (gn.e) gVar.b.get(i2);
            if (eVar != null) {
                com.transsion.player.shorttv.preload.a l = gVar.l(i2, eVar);
                l.i(307200L);
                if (l.b() < l.d()) {
                    Log.e("VideoPreloadHelper", "非当前选中  下载大小 downloadLength:" + l.b() + "  index:" + i2);
                    gVar.d = l.c();
                    q.a.s(l);
                    return;
                }
                l.b();
                l.a();
                Log.e("VideoPreloadHelper", "非当前选中  下载大小 downloadLength:" + l.b() + " 大于最小下载，跳过 index:" + i2);
            }
        }
        Log.e("VideoPreloadHelper", "不用全量下载");
    }

    public final void f(int i, gn.e eVar) {
        Intrinsics.h(eVar, "mediaSource");
        if (i <= this.b.size()) {
            this.b.add(i, eVar);
        }
        m();
    }

    public final void g(gn.e eVar) {
        Intrinsics.h(eVar, "mediaSource");
        this.b.add(eVar);
        m();
    }

    public final void h(int i) {
        Log.e("VideoPreloadHelper", "changeSelect  position:" + i);
        if (this.c == i) {
            return;
        }
        this.d = null;
        this.c = i;
        i(i);
        j(this.c + 1);
    }

    public final void m() {
        final int i = this.c;
        if (i >= 0 && this.d == null) {
            q.a.z(new Runnable() { // from class: com.transsion.player.shorttv.preload.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.n(g.this, i);
                }
            });
        }
    }

    public final void o() {
        i(this.c);
        this.c = -1;
    }

    public final void p() {
        in.a.h(this.a).w(this.e);
        o();
    }

    public final void q(String str) {
        Intrinsics.h(str, "key");
        this.f.remove(str);
        q.a.x(str);
    }
}
