package rb;

import android.os.Bundle;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import org.json.JSONException;
import org.json.JSONObject;
import qb.g;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class d implements b, sb.b {
    private sb.a a;

    private static String b(String str, Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put(RewardPlus.NAME, str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // sb.b
    public void a(sb.a aVar) {
        this.a = aVar;
        g.f().b("Registered Firebase Analytics event receiver for breadcrumbs");
    }

    @Override // rb.b
    public void c(String str, Bundle bundle) {
        sb.a aVar = this.a;
        if (aVar != null) {
            try {
                aVar.a("$A$:" + b(str, bundle));
            } catch (JSONException unused) {
                g.f().k("Unable to serialize Firebase Analytics event to breadcrumb.");
            }
        }
    }
}
