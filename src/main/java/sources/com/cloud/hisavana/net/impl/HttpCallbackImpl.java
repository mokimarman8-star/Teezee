package com.cloud.hisavana.net.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.cloud.sdk.commonutil.util.c;
import java.io.IOException;
import okhttp3.Headers;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class HttpCallbackImpl implements IHttpCallback {
    private Handler a;
    private Looper b;

    public HttpCallbackImpl() {
        this(true);
    }

    private HttpCallbackImpl(Looper looper) {
        this.a = null;
        this.b = null;
        if (looper != null) {
            this.b = looper;
            this.a = new ResponderHandler(this, looper);
        }
    }

    public HttpCallbackImpl(boolean z) {
        this(z ? Looper.myLooper() : null);
    }

    @Override // com.cloud.hisavana.net.impl.IHttpCallback
    public void a() {
        s(h(2, null));
    }

    @Override // com.cloud.hisavana.net.impl.IHttpCallback
    public void b() {
        s(h(3, null));
    }

    @Override // com.cloud.hisavana.net.impl.IHttpCallback
    public void c(int i, byte[] bArr) {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (i >= 300) {
            d(i, bArr, new IOException());
        } else {
            t(i, bArr);
        }
    }

    @Override // com.cloud.hisavana.net.impl.IHttpCallback
    public void d(int i, byte[] bArr, Throwable th) {
        s(h(1, new Object[]{Integer.valueOf(i), bArr, th}));
    }

    @Override // com.cloud.hisavana.net.impl.IHttpCallback
    public void e(int i, byte[] bArr, String str) {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (i >= 300) {
            d(i, bArr, new IOException());
        } else {
            u(i, bArr, str);
        }
    }

    @Override // com.cloud.hisavana.net.impl.IHttpCallback
    public void f(int i, byte[] bArr, Headers headers) {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (i >= 300) {
            r(i, bArr, new IOException(), headers);
        } else {
            v(i, bArr, headers);
        }
    }

    protected void g(Message message) {
        try {
            int i = message.what;
            if (i == 0) {
                Object[] objArr = (Object[]) message.obj;
                if (objArr == null || objArr.length < 2) {
                    c.Log().e("HttpCallbackImpl", "SUCCESS_MESSAGE didn't got enough params");
                    return;
                }
                if (objArr.length < 3) {
                    n(((Integer) objArr[0]).intValue(), (byte[]) objArr[1]);
                    return;
                }
                Object obj = objArr[2];
                if (obj instanceof String) {
                    o(((Integer) objArr[0]).intValue(), (byte[]) objArr[1], (String) objArr[2]);
                    return;
                } else {
                    if (obj instanceof Headers) {
                        l((Headers) obj);
                        n(((Integer) objArr[0]).intValue(), (byte[]) objArr[1]);
                        return;
                    }
                    return;
                }
            }
            if (i != 1) {
                if (i == 2) {
                    m();
                    return;
                }
                if (i == 3) {
                    j();
                    return;
                } else if (i != 7) {
                    c.Log().e("HttpCallbackImpl", "UnKnown message");
                    return;
                } else {
                    k();
                    return;
                }
            }
            Object[] objArr2 = (Object[]) message.obj;
            if (objArr2 == null || objArr2.length < 3) {
                c.Log().e("HttpCallbackImpl", "FAILURE_MESSAGE didn't got enough params");
                return;
            }
            if (objArr2.length >= 4) {
                Object obj2 = objArr2[3];
                if (obj2 instanceof Headers) {
                    l((Headers) obj2);
                }
            }
            i(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1], (Throwable) objArr2[2]);
        } catch (Throwable th) {
            p(th);
        }
    }

    protected Message h(int i, Object obj) {
        return Message.obtain(this.a, i, obj);
    }

    public abstract void i(int i, byte[] bArr, Throwable th);

    public void j() {
    }

    public void k() {
        c.Log().d("HttpCallbackImpl", "Request got onPaused");
    }

    public void l(Headers headers) {
    }

    public void m() {
    }

    public abstract void n(int i, byte[] bArr);

    public void o(int i, byte[] bArr, String str) {
    }

    public void p(Throwable th) {
        c.Log().e("HttpCallbackImpl", "User-space exception detected!", th);
        throw new RuntimeException(th);
    }

    protected void q(Runnable runnable) {
        if (runnable != null) {
            Handler handler = this.a;
            if (handler == null) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }
    }

    public void r(int i, byte[] bArr, Throwable th, Headers headers) {
        s(h(1, new Object[]{Integer.valueOf(i), bArr, th, headers}));
    }

    protected void s(Message message) {
        Handler handler;
        if (this.a == null) {
            g(message);
        } else {
            if (Thread.currentThread().isInterrupted() || (handler = this.a) == null) {
                return;
            }
            handler.sendMessage(message);
        }
    }

    public void t(int i, byte[] bArr) {
        s(h(0, new Object[]{Integer.valueOf(i), bArr}));
    }

    public void u(int i, byte[] bArr, String str) {
        s(h(0, new Object[]{Integer.valueOf(i), bArr, str}));
    }

    public void v(int i, byte[] bArr, Headers headers) {
        s(h(0, new Object[]{Integer.valueOf(i), bArr, headers}));
    }
}
