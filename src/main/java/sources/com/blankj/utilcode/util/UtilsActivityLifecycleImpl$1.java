package com.blankj.utilcode.util;

import android.app.Activity;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class UtilsActivityLifecycleImpl$1 implements Runnable {
    final /* synthetic */ UtilsActivityLifecycleImpl this$0;
    final /* synthetic */ Activity val$activity;
    final /* synthetic */ Utils$a val$listener;

    UtilsActivityLifecycleImpl$1(UtilsActivityLifecycleImpl utilsActivityLifecycleImpl, Activity activity, Utils$a utils$a) {
        this.this$0 = utilsActivityLifecycleImpl;
        this.val$activity = activity;
        this.val$listener = utils$a;
    }

    @Override // java.lang.Runnable
    public void run() {
        UtilsActivityLifecycleImpl.a(this.this$0, this.val$activity, this.val$listener);
    }
}
