package com.journeyapps.barcodescanner.camera;

import af.q;
import android.graphics.Rect;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class l extends PreviewScalingStrategy {
    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    protected float c(q qVar, q qVar2) {
        if (qVar.a <= 0 || qVar.b <= 0) {
            return 0.0f;
        }
        q f = qVar.f(qVar2);
        float f2 = (f.a * 1.0f) / qVar.a;
        if (f2 > 1.0f) {
            f2 = (float) Math.pow(1.0f / f2, 1.1d);
        }
        float f3 = ((f.a * 1.0f) / qVar2.a) + ((f.b * 1.0f) / qVar2.b);
        return f2 * ((1.0f / f3) / f3);
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public Rect d(q qVar, q qVar2) {
        q f = qVar.f(qVar2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Preview: ");
        sb2.append(qVar);
        sb2.append("; Scaled: ");
        sb2.append(f);
        sb2.append("; Want: ");
        sb2.append(qVar2);
        int i = (f.a - qVar2.a) / 2;
        int i2 = (f.b - qVar2.b) / 2;
        return new Rect(-i, -i2, f.a - i, f.b - i2);
    }
}
