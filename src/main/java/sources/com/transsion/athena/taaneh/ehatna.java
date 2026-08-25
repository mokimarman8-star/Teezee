package com.transsion.athena.taaneh;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.gslb.BuildConfig;
import com.transsion.push.PushConstants;
import com.transsion.sdk.oneid.OneID;
import java.util.UUID;
import m4.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class ehatna {
    private static String a = "";
    private static boolean b;

    public static String a() {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        if (OneID.f()) {
            aethna.a("OneID isEnable = true");
            a = b ? OneID.e().b() : BuildConfig.FLAVOR;
        }
        return a;
    }

    private static void a(Context context) {
        if (TextUtils.isEmpty(a)) {
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    if (!TextUtils.isEmpty(string)) {
                        a = UUID.nameUUIDFromBytes((context.getPackageName() + string).getBytes()).toString();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (TextUtils.isEmpty(a)) {
                a = UUID.randomUUID().toString();
            }
            try {
                b.b(context).c(PushConstants.PROVIDER_VAID, a);
            } catch (Exception e2) {
                aethna.b(Log.getStackTraceString(e2));
            }
        }
    }

    public static void a(Context context, int i, int i2) {
        try {
            OneID.d(context, i, i2);
            b = true;
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
        }
    }

    public static String b(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            aethna.b(Log.getStackTraceString(e));
            a(context);
        }
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        if (OneID.f()) {
            aethna.a("OneID isEnable = true");
            a = b ? OneID.e().b() : BuildConfig.FLAVOR;
        }
        if (TextUtils.isEmpty(a)) {
            a = b.b(context).a(PushConstants.PROVIDER_VAID);
            a(context);
        }
        aethna.a("*******************/ vaid cost : " + (System.currentTimeMillis() - currentTimeMillis) + " /*******************");
        return a;
    }
}
