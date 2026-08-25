package com.blankj.utilcode.util;

import android.app.Activity;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class UtilsActivityLifecycleImpl$3 implements Runnable {
    final /* synthetic */ UtilsActivityLifecycleImpl this$0;
    final /* synthetic */ Activity val$activity;
    final /* synthetic */ Utils$a val$callbacks;

    UtilsActivityLifecycleImpl$3(UtilsActivityLifecycleImpl utilsActivityLifecycleImpl, Activity activity, Utils$a utils$a) {
        this.this$0 = utilsActivityLifecycleImpl;
        this.val$activity = activity;
        this.val$callbacks = utils$a;
    }

    @Override // java.lang.Runnable
    public void run() {
        UtilsActivityLifecycleImpl.c(this.this$0, this.val$activity, this.val$callbacks);
    }
}
