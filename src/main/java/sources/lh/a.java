package lh;

import android.util.Log;
import com.tn.tranpay.logger.LogLevel;
import com.tn.tranpay.logger.LoggerPlugin;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a {
    private static boolean c;
    public static final a a = new a();
    private static LogLevel b = LogLevel.INFO;
    private static final CopyOnWriteArrayList d = new CopyOnWriteArrayList();

    /* renamed from: lh.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0056a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LogLevel.values().length];
            try {
                iArr[LogLevel.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogLevel.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    private a() {
    }

    public static /* synthetic */ void c(a aVar, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "TranPay";
        }
        aVar.b(str, str2);
    }

    public static /* synthetic */ void e(a aVar, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "TranPay";
        }
        aVar.d(str, str2);
    }

    public static /* synthetic */ void g(a aVar, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "TranPay";
        }
        aVar.f(str, str2);
    }

    private final void i(LogLevel logLevel, String str, String str2) {
        if (logLevel.ordinal() < b.ordinal()) {
            return;
        }
        if (c) {
            int i = C0056a.a[logLevel.ordinal()];
            if (i == 3) {
                Log.w(str, str2);
            } else if (i == 4) {
                Log.e(str, str2);
            }
        }
        try {
            Result.Companion companion = Result.Companion;
            for (LoggerPlugin loggerPlugin : d) {
                if (loggerPlugin != null) {
                    loggerPlugin.log(logLevel, str, str2);
                }
            }
            Result.constructor-impl(Unit.a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.a(th));
        }
    }

    public static /* synthetic */ void k(a aVar, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "TranPay";
        }
        aVar.j(str, str2);
    }

    public final void a(LoggerPlugin loggerPlugin) {
        if (loggerPlugin != null) {
            d.add(loggerPlugin);
        } else {
            Log.e("TranPay", "Attempt to add null plugin ignored");
        }
    }

    public final void b(String str, String str2) {
        Intrinsics.h(str, "message");
        Intrinsics.h(str2, "tag");
        i(LogLevel.DEBUG, str2, str);
    }

    public final void d(String str, String str2) {
        Intrinsics.h(str, "message");
        Intrinsics.h(str2, "tag");
        i(LogLevel.ERROR, str2, str);
    }

    public final void f(String str, String str2) {
        Intrinsics.h(str, "message");
        Intrinsics.h(str2, "tag");
        i(LogLevel.INFO, str2, str);
    }

    public final void h(LogLevel logLevel, boolean z) {
        Intrinsics.h(logLevel, "level");
        b = logLevel;
        c = z;
    }

    public final void j(String str, String str2) {
        Intrinsics.h(str, "message");
        Intrinsics.h(str2, "tag");
        i(LogLevel.WARNING, str2, str);
    }
}
