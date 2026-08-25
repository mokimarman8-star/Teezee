package o1;

import android.view.animation.Interpolator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class d implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f16687a;

    /* renamed from: b, reason: collision with root package name */
    private final float f16688b;

    protected d(float[] fArr) {
        this.f16687a = fArr;
        this.f16688b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f5) {
        if (f5 >= 1.0f) {
            return 1.0f;
        }
        if (f5 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f16687a;
        int min = Math.min((int) ((fArr.length - 1) * f5), fArr.length - 2);
        float f6 = this.f16688b;
        float f7 = (f5 - (min * f6)) / f6;
        float[] fArr2 = this.f16687a;
        float f8 = fArr2[min];
        return f8 + (f7 * (fArr2[min + 1] - f8));
    }
}
