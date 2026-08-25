package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class b extends a0 {
    private final CrashlyticsReport a;
    private final String b;
    private final File c;

    b(CrashlyticsReport crashlyticsReport, String str, File file) {
        if (crashlyticsReport == null) {
            throw new NullPointerException("Null report");
        }
        this.a = crashlyticsReport;
        if (str == null) {
            throw new NullPointerException("Null sessionId");
        }
        this.b = str;
        if (file == null) {
            throw new NullPointerException("Null reportFile");
        }
        this.c = file;
    }

    @Override // com.google.firebase.crashlytics.internal.common.a0
    public CrashlyticsReport b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.internal.common.a0
    public File c() {
        return this.c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.a0
    public String d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return this.a.equals(a0Var.b()) && this.b.equals(a0Var.d()) && this.c.equals(a0Var.c());
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
    }

    public String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.a + ", sessionId=" + this.b + ", reportFile=" + this.c + "}";
    }
}
