package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class c extends CrashlyticsReport$a {
    private final int a;
    private final String b;
    private final int c;
    private final int d;
    private final long e;
    private final long f;
    private final long g;
    private final String h;
    private final List i;

    static final class b extends CrashlyticsReport$a.b {
        private int a;
        private String b;
        private int c;
        private int d;
        private long e;
        private long f;
        private long g;
        private String h;
        private List i;
        private byte j;

        b() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.b
        public CrashlyticsReport$a a() {
            String str;
            if (this.j == 63 && (str = this.b) != null) {
                return new c(this.a, str, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
            }
            StringBuilder sb2 = new StringBuilder();
            if ((this.j & 1) == 0) {
                sb2.append(" pid");
            }
            if (this.b == null) {
                sb2.append(" processName");
            }
            if ((this.j & 2) == 0) {
                sb2.append(" reasonCode");
            }
            if ((this.j & 4) == 0) {
                sb2.append(" importance");
            }
            if ((this.j & 8) == 0) {
                sb2.append(" pss");
            }
            if ((this.j & 16) == 0) {
                sb2.append(" rss");
            }
            if ((this.j & 32) == 0) {
                sb2.append(" timestamp");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.b
        public CrashlyticsReport$a.b b(List list) {
            this.i = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.b
        public CrashlyticsReport$a.b c(int i) {
            this.d = i;
            this.j = (byte) (this.j | 4);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.b
        public CrashlyticsReport$a.b d(int i) {
            this.a = i;
            this.j = (byte) (this.j | 1);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.b
        public CrashlyticsReport$a.b e(String str) {
            if (str == null) {
                throw new NullPointerException("Null processName");
            }
            this.b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.b
        public CrashlyticsReport$a.b f(long j) {
            this.e = j;
            this.j = (byte) (this.j | 8);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.b
        public CrashlyticsReport$a.b g(int i) {
            this.c = i;
            this.j = (byte) (this.j | 2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.b
        public CrashlyticsReport$a.b h(long j) {
            this.f = j;
            this.j = (byte) (this.j | 16);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.b
        public CrashlyticsReport$a.b i(long j) {
            this.g = j;
            this.j = (byte) (this.j | 32);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.b
        public CrashlyticsReport$a.b j(String str) {
            this.h = str;
            return this;
        }
    }

    private c(int i, String str, int i2, int i3, long j, long j2, long j3, String str2, List list) {
        this.a = i;
        this.b = str;
        this.c = i2;
        this.d = i3;
        this.e = j;
        this.f = j2;
        this.g = j3;
        this.h = str2;
        this.i = list;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a
    public List b() {
        return this.i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a
    public int c() {
        return this.d;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a
    public int d() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a
    public String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport$a)) {
            return false;
        }
        CrashlyticsReport$a crashlyticsReport$a = (CrashlyticsReport$a) obj;
        if (this.a == crashlyticsReport$a.d() && this.b.equals(crashlyticsReport$a.e()) && this.c == crashlyticsReport$a.g() && this.d == crashlyticsReport$a.c() && this.e == crashlyticsReport$a.f() && this.f == crashlyticsReport$a.h() && this.g == crashlyticsReport$a.i() && ((str = this.h) != null ? str.equals(crashlyticsReport$a.j()) : crashlyticsReport$a.j() == null)) {
            List list = this.i;
            if (list == null) {
                if (crashlyticsReport$a.b() == null) {
                    return true;
                }
            } else if (list.equals(crashlyticsReport$a.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a
    public long f() {
        return this.e;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a
    public int g() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a
    public long h() {
        return this.f;
    }

    public int hashCode() {
        int hashCode = (((((((this.a ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003;
        long j = this.e;
        int i = (hashCode ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.f;
        int i2 = (i ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.g;
        int i3 = (i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        String str = this.h;
        int hashCode2 = (i3 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List list = this.i;
        return hashCode2 ^ (list != null ? list.hashCode() : 0);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a
    public long i() {
        return this.g;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a
    public String j() {
        return this.h;
    }

    public String toString() {
        return "ApplicationExitInfo{pid=" + this.a + ", processName=" + this.b + ", reasonCode=" + this.c + ", importance=" + this.d + ", pss=" + this.e + ", rss=" + this.f + ", timestamp=" + this.g + ", traceFile=" + this.h + ", buildIdMappingForArch=" + this.i + "}";
    }
}
