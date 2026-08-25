package sl;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.transsion.lib_web.LoadUrlData;
import com.transsion.lib_web.download_render.data.FileData;
import com.transsion.lib_web.download_render.data.FileOperateStatus;
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
public final class c implements com.transsion.lib_web.zip.loader.c {
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

    public c(Context context, LoadUrlData loadUrlData) {
        Intrinsics.h(context, "context");
        Intrinsics.h(loadUrlData, "loadUrlData");
        this.b = context;
        this.c = loadUrlData;
        com.transsion.lib_web.download_render.c.a.v(loadUrlData.getOriginUrl());
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032 A[Catch: all -> 0x01d6, TRY_ENTER, TryCatch #0 {all -> 0x01d6, blocks: (B:50:0x0005, B:52:0x000b, B:5:0x0013, B:8:0x001d, B:11:0x0032, B:14:0x004c, B:16:0x0052, B:18:0x006c, B:21:0x0079, B:23:0x009b, B:25:0x00a3, B:27:0x00ab, B:29:0x00ce, B:31:0x00d6, B:33:0x0109, B:35:0x010f, B:37:0x0132, B:39:0x013d, B:41:0x016c, B:43:0x017d, B:45:0x0188, B:47:0x0183), top: B:49:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c A[Catch: all -> 0x01d6, TryCatch #0 {all -> 0x01d6, blocks: (B:50:0x0005, B:52:0x000b, B:5:0x0013, B:8:0x001d, B:11:0x0032, B:14:0x004c, B:16:0x0052, B:18:0x006c, B:21:0x0079, B:23:0x009b, B:25:0x00a3, B:27:0x00ab, B:29:0x00ce, B:31:0x00d6, B:33:0x0109, B:35:0x010f, B:37:0x0132, B:39:0x013d, B:41:0x016c, B:43:0x017d, B:45:0x0188, B:47:0x0183), top: B:49:0x0005 }] */
    @Override // com.transsion.lib_web.zip.loader.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public WebResourceResponse a(WebResourceRequest webResourceRequest) {
        Uri url;
        String uri;
        com.transsion.lib_web.download_render.c cVar;
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
                    cVar = com.transsion.lib_web.download_render.c.a;
                    if (cVar.h(this.c.getOriginUrl()) == null) {
                        h.a.f("DR_WebviewRenderIgnorePageUrlFileLoader", "<interceptRequest> url:" + uri + " pageData is not null return");
                        return null;
                    }
                    FileData f = cVar.f(uri);
                    if (f == null) {
                        h.a.f("DR_WebviewRenderIgnorePageUrlFileLoader", "<interceptRequest> url:" + uri + " fileData is null return");
                        return null;
                    }
                    if (Intrinsics.c(f.getMimeType(), "application/octet-stream")) {
                        return null;
                    }
                    com.transsion.lib_web.download_render.utils.a aVar = com.transsion.lib_web.download_render.utils.a.a;
                    aVar.j(this.c.getOriginUrl());
                    aVar.o(this.c.getOriginUrl(), CacheType.ALL);
                    if (Intrinsics.c(f.getMimeType(), "text/html") && this.c.getHtmlUseRemote() && com.transsion.lib_web.download_render.utils.d.a.a()) {
                        aVar.h(this.c.getOriginUrl());
                        h.a.a("DR_WebviewRenderIgnorePageUrlFileLoader", "<interceptRequest> url:" + uri + " is html use remote");
                        return null;
                    }
                    if (f.getFileOperateStatus$lib_web_release() != FileOperateStatus.NONE) {
                        aVar.f(this.c.getOriginUrl());
                        h.a.f("DR_WebviewRenderIgnorePageUrlFileLoader", "<interceptRequest> url:" + uri + " fileOperateStatus:" + f.getFileOperateStatus$lib_web_release().getType() + " unNormal return");
                        return null;
                    }
                    String fileLocalPath$lib_web_release = f.getFileLocalPath$lib_web_release();
                    if (fileLocalPath$lib_web_release == null) {
                        aVar.g(this.c.getOriginUrl());
                        h.a.f("DR_WebviewRenderIgnorePageUrlFileLoader", "<interceptRequest> url:" + uri + " fileLocalPath is null return");
                        return null;
                    }
                    File file = new File(fileLocalPath$lib_web_release);
                    if (!file.exists()) {
                        aVar.g(this.c.getOriginUrl());
                        h.a.f("DR_WebviewRenderIgnorePageUrlFileLoader", "<interceptRequest> url:" + uri + " file:" + file.getAbsoluteFile() + " is not exist return");
                        return null;
                    }
                    FileInputStream fileInputStream = new FileInputStream(file);
                    String mimeType = f.getMimeType();
                    if (webResourceRequest == null || (hashMap = webResourceRequest.getRequestHeaders()) == null) {
                        hashMap = new HashMap<>();
                    }
                    WebResourceResponse webResourceResponse = new WebResourceResponse(mimeType, "UTF-8", 200, "OK", b(hashMap), fileInputStream);
                    aVar.i(this.c.getOriginUrl());
                    h.a.a("DR_WebviewRenderIgnorePageUrlFileLoader", "<interceptRequest> url:" + uri + ", mimeType:" + mimeType + ", length:" + file.length() + ", file:" + file.getAbsoluteFile() + " exist");
                    return webResourceResponse;
                }
                return null;
            }
        }
        uri = null;
        if (uri != null) {
            System.currentTimeMillis();
            cVar = com.transsion.lib_web.download_render.c.a;
            if (cVar.h(this.c.getOriginUrl()) == null) {
            }
        }
        return null;
    }

    public Map b(Map map) {
        return c.b.a(this, map);
    }
}
