package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
class SequencesKt__SequenceBuilderKt {
    public static Iterator a(Function2 block) {
        Intrinsics.h(block, "block");
        c cVar = new c();
        cVar.i(IntrinsicsKt.a(block, cVar, cVar));
        return cVar;
    }

    public static Sequence b(final Function2 block) {
        Intrinsics.h(block, "block");
        return new Sequence<Object>() { // from class: kotlin.sequences.SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            /* renamed from: iterator */
            public Iterator getA() {
                return SequencesKt.a(Function2.this);
            }
        };
    }
}
