package x8;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class d {
    private static final d c = new a().a();
    private final long a;
    private final long b;

    public static final class a {
        private long a = 0;
        private long b = 0;

        a() {
        }

        public d a() {
            return new d(this.a, this.b);
        }

        public a b(long j) {
            this.a = j;
            return this;
        }

        public a c(long j) {
            this.b = j;
            return this;
        }
    }

    d(long j, long j2) {
        this.a = j;
        this.b = j2;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.a;
    }

    public long b() {
        return this.b;
    }
}
