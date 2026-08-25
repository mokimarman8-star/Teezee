package kotlin.ranges;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class d {
    public static final void a(boolean z, Number step) {
        Intrinsics.h(step, "step");
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + step + '.');
    }

    public static ClosedFloatingPointRange b(float f, float f2) {
        return new b(f, f2);
    }

    public static OpenEndRange c(float f, float f2) {
        return new c(f, f2);
    }
}
