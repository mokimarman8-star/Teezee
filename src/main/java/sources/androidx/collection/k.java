package androidx.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMutableIterator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class k implements Iterator, KMutableIterator {

    /* renamed from: a, reason: collision with root package name */
    private int f1286a;

    /* renamed from: b, reason: collision with root package name */
    private int f1287b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1288c;

    public k(int i5) {
        this.f1286a = i5;
    }

    protected abstract Object a(int i5);

    protected abstract void c(int i5);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f1287b < this.f1286a;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object a5 = a(this.f1287b);
        this.f1287b++;
        this.f1288c = true;
        return a5;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.f1288c) {
            n.d.b("Call next() before removing an element.");
        }
        int i5 = this.f1287b - 1;
        this.f1287b = i5;
        c(i5);
        this.f1286a--;
        this.f1288c = false;
    }
}
