package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.BooleanIterator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class a extends BooleanIterator {
    private final boolean[] a;
    private int b;

    public a(boolean[] array) {
        Intrinsics.h(array, "array");
        this.a = array;
    }

    @Override // kotlin.collections.BooleanIterator
    public boolean a() {
        try {
            boolean[] zArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return zArr[i];
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
