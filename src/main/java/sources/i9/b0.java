package i9;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public interface b0 {

    public static final class a {
        public final c0 a;
        public final c0 b;

        public a(c0 c0Var) {
            this(c0Var, c0Var);
        }

        public a(c0 c0Var, c0 c0Var2) {
            this.a = (c0) com.google.android.exoplayer2.util.a.e(c0Var);
            this.b = (c0) com.google.android.exoplayer2.util.a.e(c0Var2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a.equals(aVar.a) && this.b.equals(aVar.b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.a);
            if (this.a.equals(this.b)) {
                str = "";
            } else {
                str = ", " + this.b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }
    }

    public static class b implements b0 {
        private final long a;
        private final a b;

        public b(long j) {
            this(j, 0L);
        }

        public b(long j, long j2) {
            this.a = j;
            this.b = new a(j2 == 0 ? c0.c : new c0(0L, j2));
        }

        @Override // i9.b0
        public long getDurationUs() {
            return this.a;
        }

        @Override // i9.b0
        public a getSeekPoints(long j) {
            return this.b;
        }

        @Override // i9.b0
        public boolean isSeekable() {
            return false;
        }
    }

    long getDurationUs();

    a getSeekPoints(long j);

    boolean isSeekable();
}
