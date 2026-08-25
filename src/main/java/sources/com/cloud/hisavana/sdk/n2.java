package com.cloud.hisavana.sdk;

import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class n2 {
    private static final AtomicInteger a = new AtomicInteger();

    public static String a() {
        String valueOf = String.valueOf(a.incrementAndGet());
        String valueOf2 = String.valueOf((int) (((new SecureRandom().nextDouble() * 9.0d) + 1.0d) * 100000.0d));
        return valueOf + String.valueOf(System.currentTimeMillis()) + valueOf2;
    }
}
