package im;

import com.transsion.memberapi.MemberCheckResult;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public interface a {

    /* renamed from: im.a$a, reason: collision with other inner class name */
    public static final class C0074a {
        public static void a(a aVar, MemberCheckResult memberCheckResult) {
        }

        public static void b(a aVar, String str) {
            Intrinsics.h(str, "errorMsg");
        }

        public static void c(a aVar) {
        }

        public static void d(a aVar, MemberCheckResult memberCheckResult) {
        }

        public static void e(a aVar, MemberCheckResult memberCheckResult) {
        }

        public static void f(a aVar, MemberCheckResult memberCheckResult) {
        }

        public static void g(a aVar, MemberCheckResult memberCheckResult) {
        }
    }

    void a(MemberCheckResult memberCheckResult);

    void b(MemberCheckResult memberCheckResult);

    void c(MemberCheckResult memberCheckResult);

    void d(MemberCheckResult memberCheckResult);

    void e();

    void f(MemberCheckResult memberCheckResult);

    void onFail(String str);
}
