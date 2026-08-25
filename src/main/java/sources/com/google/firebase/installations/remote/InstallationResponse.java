package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.a;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class InstallationResponse {

    public enum ResponseCode {
        OK,
        BAD_CONFIG
    }

    public static a a() {
        return new a.b();
    }

    public abstract TokenResult b();

    public abstract String c();

    public abstract String d();

    public abstract ResponseCode e();

    public abstract String f();
}
