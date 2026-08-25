package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.collections.FloatIterator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class e extends FloatIterator {
    private final float[] a;
    private int b;

    public e(float[] array) {
        Intrinsics.h(array, "array");
        this.a = array;
    }

    @Override // kotlin.collections.FloatIterator
    public float a() {
        try {
            float[] fArr = this.a;
            int i = this.b;
            this.b = i + 1;
            return fArr[i];
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
