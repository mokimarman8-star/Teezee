package wb;

import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import qb.g;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    private final String a;
    private final Map b;
    private final Map c = new HashMap();

    public a(String str, Map map) {
        this.a = str;
        this.b = map;
    }

    private String a(Map map) {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = map.entrySet().iterator();
        Map.Entry entry = (Map.Entry) it.next();
        sb2.append((String) entry.getKey());
        sb2.append("=");
        sb2.append(entry.getValue() != null ? URLEncoder.encode((String) entry.getValue(), C.UTF8_NAME) : TtmlNode.ANONYMOUS_REGION_ID);
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            sb2.append("&");
            sb2.append((String) entry2.getKey());
            sb2.append("=");
            sb2.append(entry2.getValue() != null ? URLEncoder.encode((String) entry2.getValue(), C.UTF8_NAME) : TtmlNode.ANONYMOUS_REGION_ID);
        }
        return sb2.toString();
    }

    private String b(String str, Map map) {
        String a = a(map);
        if (a.isEmpty()) {
            return str;
        }
        if (!str.contains("?")) {
            return str + "?" + a;
        }
        if (!str.endsWith("&")) {
            a = "&" + a;
        }
        return str + a;
    }

    private String e(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, C.UTF8_NAME));
        char[] cArr = new char[8192];
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read == -1) {
                return sb2.toString();
            }
            sb2.append(cArr, 0, read);
        }
    }

    public c c() {
        HttpsURLConnection httpsURLConnection;
        CrashlyticsWorkers.d();
        InputStream inputStream = null;
        String e = null;
        inputStream = null;
        try {
            String b = b(this.a, this.b);
            g.f().i("GET Request URL: " + b);
            httpsURLConnection = (HttpsURLConnection) new URL(b).openConnection();
            try {
                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setRequestMethod("GET");
                for (Map.Entry entry : this.c.entrySet()) {
                    httpsURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                InputStream inputStream2 = httpsURLConnection.getInputStream();
                if (inputStream2 != null) {
                    try {
                        e = e(inputStream2);
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                httpsURLConnection.disconnect();
                return new c(responseCode, e);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            httpsURLConnection = null;
        }
    }

    public a d(String str, String str2) {
        this.c.put(str, str2);
        return this;
    }
}
