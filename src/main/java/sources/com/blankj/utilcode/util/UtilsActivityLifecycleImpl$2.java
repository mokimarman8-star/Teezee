package com.blankj.utilcode.util;

import android.app.Activity;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class UtilsActivityLifecycleImpl$2 implements Runnable {
    final /* synthetic */ UtilsActivityLifecycleImpl this$0;
    final /* synthetic */ Activity val$activity;

    UtilsActivityLifecycleImpl$2(UtilsActivityLifecycleImpl utilsActivityLifecycleImpl, Activity activity) {
        this.this$0 = utilsActivityLifecycleImpl;
        this.val$activity = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        UtilsActivityLifecycleImpl.b(this.this$0).remove(this.val$activity);
    }
}
