package com.bytedance.adsdk.ugeno.Sj;

import android.text.TextUtils;
import android.util.Pair;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.adsdk.ugeno.Sj.sP;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TKC {
    public static sP.Sj EjP(String str) {
        JSONArray Sj;
        if (TextUtils.isEmpty(str) || (Sj = com.bytedance.adsdk.ugeno.Jcg.sP.Sj(str, (JSONArray) null)) == null || Sj.length() != 2) {
            return null;
        }
        sP.Sj sj = new sP.Sj();
        sj.Sj = Sj.optString(0);
        sj.sP = Sj.optString(1);
        return sj;
    }

    public static int Sj(int i) {
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return 1;
        }
        return i - 1;
    }

    public static int Sj(String str) {
        int hashCode = str.hashCode();
        if (hashCode == -1408024454) {
            return str.equals("alternate") ? 2 : 1;
        }
        if (hashCode != -1039745817) {
            return 1;
        }
        str.equals("normal");
        return 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0035, code lost:
    
        if (r6.equals(com.cloud.tmc.integration.constants.IntegrationConstants.TAB_BAR_POSITION_TOP) == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int Sj(String str, int i) {
        char c = 2;
        int i2 = i / 2;
        if (TextUtils.isEmpty(str)) {
            return i2;
        }
        str.hashCode();
        switch (str.hashCode()) {
            case -1383228885:
                if (str.equals(IntegrationConstants.TAB_BAR_POSITION_DEFAULT)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 115029:
                break;
            case 3317767:
                if (str.equals("left")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 108511772:
                if (str.equals("right")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 4:
                return i;
            case 1:
                return i2;
            case 2:
            case 3:
                return 0;
            default:
                if (str.endsWith("%")) {
                    try {
                        return (int) ((i * Float.parseFloat(str.substring(0, str.length() - 1))) / 100.0f);
                    } catch (NumberFormatException unused) {
                        return i2;
                    }
                }
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException unused2) {
                    return i2;
                }
        }
    }

    public static sP Sj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        sP sPVar = new sP();
        sPVar.sP(jSONObject.optLong("delay"));
        sPVar.Sj(jSONObject.optLong("duration"));
        sPVar.Sj(jSONObject.optInt("playCount", 1));
        sPVar.Sj(jSONObject.optString("playDirection"));
        sPVar.Sj(EjP(jSONObject.optString("transformOrigin")));
        sPVar.sP(jSONObject.optString("timingFunction", "linear"));
        sPVar.Sj(jSONObject.optJSONObject("effect"));
        sPVar.Sj(Sj(jSONObject.optJSONArray("keyframes")));
        return sPVar;
    }

    public static Map<String, TreeMap<Float, String>> Sj(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                float optDouble = (float) optJSONObject.optDouble("offset");
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    TreeMap treeMap = (TreeMap) hashMap.get(next);
                    if (!TextUtils.equals(next, "offset")) {
                        if (!hashMap.containsKey(next) || treeMap == null) {
                            TreeMap treeMap2 = new TreeMap();
                            new Pair(Float.valueOf(optDouble), optJSONObject.optString(next));
                            treeMap2.put(Float.valueOf(optDouble), optJSONObject.optString(next));
                            hashMap.put(next, treeMap2);
                        } else {
                            treeMap.put(Float.valueOf(optDouble), optJSONObject.optString(next));
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public static float[] TKC(String str) {
        float[] fArr = {0.0f, 0.0f};
        JSONArray Sj = com.bytedance.adsdk.ugeno.Jcg.sP.Sj(str, (JSONArray) null);
        if (Sj != null && Sj.length() == 2) {
            fArr[0] = (float) Sj.optDouble(0);
            fArr[1] = (float) Sj.optDouble(1);
        }
        return fArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static Interpolator sP(String str) {
        char c;
        switch (str.hashCode()) {
            case -1965072618:
                if (str.equals("ease_in")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -787702915:
                if (str.equals("ease_out")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1065009829:
                if (str.equals("ease_in_out")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        return c != 0 ? c != 1 ? c != 2 ? new LinearInterpolator() : new DecelerateInterpolator() : new AccelerateDecelerateInterpolator() : new AccelerateInterpolator();
    }
}
