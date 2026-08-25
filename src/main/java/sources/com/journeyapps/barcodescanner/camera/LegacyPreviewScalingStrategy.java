package com.journeyapps.barcodescanner.camera;

import af.q;
import android.graphics.Rect;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class LegacyPreviewScalingStrategy extends PreviewScalingStrategy {
    public static q e(q qVar, q qVar2) {
        q e;
        if (qVar2.b(qVar)) {
            while (true) {
                e = qVar.e(2, 3);
                q e2 = qVar.e(1, 2);
                if (!qVar2.b(e2)) {
                    break;
                }
                qVar = e2;
            }
            return qVar2.b(e) ? e : qVar;
        }
        do {
            q e3 = qVar.e(3, 2);
            qVar = qVar.e(2, 1);
            if (qVar2.b(e3)) {
                return e3;
            }
        } while (!qVar2.b(qVar));
        return qVar;
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public q b(List list, final q qVar) {
        if (qVar == null) {
            return (q) list.get(0);
        }
        Collections.sort(list, new Comparator<q>() { // from class: com.journeyapps.barcodescanner.camera.LegacyPreviewScalingStrategy.1
            @Override // java.util.Comparator
            public int compare(q qVar2, q qVar3) {
                int i = LegacyPreviewScalingStrategy.e(qVar2, qVar).a - qVar2.a;
                int i2 = LegacyPreviewScalingStrategy.e(qVar3, qVar).a - qVar3.a;
                if (i == 0 && i2 == 0) {
                    return qVar2.compareTo(qVar3);
                }
                if (i == 0) {
                    return -1;
                }
                if (i2 == 0) {
                    return 1;
                }
                return (i >= 0 || i2 >= 0) ? (i <= 0 || i2 <= 0) ? i < 0 ? -1 : 1 : -qVar2.compareTo(qVar3) : qVar2.compareTo(qVar3);
            }
        });
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Viewfinder size: ");
        sb2.append(qVar);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Preview in order of preference: ");
        sb3.append(list);
        return (q) list.get(0);
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public Rect d(q qVar, q qVar2) {
        q e = e(qVar, qVar2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Preview: ");
        sb2.append(qVar);
        sb2.append("; Scaled: ");
        sb2.append(e);
        sb2.append("; Want: ");
        sb2.append(qVar2);
        int i = (e.a - qVar2.a) / 2;
        int i2 = (e.b - qVar2.b) / 2;
        return new Rect(-i, -i2, e.a - i, e.b - i2);
    }
}
