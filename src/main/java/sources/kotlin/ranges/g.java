package kotlin.ranges;

import androidx.collection.b0;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class g implements Iterator, KMappedMarker {
    private final long a;
    private boolean b;
    private final long c;
    private long d;

    private g(long j, long j2, long j3) {
        this.a = j2;
        boolean z = false;
        if (j3 <= 0 ? b0.a(j, j2) >= 0 : b0.a(j, j2) <= 0) {
            z = true;
        }
        this.b = z;
        this.c = ULong.b(j3);
        this.d = this.b ? j : j2;
    }

    public /* synthetic */ g(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }

    public long a() {
        long j = this.d;
        if (j != this.a) {
            this.d = ULong.b(this.c + j);
        } else {
            if (!this.b) {
                throw new NoSuchElementException();
            }
            this.b = false;
        }
        return j;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return ULong.a(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
