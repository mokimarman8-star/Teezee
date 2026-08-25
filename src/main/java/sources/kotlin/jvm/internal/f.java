package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.IntIterator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class f extends IntIterator {
    private final int[] a;
    private int b;

    public f(int[] array) {
        Intrinsics.h(array, "array");
        this.a = array;
    }

    @Override // kotlin.collections.IntIterator
    public int a() {
        try {
            int[] iArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return iArr[i];
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
