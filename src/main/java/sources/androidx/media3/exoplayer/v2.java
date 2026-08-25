package androidx.media3.exoplayer;

import java.util.Objects;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class v2 {

    /* renamed from: a, reason: collision with root package name */
    public final long f11725a;

    /* renamed from: b, reason: collision with root package name */
    public final float f11726b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11727c;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private long f11728a;

        /* renamed from: b, reason: collision with root package name */
        private float f11729b;

        /* renamed from: c, reason: collision with root package name */
        private long f11730c;

        public b() {
            this.f11728a = -9223372036854775807L;
            this.f11729b = -3.4028235E38f;
            this.f11730c = -9223372036854775807L;
        }

        private b(v2 v2Var) {
            this.f11728a = v2Var.f11725a;
            this.f11729b = v2Var.f11726b;
            this.f11730c = v2Var.f11727c;
        }

        public v2 d() {
            return new v2(this);
        }

        public b e(long j5) {
            androidx.media3.common.util.a.a(j5 >= 0 || j5 == -9223372036854775807L);
            this.f11730c = j5;
            return this;
        }

        public b f(long j5) {
            this.f11728a = j5;
            return this;
        }

        public b g(float f5) {
            androidx.media3.common.util.a.a(f5 > 0.0f || f5 == -3.4028235E38f);
            this.f11729b = f5;
            return this;
        }
    }

    private v2(b bVar) {
        this.f11725a = bVar.f11728a;
        this.f11726b = bVar.f11729b;
        this.f11727c = bVar.f11730c;
    }

    public b a() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v2)) {
            return false;
        }
        v2 v2Var = (v2) obj;
        return this.f11725a == v2Var.f11725a && this.f11726b == v2Var.f11726b && this.f11727c == v2Var.f11727c;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.f11725a), Float.valueOf(this.f11726b), Long.valueOf(this.f11727c));
    }
}
