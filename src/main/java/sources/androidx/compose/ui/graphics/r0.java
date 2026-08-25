package androidx.compose.ui.graphics;

import android.graphics.Matrix;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class r0 {
    public static final void a(Matrix matrix, float[] fArr) {
        float f5 = fArr[0];
        float f6 = fArr[1];
        float f7 = fArr[2];
        float f8 = fArr[3];
        float f9 = fArr[4];
        float f10 = fArr[5];
        float f11 = fArr[6];
        float f12 = fArr[7];
        float f13 = fArr[8];
        float f14 = fArr[12];
        float f15 = fArr[13];
        float f16 = fArr[15];
        fArr[0] = f5;
        fArr[1] = f9;
        fArr[2] = f14;
        fArr[3] = f6;
        fArr[4] = f10;
        fArr[5] = f15;
        fArr[6] = f8;
        fArr[7] = f12;
        fArr[8] = f16;
        matrix.setValues(fArr);
        fArr[0] = f5;
        fArr[1] = f6;
        fArr[2] = f7;
        fArr[3] = f8;
        fArr[4] = f9;
        fArr[5] = f10;
        fArr[6] = f11;
        fArr[7] = f12;
        fArr[8] = f13;
    }

    public static final void b(float[] fArr, Matrix matrix) {
        matrix.getValues(fArr);
        float f5 = fArr[0];
        float f6 = fArr[1];
        float f7 = fArr[2];
        float f8 = fArr[3];
        float f9 = fArr[4];
        float f10 = fArr[5];
        float f11 = fArr[6];
        float f12 = fArr[7];
        float f13 = fArr[8];
        fArr[0] = f5;
        fArr[1] = f8;
        fArr[2] = 0.0f;
        fArr[3] = f11;
        fArr[4] = f6;
        fArr[5] = f9;
        fArr[6] = 0.0f;
        fArr[7] = f12;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = f7;
        fArr[13] = f10;
        fArr[14] = 0.0f;
        fArr[15] = f13;
    }
}
