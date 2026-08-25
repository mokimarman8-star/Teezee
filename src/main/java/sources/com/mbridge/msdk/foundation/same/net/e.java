package com.mbridge.msdk.foundation.same.net;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class e<T> {
    public com.mbridge.msdk.foundation.same.net.exception.a a = null;
    public com.mbridge.msdk.foundation.same.net.toolbox.a b;
    public T c;

    private e(T t, com.mbridge.msdk.foundation.same.net.toolbox.a aVar) {
        this.c = t;
        this.b = aVar;
    }

    public static <T> e<T> a(T t, com.mbridge.msdk.foundation.same.net.toolbox.a aVar) {
        return new e<>(t, aVar);
    }
}
