package pl;

import kotlin.jvm.internal.Intrinsics;
import wf.a;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h {
    public static final h a = new h();

    private h() {
    }

    public final void a(String str, String str2) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(str2, "msg");
        try {
            a.a.f(wf.a.a, "web_log", "<" + str + ">: " + str2, false, 4, (Object) null);
        } catch (Throwable unused) {
        }
    }

    public final void b(String str, String str2) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(str2, "msg");
        try {
            a.a.l(wf.a.a, "web_log", "<" + str + ">: " + str2, false, 4, (Object) null);
        } catch (Throwable unused) {
        }
    }

    public final void c(String str) {
        Intrinsics.h(str, "msg");
        try {
            a.a.f(wf.a.a, "web_log", str, false, 4, (Object) null);
        } catch (Throwable unused) {
        }
    }

    public final void d(String str) {
        Intrinsics.h(str, "msg");
        try {
            a.a.l(wf.a.a, "web_log", str, false, 4, (Object) null);
        } catch (Throwable unused) {
        }
    }

    public final void e(String str) {
        Intrinsics.h(str, "msg");
        try {
            a.a.x(wf.a.a, "web_log", str, false, 4, (Object) null);
        } catch (Throwable unused) {
        }
    }

    public final void f(String str, String str2) {
        Intrinsics.h(str, "tag");
        Intrinsics.h(str2, "msg");
        try {
            a.a.x(wf.a.a, "web_log", "<" + str + ">: " + str2, false, 4, (Object) null);
        } catch (Throwable unused) {
        }
    }
}
