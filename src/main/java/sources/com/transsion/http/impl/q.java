package com.transsion.http.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class q implements r {
    private Handler a;
    private boolean b;
    private boolean c;
    private Looper d;

    private static class a extends Handler {
        private final q a;

        a(q qVar, Looper looper) {
            super(looper);
            this.a = qVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.a.g(message);
        }
    }

    public q() {
        this(null);
    }

    public q(Looper looper) {
        this(looper == null ? Looper.myLooper() : looper, false);
    }

    private q(Looper looper, boolean z) {
        this.d = null;
        if (z) {
            kl.b.a(looper == null, "use pool thread, looper should be null!");
            this.d = null;
            this.a = null;
        } else {
            kl.b.a(looper != null, "use looper thread, must call Looper.prepare() first!");
            this.d = looper;
            this.a = new a(this, looper);
        }
        this.c = z;
    }

    @Override // com.transsion.http.impl.r
    public void a() {
        i(f(2, null));
    }

    @Override // com.transsion.http.impl.r
    public void b() {
        i(f(3, null));
    }

    @Override // com.transsion.http.impl.r
    public void c(int i, byte[] bArr) {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (i >= 300) {
            d(i, bArr, new IOException());
        } else {
            v(i, bArr);
        }
    }

    @Override // com.transsion.http.impl.r
    public void d(int i, byte[] bArr, Throwable th2) {
        i(f(1, new Object[]{Integer.valueOf(i), bArr, th2}));
    }

    @Override // com.transsion.http.impl.r
    public final void e() {
        i(f(6, null));
    }

    protected Message f(int i, Object obj) {
        return Message.obtain(this.a, i, obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void g(Message message) {
        try {
            switch (message.what) {
                case 0:
                    Object[] objArr = (Object[]) message.obj;
                    if (objArr == null || objArr.length < 2) {
                        jl.a.a.e("HttpCallbackImpl", "SUCCESS_MESSAGE didn't got enough params");
                    } else {
                        s(((Integer) objArr[0]).intValue(), (byte[]) objArr[1]);
                    }
                    break;
                case 1:
                    Object[] objArr2 = (Object[]) message.obj;
                    if (objArr2 == null || objArr2.length < 3) {
                        jl.a.a.e("HttpCallbackImpl", "FAILURE_MESSAGE didn't got enough params");
                    } else {
                        m(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1], (Throwable) objArr2[2]);
                    }
                    break;
                case 2:
                    r();
                    break;
                case 3:
                    n();
                    break;
                case 4:
                    Object[] objArr3 = (Object[]) message.obj;
                    if (objArr3 == null || objArr3.length < 2) {
                        jl.a.a.e("HttpCallbackImpl", "PROGRESS_MESSAGE didn't got enough params");
                    } else {
                        try {
                            p(((Long) objArr3[0]).longValue(), ((Long) objArr3[1]).longValue());
                        } catch (Throwable th2) {
                            jl.a.a.e("HttpCallbackImpl", "custom onProgress contains an error", th2);
                        }
                    }
                    break;
                case 5:
                    Object[] objArr4 = (Object[]) message.obj;
                    if (objArr4 == null || objArr4.length != 1) {
                        jl.a.a.e("HttpCallbackImpl", "RETRY_MESSAGE didn't get enough params");
                    } else {
                        q(((Integer) objArr4[0]).intValue());
                    }
                    break;
                case 6:
                    l();
                    break;
                case 7:
                    o();
                    break;
            }
        } catch (Throwable th3) {
            t(th3);
        }
    }

    protected void h(Runnable runnable) {
        Handler handler;
        if (runnable != null) {
            if (k() || (handler = this.a) == null) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }
    }

    protected void i(Message message) {
        if (k() || this.a == null) {
            g(message);
        } else {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            kl.b.a(this.a != null, "handler should not be null!");
            this.a.sendMessage(message);
        }
    }

    public boolean j() {
        return this.c;
    }

    public boolean k() {
        return this.b;
    }

    public void l() {
        jl.a.a.d("HttpCallbackImpl", "Request got cancelled");
    }

    public abstract void m(int i, byte[] bArr, Throwable th2);

    public void n() {
    }

    public void o() {
        jl.a.a.d("HttpCallbackImpl", "Request got onPaused");
    }

    public void p(long j, long j2) {
        jl.a.a.v("HttpCallbackImpl", String.format("Progress %d from %d (%2.0f%%)", Long.valueOf(j), Long.valueOf(j2), Double.valueOf(j2 > 0 ? ((j * 1.0d) / j2) * 100.0d : -1.0d)));
    }

    public void q(int i) {
        jl.a.a.d("HttpCallbackImpl", String.format("Request retry no. %d", Integer.valueOf(i)));
    }

    public void r() {
    }

    public abstract void s(int i, byte[] bArr);

    public void t(Throwable th2) {
        jl.a.a.e("HttpCallbackImpl", "User-space exception detected!", th2);
        throw new RuntimeException(th2);
    }

    public void u() {
        i(f(7, null));
    }

    public void v(int i, byte[] bArr) {
        i(f(0, new Object[]{Integer.valueOf(i), bArr}));
    }
}
