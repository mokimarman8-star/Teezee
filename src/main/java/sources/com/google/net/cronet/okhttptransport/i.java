package com.google.net.cronet.okhttptransport;

import com.google.common.base.m;
import com.google.common.base.o;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.g3;
import com.google.common.util.concurrent.z;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
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

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class i {
    private static final ImmutableSet a = ImmutableSet.of(TtmlNode.TAG_BR, "deflate", "gzip", "x-gzip");
    private static final o b = o.f(',').k().e();

    i() {
    }

    private static Protocol a(String str) {
        if (!str.contains("quic") && !str.contains("h3")) {
            if (!str.contains("spdy") && !str.contains("h2")) {
                return str.contains("http1.1") ? Protocol.HTTP_1_1 : Protocol.HTTP_1_0;
            }
            return Protocol.HTTP_2;
        }
        return Protocol.QUIC;
    }

    private static ResponseBody b(Request request, int i, String str, String str2, Source source) {
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

    private static Object c(Future future) {
        try {
            return z.a(future);
        } catch (ExecutionException e) {
            throw new IOException(e);
        }
    }

    private static String d(String str, UrlResponseInfo urlResponseInfo) {
        List list = (List) urlResponseInfo.getAllHeaders().get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) g3.g(list);
    }

    private static Object e(Map map, Object obj, Object obj2) {
        Object obj3 = map.get(obj);
        return obj3 == null ? m.o(obj2) : obj3;
    }

    Response f(Request request, OkHttpBridgeRequestCallback okHttpBridgeRequestCallback) {
        Response.Builder builder = new Response.Builder();
        UrlResponseInfo urlResponseInfo = (UrlResponseInfo) c(okHttpBridgeRequestCallback.g());
        String d = d("Content-Type", urlResponseInfo);
        ArrayList arrayList = new ArrayList();
        Iterator it = ((List) e(urlResponseInfo.getAllHeaders(), "Content-Encoding", Collections.emptyList())).iterator();
        while (it.hasNext()) {
            g3.a(arrayList, b.h((String) it.next()));
        }
        boolean z = arrayList.isEmpty() || !a.containsAll(arrayList);
        builder.request(request).code(urlResponseInfo.getHttpStatusCode()).message(urlResponseInfo.getHttpStatusText()).protocol(a(urlResponseInfo.getNegotiatedProtocol())).body(b(request, urlResponseInfo.getHttpStatusCode(), d, z ? d("Content-Length", urlResponseInfo) : null, (Source) c(okHttpBridgeRequestCallback.f())));
        for (Map.Entry entry : urlResponseInfo.getAllHeadersAsList()) {
            if (z || (!com.google.common.base.a.a((CharSequence) entry.getKey(), "Content-Length") && !com.google.common.base.a.a((CharSequence) entry.getKey(), "Content-Encoding"))) {
                builder.addHeader((String) entry.getKey(), (String) entry.getValue());
            }
        }
        return builder.build();
    }
}
