package kotlin.uuid;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class a {
    public static final void a(long j, byte[] dst, int i, int i2, int i3) {
        Intrinsics.h(dst, "dst");
        b.d(j, dst, i, i2, i3);
    }

    public static final Object b(Uuid uuid) {
        Intrinsics.h(uuid, "uuid");
        return new UuidSerialized(uuid.getMostSignificantBits(), uuid.getLeastSignificantBits());
    }

    public static final void c(byte[] bArr, int i, long j) {
        Intrinsics.h(bArr, "<this>");
        b.e(bArr, i, j);
    }
}
