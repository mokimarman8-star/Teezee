package com.mbridge.msdk.thrid.okhttp.internal.http2;

import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class n extends IOException {
    public final b a;

    public n(b bVar) {
        super("stream was reset: " + bVar);
        this.a = bVar;
    }
}
