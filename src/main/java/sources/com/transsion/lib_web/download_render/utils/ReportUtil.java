package com.transsion.lib_web.download_render.utils;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class ReportUtil {
    public static final ReportUtil a = new ReportUtil();
    private static final n0 b;

    static {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.g(newSingleThreadExecutor, "newSingleThreadExecutor(...)");
        b = o0.a(m1.c(newSingleThreadExecutor));
    }

    private ReportUtil() {
    }

    public final void a(Map map) {
        Intrinsics.h(map, "datas");
        i.d(b, (CoroutineContext) null, (CoroutineStart) null, new ReportUtil$reportManifestDownload$1(map, null), 3, (Object) null);
    }

    public final void b(String str, String str2, int i, int i2, int i3, int i4, int i5, long j, boolean z, long j2, long j3) {
        Intrinsics.h(str, "url");
        Intrinsics.h(str2, "versionCode");
        i.d(b, (CoroutineContext) null, (CoroutineStart) null, new ReportUtil$reportPageDownload$1(str, str2, i, i2, i3, i4, j, z, i5, j2, j3, null), 3, (Object) null);
    }

    public final void c(RenderStage renderStage) {
        i.d(b, (CoroutineContext) null, (CoroutineStart) null, new ReportUtil$reportRender$1(renderStage, null), 3, (Object) null);
    }
}
