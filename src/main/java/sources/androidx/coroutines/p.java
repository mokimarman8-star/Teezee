package androidx.coroutines;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.x0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    private final x0 f13237a;

    public p(int i5) {
        this.f13237a = i1.a(new int[i5]);
    }

    public final void a(Set set) {
        Object value;
        int[] iArr;
        Intrinsics.h(set, "tableIds");
        if (set.isEmpty()) {
            return;
        }
        x0 x0Var = this.f13237a;
        do {
            value = x0Var.getValue();
            int[] iArr2 = (int[]) value;
            int length = iArr2.length;
            iArr = new int[length];
            for (int i5 = 0; i5 < length; i5++) {
                iArr[i5] = set.contains(Integer.valueOf(i5)) ? iArr2[i5] + 1 : iArr2[i5];
            }
        } while (!x0Var.e(value, iArr));
    }
}
