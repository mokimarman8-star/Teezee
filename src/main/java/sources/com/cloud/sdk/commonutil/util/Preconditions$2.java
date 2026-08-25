package com.cloud.sdk.commonutil.util;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class Preconditions$2 implements Runnable {
    final /* synthetic */ Preconditions$a val$callback;

    Preconditions$2(Preconditions$a preconditions$a) {
        this.val$callback = preconditions$a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.val$callback.onRun();
    }
}
