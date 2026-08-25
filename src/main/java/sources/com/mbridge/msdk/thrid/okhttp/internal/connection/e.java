package com.mbridge.msdk.thrid.okhttp.internal.connection;

import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class e extends RuntimeException {
    private IOException a;
    private IOException b;

    public e(IOException iOException) {
        super(iOException);
        this.a = iOException;
        this.b = iOException;
    }

    public IOException a() {
        return this.a;
    }

    public void a(IOException iOException) {
        com.mbridge.msdk.thrid.okhttp.internal.c.a((Throwable) this.a, (Throwable) iOException);
        this.b = iOException;
    }

    public IOException b() {
        return this.b;
    }
}
