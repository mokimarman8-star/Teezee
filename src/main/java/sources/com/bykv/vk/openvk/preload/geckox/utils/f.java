package com.bykv.vk.openvk.preload.geckox.utils;

import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class f implements Executor {
    private static volatile f a;

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                try {
                    if (a == null) {
                        a = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        com.bykv.vk.openvk.preload.geckox.b.t().execute(runnable);
    }
}
