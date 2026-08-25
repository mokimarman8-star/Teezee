package c9;

import c9.e;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class a extends e {
    private final long b;
    private final int c;
    private final int d;
    private final long e;
    private final int f;

    static final class b extends e.a {
        private Long a;
        private Integer b;
        private Integer c;
        private Long d;
        private Integer e;

        b() {
        }

        @Override // c9.e.a
        e a() {
            String str = "";
            if (this.a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.b == null) {
                str = str + " loadBatchSize";
            }
            if (this.c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.a.longValue(), this.b.intValue(), this.c.intValue(), this.d.longValue(), this.e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // c9.e.a
        e.a b(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        @Override // c9.e.a
        e.a c(long j) {
            this.d = Long.valueOf(j);
            return this;
        }

        @Override // c9.e.a
        e.a d(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        @Override // c9.e.a
        e.a e(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        @Override // c9.e.a
        e.a f(long j) {
            this.a = Long.valueOf(j);
            return this;
        }
    }

    private a(long j, int i, int i2, long j2, int i3) {
        this.b = j;
        this.c = i;
        this.d = i2;
        this.e = j2;
        this.f = i3;
    }

    @Override // c9.e
    int b() {
        return this.d;
    }

    @Override // c9.e
    long c() {
        return this.e;
    }

    @Override // c9.e
    int d() {
        return this.c;
    }

    @Override // c9.e
    int e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.b == eVar.f() && this.c == eVar.d() && this.d == eVar.b() && this.e == eVar.c() && this.f == eVar.e();
    }

    @Override // c9.e
    long f() {
        return this.b;
    }

    public int hashCode() {
        long j = this.b;
        int i = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003;
        long j2 = this.e;
        return ((i ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f;
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.b + ", loadBatchSize=" + this.c + ", criticalSectionEnterTimeoutMs=" + this.d + ", eventCleanUpAge=" + this.e + ", maxBlobByteSizePerRow=" + this.f + "}";
    }
}
