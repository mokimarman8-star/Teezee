package com.facebook.biddingkit.logging;

import android.content.Context;
import android.os.Build;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
abstract class a {
    private static final AtomicReference a = new AtomicReference();

    protected static JSONObject a() {
        Map map = (Map) a.get();
        JSONObject jSONObject = new JSONObject();
        if (map == null) {
            return jSONObject;
        }
        try {
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            b.d("BiddingStaticEnvironmentData", "Failed to create json data", e);
        }
        return jSONObject;
    }

    protected static void b(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("bundle", context.getPackageName());
        hashMap.put("idfa", str);
        hashMap.put("device_make", Build.MANUFACTURER);
        hashMap.put("device_model", Build.MODEL);
        hashMap.put("os", "Android");
        hashMap.put("os_version", Build.VERSION.RELEASE);
        hashMap.put("bidding_kit_version", str2);
        a.set(hashMap);
    }
}
