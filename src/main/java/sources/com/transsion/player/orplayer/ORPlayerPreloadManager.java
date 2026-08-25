package com.transsion.player.orplayer;

import com.aliyun.loader.MediaLoader;
import com.aliyun.player.AliPlayerGlobalSettings;
import com.blankj.utilcode.util.Utils;
import com.transsion.gslb.BuildConfig;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ORPlayerPreloadManager implements MediaLoader.OnLoadStatusListener {
    public static final a i = new a(null);
    private static final Lazy j = LazyKt.b(new Function0() { // from class: com.transsion.player.orplayer.x
        public final Object invoke() {
            ORPlayerPreloadManager d;
            d = ORPlayerPreloadManager.d();
            return d;
        }
    });
    private final String a = "ORPlayerPreload";
    private final long b = 4000;
    private long c = 4000;
    private String d = BuildConfig.FLAVOR;
    private final CopyOnWriteArrayList e = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList f = new CopyOnWriteArrayList();
    private final CopyOnWriteArrayList g = new CopyOnWriteArrayList();
    private long h;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ORPlayerPreloadManager a() {
            return (ORPlayerPreloadManager) ORPlayerPreloadManager.j.getValue();
        }
    }

    public ORPlayerPreloadManager() {
        MediaLoader.getInstance().setOnLoadStatusListener(this);
        File externalCacheDir = Utils.a().getExternalCacheDir();
        String absolutePath = externalCacheDir != null ? externalCacheDir.getAbsolutePath() : null;
        String str = absolutePath + File.separator + "video_cache";
        try {
            Result.Companion companion = Result.Companion;
            AliPlayerGlobalSettings.enableLocalCache(true, 0, str);
            Result.constructor-impl(Unit.a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ORPlayerPreloadManager d() {
        return new ORPlayerPreloadManager();
    }

    private final void l(String str) {
        this.h = System.currentTimeMillis();
        sn.e.b(sn.e.a, this.a, "startPreload, url = " + str, false, 4, null);
        MediaLoader.getInstance().load(str, this.c);
    }

    public final void c() {
        sn.e.b(sn.e.a, this.a, "cancelAll", false, 4, null);
        this.d = BuildConfig.FLAVOR;
        this.g.clear();
        this.e.clear();
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new ORPlayerPreloadManager$cancelAll$1(null), 3, (Object) null);
    }

    public final boolean e(String str) {
        Intrinsics.h(str, "url");
        return this.f.contains(str);
    }

    public final boolean f(String str) {
        Intrinsics.h(str, "url");
        return (this.d.length() > 0 && Intrinsics.c(str, this.d)) || this.g.contains(str);
    }

    public final void g(String str) {
        Intrinsics.h(str, "url");
        if (!f(str)) {
            sn.e.b(sn.e.a, this.a, "pause, but not contains, PausedContains =  " + this.e.contains(str) + ", url = " + str, false, 4, null);
            return;
        }
        sn.e.b(sn.e.a, this.a, "pause, url = " + str, false, 4, null);
        this.e.add(str);
        if (!Intrinsics.c(this.d, str)) {
            if (this.g.contains(str)) {
                this.g.remove(str);
                return;
            }
            return;
        }
        this.d = BuildConfig.FLAVOR;
        MediaLoader.getInstance().pause(str);
        if (this.g.isEmpty()) {
            return;
        }
        Object i0 = CollectionsKt.i0(this.g);
        Intrinsics.g(i0, "first(...)");
        String str2 = (String) i0;
        this.d = str2;
        l(str2);
        this.g.remove(this.d);
    }

    public final void h() {
        sn.e.b(sn.e.a, this.a, "pauseAll, paused size = " + this.e.size() + ", urlsCache size = " + this.g.size() + ", curUrl = " + this.d + " ", false, 4, null);
        if (this.d.length() > 0) {
            MediaLoader.getInstance().pause(this.d);
            this.e.add(this.d);
            this.d = BuildConfig.FLAVOR;
        }
        if (this.g.isEmpty()) {
            return;
        }
        this.e.addAll(this.g);
        this.g.clear();
    }

    public final void i(String str) {
        Intrinsics.h(str, "url");
        j(str, this.b);
    }

    public final void j(String str, long j2) {
        Intrinsics.h(str, "url");
        if (j2 > 0) {
            this.c = j2;
        }
        if (f(str)) {
            sn.e.b(sn.e.a, this.a, "start preload, contains return~ url = " + str, false, 4, null);
            return;
        }
        if (this.e.contains(str)) {
            sn.e.b(sn.e.a, this.a, "start preload, pause contains resume~ url = " + str, false, 4, null);
            if (this.d.length() > 0) {
                this.g.add(str);
            } else {
                this.d = str;
                MediaLoader.getInstance().resume(str);
            }
            this.e.remove(str);
            return;
        }
        if (this.f.contains(str)) {
            sn.e.b(sn.e.a, this.a, "is preloaded, return, url = " + str, false, 4, null);
            return;
        }
        if (this.d.length() <= 0) {
            this.d = str;
            l(str);
            return;
        }
        if (System.currentTimeMillis() - this.h <= 5000) {
            sn.e.b(sn.e.a, this.a, "start preload, add to cache, url = " + str, false, 4, null);
            this.g.add(str);
            return;
        }
        sn.e.i(sn.e.a, this.a, "last is more than 5 sec, preload new url", false, 4, null);
        if (this.g.isEmpty()) {
            this.d = str;
            l(str);
            return;
        }
        Object i0 = CollectionsKt.i0(this.g);
        Intrinsics.g(i0, "first(...)");
        String str2 = (String) i0;
        this.d = str2;
        l(str2);
        this.g.remove(this.d);
        this.g.add(str);
    }

    public final void k() {
        sn.e.b(sn.e.a, this.a, "resumeAll, paused size = " + this.e.size() + ", urlsCache size = " + this.g.size() + ", curUrl = " + this.d + " ", false, 4, null);
        if (this.d.length() > 0) {
            return;
        }
        if (!this.e.isEmpty()) {
            Iterator it = this.e.iterator();
            Intrinsics.g(it, "iterator(...)");
            while (it.hasNext()) {
                String str = (String) it.next();
                if (this.d.length() > 0) {
                    this.g.add(str);
                } else {
                    Intrinsics.e(str);
                    this.d = str;
                    MediaLoader.getInstance().resume(str);
                }
            }
        }
        this.e.clear();
    }

    public void onCanceled(String str) {
    }

    public void onCompleted(String str) {
        sn.e.i(sn.e.a, this.a, "preload complete, url = " + str, false, 4, null);
        this.e.remove(str);
        if (this.g.isEmpty()) {
            this.d = BuildConfig.FLAVOR;
        } else {
            Object i0 = CollectionsKt.i0(this.g);
            Intrinsics.g(i0, "first(...)");
            String str2 = (String) i0;
            this.d = str2;
            l(str2);
            this.g.remove(this.d);
        }
        if (str != null) {
            this.f.add(str);
        }
    }

    public void onError(String str, int i2, String str2) {
        sn.e.b(sn.e.a, this.a, "preload error, " + (i2 == -300 ? "is preloaded code" : "errorCode") + " = " + i2 + ", errorMsg= " + str2 + ", url = " + str, false, 4, null);
        if (!this.g.isEmpty()) {
            Object i0 = CollectionsKt.i0(this.g);
            Intrinsics.g(i0, "first(...)");
            String str3 = (String) i0;
            this.d = str3;
            l(str3);
            this.g.remove(this.d);
        }
        this.e.remove(str);
        if (i2 == -300) {
            this.f.add(str);
        }
    }
}
