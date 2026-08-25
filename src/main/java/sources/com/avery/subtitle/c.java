package com.avery.subtitle;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract class c {
    public static m5.b a(long j, List list) {
        if (list != null && !list.isEmpty()) {
            int size = list.size() - 1;
            int i = 0;
            while (i <= size) {
                int i2 = (i + size) / 2;
                m5.b bVar = (m5.b) list.get(i2);
                int i3 = bVar.b.a;
                if (j >= i3) {
                    int i4 = bVar.c.a;
                    if (j > i4) {
                        if (j < i3) {
                            return bVar;
                        }
                        i = i2 + 1;
                    } else if (j >= i3 && j <= i4) {
                        return bVar;
                    }
                } else {
                    if (j > bVar.c.a) {
                        return bVar;
                    }
                    size = i2 - 1;
                }
            }
        }
        return null;
    }
}
