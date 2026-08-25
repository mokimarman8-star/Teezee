package com.bytedance.sdk.component.adexpress.dynamic.HiB;

import com.bytedance.sdk.component.adexpress.dynamic.HiB.sP;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TEQ {
    public static float Sj(float f) {
        return (float) Math.ceil((f * 16.0f) / 16.0f);
    }

    public static List<sP.Sj> Sj(float f, List<sP.Sj> list) {
        ArrayList<sP.Sj> arrayList = new ArrayList();
        Iterator<sP.Sj> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((sP.Sj) it.next().clone());
        }
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (sP.Sj sj : arrayList) {
            if (sj.sP) {
                i = (int) (i + sj.Sj);
            } else {
                i2 = (int) (i2 + sj.Sj);
                z = false;
            }
        }
        if (z && f > i) {
            return arrayList;
        }
        float f2 = i;
        float f3 = f < f2 ? f / f2 : 1.0f;
        float f4 = f > f2 ? (f - f2) / i2 : 0.0f;
        if (f4 > 1.0f) {
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = false;
            for (sP.Sj sj2 : arrayList) {
                if (!sj2.sP) {
                    float f8 = sj2.TKC;
                    if (f8 != 0.0f && sj2.Sj * f4 > f8) {
                        sj2.Sj = f8;
                        sj2.sP = true;
                        z2 = true;
                    }
                }
                arrayList2.add(sj2);
            }
            if (z2) {
                return Sj(f, arrayList2);
            }
        }
        int i3 = 0;
        for (sP.Sj sj3 : arrayList) {
            if (sj3.sP) {
                sj3.Sj = Sj(sj3.Sj * f3);
            } else {
                sj3.Sj = Sj(sj3.Sj * f4);
            }
            i3 = (int) (i3 + sj3.Sj);
        }
        float f9 = i3;
        if (f9 < f) {
            float f10 = f - f9;
            for (int i4 = 0; i4 < arrayList.size() && f10 > 0.0f; i4 = (i4 + 1) % arrayList.size()) {
                sP.Sj sj4 = (sP.Sj) arrayList.get(i4);
                if ((f < f2 && sj4.sP) || (f > f2 && !sj4.sP)) {
                    sj4.Sj += 0.0625f;
                    f10 -= 0.0625f;
                }
            }
        }
        return arrayList;
    }
}
