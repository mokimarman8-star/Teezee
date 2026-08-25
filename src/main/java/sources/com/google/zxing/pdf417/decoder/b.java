package com.google.zxing.pdf417.decoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b {
    private final Map a = new HashMap();

    b() {
    }

    int[] a() {
        ArrayList arrayList = new ArrayList();
        int i = -1;
        for (Map.Entry entry : this.a.entrySet()) {
            if (((Integer) entry.getValue()).intValue() > i) {
                i = ((Integer) entry.getValue()).intValue();
                arrayList.clear();
                arrayList.add((Integer) entry.getKey());
            } else if (((Integer) entry.getValue()).intValue() == i) {
                arrayList.add((Integer) entry.getKey());
            }
        }
        return vd.a.b(arrayList);
    }

    void b(int i) {
        Integer num = (Integer) this.a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }
}
