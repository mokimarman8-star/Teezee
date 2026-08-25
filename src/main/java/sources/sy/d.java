package sy;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.g;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface d {

    public static final class a {
        public static boolean a(d dVar, kotlinx.serialization.descriptors.f descriptor, int i) {
            Intrinsics.h(descriptor, "descriptor");
            return true;
        }
    }

    void C(kotlinx.serialization.descriptors.f fVar, int i, g gVar, Object obj);

    void D(kotlinx.serialization.descriptors.f fVar, int i, short s);

    void E(kotlinx.serialization.descriptors.f fVar, int i, double d);

    void F(kotlinx.serialization.descriptors.f fVar, int i, long j);

    void c(kotlinx.serialization.descriptors.f fVar);

    f f(kotlinx.serialization.descriptors.f fVar, int i);

    void i(kotlinx.serialization.descriptors.f fVar, int i, g gVar, Object obj);

    void n(kotlinx.serialization.descriptors.f fVar, int i, char c);

    void p(kotlinx.serialization.descriptors.f fVar, int i, byte b);

    void s(kotlinx.serialization.descriptors.f fVar, int i, float f);

    void w(kotlinx.serialization.descriptors.f fVar, int i, int i2);

    void x(kotlinx.serialization.descriptors.f fVar, int i, boolean z);

    void y(kotlinx.serialization.descriptors.f fVar, int i, String str);

    boolean z(kotlinx.serialization.descriptors.f fVar, int i);
}
