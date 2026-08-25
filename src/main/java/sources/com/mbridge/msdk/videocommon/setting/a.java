package com.mbridge.msdk.videocommon.setting;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    private Map<String, Integer> a;
    private Map<String, com.mbridge.msdk.videocommon.entity.c> b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private String j;
    private int i = 0;
    private String k = TtmlNode.ANONYMOUS_REGION_ID;
    private String l = TtmlNode.ANONYMOUS_REGION_ID;

    public static a a(String str) {
        a aVar;
        a aVar2 = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                aVar = new a();
            } catch (Exception e) {
                e = e;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject optJSONObject = jSONObject.optJSONObject("caplist");
                aVar.b(jSONObject.optString("ab_id", TtmlNode.ANONYMOUS_REGION_ID));
                aVar.c(jSONObject.optString("rid", TtmlNode.ANONYMOUS_REGION_ID));
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys != null && keys.hasNext()) {
                        String next = keys.next();
                        int optInt = optJSONObject.optInt(next, 1000);
                        if (!TextUtils.isEmpty(next)) {
                            if (TextUtils.isEmpty(next) || optInt != 0) {
                                hashMap.put(next, Integer.valueOf(optInt));
                            } else {
                                hashMap.put(next, 1000);
                            }
                        }
                    }
                    aVar.a(hashMap);
                }
                aVar.b(com.mbridge.msdk.videocommon.entity.c.a(jSONObject.optJSONArray("reward")));
                aVar.c(jSONObject.optLong("getpf", 43200L));
                aVar.e(jSONObject.optLong("ruct", 5400L));
                aVar.d(jSONObject.optLong(CampaignEx.JSON_KEY_PLCT, 3600L));
                aVar.b(jSONObject.optLong("dlct", 3600L));
                aVar.f(jSONObject.optLong("vcct", 5L));
                aVar.a(jSONObject.optLong("current_time"));
                aVar.d(jSONObject.optString("vtag", TtmlNode.ANONYMOUS_REGION_ID));
                return aVar;
            } catch (Exception e2) {
                e = e2;
                aVar2 = aVar;
                e.printStackTrace();
                return aVar2;
            }
        }
        return aVar2;
    }

    public String a() {
        return this.j;
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(long j) {
        this.h = j;
    }

    public void a(Map<String, Integer> map) {
        this.a = map;
    }

    public long b() {
        return this.h;
    }

    public void b(long j) {
        this.f = j;
    }

    public void b(String str) {
        this.j = str;
    }

    public void b(Map<String, com.mbridge.msdk.videocommon.entity.c> map) {
        this.b = map;
    }

    public long c() {
        return this.f;
    }

    public void c(long j) {
        this.c = j;
    }

    public void c(String str) {
        this.l = str;
    }

    public long d() {
        return this.c * 1000;
    }

    public void d(long j) {
        this.e = j;
    }

    public void d(String str) {
        this.k = str;
    }

    public long e() {
        return this.e * 1000;
    }

    public void e(long j) {
        this.d = j;
    }

    public String f() {
        return this.l;
    }

    public void f(long j) {
        this.g = j;
    }

    public Map<String, com.mbridge.msdk.videocommon.entity.c> g() {
        return this.b;
    }

    public long h() {
        return this.d * 1000;
    }

    public long i() {
        return this.g;
    }

    public String j() {
        return this.k;
    }

    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            Map<String, Integer> map = this.a;
            if (map != null && map.size() > 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, Integer> entry : this.a.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue().intValue());
                    }
                    jSONObject.put("caplist", jSONObject2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Map<String, com.mbridge.msdk.videocommon.entity.c> map2 = this.b;
            if (map2 != null && map2.size() > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, com.mbridge.msdk.videocommon.entity.c> entry2 : this.b.entrySet()) {
                        JSONObject jSONObject3 = new JSONObject();
                        String key = entry2.getKey();
                        com.mbridge.msdk.videocommon.entity.c value = entry2.getValue();
                        if (value != null) {
                            jSONObject3.put(RewardPlus.NAME, value.c());
                            jSONObject3.put(RewardPlus.AMOUNT, value.a());
                            jSONObject3.put("id", key);
                        }
                        jSONArray.put(jSONObject3);
                    }
                    jSONObject.put("reward", jSONArray);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            jSONObject.put("getpf", this.c);
            jSONObject.put("ruct", this.d);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.e);
            jSONObject.put("dlct", this.f);
            jSONObject.put("vcct", this.g);
            jSONObject.put("current_time", this.h);
            jSONObject.put("vtag", this.k);
            jSONObject.put("isDefault", this.i);
            return jSONObject;
        } catch (Exception e3) {
            e3.printStackTrace();
            return jSONObject;
        }
    }
}
