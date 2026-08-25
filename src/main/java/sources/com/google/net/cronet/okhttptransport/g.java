package com.google.net.cronet.okhttptransport;

import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class g {
    private final CronetEngine a;
    private final Executor b;
    private final i c;
    private final d d;
    private final com.google.net.cronet.okhttptransport.c e;

    class a implements c {
        final /* synthetic */ Request a;
        final /* synthetic */ OkHttpBridgeRequestCallback b;

        a(Request request, OkHttpBridgeRequestCallback okHttpBridgeRequestCallback) {
            this.a = request;
            this.b = okHttpBridgeRequestCallback;
        }

        @Override // com.google.net.cronet.okhttptransport.g.c
        public Response getResponse() {
            return g.this.c.f(this.a, this.b);
        }
    }

    static final class b {
        private final UrlRequest a;
        private final c b;

        b(UrlRequest urlRequest, c cVar) {
            this.a = urlRequest;
            this.b = cVar;
        }

        public UrlRequest a() {
            return this.a;
        }

        public Response b() {
            return this.b.getResponse();
        }
    }

    private interface c {
        Response getResponse();
    }

    g(CronetEngine cronetEngine, Executor executor, d dVar, i iVar, com.google.net.cronet.okhttptransport.c cVar) {
        this.a = cronetEngine;
        this.b = executor;
        this.d = dVar;
        this.c = iVar;
        this.e = cVar;
    }

    private c c(Request request, OkHttpBridgeRequestCallback okHttpBridgeRequestCallback) {
        return new a(request, okHttpBridgeRequestCallback);
    }

    b b(Request request, int i, int i2) {
        OkHttpBridgeRequestCallback okHttpBridgeRequestCallback = new OkHttpBridgeRequestCallback(i, this.e);
        UrlRequest.Builder allowDirectExecutor = this.a.newUrlRequestBuilder(request.url().toString(), okHttpBridgeRequestCallback, MoreExecutors.a()).allowDirectExecutor();
        allowDirectExecutor.setHttpMethod(request.method());
        for (int i3 = 0; i3 < request.headers().size(); i3++) {
            allowDirectExecutor.addHeader(request.headers().name(i3), request.headers().value(i3));
        }
        RequestBody body = request.body();
        if (body != null) {
            if (request.header("Content-Length") == null && body.contentLength() != -1) {
                allowDirectExecutor.addHeader("Content-Length", String.valueOf(body.contentLength()));
            }
            if (body.contentLength() != 0) {
                if (request.header("Content-Type") != null || body.contentType() == null) {
                    allowDirectExecutor.addHeader("Content-Type", "application/octet-stream");
                } else {
                    allowDirectExecutor.addHeader("Content-Type", body.contentType().toString());
                }
                allowDirectExecutor.setUploadDataProvider(this.d.a(body, i2), this.b);
            }
        }
        return new b(allowDirectExecutor.build(), c(request, okHttpBridgeRequestCallback));
    }
}
