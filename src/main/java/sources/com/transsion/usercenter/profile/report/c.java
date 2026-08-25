package com.transsion.usercenter.profile.report;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c {
    private String a;
    private boolean b;

    public c(String reportName, boolean z) {
        Intrinsics.h(reportName, "reportName");
        this.a = reportName;
        this.b = z;
    }

    public final String a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public final void c(boolean z) {
        this.b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.c(this.a, cVar.a) && this.b == cVar.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + androidx.compose.foundation.e.a(this.b);
    }

    public String toString() {
        return "ReportBean(reportName=" + this.a + ", isChecked=" + this.b + ")";
    }
}
