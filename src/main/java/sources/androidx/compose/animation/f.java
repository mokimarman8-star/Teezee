package androidx.compose.animation;

import androidx.compose.animation.core.w;
import androidx.compose.animation.core.y;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class f {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(float[] fArr, float[] fArr2, int i5) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13 = 0.0f;
        float f14 = 0.0f;
        for (int i6 = 0; i6 < i5; i6++) {
            float f15 = i6 / i5;
            float f16 = 1.0f;
            while (true) {
                f5 = ((f16 - f13) / 2.0f) + f13;
                f6 = 1.0f - f5;
                f7 = f5 * 3.0f * f6;
                f8 = f5 * f5 * f5;
                float f17 = (((f6 * 0.175f) + (f5 * 0.35000002f)) * f7) + f8;
                if (Math.abs(f17 - f15) < 1.0E-5d) {
                    break;
                } else if (f17 > f15) {
                    f16 = f5;
                } else {
                    f13 = f5;
                }
            }
            float f18 = 0.5f;
            fArr[i6] = (f7 * ((f6 * 0.5f) + f5)) + f8;
            float f19 = 1.0f;
            while (true) {
                f9 = ((f19 - f14) / 2.0f) + f14;
                f10 = 1.0f - f9;
                f11 = f9 * 3.0f * f10;
                f12 = f9 * f9 * f9;
                float f20 = (((f10 * f18) + f9) * f11) + f12;
                if (Math.abs(f20 - f15) >= 1.0E-5d) {
                    if (f20 > f15) {
                        f19 = f9;
                    } else {
                        f14 = f9;
                    }
                    f18 = 0.5f;
                }
            }
            fArr2[i6] = (f11 * ((f10 * 0.175f) + (f9 * 0.35000002f))) + f12;
        }
        fArr2[i5] = 1.0f;
        fArr[i5] = 1.0f;
    }

    public static final w c(o0.e eVar) {
        return y.a(new g(eVar));
    }
}
