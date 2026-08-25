package com.cloud.hisavana.net;

import android.util.Log;
import com.cloud.hisavana.net.impl.IHttpCallback;
import com.cloud.sdk.commonutil.util.c;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.chromium.net.NetworkException;
import org.chromium.net.QuicException;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class CommonOkHttpClient$3 implements Callback {
    final /* synthetic */ IHttpCallback a;
    final /* synthetic */ RequestParams b;
    final /* synthetic */ Request c;

    CommonOkHttpClient$3(IHttpCallback iHttpCallback, RequestParams requestParams, Request request) {
        this.a = iHttpCallback;
        this.b = requestParams;
        this.c = request;
    }

    public void onFailure(Call call, IOException iOException) {
        try {
            IHttpCallback iHttpCallback = this.a;
            if (iHttpCallback == null) {
                return;
            }
            if (iOException instanceof SocketTimeoutException) {
                iHttpCallback.d(481, (byte[]) null, iOException);
            } else if (iOException instanceof UnknownHostException) {
                iHttpCallback.d(484, (byte[]) null, iOException);
            } else if (iOException instanceof NoRouteToHostException) {
                iHttpCallback.d(485, (byte[]) null, iOException);
            } else if (iOException instanceof ProtocolException) {
                iHttpCallback.d(486, (byte[]) null, iOException);
            } else if (iOException instanceof ConnectException) {
                iHttpCallback.d(483, (byte[]) null, iOException);
            } else if (iOException instanceof QuicException) {
                iHttpCallback.d(487, (byte[]) null, iOException);
            } else if (iOException instanceof NetworkException) {
                this.a.d(CommonOkHttpClient.c(((NetworkException) iOException).getErrorCode()), (byte[]) null, iOException);
            } else {
                iHttpCallback.d(480, (byte[]) null, iOException);
            }
        } catch (Throwable th) {
            IHttpCallback iHttpCallback2 = this.a;
            if (iHttpCallback2 != null) {
                iHttpCallback2.d(480, (byte[]) null, iOException);
            }
            CommonOkHttpClient.d(th);
        }
    }

    public void onResponse(Call call, Response response) {
        try {
        } catch (Exception e) {
            IHttpCallback iHttpCallback = this.a;
            if (iHttpCallback != null && response != null) {
                iHttpCallback.d(response.code(), (byte[]) null, e);
            }
        }
        if (this.a == null) {
            return;
        }
        if (response == null || !response.isSuccessful()) {
            this.a.d(1027, (byte[]) null, CommonOkHttpClient.e());
        } else {
            byte[] bytes = this.b.f() ? new byte[0] : response.body().bytes();
            if (!this.b.g()) {
                this.a.f(response.code(), bytes, response.headers());
            }
            String f = CommonOkHttpClient.f(this.b, this.c.url().toString(), response, bytes);
            if (Log.isLoggable("ADSDK", 3)) {
                c.netLog("real download on response, code = " + response.code() + ", adId = " + this.b.a() + ", \nurl = " + this.c.url() + " , \nfilePath = " + f);
            }
            if (this.b.g()) {
                if (CommonOkHttpClient.g(f)) {
                    this.a.e(response.code(), bytes, f);
                } else {
                    this.a.d(1026, (byte[]) null, new Exception("fail to cache file to disk"));
                }
            }
        }
        IHttpCallback iHttpCallback2 = this.a;
        if (iHttpCallback2 != null) {
            iHttpCallback2.b();
        }
    }
}
