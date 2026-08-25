package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a implements ListIterator, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private int f2700a;

    /* renamed from: b, reason: collision with root package name */
    private int f2701b;

    public a(int i5, int i6) {
        this.f2700a = i5;
        this.f2701b = i6;
    }

    public final void a() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void c() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
    }

    public final int e() {
        return this.f2700a;
    }

    public final int f() {
        return this.f2701b;
    }

    public final void h(int i5) {
        this.f2700a = i5;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.f2700a < this.f2701b;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.f2700a > 0;
    }

    public final void i(int i5) {
        this.f2701b = i5;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.f2700a;
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.f2700a - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
