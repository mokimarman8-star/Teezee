package com.mbridge.msdk.foundation.tools;

import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class b0 {
    public static String a(int i, int i2, int i3, int i4, int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                jSONObject.put(TrackingKey.CODE, 0);
                jSONObject.put(TrackingKey.MESSAGE, "Success");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("rotateAngle", i);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(TtmlNode.LEFT, i2);
                jSONObject3.put(TtmlNode.RIGHT, i3);
                jSONObject3.put("top", i4);
                jSONObject3.put("bottom", i5);
                jSONObject2.put("cutoutInfo", jSONObject3);
                jSONObject.put("data", jSONObject2);
            } catch (Exception e) {
                o0.b("JSONUtils", e.getMessage());
            }
        } catch (Throwable th) {
            o0.b("JSONUtils", th.getMessage());
            try {
                jSONObject.put(TrackingKey.CODE, 1);
                jSONObject.put(TrackingKey.MESSAGE, "Fail");
            } catch (JSONException e2) {
                o0.b("JSONUtils", e2.getMessage());
            }
        }
        return jSONObject.toString();
    }

    public static ArrayList<String> a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int length = jSONArray.length();
        ArrayList<String> arrayList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(jSONArray.optString(i));
        }
        return arrayList;
    }
}
