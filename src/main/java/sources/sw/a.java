package sw;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    public static final a a = new a();
    private static final Set b = new LinkedHashSet();

    private a() {
    }

    public final void a() {
        com.transsion.wrapperad.install.b bVar = com.transsion.wrapperad.install.b.a;
        Application a2 = Utils.a();
        Intrinsics.g(a2, "getApp(...)");
        bVar.b(a2);
    }
}
