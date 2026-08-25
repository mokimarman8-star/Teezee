package tl;

import com.blankj.utilcode.util.o;
import com.transsion.lib_web.download_render.data.FileData;
import com.transsion.lib_web.download_render.data.PageData;
import com.transsion.lib_web.download_render.data.PageListData;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import pl.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e implements d {
    private final long a;
    private final PageData b;
    private final String c;

    public e(long j, PageData pageData) {
        Intrinsics.h(pageData, "pageData");
        this.a = j;
        this.b = pageData;
        this.c = "DR_ManifestDownloadTask";
    }

    @Override // tl.d
    public void start() {
        String manifestUrl;
        List<PageData> h5Pages;
        PageListData l = com.transsion.lib_web.download_render.c.a.l();
        if (l != null && (h5Pages = l.getH5Pages()) != null) {
            for (PageData pageData : h5Pages) {
                if (Intrinsics.c(pageData.getUrl(), this.b.getUrl())) {
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        pageData = null;
        List<FileData> files = pageData != null ? pageData.getFiles() : null;
        if ((files != null && !files.isEmpty()) || pageData == null || (manifestUrl = pageData.getManifestUrl()) == null) {
            return;
        }
        try {
            h hVar = h.a;
            hVar.a(this.c, "<ManifestDownloadTask> start id:" + this.a);
            Response execute = com.transsion.lib_web.zip.loader.b.a.d().newCall(new Request.Builder().url(manifestUrl).build()).execute();
            try {
                if (!execute.isSuccessful()) {
                    throw new IOException("Unexpected code " + execute);
                }
                ResponseBody body = execute.body();
                if (body != null) {
                    try {
                        pageData.setFiles(((PageData) o.d(body.string(), PageData.class)).getFiles());
                        com.transsion.lib_web.download_render.c.a.o(pageData);
                        Unit unit = Unit.a;
                        CloseableKt.a(body, (Throwable) null);
                    } finally {
                    }
                }
                CloseableKt.a(execute, (Throwable) null);
                hVar.a(this.c, "<ManifestDownloadTask> end id:" + this.a);
            } finally {
            }
        } catch (Throwable th2) {
            try {
                h hVar2 = h.a;
                hVar2.f(this.c, "<ManifestDownloadTask> download: " + manifestUrl + " fail, msg:" + th2);
                Unit unit2 = Unit.a;
                hVar2.a(this.c, "<ManifestDownloadTask> end id:" + this.a);
            } catch (Throwable th3) {
                h.a.a(this.c, "<ManifestDownloadTask> end id:" + this.a);
                throw th3;
            }
        }
    }
}
