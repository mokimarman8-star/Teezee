package xf;

import android.app.Application;
import android.os.Environment;
import android.util.Log;
import com.elvishew.xlog.printer.file.FilePrinter;
import com.tn.lib.logger.xlog.LogType;
import h8.d;
import java.io.File;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import s7.a;
import s7.e;
import xf.c;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class c {
    private static Application b;
    private static boolean c;
    public static final a a = new a(null);
    private static LogType d = LogType.TYPE_LOGCAT;

    public static final class a {

        /* renamed from: xf.c$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0162a {
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

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void g(a aVar, Application application, LogType logType, boolean z, String str, long j, int i, Object obj) {
            if ((i & 8) != 0) {
                str = "";
            }
            String str2 = str;
            if ((i & 16) != 0) {
                j = 0;
            }
            aVar.f(application, logType, z, str2, j);
        }

        private final void h(String str, long j, boolean z) {
            i(str, j, z);
        }

        private final void i(String str, long j, boolean z) {
            String c = c(b());
            if (str.length() <= 0) {
                str = c;
            }
            s7.a r = new a.a().B(Integer.MIN_VALUE).E("X-LOG").A(new w7.a()).H(new z7.a()).G(new y7.a()).F(new yf.b()).D(new a8.a()).q(new v7.b()).p(new c8.a() { // from class: xf.b
                public final s7.b a(s7.b bVar) {
                    s7.b j2;
                    j2 = c.a.j(bVar);
                    return j2;
                }
            }).r();
            g8.c aVar = new g8.a();
            FilePrinter b = str.length() > 0 ? new FilePrinter.b(str).d(new yf.a()).a(new d()).c(new yf.c()).f(new t7.a()).b() : null;
            if (z) {
                if (b == null) {
                    e.f(r, new g8.c[]{aVar});
                    return;
                } else {
                    e.f(r, new g8.c[]{aVar, b});
                    return;
                }
            }
            if (b == null) {
                e.e(r);
            } else {
                e.f(r, new g8.c[]{b});
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final s7.b j(s7.b bVar) {
            return bVar;
        }

        private final boolean k() {
            return Intrinsics.c(Environment.getExternalStorageState(), "mounted");
        }

        public final Application b() {
            return c.b;
        }

        public final String c(Application application) {
            if (application == null) {
                throw new RuntimeException("日志库传入Application为空");
            }
            if (k()) {
                StringBuilder sb = new StringBuilder();
                File externalFilesDir = application.getExternalFilesDir(null);
                sb.append(externalFilesDir != null ? externalFilesDir.getParent() : null);
                sb.append(File.separator);
                sb.append("log");
                return sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            File filesDir = application.getFilesDir();
            sb2.append(filesDir != null ? filesDir.getParent() : null);
            sb2.append(File.separator);
            sb2.append("log");
            return sb2.toString();
        }

        public final LogType d() {
            return c.d;
        }

        public final boolean e() {
            return c.c;
        }

        public final void f(Application application, LogType logType, boolean z, String str, long j) {
            Intrinsics.h(application, "application");
            Intrinsics.h(logType, "logType");
            Intrinsics.h(str, "loggerPath");
            a aVar = c.a;
            if (aVar.b() != null) {
                return;
            }
            c.d = logType;
            c.c = z || Log.isLoggable("oneroom_logger", 3);
            aVar.l(application);
            int i = C0162a.a[logType.ordinal()];
            if (i == 1) {
                h(str, j, z);
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                i(str, j, z);
            }
        }

        public final void l(Application application) {
            c.b = application;
        }
    }
}
