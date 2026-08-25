package com.google.net.cronet.okhttptransport;

import com.google.net.cronet.okhttptransport.OkHttpBridgeRequestCallback;
import java.nio.ByteBuffer;
import org.chromium.net.CronetException;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class OkHttpBridgeRequestCallback$b {
    private final OkHttpBridgeRequestCallback.CallbackStep a;
    private final ByteBuffer b;
    private final CronetException c;

    private OkHttpBridgeRequestCallback$b(OkHttpBridgeRequestCallback.CallbackStep callbackStep, ByteBuffer byteBuffer, CronetException cronetException) {
        this.a = callbackStep;
        this.b = byteBuffer;
        this.c = cronetException;
    }
}
