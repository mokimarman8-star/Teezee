package com.cloud.hisavana.protocol.okhttptransport;

import com.google.common.base.m;
import com.google.common.util.concurrent.r;
import com.google.common.util.concurrent.y;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okio.Buffer;
import okio.Source;
import okio.Timeout;
import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class OkHttpBridgeRequestCallback extends UrlRequest.Callback {
    private final long f;
    private final com.cloud.hisavana.protocol.okhttptransport.c h;
    private volatile UrlRequest i;
    private final y a = y.s();
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicBoolean c = new AtomicBoolean(false);
    private final BlockingQueue d = new ArrayBlockingQueue(2);
    private final y e = y.s();
    private final List g = new ArrayList();

    private enum CallbackStep {
        ON_READ_COMPLETED,
        ON_SUCCESS,
        ON_FAILED,
        ON_CANCELED
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[CallbackStep.values().length];
            a = iArr;
            try {
                iArr[CallbackStep.ON_FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[CallbackStep.ON_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[CallbackStep.ON_CANCELED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[CallbackStep.ON_READ_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private static class b {
        private final CallbackStep a;
        private final ByteBuffer b;
        private final CronetException c;

        private b(CallbackStep callbackStep, ByteBuffer byteBuffer, CronetException cronetException) {
            this.a = callbackStep;
            this.b = byteBuffer;
            this.c = cronetException;
        }

        /* synthetic */ b(CallbackStep callbackStep, ByteBuffer byteBuffer, CronetException cronetException, a aVar) {
            this(callbackStep, byteBuffer, cronetException);
        }
    }

    private class c implements Source {
        private ByteBuffer a;
        private volatile boolean b;

        private c() {
            this.a = ByteBuffer.allocateDirect(32768);
            this.b = false;
        }

        /* synthetic */ c(OkHttpBridgeRequestCallback okHttpBridgeRequestCallback, a aVar) {
            this();
        }

        public void close() {
            if (this.b) {
                return;
            }
            this.b = true;
            if (OkHttpBridgeRequestCallback.this.b.get()) {
                return;
            }
            OkHttpBridgeRequestCallback.this.i.cancel();
        }

        public long read(Buffer buffer, long j) {
            b bVar;
            if (OkHttpBridgeRequestCallback.this.c.get()) {
                throw new IOException("The request was canceled!");
            }
            m.e(buffer != null, "sink == null");
            m.h(j >= 0, "byteCount < 0: %s", j);
            m.v(!this.b, "closed");
            if (OkHttpBridgeRequestCallback.this.b.get()) {
                return -1L;
            }
            if (j < this.a.limit()) {
                this.a.limit((int) j);
            }
            OkHttpBridgeRequestCallback.this.i.read(this.a);
            try {
                bVar = (b) OkHttpBridgeRequestCallback.this.d.poll(OkHttpBridgeRequestCallback.this.f, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                bVar = null;
            }
            if (bVar == null) {
                OkHttpBridgeRequestCallback.this.i.cancel();
                throw new CronetTimeoutException();
            }
            int i = a.a[bVar.a.ordinal()];
            if (i == 1) {
                OkHttpBridgeRequestCallback.this.b.set(true);
                this.a = null;
                throw new IOException((Throwable) bVar.c);
            }
            if (i == 2) {
                OkHttpBridgeRequestCallback.this.b.set(true);
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
            bVar.b.flip();
            int write = buffer.write(bVar.b);
            bVar.b.clear();
            return write;
        }

        public Timeout timeout() {
            return Timeout.NONE;
        }
    }

    OkHttpBridgeRequestCallback(long j, com.cloud.hisavana.protocol.okhttptransport.c cVar) {
        m.d(j >= 0);
        if (j == 0) {
            this.f = 2147483647L;
        } else {
            this.f = j;
        }
        this.h = cVar;
    }

    r f() {
        return this.a;
    }

    r g() {
        return this.e;
    }

    List h() {
        return Collections.unmodifiableList(this.g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.c.set(true);
        this.d.add(new b(CallbackStep.ON_CANCELED, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0));
        IOException iOException = new IOException("The request was canceled!");
        this.e.setException(iOException);
        this.a.setException(iOException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        if (this.e.setException(cronetException) && this.a.setException(cronetException)) {
            return;
        }
        this.d.add(new b(CallbackStep.ON_FAILED, null, cronetException, 0 == true ? 1 : 0));
    }

    public void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) {
        CronetException cronetException = null;
        this.d.add(new b(CallbackStep.ON_READ_COMPLETED, byteBuffer, cronetException, cronetException));
    }

    public void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) {
        if (!this.h.b()) {
            m.u(this.e.set(urlResponseInfo));
            m.u(this.a.set(new Buffer()));
            urlRequest.cancel();
            return;
        }
        this.g.add(urlResponseInfo);
        if (urlResponseInfo.getUrlChain().size() <= this.h.c()) {
            urlRequest.followRedirect();
            return;
        }
        urlRequest.cancel();
        ProtocolException protocolException = new ProtocolException("Too many follow-up requests: " + (this.h.c() + 1));
        this.e.setException(protocolException);
        this.a.setException(protocolException);
    }

    public void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.i = urlRequest;
        m.u(this.e.set(urlResponseInfo));
        m.u(this.a.set(new c(this, null)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        this.d.add(new b(CallbackStep.ON_SUCCESS, null, 0 == true ? 1 : 0, 0 == true ? 1 : 0));
    }
}
