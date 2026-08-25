package com.mbridge.msdk.foundation.controller;

import android.util.Log;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class b {
    private HashMap<String, com.mbridge.msdk.foundation.cache.d> a;

    /* renamed from: com.mbridge.msdk.foundation.controller.b$b, reason: collision with other inner class name */
    static class C0078b {
        static b a = new b();
    }

    private b() {
        this.a = new HashMap<>();
    }

    public static b a() {
        return C0078b.a;
    }

    public com.mbridge.msdk.foundation.cache.d a(String str, JSONArray jSONArray) {
        if (this.a == null) {
            this.a = new HashMap<>();
        }
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        com.mbridge.msdk.foundation.cache.d dVar = new com.mbridge.msdk.foundation.cache.d(str, jSONArray);
        this.a.put(str, dVar);
        return dVar;
    }

    public com.mbridge.msdk.foundation.cache.d b(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        Exception e;
        if (this.a == null) {
            this.a = new HashMap<>();
        }
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        if (jSONArray == null) {
            try {
                jSONArray2 = new JSONArray();
            } catch (Exception e2) {
                jSONArray2 = jSONArray;
                e = e2;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("c_cb", 0);
                jSONObject.put("t_disc", 0.95d);
                jSONObject.put("u_disc", 0.95d);
                jSONObject.put("max_ecppv_diff", 0);
                jSONObject.put("max_cache_num", 20);
                jSONObject.put("max_usage_limit", 10);
                jSONObject.put("time_interval", 7200);
                jSONArray2.put(jSONObject);
            } catch (Exception e3) {
                e = e3;
                Log.e("CandidateController", e.getMessage());
                jSONArray = jSONArray2;
                return a(str, jSONArray);
            }
            jSONArray = jSONArray2;
        }
        return a(str, jSONArray);
    }
}
