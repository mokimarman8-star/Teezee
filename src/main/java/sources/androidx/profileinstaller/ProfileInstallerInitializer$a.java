package androidx.profileinstaller;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: Access modifiers changed from: private */
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class ProfileInstallerInitializer$a {
    public static Handler a(Looper looper) {
        Handler createAsync;
        createAsync = Handler.createAsync(looper);
        return createAsync;
    }
}
