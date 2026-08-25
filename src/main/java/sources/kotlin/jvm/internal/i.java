package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.ShortIterator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class i extends ShortIterator {
    private final short[] a;
    private int b;

    public i(short[] array) {
        Intrinsics.h(array, "array");
        this.a = array;
    }

    @Override // kotlin.collections.ShortIterator
    public short a() {
        try {
            short[] sArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return sArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.b--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b < this.a.length;
    }
}
