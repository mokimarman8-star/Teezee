package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.MissingFieldException;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class m1 {
    public static final void a(int i, int i2, kotlinx.serialization.descriptors.f descriptor) {
        Intrinsics.h(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i3 = (~i) & i2;
        for (int i4 = 0; i4 < 32; i4++) {
            if ((i3 & 1) != 0) {
                arrayList.add(descriptor.f(i4));
            }
            i3 >>>= 1;
        }
        throw new MissingFieldException(arrayList, descriptor.i());
    }
}
