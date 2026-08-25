package zk;

import com.transsion.mb.config.manager.ConfigBean;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final boolean a() {
        String value;
        ConfigBean c = cm.f.c.a().c("app_center_switch", true);
        if (c != null && (value = c.getValue()) != null) {
            try {
                return new JSONObject(value).optBoolean("app_center_off");
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}
