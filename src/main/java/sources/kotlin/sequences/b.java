package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.EmptyIterator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class b implements Sequence, DropTakeSequence {
    public static final b a = new b();

    private b() {
    }

    @Override // kotlin.sequences.DropTakeSequence
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b a(int i) {
        return a;
    }

    @Override // kotlin.sequences.Sequence
    /* renamed from: iterator */
    public Iterator getA() {
        return EmptyIterator.a;
    }
}
