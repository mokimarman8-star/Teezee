package com.bytedance.sdk.component.adexpress.dynamic.EjP;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class EjP {
    public String EjP;
    public List<Sj> Sj;
    public String TKC;
    public String sP;

    public static class Sj {
        public int Sj;
        public JSONObject sP;
    }

    public static EjP Sj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        EjP ejP = new EjP();
        String optString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(optString);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    Sj sj = new Sj();
                    sj.Sj = optJSONObject.optInt("id");
                    sj.sP = new JSONObject(optJSONObject.optString("componentLayout"));
                    arrayList.add(sj);
                }
            }
        } catch (JSONException unused) {
        }
        ejP.Sj = arrayList;
        ejP.sP = jSONObject.optString("diff_data");
        ejP.TKC = jSONObject.optString("style_diff");
        ejP.EjP = jSONObject.optString("tag_diff");
        return ejP;
    }
}
