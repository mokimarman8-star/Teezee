package com.cloud.hisavana.protocol.okhttptransport;

import com.google.common.base.m;
import com.google.common.base.o;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.g3;
import com.google.common.util.concurrent.z;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Okio;
import okio.Source;
import org.chromium.net.UrlResponseInfo;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
final class i {
    private static final ImmutableSet a = ImmutableSet.of("br", "deflate", "gzip", "x-gzip");
    private static final o b = o.f(',').k().e();

    i() {
    }

    private static Protocol a(String str) {
        if (!str.contains("quic") && !str.contains("h3")) {
            if (!str.contains("spdy") && !str.contains("h2")) {
                return str.contains("http/1.1") ? Protocol.HTTP_1_1 : Protocol.HTTP_1_0;
            }
            return Protocol.HTTP_2;
        }
        return Protocol.QUIC;
    }

    private static Response.Builder b(Request request, UrlResponseInfo urlResponseInfo, Source source) {
        Response.Builder builder = new Response.Builder();
        String e = e("Content-Type", urlResponseInfo);
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) f(urlResponseInfo.getAllHeaders(), "Content-Encoding", Collections.emptyList())).iterator();
        while (it.hasNext()) {
            g3.a(arrayList, b.h((String) it.next()));
        }
        boolean z = arrayList.isEmpty() || !a.containsAll(arrayList);
        builder.request(request).code(urlResponseInfo.getHttpStatusCode()).message(urlResponseInfo.getHttpStatusText()).protocol(a(urlResponseInfo.getNegotiatedProtocol())).body(source != null ? c(request, urlResponseInfo.getHttpStatusCode(), e, z ? e("Content-Length", urlResponseInfo) : null, source) : null);
        for (Map.Entry entry : urlResponseInfo.getAllHeadersAsList()) {
            if (z || (!com.google.common.base.a.a((CharSequence) entry.getKey(), "Content-Length") && !com.google.common.base.a.a((CharSequence) entry.getKey(), "Content-Encoding"))) {
                builder.addHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return builder;
    }

    private static ResponseBody c(Request request, int i, String str, String str2, Source source) {
        long j;
        if (request.method().equals("HEAD")) {
            j = 0;
        } else {
            j = -1;
            if (str2 != null) {
                try {
                    j = Long.parseLong(str2);
                } catch (NumberFormatException unused) {
                }
            }
        }
        if ((i != 204 && i != 205) || j <= 0) {
            return ResponseBody.create(str != null ? MediaType.parse(str) : null, j, Okio.buffer(source));
        }
        throw new ProtocolException("HTTP " + i + " had non-zero Content-Length: " + str2);
    }

    private static Object d(Future future) {
        try {
            return z.a(future);
        } catch (ExecutionException e) {
            throw new IOException(e);
        }
    }

    private static String e(String str, UrlResponseInfo urlResponseInfo) {
        List list = (List) urlResponseInfo.getAllHeaders().get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) g3.g(list);
    }

    private static Object f(Map map, Object obj, Object obj2) {
        Object obj3 = map.get(obj);
        return obj3 == null ? m.o(obj2) : obj3;
    }

    Response g(Request request, OkHttpBridgeRequestCallback okHttpBridgeRequestCallback) {
        UrlResponseInfo urlResponseInfo = (UrlResponseInfo) d(okHttpBridgeRequestCallback.g());
        Response.Builder b2 = b(request, urlResponseInfo, (Source) d(okHttpBridgeRequestCallback.f()));
        List h = okHttpBridgeRequestCallback.h();
        List urlChain = urlResponseInfo.getUrlChain();
        if (!h.isEmpty()) {
            m.e(urlChain.size() == h.size() + 1, "The number of redirects should be consistent across URLs and headers!");
            Response response = null;
            for (int i = 0; i < h.size(); i++) {
                response = b(request.newBuilder().url((String) urlChain.get(i)).build(), (UrlResponseInfo) h.get(i), null).priorResponse(response).build();
            }
            b2.request(request.newBuilder().url((String) g3.g(urlChain)).build()).priorResponse(response);
        }
        return b2.build();
    }
}
