package com.cloud.tmc.miniapp.performanceanalyse.page;

import com.cloud.tmc.kernel.framework.FrameworkConstants;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO00o {
    public final String OooO00o;
    public String OooO0O0;
    public final Map<String, Long> OooO0OO;
    public final Map<String, Long> OooO0Oo;
    public boolean OooO0o;
    public final Map<String, Long> OooO0o0;
    public boolean OooO0oO;
    public boolean OooO0oo;

    public OooO00o(String str, String str2, Map<String, Long> map, Map<String, Long> map2, Map<String, Long> map3, boolean z, boolean z2, boolean z3) {
        Intrinsics.h(str, FrameworkConstants.GLOBAL_DATA_KEY_PAGE_PATH);
        Intrinsics.h(str2, "pageId");
        Intrinsics.h(map, "stageStartMap");
        Intrinsics.h(map2, "stageEndMap");
        Intrinsics.h(map3, "stageTime");
        this.OooO00o = str;
        this.OooO0O0 = str2;
        this.OooO0OO = map;
        this.OooO0Oo = map2;
        this.OooO0o0 = map3;
        this.OooO0o = z;
        this.OooO0oO = z2;
        this.OooO0oo = z3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OooO00o)) {
            return false;
        }
        OooO00o oooO00o = (OooO00o) obj;
        return Intrinsics.c(this.OooO00o, oooO00o.OooO00o) && Intrinsics.c(this.OooO0O0, oooO00o.OooO0O0) && Intrinsics.c(this.OooO0OO, oooO00o.OooO0OO) && Intrinsics.c(this.OooO0Oo, oooO00o.OooO0Oo) && Intrinsics.c(this.OooO0o0, oooO00o.OooO0o0) && this.OooO0o == oooO00o.OooO0o && this.OooO0oO == oooO00o.OooO0oO && this.OooO0oo == oooO00o.OooO0oo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = (this.OooO0o0.hashCode() + ((this.OooO0Oo.hashCode() + ((this.OooO0OO.hashCode() + ((this.OooO0O0.hashCode() + (this.OooO00o.hashCode() * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z = this.OooO0o;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.OooO0oO;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z3 = this.OooO0oo;
        return i4 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        return "PageOpenPointData(pagePath=" + this.OooO00o + ", pageId=" + this.OooO0O0 + ", stageStartMap=" + this.OooO0OO + ", stageEndMap=" + this.OooO0Oo + ", stageTime=" + this.OooO0o0 + ", isHomePage=" + this.OooO0o + ", isReportFail=" + this.OooO0oO + ", isPageOpenSuccessed=" + this.OooO0oo + ")";
    }
}
