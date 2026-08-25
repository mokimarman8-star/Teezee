package kotlin.collections;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class a0 extends z {
    public static Set k(Set set, Object obj) {
        Intrinsics.h(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.e(set.size()));
        boolean z = false;
        for (Object obj2 : set) {
            boolean z2 = true;
            if (!z && Intrinsics.c(obj2, obj)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(obj2);
            }
        }
        return linkedHashSet;
    }

    public static Set l(Set set, Iterable elements) {
        int size;
        Intrinsics.h(set, "<this>");
        Intrinsics.h(elements, "elements");
        Integer w = k.w(elements);
        if (w != null) {
            size = set.size() + w.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.e(size));
        linkedHashSet.addAll(set);
        CollectionsKt.B(linkedHashSet, elements);
        return linkedHashSet;
    }
}
