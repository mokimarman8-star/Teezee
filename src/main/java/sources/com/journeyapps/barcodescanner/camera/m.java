package com.journeyapps.barcodescanner.camera;

import af.q;
import android.graphics.Rect;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class m {
    private q a;
    private int b;
    private boolean c = false;
    private PreviewScalingStrategy d = new n();

    public m(int i, q qVar) {
        this.b = i;
        this.a = qVar;
    }

    public q a(List list, boolean z) {
        return this.d.b(list, b(z));
    }

    public q b(boolean z) {
        q qVar = this.a;
        if (qVar == null) {
            return null;
        }
        return z ? qVar.d() : qVar;
    }

    public int c() {
        return this.b;
    }

    public Rect d(q qVar) {
        return this.d.d(qVar, this.a);
    }

    public void e(PreviewScalingStrategy previewScalingStrategy) {
        this.d = previewScalingStrategy;
    }
}
