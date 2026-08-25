package dd;

import dd.d;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b extends d {
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final long f;

    /* renamed from: dd.b$b, reason: collision with other inner class name */
    static final class C0181b extends d.a {
        private String a;
        private String b;
        private String c;
        private String d;
        private long e;
        private byte f;

        C0181b() {
        }

        @Override // dd.d.a
        public d a() {
            if (this.f == 1 && this.a != null && this.b != null && this.c != null && this.d != null) {
                return new b(this.a, this.b, this.c, this.d, this.e);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.a == null) {
                sb2.append(" rolloutId");
            }
            if (this.b == null) {
                sb2.append(" variantId");
            }
            if (this.c == null) {
                sb2.append(" parameterKey");
            }
            if (this.d == null) {
                sb2.append(" parameterValue");
            }
            if ((1 & this.f) == 0) {
                sb2.append(" templateVersion");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // dd.d.a
        public d.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterKey");
            }
            this.c = str;
            return this;
        }

        @Override // dd.d.a
        public d.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null parameterValue");
            }
            this.d = str;
            return this;
        }

        @Override // dd.d.a
        public d.a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null rolloutId");
            }
            this.a = str;
            return this;
        }

        @Override // dd.d.a
        public d.a e(long j) {
            this.e = j;
            this.f = (byte) (this.f | 1);
            return this;
        }

        @Override // dd.d.a
        public d.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null variantId");
            }
            this.b = str;
            return this;
        }
    }

    private b(String str, String str2, String str3, String str4, long j) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = j;
    }

    @Override // dd.d
    public String b() {
        return this.d;
    }

    @Override // dd.d
    public String c() {
        return this.e;
    }

    @Override // dd.d
    public String d() {
        return this.b;
    }

    @Override // dd.d
    public long e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.b.equals(dVar.d()) && this.c.equals(dVar.f()) && this.d.equals(dVar.b()) && this.e.equals(dVar.c()) && this.f == dVar.e();
    }

    @Override // dd.d
    public String f() {
        return this.c;
    }

    public int hashCode() {
        int hashCode = (((((((this.b.hashCode() ^ 1000003) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003;
        long j = this.f;
        return hashCode ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.b + ", variantId=" + this.c + ", parameterKey=" + this.d + ", parameterValue=" + this.e + ", templateVersion=" + this.f + "}";
    }
}
