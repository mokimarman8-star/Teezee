package com.cloud.tmc.miniapp.utils.athena.strategy;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO00o {
    public boolean OooO00o;
    public boolean OooO0O0;
    public boolean OooO0OO;

    public OooO00o(boolean z, boolean z2, boolean z3) {
        this.OooO00o = z;
        this.OooO0O0 = z2;
        this.OooO0OO = z3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OooO00o)) {
            return false;
        }
        OooO00o oooO00o = (OooO00o) obj;
        return this.OooO00o == oooO00o.OooO00o && this.OooO0O0 == oooO00o.OooO0O0 && this.OooO0OO == oooO00o.OooO0OO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z = this.OooO00o;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.OooO0O0;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        boolean z2 = this.OooO0OO;
        return i3 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "AthenaReportBean(setCache=" + this.OooO00o + ", clearCache=" + this.OooO0O0 + ", isMfah=" + this.OooO0OO + ")";
    }
}
