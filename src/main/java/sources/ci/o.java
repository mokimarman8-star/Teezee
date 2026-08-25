package ci;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class o {
    public static final o a = new o();

    private o() {
    }

    public final boolean a(Context context) {
        Intrinsics.h(context, "context");
        Object systemService = context.getSystemService("power");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isInteractive();
    }

    public final boolean b(Context context) {
        Intrinsics.h(context, "context");
        Object systemService = context.getSystemService("keyguard");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        KeyguardManager keyguardManager = (KeyguardManager) systemService;
        return keyguardManager.isDeviceLocked() || keyguardManager.isKeyguardLocked();
    }
}
