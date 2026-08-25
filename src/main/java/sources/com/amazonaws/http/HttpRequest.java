package com.amazonaws.http;

import com.amazonaws.util.StringUtils;
import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class HttpRequest {
    private final String a;
    private URI b;
    private final Map c;
    private final InputStream d;
    private boolean e;

    public HttpRequest(String str, URI uri, Map map, InputStream inputStream) {
        this.a = StringUtils.c(str);
        this.b = uri;
        this.c = map == null ? Collections.EMPTY_MAP : Collections.unmodifiableMap(map);
        this.d = inputStream;
    }

    public InputStream a() {
        return this.d;
    }

    public long b() {
        String str;
        Map map = this.c;
        if (map == null || (str = (String) map.get("Content-Length")) == null || str.isEmpty()) {
            return 0L;
        }
        return Long.valueOf(str).longValue();
    }

    public Map c() {
        return this.c;
    }

    public String d() {
        return this.a;
    }

    public URI e() {
        return this.b;
    }

    public boolean f() {
        return this.e;
    }

    public void g(boolean z) {
        this.e = z;
    }
}
