package kotlin.collections;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class x extends w {
    public static Sequence x(Map map) {
        Intrinsics.h(map, "<this>");
        return CollectionsKt.Z(map.entrySet());
    }
}
