package p0;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class c implements p0.a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f16862c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final int f16863d = 8;

    /* renamed from: a, reason: collision with root package name */
    private final float[] f16864a;

    /* renamed from: b, reason: collision with root package name */
    private final float[] f16865b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final float b(float f5, float[] fArr, float[] fArr2) {
            float f6;
            float f7;
            float f8;
            float a5;
            float abs = Math.abs(f5);
            float signum = Math.signum(f5);
            int binarySearch = Arrays.binarySearch(fArr, abs);
            if (binarySearch >= 0) {
                a5 = fArr2[binarySearch];
            } else {
                int i5 = -(binarySearch + 1);
                int i6 = i5 - 1;
                float f9 = 0.0f;
                if (i6 >= fArr.length - 1) {
                    float f10 = fArr[fArr.length - 1];
                    float f11 = fArr2[fArr.length - 1];
                    if (f10 == 0.0f) {
                        return 0.0f;
                    }
                    return f5 * (f11 / f10);
                }
                if (i6 == -1) {
                    float f12 = fArr[0];
                    f8 = fArr2[0];
                    f7 = f12;
                    f6 = 0.0f;
                } else {
                    float f13 = fArr[i6];
                    float f14 = fArr[i5];
                    f6 = fArr2[i6];
                    f9 = f13;
                    f7 = f14;
                    f8 = fArr2[i5];
                }
                a5 = d.f16866a.a(f6, f8, f9, f7, abs);
            }
            return signum * a5;
        }
    }

    public c(float[] fArr, float[] fArr2) {
        if (fArr.length != fArr2.length || fArr.length == 0) {
            throw new IllegalArgumentException("Array lengths must match and be nonzero");
        }
        this.f16864a = fArr;
        this.f16865b = fArr2;
    }

    @Override // p0.a
    public float a(float f5) {
        return f16862c.b(f5, this.f16865b, this.f16864a);
    }

    @Override // p0.a
    public float b(float f5) {
        return f16862c.b(f5, this.f16864a, this.f16865b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Arrays.equals(this.f16864a, cVar.f16864a) && Arrays.equals(this.f16865b, cVar.f16865b);
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f16864a) * 31) + Arrays.hashCode(this.f16865b);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontScaleConverter{fromSpValues=");
        String arrays = Arrays.toString(this.f16864a);
        Intrinsics.g(arrays, "toString(this)");
        sb.append(arrays);
        sb.append(", toDpValues=");
        String arrays2 = Arrays.toString(this.f16865b);
        Intrinsics.g(arrays2, "toString(this)");
        sb.append(arrays2);
        sb.append('}');
        return sb.toString();
    }
}
