package ij;

import android.app.KeyguardManager;
import android.os.PowerManager;
import com.blankj.utilcode.util.Utils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class v {
    public static final v a = new v();

    private v() {
    }

    public final int a() {
        boolean c = c();
        boolean b = b();
        if (c) {
            return b ? 2 : 3;
        }
        return 1;
    }

    public final boolean b() {
        Object systemService = Utils.a().getSystemService("keyguard");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        KeyguardManager keyguardManager = (KeyguardManager) systemService;
        return keyguardManager.isDeviceLocked() || keyguardManager.isKeyguardLocked();
    }

    public final boolean c() {
        Object systemService = Utils.a().getSystemService("power");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        try {
            return ((PowerManager) systemService).isInteractive();
        } catch (Throwable unused) {
            return false;
        }
    }
}
