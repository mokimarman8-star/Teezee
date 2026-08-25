package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.qrcode.detector.d;
import java.io.Serializable;
import java.util.Comparator;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class MultiFinderPatternFinder$ModuleSizeComparator implements Comparator<d>, Serializable {
    private MultiFinderPatternFinder$ModuleSizeComparator() {
    }

    @Override // java.util.Comparator
    public int compare(d dVar, d dVar2) {
        double i = dVar2.i() - dVar.i();
        if (i < 0.0d) {
            return -1;
        }
        return i > 0.0d ? 1 : 0;
    }
}
