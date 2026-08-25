package com.journeyapps.barcodescanner.camera;

import af.q;
import android.graphics.Rect;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class n extends PreviewScalingStrategy {
    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    protected float c(q qVar, q qVar2) {
        if (qVar.a <= 0 || qVar.b <= 0) {
            return 0.0f;
        }
        q g = qVar.g(qVar2);
        float f = (g.a * 1.0f) / qVar.a;
        if (f > 1.0f) {
            f = (float) Math.pow(1.0f / f, 1.1d);
        }
        float f2 = ((qVar2.a * 1.0f) / g.a) * ((qVar2.b * 1.0f) / g.b);
        return f * (((1.0f / f2) / f2) / f2);
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public Rect d(q qVar, q qVar2) {
        q g = qVar.g(qVar2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Preview: ");
        sb2.append(qVar);
        sb2.append("; Scaled: ");
        sb2.append(g);
        sb2.append("; Want: ");
        sb2.append(qVar2);
        int i = (g.a - qVar2.a) / 2;
        int i2 = (g.b - qVar2.b) / 2;
        return new Rect(-i, -i2, g.a - i, g.b - i2);
    }
}
