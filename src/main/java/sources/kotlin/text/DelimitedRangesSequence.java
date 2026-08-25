package kotlin.text;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class DelimitedRangesSequence implements Sequence {
    private final CharSequence a;
    private final int b;
    private final int c;
    private final Function2 d;

    public DelimitedRangesSequence(CharSequence input, int i, int i2, Function2 getNextMatch) {
        Intrinsics.h(input, "input");
        Intrinsics.h(getNextMatch, "getNextMatch");
        this.a = input;
        this.b = i;
        this.c = i2;
        this.d = getNextMatch;
    }

    @Override // kotlin.sequences.Sequence
    /* renamed from: iterator */
    public Iterator getA() {
        return new DelimitedRangesSequence$iterator$1(this);
    }
}
