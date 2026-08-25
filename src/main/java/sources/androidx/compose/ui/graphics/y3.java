package androidx.compose.ui.graphics;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class y3 implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3902a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final short f3903b = b(5120);

    /* renamed from: c, reason: collision with root package name */
    private static final short f3904c = b(-1025);

    /* renamed from: d, reason: collision with root package name */
    private static final short f3905d = b(31743);

    /* renamed from: e, reason: collision with root package name */
    private static final short f3906e = b(1024);

    /* renamed from: f, reason: collision with root package name */
    private static final short f3907f = b(1);

    /* renamed from: g, reason: collision with root package name */
    private static final short f3908g = b(32256);

    /* renamed from: h, reason: collision with root package name */
    private static final short f3909h = b(-1024);

    /* renamed from: i, reason: collision with root package name */
    private static final short f3910i = b(Short.MIN_VALUE);

    /* renamed from: j, reason: collision with root package name */
    private static final short f3911j = b(31744);

    /* renamed from: k, reason: collision with root package name */
    private static final short f3912k = b(0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static short a(float f5) {
        int i5;
        int floatToRawIntBits = Float.floatToRawIntBits(f5);
        int i6 = floatToRawIntBits >>> 31;
        int i7 = (floatToRawIntBits >>> 23) & 255;
        int i8 = 8388607 & floatToRawIntBits;
        int i9 = 31;
        int i10 = 0;
        if (i7 != 255) {
            int i11 = i7 - 112;
            if (i11 >= 31) {
                i9 = 49;
            } else if (i11 > 0) {
                i10 = i8 >> 13;
                if ((floatToRawIntBits & 4096) != 0) {
                    i5 = (((i11 << 10) | i10) + 1) | (i6 << 15);
                    return b((short) i5);
                }
                i9 = i11;
            } else if (i11 >= -10) {
                int i12 = (8388608 | i8) >> (1 - i11);
                if ((i12 & 4096) != 0) {
                    i12 += 8192;
                }
                i9 = 0;
                i10 = i12 >> 13;
            } else {
                i9 = 0;
            }
        } else if (i8 != 0) {
            i10 = 512;
        }
        i5 = (i6 << 15) | (i9 << 10) | i10;
        return b((short) i5);
    }

    public static short b(short s5) {
        return s5;
    }
}
