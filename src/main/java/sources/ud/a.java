package ud;

import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
abstract class a {
    static kd.a a(List list) {
        int size = list.size() * 2;
        int i = size - 1;
        if (((b) list.get(list.size() - 1)).c() == null) {
            i = size - 2;
        }
        kd.a aVar = new kd.a(i * 12);
        int i2 = 0;
        int b = ((b) list.get(0)).c().b();
        for (int i3 = 11; i3 >= 0; i3--) {
            if (((1 << i3) & b) != 0) {
                aVar.r(i2);
            }
            i2++;
        }
        for (int i4 = 1; i4 < list.size(); i4++) {
            b bVar = (b) list.get(i4);
            int b2 = bVar.b().b();
            for (int i5 = 11; i5 >= 0; i5--) {
                if (((1 << i5) & b2) != 0) {
                    aVar.r(i2);
                }
                i2++;
            }
            if (bVar.c() != null) {
                int b3 = bVar.c().b();
                for (int i6 = 11; i6 >= 0; i6--) {
                    if (((1 << i6) & b3) != 0) {
                        aVar.r(i2);
                    }
                    i2++;
                }
            }
        }
        return aVar;
    }
}
