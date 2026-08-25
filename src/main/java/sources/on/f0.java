package on;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f0 {
    public static final f0 a = new f0();
    private static final String b = "TnPlayerPool";

    private f0() {
    }

    public final boolean a(com.transsion.player.orplayer.f fVar) {
        return true;
    }

    public final y b(Context context) {
        Intrinsics.h(context, "context");
        return y.j.a();
    }

    public final in.e c(Context context) {
        Intrinsics.h(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.g(applicationContext, "getApplicationContext(...)");
        return new in.e(applicationContext, null, false, 6, null);
    }
}
