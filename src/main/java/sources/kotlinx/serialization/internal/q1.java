package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class q1 extends y0 {
    private final String c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q1(kotlinx.serialization.descriptors.f primitive) {
        super(primitive, null);
        Intrinsics.h(primitive, "primitive");
        this.c = primitive.i() + "Array";
    }

    @Override // kotlinx.serialization.descriptors.f
    public String i() {
        return this.c;
    }
}
