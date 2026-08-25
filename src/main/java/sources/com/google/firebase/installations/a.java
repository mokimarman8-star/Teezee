package com.google.firebase.installations;

import com.google.firebase.installations.f;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class a extends f {
    private final String a;
    private final long b;
    private final long c;

    static final class b extends f.a {
        private String a;
        private Long b;
        private Long c;

        b() {
        }

        @Override // com.google.firebase.installations.f.a
        public f a() {
            String str = this.a;
            String str2 = TtmlNode.ANONYMOUS_REGION_ID;
            if (str == null) {
                str2 = TtmlNode.ANONYMOUS_REGION_ID + " token";
            }
            if (this.b == null) {
                str2 = str2 + " tokenExpirationTimestamp";
            }
            if (this.c == null) {
                str2 = str2 + " tokenCreationTimestamp";
            }
            if (str2.isEmpty()) {
                return new a(this.a, this.b.longValue(), this.c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // com.google.firebase.installations.f.a
        public f.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null token");
            }
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.installations.f.a
        public f.a c(long j) {
            this.c = Long.valueOf(j);
            return this;
        }

        @Override // com.google.firebase.installations.f.a
        public f.a d(long j) {
            this.b = Long.valueOf(j);
            return this;
        }
    }

    private a(String str, long j, long j2) {
        this.a = str;
        this.b = j;
        this.c = j2;
    }

    @Override // com.google.firebase.installations.f
    public String b() {
        return this.a;
    }

    @Override // com.google.firebase.installations.f
    public long c() {
        return this.c;
    }

    @Override // com.google.firebase.installations.f
    public long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.a.equals(fVar.b()) && this.b == fVar.d() && this.c == fVar.c();
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        long j = this.b;
        long j2 = this.c;
        return ((hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        return "InstallationTokenResult{token=" + this.a + ", tokenExpirationTimestamp=" + this.b + ", tokenCreationTimestamp=" + this.c + "}";
    }
}
