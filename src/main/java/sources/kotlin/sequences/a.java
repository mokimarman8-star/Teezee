package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class a extends AbstractIterator {
    private final Iterator c;
    private final Function1 d;
    private final HashSet e;

    public a(Iterator source, Function1 keySelector) {
        Intrinsics.h(source, "source");
        Intrinsics.h(keySelector, "keySelector");
        this.c = source;
        this.d = keySelector;
        this.e = new HashSet();
    }

    @Override // kotlin.collections.AbstractIterator
    protected void a() {
        while (this.c.hasNext()) {
            Object next = this.c.next();
            if (this.e.add(this.d.invoke(next))) {
                e(next);
                return;
            }
        }
        c();
    }
}
