package kotlinx.serialization.descriptors;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class g {

    public static final class a implements Iterator, KMappedMarker {
        private int a;
        final /* synthetic */ f b;

        a(f fVar) {
            this.b = fVar;
            this.a = fVar.e();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f next() {
            f fVar = this.b;
            int e = fVar.e();
            int i = this.a;
            this.a = i - 1;
            return fVar.h(e - i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class b implements Iterator, KMappedMarker {
        private int a;
        final /* synthetic */ f b;

        b(f fVar) {
            this.b = fVar;
            this.a = fVar.e();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            f fVar = this.b;
            int e = fVar.e();
            int i = this.a;
            this.a = i - 1;
            return fVar.f(e - i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class c implements Iterable, KMappedMarker {
        final /* synthetic */ f a;

        public c(f fVar) {
            this.a = fVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new a(this.a);
        }
    }

    public static final class d implements Iterable, KMappedMarker {
        final /* synthetic */ f a;

        public d(f fVar) {
            this.a = fVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new b(this.a);
        }
    }

    public static final Iterable a(f fVar) {
        Intrinsics.h(fVar, "<this>");
        return new c(fVar);
    }

    public static final Iterable b(f fVar) {
        Intrinsics.h(fVar, "<this>");
        return new d(fVar);
    }
}
