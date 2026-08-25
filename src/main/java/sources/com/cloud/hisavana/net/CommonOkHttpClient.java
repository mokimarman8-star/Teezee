package com.cloud.hisavana.net;

import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.hisavana.net.disklrucache.ImageCacheURL;
import com.cloud.hisavana.net.disklrucache.impl.IDiskCache;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.net.impl.IHttpCallback;
import com.cloud.hisavana.net.ssl.HttpsTrustManager;
import com.cloud.hisavana.net.utils.ByteBufferUtil;
import com.cloud.sdk.commonutil.util.c;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import mh.g;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.chromium.net.NetworkException;
import org.chromium.net.QuicException;
import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public class CommonOkHttpClient {
    public static boolean a;
    private static Dispatcher b;
    private static EventListener.Factory c;
    private static Exception d = new Exception("http response body is empty");

    private static class GeneralOkHttpClient {
        private static final OkHttpClient a = b().build();

        private GeneralOkHttpClient() {
        }

        private static OkHttpClient.Builder b() {
            OkHttpClient.Builder eventListenerFactory;
            g gVar = new g(CommonOkHttpClient.c, 0, CommonOkHttpClient.a);
            if (CommonOkHttpClient.a) {
                OkHttpClient.Builder hostnameVerifier = new OkHttpClient.Builder().sslSocketFactory(HttpsTrustManager.a(), new HttpsTrustManager()).hostnameVerifier(new HttpsTrustManager.TrustAllHostnameVerifier());
                TimeUnit timeUnit = TimeUnit.SECONDS;
                eventListenerFactory = hostnameVerifier.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).dispatcher(CommonOkHttpClient.b != null ? CommonOkHttpClient.b : new Dispatcher()).eventListenerFactory(gVar);
            } else {
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit2 = TimeUnit.SECONDS;
                eventListenerFactory = builder.connectTimeout(30L, timeUnit2).readTimeout(30L, timeUnit2).writeTimeout(30L, timeUnit2).dispatcher(CommonOkHttpClient.b != null ? CommonOkHttpClient.b : new Dispatcher()).eventListenerFactory(gVar);
            }
            c.netLog("getBuilder: isTestRequest = " + CommonOkHttpClient.a);
            return NetGroup.f(eventListenerFactory, gVar, NetGroup.e());
        }
    }

    private CommonOkHttpClient() {
        throw new IllegalStateException("Utility class");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(RequestParams requestParams, String str, Response response, byte[] bArr) {
        String str2 = "";
        try {
            IDiskCache g = DiskLruCacheUtil.g(requestParams.getCacheMode());
            if (requestParams.getIsUseCache() && g != null && response.code() < 300) {
                ImageCacheURL imageCacheURL = new ImageCacheURL(str);
                str2 = requestParams.getIsDownloadVideo() ? g.d(imageCacheURL, response) : g.b(imageCacheURL, bArr);
                if (Log.isLoggable("ADSDK", 3)) {
                    c.netLog("url :" + str + " , write cache finish.  filePath = " + str2);
                }
            }
        } catch (Exception e) {
            c.netLog("cacheToDisk is failure, " + Log.getStackTraceString(e));
        }
        return str2;
    }

    public static Call i(RequestParams requestParams, Request request, IHttpCallback iHttpCallback) {
        IDiskCache g;
        if (Log.isLoggable("ADSDK", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("downLoadImg okhttp------> run Current Looper:");
            sb.append(Looper.myLooper() == Looper.getMainLooper() ? "Main Looper" : "thread Looper");
            c.netLog(sb.toString());
        }
        try {
            if (requestParams.getIsUseCache() && (g = DiskLruCacheUtil.g(requestParams.getCacheMode())) != null) {
                File c2 = g.c(new ImageCacheURL(request.url().toString()));
                if (c2 == null || !c2.exists() || c2.length() <= 0) {
                    return p(requestParams, request, iHttpCallback);
                }
                if (Log.isLoggable("ADSDK", 3)) {
                    c.netLog("image url:" + request.url());
                    c.netLog("image path:" + c2.getPath());
                }
                if (iHttpCallback != null) {
                    if (requestParams.getIsFetchFilePath()) {
                        iHttpCallback.e(250, ByteBufferUtil.c(ByteBufferUtil.a(c2)), c2.getPath());
                    } else {
                        iHttpCallback.c(250, ByteBufferUtil.c(ByteBufferUtil.a(c2)));
                    }
                    return null;
                }
            }
        } catch (IOException e) {
            c.netLog("downLoadImg: --> " + Log.getStackTraceString(e));
            if (iHttpCallback != null && 0 != 0) {
                iHttpCallback.d(ASTNode.COLLECTION, null, e);
            }
        }
        return p(requestParams, request, iHttpCallback);
    }

    public static Call j(Request request, IHttpCallback iHttpCallback) {
        try {
            Call newCall = l().newCall(request);
            FirebasePerfOkHttpClient.enqueue(newCall, new 1(iHttpCallback));
            return newCall;
        } catch (Throwable th) {
            if (iHttpCallback != null) {
                iHttpCallback.d(480, null, th);
            }
            o(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(int i) {
        if (i == 1) {
            return 1101;
        }
        if (i == 2) {
            return 1102;
        }
        if (i == 3) {
            return 1103;
        }
        if (i == 4) {
            return 1104;
        }
        if (i == 5) {
            return 1105;
        }
        if (i == 6) {
            return 1106;
        }
        if (i == 7) {
            return 1107;
        }
        if (i == 8) {
            return 1108;
        }
        if (i == 9) {
            return 1109;
        }
        if (i == 10) {
            return 1110;
        }
        return i == 11 ? 1111 : 480;
    }

    public static OkHttpClient l() {
        return GeneralOkHttpClient.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.length() > 0;
    }

    public static Call n(Request request, final IHttpCallback iHttpCallback) {
        if (iHttpCallback != null) {
            iHttpCallback.a();
        }
        try {
            Call newCall = l().newCall(request);
            FirebasePerfOkHttpClient.enqueue(newCall, new Callback() { // from class: com.cloud.hisavana.net.CommonOkHttpClient.2
                public void onFailure(Call call, IOException iOException) {
                    try {
                        IHttpCallback iHttpCallback2 = IHttpCallback.this;
                        if (iHttpCallback2 == null) {
                            return;
                        }
                        if (iOException instanceof SocketTimeoutException) {
                            iHttpCallback2.d(481, null, iOException);
                        } else if (iOException instanceof UnknownHostException) {
                            iHttpCallback2.d(484, null, iOException);
                        } else if (iOException instanceof NoRouteToHostException) {
                            iHttpCallback2.d(485, null, iOException);
                        } else if (iOException instanceof ProtocolException) {
                            iHttpCallback2.d(486, null, iOException);
                        } else if (iOException instanceof ConnectException) {
                            iHttpCallback2.d(483, null, iOException);
                        } else if (iOException instanceof QuicException) {
                            iHttpCallback2.d(487, null, iOException);
                        } else if (iOException instanceof NetworkException) {
                            IHttpCallback.this.d(CommonOkHttpClient.k(((NetworkException) iOException).getErrorCode()), null, iOException);
                        } else {
                            iHttpCallback2.d(480, null, iOException);
                        }
                    } catch (Throwable th) {
                        IHttpCallback iHttpCallback3 = IHttpCallback.this;
                        if (iHttpCallback3 != null) {
                            iHttpCallback3.d(480, null, iOException);
                        }
                        CommonOkHttpClient.o(th);
                    }
                }

                public void onResponse(Call call, Response response) {
                    try {
                        IHttpCallback iHttpCallback2 = IHttpCallback.this;
                        if (iHttpCallback2 == null) {
                            return;
                        }
                        if (response == null) {
                            iHttpCallback2.d(1027, null, CommonOkHttpClient.d);
                        } else {
                            ResponseBody body = response.body();
                            IHttpCallback.this.f(response.code(), body == null ? new byte[0] : body.bytes(), response.headers());
                        }
                    } catch (Exception e) {
                        if (response != null) {
                            IHttpCallback.this.d(response.code(), null, e);
                        }
                    }
                }
            });
            return newCall;
        } catch (Throwable th) {
            if (iHttpCallback != null) {
                iHttpCallback.d(480, null, th);
            }
            o(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o(Throwable th) {
        if (!Log.isLoggable("ADSDK", 3) || th == null) {
            return;
        }
        c.netLog("onFailure:  " + Log.getStackTraceString(th));
    }

    private static Call p(RequestParams requestParams, Request request, IHttpCallback iHttpCallback) {
        try {
            Call newCall = l().newCall(request);
            FirebasePerfOkHttpClient.enqueue(newCall, new 3(iHttpCallback, requestParams, request));
            return newCall;
        } catch (Throwable th) {
            if (iHttpCallback != null) {
                iHttpCallback.d(480, null, th);
            }
            o(th);
            return null;
        }
    }

    public static void q(Dispatcher dispatcher, EventListener.Factory factory) {
        b = dispatcher;
        c = factory;
    }

    public static void r(Dispatcher dispatcher) {
        q(dispatcher, null);
    }
}
