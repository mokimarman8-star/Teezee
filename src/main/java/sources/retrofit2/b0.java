package retrofit2;

import android.os.Build;
import java.util.concurrent.Executor;
import retrofit2.c;
import retrofit2.d0;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
abstract class b0 {
    static final Executor a;
    static final d0 b;
    static final c c;

    static {
        String property = System.getProperty("java.vm.name");
        property.hashCode();
        if (property.equals("RoboVM")) {
            a = null;
            b = new d0();
            c = new c();
        } else {
            if (!property.equals("Dalvik")) {
                a = null;
                b = new d0.b();
                c = new c.a();
                return;
            }
            a = new a();
            if (Build.VERSION.SDK_INT >= 24) {
                b = new d0.a();
                c = new c.a();
            } else {
                b = new d0();
                c = new c();
            }
        }
    }
}
