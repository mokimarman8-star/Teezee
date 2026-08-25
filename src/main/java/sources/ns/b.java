package ns;

import android.app.Application;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b {
    public static final a a = new a(null);
    private static ns.a b;

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

        private final ns.a b() {
            return qs.b.a.a();
        }

        public final void c(Application application) {
            Intrinsics.h(application, "application");
            qs.b.a.b(application);
        }

        public final void d(int i) {
            a();
            ns.a aVar = b.b;
            if (aVar != null) {
                aVar.a(i);
            }
        }

        public final void e(CharSequence charSequence) {
            a();
            ns.a aVar = b.b;
            if (aVar != null) {
                aVar.b(charSequence);
            }
        }

        public final void f(int i, CharSequence text, int i2, int i3, int i4) {
            Intrinsics.h(text, "text");
            a();
            ns.a aVar = b.b;
            if (aVar != null) {
                aVar.c(i, text, i2, i3, i4);
            }
        }
    }
}
