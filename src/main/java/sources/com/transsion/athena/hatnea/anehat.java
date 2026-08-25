package com.transsion.athena.hatnea;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.transsion.athena.config.data.model.TidConfigBean;
import com.transsion.athena.hatnea.aatnhe;
import com.transsion.gslb.BuildConfig;
import com.transsion.gslb.GslbSdk;
import com.transsion.gslb.NetResponse;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.push.bean.MsgStyle;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.crypto.KeyGenerator;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class anehat {
    private static SSLSocketFactory a;

    private static com.transsion.athena.anateh.athena a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new com.transsion.athena.anateh.athena(bArr);
    }

    static ehanat<aatnhe> a(long j, byte[] bArr, int i, com.transsion.athena.config.data.model.aethna aethnaVar) {
        URL url;
        HttpURLConnection httpURLConnection;
        byte[] bArr2;
        SSLContext a2;
        ehanat<aatnhe> ehanatVar = new ehanat<>(2, new aatnhe("sdk_error"));
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                url = new URL(GslbSdk.getDomain(aethnaVar.a, true));
                httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            if (httpURLConnection instanceof HttpsURLConnection) {
                if (a == null && (a2 = com.transsion.athena.ehanat.athena.a()) != null) {
                    a = a2.getSocketFactory();
                }
                SSLSocketFactory sSLSocketFactory = a;
                if (sSLSocketFactory != null) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(com.transsion.athena.ehanat.athena.a);
                }
            }
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setInstanceFollowRedirects(true);
            if (aethnaVar.c * 1024 <= bArr.length) {
                httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
                httpURLConnection.setRequestProperty("zip", MsgStyle.CUSTOM_LEFT_PIC);
                bArr2 = com.transsion.athena.config.data.model.anehat.b(bArr);
            } else {
                httpURLConnection.setRequestProperty("Accept-Encoding", "text/example");
                httpURLConnection.setRequestProperty("zip", "0");
                bArr2 = bArr;
            }
            httpURLConnection.setRequestProperty("fixed", MsgStyle.CUSTOM_LEFT_PIC);
            httpURLConnection.setRequestProperty("record-id", j + BuildConfig.FLAVOR);
            httpURLConnection.setRequestProperty("count", i + BuildConfig.FLAVOR);
            httpURLConnection.setRequestProperty("ver", "3.1.1.4");
            TidConfigBean b = com.transsion.athena.aethna.athena.c().b(j);
            if (b == null) {
                com.transsion.athena.taaneh.aethna.a("requestByPost TidConfigBean " + j + " is missing, maybe cancelled");
                ehanatVar.b.d = "tid not found";
                httpURLConnection.disconnect();
                return ehanatVar;
            }
            b.getTidConfig().getClass();
            com.transsion.athena.anateh.athena a3 = a((byte[]) aethnaVar.b.second);
            if (a3 == null) {
                ehanatVar.b.d = "encrypt error";
                httpURLConnection.disconnect();
                return ehanatVar;
            }
            byte[] bytes = Base64.encodeToString(a3.b(bArr2), 2).getBytes();
            if (bytes == null) {
                com.transsion.athena.taaneh.aethna.b("requestByPost buffer is null");
                ehanatVar.b.d = "base64 error";
                httpURLConnection.disconnect();
                return ehanatVar;
            }
            String a4 = com.transsion.athena.config.data.model.anehat.a(bytes);
            if (TextUtils.isEmpty(a4)) {
                httpURLConnection.setRequestProperty("md5", MediaItem.MUSIC_FLOAT_STATE_ERROR);
            } else {
                httpURLConnection.setRequestProperty("md5", a4);
            }
            httpURLConnection.setRequestProperty("encrypt-level", String.valueOf(3));
            httpURLConnection.setRequestProperty("encrypt-index", String.valueOf(((Integer) aethnaVar.b.first).intValue() + 1));
            com.transsion.athena.taaneh.aethna.c(url + " tid = " + j + " count = " + i);
            httpURLConnection.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bytes);
            dataOutputStream.flush();
            dataOutputStream.close();
            if (httpURLConnection.getResponseCode() != 200) {
                ehanat<aatnhe> ehanatVar2 = new ehanat<>(-1, new aatnhe("rc_" + com.transsion.athena.config.data.model.anehat.a(httpURLConnection.getErrorStream())));
                httpURLConnection.disconnect();
                return ehanatVar2;
            }
            String a5 = com.transsion.athena.config.data.model.anehat.a(httpURLConnection.getInputStream());
            com.transsion.athena.taaneh.aethna.c(String.format(Locale.ENGLISH, "post tid: %s response: %s", Long.valueOf(j), a5));
            if (TextUtils.isEmpty(a5)) {
                ehanat<aatnhe> ehanatVar3 = new ehanat<>(-1, new aatnhe("rc_" + i));
                httpURLConnection.disconnect();
                return ehanatVar3;
            }
            int optInt = new JSONObject(a5).optInt("code");
            if (optInt == 0) {
                ehanat<aatnhe> ehanatVar4 = new ehanat<>(0, new aatnhe());
                httpURLConnection.disconnect();
                return ehanatVar4;
            }
            ehanat<aatnhe> ehanatVar5 = new ehanat<>(-1, new aatnhe("rc_" + optInt));
            httpURLConnection.disconnect();
            return ehanatVar5;
        } catch (Exception e2) {
            e = e2;
            httpURLConnection2 = httpURLConnection;
            if (e instanceof UnknownHostException) {
                com.transsion.athena.taaneh.aethna.b(e.getMessage());
            } else {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return new ehanat<>(-1, new aatnhe());
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0080, code lost:
    
        if (r4 != null) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static ehanat<Long> a(String str) {
        Throwable th2;
        HttpURLConnection httpURLConnection;
        Exception e;
        SSLContext a2;
        try {
            httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            try {
                try {
                    if (httpURLConnection instanceof HttpsURLConnection) {
                        if (a == null && (a2 = com.transsion.athena.ehanat.athena.a()) != null) {
                            a = a2.getSocketFactory();
                        }
                        SSLSocketFactory sSLSocketFactory = a;
                        if (sSLSocketFactory != null) {
                            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(com.transsion.athena.ehanat.athena.a);
                        }
                    }
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setConnectTimeout(10000);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode >= 200 && responseCode < 400) {
                        ehanat<Long> ehanatVar = new ehanat<>(0, Long.valueOf(httpURLConnection.getDate()));
                        httpURLConnection.disconnect();
                        return ehanatVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    if (e instanceof UnknownHostException) {
                        com.transsion.athena.taaneh.aethna.b(e.getMessage());
                    } else {
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                    }
                }
            } catch (Throwable th3) {
                th2 = th3;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
        } catch (Throwable th4) {
            th2 = th4;
            httpURLConnection = null;
        }
        httpURLConnection.disconnect();
        return new ehanat<>(-1, 0L);
    }

    static ehanat<String> a(String str, String str2, long j) {
        ehanat<String> ehanatVar;
        HttpURLConnection httpURLConnection;
        com.transsion.athena.anateh.athena athenaVar;
        String str3;
        URL url;
        SSLContext a2;
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(128);
                String c = com.transsion.athena.config.data.model.anehat.c(keyGenerator.generateKey().getEncoded());
                athenaVar = new com.transsion.athena.anateh.athena(c.getBytes());
                byte[] a3 = athenaVar.a(str2);
                str3 = Base64.encodeToString(a3, 2) + "," + Base64.encodeToString(new rp.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArNrm4jErOdstd1P5L1X/\nCGSS6NKf4glPrFbTM97aE9ZKGUiMALIV8W7FClAgLZdtTZkL5XEQdbX4RB/C6edc\nnN2ifla6sVu23y78FMiL6smp9ayE7Y3gSEfB3md4nvEUpyRUu4wYLIf9nVR36okK\nGCerxYdLtDbJ69Rux4lgE5C9a6qLfV6BzjJYONk/vQhGQYT6qes+TFtXV0hvF8UM\nDG+0GfA3MiQue/Ny8uIPBykDPS1dcIADzVos2fXs/o2aFTrkdVjiX8irwYBze69K\nzFx18H12iZ9gG1VztMbHetvImBoXeCOwjTc5RnGIz+Hya96pxJLK2DcSlAaHEs1H\nOQIDAQAB").d(c), 2);
                url = new URL(GslbSdk.getDomain(str, true));
                httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            try {
                if (httpURLConnection instanceof HttpsURLConnection) {
                    if (a == null && (a2 = com.transsion.athena.ehanat.athena.a()) != null) {
                        a = a2.getSocketFactory();
                    }
                    SSLSocketFactory sSLSocketFactory = a;
                    if (sSLSocketFactory != null) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(com.transsion.athena.ehanat.athena.a);
                    }
                }
                httpURLConnection.setRequestProperty("accept", "*/*");
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(str3.length()));
                httpURLConnection.setRequestProperty("encrypt-level", "2");
                httpURLConnection.setRequestProperty("ver", String.valueOf(j));
                httpURLConnection.setRequestProperty("vn", MsgStyle.CUSTOM_LEFT_PIC);
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
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", url);
                    jSONObject.put("params", str2);
                    jSONObject.put("version", j);
                    jSONObject.put("code", responseCode);
                    com.transsion.athena.taaneh.aethna.c("--> request config:%s", jSONObject.toString());
                } catch (Exception e2) {
                    com.transsion.athena.taaneh.aethna.b("print request config exception:%s", e2.getMessage());
                }
                if (responseCode == 200) {
                    String a4 = com.transsion.athena.config.data.model.anehat.a(httpURLConnection.getInputStream());
                    if (TextUtils.equals(NetResponse.EMPTY_RESPONSE, a4)) {
                        ehanatVar = new ehanat<>(1, null);
                    } else if (TextUtils.isEmpty(a4)) {
                        ehanatVar = new ehanat<>(-1, null);
                    } else {
                        ehanatVar = new ehanat<>(0, str.contains("secret") ? new String(athenaVar.a(Base64.decode(a4, 2)), StandardCharsets.UTF_8) : new String(com.transsion.athena.config.data.model.anehat.d(athenaVar.a(Base64.decode(a4, 2))), StandardCharsets.UTF_8));
                    }
                } else {
                    ehanatVar = new ehanat<>(-1, com.transsion.athena.config.data.model.anehat.a(httpURLConnection.getErrorStream()));
                }
            } catch (Exception e3) {
                e = e3;
                httpURLConnection2 = httpURLConnection;
                ehanat<String> ehanatVar2 = new ehanat<>(-1, e.getMessage());
                if (httpURLConnection2 == null) {
                    return ehanatVar2;
                }
                ehanatVar = ehanatVar2;
                httpURLConnection = httpURLConnection2;
                httpURLConnection.disconnect();
                return ehanatVar;
            }
            httpURLConnection.disconnect();
            return ehanatVar;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    static ehanat<String> a(String str, String str2, long j, int i) {
        ehanat<String> ehanatVar;
        HttpURLConnection httpURLConnection;
        URL url;
        byte[] bytes;
        Pair<Integer, byte[]> i2;
        com.transsion.athena.anateh.athena a2;
        SSLContext a3;
        HttpURLConnection httpURLConnection2 = null;
        ehanat<String> ehanatVar2 = new ehanat<>(-1, null);
        try {
            try {
                url = new URL(GslbSdk.getDomain(str, true));
                httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
                try {
                    try {
                        if (httpURLConnection instanceof HttpsURLConnection) {
                            if (a == null && (a3 = com.transsion.athena.ehanat.athena.a()) != null) {
                                a = a3.getSocketFactory();
                            }
                            SSLSocketFactory sSLSocketFactory = a;
                            if (sSLSocketFactory != null) {
                                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(com.transsion.athena.ehanat.athena.a);
                            }
                        }
                        bytes = str2.getBytes();
                        i2 = com.transsion.athena.aethna.athena.c().i();
                        a2 = a((byte[]) i2.second);
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection2 = httpURLConnection;
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception e) {
                    e = e;
                    httpURLConnection2 = httpURLConnection;
                    ehanat<String> ehanatVar3 = new ehanat<>(-1, e.getMessage());
                    if (httpURLConnection2 == null) {
                        return ehanatVar3;
                    }
                    ehanatVar = ehanatVar3;
                    httpURLConnection = httpURLConnection2;
                    httpURLConnection.disconnect();
                    return ehanatVar;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e2) {
            e = e2;
        }
        if (a2 == null) {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            return ehanatVar2;
        }
        byte[] bytes2 = Base64.encodeToString(a2.b(bytes), 2).getBytes();
        httpURLConnection.setRequestProperty("index", String.valueOf(((Integer) i2.first).intValue() + 1));
        httpURLConnection.setRequestProperty("accept", "*/*");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bytes2.length));
        httpURLConnection.setRequestProperty("ver", String.valueOf(j));
        httpURLConnection.setRequestProperty("vn", MsgStyle.CUSTOM_LEFT_PIC);
        httpURLConnection.setRequestProperty("app", String.valueOf(i));
        httpURLConnection.setRequestProperty("model", Build.MODEL);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bytes2);
        dataOutputStream.flush();
        dataOutputStream.close();
        int responseCode = httpURLConnection.getResponseCode();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", url);
            jSONObject.put("params", str2);
            jSONObject.put("version", j);
            jSONObject.put("code", responseCode);
            com.transsion.athena.taaneh.aethna.c("--> request config:%s", jSONObject.toString());
        } catch (Exception e3) {
            com.transsion.athena.taaneh.aethna.b("print request config exception:%s", e3.getMessage());
        }
        if (responseCode == 200) {
            String a4 = com.transsion.athena.config.data.model.anehat.a(httpURLConnection.getInputStream());
            ehanatVar = TextUtils.equals(NetResponse.EMPTY_RESPONSE, a4) ? new ehanat<>(1, null) : TextUtils.isEmpty(a4) ? new ehanat<>(-1, null) : new ehanat<>(0, new String(com.transsion.athena.config.data.model.anehat.d(Base64.decode(a4, 2)), StandardCharsets.UTF_8));
        } else {
            ehanatVar = new ehanat<>(-1, com.transsion.athena.config.data.model.anehat.a(httpURLConnection.getErrorStream()));
        }
        httpURLConnection.disconnect();
        return ehanatVar;
    }

    static ehanat<aatnhe> a(String str, byte[] bArr, int i, List<Integer> list, String str2, String str3) {
        HttpURLConnection httpURLConnection;
        SSLContext a2;
        ehanat<aatnhe> ehanatVar = new ehanat<>(2, new aatnhe("sdk_error"));
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            if (httpURLConnection instanceof HttpsURLConnection) {
                if (a == null && (a2 = com.transsion.athena.ehanat.athena.a()) != null) {
                    a = a2.getSocketFactory();
                }
                SSLSocketFactory sSLSocketFactory = a;
                if (sSLSocketFactory != null) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                    ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(com.transsion.athena.ehanat.athena.a);
                }
            }
            httpURLConnection.setReadTimeout(20000);
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setInstanceFollowRedirects(true);
            int length = bArr.length;
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
            httpURLConnection.setRequestProperty("zip", MsgStyle.CUSTOM_LEFT_PIC);
            byte[] b = com.transsion.athena.config.data.model.anehat.b(bArr);
            httpURLConnection.setRequestProperty("fixed", MsgStyle.CUSTOM_LEFT_PIC);
            httpURLConnection.setRequestProperty("count", String.valueOf(list.size()));
            httpURLConnection.setRequestProperty("appids", com.transsion.athena.config.data.model.anehat.a(list, "_"));
            httpURLConnection.setRequestProperty("ver", "3.1.1.4");
            httpURLConnection.setRequestProperty("uuid", str2);
            httpURLConnection.setRequestProperty("dupid", str3);
            Pair<Integer, byte[]> i2 = com.transsion.athena.aethna.athena.c().i();
            com.transsion.athena.anateh.athena a3 = a((byte[]) i2.second);
            if (a3 == null) {
                ehanatVar.b.d = "encrypt error";
                httpURLConnection.disconnect();
                return ehanatVar;
            }
            byte[] bytes = Base64.encodeToString(a3.b(b), 2).getBytes();
            if (bytes == null) {
                com.transsion.athena.taaneh.aethna.b("requestByPost buffer is null");
                ehanatVar.b.d = "base64 error";
                httpURLConnection.disconnect();
                return ehanatVar;
            }
            httpURLConnection.setRequestProperty("encrypt-level", MsgStyle.NATIVE_STANDARD);
            httpURLConnection.setRequestProperty("encrypt-index", String.valueOf(((Integer) i2.first).intValue() + 1));
            httpURLConnection.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(bytes);
            dataOutputStream.flush();
            dataOutputStream.close();
            if (httpURLConnection.getResponseCode() != 200) {
                ehanat<aatnhe> ehanatVar2 = new ehanat<>(-1, new aatnhe("rc_" + com.transsion.athena.config.data.model.anehat.a(httpURLConnection.getErrorStream())));
                httpURLConnection.disconnect();
                return ehanatVar2;
            }
            String a4 = com.transsion.athena.config.data.model.anehat.a(httpURLConnection.getInputStream());
            if (TextUtils.isEmpty(a4)) {
                ehanat<aatnhe> ehanatVar3 = new ehanat<>(-1, new aatnhe("rc_" + i));
                httpURLConnection.disconnect();
                return ehanatVar3;
            }
            JSONObject jSONObject = new JSONObject(a4);
            int optInt = jSONObject.optInt("code");
            String optString = jSONObject.optString("message", BuildConfig.FLAVOR);
            aatnhe aatnheVar = new aatnhe();
            aatnheVar.a = optInt;
            aatnheVar.b = optString;
            if (optInt != 0) {
                aatnheVar.d = "rc_" + optInt;
                ehanat<aatnhe> ehanatVar4 = new ehanat<>(-1, aatnheVar);
                httpURLConnection.disconnect();
                return ehanatVar4;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("app");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    long j = optJSONObject.getJSONObject(next).getLong("ver");
                    int i3 = optJSONObject.getJSONObject(next).getInt("type");
                    if (i3 != 0) {
                        aatnhe.athena athenaVar = new aatnhe.athena(Integer.parseInt(next), i3, j);
                        if (aatnheVar.c == null) {
                            aatnheVar.c = new ArrayList();
                        }
                        aatnheVar.c.add(athenaVar);
                    }
                }
            }
            ehanat<aatnhe> ehanatVar5 = new ehanat<>(0, aatnheVar);
            httpURLConnection.disconnect();
            return ehanatVar5;
        } catch (Exception e2) {
            e = e2;
            httpURLConnection2 = httpURLConnection;
            com.transsion.athena.taaneh.aethna.b(e.getMessage());
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return new ehanat<>(-1, new aatnhe());
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }
}
