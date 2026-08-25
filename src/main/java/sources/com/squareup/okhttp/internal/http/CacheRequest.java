package com.squareup.okhttp.internal.http;

import java.io.IOException;
import okio.Sink;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface CacheRequest {
    void abort();

    Sink body() throws IOException;
}
