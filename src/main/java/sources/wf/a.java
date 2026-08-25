package wf;

import android.util.Log;
import com.tn.lib.logger.xlog.LogType;
import java.util.Arrays;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xf.c;
import zf.b;
import zf.d;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class a {
    public static final C0158a a = new C0158a(null);
    private static xf.a b;

    /* renamed from: wf.a$a, reason: collision with other inner class name */
    public static final class C0158a {

        /* renamed from: wf.a$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0159a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[LogType.values().length];
                try {
                    iArr[LogType.TYPE_LOGCAT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[LogType.TYPE_XLOG.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                a = iArr;
            }
        }

        private C0158a() {
        }

        public /* synthetic */ C0158a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String a(String str) {
            String str2 = "MB_" + str;
            if (str2.length() <= 23) {
                return str2;
            }
            String substring = str2.substring(0, 23);
            Intrinsics.g(substring, "substring(...)");
            return substring;
        }

        public static /* synthetic */ void e(C0158a c0158a, String str, String str2, Throwable th, boolean z, int i, Object obj) {
            if ((i & 8) != 0) {
                z = false;
            }
            c0158a.b(str, str2, th, z);
        }

        public static /* synthetic */ void f(C0158a c0158a, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            c0158a.c(str, str2, z);
        }

        public static /* synthetic */ void g(C0158a c0158a, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            c0158a.d(str, z);
        }

        public static /* synthetic */ void k(C0158a c0158a, String str, String str2, Throwable th, boolean z, int i, Object obj) {
            if ((i & 8) != 0) {
                z = false;
            }
            c0158a.h(str, str2, th, z);
        }

        public static /* synthetic */ void l(C0158a c0158a, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            c0158a.i(str, str2, z);
        }

        public static /* synthetic */ void m(C0158a c0158a, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            c0158a.j(str, z);
        }

        private final xf.a n() {
            int i = C0159a.a[c.a.d().ordinal()];
            if (i == 1) {
                return b.b.a();
            }
            if (i == 2) {
                return d.b.a();
            }
            throw new NoWhenBranchMatchedException();
        }

        public static /* synthetic */ void q(C0158a c0158a, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            c0158a.o(str, z);
        }

        public static /* synthetic */ void r(C0158a c0158a, String str, String[] strArr, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            c0158a.p(str, strArr, z);
        }

        private final boolean s(String str, boolean z) {
            return !z || Log.isLoggable(a(str), 3);
        }

        private final boolean t(String str) {
            return Log.isLoggable(a(str), 3);
        }

        public static /* synthetic */ void v(C0158a c0158a, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            c0158a.u(str, str2, z);
        }

        public static /* synthetic */ void x(C0158a c0158a, String str, String str2, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            c0158a.w(str, str2, z);
        }

        public final void b(String str, String str2, Throwable th, boolean z) {
            Intrinsics.h(str, "tag");
            Intrinsics.h(str2, "msg");
            Intrinsics.h(th, "throwable");
            if (t(str)) {
                b.b.a().f(a(str), str2, th.getStackTrace().toString());
                return;
            }
            if (!z) {
                b.b.a().d(a(str), str2, th.getStackTrace().toString());
                return;
            }
            if (a.b == null) {
                a.b = n();
            }
            xf.a aVar = a.b;
            if (aVar != null) {
                aVar.e(a(str), str2, th.getStackTrace().toString());
            }
        }

        public final void c(String str, String str2, boolean z) {
            Intrinsics.h(str, "tag");
            Intrinsics.h(str2, "msg");
            if (t(str)) {
                b.b.a().f(a(str), str2);
                return;
            }
            if (!z) {
                b.b.a().e(a(str), str2);
                return;
            }
            if (a.b == null) {
                a.b = n();
            }
            xf.a aVar = a.b;
            if (aVar != null) {
                aVar.e(a(str), str2);
            }
        }

        public final void d(String str, boolean z) {
            Intrinsics.h(str, "msg");
            if (!z) {
                b.b.a().c(str);
                return;
            }
            if (a.b == null) {
                a.b = n();
            }
            xf.a aVar = a.b;
            if (aVar != null) {
                aVar.c(str);
            }
        }

        public final void h(String str, String str2, Throwable th, boolean z) {
            Intrinsics.h(str, "tag");
            Intrinsics.h(str2, "msg");
            Intrinsics.h(th, "throwable");
            if (s(str, z)) {
                b.b.a().g(a(str), str2, th.getStackTrace().toString());
                return;
            }
            if (a.b == null) {
                a.b = n();
            }
            xf.a aVar = a.b;
            if (aVar != null) {
                aVar.g(a(str), str2, th.getStackTrace().toString());
            }
        }

        public final void i(String str, String str2, boolean z) {
            Intrinsics.h(str, "tag");
            Intrinsics.h(str2, "msg");
            if (s(str, z)) {
                b.b.a().g(a(str), str2);
                return;
            }
            if (a.b == null) {
                a.b = n();
            }
            xf.a aVar = a.b;
            if (aVar != null) {
                aVar.g(a(str), str2);
            }
        }

        public final void j(String str, boolean z) {
            Intrinsics.h(str, "msg");
            if (!z) {
                b.b.a().b(str);
                return;
            }
            if (a.b == null) {
                a.b = n();
            }
            xf.a aVar = a.b;
            if (aVar != null) {
                aVar.b(str);
            }
        }

        public final void o(String str, boolean z) {
            Intrinsics.h(str, "msg");
            if (!z) {
                b.b.a().a(str);
                return;
            }
            if (a.b == null) {
                a.b = n();
            }
            xf.a aVar = a.b;
            if (aVar != null) {
                aVar.a(str);
            }
        }

        public final void p(String str, String[] strArr, boolean z) {
            Intrinsics.h(str, "tag");
            Intrinsics.h(strArr, "msg");
            if (t(str)) {
                b.b.a().f(a(str), (String[]) Arrays.copyOf(strArr, strArr.length));
                return;
            }
            if (!z) {
                b.b.a().d(a(str), (String[]) Arrays.copyOf(strArr, strArr.length));
                return;
            }
            if (a.b == null) {
                a.b = n();
            }
            xf.a aVar = a.b;
            if (aVar != null) {
                aVar.d(a(str), (String[]) Arrays.copyOf(strArr, strArr.length));
            }
        }

        public final void u(String str, String str2, boolean z) {
            Intrinsics.h(str, "tag");
            Intrinsics.h(str2, "msg");
            if (t(str)) {
                b.b.a().f(a(str), str2);
                return;
            }
            if (!z) {
                b.b.a().h(a(str), str2);
                return;
            }
            if (a.b == null) {
                a.b = n();
            }
            xf.a aVar = a.b;
            if (aVar != null) {
                aVar.h(a(str), str2);
            }
        }

        public final void w(String str, String str2, boolean z) {
            Intrinsics.h(str, "tag");
            Intrinsics.h(str2, "msg");
            if (s(str, z)) {
                b.b.a().f(a(str), str2);
                return;
            }
            if (a.b == null) {
                a.b = n();
            }
            xf.a aVar = a.b;
            if (aVar != null) {
                aVar.f(a(str), str2);
            }
        }
    }

    public static final void c(String str, String str2, boolean z) {
        a.c(str, str2, z);
    }
}
