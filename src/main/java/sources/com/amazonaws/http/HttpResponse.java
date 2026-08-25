package com.amazonaws.http;

import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class HttpResponse {
    private final String a;
    private final int b;
    private final InputStream c;
    private final Map d;
    private InputStream e;

    public static class Builder {
        private String a;
        private int b;
        private InputStream c;
        private final Map d = new HashMap();

        public HttpResponse a() {
            return new HttpResponse(this.a, this.b, Collections.unmodifiableMap(this.d), this.c);
        }

        public Builder b(InputStream inputStream) {
            this.c = inputStream;
            return this;
        }

        public Builder c(String str, String str2) {
            this.d.put(str, str2);
            return this;
        }

        public Builder d(int i) {
            this.b = i;
            return this;
        }

        public Builder e(String str) {
            this.a = str;
            return this;
        }
    }

    private HttpResponse(String str, int i, Map map, InputStream inputStream) {
        this.a = str;
        this.b = i;
        this.d = map;
        this.c = inputStream;
    }

    public static Builder a() {
        return new Builder();
    }

    public InputStream b() {
        if (this.e == null) {
            synchronized (this) {
                try {
                    if (this.c == null || !"gzip".equals(this.d.get("Content-Encoding"))) {
                        this.e = this.c;
                    } else {
                        this.e = new GZIPInputStream(this.c);
                    }
                } finally {
                }
            }
        }
        return this.e;
    }

    public Map c() {
        return this.d;
    }

    public InputStream d() {
        return this.c;
    }

    public int e() {
        return this.b;
    }

    public String f() {
        return this.a;
    }
}
