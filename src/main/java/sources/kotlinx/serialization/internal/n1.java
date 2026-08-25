package kotlinx.serialization.internal;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class n1 {
    public static final int a(kotlinx.serialization.descriptors.f fVar, kotlinx.serialization.descriptors.f[] typeParams) {
        Intrinsics.h(fVar, "<this>");
        Intrinsics.h(typeParams, "typeParams");
        int hashCode = (fVar.i().hashCode() * 31) + Arrays.hashCode(typeParams);
        Iterable a = kotlinx.serialization.descriptors.g.a(fVar);
        Iterator it = a.iterator();
        int i = 1;
        int i2 = 1;
        while (true) {
            int i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i4 = i2 * 31;
            String i5 = ((kotlinx.serialization.descriptors.f) it.next()).i();
            if (i5 != null) {
                i3 = i5.hashCode();
            }
            i2 = i4 + i3;
        }
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            int i6 = i * 31;
            kotlinx.serialization.descriptors.h d = ((kotlinx.serialization.descriptors.f) it2.next()).d();
            i = i6 + (d != null ? d.hashCode() : 0);
        }
        return (((hashCode * 31) + i2) * 31) + i;
    }
}
