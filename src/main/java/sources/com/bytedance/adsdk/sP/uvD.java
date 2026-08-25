package com.bytedance.adsdk.sP;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
class uvD implements Interpolator {
    private final float[] Sj;
    private final float[] sP;

    uvD(float f, float f2, float f3, float f4) {
        this(Sj(f, f2, f3, f4));
    }

    uvD(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = (int) (length / 0.002f);
        int i2 = i + 1;
        this.Sj = new float[i2];
        this.sP = new float[i2];
        float[] fArr = new float[2];
        for (int i3 = 0; i3 < i2; i3++) {
            pathMeasure.getPosTan((i3 * length) / i, fArr, null);
            this.Sj[i3] = fArr[0];
            this.sP[i3] = fArr[1];
        }
    }

    private static Path Sj(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.Sj.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.Sj[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.Sj;
        float f2 = fArr[length];
        float f3 = fArr[i];
        float f4 = f2 - f3;
        if (f4 == 0.0f) {
            return this.sP[i];
        }
        float f8 = (f - f3) / f4;
        float[] fArr2 = this.sP;
        float f9 = fArr2[i];
        return f9 + (f8 * (fArr2[length] - f9));
    }
}
