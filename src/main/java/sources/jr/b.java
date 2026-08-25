package jr;

import android.app.Application;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    public static final a a = new a(null);
    private static jr.a b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a() {
            if (b.b == null) {
                b.b = b();
            }
        }

        private final jr.a b() {
            return mr.b.a.a();
        }

        public final void c(Application application) {
            Intrinsics.h(application, "application");
            mr.b.a.b(application);
        }

        public final void d(int i) {
            a();
            jr.a aVar = b.b;
            if (aVar != null) {
                aVar.a(i);
            }
        }

        public final void e(CharSequence charSequence) {
            a();
            jr.a aVar = b.b;
            if (aVar != null) {
                aVar.b(charSequence);
            }
        }
    }
}
