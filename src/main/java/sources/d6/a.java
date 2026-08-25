package d6;

import org.json.JSONObject;
import z5.b;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class a {
    private static b a = null;
    public static int b = 10;
    public static int c = 10;
    public static int d = 10;
    public static int e = 10;

    public static int a() {
        return d;
    }

    public static int b() {
        return e;
    }

    public static void c() {
        b bVar = a;
        if (bVar != null) {
            bVar.EjP();
        }
    }

    public static void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            b = jSONObject.optInt("splash", 10);
            c = jSONObject.optInt("reward", 10);
            d = jSONObject.optInt("brand", 10);
            int optInt = jSONObject.optInt("other", 10);
            e = optInt;
            if (b < 0) {
                b = 10;
            }
            if (c < 0) {
                c = 10;
            }
            if (d < 0) {
                d = 10;
            }
            if (optInt < 0) {
                e = 10;
            }
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static void e(b bVar) {
        a = bVar;
    }

    public static int f() {
        return c;
    }

    public static int g() {
        return b;
    }
}
