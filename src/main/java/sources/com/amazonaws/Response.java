package com.amazonaws;

import com.amazonaws.http.HttpResponse;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class Response<T> {
    private final Object a;
    private final HttpResponse b;

    public Response(Object obj, HttpResponse httpResponse) {
        this.a = obj;
        this.b = httpResponse;
    }

    public Object a() {
        return this.a;
    }
}
