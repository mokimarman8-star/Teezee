package xe;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class d {
    public static void a(String str) {
        if (ue.b.a.booleanValue()) {
            TextUtils.isEmpty(str);
        }
    }

    public static void b(String str, Exception exc) {
        if ((!ue.b.a.booleanValue() || TextUtils.isEmpty(str)) && exc == null) {
            return;
        }
        Log.e("OMIDLIB", str, exc);
    }
}
