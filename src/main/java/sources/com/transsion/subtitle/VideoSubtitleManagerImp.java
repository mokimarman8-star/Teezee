package com.transsion.subtitle;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.launch.b;
import com.transsion.subtitle.helper.SubtitleSearchHelper;
import com.transsion.subtitle_download.SubtitleDownloadManager;
import com.transsion.subtitle_download.bean.SubtitleAppType;
import com.transsnet.downloader.manager.p;
import ht.a;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lt.c;
import ui.s0;
import ui.v0;
import wf.a;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class VideoSubtitleManagerImp implements h {
    public static final a g = new a((DefaultConstructorMarker) null);
    private final Lazy b = LazyKt.b(new Function0() { // from class: com.transsion.subtitle.j
        public final Object invoke() {
            v0 D;
            D = VideoSubtitleManagerImp.D();
            return D;
        }
    });
    private Set c = new CopyOnWriteArraySet();
    private final String d = VideoSubtitleManagerImp.class.getSimpleName();
    private final n0 e = o0.a(y0.c());
    private final VideoSubtitleManagerImp$resDownloadListener$1 f = new s0() { // from class: com.transsion.subtitle.VideoSubtitleManagerImp$resDownloadListener$1
        private final void e(DownloadBean downloadBean, boolean z) {
            i.d(o0.a(y0.a()), (CoroutineContext) null, (CoroutineStart) null, new downloadCheck.1(VideoSubtitleManagerImp.this, downloadBean, z, this, (Continuation) null), 3, (Object) null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean f(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.d() && aVar.b().getStatus() == 6) {
                    return true;
                }
            }
            return false;
        }

        public void a(String str) {
            Intrinsics.h(str, "subtitleResId");
            i.d(o0.a(y0.a()), (CoroutineContext) null, (CoroutineStart) null, new deleteSubtitle.1(str, (Continuation) null), 3, (Object) null);
        }

        public void b(DownloadBean downloadBean) {
            Intrinsics.h(downloadBean, "bean");
            e(downloadBean, true);
        }

        public void c(DownloadBean downloadBean, boolean z) {
            String str;
            Intrinsics.h(downloadBean, "bean");
            a.a aVar = wf.a.a;
            String a = com.transsion.baselib.report.a.a.a();
            str = VideoSubtitleManagerImp.this.d;
            aVar.c(a, str + " 开始下载，检测字幕 firstDownload:" + z + "，titleName:" + downloadBean.getTitleName() + ", ep:" + downloadBean.getEp() + " se:" + downloadBean.getSe(), true);
            if (z) {
                VideoSubtitleManagerImp.t(VideoSubtitleManagerImp.this, downloadBean, null, 2, null);
            } else {
                e(downloadBean, false);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public final v0 A() {
        return (v0) this.b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String B() {
        return b.a.b().getString("k_language_short_name", null);
    }

    private final void C() {
        if (!b.a.b().getBoolean("subtitle_old_db_move", false)) {
            i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new VideoSubtitleManagerImp$initOldSubtitleMoveDB$1(this, null), 3, (Object) null);
            return;
        }
        wf.a.a.c(com.transsion.baselib.report.a.a.a(), this.d + " 转移数据库, 已转移过，不再处理", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v0 D() {
        AppDatabase.f1 f1Var = AppDatabase.p;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return f1Var.b(a).y1();
    }

    private final void s(DownloadBean downloadBean, Function1 function1) {
        if (!downloadBean.isVideo() || downloadBean.isMusic()) {
            return;
        }
        if (l.a.e()) {
            if (downloadBean.isUGCVideo()) {
                y(downloadBean, function1);
                return;
            } else if (downloadBean.isStream()) {
                w(downloadBean, function1);
                return;
            } else {
                u(downloadBean, function1);
                return;
            }
        }
        wf.a.a.w(com.transsion.baselib.report.a.a.a(), this.d + " checkDownloadSubtitle ,无网络不做检测", true);
    }

    static /* synthetic */ void t(VideoSubtitleManagerImp videoSubtitleManagerImp, DownloadBean downloadBean, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        videoSubtitleManagerImp.s(downloadBean, function1);
    }

    private final void u(DownloadBean downloadBean, Function1 function1) {
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null || resourceId.length() == 0) {
            a.a.f(wf.a.a, com.transsion.baselib.report.a.a.a(), this.d + " checkDownloadSubtitleNormal fail， has no resourceId", false, 4, (Object) null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        String resourceId2 = downloadBean.getResourceId();
        if ((resourceId2 != null ? StringsKt.x(resourceId2) : null) == null) {
            a.a.x(wf.a.a, com.transsion.baselib.report.a.a.a(), this.d + " checkDownloadSubtitleNormal ,resourceId is abnormal", false, 4, (Object) null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        wf.a.a.c(com.transsion.baselib.report.a.a.a(), this.d + " checkDownloadSubtitleNormal, name = " + downloadBean.getName() + " subjectId:" + downloadBean.getSubjectId() + " subtitleResId:" + downloadBean.getSubtitleResId() + " resourceId:" + downloadBean.getResourceId(), true);
        if (downloadBean.isOutside()) {
            downloadBean.getPostIdNotNull();
        } else if (downloadBean.getPostId() == null) {
            downloadBean.getResourceId();
        }
        SubtitleDownloadManager.a.e(downloadBean.getSubjectId(), downloadBean.getSubtitleResId(), downloadBean.getResourceId(), null, downloadBean.getSubjectName(), 1, downloadBean.getEpse(), downloadBean.getEp(), downloadBean.getSe(), downloadBean.getOps(), new l(this, function1, downloadBean));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(VideoSubtitleManagerImp videoSubtitleManagerImp, Function1 function1, DownloadBean downloadBean, boolean z) {
        i.d(videoSubtitleManagerImp.e, (CoroutineContext) null, (CoroutineStart) null, new checkDownloadSubtitleNormal.1.1(function1, z, videoSubtitleManagerImp, downloadBean, (Continuation) null), 3, (Object) null);
        return Unit.a;
    }

    private final void w(DownloadBean downloadBean, Function1 function1) {
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null || resourceId.length() == 0) {
            a.a.f(wf.a.a, com.transsion.baselib.report.a.a.a(), this.d + " checkStreamSubtitle fail， has no resourceId", false, 4, (Object) null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        String resourceId2 = downloadBean.getResourceId();
        if ((resourceId2 != null ? StringsKt.x(resourceId2) : null) == null) {
            a.a.x(wf.a.a, com.transsion.baselib.report.a.a.a(), this.d + " checkStreamSubtitle ,resourceId is abnormal", false, 4, (Object) null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        wf.a.a.c(com.transsion.baselib.report.a.a.a(), this.d + " checkStreamSubtitle, name = " + downloadBean.getName() + " subjectId:" + downloadBean.getSubjectId() + " subtitleResId:" + downloadBean.getSubtitleResId() + " resourceId:" + downloadBean.getResourceId(), true);
        SubtitleDownloadManager.a.e(downloadBean.getSubjectId(), downloadBean.getSubtitleResId(), downloadBean.getResourceId(), null, downloadBean.getSubjectName(), 2, downloadBean.getEpse(), downloadBean.getEp(), downloadBean.getSe(), downloadBean.getOps(), new m(this, function1, downloadBean));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(VideoSubtitleManagerImp videoSubtitleManagerImp, Function1 function1, DownloadBean downloadBean, boolean z) {
        i.d(videoSubtitleManagerImp.e, (CoroutineContext) null, (CoroutineStart) null, new checkStreamSubtitle.1.1(function1, z, videoSubtitleManagerImp, downloadBean, (Continuation) null), 3, (Object) null);
        return Unit.a;
    }

    private final void y(DownloadBean downloadBean, Function1 function1) {
        String ugcVideoId = downloadBean.getUgcVideoId();
        if (ugcVideoId == null || ugcVideoId.length() == 0) {
            a.a.f(wf.a.a, com.transsion.baselib.report.a.a.a(), this.d + " checkUGCVideoSubtitle fail，UGC视频缺少ugcVideoId", false, 4, (Object) null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null || resourceId.length() == 0) {
            a.a.f(wf.a.a, com.transsion.baselib.report.a.a.a(), this.d + " checkUGCVideoSubtitle fail，UGC视频缺少resourceId（videoResourceId）", false, 4, (Object) null);
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        String subtitleIdType = downloadBean.getSubtitleIdType();
        if (subtitleIdType == null) {
            subtitleIdType = downloadBean.isStream() ? "StreamId" : "ResourceId";
        }
        String str = subtitleIdType;
        wf.a.a.c(com.transsion.baselib.report.a.a.a(), this.d + " checkUGCVideoSubtitle, name = " + downloadBean.getName() + " ugcVideoId:" + downloadBean.getUgcVideoId() + " collectionId:" + downloadBean.getUgcVideoCollectionId() + " videoResourceId:" + resourceId + " idType:" + str, true);
        SubtitleDownloadManager.a.f(downloadBean.getSubjectId(), downloadBean.getSubtitleResId(), resourceId, downloadBean.getUgcVideoId(), downloadBean.getUgcVideoCollectionId(), downloadBean.getOps(), str, new k(this, function1, downloadBean));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(VideoSubtitleManagerImp videoSubtitleManagerImp, Function1 function1, DownloadBean downloadBean, boolean z) {
        i.d(videoSubtitleManagerImp.e, (CoroutineContext) null, (CoroutineStart) null, new checkUGCVideoSubtitle.1.1(function1, z, videoSubtitleManagerImp, downloadBean, (Continuation) null), 3, (Object) null);
        return Unit.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.transsion.subtitle.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(java.lang.String r6, kotlin.coroutines.Continuation r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.transsion.subtitle.VideoSubtitleManagerImp.getSubtitleList.1
            if (r0 == 0) goto L13
            r0 = r7
            com.transsion.subtitle.VideoSubtitleManagerImp$getSubtitleList$1 r0 = (com.transsion.subtitle.VideoSubtitleManagerImp.getSubtitleList.1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.subtitle.VideoSubtitleManagerImp$getSubtitleList$1 r0 = new com.transsion.subtitle.VideoSubtitleManagerImp$getSubtitleList$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r6 = r0.L$0
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.b(r7)
            goto L4d
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.b(r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            com.transsion.subtitle_download.SubtitleDownloadManager r2 = com.transsion.subtitle_download.SubtitleDownloadManager.a
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r6 = r2.j(r6, r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            r4 = r7
            r7 = r6
            r6 = r4
        L4d:
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L6c
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L57:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L6c
            java.lang.Object r0 = r7.next()
            com.transsion.subtitle_download.db.SubtitleDownloadTable r0 = (com.transsion.subtitle_download.db.SubtitleDownloadTable) r0
            ht.a r1 = new ht.a
            r1.<init>(r0)
            r6.add(r1)
            goto L57
        L6c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.subtitle.VideoSubtitleManagerImp.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.transsion.subtitle.h
    public void b(com.transsion.subtitle_download.a aVar) {
        Intrinsics.h(aVar, "listener");
        SubtitleDownloadManager.a.b(aVar);
    }

    @Override // com.transsion.subtitle.h
    public void c(com.transsion.subtitle_download.a aVar) {
        Intrinsics.h(aVar, "listener");
        SubtitleDownloadManager.a.s(aVar);
    }

    @Override // com.transsion.subtitle.h
    public void d(c cVar) {
        Intrinsics.h(cVar, "listener");
        this.c.add(cVar);
    }

    @Override // com.transsion.subtitle.h
    public void destroy() {
    }

    @Override // com.transsion.subtitle.h
    public void e(DownloadBean downloadBean, Function1 function1) {
        Intrinsics.h(downloadBean, "bean");
        s(downloadBean, function1);
    }

    @Override // com.transsion.subtitle.h
    public void f(c cVar) {
        Intrinsics.h(cVar, "listener");
        this.c.remove(cVar);
    }

    @Override // com.transsion.subtitle.h
    public void g(ht.a aVar) {
        Intrinsics.h(aVar, "bean");
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((c) it.next()).g(aVar);
        }
    }

    @Override // com.transsion.subtitle.h
    public void h(ht.a aVar) {
        Intrinsics.h(aVar, "bean");
        SubtitleDownloadManager.a.d(aVar.b());
    }

    @Override // com.transsion.subtitle.h
    public void i(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "bean");
        wf.a.a.c(com.transsion.baselib.report.a.a.a(), this.d + " 打开字幕弹窗检测字幕，subjectId:" + downloadBean.getSubjectId() + " subtitleResId:" + downloadBean.getSubtitleResId(), true);
        t(this, downloadBean, null, 2, null);
    }

    @Override // com.transsion.subtitle.h
    public void init() {
        SubtitleSearchHelper.c.a().j();
        SubtitleDownloadManager subtitleDownloadManager = SubtitleDownloadManager.a;
        subtitleDownloadManager.l(new i());
        subtitleDownloadManager.k(SubtitleAppType.MB);
        p.a.a(Utils.a()).E(this.f);
        C();
    }

    @Override // com.transsion.subtitle.h
    public void j(ht.a aVar) {
        Intrinsics.h(aVar, "bean");
        SubtitleDownloadManager.a.d(aVar.b());
    }

    @Override // com.transsion.subtitle.h
    public void reset() {
    }
}
