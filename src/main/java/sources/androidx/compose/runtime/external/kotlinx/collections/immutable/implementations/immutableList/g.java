package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class g extends a {

    /* renamed from: c, reason: collision with root package name */
    private final Object f2714c;

    public g(Object obj, int i5) {
        super(i5, 1);
        this.f2714c = obj;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        a();
        h(e() + 1);
        return this.f2714c;
    }

    @Override // java.util.ListIterator
    public Object previous() {
        c();
        h(e() - 1);
        return this.f2714c;
    }
}
