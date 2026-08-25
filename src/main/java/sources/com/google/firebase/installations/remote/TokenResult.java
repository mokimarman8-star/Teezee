package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.b;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class TokenResult {

    public enum ResponseCode {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    public static a a() {
        return new b.b().d(0L);
    }

    public abstract ResponseCode b();

    public abstract String c();

    public abstract long d();
}
