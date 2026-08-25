package kd;

import com.google.zxing.NotFoundException;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class e extends k {
    @Override // kd.k
    public b c(b bVar, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return d(bVar, i, i2, n.b(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    @Override // kd.k
    public b d(b bVar, int i, int i2, n nVar) {
        if (i <= 0 || i2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        b bVar2 = new b(i, i2);
        int i3 = i * 2;
        float[] fArr = new float[i3];
        for (int i4 = 0; i4 < i2; i4++) {
            float f = i4 + 0.5f;
            for (int i5 = 0; i5 < i3; i5 += 2) {
                fArr[i5] = (i5 / 2) + 0.5f;
                fArr[i5 + 1] = f;
            }
            nVar.f(fArr);
            k.a(bVar, fArr);
            for (int i6 = 0; i6 < i3; i6 += 2) {
                try {
                    if (bVar.h((int) fArr[i6], (int) fArr[i6 + 1])) {
                        bVar2.r(i6 / 2, i4);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
        return bVar2;
    }
}
