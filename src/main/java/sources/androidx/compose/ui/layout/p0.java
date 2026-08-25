package androidx.compose.ui.layout;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface p0 {

    public static final class a implements Collection, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        private final Set f4193a;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a() {
            this(r0, 1, r0);
            Set set = null;
        }

        public a(Set set) {
            this.f4193a = set;
        }

        public /* synthetic */ a(Set set, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? new LinkedHashSet() : set);
        }

        @Override // java.util.Collection
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final boolean add(Object obj) {
            return this.f4193a.add(obj);
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public int c() {
            return this.f4193a.size();
        }

        @Override // java.util.Collection
        public final void clear() {
            this.f4193a.clear();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return this.f4193a.contains(obj);
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            return this.f4193a.containsAll(collection);
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.f4193a.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return this.f4193a.iterator();
        }

        @Override // java.util.Collection
        public final boolean remove(Object obj) {
            return this.f4193a.remove(obj);
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection collection) {
            return this.f4193a.remove(collection);
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate predicate) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection collection) {
            return this.f4193a.retainAll(collection);
        }

        @Override // java.util.Collection
        public final /* bridge */ int size() {
            return c();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.a(this);
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return CollectionToArray.b(this, objArr);
        }
    }

    void a(a aVar);

    boolean b(Object obj, Object obj2);
}
