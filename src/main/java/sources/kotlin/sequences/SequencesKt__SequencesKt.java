package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt__SequencesKt$asSequence$;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
class SequencesKt__SequencesKt extends d {
    public static Sequence e(Iterator it) {
        Intrinsics.h(it, "<this>");
        return SequencesKt.f(new SequencesKt__SequencesKt$asSequence$.inlined.Sequence.1(it));
    }

    public static Sequence f(Sequence sequence) {
        Intrinsics.h(sequence, "<this>");
        return sequence instanceof ConstrainedOnceSequence ? sequence : new ConstrainedOnceSequence(sequence);
    }

    public static final Sequence g() {
        return b.a;
    }

    public static Sequence h(Object obj, Function1 function1) {
        Intrinsics.h(function1, "nextFunction");
        return obj == null ? b.a : new GeneratorSequence(new e(obj), function1);
    }

    public static Sequence i(Function0 function0) {
        Intrinsics.h(function0, "nextFunction");
        return SequencesKt.f(new GeneratorSequence(function0, new f(function0)));
    }

    public static Sequence j(Function0 function0, Function1 function1) {
        Intrinsics.h(function0, "seedFunction");
        Intrinsics.h(function1, "nextFunction");
        return new GeneratorSequence(function0, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object k(Function0 function0, Object obj) {
        Intrinsics.h(obj, "it");
        return function0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object l(Object obj) {
        return obj;
    }
}
