package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.CharIterator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class c extends CharIterator {
    private final char[] a;
    private int b;

    public c(char[] array) {
        Intrinsics.h(array, "array");
        this.a = array;
    }

    @Override // kotlin.collections.CharIterator
    public char a() {
        try {
            char[] cArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return cArr[i];
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
