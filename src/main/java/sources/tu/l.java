package tu;

import android.os.Bundle;
import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class l {
    public static /* synthetic */ void a(int i, int i2, String str, String str2, int i3) {
        if ((i3 & 4) != 0) {
            str = null;
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        b(i, i2, str, str2, com.transsion.upgradesdk.bean.c.b);
    }

    public static void b(int i, int i2, String str, String str2, com.transsion.upgradesdk.bean.c customType) {
        Intrinsics.h(customType, "customType");
        Bundle bundle = new Bundle();
        bundle.putInt("t", i);
        if (i2 > 0) {
            bundle.putInt("s", i2);
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("c", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString("m", str2);
        }
        int i3 = customType.a;
        if (i3 > 0) {
            bundle.putInt("customType", i3);
        }
        g("ps_upgrade_sdk_event", bundle);
    }

    public static void c(int i, int i2, String str, String str2, com.transsion.upgradesdk.bean.c customType, Boolean bool, Boolean bool2, int i3) {
        if ((i3 & 4) != 0) {
            str = null;
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        if ((i3 & 16) != 0) {
            customType = com.transsion.upgradesdk.bean.c.b;
        }
        if ((i3 & 32) != 0) {
            bool = null;
        }
        if ((i3 & 64) != 0) {
            bool2 = null;
        }
        Intrinsics.h(customType, "customType");
        Bundle bundle = new Bundle();
        bundle.putInt("t", i);
        if (i2 > 0) {
            bundle.putInt("s", i2);
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("c", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString("m", str2);
        }
        if (bool2 != null) {
            bundle.putBoolean("show", bool2.booleanValue());
        }
        if (bool != null) {
            bundle.putBoolean("f", bool.booleanValue());
        }
        int i4 = customType.a;
        if (i4 > 0) {
            bundle.putInt("customType", i4);
        }
        g("ps_upgrade_report_event", bundle);
    }

    public static void d(int i, boolean z, com.transsion.upgradesdk.bean.c customType) {
        Intrinsics.h(customType, "customType");
        Bundle bundle = new Bundle();
        bundle.putString("value", "R_USK_X_X");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", i);
            jSONObject.put("isManual", z);
            jSONObject.put("customType", customType.a);
            bundle.putString("extraValue", jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        g("ps_common_exposure", bundle);
    }

    public static void e(int i, boolean z, String str, com.transsion.upgradesdk.bean.c customType) {
        Intrinsics.h(customType, "customType");
        Bundle bundle = new Bundle();
        bundle.putString("value", "R_USK_X_X");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", i);
            jSONObject.put("isManual", z);
            jSONObject.put("customType", customType.a);
            bundle.putString("extraValue", jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        bundle.putString("buttonType", str);
        g("ps_common_click", bundle);
    }

    public static final void f(String eventName, int i, Bundle bundle) {
        Intrinsics.h(eventName, "$eventName");
        Intrinsics.h(bundle, "$bundle");
        new hi.a(eventName, i).c(bundle, (Bundle) null).b();
    }

    public static void g(final String str, final Bundle bundle) {
        final int i = 1044;
        e.a.execute(new Runnable() { // from class: tu.k
            @Override // java.lang.Runnable
            public final void run() {
                l.f(str, i, bundle);
            }
        });
    }
}
