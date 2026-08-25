package j4;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface j {

    public static final class a {
        public static i a(j jVar, m mVar) {
            Intrinsics.h(mVar, "id");
            return jVar.d(mVar.b(), mVar.a());
        }

        public static void b(j jVar, m mVar) {
            Intrinsics.h(mVar, "id");
            jVar.f(mVar.b(), mVar.a());
        }
    }

    i a(m mVar);

    void b(i iVar);

    void c(m mVar);

    i d(String str, int i5);

    List e();

    void f(String str, int i5);

    void g(String str);
}
