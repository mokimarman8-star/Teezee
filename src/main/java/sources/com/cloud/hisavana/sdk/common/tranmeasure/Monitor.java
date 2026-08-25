package com.cloud.hisavana.sdk.common.tranmeasure;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class Monitor {

    private static class a {
        private static final Monitor a = new b();
    }

    public static Monitor getInstance() {
        return a.a;
    }

    public abstract void end();

    public abstract void start();
}
