package com.bytedance.adsdk.ugeno.core;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class HiB {
    private JSONObject EjP;
    private String HiB;
    private boolean Jcg;
    private JSONObject Sj;
    private String TKC;
    private JSONObject sP;
    private JSONObject vS;

    public static class Sj {
        private String Dq;
        private JSONObject EjP;
        private List<Sj> HiB;
        private String Jcg;
        private String Sj;
        private JSONObject TKC;
        private String sP;
        private Sj vS;

        public JSONObject EjP() {
            return this.TKC;
        }

        public List<Sj> HiB() {
            return this.HiB;
        }

        public String Sj() {
            return this.Sj;
        }

        public void Sj(Sj sj) {
            if (this.HiB == null) {
                this.HiB = new ArrayList();
            }
            this.HiB.add(sj);
        }

        public void Sj(String str) {
            this.sP = str;
        }

        public String TKC() {
            return this.sP;
        }

        public String sP() {
            return this.Jcg;
        }

        public String toString() {
            return "UGNode{id='" + this.Sj + "', name='" + this.sP + "'}";
        }

        public JSONObject vS() {
            return this.EjP;
        }
    }

    public HiB(JSONObject jSONObject, JSONObject jSONObject2) {
        this(jSONObject, jSONObject2, null);
    }

    public HiB(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (jSONObject != null) {
            if (jSONObject.has("body")) {
                this.Sj = jSONObject.optJSONObject("body");
            } else {
                this.Sj = jSONObject.optJSONObject("main_template");
            }
            this.sP = jSONObject.optJSONObject("sub_templates");
            JSONObject optJSONObject = jSONObject.has("meta") ? jSONObject.optJSONObject("meta") : jSONObject.optJSONObject("template_info");
            if (optJSONObject != null) {
                if (jSONObject.has("body")) {
                    this.Jcg = true;
                    String optString = optJSONObject.optString("version");
                    this.TKC = optString;
                    if (TextUtils.isEmpty(optString)) {
                        this.TKC = "3.0";
                    }
                } else {
                    this.TKC = optJSONObject.optString("sdk_version");
                }
                if (optJSONObject.has("adType")) {
                    this.HiB = optJSONObject.optString("adType");
                }
            } else if (jSONObject.has("body")) {
                this.TKC = "3.0";
                this.Jcg = true;
            }
            this.EjP = jSONObject2;
            this.vS = jSONObject3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Sj Sj(JSONObject jSONObject, Sj sj) {
        Sj Sj2;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.has("type") ? jSONObject.optString("type") : jSONObject.optString("name");
        String optString2 = jSONObject.optString("id");
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.equals(next, "children")) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException unused) {
                }
            }
        }
        Sj sj2 = new Sj();
        sj2.Sj = optString2;
        if (this.Jcg && TextUtils.equals("Video", optString)) {
            sj2.sP = optString + "V3";
        } else {
            sj2.sP = optString;
        }
        sj2.TKC = jSONObject2;
        sj2.vS = sj;
        sj2.Jcg = this.TKC;
        sj2.Dq = this.HiB;
        if (jSONObject2.has("i18n")) {
            sj2.EjP = jSONObject2.optJSONObject("i18n");
        }
        if (TextUtils.equals(optString, "CustomComponent")) {
            Sj(jSONObject, sj2.TKC);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                String optString3 = jSONObject.has("type") ? jSONObject.optString("type") : jSONObject.optString("name");
                String Sj3 = com.bytedance.adsdk.ugeno.TKC.sP.Sj(optJSONObject.optString("id"), this.EjP);
                if (TextUtils.equals(optString3, "Template")) {
                    JSONObject jSONObject3 = this.sP;
                    if (jSONObject3 != null) {
                        optJSONObject = jSONObject3.optJSONObject(Sj3);
                    } else {
                        Sj2 = null;
                        if (Sj2 == null) {
                            sj2.Sj(Sj2);
                        }
                    }
                }
                Sj2 = Sj(optJSONObject, sj2);
                if (Sj2 == null) {
                }
            }
        }
        return sj2;
    }

    private void Sj(JSONObject jSONObject, JSONObject jSONObject2) {
        if (this.vS == null || jSONObject2 == null) {
            return;
        }
        try {
            String optString = this.vS.optString(jSONObject2.optString("targetId"));
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject(optString);
            JSONObject optJSONObject = jSONObject2.optJSONObject("targetProps");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = optJSONObject.opt(next);
                    if (!TextUtils.equals(next, "events") || !jSONObject3.has("events")) {
                        jSONObject3.put(next, opt);
                    } else if (opt instanceof JSONArray) {
                        com.bytedance.adsdk.ugeno.Jcg.sP.Sj(jSONObject3.optJSONArray("events"), (JSONArray) opt);
                    }
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("children");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                optJSONArray.put(jSONObject3);
                if (jSONObject.has("children")) {
                    return;
                }
                jSONObject.put("children", optJSONArray);
            }
        } catch (JSONException unused) {
        }
    }

    public static boolean Sj(Sj sj) {
        return (sj == null || sj.TKC == null) ? false : true;
    }

    public boolean EjP() {
        return this.Jcg;
    }

    public Sj Sj() {
        return Sj(this.Sj, (Sj) null);
    }

    public List<Sj> TKC() {
        if (this.sP == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = this.sP.keys();
        while (keys.hasNext()) {
            Sj Sj2 = Sj(this.sP.optJSONObject(keys.next()), (Sj) null);
            if (Sj2 != null) {
                arrayList.add(Sj2);
            }
        }
        return arrayList;
    }

    public String sP() {
        return this.TKC;
    }
}
