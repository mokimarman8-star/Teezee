package kotlin.io;

import java.io.BufferedReader;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class LinesSequence implements Sequence {
    private final BufferedReader a;

    public LinesSequence(BufferedReader reader) {
        Intrinsics.h(reader, "reader");
        this.a = reader;
    }

    @Override // kotlin.sequences.Sequence
    /* renamed from: iterator */
    public Iterator getA() {
        return new LinesSequence$iterator$1(this);
    }
}
