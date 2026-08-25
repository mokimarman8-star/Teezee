package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b extends a {

    /* renamed from: c, reason: collision with root package name */
    private final Object[] f2702c;

    public b(Object[] objArr, int i5, int i6) {
        super(i5, i6);
        this.f2702c = objArr;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.f2702c;
        int e5 = e();
        h(e5 + 1);
        return objArr[e5];
    }

    @Override // java.util.ListIterator
    public Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.f2702c;
        h(e() - 1);
        return objArr[e()];
    }
}
