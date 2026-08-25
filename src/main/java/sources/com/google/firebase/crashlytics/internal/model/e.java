package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$c;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class e extends CrashlyticsReport$c {
    private final String a;
    private final String b;

    static final class b extends CrashlyticsReport$c.a {
        private String a;
        private String b;

        b() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$c.a
        public CrashlyticsReport$c a() {
            String str;
            String str2 = this.a;
            if (str2 != null && (str = this.b) != null) {
                return new e(str2, str);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.a == null) {
                sb2.append(" key");
            }
            if (this.b == null) {
                sb2.append(" value");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$c.a
        public CrashlyticsReport$c.a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$c.a
        public CrashlyticsReport$c.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null value");
            }
            this.b = str;
            return this;
        }
    }

    private e(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$c
    public String b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$c
    public String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport$c)) {
            return false;
        }
        CrashlyticsReport$c crashlyticsReport$c = (CrashlyticsReport$c) obj;
        return this.a.equals(crashlyticsReport$c.b()) && this.b.equals(crashlyticsReport$c.c());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.a + ", value=" + this.b + "}";
    }
}
