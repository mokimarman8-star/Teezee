package sy;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.g;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface f {

    public static final class a {
        public static d a(f fVar, kotlinx.serialization.descriptors.f descriptor, int i) {
            Intrinsics.h(descriptor, "descriptor");
            return fVar.b(descriptor);
        }

        public static void b(f fVar) {
        }

        public static void c(f fVar, g serializer, Object obj) {
            Intrinsics.h(serializer, "serializer");
            if (serializer.getDescriptor().b()) {
                fVar.e(serializer, obj);
            } else if (obj == null) {
                fVar.o();
            } else {
                fVar.v();
                fVar.e(serializer, obj);
            }
        }

        public static void d(f fVar, g serializer, Object obj) {
            Intrinsics.h(serializer, "serializer");
            serializer.serialize(fVar, obj);
        }
    }

    void B(int i);

    void G(String str);

    ty.c a();

    d b(kotlinx.serialization.descriptors.f fVar);

    void e(g gVar, Object obj);

    void g(double d);

    void h(byte b);

    d j(kotlinx.serialization.descriptors.f fVar, int i);

    void k(kotlinx.serialization.descriptors.f fVar, int i);

    f l(kotlinx.serialization.descriptors.f fVar);

    void m(long j);

    void o();

    void q(short s);

    void r(boolean z);

    void t(float f);

    void u(char c);

    void v();
}
