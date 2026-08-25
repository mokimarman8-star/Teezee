package com.transsion.subtitle_download;

import android.text.TextUtils;
import com.transsion.subtitle_download.bean.SubtitleAppType;
import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import com.transsion.subtitle_download.task.GetInStationSubtitleListTask;
import com.transsion.subtitle_download.task.q;
import com.transsion.subtitle_download.utils.ObserveNetworkState;
import com.transsion.subtitle_download.utils.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class SubtitleDownloadManager {
    public static final SubtitleDownloadManager a = new SubtitleDownloadManager();
    private static SubtitleAppType b = SubtitleAppType.MB;
    private static final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    private static Function0 d;

    private SubtitleDownloadManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i() {
        String simpleName = SubtitleDownloadManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void b(a aVar) {
        Intrinsics.h(aVar, "listener");
        c.add(aVar);
    }

    public final Object c(String str, Continuation continuation) {
        Object g = i.g(y0.b(), new deleteSubtitle.2(str, (Continuation) null), continuation);
        return g == IntrinsicsKt.f() ? g : Unit.a;
    }

    public final void d(SubtitleDownloadTable subtitleDownloadTable) {
        Intrinsics.h(subtitleDownloadTable, "dbBean");
        GetInStationSubtitleListTask.a.h(subtitleDownloadTable);
    }

    public final void e(String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, int i4, String str6, Function1 function1) {
        GetInStationSubtitleListTask.a.i(str, str2, str4, i2, i3, i4, str3, str5, str6, i, function1);
    }

    public final void f(String str, String str2, String str3, String str4, String str5, String str6, String str7, Function1 function1) {
        Intrinsics.h(str3, "videoResourceId");
        Intrinsics.h(str7, "idType");
        GetInStationSubtitleListTask.a.j(str, str2, str3, str4, str5, str6, str7, function1);
    }

    public final String g() {
        Function0 function0 = d;
        if (function0 != null) {
            return (String) function0.invoke();
        }
        return null;
    }

    public final SubtitleAppType h() {
        return b;
    }

    public final Object j(String str, Continuation continuation) {
        return i.g(y0.b(), new getSubtitleList.2(str, (Continuation) null), continuation);
    }

    public final void k(SubtitleAppType subtitleAppType) {
        Intrinsics.h(subtitleAppType, "appType");
        b = subtitleAppType;
        b.a.b(i() + " --> init() --> 字幕下载工具初始化");
        ObserveNetworkState.a.d();
    }

    public final void l(Function0 function0) {
        d = function0;
    }

    public final Object m(SubtitleDownloadTable subtitleDownloadTable, Continuation continuation) {
        if (!TextUtils.isEmpty(subtitleDownloadTable.getPath()) && !TextUtils.isEmpty(subtitleDownloadTable.getResourceId()) && !TextUtils.isEmpty(subtitleDownloadTable.getId())) {
            Object g = i.g(y0.b(), new migration.2(subtitleDownloadTable, (Continuation) null), continuation);
            return g == IntrinsicsKt.f() ? g : Unit.a;
        }
        b.a.b(i() + " --> migration() --> 缺少必要字段 --> path = " + subtitleDownloadTable.getPath() + " -- resourceId = " + subtitleDownloadTable.getResourceId() + " -- id = " + subtitleDownloadTable.getId());
        return Unit.a;
    }

    public final void n(SubtitleDownloadTable subtitleDownloadTable) {
        Intrinsics.h(subtitleDownloadTable, "stDownloadTable");
        q.a.c(subtitleDownloadTable);
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onComplete(subtitleDownloadTable);
        }
    }

    public final void o(Exception exc, SubtitleDownloadTable subtitleDownloadTable) {
        Intrinsics.h(exc, "e");
        Intrinsics.h(subtitleDownloadTable, "dbBean");
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onFail(exc, subtitleDownloadTable);
        }
    }

    public final void p(int i, SubtitleDownloadTable subtitleDownloadTable) {
        Intrinsics.h(subtitleDownloadTable, "stDownloadTable");
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onDownloading(i, subtitleDownloadTable);
        }
    }

    public final void q(SubtitleDownloadTable subtitleDownloadTable) {
        Intrinsics.h(subtitleDownloadTable, "bean");
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onSaveDownload(subtitleDownloadTable);
        }
    }

    public final void r(SubtitleDownloadTable subtitleDownloadTable) {
        Intrinsics.h(subtitleDownloadTable, "stDownloadTable");
        Iterator it = c.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onUnGzZip(subtitleDownloadTable);
        }
    }

    public final void s(a aVar) {
        Intrinsics.h(aVar, "listener");
        c.remove(aVar);
    }
}
