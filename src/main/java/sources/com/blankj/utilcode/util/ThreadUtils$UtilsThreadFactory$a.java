package com.blankj.utilcode.util;

import com.blankj.utilcode.util.ThreadUtils;
import java.lang.Thread;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class ThreadUtils$UtilsThreadFactory$a implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ ThreadUtils.UtilsThreadFactory a;

    ThreadUtils$UtilsThreadFactory$a(ThreadUtils.UtilsThreadFactory utilsThreadFactory) {
        this.a = utilsThreadFactory;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        System.out.println(th);
    }
}
