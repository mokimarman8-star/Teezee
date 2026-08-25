package com.transsion.postdetail.util;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.baselib.db.video.UGCVideoDetailPlayDao;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv_pugc.ShorttvModel;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class UGCShortTVFloatManager extends com.transsion.videofloat.manager.b {
    public static final UGCShortTVFloatManager b = new UGCShortTVFloatManager();
    private static final sr.a c = (sr.a) kg.c.e.a().h(sr.a.class);
    private static final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.util.o
        public final Object invoke() {
            com.transsnet.downloader.manager.g g;
            g = UGCShortTVFloatManager.g();
            return g;
        }
    });
    private static final Lazy e = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.util.p
        public final Object invoke() {
            UGCVideoDetailPlayDao s;
            s = UGCShortTVFloatManager.s();
            return s;
        }
    });
    private static final Lazy f = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.util.q
        public final Object invoke() {
            ShortTVPlayDao r;
            r = UGCShortTVFloatManager.r();
            return r;
        }
    });

    private UGCShortTVFloatManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g g() {
        return com.transsnet.downloader.manager.p.a.a(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UGCVideoDetailPlayDao i() {
        return (UGCVideoDetailPlayDao) e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(dw.a aVar) {
        UGCVideo v;
        b.j();
        if (aVar != null && (v = aVar.v()) != null) {
            hu.b.b(v, (Function1) null, 1, (Object) null);
        }
        return Unit.a;
    }

    private final void o(dw.a aVar, Function0 function0) {
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new UGCShortTVFloatManager$saveHistoryInner$1(aVar, function0, null), 3, (Object) null);
    }

    static /* synthetic */ void p(UGCShortTVFloatManager uGCShortTVFloatManager, dw.a aVar, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        uGCShortTVFloatManager.o(aVar, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortTVPlayDao r() {
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return appDatabase$f1.b(a).w1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UGCVideoDetailPlayDao s() {
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return appDatabase$f1.b(a).B1();
    }

    public final String h(String str) {
        Intrinsics.h(str, "ugcVideoId");
        return "SHORT_TV" + str;
    }

    public void j() {
        a().clear();
    }

    public void k(final dw.a aVar) {
        o(aVar, new Function0() { // from class: com.transsion.postdetail.util.r
            public final Object invoke() {
                Unit l;
                l = UGCShortTVFloatManager.l(aVar);
                return l;
            }
        });
    }

    public boolean m(dw.a aVar) {
        ShorttvModel.UGCVideo uGCVideo;
        Iterator it = a().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            ShorttvModel.UGCVideo uGCVideo2 = (ShorttvModel.UGCVideo) it.next();
            if (!(uGCVideo2 instanceof ShorttvModel.UGCVideo)) {
                uGCVideo2 = null;
            }
            if (Intrinsics.c(uGCVideo2 != null ? Integer.valueOf(uGCVideo2.getEp()) : null, aVar != null ? Integer.valueOf(aVar.c()) : null)) {
                break;
            }
            i++;
        }
        int size = a().size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = 0;
                uGCVideo = null;
                break;
            }
            uGCVideo = (ShorttvModel.UGCVideo) a().get(i2);
            if (i2 > i && (uGCVideo instanceof ShorttvModel.UGCVideo)) {
                break;
            }
            i2++;
        }
        wf.a.a.c("VideoFloat", "shorttv-----playNext, size:" + a().size() + ", ep:" + (aVar != null ? Integer.valueOf(aVar.c()) : null) + " nextEp:" + (uGCVideo != null ? Integer.valueOf(uGCVideo.getEp()) : null), true);
        if (uGCVideo == null) {
            return false;
        }
        int i3 = i2 + 5;
        if (a().size() > i3) {
            ShorttvModel.UGCVideo uGCVideo3 = (ShorttvModel.UGCVideo) a().get(i3);
            if (uGCVideo3 instanceof ShorttvModel.UGCVideo) {
                uGCVideo3.isDataNotComplete();
            }
        }
        if (aVar != null) {
            aVar.z(uGCVideo.getEp());
            aVar.F(0L);
            com.transsion.player.orplayer.f f2 = aVar.f();
            String playUrl = uGCVideo.getPlayUrl();
            if (playUrl == null) {
                playUrl = BuildConfig.FLAVOR;
            }
            f2.seekTo(playUrl, 0L);
            aVar.f().play();
        }
        return true;
    }

    public void n(dw.a aVar) {
        p(this, aVar, null, 2, null);
    }

    public void q(List list) {
        Intrinsics.h(list, "list");
        a.a.f(wf.a.a, "VideoFloat", "shorttv-----setPlayList:" + list.size(), false, 4, (Object) null);
        a().clear();
        a().addAll(list);
    }
}
