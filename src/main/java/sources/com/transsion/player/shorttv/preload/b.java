package com.transsion.player.shorttv.preload;

import androidx.media3.common.t;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.cache.a;
import androidx.media3.exoplayer.offline.DownloadRequest;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends androidx.media3.exoplayer.offline.b {
    private final a.c d;
    private final Executor e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a.c cVar, Executor executor) {
        super(cVar, executor);
        Intrinsics.h(cVar, "cacheDataSourceFactory");
        Intrinsics.h(executor, "executor");
        this.d = cVar;
        this.e = executor;
    }

    public androidx.media3.exoplayer.offline.o a(DownloadRequest downloadRequest) {
        Intrinsics.h(downloadRequest, "request");
        int A0 = a1.A0(downloadRequest.uri, downloadRequest.mimeType);
        if (A0 == 0 || A0 == 1 || A0 == 2) {
            androidx.media3.exoplayer.offline.o a = super.a(downloadRequest);
            Intrinsics.g(a, "createDownloader(...)");
            return a;
        }
        if (A0 == 4) {
            return new VideoProgressiveDownloader(new t.c().i(downloadRequest.uri).b(downloadRequest.customCacheKey).a(), this.d, this.e);
        }
        throw new IllegalArgumentException("Unsupported type: " + A0);
    }
}
