package bf;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class c {
    public static b a(File file) {
        Map b = b(file);
        if (b == null) {
            return null;
        }
        String str = (String) b.get("channel");
        b.remove("channel");
        return new b(str, b);
    }

    public static Map b(File file) {
        try {
            String c = c(file);
            if (c == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(c);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, jSONObject.getString(obj));
            }
            return hashMap;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(File file) {
        return e.d(file, 1903654775);
    }
}
