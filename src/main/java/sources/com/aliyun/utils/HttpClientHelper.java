package com.aliyun.utils;

import com.cicada.player.utils.Logger;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class HttpClientHelper {
    private static final int CONNECTION_TIMEOUT = 10000;
    private static final String TAG = "HttpClientHelper";
    private static ExecutorService sThreadCachePool = Executors.newCachedThreadPool();
    private String mUrl;
    private URLConnection urlConnection = null;
    private String mReferer = null;
    private int mNetworkTimeout = 10000;
    private String mHttpProxy = null;
    private String mUserAgent = null;
    private String[] mCustomHeaders = null;

    public HttpClientHelper(String str) {
        this.mUrl = str;
    }

    private InputStream getErrorStream() {
        URLConnection uRLConnection = this.urlConnection;
        if (uRLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) uRLConnection).getErrorStream();
        }
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getErrorStream();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0042 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043 A[Catch: Exception -> 0x0056, TRY_LEAVE, TryCatch #1 {Exception -> 0x0056, blocks: (B:10:0x003e, B:14:0x0043), top: B:9:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0034 A[Catch: Exception -> 0x0057, TRY_LEAVE, TryCatch #0 {Exception -> 0x0057, blocks: (B:3:0x0001, B:6:0x0022, B:8:0x0029, B:20:0x0034), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029 A[Catch: Exception -> 0x0057, TryCatch #0 {Exception -> 0x0057, blocks: (B:3:0x0001, B:6:0x0022, B:8:0x0029, B:20:0x0034), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private URLConnection getHttpUrlConnection(String str) {
        Proxy proxy;
        URLConnection uRLConnection;
        URLConnection uRLConnection2 = null;
        try {
            if (this.mHttpProxy != null) {
                try {
                    URL url = new URL(this.mHttpProxy);
                    proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(url.getHost(), url.getPort()));
                } catch (Exception unused) {
                }
                URL url2 = new URL(str);
                uRLConnection = proxy == null ? (URLConnection) FirebasePerfUrlConnection.instrument(url2.openConnection(proxy)) : (URLConnection) FirebasePerfUrlConnection.instrument(url2.openConnection());
                if (uRLConnection instanceof HttpURLConnection) {
                    return null;
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setConnectTimeout(this.mNetworkTimeout);
                httpURLConnection.setReadTimeout(this.mNetworkTimeout);
                return uRLConnection;
            }
            if (uRLConnection instanceof HttpURLConnection) {
            }
        } catch (Exception unused2) {
            uRLConnection2 = uRLConnection;
            return uRLConnection2;
        }
        proxy = null;
        URL url22 = new URL(str);
        if (proxy == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0042 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043 A[Catch: Exception -> 0x0056, TRY_LEAVE, TryCatch #1 {Exception -> 0x0056, blocks: (B:10:0x003e, B:14:0x0043), top: B:9:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0034 A[Catch: Exception -> 0x0057, TRY_LEAVE, TryCatch #0 {Exception -> 0x0057, blocks: (B:3:0x0001, B:6:0x0022, B:8:0x0029, B:20:0x0034), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029 A[Catch: Exception -> 0x0057, TryCatch #0 {Exception -> 0x0057, blocks: (B:3:0x0001, B:6:0x0022, B:8:0x0029, B:20:0x0034), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private URLConnection getHttpsUrlConnection(String str) {
        Proxy proxy;
        URLConnection uRLConnection;
        URLConnection uRLConnection2 = null;
        try {
            if (this.mHttpProxy != null) {
                try {
                    URL url = new URL(this.mHttpProxy);
                    proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(url.getHost(), url.getPort()));
                } catch (Exception unused) {
                }
                URL url2 = new URL(str);
                uRLConnection = proxy == null ? (URLConnection) FirebasePerfUrlConnection.instrument(url2.openConnection(proxy)) : (URLConnection) FirebasePerfUrlConnection.instrument(url2.openConnection());
                if (uRLConnection instanceof HttpsURLConnection) {
                    return null;
                }
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
                httpsURLConnection.setRequestMethod("GET");
                httpsURLConnection.setConnectTimeout(this.mNetworkTimeout);
                httpsURLConnection.setReadTimeout(this.mNetworkTimeout);
                return uRLConnection;
            }
            if (uRLConnection instanceof HttpsURLConnection) {
            }
        } catch (Exception unused2) {
            uRLConnection2 = uRLConnection;
            return uRLConnection2;
        }
        proxy = null;
        URL url22 = new URL(str);
        if (proxy == null) {
        }
    }

    private int getResponseCode() throws IOException {
        URLConnection uRLConnection = this.urlConnection;
        if (uRLConnection instanceof HttpsURLConnection) {
            return ((HttpsURLConnection) uRLConnection).getResponseCode();
        }
        if (uRLConnection instanceof HttpURLConnection) {
            return ((HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b5, code lost:
    
        if (r7 == null) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b8, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008c, code lost:
    
        ((java.net.HttpURLConnection) r7).disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x008a, code lost:
    
        if (r7 != null) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2 A[Catch: IOException -> 0x00b5, TRY_LEAVE, TryCatch #3 {IOException -> 0x00b5, blocks: (B:43:0x00ad, B:36:0x00b2), top: B:42:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] post(String str, byte[] bArr) {
        URLConnection uRLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        InputStream inputStream2 = null;
        try {
            uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection());
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(bArr != null);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                if (bArr != null) {
                    httpURLConnection.setFixedLengthStreamingMode(bArr.length);
                    httpURLConnection.connect();
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.close();
                } else {
                    httpURLConnection.connect();
                }
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[4096];
                        byteArrayOutputStream2 = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr2, 0, read);
                            } catch (Exception unused) {
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream2 != 0) {
                                }
                            } catch (Throwable th) {
                                inputStream2 = inputStream;
                                th = th;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException unused2) {
                                        if (uRLConnection != null) {
                                            throw th;
                                        }
                                        ((HttpURLConnection) uRLConnection).disconnect();
                                        throw th;
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (uRLConnection != null) {
                                }
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        try {
                            inputStream.close();
                            byteArrayOutputStream2.close();
                        } catch (IOException unused3) {
                        }
                        if (uRLConnection != null) {
                            ((HttpURLConnection) uRLConnection).disconnect();
                        }
                        return byteArray;
                    } catch (Exception unused4) {
                        byteArrayOutputStream2 = 0;
                    } catch (Throwable th2) {
                        byteArrayOutputStream = null;
                        inputStream2 = inputStream;
                        th = th2;
                    }
                }
            } catch (Exception unused5) {
                inputStream = null;
                byteArrayOutputStream2 = inputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused6) {
                    }
                }
                if (byteArrayOutputStream2 != 0) {
                    byteArrayOutputStream2.close();
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
            }
        } catch (Exception unused7) {
            uRLConnection = null;
            inputStream = null;
        } catch (Throwable th4) {
            th = th4;
            uRLConnection = null;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x017b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0159 A[Catch: IOException -> 0x0161, TryCatch #13 {IOException -> 0x0161, blocks: (B:79:0x0154, B:64:0x0159, B:66:0x015e), top: B:78:0x0154 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015e A[Catch: IOException -> 0x0161, TRY_LEAVE, TryCatch #13 {IOException -> 0x0161, blocks: (B:79:0x0154, B:64:0x0159, B:66:0x015e), top: B:78:0x0154 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0154 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0180 A[Catch: IOException -> 0x0188, TryCatch #8 {IOException -> 0x0188, blocks: (B:105:0x017b, B:87:0x0180, B:89:0x0185), top: B:104:0x017b }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0185 A[Catch: IOException -> 0x0188, TRY_LEAVE, TryCatch #8 {IOException -> 0x0188, blocks: (B:105:0x017b, B:87:0x0180, B:89:0x0185), top: B:104:0x017b }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x018c  */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v16, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String doGet() {
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        InputStream inputStream2;
        InputStreamReader inputStreamReader2;
        InputStreamReader inputStreamReader3;
        Throwable th;
        ?? r3;
        ?? r4;
        URLConnection uRLConnection;
        Object obj;
        Object obj2;
        URLConnection uRLConnection2;
        BufferedReader bufferedReader;
        if (this.mUrl.startsWith(AgentPageJsBridge.HTTPS)) {
            this.urlConnection = getHttpsUrlConnection(this.mUrl);
        } else if (this.mUrl.startsWith("http://")) {
            this.urlConnection = getHttpUrlConnection(this.mUrl);
        } else {
            this.urlConnection = null;
        }
        URLConnection uRLConnection3 = this.urlConnection;
        if (uRLConnection3 == null) {
            return null;
        }
        String str = this.mReferer;
        if (str != null) {
            uRLConnection3.setRequestProperty("Referer", str);
        }
        String str2 = this.mUserAgent;
        if (str2 != null) {
            this.urlConnection.addRequestProperty("User-Agent", str2);
        }
        String[] strArr = this.mCustomHeaders;
        if (strArr != null) {
            for (String str3 : strArr) {
                if (str3 != null) {
                    String[] split = str3.split(":");
                    if (split.length == 2) {
                        this.urlConnection.addRequestProperty(split[0], split[1]);
                    }
                }
            }
        }
        try {
            int responseCode = getResponseCode();
            if (responseCode == 200) {
                inputStream2 = this.urlConnection.getInputStream();
                try {
                    inputStreamReader2 = new InputStreamReader(inputStream2);
                } catch (Exception e) {
                    e = e;
                    inputStreamReader2 = null;
                    r3 = inputStreamReader2;
                    Logger.d("HttpClientUtil", e.getMessage());
                    if (inputStream2 != null) {
                    }
                    if (inputStreamReader2 != null) {
                    }
                    if (r3 != 0) {
                    }
                    uRLConnection2 = this.urlConnection;
                    if (uRLConnection2 != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    inputStreamReader = null;
                    obj = null;
                    th = th2;
                    inputStream = inputStream2;
                    r4 = obj;
                    if (inputStream != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (r4 != 0) {
                    }
                    uRLConnection = this.urlConnection;
                    if (uRLConnection == null) {
                    }
                }
                try {
                    r3 = new BufferedReader(inputStreamReader2);
                    try {
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = r3.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            String sb2 = sb.toString();
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException unused) {
                                }
                            }
                            inputStreamReader2.close();
                            r3.close();
                            URLConnection uRLConnection4 = this.urlConnection;
                            if (uRLConnection4 != null) {
                                if (uRLConnection4 instanceof HttpURLConnection) {
                                    ((HttpURLConnection) uRLConnection4).disconnect();
                                } else if (uRLConnection4 instanceof HttpsURLConnection) {
                                    ((HttpsURLConnection) uRLConnection4).disconnect();
                                }
                            }
                            return sb2;
                        } catch (Exception e2) {
                            e = e2;
                            r3 = r3;
                            Logger.d("HttpClientUtil", e.getMessage());
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException unused2) {
                                    uRLConnection2 = this.urlConnection;
                                    if (uRLConnection2 != null) {
                                    }
                                    return null;
                                }
                            }
                            if (inputStreamReader2 != null) {
                                inputStreamReader2.close();
                            }
                            if (r3 != 0) {
                                r3.close();
                            }
                            uRLConnection2 = this.urlConnection;
                            if (uRLConnection2 != null) {
                                if (uRLConnection2 instanceof HttpURLConnection) {
                                    ((HttpURLConnection) uRLConnection2).disconnect();
                                } else if (uRLConnection2 instanceof HttpsURLConnection) {
                                    ((HttpsURLConnection) uRLConnection2).disconnect();
                                }
                            }
                            return null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        obj2 = r3;
                        inputStreamReader = inputStreamReader2;
                        obj = obj2;
                        inputStream = inputStream2;
                        r4 = obj;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused3) {
                                uRLConnection = this.urlConnection;
                                if (uRLConnection == null) {
                                }
                            }
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (r4 != 0) {
                            r4.close();
                        }
                        uRLConnection = this.urlConnection;
                        if (uRLConnection == null) {
                            throw th;
                        }
                        if (uRLConnection instanceof HttpURLConnection) {
                            ((HttpURLConnection) uRLConnection).disconnect();
                            throw th;
                        }
                        if (!(uRLConnection instanceof HttpsURLConnection)) {
                            throw th;
                        }
                        ((HttpsURLConnection) uRLConnection).disconnect();
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    r3 = 0;
                    Logger.d("HttpClientUtil", e.getMessage());
                    if (inputStream2 != null) {
                    }
                    if (inputStreamReader2 != null) {
                    }
                    if (r3 != 0) {
                    }
                    uRLConnection2 = this.urlConnection;
                    if (uRLConnection2 != null) {
                    }
                    return null;
                } catch (Throwable th4) {
                    obj2 = null;
                    th = th4;
                    inputStreamReader = inputStreamReader2;
                    obj = obj2;
                    inputStream = inputStream2;
                    r4 = obj;
                    if (inputStream != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (r4 != 0) {
                    }
                    uRLConnection = this.urlConnection;
                    if (uRLConnection == null) {
                    }
                }
            } else {
                inputStream = getErrorStream();
                try {
                    inputStreamReader = new InputStreamReader(inputStream);
                } catch (Exception e4) {
                    e = e4;
                    r3 = 0;
                    inputStream2 = inputStream;
                    inputStreamReader2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStreamReader = null;
                    inputStreamReader3 = inputStreamReader;
                    th = th;
                    r4 = inputStreamReader3;
                    if (inputStream != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (r4 != 0) {
                    }
                    uRLConnection = this.urlConnection;
                    if (uRLConnection == null) {
                    }
                }
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Exception e8) {
                    e = e8;
                    inputStream2 = inputStream;
                    inputStreamReader2 = inputStreamReader;
                    r3 = 0;
                    Logger.d("HttpClientUtil", e.getMessage());
                    if (inputStream2 != null) {
                    }
                    if (inputStreamReader2 != null) {
                    }
                    if (r3 != 0) {
                    }
                    uRLConnection2 = this.urlConnection;
                    if (uRLConnection2 != null) {
                    }
                    return null;
                } catch (Throwable th6) {
                    th = th6;
                    inputStreamReader3 = null;
                    th = th;
                    r4 = inputStreamReader3;
                    if (inputStream != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (r4 != 0) {
                    }
                    uRLConnection = this.urlConnection;
                    if (uRLConnection == null) {
                    }
                }
                try {
                    StringBuilder sb3 = new StringBuilder();
                    while (true) {
                        String readLine2 = bufferedReader.readLine();
                        if (readLine2 == null) {
                            break;
                        }
                        sb3.append(readLine2);
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("StatusCode", responseCode);
                    jSONObject.put("ResponseStr", sb3.toString());
                    String jSONObject2 = jSONObject.toString();
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    inputStreamReader.close();
                    bufferedReader.close();
                    URLConnection uRLConnection5 = this.urlConnection;
                    if (uRLConnection5 != null) {
                        if (uRLConnection5 instanceof HttpURLConnection) {
                            ((HttpURLConnection) uRLConnection5).disconnect();
                        } else if (uRLConnection5 instanceof HttpsURLConnection) {
                            ((HttpsURLConnection) uRLConnection5).disconnect();
                        }
                    }
                    return jSONObject2;
                } catch (Exception e9) {
                    e = e9;
                    inputStream2 = inputStream;
                    inputStreamReader2 = inputStreamReader;
                    r3 = bufferedReader;
                    Logger.d("HttpClientUtil", e.getMessage());
                    if (inputStream2 != null) {
                    }
                    if (inputStreamReader2 != null) {
                    }
                    if (r3 != 0) {
                    }
                    uRLConnection2 = this.urlConnection;
                    if (uRLConnection2 != null) {
                    }
                    return null;
                } catch (Throwable th7) {
                    th = th7;
                    r4 = bufferedReader;
                    if (inputStream != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (r4 != 0) {
                    }
                    uRLConnection = this.urlConnection;
                    if (uRLConnection == null) {
                    }
                }
            }
        } catch (Exception e10) {
            e = e10;
            inputStream2 = null;
            inputStreamReader2 = null;
        } catch (Throwable th8) {
            th = th8;
            inputStream = null;
            inputStreamReader = null;
        }
    }

    public void setCustomHeaders(String[] strArr) {
        this.mCustomHeaders = strArr;
    }

    public void setHttpProxy(String str) {
        this.mHttpProxy = str;
    }

    public void setRefer(String str) {
        this.mReferer = str;
    }

    public void setTimeout(int i) {
        this.mNetworkTimeout = i;
    }

    public void setUerAgent(String str) {
        this.mUserAgent = str;
    }

    public void stop() {
        Logger.d(TAG, "HttpClientHelper stop().... urlConnection = " + this.urlConnection);
        if (this.urlConnection != null) {
            sThreadCachePool.execute(new Runnable() { // from class: com.aliyun.utils.HttpClientHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (HttpClientHelper.this.urlConnection instanceof HttpsURLConnection) {
                            Logger.i(HttpClientHelper.TAG, "HttpClientHelper stop().... HttpsURLConnection.disconnect ");
                            ((HttpsURLConnection) HttpClientHelper.this.urlConnection).disconnect();
                        } else if (HttpClientHelper.this.urlConnection instanceof HttpURLConnection) {
                            Logger.i(HttpClientHelper.TAG, "HttpClientHelper stop().... HttpURLConnection.disconnect ");
                            ((HttpURLConnection) HttpClientHelper.this.urlConnection).disconnect();
                        }
                    } catch (Exception e) {
                        Logger.e(HttpClientHelper.TAG, e.getMessage());
                    }
                }
            });
        }
    }
}
