package n0;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class i implements Collection, KMappedMarker {

    /* renamed from: c, reason: collision with root package name */
    public static final a f16559c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final i f16560d = new i(CollectionsKt.l());

    /* renamed from: a, reason: collision with root package name */
    private final List f16561a;

    /* renamed from: b, reason: collision with root package name */
    private final int f16562b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i a() {
            return k.a().d();
        }

        public final i b() {
            return i.f16560d;
        }
    }

    public i(List list) {
        this.f16561a = list;
        this.f16562b = list.size();
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean c(h hVar) {
        return this.f16561a.contains(hVar);
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof h) {
            return c((h) obj);
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.f16561a.containsAll(collection);
    }

    public final h e(int i5) {
        return (h) this.f16561a.get(i5);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && Intrinsics.c(this.f16561a, ((i) obj).f16561a);
    }

    public final List f() {
        return this.f16561a;
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.f16561a.hashCode();
    }

    public int i() {
        return this.f16562b;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f16561a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f16561a.iterator();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate predicate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return i();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return CollectionToArray.b(this, objArr);
    }

    public String toString() {
        return "LocaleList(localeList=" + this.f16561a + ')';
    }
}
