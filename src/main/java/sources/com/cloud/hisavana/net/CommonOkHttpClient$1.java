package com.cloud.hisavana.net;

import com.cloud.hisavana.net.impl.IHttpCallback;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.chromium.net.NetworkException;
import org.chromium.net.QuicException;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class CommonOkHttpClient$1 implements Callback {
    final /* synthetic */ IHttpCallback a;

    CommonOkHttpClient$1(IHttpCallback iHttpCallback) {
        this.a = iHttpCallback;
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
            IHttpCallback iHttpCallback = this.a;
            if (iHttpCallback == null) {
                return;
            }
            if (response == null) {
                iHttpCallback.d(1027, (byte[]) null, CommonOkHttpClient.e());
            } else {
                ResponseBody body = response.body();
                this.a.f(response.code(), body == null ? new byte[0] : body.bytes(), response.headers());
            }
        } catch (Exception e) {
            if (response != null) {
                this.a.d(response.code(), (byte[]) null, e);
            }
        }
    }
}
