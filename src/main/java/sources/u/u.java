package u;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class u implements Iterator, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private Object[] f17951a = t.f17942e.a().p();

    /* renamed from: b, reason: collision with root package name */
    private int f17952b;

    /* renamed from: c, reason: collision with root package name */
    private int f17953c;

    public final Object a() {
        w.a.a(h());
        return this.f17951a[this.f17953c];
    }

    public final t c() {
        w.a.a(i());
        Object obj = this.f17951a[this.f17953c];
        Intrinsics.f(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator>");
        return (t) obj;
    }

    protected final Object[] e() {
        return this.f17951a;
    }

    protected final int f() {
        return this.f17953c;
    }

    public final boolean h() {
        return this.f17953c < this.f17952b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return h();
    }

    public final boolean i() {
        w.a.a(this.f17953c >= this.f17952b);
        return this.f17953c < this.f17951a.length;
    }

    public final void j() {
        w.a.a(h());
        this.f17953c += 2;
    }

    public final void l() {
        w.a.a(i());
        this.f17953c++;
    }

    public final void m(Object[] objArr, int i5) {
        n(objArr, i5, 0);
    }

    public final void n(Object[] objArr, int i5, int i6) {
        this.f17951a = objArr;
        this.f17952b = i5;
        this.f17953c = i6;
    }

    protected final void o(int i5) {
        this.f17953c = i5;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
