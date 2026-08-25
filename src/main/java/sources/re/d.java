package re;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class d {
    public static void a(String str) {
        if (oe.c.a.booleanValue()) {
            TextUtils.isEmpty(str);
        }
    }

    public static void b(String str, Exception exc) {
        if ((!oe.c.a.booleanValue() || TextUtils.isEmpty(str)) && exc == null) {
            return;
        }
        Log.e("OMIDLIB", str, exc);
    }
}
