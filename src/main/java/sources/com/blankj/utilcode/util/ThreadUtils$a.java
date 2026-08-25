package com.blankj.utilcode.util;

import java.util.concurrent.Executor;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class ThreadUtils$a implements Executor {
    ThreadUtils$a() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        ThreadUtils.j(runnable);
    }
}
