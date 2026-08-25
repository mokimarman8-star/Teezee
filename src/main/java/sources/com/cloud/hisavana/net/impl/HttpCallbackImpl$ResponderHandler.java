package com.cloud.hisavana.net.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class HttpCallbackImpl$ResponderHandler extends Handler {
    private final HttpCallbackImpl a;

    HttpCallbackImpl$ResponderHandler(HttpCallbackImpl httpCallbackImpl, Looper looper) {
        super(looper);
        this.a = httpCallbackImpl;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        this.a.g(message);
    }
}
