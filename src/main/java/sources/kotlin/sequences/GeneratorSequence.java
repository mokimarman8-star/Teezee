package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class GeneratorSequence implements Sequence {
    private final Function0 a;
    private final Function1 b;

    public GeneratorSequence(Function0 getInitialValue, Function1 getNextValue) {
        Intrinsics.h(getInitialValue, "getInitialValue");
        Intrinsics.h(getNextValue, "getNextValue");
        this.a = getInitialValue;
        this.b = getNextValue;
    }

    @Override // kotlin.sequences.Sequence
    /* renamed from: iterator */
    public Iterator getA() {
        return new GeneratorSequence$iterator$1(this);
    }
}
