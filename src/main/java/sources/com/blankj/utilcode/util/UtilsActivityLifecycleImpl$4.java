package com.blankj.utilcode.util;

import android.app.Activity;
import android.view.Window;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class UtilsActivityLifecycleImpl$4 implements Runnable {
    final /* synthetic */ UtilsActivityLifecycleImpl this$0;
    final /* synthetic */ Activity val$activity;
    final /* synthetic */ Object val$tag;

    UtilsActivityLifecycleImpl$4(UtilsActivityLifecycleImpl utilsActivityLifecycleImpl, Activity activity, Object obj) {
        this.this$0 = utilsActivityLifecycleImpl;
        this.val$activity = activity;
        this.val$tag = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Window window = this.val$activity.getWindow();
            if (window != null) {
                window.setSoftInputMode(((Integer) this.val$tag).intValue());
            }
        } catch (Exception unused) {
        }
    }
}
