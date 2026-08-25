package com.google.net.cronet.okhttptransport;

import com.google.common.base.m;
import com.google.common.util.concurrent.r;
import com.google.common.util.concurrent.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.Buffer;
import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
class OkHttpBridgeRequestCallback extends UrlRequest.Callback {
    private final y a = y.s();
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final BlockingQueue d = new ArrayBlockingQueue(2);
    private final y e = y.s();
    private final long f;
    private final c g;
    private volatile UrlRequest h;

    private enum CallbackStep {
        ON_READ_COMPLETED,
        ON_SUCCESS,
        ON_FAILED,
        ON_CANCELED
    }

    OkHttpBridgeRequestCallback(long j, c cVar) {
        m.d(j >= 0);
        if (j == 0) {
            this.f = 2147483647L;
        } else {
            this.f = j;
        }
        this.g = cVar;
    }

    r f() {
        return this.a;
    }

    r g() {
        return this.e;
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.c.set(true);
        this.d.add(new b(CallbackStep.ON_CANCELED, (ByteBuffer) null, (CronetException) null, (a) null));
        IOException iOException = new IOException("The request was canceled!");
        this.e.setException(iOException);
        this.a.setException(iOException);
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        if (this.e.setException(cronetException) && this.a.setException(cronetException)) {
            return;
        }
        this.d.add(new b(CallbackStep.ON_FAILED, (ByteBuffer) null, cronetException, (a) null));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
        this.d.add(new b(CallbackStep.ON_READ_COMPLETED, byteBuffer, (CronetException) null, (a) null));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
        if (!this.g.b()) {
            m.u(this.e.set(urlResponseInfo));
            m.u(this.a.set(new Buffer()));
            urlRequest.cancel();
        } else {
            if (urlResponseInfo.getUrlChain().size() <= this.g.c()) {
                urlRequest.followRedirect();
                return;
            }
            urlRequest.cancel();
            ProtocolException protocolException = new ProtocolException("Too many follow-up requests: " + (this.g.c() + 1));
            this.e.setException(protocolException);
            this.a.setException(protocolException);
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.h = urlRequest;
        m.u(this.e.set(urlResponseInfo));
        m.u(this.a.set(new c(this, (a) null)));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.d.add(new b(CallbackStep.ON_SUCCESS, (ByteBuffer) null, (CronetException) null, (a) null));
    }
}
