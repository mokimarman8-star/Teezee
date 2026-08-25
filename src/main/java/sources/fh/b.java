package fh;

import android.app.Application;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b {
    public static final a a = new a(null);
    private static fh.a b;

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

        private final fh.a b() {
            return ih.b.a.a();
        }

        public final void c(Application application) {
            Intrinsics.h(application, "application");
            ih.b.a.b(application);
        }

        public final void d(int i) {
            a();
            fh.a aVar = b.b;
            if (aVar != null) {
                aVar.a(i);
            }
        }

        public final void e(CharSequence charSequence) {
            a();
            fh.a aVar = b.b;
            if (aVar != null) {
                aVar.b(charSequence);
            }
        }

        public final void f(CharSequence charSequence, int i) {
            a();
            fh.a aVar = b.b;
            if (aVar != null) {
                aVar.d(charSequence, i);
            }
        }

        public final void g(int i, CharSequence charSequence, int i2, int i3, int i4) {
            Intrinsics.h(charSequence, "text");
            a();
            fh.a aVar = b.b;
            if (aVar != null) {
                aVar.c(i, charSequence, i2, i3, i4);
            }
        }
    }
}
