package com.bytedance.sdk.component.Sj;

import com.cloud.tmc.integration.MiniAppConfigHelper;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class Dq {
    private aa Sj;

    private Dq(aa aaVar) {
        this.Sj = aaVar;
    }

    static Dq Sj(aa aaVar) {
        return new Dq(aaVar);
    }

    private static void Sj(String str) {
        if (str.startsWith("{") && str.endsWith("}")) {
            return;
        }
        uA.Sj(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(str)));
    }

    <T> T Sj(String str, Type type) throws JSONException {
        Sj(str);
        return (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) ? (T) new JSONObject(str) : (T) this.Sj.Sj(str, type);
    }

    <T> String Sj(T t) {
        if (t == null) {
            return MiniAppConfigHelper.DEFAULT_KEY_CORS_LIST;
        }
        String obj = ((t instanceof JSONObject) || (t instanceof JSONArray)) ? t.toString() : this.Sj.Sj(t);
        Sj(obj);
        return obj;
    }
}
