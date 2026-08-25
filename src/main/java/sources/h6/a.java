package h6;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.sP;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.uA;
import com.bytedance.sdk.component.Dq.Dq;
import com.bytedance.sdk.component.Dq.vS;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import j6.b;
import j6.c;
import java.io.Closeable;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class a {
    private static final Handler a = new Handler(Looper.getMainLooper());
    public static final Charset b = Charset.forName(Key.STRING_CHARSET_NAME);

    public static int a() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 1);
    }

    public static int b(c cVar) {
        int lastIndexOf;
        if (cVar == null) {
            return -1;
        }
        if (cVar.d() == 200) {
            return c(cVar.g("Content-Length", null), -1);
        }
        if (cVar.d() == 206) {
            String g = cVar.g("Content-Range", null);
            if (!TextUtils.isEmpty(g) && (lastIndexOf = g.lastIndexOf("/")) >= 0 && lastIndexOf < g.length() - 1) {
                return c(g.substring(lastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static int c(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static sP.d d(c cVar, sP.e eVar, String str, int i) {
        String str2;
        String str3;
        String str4;
        sP.d c = eVar.c(str, i);
        if (c != null) {
            return c;
        }
        int b2 = b(cVar);
        String g = cVar.g("Content-Type", null);
        if (b2 <= 0 || TextUtils.isEmpty(g)) {
            return c;
        }
        b c2 = cVar.c();
        if (c2 != null) {
            str3 = c2.b;
            str2 = w(c2.e);
        } else {
            str2 = "";
            str3 = str2;
        }
        String v = v(cVar.h());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestUrl", str3);
            jSONObject.put("requestHeaders", str2);
            jSONObject.put("responseHeaders", v);
            str4 = jSONObject.toString();
        } catch (Throwable unused) {
            str4 = "";
        }
        sP.d dVar = new sP.d(str, g, b2, i, str4);
        eVar.d(dVar);
        return dVar;
    }

    public static String e(int i, int i2) {
        String u = u(i, i2);
        if (u == null) {
            return null;
        }
        return "bytes=".concat(u);
    }

    public static String f(sP.d dVar, int i) {
        StringBuilder sb = new StringBuilder();
        if (i <= 0) {
            sb.append("HTTP/1.1 200 OK\r\n");
        } else {
            sb.append("HTTP/1.1 206 Partial Content\r\n");
        }
        sb.append("Accept-Ranges: bytes\r\n");
        sb.append("Content-Type: ");
        sb.append(dVar.b);
        sb.append("\r\n");
        if (i <= 0) {
            sb.append("Content-Length: ");
            sb.append(dVar.c);
            sb.append("\r\n");
        } else {
            sb.append("Content-Range: bytes ");
            sb.append(i);
            sb.append("-");
            sb.append(dVar.c - 1);
            sb.append("/");
            sb.append(dVar.c);
            sb.append("\r\n");
            sb.append("Content-Length: ");
            sb.append(dVar.c - i);
            sb.append("\r\n");
        }
        sb.append("Connection: close\r\n");
        sb.append("\r\n");
        String sb2 = sb.toString();
        boolean z = com.bykv.vk.openvk.Sj.Sj.sP.sP.a.b;
        return sb2;
    }

    public static String g(c cVar, int i) {
        boolean z;
        int b2;
        if (cVar == null || !cVar.i()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.b().toUpperCase());
        sb.append(' ');
        sb.append(cVar.d());
        sb.append(' ');
        sb.append(cVar.j());
        sb.append("\r\n");
        if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.b) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cVar.b().toUpperCase());
            sb2.append(" ");
            sb2.append(cVar.d());
            sb2.append(" ");
            sb2.append(cVar.j());
        }
        List i2 = i(cVar.h());
        if (i2 != null) {
            int size = i2.size();
            z = true;
            for (int i3 = 0; i3 < size; i3++) {
                uA.c cVar2 = (uA.c) i2.get(i3);
                if (cVar2 != null) {
                    String str = cVar2.a;
                    String str2 = cVar2.b;
                    sb.append(str);
                    sb.append(": ");
                    sb.append(str2);
                    sb.append("\r\n");
                    if ("Content-Range".equalsIgnoreCase(str) || ("Accept-Ranges".equalsIgnoreCase(str) && "bytes".equalsIgnoreCase(str2))) {
                        z = false;
                    }
                }
            }
        } else {
            z = true;
        }
        if (z && (b2 = b(cVar)) > 0) {
            sb.append("Content-Range: bytes ");
            sb.append(Math.max(i, 0));
            sb.append("-");
            sb.append(b2 - 1);
            sb.append("/");
            sb.append(b2);
            sb.append("\r\n");
        }
        sb.append("Connection: close\r\n");
        sb.append("\r\n");
        String sb3 = sb.toString();
        boolean z2 = com.bykv.vk.openvk.Sj.Sj.sP.sP.a.b;
        return sb3;
    }

    public static String h(c cVar, boolean z, boolean z2) {
        String g;
        if (cVar == null) {
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.b) {
                Log.e("TAG_PROXY_Response", "response null");
            }
            return "response null";
        }
        if (!cVar.i()) {
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.b) {
                Log.e("TAG_PROXY_Response", "response code: " + cVar.d());
            }
            return "response code: " + cVar.d();
        }
        String g2 = cVar.g("Content-Type", null);
        if (!s(g2)) {
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.b) {
                Log.e("TAG_PROXY_Response", "Content-Type: ".concat(String.valueOf(g2)));
            }
            return "Content-Type: ".concat(String.valueOf(g2));
        }
        int b2 = b(cVar);
        if (b2 <= 0) {
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.b) {
                Log.e("TAG_PROXY_Response", "Content-Length: ".concat(String.valueOf(b2)));
            }
            return "Content-Length: ".concat(String.valueOf(b2));
        }
        if (z && ((g = cVar.g("Accept-Ranges", null)) == null || !g.contains("bytes"))) {
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.b) {
                Log.e("TAG_PROXY_Response", "Accept-Ranges: ".concat(String.valueOf(g)));
            }
            return "Accept-Ranges: ".concat(String.valueOf(g));
        }
        if (!z2 || cVar.a() != null) {
            return null;
        }
        if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.b) {
            Log.e("TAG_PROXY_Response", "response body null");
        }
        return "response body null";
    }

    public static List i(List list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.b) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                uA.c cVar = (uA.c) list.get(i);
                if (cVar != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(cVar.a);
                    sb.append(": ");
                    sb.append(cVar.a);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            uA.c cVar2 = (uA.c) it.next();
            if ("Host".equals(cVar2.a) || "Keep-Alive".equals(cVar2.a) || "Connection".equals(cVar2.a) || "Proxy-Connection".equals(cVar2.a)) {
                arrayList.add(cVar2);
            }
        }
        list.removeAll(arrayList);
        if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.b) {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                uA.c cVar3 = (uA.c) list.get(i2);
                if (cVar3 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(cVar3.a);
                    sb2.append(": ");
                    sb2.append(cVar3.b);
                }
            }
        }
        return list;
    }

    public static List j(Map map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Map.Entry> entrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : entrySet) {
                    arrayList.add(new uA.c((String) entry.getKey(), (String) entry.getValue()));
                }
                return arrayList;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static List k(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (r(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static void l(Dq dq) {
        if (dq != null) {
            if (x()) {
                vS.sP(dq);
                if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.b) {
                    Log.e("TAG_PROXY_UTIL", "invoke in pool thread");
                    return;
                }
                return;
            }
            dq.run();
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.b) {
                Log.e("TAG_PROXY_UTIL", "invoke calling thread");
            }
        }
    }

    public static void m(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void n(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void o(Runnable runnable) {
        if (runnable != null) {
            if (x()) {
                runnable.run();
            } else {
                a.post(runnable);
            }
        }
    }

    public static void p(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void q(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean r(String str) {
        if (str != null) {
            return str.startsWith("http://") || str.startsWith(AgentPageJsBridge.HTTPS);
        }
        return false;
    }

    public static boolean s(String str) {
        if (str != null) {
            return str.startsWith("video/") || "application/octet-stream".equals(str) || "binary/octet-stream".equals(str);
        }
        return false;
    }

    public static int t(String str) {
        return c(str, 0);
    }

    public static String u(int i, int i2) {
        if (i >= 0 && i2 > 0) {
            return i + "-" + i2;
        }
        if (i > 0) {
            return i + "-";
        }
        if (i >= 0 || i2 <= 0) {
            return null;
        }
        return "-".concat(String.valueOf(i2));
    }

    public static String v(List list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            uA.c cVar = (uA.c) list.get(0);
            if (cVar != null) {
                sb.append(cVar.a);
                sb.append(": ");
                sb.append(cVar.b);
                sb.append("\r\n");
            }
        }
        return sb.toString();
    }

    public static String w(Map map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(": ");
            sb.append(entry.getValue());
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public static boolean x() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }
}
