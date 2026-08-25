package com.google.net.cronet.okhttptransport;

import com.google.common.base.m;
import com.google.net.cronet.okhttptransport.OkHttpBridgeRequestCallback;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.Source;
import okio.Timeout;
import org.chromium.net.CronetException;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class OkHttpBridgeRequestCallback$c implements Source {
    private ByteBuffer a;
    private volatile boolean b;
    final /* synthetic */ OkHttpBridgeRequestCallback c;

    private OkHttpBridgeRequestCallback$c(OkHttpBridgeRequestCallback okHttpBridgeRequestCallback) {
        this.c = okHttpBridgeRequestCallback;
        this.a = ByteBuffer.allocateDirect(32768);
        this.b = false;
    }

    /* synthetic */ OkHttpBridgeRequestCallback$c(OkHttpBridgeRequestCallback okHttpBridgeRequestCallback, OkHttpBridgeRequestCallback$a okHttpBridgeRequestCallback$a) {
        this(okHttpBridgeRequestCallback);
    }

    public void close() {
        if (this.b) {
            return;
        }
        this.b = true;
        if (OkHttpBridgeRequestCallback.b(this.c).get()) {
            return;
        }
        OkHttpBridgeRequestCallback.c(this.c).cancel();
    }

    public long read(Buffer buffer, long j) {
        OkHttpBridgeRequestCallback$b okHttpBridgeRequestCallback$b;
        OkHttpBridgeRequestCallback.CallbackStep callbackStep;
        CronetException cronetException;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        ByteBuffer byteBuffer3;
        if (OkHttpBridgeRequestCallback.a(this.c).get()) {
            throw new IOException("The request was canceled!");
        }
        m.e(buffer != null, "sink == null");
        m.h(j >= 0, "byteCount < 0: %s", j);
        m.v(!this.b, "closed");
        if (OkHttpBridgeRequestCallback.b(this.c).get()) {
            return -1L;
        }
        if (j < this.a.limit()) {
            this.a.limit((int) j);
        }
        OkHttpBridgeRequestCallback.c(this.c).read(this.a);
        try {
            okHttpBridgeRequestCallback$b = (OkHttpBridgeRequestCallback$b) OkHttpBridgeRequestCallback.e(this.c).poll(OkHttpBridgeRequestCallback.d(this.c), TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            okHttpBridgeRequestCallback$b = null;
        }
        if (okHttpBridgeRequestCallback$b == null) {
            OkHttpBridgeRequestCallback.c(this.c).cancel();
            throw new CronetTimeoutException();
        }
        int[] iArr = OkHttpBridgeRequestCallback$a.a;
        callbackStep = okHttpBridgeRequestCallback$b.a;
        int i = iArr[callbackStep.ordinal()];
        if (i == 1) {
            OkHttpBridgeRequestCallback.b(this.c).set(true);
            this.a = null;
            cronetException = okHttpBridgeRequestCallback$b.c;
            throw new IOException((Throwable) cronetException);
        }
        if (i == 2) {
            OkHttpBridgeRequestCallback.b(this.c).set(true);
            this.a = null;
            return -1L;
        }
        if (i == 3) {
            this.a = null;
            throw new IOException("The request was canceled!");
        }
        if (i != 4) {
            throw new AssertionError("The switch block above is exhaustive!");
        }
        byteBuffer = okHttpBridgeRequestCallback$b.b;
        byteBuffer.flip();
        byteBuffer2 = okHttpBridgeRequestCallback$b.b;
        int write = buffer.write(byteBuffer2);
        byteBuffer3 = okHttpBridgeRequestCallback$b.b;
        byteBuffer3.clear();
        return write;
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }
}
