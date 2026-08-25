package bz;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.transsion.infra.gateway.core.bean.GatewaySignKey;
import com.transsion.infra.gateway.core.bean.RequestBean;
import com.transsion.infra.gateway.core.sercurity.SignAlgorithm;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class f {
    private static SSLSocketFactory a;

    static {
        Pattern.compile("\\d+");
        a = null;
    }

    static i a(String str, String str2, int i) {
        HttpURLConnection httpURLConnection;
        String str3;
        URL url;
        GatewaySignKey gatewaySignKey;
        i iVar;
        SSLContext a2;
        com.transsion.sdk.oneid.b.i("Post url : " + str + "\nBody : " + str2);
        HttpURLConnection httpURLConnection2 = null;
        i iVar2 = new i(-1, null);
        try {
            try {
                String a3 = c.a();
                byte[] a4 = new d(a3.getBytes()).a(str2);
                str3 = Base64.encodeToString(a4, 2) + "," + Base64.encodeToString(new rp.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoj6/eaT17WcI4r6GJxLVIDfQkYLRLGWyObKO1kj1FS+7NvAIIhNxjNpplefKGWSLOyuKdkLlH53q+HQeyo3ngDf3IPp8evvBfWaoCk1H33q35hm+W+XKsL5bMbzZhJDVEqYpebXRqL6Cz+79xyWPEHbp1l2G5FKQ76/tKAqZ+7LNeEBhgoX1duXcAXrSR7dOP6loh2DUwagVta/o2poAVzxKQKDJeJs0+VV741yJSjjVMGWAl0enK4MA0lvtmin6LVQMgNuHL5UXmdrbsEcbiVvE7z9Ol6MGDRzxyUBufklb3Orr9tbLNydKJ0mrdHZMcg8yGpuJMMOOs+CBiqA+MQIDAQAB").d(a3), 2);
                url = new URL(str);
                httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            if (httpURLConnection instanceof HttpsURLConnection) {
                if (a == null && (a2 = k.a()) != null) {
                    a = a2.getSocketFactory();
                }
                SSLSocketFactory sSLSocketFactory = a;
                if (sSLSocketFactory != null) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(k.a);
                }
            }
            if (i > 0) {
                gatewaySignKey = new GatewaySignKey(l.d().b(), 2, SignAlgorithm.HmacMD5);
                RequestBean build = new RequestBean.Builder().method("POST").accept("*/*").contentType("application/json").url(str).key(gatewaySignKey).body(str3).build();
                com.transsion.sdk.oneid.b.i("Gateway requestBean : " + build.toString());
                String a5 = ll.a.a(build);
                com.transsion.sdk.oneid.b.i("Gateway sign : " + a5);
                httpURLConnection.setRequestProperty("x-tr-signature", a5);
            } else {
                gatewaySignKey = null;
            }
            httpURLConnection.setRequestProperty("accept", "*/*");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str3.length()));
            httpURLConnection.setRequestProperty("appid", String.valueOf(i));
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            PrintWriter printWriter = new PrintWriter(httpURLConnection.getOutputStream());
            printWriter.write(str3);
            printWriter.flush();
            printWriter.close();
            int responseCode = httpURLConnection.getResponseCode();
            com.transsion.sdk.oneid.b.i("url:" + url + " code:" + responseCode);
            if (responseCode == 200) {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                String sb2 = sb.toString();
                if (TextUtils.equals("{}", sb2)) {
                    iVar = new i(1, null);
                } else if (TextUtils.isEmpty(sb2)) {
                    iVar = new i(-1, null);
                } else {
                    iVar2 = new i(0, sb2);
                    bufferedReader.close();
                    inputStream.close();
                }
                iVar2 = iVar;
                bufferedReader.close();
                inputStream.close();
            } else if ("429&503&504".contains(String.valueOf(responseCode))) {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream(), StandardCharsets.UTF_8));
                StringBuilder sb3 = new StringBuilder();
                while (true) {
                    String readLine2 = bufferedReader2.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    sb3.append(readLine2);
                }
                iVar2 = new i(4, sb3.toString());
            } else if (responseCode >= 400 && gatewaySignKey != null) {
                com.transsion.sdk.oneid.b.i("result from server : " + httpURLConnection.getResponseMessage());
                InputStream errorStream = httpURLConnection.getErrorStream();
                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(errorStream, StandardCharsets.UTF_8));
                StringBuilder sb4 = new StringBuilder();
                while (true) {
                    String readLine3 = bufferedReader3.readLine();
                    if (readLine3 == null) {
                        break;
                    }
                    sb4.append(readLine3);
                }
                String sb5 = sb4.toString();
                if (ll.a.c(responseCode, sb5, gatewaySignKey)) {
                    iVar2 = new i(3, sb5);
                }
                bufferedReader3.close();
                errorStream.close();
            }
        } catch (Exception e2) {
            e = e2;
            httpURLConnection2 = httpURLConnection;
            if (e instanceof UnknownHostException) {
                com.transsion.sdk.oneid.b.m(e.getMessage());
            } else {
                com.transsion.sdk.oneid.b.m(Log.getStackTraceString(e));
            }
            if (httpURLConnection2 != null) {
                httpURLConnection = httpURLConnection2;
                httpURLConnection.disconnect();
            }
            return iVar2;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
        httpURLConnection.disconnect();
        return iVar2;
    }
}
