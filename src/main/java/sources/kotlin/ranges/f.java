package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class f implements Iterator, KMappedMarker {
    private final int a;
    private boolean b;
    private final int c;
    private int d;

    private f(int i, int i2, int i3) {
        int compare;
        this.a = i2;
        boolean z = false;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
        if (i3 <= 0 ? compare >= 0 : compare <= 0) {
            z = true;
        }
        this.b = z;
        this.c = UInt.b(i3);
        this.d = this.b ? i : i2;
    }

    public /* synthetic */ f(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3);
    }

    public int a() {
        int i = this.d;
        if (i != this.a) {
            this.d = UInt.b(this.c + i);
        } else {
            if (!this.b) {
                throw new NoSuchElementException();
            }
            this.b = false;
        }
        return i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return UInt.a(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
