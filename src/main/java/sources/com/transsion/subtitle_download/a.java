package com.transsion.subtitle_download;

import com.transsion.subtitle_download.db.SubtitleDownloadTable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface a {

    /* renamed from: com.transsion.subtitle_download.a$a, reason: collision with other inner class name */
    public static final class C0010a {
        public static void a(a aVar, SubtitleDownloadTable bean) {
            Intrinsics.h(bean, "bean");
        }

        public static void b(a aVar, SubtitleDownloadTable stDownloadTable) {
            Intrinsics.h(stDownloadTable, "stDownloadTable");
        }
    }

    void onComplete(SubtitleDownloadTable subtitleDownloadTable);

    void onDownloading(int i, SubtitleDownloadTable subtitleDownloadTable);

    void onFail(Exception exc, SubtitleDownloadTable subtitleDownloadTable);

    void onSaveDownload(SubtitleDownloadTable subtitleDownloadTable);

    void onUnGzZip(SubtitleDownloadTable subtitleDownloadTable);
}
