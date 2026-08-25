package hn;

import com.transsion.gslb.BuildConfig;
import com.transsion.player.config.RenderType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final b a = new b();
    private static d b;

    private b() {
    }

    public final d a() {
        if (b == null) {
            b = new d(RenderType.SURFACE_VIEW, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, BuildConfig.FLAVOR, 65534, null);
        }
        d dVar = b;
        Intrinsics.e(dVar);
        return dVar;
    }

    public final boolean b() {
        d dVar = b;
        return (dVar != null ? dVar.p() : null) == RenderType.SURFACE_VIEW;
    }

    public final boolean c() {
        d dVar = b;
        if (dVar != null) {
            return dVar.j();
        }
        return true;
    }

    public final void d(d dVar) {
        b = dVar;
    }
}
