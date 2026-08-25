package androidx.compose.ui.graphics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class j4 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final float b(float[] fArr, int i5, float[] fArr2, int i6) {
        int i7 = i5 * 4;
        return (fArr[i7] * fArr2[i6]) + (fArr[i7 + 1] * fArr2[4 + i6]) + (fArr[i7 + 2] * fArr2[8 + i6]) + (fArr[i7 + 3] * fArr2[12 + i6]);
    }

    public static final boolean c(float[] fArr) {
        int i5 = 0;
        while (i5 < 4) {
            int i6 = 0;
            while (i6 < 4) {
                if (fArr[(i5 * 4) + i6] != (i5 == i6 ? 1.0f : 0.0f)) {
                    return false;
                }
                i6++;
            }
            i5++;
        }
        return true;
    }
}
