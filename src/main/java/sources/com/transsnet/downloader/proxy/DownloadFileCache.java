package com.transsnet.downloader.proxy;

import android.app.Application;
import androidx.collection.s;
import com.blankj.utilcode.util.Utils;
import com.danikula.videocache.m;
import com.danikula.videocache.q;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsnet.downloader.core.task.DownloadTaskUtil;
import com.transsnet.downloader.proxy.DownloadFileCache$updateDBRanges$lambda$6$;
import com.transsnet.downloader.util.DownloadUtil;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import ui.n0;
import wf.a;
import yg.l;
import zw.d;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class DownloadFileCache implements com.danikula.videocache.a {
    private RandomAccessFile d;
    private DownloadBean e;
    private String f;
    private c g;
    private DownloadRange i;
    private int j;
    private long l;
    private m m;
    private final long a = 3145728;
    private long b = 3145728;
    private final Lazy c = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.proxy.a
        public final Object invoke() {
            n0 m;
            m = DownloadFileCache.m();
            return m;
        }
    });
    private ConcurrentHashMap h = new ConcurrentHashMap();
    private String k = "";
    private boolean n = true;
    private final d o = new a(this);

    private final void g(long j) {
        DownloadRange downloadRange;
        DownloadRange downloadRange2 = this.i;
        if (downloadRange2 != null) {
            Intrinsics.e(downloadRange2);
            if (downloadRange2.contains(j)) {
                return;
            }
        }
        q.a("checkDownloadNewV2Ranges = " + (this.e == null));
        DownloadBean downloadBean = this.e;
        if (downloadBean != null) {
            DownloadRange downloadRange3 = this.i;
            Iterator it = downloadBean.getDownloadRanges().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadRange downloadRange4 = (DownloadRange) it.next();
                if (downloadRange4.contains(j)) {
                    this.j = downloadRange4.getThreadIndex();
                    this.i = downloadRange4;
                    break;
                }
            }
            a.a aVar = wf.a.a;
            int i = this.j;
            DownloadRange downloadRange5 = this.i;
            Boolean valueOf = downloadRange5 != null ? Boolean.valueOf(downloadRange5.isDownloading()) : null;
            DownloadRange downloadRange6 = this.i;
            Boolean valueOf2 = downloadRange6 != null ? Boolean.valueOf(downloadRange6.isRangeDownloadSuccess()) : null;
            DownloadRange downloadRange7 = this.i;
            String valueOf3 = downloadRange7 != null ? Integer.valueOf(downloadRange7.getRangeId()) : "range is null";
            DownloadRange downloadRange8 = this.i;
            Long valueOf4 = downloadRange8 != null ? Long.valueOf(downloadRange8.getStart()) : null;
            DownloadRange downloadRange9 = this.i;
            Long valueOf5 = downloadRange9 != null ? Long.valueOf(downloadRange9.getEnd()) : null;
            DownloadRange downloadRange10 = this.i;
            Long valueOf6 = downloadRange10 != null ? Long.valueOf(downloadRange10.getProgress()) : null;
            aVar.c("download", StringsKt.n("download&play checkDownloadNewV2Ranges, offset=" + j + ",index = " + i + " \n                  currentRange, isDownloading: " + valueOf + ", downloadSuccess: " + valueOf2 + "\n                  rangeId: " + valueOf3 + ", start: " + valueOf4 + ", end: " + valueOf5 + ",progress: " + valueOf6 + "\n                  resourceId:" + downloadBean.getResourceId() + ",name:" + downloadBean.getName() + "\n                "), true);
            DownloadRange downloadRange11 = this.i;
            if (downloadRange11 != null) {
                Intrinsics.e(downloadRange11);
                if (downloadRange11.isDownloading()) {
                    return;
                }
                DownloadRange downloadRange12 = this.i;
                Intrinsics.e(downloadRange12);
                if (downloadRange12.isRangeDownloadSuccess() || !l.a.e()) {
                    return;
                }
                c cVar = this.g;
                if (cVar != null) {
                    String resourceId = downloadBean.getResourceId();
                    int i2 = this.j;
                    DownloadRange downloadRange13 = this.i;
                    Intrinsics.e(downloadRange13);
                    downloadRange = downloadRange3;
                    cVar.a(resourceId, i2, downloadRange, downloadRange13);
                } else {
                    downloadRange = downloadRange3;
                }
                for (Map.Entry entry : this.h.entrySet()) {
                    Object key = entry.getKey();
                    String resourceId2 = downloadBean.getResourceId();
                    if (resourceId2 == null) {
                        resourceId2 = downloadBean.getUrl();
                    }
                    if (Intrinsics.c(key, resourceId2)) {
                        c cVar2 = (c) entry.getValue();
                        String resourceId3 = downloadBean.getResourceId();
                        int i3 = this.j;
                        DownloadRange downloadRange14 = this.i;
                        Intrinsics.e(downloadRange14);
                        cVar2.a(resourceId3, i3, downloadRange, downloadRange14);
                    }
                }
            }
        }
    }

    private final void h(String str, long j) {
        Object obj;
        List downloadRanges;
        String url;
        DownloadBean downloadBean = this.e;
        List downloadRanges2 = downloadBean != null ? downloadBean.getDownloadRanges() : null;
        if (downloadRanges2 == null || downloadRanges2.isEmpty()) {
            return;
        }
        DownloadBean downloadBean2 = this.e;
        Intrinsics.e(downloadBean2);
        for (DownloadRange downloadRange : downloadBean2.getDownloadRanges()) {
            if (downloadRange.contains(j)) {
                DownloadRange downloadRange2 = this.i;
                long start = downloadRange.getStart();
                if (j <= downloadRange.totalProgress() && start <= j) {
                    this.i = downloadRange;
                    r(str + "_range1", str + " 暂停当前线程，启动新线程下载, 已经下载，直接返回, offset = " + j + ", rangeId = " + downloadRange.getRangeId());
                } else if (j < downloadRange.getStart() + downloadRange.getProgress() + this.b) {
                    this.i = downloadRange;
                    r(str + "_range2", str + " 暂停当前线程，启动新线程下载, 小于阈值，等待下载,只的启动线程，不处理range, offset = " + j);
                } else {
                    if (downloadRange.getEnd() - j < this.b) {
                        r(str + "_range3", str + " 暂停当前线程，启动新线程下载, 新增分片小于阈值，使用阈值大小, offset = " + j);
                        j = downloadRange.getEnd() - this.b;
                    } else {
                        r(str + "_range4", str + " 暂停当前线程，启动新线程下载, 新增分片大于阈值, offset = " + j);
                    }
                    if (l.a.e()) {
                        DownloadRange downloadRange3 = new DownloadRange();
                        DownloadBean downloadBean3 = this.e;
                        if (downloadBean3 == null || (obj = downloadBean3.getResourceId()) == null) {
                            obj = 0;
                        }
                        downloadRange3.setThreadId(obj.hashCode());
                        downloadRange3.setRangeId(s.a(downloadRange.getEnd() + j));
                        downloadRange3.setResourceId(downloadRange.getResourceId());
                        downloadRange3.setStart(j);
                        downloadRange3.setEnd(downloadRange.getEnd());
                        downloadRange3.setProgress(0L);
                        downloadRange.setEnd(downloadRange3.getStart() - 1);
                        DownloadBean downloadBean4 = this.e;
                        if (downloadBean4 != null && (downloadRanges = downloadBean4.getDownloadRanges()) != null) {
                            downloadRanges.add(downloadRange3);
                        }
                        this.i = downloadRange3;
                        DownloadBean downloadBean5 = this.e;
                        s(downloadBean5 != null ? downloadBean5.getDownloadRanges() : null);
                    }
                }
                DownloadRange downloadRange4 = this.i;
                if (downloadRange4 != null) {
                    Intrinsics.e(downloadRange4);
                    if (downloadRange4.isRangeDownloadSuccess()) {
                        return;
                    }
                    DownloadRange downloadRange5 = this.i;
                    Intrinsics.e(downloadRange5);
                    if (downloadRange5.isDownloading() || !l.a.e()) {
                        return;
                    }
                    c cVar = this.g;
                    if (cVar != null) {
                        DownloadBean downloadBean6 = this.e;
                        String resourceId = downloadBean6 != null ? downloadBean6.getResourceId() : null;
                        int i = this.j;
                        DownloadRange downloadRange6 = this.i;
                        Intrinsics.e(downloadRange6);
                        cVar.a(resourceId, i, downloadRange2, downloadRange6);
                    }
                    for (Map.Entry entry : this.h.entrySet()) {
                        Object key = entry.getKey();
                        DownloadBean downloadBean7 = this.e;
                        if (downloadBean7 == null || (url = downloadBean7.getResourceId()) == null) {
                            DownloadBean downloadBean8 = this.e;
                            url = downloadBean8 != null ? downloadBean8.getUrl() : null;
                        }
                        if (Intrinsics.c(key, url)) {
                            c cVar2 = (c) entry.getValue();
                            DownloadBean downloadBean9 = this.e;
                            String resourceId2 = downloadBean9 != null ? downloadBean9.getResourceId() : null;
                            int i2 = this.j;
                            DownloadRange downloadRange7 = this.i;
                            Intrinsics.e(downloadRange7);
                            cVar2.a(resourceId2, i2, downloadRange2, downloadRange7);
                        }
                    }
                    return;
                }
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n0 k() {
        return (n0) this.c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n0 m() {
        AppDatabase.f1 f1Var = AppDatabase.p;
        Application a = Utils.a();
        Intrinsics.g(a, "getApp(...)");
        return f1Var.b(a).p1();
    }

    private final void r(String str, String str2) {
        if (Intrinsics.c(this.k, str)) {
            return;
        }
        this.k = str;
        q.a("================range,  " + str2);
    }

    private final void s(List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list2);
        if (arrayList.size() > 1) {
            CollectionsKt.A(arrayList, new DownloadFileCache$updateDBRanges$lambda$6$.inlined.sortBy.1());
        }
        list.clear();
        list.addAll(arrayList);
        i.d(o0.a(y0.b()), (CoroutineContext) null, (CoroutineStart) null, new updateDBRanges.1(list, this, (Continuation) null), 3, (Object) null);
    }

    public long A() {
        Long size;
        DownloadBean downloadBean = this.e;
        if (downloadBean == null || (size = downloadBean.getSize()) == null) {
            return 0L;
        }
        return size.longValue();
    }

    public void B() {
        try {
            DownloadBean downloadBean = this.e;
            String path = downloadBean != null ? downloadBean.getPath() : null;
            if (path != null && path.length() != 0) {
                q.b("1-path create");
                DownloadBean downloadBean2 = this.e;
                this.d = new RandomAccessFile(downloadBean2 != null ? downloadBean2.getPath() : null, "r");
                return;
            }
            q.b("path is null, is not downloading");
        } catch (Throwable th) {
            DownloadBean downloadBean3 = this.e;
            q.b("1--path = " + (downloadBean3 != null ? downloadBean3.getPath() : null) + ",error = " + th);
            try {
                q.b("2-path create");
                DownloadBean downloadBean4 = this.e;
                this.d = new RandomAccessFile(downloadBean4 != null ? downloadBean4.getPath() : null, "rwd");
            } catch (Throwable th2) {
                DownloadBean downloadBean5 = this.e;
                q.b("2--path = " + (downloadBean5 != null ? downloadBean5.getPath() : null) + ",error = " + th2);
            }
        }
    }

    public void C(long j) {
        Object obj;
        String url;
        List downloadRanges;
        if (DownloadTaskUtil.a.j()) {
            g(j);
            return;
        }
        DownloadRange downloadRange = this.i;
        if (downloadRange == null) {
            a.a aVar = wf.a.a;
            DownloadBean downloadBean = this.e;
            String resourceId = downloadBean != null ? downloadBean.getResourceId() : null;
            DownloadBean downloadBean2 = this.e;
            aVar.i("download", "download&play currentRangeNull currentRange is null, offset = " + j + ",resourceId=" + resourceId + ",,name=" + (downloadBean2 != null ? downloadBean2.getName() : null), true);
            return;
        }
        Intrinsics.e(downloadRange);
        long start = downloadRange.getStart();
        DownloadRange downloadRange2 = this.i;
        Intrinsics.e(downloadRange2);
        if (j <= downloadRange2.totalProgress() && start <= j) {
            r("currentRange1", "当前分片已下载进度内，不做任何处理，直接返回, offset = " + j);
            return;
        }
        DownloadRange downloadRange3 = this.i;
        Intrinsics.e(downloadRange3);
        if (j < downloadRange3.getStart()) {
            h("beforeRange", j);
            return;
        }
        DownloadRange downloadRange4 = this.i;
        Intrinsics.e(downloadRange4);
        if (j >= downloadRange4.getEnd()) {
            h("afterRange", j);
            return;
        }
        DownloadRange downloadRange5 = this.i;
        Intrinsics.e(downloadRange5);
        long start2 = downloadRange5.getStart();
        DownloadRange downloadRange6 = this.i;
        Intrinsics.e(downloadRange6);
        if (j < start2 + downloadRange6.getProgress() + this.b) {
            r("currentRange21", "当前分片内，快进小于阈值，等待下载, offset = " + j);
            return;
        }
        DownloadRange downloadRange7 = this.i;
        Intrinsics.e(downloadRange7);
        if (downloadRange7.getEnd() - j < this.b) {
            r("currentRange22", "当前分片内，（暂停当前线程，启动新线程下载）快进 新增分片小于阈值，使用阈值大小, offset = " + j);
            DownloadRange downloadRange8 = this.i;
            Intrinsics.e(downloadRange8);
            j = downloadRange8.getEnd() - this.b;
        } else {
            r("currentRange23", "当前分片内，（暂停当前线程，启动新线程下载）快进 新增分片大于阈值, offset = " + j);
        }
        if (l.a.e()) {
            DownloadRange downloadRange9 = new DownloadRange();
            DownloadBean downloadBean3 = this.e;
            if (downloadBean3 == null || (obj = downloadBean3.getResourceId()) == null) {
                obj = 0;
            }
            downloadRange9.setThreadId(obj.hashCode());
            DownloadRange downloadRange10 = this.i;
            Intrinsics.e(downloadRange10);
            downloadRange9.setRangeId(s.a(downloadRange10.getEnd() + j));
            DownloadRange downloadRange11 = this.i;
            Intrinsics.e(downloadRange11);
            downloadRange9.setResourceId(downloadRange11.getResourceId());
            downloadRange9.setStart(j);
            DownloadRange downloadRange12 = this.i;
            Intrinsics.e(downloadRange12);
            downloadRange9.setEnd(downloadRange12.getEnd());
            downloadRange9.setProgress(0L);
            DownloadRange downloadRange13 = this.i;
            Intrinsics.e(downloadRange13);
            downloadRange13.setEnd(downloadRange9.getStart() - 1);
            DownloadBean downloadBean4 = this.e;
            if (downloadBean4 != null && (downloadRanges = downloadBean4.getDownloadRanges()) != null) {
                downloadRanges.add(downloadRange9);
            }
            DownloadRange downloadRange14 = this.i;
            this.i = downloadRange9;
            DownloadBean downloadBean5 = this.e;
            s(downloadBean5 != null ? downloadBean5.getDownloadRanges() : null);
            c cVar = this.g;
            if (cVar != null) {
                DownloadBean downloadBean6 = this.e;
                cVar.a(downloadBean6 != null ? downloadBean6.getResourceId() : null, this.j, downloadRange14, downloadRange9);
            }
            for (Map.Entry entry : this.h.entrySet()) {
                Object key = entry.getKey();
                DownloadBean downloadBean7 = this.e;
                if (downloadBean7 == null || (url = downloadBean7.getResourceId()) == null) {
                    DownloadBean downloadBean8 = this.e;
                    url = downloadBean8 != null ? downloadBean8.getUrl() : null;
                }
                if (Intrinsics.c(key, url)) {
                    c cVar2 = (c) entry.getValue();
                    DownloadBean downloadBean9 = this.e;
                    cVar2.a(downloadBean9 != null ? downloadBean9.getResourceId() : null, this.j, downloadRange14, downloadRange9);
                }
            }
        }
    }

    public int D(byte[] bArr, long j, int i, String str) {
        RandomAccessFile randomAccessFile;
        Intrinsics.h(bArr, "buffer");
        Intrinsics.h(str, "url");
        if (this.d == null) {
            B();
        }
        RandomAccessFile randomAccessFile2 = this.d;
        if ((randomAccessFile2 != null ? randomAccessFile2.length() : 0L) == 0) {
            DownloadRange downloadRange = this.i;
            if ((downloadRange != null ? downloadRange.getProgress() : 0L) > 0) {
                q.f("read error, create new data file");
                B();
            }
        }
        RandomAccessFile randomAccessFile3 = this.d;
        if (randomAccessFile3 != null) {
            randomAccessFile3.seek(j);
        }
        DownloadRange downloadRange2 = this.i;
        Intrinsics.e(downloadRange2);
        int read = (j <= downloadRange2.totalProgress() && (randomAccessFile = this.d) != null) ? randomAccessFile.read(bArr, 0, i) : -1;
        if (read == -1) {
            RandomAccessFile randomAccessFile4 = this.d;
            Long valueOf = randomAccessFile4 != null ? Long.valueOf(randomAccessFile4.length()) : null;
            DownloadRange downloadRange3 = this.i;
            Integer valueOf2 = downloadRange3 != null ? Integer.valueOf(downloadRange3.getRangeId()) : null;
            DownloadRange downloadRange4 = this.i;
            Long valueOf3 = downloadRange4 != null ? Long.valueOf(downloadRange4.getStart()) : null;
            DownloadRange downloadRange5 = this.i;
            Long valueOf4 = downloadRange5 != null ? Long.valueOf(downloadRange5.getEnd()) : null;
            DownloadRange downloadRange6 = this.i;
            q.b("read -1, dataFile created & length= " + valueOf + ", rangeId = " + valueOf2 + ", offset = " + j + " , start =  " + valueOf3 + ",end =  " + valueOf4 + ", totalProgress = " + (downloadRange6 != null ? Long.valueOf(downloadRange6.totalProgress()) : null));
        }
        return read;
    }

    public void E(long j) {
        if (DownloadTaskUtil.a.j()) {
            return;
        }
        DownloadRange downloadRange = this.i;
        if (downloadRange != null) {
            Intrinsics.e(downloadRange);
            long start = downloadRange.getStart();
            DownloadRange downloadRange2 = this.i;
            Intrinsics.e(downloadRange2);
            if (j <= downloadRange2.getEnd() && start <= j) {
                return;
            }
        }
        q.a("check  downloadBean = " + (this.e == null));
        DownloadBean downloadBean = this.e;
        if (downloadBean != null) {
            Iterator it = downloadBean.getDownloadRanges().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadRange downloadRange3 = (DownloadRange) it.next();
                if (downloadRange3.contains(j)) {
                    this.j = downloadRange3.getThreadIndex();
                    this.i = downloadRange3;
                    break;
                }
            }
            a.a aVar = wf.a.a;
            int i = this.j;
            DownloadRange downloadRange4 = this.i;
            String valueOf = downloadRange4 != null ? Integer.valueOf(downloadRange4.getRangeId()) : "range is null";
            DownloadRange downloadRange5 = this.i;
            Long valueOf2 = downloadRange5 != null ? Long.valueOf(downloadRange5.getStart()) : null;
            DownloadRange downloadRange6 = this.i;
            Long valueOf3 = downloadRange6 != null ? Long.valueOf(downloadRange6.getEnd()) : null;
            DownloadRange downloadRange7 = this.i;
            Long valueOf4 = downloadRange7 != null ? Long.valueOf(downloadRange7.getProgress()) : null;
            DownloadBean downloadBean2 = this.e;
            String resourceId = downloadBean2 != null ? downloadBean2.getResourceId() : null;
            DownloadBean downloadBean3 = this.e;
            aVar.c("download", StringsKt.n("download&play set new download thread, offset=" + j + ",index = " + i + " \n                           currentRange.rangeId = " + valueOf + ", start = " + valueOf2 + ", end = " + valueOf3 + ",\n                           progress = " + valueOf4 + ",resourceId=" + resourceId + ",name=" + (downloadBean3 != null ? downloadBean3.getName() : null) + "\n                    "), true);
        }
    }

    public void F(m mVar) {
        Intrinsics.h(mVar, "proxyCache");
        this.m = mVar;
    }

    public long G() {
        DownloadRange downloadRange = this.i;
        return downloadRange != null ? downloadRange.getEnd() : A();
    }

    public boolean H(long j, int i, String str) {
        Intrinsics.h(str, "url");
        this.l = j;
        DownloadBean downloadBean = this.e;
        if (downloadBean != null) {
            downloadBean.setCurrentOffset(j);
        }
        if (this.i == null) {
            return false;
        }
        RandomAccessFile randomAccessFile = this.d;
        if ((randomAccessFile != null ? randomAccessFile.length() : 0L) < j) {
            return false;
        }
        DownloadRange downloadRange = this.i;
        Intrinsics.e(downloadRange);
        if (downloadRange.isRangeDownloadSuccess()) {
            return true;
        }
        long j2 = j + i;
        DownloadRange downloadRange2 = this.i;
        Intrinsics.e(downloadRange2);
        return j2 <= downloadRange2.totalProgress();
    }

    public void close() {
        try {
            RandomAccessFile randomAccessFile = this.d;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.k = "";
        } catch (Throwable unused) {
        }
    }

    public final void f(String str, c cVar) {
        Intrinsics.h(str, "resourceId");
        Intrinsics.h(cVar, "callback");
        this.h.put(str, cVar);
    }

    public final DownloadBean i() {
        return this.e;
    }

    public boolean isCompleted() {
        DownloadBean downloadBean = this.e;
        return downloadBean != null && downloadBean.getStatus() == 5;
    }

    public final d j() {
        return this.o;
    }

    public final boolean l() {
        return this.n;
    }

    public final void n(String str) {
        Intrinsics.h(str, "resourceId");
        this.h.remove(str);
    }

    public final void o() {
        this.i = null;
        this.j = 0;
        this.k = "";
        close();
        this.d = null;
        this.m = null;
        this.n = true;
    }

    public final void p(String str) {
        this.f = str;
    }

    public final void q(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadBean");
        this.n = false;
        q.e("set new video =  " + downloadBean.getName());
        this.e = downloadBean;
        Long size = downloadBean.getSize();
        long longValue = size != null ? size.longValue() / 120 : this.a;
        long j = this.a;
        if (longValue > j) {
            longValue = j;
        }
        this.b = longValue;
        DownloadUtil.a.B(downloadBean);
    }

    public String z() {
        String str = this.f;
        if (str != null) {
            return str;
        }
        DownloadBean downloadBean = this.e;
        return (downloadBean == null || downloadBean.getType() != 1) ? "video/mp4" : "audio/mpeg";
    }
}
