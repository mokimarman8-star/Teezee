package ij;

import com.transsion.push.bean.MsgStyle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g {
    public static final g a = new g();
    private static Boolean b;

    private g() {
    }

    private final boolean a() {
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.a;
        return bVar.b().getBoolean("key_or_content_mode", false) || bVar.b().getInt("key_or_content_mode_local", -1) == 1;
    }

    private final void c(boolean z) {
        jg.b.a.b("X-Content-Mode", z ? MsgStyle.CUSTOM_LEFT_PIC : "0");
    }

    private final void d(boolean z) {
        com.transsion.baselib.report.launch.b.a.b().putBoolean("key_or_content_mode", z);
    }

    public final boolean b() {
        Boolean bool = b;
        if (bool != null) {
            Intrinsics.e(bool);
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(a());
        b = valueOf;
        Intrinsics.e(valueOf);
        c(valueOf.booleanValue());
        Boolean bool2 = b;
        Intrinsics.e(bool2);
        return bool2.booleanValue();
    }

    public final void e(boolean z) {
        c(z);
        b = Boolean.valueOf(z);
        d(z);
    }
}
