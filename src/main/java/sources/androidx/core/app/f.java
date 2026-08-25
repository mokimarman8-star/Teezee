package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class f {
    public static IBinder a(Bundle bundle, String str) {
        return bundle.getBinder(str);
    }

    public static void b(Bundle bundle, String str, IBinder iBinder) {
        bundle.putBinder(str, iBinder);
    }
}
