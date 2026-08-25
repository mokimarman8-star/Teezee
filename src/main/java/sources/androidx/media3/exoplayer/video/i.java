package androidx.media3.exoplayer.video;

import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class i {

    /* renamed from: c, reason: collision with root package name */
    private boolean f11798c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11799d;

    /* renamed from: f, reason: collision with root package name */
    private int f11801f;

    /* renamed from: a, reason: collision with root package name */
    private a f11796a = new a();

    /* renamed from: b, reason: collision with root package name */
    private a f11797b = new a();

    /* renamed from: e, reason: collision with root package name */
    private long f11800e = -9223372036854775807L;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f11802a;

        /* renamed from: b, reason: collision with root package name */
        private long f11803b;

        /* renamed from: c, reason: collision with root package name */
        private long f11804c;

        /* renamed from: d, reason: collision with root package name */
        private long f11805d;

        /* renamed from: e, reason: collision with root package name */
        private long f11806e;

        /* renamed from: f, reason: collision with root package name */
        private long f11807f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean[] f11808g = new boolean[15];

        /* renamed from: h, reason: collision with root package name */
        private int f11809h;

        private static int c(long j5) {
            return (int) (j5 % 15);
        }

        public long a() {
            long j5 = this.f11806e;
            if (j5 == 0) {
                return 0L;
            }
            return this.f11807f / j5;
        }

        public long b() {
            return this.f11807f;
        }

        public boolean d() {
            long j5 = this.f11805d;
            if (j5 == 0) {
                return false;
            }
            return this.f11808g[c(j5 - 1)];
        }

        public boolean e() {
            return this.f11805d > 15 && this.f11809h == 0;
        }

        public void f(long j5) {
            long j6 = this.f11805d;
            if (j6 == 0) {
                this.f11802a = j5;
            } else if (j6 == 1) {
                long j7 = j5 - this.f11802a;
                this.f11803b = j7;
                this.f11807f = j7;
                this.f11806e = 1L;
            } else {
                long j8 = j5 - this.f11804c;
                int c5 = c(j6);
                if (Math.abs(j8 - this.f11803b) <= 1000000) {
                    this.f11806e++;
                    this.f11807f += j8;
                    boolean[] zArr = this.f11808g;
                    if (zArr[c5]) {
                        zArr[c5] = false;
                        this.f11809h--;
                    }
                } else {
                    boolean[] zArr2 = this.f11808g;
                    if (!zArr2[c5]) {
                        zArr2[c5] = true;
                        this.f11809h++;
                    }
                }
            }
            this.f11805d++;
            this.f11804c = j5;
        }

        public void g() {
            this.f11805d = 0L;
            this.f11806e = 0L;
            this.f11807f = 0L;
            this.f11809h = 0;
            Arrays.fill(this.f11808g, false);
        }
    }

    public long a() {
        if (e()) {
            return this.f11796a.a();
        }
        return -9223372036854775807L;
    }

    public float b() {
        if (e()) {
            return (float) (1.0E9d / this.f11796a.a());
        }
        return -1.0f;
    }

    public int c() {
        return this.f11801f;
    }

    public long d() {
        if (e()) {
            return this.f11796a.b();
        }
        return -9223372036854775807L;
    }

    public boolean e() {
        return this.f11796a.e();
    }

    public void f(long j5) {
        this.f11796a.f(j5);
        if (this.f11796a.e() && !this.f11799d) {
            this.f11798c = false;
        } else if (this.f11800e != -9223372036854775807L) {
            if (!this.f11798c || this.f11797b.d()) {
                this.f11797b.g();
                this.f11797b.f(this.f11800e);
            }
            this.f11798c = true;
            this.f11797b.f(j5);
        }
        if (this.f11798c && this.f11797b.e()) {
            a aVar = this.f11796a;
            this.f11796a = this.f11797b;
            this.f11797b = aVar;
            this.f11798c = false;
            this.f11799d = false;
        }
        this.f11800e = j5;
        this.f11801f = this.f11796a.e() ? 0 : this.f11801f + 1;
    }

    public void g() {
        this.f11796a.g();
        this.f11797b.g();
        this.f11798c = false;
        this.f11800e = -9223372036854775807L;
        this.f11801f = 0;
    }
}
