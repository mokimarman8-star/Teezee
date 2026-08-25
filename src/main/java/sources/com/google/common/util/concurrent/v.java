package com.google.common.util.concurrent;

import java.util.concurrent.locks.LockSupport;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class v {
    static void a(Object obj, long j) {
        LockSupport.parkNanos(obj, Math.min(j, 2147483647999999999L));
    }
}
