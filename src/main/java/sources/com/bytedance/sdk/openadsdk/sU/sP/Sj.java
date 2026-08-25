package com.bytedance.sdk.openadsdk.sU.sP;

import android.text.TextUtils;
import com.cloud.tmc.integration.params.TmcStartParams;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj {
    private String Sj;
    private List<C0115Sj> TKC;
    private List<C0115Sj> sP;

    /* renamed from: com.bytedance.sdk.openadsdk.sU.sP.Sj$Sj, reason: collision with other inner class name */
    public static class C0115Sj {
        private String Sj;
        private int TKC;
        private String sP;

        public static C0115Sj Sj(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            C0115Sj c0115Sj = new C0115Sj();
            c0115Sj.Sj = jSONObject.optString(TmcStartParams.KEY_URL);
            c0115Sj.sP = jSONObject.optString("md5");
            c0115Sj.TKC = jSONObject.optInt("type");
            return c0115Sj;
        }

        public String Sj() {
            return this.Sj;
        }

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof C0115Sj)) {
                return super.equals(obj);
            }
            String str2 = this.Sj;
            if (str2 != null) {
                C0115Sj c0115Sj = (C0115Sj) obj;
                if (str2.equals(c0115Sj.Sj) && (str = this.sP) != null && str.equals(c0115Sj.sP)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static Sj sP(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Sj sj = new Sj();
            sj.Sj(jSONObject.optString("version"));
            JSONArray optJSONArray = jSONObject.optJSONArray("resources");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    C0115Sj Sj = C0115Sj.Sj(optJSONArray.optJSONObject(i));
                    if (Sj != null) {
                        if (Sj.TKC == 1) {
                            arrayList.add(Sj);
                        } else if (Sj.TKC == 2 && arrayList2.size() < 10) {
                            arrayList2.add(Sj);
                        }
                    }
                }
            }
            sj.Sj(arrayList);
            sj.sP(arrayList2);
            return sj;
        } catch (JSONException unused) {
            return null;
        }
    }

    public String Sj() {
        return this.Sj;
    }

    public void Sj(String str) {
        this.Sj = str;
    }

    public void Sj(List<C0115Sj> list) {
        this.sP = list;
    }

    public List<C0115Sj> TKC() {
        return this.TKC;
    }

    public List<C0115Sj> sP() {
        return this.sP;
    }

    public void sP(List<C0115Sj> list) {
        this.TKC = list;
    }
}
