package com.transsion.postdetail.util;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.AppDatabase$f1;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import com.transsion.gslb.BuildConfig;
import com.transsion.shorttv.bean.ShortTVItem;
import com.transsion.shorttv.bean.ShortTvInfoEpisodeList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
public final class ShortTVFloatManager extends com.transsion.videofloat.manager.b {
    public static final ShortTVFloatManager b = new ShortTVFloatManager();
    private static final sr.a c = (sr.a) kg.c.e.a().h(sr.a.class);
    private static final Lazy d = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.util.h
        public final Object invoke() {
            com.transsnet.downloader.manager.g i;
            i = ShortTVFloatManager.i();
            return i;
        }
    });
    private static final Lazy e = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.util.i
        public final Object invoke() {
            ShortTVPlayDao x;
            x = ShortTVFloatManager.x();
            return x;
        }
    });

    private ShortTVFloatManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g i() {
        return com.transsnet.downloader.manager.p.a.a(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsnet.downloader.manager.g j() {
        return (com.transsnet.downloader.manager.g) d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ShortTVPlayDao l() {
        return (ShortTVPlayDao) e.getValue();
    }

    private final void m(String str, int i, Function1 function1) {
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new ShortTVFloatManager$getShortTvEpisodeList$1(i, str, function1, null), 3, (Object) null);
    }

    private final void n(dw.a aVar, List list) {
        Object obj;
        Map b2;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ShortTVItem shortTVItem = (ShortTVItem) it.next();
                Iterator it2 = b.a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    nr.k kVar = (nr.k) obj;
                    if ((kVar instanceof nr.e) && ((nr.e) kVar).c() == shortTVItem.getEp()) {
                        break;
                    }
                }
                nr.k kVar2 = (nr.k) obj;
                if (kVar2 != null && (kVar2 instanceof nr.e)) {
                    nr.e eVar = (nr.e) kVar2;
                    ShortTVItem d2 = eVar.d();
                    String id = d2 != null ? d2.getId() : null;
                    if (id != null && id.length() != 0) {
                        shortTVItem.setId(id);
                    }
                    a.a.f(wf.a.a, "VideoFloat", "handleNewData----设置播放数据  ep:" + shortTVItem.getEp(), false, 4, (Object) null);
                    eVar.h(shortTVItem);
                }
                gn.e mediaSource = shortTVItem.toMediaSource();
                if (mediaSource != null) {
                    com.transsion.player.orplayer.f f = aVar.f();
                    pn.f fVar = f instanceof pn.f ? (pn.f) f : null;
                    boolean containsKey = (fVar == null || (b2 = fVar.b()) == null) ? false : b2.containsKey(mediaSource.e());
                    a.a.f(wf.a.a, "VideoFloat", "addDataSource----updateShortTvInfoList  ep:" + shortTVItem.getEp() + ",inPlayerList:" + containsKey, false, 4, (Object) null);
                    if (!containsKey) {
                        aVar.f().addDataSource(mediaSource);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(dw.a aVar) {
        b.o();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("oneroom://com.community.oneroom?type=/shorts/detail&id=" + (aVar != null ? aVar.r() : null) + "&ep=" + (aVar != null ? Integer.valueOf(aVar.c()) : null) + "&ms=" + (aVar != null ? Long.valueOf(aVar.n()) : null)));
        intent.setFlags(268435456);
        Utils.a().startActivity(intent);
        return Unit.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(dw.a aVar, ShortTvInfoEpisodeList shortTvInfoEpisodeList) {
        if (shortTvInfoEpisodeList != null) {
            b.n(aVar, shortTvInfoEpisodeList.getItems());
        }
        return Unit.a;
    }

    private final void u(dw.a aVar, Function0 function0) {
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new ShortTVFloatManager$saveHistoryInner$1(aVar, function0, null), 3, (Object) null);
    }

    static /* synthetic */ void v(ShortTVFloatManager shortTVFloatManager, dw.a aVar, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        shortTVFloatManager.u(aVar, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortTVPlayDao x() {
        AppDatabase$f1 appDatabase$f1 = AppDatabase.p;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return appDatabase$f1.b(a).w1();
    }

    public final String k(String str) {
        Intrinsics.h(str, "subjectId");
        return "SHORT_TV" + str;
    }

    public void o() {
        a().clear();
    }

    public void p(final dw.a aVar) {
        u(aVar, new Function0() { // from class: com.transsion.postdetail.util.k
            public final Object invoke() {
                Unit q;
                q = ShortTVFloatManager.q(aVar);
                return q;
            }
        });
    }

    public boolean r(final dw.a aVar) {
        nr.k kVar;
        String str;
        Iterator it = a().iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            nr.k kVar2 = (nr.k) it.next();
            nr.e eVar = kVar2 instanceof nr.e ? (nr.e) kVar2 : null;
            if (Intrinsics.c(eVar != null ? Integer.valueOf(eVar.c()) : null, aVar != null ? Integer.valueOf(aVar.c()) : null)) {
                break;
            }
            i++;
        }
        int size = a().size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = 0;
                kVar = null;
                break;
            }
            kVar = (nr.k) a().get(i2);
            if (i2 > i && (kVar instanceof nr.e)) {
                break;
            }
            i2++;
        }
        nr.e eVar2 = (nr.e) kVar;
        wf.a.a.c("VideoFloat", "shorttv-----playNext, size:" + a().size() + ", ep:" + (aVar != null ? Integer.valueOf(aVar.c()) : null) + " nextEp:" + (eVar2 != null ? Integer.valueOf(eVar2.c()) : null), true);
        if (kVar == null) {
            return false;
        }
        int i3 = i2 + 5;
        if (a().size() > i3) {
            nr.k kVar3 = (nr.k) a().get(i3);
            if (kVar3 instanceof nr.e) {
                nr.e eVar3 = (nr.e) kVar3;
                if (nr.l.b(eVar3) && aVar != null) {
                    b.m(aVar.r(), eVar3.c(), new Function1() { // from class: com.transsion.postdetail.util.j
                        public final Object invoke(Object obj) {
                            Unit s;
                            s = ShortTVFloatManager.s(aVar, (ShortTvInfoEpisodeList) obj);
                            return s;
                        }
                    });
                }
            }
        }
        if (aVar != null) {
            nr.e eVar4 = (nr.e) kVar;
            aVar.z(eVar4.c());
            aVar.F(0L);
            com.transsion.player.orplayer.f f = aVar.f();
            ShortTVItem d2 = eVar4.d();
            if (d2 == null || (str = d2.getId()) == null) {
                str = BuildConfig.FLAVOR;
            }
            f.seekTo(str, 0L);
            aVar.f().play();
        }
        return true;
    }

    public void t(dw.a aVar) {
        v(this, aVar, null, 2, null);
    }

    public void w(List list) {
        Intrinsics.h(list, "list");
        a.a.f(wf.a.a, "VideoFloat", "shorttv-----setPlayList:" + list.size(), false, 4, (Object) null);
        a().clear();
        a().addAll(list);
    }
}
