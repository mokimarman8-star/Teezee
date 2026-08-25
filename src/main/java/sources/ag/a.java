package ag;

import android.app.Application;
import android.util.Log;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a {
    public static final C0001a a = new C0001a(null);
    private static Application b;
    private static b c;
    private static boolean d;

    /* renamed from: ag.a$a, reason: collision with other inner class name */
    public static final class C0001a {
        private C0001a() {
        }

        public /* synthetic */ C0001a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return a.d;
        }

        public final b b() {
            return a.c;
        }

        public final boolean c() {
            b b = b();
            return (b != null ? b.c() : false) || Log.isLoggable("net_proxy_tag", 3);
        }

        public final boolean d() {
            b b;
            if (a() || (b = b()) == null) {
                return false;
            }
            return b.d();
        }

        public final void e(Application application) {
            a.b = application;
        }

        public final void f(Application application, b bVar) {
            Intrinsics.h(application, "application");
            e(application);
            i(bVar);
        }

        public final void g(boolean z) {
            a.d = z;
        }

        public final void h(boolean z) {
            g(z);
        }

        public final void i(b bVar) {
            a.c = bVar;
        }
    }
}
