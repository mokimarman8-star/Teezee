package com.transsnet.downloader.core.thread;

import com.transsion.baselib.db.download.DownloadRange;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface d {

    public static final class a {
        public static void a(d dVar, f runnable, int i, DownloadRange curRange) {
            Intrinsics.h(runnable, "runnable");
            Intrinsics.h(curRange, "curRange");
        }
    }

    void a(f fVar, int i, DownloadRange downloadRange);

    void c(f fVar, int i, DownloadRange downloadRange);

    void d();

    void e();

    void f(f fVar, int i, DownloadRange downloadRange);
}
