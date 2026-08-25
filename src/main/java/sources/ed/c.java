package ed;

import android.os.Trace;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class c {
    public static void a() {
        Trace.endSection();
    }

    public static void b(String str) {
        Trace.beginSection(str);
    }
}
