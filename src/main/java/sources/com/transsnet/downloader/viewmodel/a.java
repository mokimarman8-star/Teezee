package com.transsnet.downloader.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.t0;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.moviedetailapi.SubjectType;
import com.transsnet.downloader.bean.HistoricalPlayRecordBean;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Settings;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class a extends t0 {
    private final CopyOnWriteArrayList a = new CopyOnWriteArrayList();

    public final DownloadBean b(j0 video) {
        Intrinsics.h(video, "video");
        a0 a0Var = a0.a;
        String j = a0Var.j(video);
        if (TextUtils.isEmpty(j)) {
            this.a.add(video);
        }
        String e = video.e();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        String str2 = e == null ? HttpUrl.FRAGMENT_ENCODE_SET : e;
        String e2 = video.e();
        String d = video.d();
        String e3 = video.e();
        if (e3 == null) {
            e3 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        long f = a0Var.f(e3);
        String e4 = video.e();
        Long a = video.a();
        String e5 = video.e();
        if (e5 != null) {
            str = e5;
        }
        return new DownloadBean(str2, e2, d, j, Long.valueOf(f), (String) null, (String) null, e4, a, Long.valueOf(a0Var.e(str)), 0L, 0, 0, 2, 0L, 0L, 1, 0, 0, 0, 0, 0, 0, video.f(), video.b(), 0, 0, (String) null, (String) null, (String) null, (String) null, 0L, 2, 0, (String) null, (String) null, 0L, (String) null, (String) null, 0L, 0, 0L, (String) null, 0, (String) null, (String) null, false, false, SubjectType.OUTSIDE_FILE.getValue(), (String) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (String) null, (Long) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Integer) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, false, (String) null, (String) null, 108789760, -65538, Settings.DEFAULT_INITIAL_WINDOW_SIZE, (DefaultConstructorMarker) null);
    }

    public final HistoricalPlayRecordBean c(DownloadBean createDownload) {
        Intrinsics.h(createDownload, "createDownload");
        Long updateTimeStamp = createDownload.getUpdateTimeStamp();
        Long updateTimeStamp2 = createDownload.getUpdateTimeStamp();
        String n = TimeUtilKt.n(updateTimeStamp2 != null ? updateTimeStamp2.longValue() : 0L);
        a0 a0Var = a0.a;
        Long updateTimeStamp3 = createDownload.getUpdateTimeStamp();
        return new HistoricalPlayRecordBean(2, updateTimeStamp, n, a0Var.z(updateTimeStamp3 != null ? updateTimeStamp3.longValue() : 0L), null, createDownload, null, null, null, 448, null);
    }

    public final CopyOnWriteArrayList d() {
        return this.a;
    }
}
