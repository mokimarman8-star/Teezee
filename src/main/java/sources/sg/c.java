package sg;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yg.l;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class c {
    public static final a a = new a(null);
    private static boolean b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Application application) {
            Intrinsics.h(application, "application");
            if (c.b) {
                return;
            }
            c.b = true;
            Utils.b(application);
            l.a.f();
            b.b.a().e(application);
        }
    }
}
