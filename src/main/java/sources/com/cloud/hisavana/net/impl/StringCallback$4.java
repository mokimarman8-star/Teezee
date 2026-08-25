package com.cloud.hisavana.net.impl;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class StringCallback$4 implements Runnable {
    final /* synthetic */ StringCallback this$0;
    final /* synthetic */ Exception val$e;
    final /* synthetic */ int val$statusCode;

    StringCallback$4(StringCallback stringCallback, int i, Exception exc) {
        this.this$0 = stringCallback;
        this.val$statusCode = i;
        this.val$e = exc;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.this$0.x(this.val$statusCode, (String) null, this.val$e.getCause());
    }
}
