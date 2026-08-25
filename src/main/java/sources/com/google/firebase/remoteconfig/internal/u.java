package com.google.firebase.remoteconfig.internal;

import android.os.Bundle;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class u {
    private final kc.b a;
    private final Map b = Collections.synchronizedMap(new HashMap());

    public u(kc.b bVar) {
        this.a = bVar;
    }

    public void a(String str, f fVar) {
        JSONObject optJSONObject;
        mb.a aVar = (mb.a) this.a.get();
        if (aVar == null) {
            return;
        }
        JSONObject i = fVar.i();
        if (i.length() < 1) {
            return;
        }
        JSONObject g = fVar.g();
        if (g.length() >= 1 && (optJSONObject = i.optJSONObject(str)) != null) {
            String optString = optJSONObject.optString("choiceId");
            if (optString.isEmpty()) {
                return;
            }
            synchronized (this.b) {
                try {
                    if (optString.equals(this.b.get(str))) {
                        return;
                    }
                    this.b.put(str, optString);
                    Bundle bundle = new Bundle();
                    bundle.putString("arm_key", str);
                    bundle.putString("arm_value", g.optString(str));
                    bundle.putString("personalization_id", optJSONObject.optString("personalizationId"));
                    bundle.putInt("arm_index", optJSONObject.optInt("armIndex", -1));
                    bundle.putString("group", optJSONObject.optString("group"));
                    aVar.a("fp", "personalization_assignment", bundle);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_fpid", optString);
                    aVar.a("fp", "_fpc", bundle2);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
