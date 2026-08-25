package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$d;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class g extends CrashlyticsReport$d.b {
    private final String a;
    private final byte[] b;

    static final class b extends CrashlyticsReport$d.b.a {
        private String a;
        private byte[] b;

        b() {
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.b.a
        public CrashlyticsReport$d.b a() {
            byte[] bArr;
            String str = this.a;
            if (str != null && (bArr = this.b) != null) {
                return new g(str, bArr);
            }
            StringBuilder sb2 = new StringBuilder();
            if (this.a == null) {
                sb2.append(" filename");
            }
            if (this.b == null) {
                sb2.append(" contents");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb2));
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.b.a
        public CrashlyticsReport$d.b.a b(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException("Null contents");
            }
            this.b = bArr;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.d.b.a
        public CrashlyticsReport$d.b.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null filename");
            }
            this.a = str;
            return this;
        }
    }

    private g(String str, byte[] bArr) {
        this.a = str;
        this.b = bArr;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$d.b
    public byte[] b() {
        return this.b;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$d.b
    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport$d.b)) {
            return false;
        }
        CrashlyticsReport$d.b bVar = (CrashlyticsReport$d.b) obj;
        if (this.a.equals(bVar.c())) {
            if (Arrays.equals(this.b, bVar instanceof g ? ((g) bVar).b : bVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public String toString() {
        return "File{filename=" + this.a + ", contents=" + Arrays.toString(this.b) + "}";
    }
}
