package com.transsion.api.gateway.interceptor;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class GatewayInterceptor$1 extends RequestBody {
    public final /* synthetic */ GatewayInterceptor this$0;
    public final /* synthetic */ RequestBody val$body;

    public GatewayInterceptor$1(GatewayInterceptor gatewayInterceptor, RequestBody requestBody) {
        this.this$0 = gatewayInterceptor;
        this.val$body = requestBody;
    }

    public MediaType contentType() {
        return this.val$body.contentType();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
        this.val$body.writeTo(buffer);
        buffer.close();
    }
}
