package com.google.net.cronet.okhttptransport;

import com.google.net.cronet.okhttptransport.OkHttpBridgeRequestCallback;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
/* synthetic */ class OkHttpBridgeRequestCallback$a {
    static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[OkHttpBridgeRequestCallback.CallbackStep.values().length];
        a = iArr;
        try {
            iArr[OkHttpBridgeRequestCallback.CallbackStep.ON_FAILED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[OkHttpBridgeRequestCallback.CallbackStep.ON_SUCCESS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[OkHttpBridgeRequestCallback.CallbackStep.ON_CANCELED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[OkHttpBridgeRequestCallback.CallbackStep.ON_READ_COMPLETED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
