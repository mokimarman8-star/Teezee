package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i extends a {

    /* renamed from: c, reason: collision with root package name */
    private int f2719c;

    /* renamed from: d, reason: collision with root package name */
    private Object[] f2720d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f2721e;

    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public i(Object[] objArr, int i5, int i6, int i7) {
        super(i5, i6);
        this.f2719c = i7;
        Object[] objArr2 = new Object[i7];
        this.f2720d = objArr2;
        ?? r5 = i5 == i6 ? 1 : 0;
        this.f2721e = r5;
        objArr2[0] = objArr;
        l(i5 - r5, 1);
    }

    private final Object j() {
        int e5 = e() & 31;
        Object obj = this.f2720d[this.f2719c - 1];
        Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Array<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator>");
        return ((Object[]) obj)[e5];
    }

    private final void l(int i5, int i6) {
        int i7 = (this.f2719c - i6) * 5;
        while (i6 < this.f2719c) {
            Object[] objArr = this.f2720d;
            Object obj = objArr[i6 - 1];
            Intrinsics.f(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr[i6] = ((Object[]) obj)[j.a(i5, i7)];
            i7 -= 5;
            i6++;
        }
    }

    private final void m(int i5) {
        int i6 = 0;
        while (j.a(e(), i6) == i5) {
            i6 += 5;
        }
        if (i6 > 0) {
            l(e(), ((this.f2719c - 1) - (i6 / 5)) + 1);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public final void n(Object[] objArr, int i5, int i6, int i7) {
        h(i5);
        i(i6);
        this.f2719c = i7;
        if (this.f2720d.length < i7) {
            this.f2720d = new Object[i7];
        }
        this.f2720d[0] = objArr;
        ?? r02 = i5 == i6 ? 1 : 0;
        this.f2721e = r02;
        l(i5 - r02, 1);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object j5 = j();
        h(e() + 1);
        if (e() == f()) {
            this.f2721e = true;
            return j5;
        }
        m(0);
        return j5;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        h(e() - 1);
        if (this.f2721e) {
            this.f2721e = false;
            return j();
        }
        m(31);
        return j();
    }
}
