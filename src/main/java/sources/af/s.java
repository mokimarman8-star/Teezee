package af;

import android.os.Looper;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class s {
    public static void a() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Must be called from the main thread.");
        }
    }
}
