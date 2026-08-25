package k2;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface m0 {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final n0 f16249a;

        /* renamed from: b, reason: collision with root package name */
        public final n0 f16250b;

        public a(n0 n0Var) {
            this(n0Var, n0Var);
        }

        public a(n0 n0Var, n0 n0Var2) {
            this.f16249a = (n0) androidx.media3.common.util.a.e(n0Var);
            this.f16250b = (n0) androidx.media3.common.util.a.e(n0Var2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f16249a.equals(aVar.f16249a) && this.f16250b.equals(aVar.f16250b);
        }

        public int hashCode() {
            return (this.f16249a.hashCode() * 31) + this.f16250b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f16249a);
            if (this.f16249a.equals(this.f16250b)) {
                str = "";
            } else {
                str = ", " + this.f16250b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }
    }

    public static class b implements m0 {

        /* renamed from: a, reason: collision with root package name */
        private final long f16251a;

        /* renamed from: b, reason: collision with root package name */
        private final a f16252b;

        public b(long j5) {
            this(j5, 0L);
        }

        public b(long j5, long j6) {
            this.f16251a = j5;
            this.f16252b = new a(j6 == 0 ? n0.f16254c : new n0(0L, j6));
        }

        @Override // k2.m0
        public long getDurationUs() {
            return this.f16251a;
        }

        @Override // k2.m0
        public a getSeekPoints(long j5) {
            return this.f16252b;
        }

        @Override // k2.m0
        public boolean isSeekable() {
            return false;
        }
    }

    long getDurationUs();

    a getSeekPoints(long j5);

    boolean isSeekable();
}
