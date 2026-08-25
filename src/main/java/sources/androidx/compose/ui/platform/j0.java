package androidx.compose.ui.platform;

import android.os.Looper;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class j0 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
