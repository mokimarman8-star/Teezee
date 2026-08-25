package com.google.net.cronet.okhttptransport;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class b extends ResponseBody {
    private final ResponseBody a;

    protected b(ResponseBody responseBody) {
        this.a = responseBody;
    }

    public final void close() {
        this.a.close();
        d();
    }

    public final long contentLength() {
        return this.a.contentLength();
    }

    public final MediaType contentType() {
        return this.a.contentType();
    }

    abstract void d();

    public final BufferedSource source() {
        return this.a.source();
    }
}
