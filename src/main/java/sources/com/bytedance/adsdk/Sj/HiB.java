package com.bytedance.adsdk.Sj;

import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class HiB implements vS {
    @Override // com.bytedance.adsdk.Sj.vS
    /* renamed from: sP, reason: merged with bridge method [inline-methods] */
    public Boolean Sj(JSONObject jSONObject, Object[] objArr) {
        if (objArr == null || objArr.length <= 0) {
            return Boolean.FALSE;
        }
        try {
            Double.parseDouble(String.valueOf(objArr[0]));
            return Boolean.TRUE;
        } catch (NumberFormatException unused) {
            return Boolean.FALSE;
        }
    }
}
