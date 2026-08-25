package androidx.compose.foundation.lazy.layout;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final int f2034b = androidx.compose.runtime.collection.b.f2677d;

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.runtime.collection.b f2035a = new androidx.compose.runtime.collection.b(new a[16], 0);

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f2036a;

        /* renamed from: b, reason: collision with root package name */
        private final int f2037b;

        public a(int i5, int i6) {
            this.f2036a = i5;
            this.f2037b = i6;
            if (i5 < 0) {
                throw new IllegalArgumentException("negative start index");
            }
            if (i6 < i5) {
                throw new IllegalArgumentException("end index greater than start");
            }
        }

        public final int a() {
            return this.f2037b;
        }

        public final int b() {
            return this.f2036a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f2036a == aVar.f2036a && this.f2037b == aVar.f2037b;
        }

        public int hashCode() {
            return (this.f2036a * 31) + this.f2037b;
        }

        public String toString() {
            return "Interval(start=" + this.f2036a + ", end=" + this.f2037b + ')';
        }
    }

    public final a a(int i5, int i6) {
        a aVar = new a(i5, i6);
        this.f2035a.b(aVar);
        return aVar;
    }

    public final int b() {
        int a5 = ((a) this.f2035a.l()).a();
        androidx.compose.runtime.collection.b bVar = this.f2035a;
        int n5 = bVar.n();
        if (n5 > 0) {
            Object[] m5 = bVar.m();
            int i5 = 0;
            do {
                a aVar = (a) m5[i5];
                if (aVar.a() > a5) {
                    a5 = aVar.a();
                }
                i5++;
            } while (i5 < n5);
        }
        return a5;
    }

    public final int c() {
        int b5 = ((a) this.f2035a.l()).b();
        androidx.compose.runtime.collection.b bVar = this.f2035a;
        int n5 = bVar.n();
        if (n5 > 0) {
            Object[] m5 = bVar.m();
            int i5 = 0;
            do {
                a aVar = (a) m5[i5];
                if (aVar.b() < b5) {
                    b5 = aVar.b();
                }
                i5++;
            } while (i5 < n5);
        }
        if (b5 >= 0) {
            return b5;
        }
        throw new IllegalArgumentException("negative minIndex");
    }

    public final boolean d() {
        return this.f2035a.q();
    }

    public final void e(a aVar) {
        this.f2035a.t(aVar);
    }
}
