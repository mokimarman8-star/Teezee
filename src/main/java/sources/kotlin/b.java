package kotlin;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class b {
    public static void a(Throwable th, Throwable exception) {
        Intrinsics.h(th, "<this>");
        Intrinsics.h(exception, "exception");
        if (th != exception) {
            PlatformImplementationsKt.a.a(th, exception);
        }
    }

    public static String b(Throwable th) {
        Intrinsics.h(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.g(stringWriter2, "toString(...)");
        return stringWriter2;
    }
}
