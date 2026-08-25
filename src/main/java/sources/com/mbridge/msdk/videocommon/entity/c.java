package com.mbridge.msdk.videocommon.entity;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class c {
    private String a;
    private int b;

    public c(String str, int i) {
        this.a = str;
        this.b = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c A[Catch: Exception -> 0x0015, TRY_LEAVE, TryCatch #0 {Exception -> 0x0015, blocks: (B:3:0x0001, B:5:0x000f, B:8:0x002c, B:14:0x0019, B:16:0x001f), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(String str) {
        c cVar;
        c cVar2 = null;
        try {
            com.mbridge.msdk.videocommon.setting.a c = com.mbridge.msdk.videocommon.setting.b.b().c();
            if (!TextUtils.isEmpty(str)) {
                if (c != null && c.g() != null) {
                    cVar = c.g().get(str);
                }
                return cVar2 != null ? b() : cVar2;
            }
            cVar = b();
            cVar2 = cVar;
            if (cVar2 != null) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static c a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String optString = jSONObject.optString(RewardPlus.NAME);
            int optInt = jSONObject.optInt(RewardPlus.AMOUNT);
            jSONObject.optString("id");
            return new c(optString, optInt);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, c> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                hashMap.put(optJSONObject.optString("id"), new c(optJSONObject.optString(RewardPlus.NAME), optJSONObject.optInt(RewardPlus.AMOUNT)));
            }
            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static c b() {
        return new c("Virtual Item", 1);
    }

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.a;
    }

    public String toString() {
        return "Reward{name='" + this.a + "', amount=" + this.b + '}';
    }
}
