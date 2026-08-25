package kotlin.collections;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class o extends n {
    public static List T(List list) {
        Intrinsics.h(list, "<this>");
        return new ReversedListReadOnly(list);
    }

    public static List U(List list) {
        Intrinsics.h(list, "<this>");
        return new ReversedList(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int V(List list, int i) {
        if (i >= 0 && i <= CollectionsKt.n(list)) {
            return CollectionsKt.n(list) - i;
        }
        throw new IndexOutOfBoundsException("Element index " + i + " must be in range [" + new IntRange(0, CollectionsKt.n(list)) + "].");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int W(List list, int i) {
        return CollectionsKt.n(list) - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int X(List list, int i) {
        if (i >= 0 && i <= list.size()) {
            return list.size() - i;
        }
        throw new IndexOutOfBoundsException("Position index " + i + " must be in range [" + new IntRange(0, list.size()) + "].");
    }
}
