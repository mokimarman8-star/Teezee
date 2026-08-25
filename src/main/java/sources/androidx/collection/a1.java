package androidx.collection;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class a1 {

    public static final class a implements Iterator, KMappedMarker {

        /* renamed from: a, reason: collision with root package name */
        private int f1258a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ y0 f1259b;

        a(y0 y0Var) {
            this.f1259b = y0Var;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1258a < this.f1259b.p();
        }

        @Override // java.util.Iterator
        public Object next() {
            y0 y0Var = this.f1259b;
            int i5 = this.f1258a;
            this.f1258a = i5 + 1;
            return y0Var.q(i5);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final Iterator a(y0 y0Var) {
        Intrinsics.h(y0Var, "<this>");
        return new a(y0Var);
    }
}
