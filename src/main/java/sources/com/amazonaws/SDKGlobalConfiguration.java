package com.amazonaws;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class SDKGlobalConfiguration {
    private static final AtomicInteger a = new AtomicInteger(0);

    public static int a() {
        return a.get();
    }

    public static void b(int i) {
        a.set(i);
    }
}
