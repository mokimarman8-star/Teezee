package tb;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class i {
    public static final dc.a a = new fc.d().j(a.a).i();

    static i a(String str) {
        JSONObject jSONObject = new JSONObject(str);
        return b(jSONObject.getString("rolloutId"), jSONObject.getString("parameterKey"), jSONObject.getString("parameterValue"), jSONObject.getString("variantId"), jSONObject.getLong("templateVersion"));
    }

    public static i b(String str, String str2, String str3, String str4, long j) {
        return new b(str, str2, i(str3), str4, j);
    }

    private static String i(String str) {
        return str.length() > 256 ? str.substring(0, 256) : str;
    }

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract long f();

    public abstract String g();

    public CrashlyticsReport$e.d.e h() {
        return CrashlyticsReport$e.d.e.a().d(CrashlyticsReport$e.d.e.b.a().c(g()).b(e()).a()).b(c()).c(d()).e(f()).a();
    }
}
