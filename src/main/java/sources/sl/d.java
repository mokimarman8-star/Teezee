package sl;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.transsion.lib_web.LoadUrlData;
import com.transsion.lib_web.download_render.data.FileData;
import com.transsion.lib_web.download_render.data.FileOperateStatus;
import com.transsion.lib_web.download_render.data.PageData;
import com.transsion.lib_web.download_render.utils.CacheType;
import com.transsion.lib_web.zip.loader.c;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pl.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class d implements com.transsion.lib_web.zip.loader.c {
    public static final a d = new a(null);
    private final Context b;
    private final LoadUrlData c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(Context context, LoadUrlData loadUrlData) {
        Intrinsics.h(context, "context");
        Intrinsics.h(loadUrlData, "loadUrlData");
        this.b = context;
        this.c = loadUrlData;
        com.transsion.lib_web.download_render.c.a.v(loadUrlData.getOriginUrl());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[Catch: all -> 0x01e6, TRY_ENTER, TryCatch #0 {all -> 0x01e6, blocks: (B:53:0x0005, B:55:0x000b, B:5:0x0013, B:8:0x001d, B:11:0x0032, B:14:0x004c, B:16:0x006e, B:18:0x0091, B:21:0x009e, B:24:0x00ab, B:26:0x00b7, B:28:0x00bf, B:30:0x00c7, B:32:0x00ea, B:34:0x00f2, B:36:0x0125, B:38:0x012b, B:40:0x014e, B:42:0x0159, B:44:0x0188, B:46:0x0199, B:48:0x01a4, B:50:0x019f), top: B:52:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c A[Catch: all -> 0x01e6, TryCatch #0 {all -> 0x01e6, blocks: (B:53:0x0005, B:55:0x000b, B:5:0x0013, B:8:0x001d, B:11:0x0032, B:14:0x004c, B:16:0x006e, B:18:0x0091, B:21:0x009e, B:24:0x00ab, B:26:0x00b7, B:28:0x00bf, B:30:0x00c7, B:32:0x00ea, B:34:0x00f2, B:36:0x0125, B:38:0x012b, B:40:0x014e, B:42:0x0159, B:44:0x0188, B:46:0x0199, B:48:0x01a4, B:50:0x019f), top: B:52:0x0005 }] */
    @Override // com.transsion.lib_web.zip.loader.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WebResourceResponse a(WebResourceRequest webResourceRequest) {
        Uri url;
        String uri;
        PageData h;
        Map<String, String> hashMap;
        if (webResourceRequest != null) {
            try {
                url = webResourceRequest.getUrl();
            } catch (Throwable unused) {
                com.transsion.lib_web.download_render.utils.a.a.d(this.c.getOriginUrl());
            }
            if (url != null) {
                uri = url.toString();
                if (uri != null && !Intrinsics.c(uri, "yy://__QUEUE_MESSAGE__")) {
                    System.currentTimeMillis();
                    h = com.transsion.lib_web.download_render.c.a.h(this.c.getOriginUrl());
                    if (h != null) {
                        h.a.f("DR_WebviewRenderStaticFileLoader", "<interceptRequest> url:" + uri + " pageData is null return");
                        return null;
                    }
                    com.transsion.lib_web.download_render.utils.a aVar = com.transsion.lib_web.download_render.utils.a.a;
                    aVar.j(this.c.getOriginUrl());
                    aVar.o(this.c.getOriginUrl(), CacheType.PAGE);
                    FileData fileData = h.getLocalFileMap().get(uri);
                    if (fileData == null) {
                        aVar.e(this.c.getOriginUrl());
                        h.a.f("DR_WebviewRenderStaticFileLoader", "<interceptRequest> url:" + uri + " fileData is null return");
                        return null;
                    }
                    if (Intrinsics.c(fileData.getMimeType(), "application/octet-stream") || !Intrinsics.c(fileData.isStatic(), Boolean.TRUE)) {
                        return null;
                    }
                    if (Intrinsics.c(fileData.getMimeType(), "text/html") && this.c.getHtmlUseRemote() && com.transsion.lib_web.download_render.utils.d.a.a()) {
                        aVar.h(this.c.getOriginUrl());
                        h.a.a("DR_WebviewRenderStaticFileLoader", "<interceptRequest> url:" + uri + " is html use remote");
                        return null;
                    }
                    if (fileData.getFileOperateStatus$lib_web_release() != FileOperateStatus.NONE) {
                        aVar.f(this.c.getOriginUrl());
                        h.a.f("DR_WebviewRenderStaticFileLoader", "<interceptRequest> url:" + uri + " fileOperateStatus:" + fileData.getFileOperateStatus$lib_web_release().getType() + " unNormal return");
                        return null;
                    }
                    String fileLocalPath$lib_web_release = fileData.getFileLocalPath$lib_web_release();
                    if (fileLocalPath$lib_web_release == null) {
                        aVar.g(this.c.getOriginUrl());
                        h.a.f("DR_WebviewRenderStaticFileLoader", "<interceptRequest> url:" + uri + " fileLocalPath is null return");
                        return null;
                    }
                    File file = new File(fileLocalPath$lib_web_release);
                    if (!file.exists()) {
                        aVar.g(this.c.getOriginUrl());
                        h.a.f("DR_WebviewRenderStaticFileLoader", "<interceptRequest> url:" + uri + " file:" + file.getAbsoluteFile() + " is not exist return");
                        return null;
                    }
                    FileInputStream fileInputStream = new FileInputStream(file);
                    String mimeType = fileData.getMimeType();
                    if (webResourceRequest == null || (hashMap = webResourceRequest.getRequestHeaders()) == null) {
                        hashMap = new HashMap<>();
                    }
                    WebResourceResponse webResourceResponse = new WebResourceResponse(mimeType, "UTF-8", 200, "OK", b(hashMap), fileInputStream);
                    aVar.i(this.c.getOriginUrl());
                    h.a.a("DR_WebviewRenderStaticFileLoader", "<interceptRequest> url:" + uri + ", mimeType:" + mimeType + ", file:" + file.getAbsoluteFile() + " exist");
                    return webResourceResponse;
                }
                return null;
            }
        }
        uri = null;
        if (uri != null) {
            System.currentTimeMillis();
            h = com.transsion.lib_web.download_render.c.a.h(this.c.getOriginUrl());
            if (h != null) {
            }
        }
        return null;
    }

    public Map b(Map map) {
        return c.b.a(this, map);
    }
}
