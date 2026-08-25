package ci;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j {
    public static final j a = new j();

    private j() {
    }

    private final void a(JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object opt = jSONArray.opt(i);
            if (opt instanceof String) {
                String str = (String) opt;
                if (e(str)) {
                    JSONObject jSONObject = new JSONObject(str);
                    b(jSONObject);
                    jSONArray.put(i, jSONObject);
                } else if (d(str)) {
                    JSONArray jSONArray2 = new JSONArray(str);
                    a(jSONArray2);
                    jSONArray.put(i, jSONArray2);
                }
            } else if (opt instanceof JSONObject) {
                b((JSONObject) opt);
            } else if (opt instanceof JSONArray) {
                a((JSONArray) opt);
            }
        }
    }

    private final void b(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt instanceof String) {
                String str = (String) opt;
                if (e(str)) {
                    JSONObject jSONObject2 = new JSONObject(str);
                    b(jSONObject2);
                    jSONObject.put(next, jSONObject2);
                } else if (d(str)) {
                    JSONArray jSONArray = new JSONArray(str);
                    a(jSONArray);
                    jSONObject.put(next, jSONArray);
                }
            } else if (opt instanceof JSONObject) {
                b((JSONObject) opt);
            } else if (opt instanceof JSONArray) {
                a((JSONArray) opt);
            }
        }
    }

    private final boolean d(String str) {
        try {
            new JSONArray(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private final boolean e(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final String c(String str, int i) {
        String str2;
        Intrinsics.h(str, "jsonString");
        try {
            if (StringsKt.W(StringsKt.n1(str).toString(), "{", false, 2, (Object) null)) {
                JSONObject jSONObject = new JSONObject(str);
                b(jSONObject);
                str2 = jSONObject.toString(i);
            } else if (StringsKt.W(StringsKt.n1(str).toString(), "[", false, 2, (Object) null)) {
                JSONArray jSONArray = new JSONArray(str);
                a(jSONArray);
                str2 = jSONArray.toString(i);
            } else {
                str2 = str;
            }
            Intrinsics.e(str2);
            return str2;
        } catch (JSONException unused) {
            return str;
        }
    }
}
