package com.aliyun.utils;

import com.cicada.player.utils.Logger;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class AbsHttpHelper {
    private static final int CONNECTION_TIMEOUT = 10000;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doHttpGet(String str) {
        ?? r4;
        HttpURLConnection httpURLConnection;
        URL url;
        InputStream errorStream;
        InputStream inputStream = null;
        try {
            try {
                url = new URL(str);
            } catch (Throwable th) {
                th = th;
                r4 = str;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                if (r4 != 0) {
                    throw th;
                }
                r4.disconnect();
                throw th;
            }
        } catch (Exception e) {
            e = e;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            r4 = 0;
            if (0 != 0) {
            }
            if (r4 != 0) {
            }
        }
        if (((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection())) instanceof HttpURLConnection) {
            httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            try {
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    errorStream = httpURLConnection.getInputStream();
                    handleOKInputStream(errorStream);
                } else {
                    errorStream = httpURLConnection.getErrorStream();
                    handleErrorInputStream(errorStream);
                }
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (Exception e2) {
                e = e2;
                Logger.w("HttpClientUtil", e.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (httpURLConnection == null) {
                    return;
                }
                httpURLConnection.disconnect();
            }
            httpURLConnection.disconnect();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doHttpsGet(String str) {
        ?? r4;
        HttpsURLConnection httpsURLConnection;
        URL url;
        InputStream errorStream;
        InputStream inputStream = null;
        try {
            try {
                url = new URL(str);
            } catch (Throwable th) {
                th = th;
                r4 = str;
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                if (r4 != 0) {
                    throw th;
                }
                r4.disconnect();
                throw th;
            }
        } catch (Exception e) {
            e = e;
            httpsURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            r4 = 0;
            if (0 != 0) {
            }
            if (r4 != 0) {
            }
        }
        if (((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection())) instanceof HttpsURLConnection) {
            httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            try {
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.connect();
                if (httpsURLConnection.getResponseCode() == 200) {
                    errorStream = httpsURLConnection.getInputStream();
                    handleOKInputStream(errorStream);
                } else {
                    errorStream = httpsURLConnection.getErrorStream();
                    handleErrorInputStream(errorStream);
                }
                if (errorStream != null) {
                    try {
                        errorStream.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (Exception e2) {
                e = e2;
                Logger.d("HttpClientUtil", e.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (httpsURLConnection == null) {
                    return;
                }
                httpsURLConnection.disconnect();
            }
            httpsURLConnection.disconnect();
        }
    }

    public void doGet(String str) {
        if (str.startsWith(AgentPageJsBridge.HTTPS)) {
            doHttpsGet(str);
        } else if (str.startsWith("http://")) {
            doHttpGet(str);
        }
    }

    protected abstract void handleErrorInputStream(InputStream inputStream);

    protected abstract void handleOKInputStream(InputStream inputStream);
}
