package androidx.appcompat.app;

import java.util.LinkedHashSet;
import java.util.Locale;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class z {
    private static androidx.core.os.i a(androidx.core.os.i iVar, androidx.core.os.i iVar2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i5 = 0;
        while (i5 < iVar.g() + iVar2.g()) {
            Locale d5 = i5 < iVar.g() ? iVar.d(i5) : iVar2.d(i5 - iVar.g());
            if (d5 != null) {
                linkedHashSet.add(d5);
            }
            i5++;
        }
        return androidx.core.os.i.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    static androidx.core.os.i b(androidx.core.os.i iVar, androidx.core.os.i iVar2) {
        return (iVar == null || iVar.f()) ? androidx.core.os.i.e() : a(iVar, iVar2);
    }
}
