package androidx.media3.common.util;

import android.os.Trace;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class q0 {
    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
