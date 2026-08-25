package com.cloud.hisavana.sdk.common.http.listener;

import android.os.Handler;
import android.os.Looper;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class ResponseBaseListener {
    protected Handler a;

    public ResponseBaseListener() {
        this(true);
    }

    private ResponseBaseListener(Looper looper) {
        this.a = null;
        if (looper != null) {
            this.a = new a(looper);
        } else {
            this.a = null;
        }
    }

    protected ResponseBaseListener(boolean z) {
        this(z ? Looper.myLooper() : null);
    }

    public abstract void a(TaErrorCode taErrorCode);

    public void b(int i) {
    }

    public void c(int i, String str, Throwable th) {
        e(new TaErrorCode(i, "erro msg = " + str));
    }

    public void d(int i, byte[] bArr, Throwable th) {
        e(new TaErrorCode(i, "erro msg = " + bArr));
    }

    public void e(final TaErrorCode taErrorCode) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener.1
                @Override // java.lang.Runnable
                public void run() {
                    ResponseBaseListener.this.a(taErrorCode);
                }
            });
        } else {
            a(taErrorCode);
        }
    }

    public void f(final int i) {
        Handler handler = this.a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener.2
                @Override // java.lang.Runnable
                public void run() {
                    ResponseBaseListener.this.b(i);
                }
            });
        } else {
            b(i);
        }
    }
}
