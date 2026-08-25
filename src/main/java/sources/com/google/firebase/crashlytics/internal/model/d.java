package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class d extends CrashlyticsReport$a.a {
    private final String a;
    private final String b;
    private final String c;

    static final class b extends CrashlyticsReport$a.a.AbstractC0020a {
        private String a;
        private String b;
        private String c;

        b() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.a.AbstractC0020a
        public CrashlyticsReport$a.a a() {
            String str;
            String str2;
            String str3 = this.a;
            if (str3 != null && (str = this.b) != null && (str2 = this.c) != null) {
                return new d(str3, str, str2);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.a == null) {
                sb2.append(" arch");
            }
            if (this.b == null) {
                sb2.append(" libraryName");
            }
            if (this.c == null) {
                sb2.append(" buildId");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.a.AbstractC0020a
        public CrashlyticsReport$a.a.AbstractC0020a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null arch");
            }
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.a.AbstractC0020a
        public CrashlyticsReport$a.a.AbstractC0020a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildId");
            }
            this.c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.a.AbstractC0020a
        public CrashlyticsReport$a.a.AbstractC0020a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null libraryName");
            }
            this.b = str;
            return this;
        }
    }

    private d(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.a
    public String b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.a
    public String c() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a.a
    public String d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport$a.a)) {
            return false;
        }
        CrashlyticsReport$a.a aVar = (CrashlyticsReport$a.a) obj;
        return this.a.equals(aVar.b()) && this.b.equals(aVar.d()) && this.c.equals(aVar.c());
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        return "BuildIdMappingForArch{arch=" + this.a + ", libraryName=" + this.b + ", buildId=" + this.c + "}";
    }
}
