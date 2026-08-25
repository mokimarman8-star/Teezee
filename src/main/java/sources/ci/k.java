package ci;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k {
    public static final k a = new k();

    private k() {
    }

    public final boolean a(List list, List list2) {
        Intrinsics.h(list, "list1");
        Intrinsics.h(list2, "list2");
        return !CollectionsKt.o0(list, CollectionsKt.W0(list2)).isEmpty();
    }
}
