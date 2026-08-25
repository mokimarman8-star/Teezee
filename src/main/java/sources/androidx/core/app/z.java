package androidx.core.app;

import android.app.Service;
import android.os.Build;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class z {

    static class a {
        static void a(Service service, int i5) {
            service.stopForeground(i5);
        }
    }

    public static void a(Service service, int i5) {
        if (Build.VERSION.SDK_INT >= 24) {
            a.a(service, i5);
        } else {
            service.stopForeground((i5 & 1) != 0);
        }
    }
}
