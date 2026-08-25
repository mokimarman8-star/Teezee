package com.transsion.athena.config.data.model;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.gslb.BuildConfig;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import javax.crypto.KeyGenerator;
import m4.a;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ehanat {
    private static String A = "";
    private static boolean B = false;
    public static boolean C = false;
    public static boolean D = false;
    public static boolean E = false;
    public static boolean F = false;
    public static boolean G = true;
    public static boolean H = true;
    public static boolean I = true;
    public static boolean J = true;
    public static boolean K = false;
    private static JSONObject L = new JSONObject();
    private static JSONObject M = new JSONObject();
    private static JSONObject N = new JSONObject();
    private static JSONObject O = new JSONObject();
    private static JSONObject P = new JSONObject();
    private static final ArrayMap<Integer, String> Q = new ArrayMap<>();
    public static boolean R = true;
    private static String a = null;
    private static String b = null;
    private static String c = null;
    private static String d = null;
    private static String e = null;
    private static String f = null;
    private static String g = null;
    public static String h = null;
    public static String i = null;
    public static String j = null;
    public static String k = null;
    public static String l = null;
    public static byte[] m = null;
    public static byte[] n = null;
    public static byte[] o = null;
    private static boolean p = false;
    private static String q = "online";
    private static long r = 30000;
    private static String s = "";
    private static String t = "";
    private static boolean u = true;
    private static boolean v = true;
    private static boolean w = false;
    private static int x = 10485760;
    private static int y;
    private static short z;

    public static String a(int i2) {
        ArrayMap<Integer, String> arrayMap = Q;
        return arrayMap.containsKey(Integer.valueOf(i2)) ? arrayMap.get(Integer.valueOf(i2)) : BuildConfig.FLAVOR;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return a(false) + f;
        }
        return str + f;
    }

    @NonNull
    public static String a(boolean z2) {
        char c2;
        String str = q;
        int hashCode = str.hashCode();
        if (hashCode == -1012222381) {
            if (str.equals("online")) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 99349) {
            if (hashCode == 3556498 && str.equals("test")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str.equals("dev")) {
                c2 = 0;
            }
            c2 = 65535;
        }
        String str2 = c2 != 0 ? c2 != 1 ? z2 ? d : e : z2 ? b : c : a;
        try {
            if (anehat.a(AthenaAnalytics.J(), "debug.athena.test_mode", false).booleanValue()) {
                str2 = z2 ? b : c;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "https://" + str2;
    }

    public static void a() {
        w = true;
    }

    public static void a(int i2, String str) {
        Q.put(Integer.valueOf(i2), str);
    }

    public static void a(long j2) {
        if (j2 < 30000) {
            j2 = 30000;
        }
        r = j2;
    }

    public static void a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (a(obj)) {
                M.put(str, obj);
            }
        } catch (JSONException e2) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e2));
        }
    }

    public static void a(String str, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(s) || z2) {
            s = str;
        }
    }

    public static void a(short s2, String str) {
        z = s2;
        A = str;
    }

    private static boolean a(Object obj) {
        int length = obj.toString().getBytes(StandardCharsets.UTF_8).length;
        if (length <= 2000) {
            return true;
        }
        com.transsion.athena.taaneh.aethna.b(String.format(Locale.getDefault(), "custom param is too long,limit is 2000 bytes(now is %d bytes)", Integer.valueOf(length)));
        return false;
    }

    public static String b() {
        return A;
    }

    public static String b(String str) {
        return str + i;
    }

    public static void b(int i2) {
        if (i2 < 0) {
            i2 = 0;
        } else if (i2 > 200) {
            i2 = 200;
        }
        y = i2;
    }

    public static void b(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (a(obj)) {
                P.put(str, obj);
            }
        } catch (JSONException e2) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e2));
        }
    }

    public static void b(boolean z2) {
        v = z2;
    }

    public static short c() {
        return z;
    }

    public static void c(int i2) {
        if (i2 < 2097152) {
            x = 2097152;
        }
        x = i2;
    }

    public static void c(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str);
        a = jSONObject.getString("d");
        b = jSONObject.getString("tu");
        c = jSONObject.getString("tc");
        d = jSONObject.getString("ou");
        e = jSONObject.getString("oc");
        f = jSONObject.getString("c").replace("v6", "v7");
        g = jSONObject.getString("g") + "v2";
        String string = jSONObject.getString("u");
        h = string;
        i = string.replace("v2", "v3");
        j = jSONObject.getString("fc");
        k = jSONObject.getString("fd");
        l = jSONObject.getString("fe");
        n = jSONObject.getString("w").getBytes();
        o = jSONObject.getString("iv").getBytes();
        a a2 = a.a(AthenaAnalytics.J());
        try {
            if (a2.e("athena_def") != 0) {
                m = n;
                return;
            }
            String h2 = a2.h("athena_ea");
            if (TextUtils.isEmpty(h2)) {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(128);
                h2 = anehat.c(keyGenerator.generateKey().getEncoded());
                a2.c("athena_ea", h2);
            }
            m = anehat.a(h2);
        } catch (Exception unused) {
            a2.b("athena_def", 1);
            m = n;
        }
    }

    public static void c(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (a(obj)) {
                O.put(str, obj);
            }
        } catch (JSONException e2) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e2));
        }
    }

    public static void c(boolean z2) {
        p = z2;
    }

    public static JSONObject d() {
        return M;
    }

    public static void d(String str) {
        t = str;
    }

    public static synchronized void d(String str, Object obj) {
        synchronized (ehanat.class) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (a(obj)) {
                        L.put(str, obj);
                    }
                } catch (JSONException e2) {
                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e2));
                }
            }
        }
    }

    public static void d(boolean z2) {
        com.transsion.athena.taaneh.aethna.c("setEnable isEnable = " + z2);
        u = z2;
    }

    public static JSONObject e() {
        return P;
    }

    public static void e(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (a(obj)) {
                N.put(str, obj);
            }
        } catch (JSONException e2) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e2));
        }
    }

    public static void e(boolean z2) {
        B = z2;
    }

    public static JSONObject f() {
        return O;
    }

    public static void f(boolean z2) {
        q = z2 ? "test" : "online";
    }

    public static String g() {
        return s;
    }

    public static synchronized JSONObject h() {
        JSONObject jSONObject;
        synchronized (ehanat.class) {
            jSONObject = L;
        }
        return jSONObject;
    }

    public static String i() {
        return a(false) + g;
    }

    public static int j() {
        return y;
    }

    public static int k() {
        return x;
    }

    public static JSONObject l() {
        return N;
    }

    public static String m() {
        return t;
    }

    public static long n() {
        return r;
    }

    public static String o() {
        return a(true) + i;
    }

    public static boolean p() {
        return v;
    }

    public static boolean q() {
        return p;
    }

    public static boolean r() {
        return u;
    }

    public static boolean s() {
        return B;
    }

    public static boolean t() {
        return TextUtils.equals(q, "online");
    }

    public static boolean u() {
        return w;
    }

    public static boolean v() {
        return TextUtils.equals(q, "test");
    }
}
