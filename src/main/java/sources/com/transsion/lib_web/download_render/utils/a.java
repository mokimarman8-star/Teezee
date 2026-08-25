package com.transsion.lib_web.download_render.utils;

import com.transsion.gslb.BuildConfig;
import com.transsion.lib_web.download_render.data.FileData;
import com.transsion.lib_web.download_render.data.PageData;
import com.transsion.lib_web.download_render.data.PageListData;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();
    private static final ConcurrentHashMap b = new ConcurrentHashMap();

    private a() {
    }

    private final RenderStage c(String str) {
        try {
            return (RenderStage) b.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private final void l(String str) {
        try {
            b.remove(str);
        } catch (Throwable unused) {
        }
    }

    public final void a(String str, RenderSource renderSource) {
        Intrinsics.h(str, "url");
        Intrinsics.h(renderSource, "source");
        try {
            ConcurrentHashMap concurrentHashMap = b;
            concurrentHashMap.remove(str);
            concurrentHashMap.put(str, new RenderStage(str, renderSource.getDes(), System.currentTimeMillis(), false, false, false, null, null, null, null, 1016, null));
        } catch (Throwable unused) {
        }
    }

    public final void b() {
        List<PageData> l;
        Map<String, PageData> h;
        try {
            com.transsion.lib_web.download_render.c cVar = com.transsion.lib_web.download_render.c.a;
            PageListData l2 = cVar.l();
            if (l2 == null || (l = l2.getH5Pages()) == null) {
                l = CollectionsKt.l();
            }
            PageListData l3 = cVar.l();
            if (l3 == null || (h = l3.getLocalH5Pages()) == null) {
                h = MapsKt.h();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (PageData pageData : l) {
                String url = pageData.getUrl();
                if (url != null) {
                    PageData pageData2 = h.get(url);
                    String str = BuildConfig.FLAVOR;
                    if (pageData2 == null) {
                        String versionCode = pageData.getVersionCode();
                        if (versionCode != null) {
                            str = versionCode;
                        }
                        List<FileData> files = pageData.getFiles();
                        linkedHashMap.put(url, new DownloadData(url, str, files != null ? files.size() : 0, 0));
                    } else {
                        String versionCode2 = pageData.getVersionCode();
                        if (versionCode2 != null) {
                            str = versionCode2;
                        }
                        List<FileData> files2 = pageData.getFiles();
                        linkedHashMap.put(url, new DownloadData(url, str, files2 != null ? files2.size() : 0, pageData2.getLocalFileMap().size()));
                    }
                }
            }
            ReportUtil.a.a(linkedHashMap);
        } catch (Throwable unused) {
        }
    }

    public final void d(String str) {
        Intrinsics.h(str, "url");
        RenderStage c = c(str);
        if (c != null) {
            if (!c.getStage1().getStageFinished()) {
                FileScoreData stage1 = c.getStage1();
                stage1.setException(stage1.getException() + 1);
            }
            if (!c.getStage2().getStageFinished()) {
                FileScoreData stage2 = c.getStage2();
                stage2.setException(stage2.getException() + 1);
            }
            if (c.getStage3().getStageFinished()) {
                return;
            }
            FileScoreData stage3 = c.getStage3();
            stage3.setException(stage3.getException() + 1);
        }
    }

    public final void e(String str) {
        Intrinsics.h(str, "url");
        RenderStage c = c(str);
        if (c != null) {
            if (!c.getStage1().getStageFinished()) {
                FileScoreData stage1 = c.getStage1();
                stage1.setFileDataNull(stage1.getFileDataNull() + 1);
            }
            if (!c.getStage2().getStageFinished()) {
                FileScoreData stage2 = c.getStage2();
                stage2.setFileDataNull(stage2.getFileDataNull() + 1);
            }
            if (c.getStage3().getStageFinished()) {
                return;
            }
            FileScoreData stage3 = c.getStage3();
            stage3.setFileDataNull(stage3.getFileDataNull() + 1);
        }
    }

    public final void f(String str) {
        Intrinsics.h(str, "url");
        RenderStage c = c(str);
        if (c != null) {
            if (!c.getStage1().getStageFinished()) {
                FileScoreData stage1 = c.getStage1();
                stage1.setFileOperateStatusAbort(stage1.getFileOperateStatusAbort() + 1);
            }
            if (!c.getStage2().getStageFinished()) {
                FileScoreData stage2 = c.getStage2();
                stage2.setFileOperateStatusAbort(stage2.getFileOperateStatusAbort() + 1);
            }
            if (c.getStage3().getStageFinished()) {
                return;
            }
            FileScoreData stage3 = c.getStage3();
            stage3.setFileOperateStatusAbort(stage3.getFileOperateStatusAbort() + 1);
        }
    }

    public final void g(String str) {
        Intrinsics.h(str, "url");
        RenderStage c = c(str);
        if (c != null) {
            if (!c.getStage1().getStageFinished()) {
                FileScoreData stage1 = c.getStage1();
                stage1.setFileUnExist(stage1.getFileUnExist() + 1);
            }
            if (!c.getStage2().getStageFinished()) {
                FileScoreData stage2 = c.getStage2();
                stage2.setFileUnExist(stage2.getFileUnExist() + 1);
            }
            if (c.getStage3().getStageFinished()) {
                return;
            }
            FileScoreData stage3 = c.getStage3();
            stage3.setFileUnExist(stage3.getFileUnExist() + 1);
        }
    }

    public final void h(String str) {
        Intrinsics.h(str, "url");
        RenderStage c = c(str);
        if (c != null) {
            if (!c.getStage1().getStageFinished()) {
                FileScoreData stage1 = c.getStage1();
                stage1.setHtmlFromRemote(stage1.getHtmlFromRemote() + 1);
            }
            if (!c.getStage2().getStageFinished()) {
                FileScoreData stage2 = c.getStage2();
                stage2.setHtmlFromRemote(stage2.getHtmlFromRemote() + 1);
            }
            if (c.getStage3().getStageFinished()) {
                return;
            }
            FileScoreData stage3 = c.getStage3();
            stage3.setHtmlFromRemote(stage3.getHtmlFromRemote() + 1);
        }
    }

    public final void i(String str) {
        Intrinsics.h(str, "url");
        RenderStage c = c(str);
        if (c != null) {
            if (!c.getStage1().getStageFinished()) {
                FileScoreData stage1 = c.getStage1();
                stage1.setScore(stage1.getScore() + 1);
            }
            if (!c.getStage2().getStageFinished()) {
                FileScoreData stage2 = c.getStage2();
                stage2.setScore(stage2.getScore() + 1);
            }
            if (c.getStage3().getStageFinished()) {
                return;
            }
            FileScoreData stage3 = c.getStage3();
            stage3.setScore(stage3.getScore() + 1);
        }
    }

    public final void j(String str) {
        Intrinsics.h(str, "url");
        RenderStage c = c(str);
        if (c != null) {
            c.setNeedReport(true);
        }
    }

    public final void k(String str, String str2, int i) {
        Intrinsics.h(str, "url");
        Intrinsics.h(str2, "originalUrl");
        if (Intrinsics.c(str, str2) && i == 100) {
            p(str);
        }
    }

    public final void m(String str) {
        Intrinsics.h(str, "url");
        RenderStage c = c(str);
        if (c != null) {
            c.setRenderWithDownload(true);
        }
    }

    public final void n() {
        ConcurrentHashMap concurrentHashMap = b;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        Set keySet = concurrentHashMap.keySet();
        Intrinsics.g(keySet, "<get-keys>(...)");
        Object h0 = CollectionsKt.h0(keySet);
        Intrinsics.g(h0, "first(...)");
        String str = (String) h0;
        q(str);
        ReportUtil reportUtil = ReportUtil.a;
        Collection values = concurrentHashMap.values();
        Intrinsics.g(values, "<get-values>(...)");
        reportUtil.c((RenderStage) CollectionsKt.h0(values));
        l(str);
    }

    public final void o(String str, CacheType cacheType) {
        Intrinsics.h(str, "url");
        Intrinsics.h(cacheType, "cacheType");
        RenderStage c = c(str);
        if (c != null) {
            c.setType(cacheType.getDes());
        }
    }

    public final void p(String str) {
        Intrinsics.h(str, "url");
        RenderStage c = c(str);
        if (c != null) {
            c.getStage1().setStageFinished(true);
            c.getStage1().setRenderTime(System.currentTimeMillis() - c.getRenderStartTime());
        }
    }

    public final void q(String str) {
        Intrinsics.h(str, "url");
        RenderStage c = c(str);
        if (c != null) {
            c.getStage3().setStageFinished(true);
            c.getStage3().setRenderTime(System.currentTimeMillis() - c.getRenderStartTime());
        }
    }

    public final void r(String str) {
        Intrinsics.h(str, "url");
        RenderStage c = c(str);
        if (c != null) {
            c.getStage2().setStageFinished(true);
            c.getStage2().setRenderTime(System.currentTimeMillis() - c.getRenderStartTime());
        }
    }
}
