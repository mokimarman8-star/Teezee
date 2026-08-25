package e4;

import android.os.Trace;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class b {
    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
