package kotlin.uuid;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexExtensionsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class b extends a {
    public static final void d(long j, byte[] dst, int i, int i2, int i3) {
        Intrinsics.h(dst, "dst");
        int i4 = 7 - i2;
        int i5 = 8 - i3;
        if (i5 > i4) {
            return;
        }
        while (true) {
            int i6 = HexExtensionsKt.a()[(int) ((j >> (i4 << 3)) & 255)];
            int i7 = i + 1;
            dst[i] = (byte) (i6 >> 8);
            i += 2;
            dst[i7] = (byte) i6;
            if (i4 == i5) {
                return;
            } else {
                i4--;
            }
        }
    }

    public static final void e(byte[] bArr, int i, long j) {
        Intrinsics.h(bArr, "<this>");
        int i2 = 7;
        while (-1 < i2) {
            bArr[i] = (byte) (j >> (i2 << 3));
            i2--;
            i++;
        }
    }
}
