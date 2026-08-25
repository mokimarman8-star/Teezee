package com.transsnet.downloader.viewmodel;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.b0;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.launch.b;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.manager.DownloadEsHelper;
import com.transsnet.downloader.viewmodel.DownloadListManager$handleDownloaded$;
import com.transsnet.downloader.viewmodel.DownloadListManager$handleDownloaded$lambda$14$;
import cx.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class DownloadListManager {
    public static final a m = new a((DefaultConstructorMarker) null);
    private static final Lazy n = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsnet.downloader.viewmodel.c
        public final Object invoke() {
            DownloadListManager U;
            U = DownloadListManager.U();
            return U;
        }
    });
    private b0 g;
    private b0 h;
    private b0 j;
    private final Lazy a = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.d
        public final Object invoke() {
            a X;
            X = DownloadListManager.X();
            return X;
        }
    });
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.e
        public final Object invoke() {
            ui.c t;
            t = DownloadListManager.t();
            return t;
        }
    });
    private final Lazy c = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.f
        public final Object invoke() {
            b0 u;
            u = DownloadListManager.u();
            return u;
        }
    });
    private final Lazy d = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.g
        public final Object invoke() {
            b0 w;
            w = DownloadListManager.w();
            return w;
        }
    });
    private final Lazy e = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.h
        public final Object invoke() {
            b0 y;
            y = DownloadListManager.y();
            return y;
        }
    });
    private final Lazy f = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.viewmodel.i
        public final Object invoke() {
            b0 W;
            W = DownloadListManager.W();
            return W;
        }
    });
    private ConcurrentHashMap i = new ConcurrentHashMap();
    private boolean k = true;
    private Map l = new LinkedHashMap();

    public static /* synthetic */ void I(DownloadListManager downloadListManager, boolean z, boolean z2, BiddingNativeManager biddingNativeManager, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        if ((i & 4) != 0) {
            biddingNativeManager = null;
        }
        downloadListManager.H(z, z2, biddingNativeManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a L() {
        return (a) this.a.getValue();
    }

    public static /* synthetic */ void N(DownloadListManager downloadListManager, String str, int i, int i2, String str2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 1;
        }
        int i6 = i;
        if ((i4 & 4) != 0) {
            i2 = 20;
        }
        int i7 = i2;
        if ((i4 & 8) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i4 & 16) != 0) {
            i3 = b.a.b().getInt("download_last_resolution", 0);
        }
        downloadListManager.M(str, i6, i7, str3, i3);
    }

    private final List R(List list) {
        Iterator it;
        int i = 0;
        int i2 = 1;
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            DownloadBean downloadBean = (DownloadBean) it2.next();
            if (linkedHashMap.containsKey(downloadBean.getSubjectId())) {
                if (downloadBean.isVideo() && Intrinsics.c(downloadBean.getResourceId(), downloadBean.getUrl())) {
                    arrayList.add(downloadBean);
                } else {
                    List list2 = (List) linkedHashMap.get(downloadBean.getSubjectId());
                    if (list2 != null) {
                        list2.add(downloadBean);
                    }
                }
            } else if (downloadBean.getSubjectId() != null) {
                String subjectId = downloadBean.getSubjectId();
                Intrinsics.e(subjectId);
                linkedHashMap.put(subjectId, CollectionsKt.q(new DownloadBean[]{downloadBean}));
            } else {
                arrayList.add(downloadBean);
            }
        }
        Iterator it3 = linkedHashMap.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            if (((List) entry.getValue()).size() == i2) {
                arrayList.add(((List) entry.getValue()).get(i));
            } else if (((List) entry.getValue()).size() > i2) {
                DownloadBean downloadBean2 = (DownloadBean) ((List) entry.getValue()).get(i);
                DownloadBean downloadBean3 = new DownloadBean("series", "series", "", downloadBean2.getCover(), 0L, (String) null, (String) null, (String) null, (Long) null, downloadBean2.getUpdateTimeStamp(), 0L, 0, 0, 0, 0L, downloadBean2.getCreateAt(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (String) null, (String) null, (String) null, (String) null, 0L, 0, 0, (String) null, (String) null, 0L, (String) null, (String) null, 0L, 0, 0L, (String) null, 0, (String) null, (String) null, false, false, 0, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (Long) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, -33312, -1, 65535, (DefaultConstructorMarker) null);
                downloadBean3.setStatus(10);
                List list3 = (List) entry.getValue();
                if (list3.size() > i2) {
                    CollectionsKt.A(list3, new DownloadListManager$handleDownloaded$lambda$14$.inlined.sortBy.1());
                }
                downloadBean3.getSeriesList().addAll((Collection) entry.getValue());
                DownloadBean downloadBean4 = downloadBean2;
                long j = 0;
                long j2 = 0;
                long j3 = 0;
                boolean z = false;
                int i3 = 0;
                boolean z2 = false;
                for (DownloadBean downloadBean5 : (List) entry.getValue()) {
                    Iterator it4 = it3;
                    if (downloadBean5.getStatus() == 14) {
                        it3 = it4;
                        i3 = 1;
                    } else {
                        if (downloadBean5.isTransferFailed()) {
                            z = true;
                        }
                        if (!z2 && !downloadBean5.isTransferFailed() && downloadBean5.isFileExist()) {
                            downloadBean4 = downloadBean5;
                            z2 = true;
                        }
                        Long size = downloadBean5.getSize();
                        j += size != null ? size.longValue() : 0L;
                        Long duration = downloadBean5.getDuration();
                        j2 += duration != null ? duration.longValue() : 0L;
                        j3 += downloadBean5.getReadProgress();
                        it3 = it4;
                    }
                }
                it = it3;
                downloadBean3.setTransferFailed(z);
                downloadBean3.setThumbnail(downloadBean2.getThumbnail());
                downloadBean3.setCount(((List) entry.getValue()).size() - i3);
                downloadBean3.setSize(Long.valueOf(j));
                downloadBean3.setDuration(Long.valueOf(j2));
                downloadBean3.setOps(downloadBean2.getOps());
                downloadBean3.setTotalEpisode(downloadBean2.getTotalEpisode());
                downloadBean3.setSubjectId(downloadBean2.getSubjectId());
                downloadBean3.setSubjectName(downloadBean2.getSubjectName());
                downloadBean3.setReadProgress(j3);
                downloadBean3.setRootPath(downloadBean4.getRootPath());
                downloadBean3.setRootPathType(downloadBean4.getRootPathType());
                downloadBean3.setType(downloadBean2.getType());
                downloadBean3.setSubjectType(downloadBean2.getSubjectType());
                c0(downloadBean3);
                arrayList.add(downloadBean3);
                it3 = it;
                i = 0;
                i2 = 1;
            }
            it = it3;
            it3 = it;
            i = 0;
            i2 = 1;
        }
        if (arrayList.size() > 1) {
            CollectionsKt.A(arrayList, new DownloadListManager$handleDownloaded$.inlined.sortByDescending.1());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(List list) {
        if (this.l == null) {
            this.l = new LinkedHashMap();
        }
        this.l.clear();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String resourceId = ((DownloadBean) list.get(i)).getResourceId();
            if (resourceId != null && resourceId.length() > 0) {
                this.l.put(resourceId, Integer.valueOf(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(List list, BiddingNativeManager biddingNativeManager) {
        Object m34constructorimpl;
        DownloadBean downloadBean;
        Boolean bool;
        if (biddingNativeManager == null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            downloadBean = new DownloadBean("ad", "ad", "ad", "", 0L, (String) null, (String) null, (String) null, (Long) null, (Long) null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, (String) null, (String) null, (String) null, (String) null, 0L, 0, 0, (String) null, (String) null, 0L, (String) null, (String) null, 0L, 0, 0L, (String) null, 0, (String) null, (String) null, false, false, 0, (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (Long) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, -32, -1, 65535, (DefaultConstructorMarker) null);
            downloadBean.setStatus(13);
            downloadBean.setWrapNativeManager(biddingNativeManager);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m34constructorimpl = Result.m34constructorimpl(ResultKt.a(th));
        }
        if (biddingNativeManager.S0()) {
            if (2 >= list.size()) {
                bool = Boolean.valueOf(list.add(downloadBean));
            } else {
                list.add(2, downloadBean);
                bool = Unit.a;
            }
            m34constructorimpl = Result.m34constructorimpl(bool);
            Result.m37exceptionOrNullimpl(m34constructorimpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DownloadListManager U() {
        return new DownloadListManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 W() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a X() {
        return (a) kg.c.e.a().h(a.class);
    }

    private final void c0(DownloadBean downloadBean) {
        if (K().f() == null) {
            return;
        }
        DownloadBean downloadBean2 = (DownloadBean) K().f();
        if (Intrinsics.c(downloadBean2 != null ? downloadBean2.getSubjectId() : null, downloadBean.getSubjectId())) {
            K().n(downloadBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                DownloadBean downloadBean = (DownloadBean) it.next();
                if (!TextUtils.isEmpty(downloadBean.getSubjectId()) && !TextUtils.isEmpty(downloadBean.getResourceId()) && !downloadBean.isShotTV()) {
                    DownloadManagerApi.j.a().T(downloadBean.getSubjectId(), downloadBean.getResourceId(), downloadBean.isSeries(), downloadBean.getTotalEpisode(), false, downloadBean.getResolution() > 0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(List list) {
        File[] listFiles;
        if (list.isEmpty()) {
            try {
                Result.Companion companion = Result.Companion;
                File s = DownloadEsHelper.m.a().s();
                if (s.exists() && s.isDirectory() && (listFiles = s.listFiles()) != null && listFiles.length != 0) {
                    qi.h.a.q("download", "app_perf", MapsKt.f(TuplesKt.a("download_ops", "delete_download_file")));
                }
                Result.m34constructorimpl(Unit.a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m34constructorimpl(ResultKt.a(th));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ui.c t() {
        Application a = Utils.a();
        if (a != null) {
            return AppDatabase.p.b(a).o1();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 u() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object v(List list, Continuation continuation) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(R(list));
        }
        a.a.f(wf.a.a, "DownloadPanel", "2-  get getDownloadedList success = " + arrayList.size(), false, 4, (Object) null);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 w() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(kotlin.coroutines.Continuation r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.transsnet.downloader.viewmodel.DownloadListManager$downloadingList$1
            if (r0 == 0) goto L13
            r0 = r12
            com.transsnet.downloader.viewmodel.DownloadListManager$downloadingList$1 r0 = (com.transsnet.downloader.viewmodel.DownloadListManager$downloadingList$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.downloader.viewmodel.DownloadListManager$downloadingList$1 r0 = new com.transsnet.downloader.viewmodel.DownloadListManager$downloadingList$1
            r0.<init>(r11, r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r12)
            goto L43
        L29:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L31:
            kotlin.ResultKt.b(r12)
            com.transsnet.downloader.manager.DownloadEsHelper$a r12 = com.transsnet.downloader.manager.DownloadEsHelper.m
            com.transsnet.downloader.manager.DownloadEsHelper r12 = r12.a()
            r0.label = r3
            java.lang.Object r12 = r12.C(r0)
            if (r12 != r1) goto L43
            return r1
        L43:
            java.util.List r12 = (java.util.List) r12
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r12 == 0) goto L7c
            r1 = r12
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L7c
            int r2 = r1.size()
            r3 = 0
            r4 = r3
        L5b:
            if (r4 >= r2) goto L73
            java.lang.Object r5 = r12.get(r4)
            com.transsion.baselib.db.download.DownloadBean r5 = (com.transsion.baselib.db.download.DownloadBean) r5
            boolean r6 = r5.isDownloading()
            if (r6 == 0) goto L70
            boolean r5 = r5.isPreDownload()
            if (r5 != 0) goto L70
            goto L74
        L70:
            int r4 = r4 + 1
            goto L5b
        L73:
            r4 = -1
        L74:
            if (r4 <= 0) goto L79
            java.util.Collections.swap(r12, r4, r3)
        L79:
            r0.addAll(r1)
        L7c:
            wf.a$a r5 = wf.a.a
            int r12 = r0.size()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "1 -- get getDownloadingList success = "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r7 = r1.toString()
            r9 = 4
            r10 = 0
            java.lang.String r6 = "DownloadPanel"
            r8 = 0
            wf.a.a.f(r5, r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.viewmodel.DownloadListManager.x(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 y() {
        return new b0();
    }

    public final ConcurrentHashMap A() {
        return this.i;
    }

    public final b0 B() {
        return (b0) this.c.getValue();
    }

    public final Map C() {
        return this.l;
    }

    public final b0 D() {
        return this.h;
    }

    public final void E() {
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new getDownloadedList.1(this, (Continuation) null), 3, (Object) null);
    }

    public final b0 F() {
        return (b0) this.d.getValue();
    }

    public final b0 G() {
        return (b0) this.e.getValue();
    }

    public final void H(boolean z, boolean z2, BiddingNativeManager biddingNativeManager) {
        E();
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new DownloadListManager$getList$1(z2, this, z, biddingNativeManager, null), 3, (Object) null);
    }

    public final Object J(int i, Continuation continuation) {
        return DownloadEsHelper.m.a().G(i, continuation);
    }

    public final b0 K() {
        return (b0) this.f.getValue();
    }

    public final void M(String str, int i, int i2, String str2, int i3) {
        kotlinx.coroutines.i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new getShortTVList.1(i3, this, str, i, i2, str2, (Continuation) null), 3, (Object) null);
    }

    public final Object O(Continuation continuation) {
        return DownloadEsHelper.m.a().M(continuation);
    }

    public final void P(String str, String str2) {
        Intrinsics.h(str2, "linkUrl");
        if (this.j == null) {
            this.j = new b0();
        }
        L().e(gg.a.a.a(), str2, str).f(dg.d.a.c()).subscribe(new b(this));
    }

    public final b0 Q() {
        return this.j;
    }

    public final boolean V() {
        return this.k;
    }

    public final void Y(b0 b0Var) {
        this.g = b0Var;
    }

    public final void Z(b0 b0Var) {
        this.h = b0Var;
    }

    public final void a0(boolean z) {
        this.k = z;
    }

    public final void b0(b0 b0Var) {
        this.j = b0Var;
    }

    public final void p(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadBean");
        if (this.h == null) {
            this.h = new b0();
        }
        b0 b0Var = this.h;
        if (b0Var != null) {
            b0Var.q(downloadBean);
        }
    }

    public final void r(int i) {
        if (this.i.containsKey(Integer.valueOf(i))) {
            return;
        }
        this.i.put(Integer.valueOf(i), new b0());
    }

    public final b0 z() {
        return this.g;
    }
}
