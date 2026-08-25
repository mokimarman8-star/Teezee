package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$d;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class f extends CrashlyticsReport$d {
    private final List a;
    private final String b;

    static final class b extends CrashlyticsReport$d.a {
        private List a;
        private String b;

        b() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$d.a
        public CrashlyticsReport$d a() {
            List list = this.a;
            if (list != null) {
                return new f(list, this.b);
            }
            throw new IllegalStateException("Missing required properties: files");
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$d.a
        public CrashlyticsReport$d.a b(List list) {
            if (list == null) {
                throw new NullPointerException("Null files");
            }
            this.a = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$d.a
        public CrashlyticsReport$d.a c(String str) {
            this.b = str;
            return this;
        }
    }

    private f(List list, String str) {
        this.a = list;
        this.b = str;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$d
    public List b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$d
    public String c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport$d)) {
            return false;
        }
        CrashlyticsReport$d crashlyticsReport$d = (CrashlyticsReport$d) obj;
        if (this.a.equals(crashlyticsReport$d.b())) {
            String str = this.b;
            if (str == null) {
                if (crashlyticsReport$d.c() == null) {
                    return true;
                }
            } else if (str.equals(crashlyticsReport$d.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.b;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilesPayload{files=" + this.a + ", orgId=" + this.b + "}";
    }
}
