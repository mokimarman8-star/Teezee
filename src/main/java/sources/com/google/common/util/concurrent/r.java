package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public interface r extends Future {
    void addListener(Runnable runnable, Executor executor);
}
