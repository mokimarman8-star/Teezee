package com.google.firebase.remoteconfig.internal;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class f {
    private static final Date h = new Date(0);
    private JSONObject a;
    private JSONObject b;
    private Date c;
    private JSONArray d;
    private JSONObject e;
    private long f;
    private JSONArray g;

    public static class b {
        private JSONObject a;
        private Date b;
        private JSONArray c;
        private JSONObject d;
        private long e;
        private JSONArray f;

        private b() {
            this.a = new JSONObject();
            this.b = f.h;
            this.c = new JSONArray();
            this.d = new JSONObject();
            this.e = 0L;
            this.f = new JSONArray();
        }

        public f a() {
            return new f(this.a, this.b, this.c, this.d, this.e, this.f);
        }

        public b b(JSONObject jSONObject) {
            try {
                this.a = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public b c(JSONArray jSONArray) {
            try {
                this.c = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public b d(Date date) {
            this.b = date;
            return this;
        }

        public b e(JSONObject jSONObject) {
            try {
                this.d = new JSONObject(jSONObject.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public b f(JSONArray jSONArray) {
            try {
                this.f = new JSONArray(jSONArray.toString());
            } catch (JSONException unused) {
            }
            return this;
        }

        public b g(long j) {
            this.e = j;
            return this;
        }
    }

    private f(JSONObject jSONObject, Date date, JSONArray jSONArray, JSONObject jSONObject2, long j, JSONArray jSONArray2) {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("configs_key", jSONObject);
        jSONObject3.put("fetch_time_key", date.getTime());
        jSONObject3.put("abt_experiments_key", jSONArray);
        jSONObject3.put("personalization_metadata_key", jSONObject2);
        jSONObject3.put("template_version_number_key", j);
        jSONObject3.put("rollout_metadata_key", jSONArray2);
        this.b = jSONObject;
        this.c = date;
        this.d = jSONArray;
        this.e = jSONObject2;
        this.f = j;
        this.g = jSONArray2;
        this.a = jSONObject3;
    }

    static f b(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("personalization_metadata_key");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONObject jSONObject2 = optJSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("rollout_metadata_key");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        return new f(jSONObject.getJSONObject("configs_key"), new Date(jSONObject.getLong("fetch_time_key")), jSONObject.getJSONArray("abt_experiments_key"), jSONObject2, jSONObject.optLong("template_version_number_key"), optJSONArray);
    }

    private Map c() {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < j().length(); i++) {
            JSONObject jSONObject = j().getJSONObject(i);
            String string = jSONObject.getString("rolloutId");
            String string2 = jSONObject.getString("variantId");
            JSONArray jSONArray = jSONObject.getJSONArray("affectedParameterKeys");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String string3 = jSONArray.getString(i2);
                if (!hashMap.containsKey(string3)) {
                    hashMap.put(string3, new HashMap());
                }
                Map map = (Map) hashMap.get(string3);
                if (map != null) {
                    map.put(string, string2);
                }
            }
        }
        return hashMap;
    }

    private static f d(JSONObject jSONObject) {
        return b(new JSONObject(jSONObject.toString()));
    }

    public static b l() {
        return new b();
    }

    public JSONArray e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            return this.a.toString().equals(((f) obj).toString());
        }
        return false;
    }

    public Set f(f fVar) {
        JSONObject g = d(fVar.a).g();
        Map c = c();
        Map c2 = fVar.c();
        HashSet hashSet = new HashSet();
        Iterator<String> keys = g().keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!fVar.g().has(next)) {
                hashSet.add(next);
            } else if (!g().get(next).equals(fVar.g().get(next))) {
                hashSet.add(next);
            } else if ((i().has(next) && !fVar.i().has(next)) || (!i().has(next) && fVar.i().has(next))) {
                hashSet.add(next);
            } else if (i().has(next) && fVar.i().has(next) && !i().getJSONObject(next).toString().equals(fVar.i().getJSONObject(next).toString())) {
                hashSet.add(next);
            } else if (c.containsKey(next) != c2.containsKey(next)) {
                hashSet.add(next);
            } else if (c.containsKey(next) && c2.containsKey(next) && !((Map) c.get(next)).equals(c2.get(next))) {
                hashSet.add(next);
            } else {
                g.remove(next);
            }
        }
        Iterator<String> keys2 = g.keys();
        while (keys2.hasNext()) {
            hashSet.add(keys2.next());
        }
        return hashSet;
    }

    public JSONObject g() {
        return this.b;
    }

    public Date h() {
        return this.c;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public JSONObject i() {
        return this.e;
    }

    public JSONArray j() {
        return this.g;
    }

    public long k() {
        return this.f;
    }

    public String toString() {
        return this.a.toString();
    }
}
