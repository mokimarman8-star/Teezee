package bt;

import android.app.Application;
import com.transsion.al.KeepAliveHelper;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a {
    public final void a(Application app, boolean z) {
        Intrinsics.h(app, "app");
        KeepAliveHelper.init(app.getApplicationContext());
    }

    public final void b(Application app) {
        Intrinsics.h(app, "app");
    }

    public final void c() {
    }
}
