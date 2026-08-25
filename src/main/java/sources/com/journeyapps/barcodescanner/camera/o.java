package com.journeyapps.barcodescanner.camera;

import af.q;
import android.graphics.Rect;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class o extends PreviewScalingStrategy {
    private static float e(float f) {
        return f < 1.0f ? 1.0f / f : f;
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    protected float c(q qVar, q qVar2) {
        int i = qVar.a;
        if (i <= 0 || qVar.b <= 0) {
            return 0.0f;
        }
        float e = (1.0f / e((i * 1.0f) / qVar2.a)) / e((qVar.b * 1.0f) / qVar2.b);
        float e2 = e(((qVar.a * 1.0f) / qVar.b) / ((qVar2.a * 1.0f) / qVar2.b));
        return e * (((1.0f / e2) / e2) / e2);
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public Rect d(q qVar, q qVar2) {
        return new Rect(0, 0, qVar2.a, qVar2.b);
    }
}
