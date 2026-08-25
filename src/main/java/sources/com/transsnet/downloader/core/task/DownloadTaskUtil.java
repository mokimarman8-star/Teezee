package com.transsnet.downloader.core.task;

import android.app.Application;
import androidx.collection.s;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.db.download.DownloadRange;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsnet.downloader.core.DownloadTaskImpl2;
import com.transsnet.downloader.util.DownloadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import ui.n0;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class DownloadTaskUtil {
    public static final DownloadTaskUtil a = new DownloadTaskUtil();
    private static final Lazy b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.core.task.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            n0 m;
            m = DownloadTaskUtil.m();
            return m;
        }
    });
    private static final Lazy c = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.core.task.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean h;
            h = DownloadTaskUtil.h();
            return Boolean.valueOf(h);
        }
    });
    private static final Lazy d = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.core.task.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean g;
            g = DownloadTaskUtil.g();
            return Boolean.valueOf(g);
        }
    });

    private DownloadTaskUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g() {
        Boolean m1;
        ConfigBean c2 = cm.f.c.a().c("downloadInCoroutine", false);
        String value = c2 != null ? c2.getValue() : null;
        if (value == null || value.length() == 0 || (m1 = StringsKt.m1(value)) == null) {
            return true;
        }
        return m1.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h() {
        Boolean m1;
        ConfigBean c2 = cm.f.c.a().c("downloadNewRange", false);
        String value = c2 != null ? c2.getValue() : null;
        if (value == null || value.length() == 0 || (m1 = StringsKt.m1(value)) == null) {
            return true;
        }
        return m1.booleanValue();
    }

    private final n0 l() {
        return (n0) b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n0 m() {
        AppDatabase.f1 f1Var = AppDatabase.p;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        return f1Var.b(a2).p1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.transsnet.downloader.core.task.DownloadTaskUtil$checkOldRanges$1, kotlin.coroutines.Continuation] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(long j, DownloadBean downloadBean, List list, Continuation continuation) {
        DownloadTaskUtil$checkOldRanges$1 downloadTaskUtil$checkOldRanges$1;
        int i;
        String str;
        List list2;
        DownloadBean downloadBean2;
        long j2;
        if (continuation instanceof DownloadTaskUtil$checkOldRanges$1) {
            downloadTaskUtil$checkOldRanges$1 = (DownloadTaskUtil$checkOldRanges$1) continuation;
            int i2 = downloadTaskUtil$checkOldRanges$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                downloadTaskUtil$checkOldRanges$1.label = i2 - Integer.MIN_VALUE;
                Object obj = downloadTaskUtil$checkOldRanges$1.result;
                Object f = IntrinsicsKt.f();
                i = downloadTaskUtil$checkOldRanges$1.label;
                String str2 = "download";
                if (i != 0) {
                    ResultKt.b(obj);
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        DownloadRange downloadRange = (DownloadRange) it.next();
                        if (downloadRange.isRangeDownloadSuccess() || downloadRange.getRangeSize() < j + 3145728) {
                            f = f;
                            str2 = str2;
                            it = it;
                            downloadTaskUtil$checkOldRanges$1 = downloadTaskUtil$checkOldRanges$1;
                            arrayList = arrayList;
                        } else {
                            Object obj2 = f;
                            Iterator it2 = it;
                            wf.a.a.c(str2, "checkOldRanges, rangeId:" + downloadRange.getRangeId() + ",start:" + downloadRange.getStart() + ",end:" + downloadRange.getEnd() + ",progress:" + downloadRange.getProgress(), true);
                            Ref.LongRef longRef = new Ref.LongRef();
                            longRef.element = -1L;
                            Ref.LongRef longRef2 = new Ref.LongRef();
                            longRef2.element = -1L;
                            long j3 = downloadRange.totalProgress();
                            long end = downloadRange.getEnd();
                            while (true) {
                                long j4 = longRef.element;
                                if (j4 >= end) {
                                    break;
                                }
                                long start = longRef2.element < 0 ? downloadRange.getStart() : j4 + 1;
                                longRef2.element = start;
                                long j5 = (start + j) - 1;
                                longRef.element = j5;
                                if (j5 >= end) {
                                    longRef.element = end;
                                }
                                if (j3 > longRef.element) {
                                    j2 = j;
                                } else {
                                    long j6 = longRef2.element;
                                    j2 = j3 > j6 ? j3 - j6 : 0L;
                                }
                                if (longRef2.element == downloadRange.getStart()) {
                                    long j7 = end;
                                    downloadRange.setEnd(longRef.element);
                                    downloadRange.setProgress(j2);
                                    ArrayList arrayList2 = arrayList;
                                    Ref.LongRef longRef3 = longRef2;
                                    String str3 = str2;
                                    wf.a.a.c(str3, "checkOldRanges,oldRange rangeId:" + downloadRange.getRangeId() + ", start:" + longRef2.element + ", end:" + longRef.element + ", progress:" + j2 + ", totalProgress:" + j3, true);
                                    str2 = str3;
                                    end = j7;
                                    arrayList = arrayList2;
                                    longRef2 = longRef3;
                                    downloadTaskUtil$checkOldRanges$1 = downloadTaskUtil$checkOldRanges$1;
                                    longRef = longRef;
                                } else {
                                    ArrayList arrayList3 = arrayList;
                                    DownloadTaskUtil$checkOldRanges$1 downloadTaskUtil$checkOldRanges$12 = downloadTaskUtil$checkOldRanges$1;
                                    Ref.LongRef longRef4 = longRef;
                                    Ref.LongRef longRef5 = longRef2;
                                    String str4 = str2;
                                    long j8 = end;
                                    DownloadRange downloadRange2 = new DownloadRange();
                                    downloadRange2.setThreadId(downloadRange.getThreadId());
                                    downloadRange2.setRangeId(s.a(longRef5.element + longRef4.element));
                                    downloadRange2.setResourceId(downloadRange.getResourceId());
                                    downloadRange2.setStart(longRef5.element);
                                    downloadRange2.setEnd(longRef4.element);
                                    downloadRange2.setProgress(j2);
                                    DownloadRange downloadRange3 = downloadRange;
                                    wf.a.a.c(str4, "checkOldRanges,newRange rangeId:" + downloadRange2.getRangeId() + ", start:" + longRef5.element + ", end:" + longRef4.element + ", progress:" + j2, true);
                                    Boxing.a(arrayList3.add(downloadRange2));
                                    str2 = str4;
                                    longRef = longRef4;
                                    end = j8;
                                    downloadRange = downloadRange3;
                                    longRef2 = longRef5;
                                    downloadTaskUtil$checkOldRanges$1 = downloadTaskUtil$checkOldRanges$12;
                                    j3 = j3;
                                    arrayList = arrayList3;
                                }
                            }
                            f = obj2;
                            it = it2;
                        }
                    }
                    ArrayList arrayList4 = arrayList;
                    ?? r22 = downloadTaskUtil$checkOldRanges$1;
                    Object obj3 = f;
                    str = str2;
                    if (arrayList4.isEmpty()) {
                        return list;
                    }
                    list2 = list;
                    list2.addAll(arrayList4);
                    downloadBean2 = downloadBean;
                    r22.L$0 = downloadBean2;
                    r22.L$1 = list2;
                    r22.label = 1;
                    if (n(list2, r22) == obj3) {
                        return obj3;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list2 = (List) downloadTaskUtil$checkOldRanges$1.L$1;
                    DownloadBean downloadBean3 = (DownloadBean) downloadTaskUtil$checkOldRanges$1.L$0;
                    ResultKt.b(obj);
                    downloadBean2 = downloadBean3;
                    str = "download";
                }
                wf.a.a.c(str, "checkOldRanges, set new range, size:" + downloadBean2.getDownloadRanges().size(), true);
                return list2;
            }
        }
        downloadTaskUtil$checkOldRanges$1 = new DownloadTaskUtil$checkOldRanges$1(this, continuation);
        Object obj4 = downloadTaskUtil$checkOldRanges$1.result;
        Object f2 = IntrinsicsKt.f();
        i = downloadTaskUtil$checkOldRanges$1.label;
        String str22 = "download";
        if (i != 0) {
        }
        wf.a.a.c(str, "checkOldRanges, set new range, size:" + downloadBean2.getDownloadRanges().size(), true);
        return list2;
    }

    public final void e(DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadBean");
        String path = downloadBean.getPath();
        if (path == null || path.length() == 0) {
            downloadBean.setPath(DownloadUtil.a.s(downloadBean));
            wf.a.a.p("download", new String[]{"DownloadTaskImpl 新任务, set download path, path = " + downloadBean.getPath()}, true);
        }
    }

    public final long f(DownloadBean downloadBean, DownloadTaskImpl2 downloadTask, c cVar) {
        Intrinsics.h(downloadBean, "downloadBean");
        Intrinsics.h(downloadTask, "downloadTask");
        ArrayList<DownloadRange> arrayList = new ArrayList();
        arrayList.addAll(downloadBean.getDownloadRanges());
        AtomicLong atomicLong = new AtomicLong(0L);
        for (DownloadRange downloadRange : arrayList) {
            if (!downloadRange.getReDownload() && downloadRange.getProgress() > 0) {
                atomicLong.getAndAdd(downloadRange.getProgress());
            }
        }
        long j = atomicLong.get();
        synchronized (downloadTask) {
            try {
                downloadBean.setProgress(j);
                if (downloadBean.isPreDownload() && j >= 5242880 && cVar != null) {
                    cVar.I(downloadBean);
                }
                a.a.f(wf.a.a, "DownloadThread", "------------total size:" + downloadBean.getSize() + " progress:" + j + ", isPreDownload: " + downloadBean.isPreDownload(), false, 4, (Object) null);
                Unit unit = Unit.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    public final boolean i() {
        return ((Boolean) d.getValue()).booleanValue();
    }

    public final boolean j() {
        return ((Boolean) c.getValue()).booleanValue();
    }

    public final List k(int i, DownloadBean downloadBean) {
        Intrinsics.h(downloadBean, "downloadBean");
        long j = 0;
        if (downloadBean.getCurrentOffset() > 0) {
            long currentOffset = downloadBean.getCurrentOffset();
            Long size = downloadBean.getSize();
            if (currentOffset < (size != null ? size.longValue() : 0L)) {
                j = downloadBean.getCurrentOffset();
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<DownloadRange> arrayList2 = new ArrayList();
        arrayList2.addAll(downloadBean.getDownloadRanges());
        for (DownloadRange downloadRange : arrayList2) {
            if (!downloadRange.isRangeDownloadSuccess() && !downloadRange.isDownloading() && (!downloadBean.isDownloadingPlay() || downloadRange.getEnd() >= j)) {
                arrayList.add(downloadRange);
                if (arrayList.size() >= i) {
                    break;
                }
            }
        }
        if (arrayList.size() < i) {
            for (DownloadRange downloadRange2 : arrayList2) {
                if (!downloadRange2.isRangeDownloadSuccess() && !downloadRange2.isDownloading() && !arrayList.contains(downloadRange2)) {
                    arrayList.add(downloadRange2);
                    if (arrayList.size() >= i) {
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:0|1|(2:3|(4:5|6|7|(1:(5:10|11|12|13|(5:15|(1:17)|12|13|(3:19|20|21)(0))(0))(2:23|24))(4:25|26|13|(0)(0))))|28|6|7|(0)(0)) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0082 A[Catch: all -> 0x0110, TryCatch #0 {all -> 0x0110, blocks: (B:11:0x0039, B:12:0x009e, B:13:0x007c, B:15:0x0082, B:19:0x00eb, B:26:0x0054), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00eb A[Catch: all -> 0x0110, TRY_LEAVE, TryCatch #0 {all -> 0x0110, blocks: (B:11:0x0039, B:12:0x009e, B:13:0x007c, B:15:0x0082, B:19:0x00eb, B:26:0x0054), top: B:7:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.transsnet.downloader.core.task.DownloadTaskUtil$updateDBRanges$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x009b -> B:12:0x009e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object n(List list, Continuation continuation) {
        ?? r1;
        int i;
        List list2;
        Iterator it;
        if (continuation instanceof DownloadTaskUtil$updateDBRanges$1) {
            DownloadTaskUtil$updateDBRanges$1 downloadTaskUtil$updateDBRanges$1 = (DownloadTaskUtil$updateDBRanges$1) continuation;
            int i2 = downloadTaskUtil$updateDBRanges$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                downloadTaskUtil$updateDBRanges$1.label = i2 - Integer.MIN_VALUE;
                r1 = downloadTaskUtil$updateDBRanges$1;
                Object obj = r1.result;
                Object f = IntrinsicsKt.f();
                i = r1.label;
                int i3 = 1;
                if (i != 0) {
                    ResultKt.b(obj);
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(list);
                    a.a.v(wf.a.a, "Download_TaskImpl", "updateDBRanges, size= " + arrayList.size() + " ------------------start", false, 4, (Object) null);
                    list2 = arrayList;
                    it = arrayList.iterator();
                    if (it.hasNext()) {
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    DownloadRange downloadRange = (DownloadRange) r1.L$2;
                    it = (Iterator) r1.L$1;
                    list2 = (List) r1.L$0;
                    ResultKt.b(obj);
                    a.a.r(wf.a.a, "Download_TaskImpl", new String[]{"updateDBRanges,rangeId = " + downloadRange.getRangeId() + ", start = " + downloadRange.getStart() + ", end = " + downloadRange.getEnd() + ", progress = " + downloadRange.getProgress()}, false, 4, (Object) null);
                    it = it;
                    i3 = 1;
                    if (it.hasNext()) {
                        downloadRange = (DownloadRange) it.next();
                        n0 l = a.l();
                        r1.L$0 = list2;
                        r1.L$1 = it;
                        r1.L$2 = downloadRange;
                        r1.label = i3;
                        if (l.c(downloadRange, (Continuation) r1) == f) {
                            return f;
                        }
                        a.a.r(wf.a.a, "Download_TaskImpl", new String[]{"updateDBRanges,rangeId = " + downloadRange.getRangeId() + ", start = " + downloadRange.getStart() + ", end = " + downloadRange.getEnd() + ", progress = " + downloadRange.getProgress()}, false, 4, (Object) null);
                        it = it;
                        i3 = 1;
                        if (it.hasNext()) {
                            a.a.v(wf.a.a, "Download_TaskImpl", "updateDBRanges, size= " + list2.size() + " ------------------end", false, 4, (Object) null);
                            return Unit.a;
                        }
                    }
                }
            }
        }
        r1 = new DownloadTaskUtil$updateDBRanges$1(this, continuation);
        Object obj2 = r1.result;
        Object f2 = IntrinsicsKt.f();
        i = r1.label;
        int i32 = 1;
        if (i != 0) {
        }
    }
}
