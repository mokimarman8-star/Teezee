package sl;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.transsion.lib_web.LoadUrlData;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pl.h;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements com.transsion.lib_web.zip.loader.c {
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

    public b(Context context, LoadUrlData loadUrlData) {
        Intrinsics.h(context, "context");
        Intrinsics.h(loadUrlData, "loadUrlData");
        this.b = context;
        this.c = loadUrlData;
    }

    @Override // com.transsion.lib_web.zip.loader.c
    public WebResourceResponse a(WebResourceRequest webResourceRequest) {
        Uri url;
        String uri;
        if (webResourceRequest != null) {
            try {
                url = webResourceRequest.getUrl();
            } catch (Throwable unused) {
            }
            if (url != null) {
                uri = url.toString();
                if (uri != null && !Intrinsics.c(uri, "yy://__QUEUE_MESSAGE__") && Intrinsics.c(uri, this.c.getOriginUrl())) {
                    h.a.a("DR_WebviewRenderHomePageFileLoader", "<interceptRequest> url:" + uri + " is home page");
                    com.transsion.lib_web.download_render.utils.a aVar = com.transsion.lib_web.download_render.utils.a.a;
                    aVar.n();
                    aVar.a(uri, this.c.getSource());
                }
                return null;
            }
        }
        uri = null;
        if (uri != null) {
            h.a.a("DR_WebviewRenderHomePageFileLoader", "<interceptRequest> url:" + uri + " is home page");
            com.transsion.lib_web.download_render.utils.a aVar2 = com.transsion.lib_web.download_render.utils.a.a;
            aVar2.n();
            aVar2.a(uri, this.c.getSource());
        }
        return null;
    }
}
