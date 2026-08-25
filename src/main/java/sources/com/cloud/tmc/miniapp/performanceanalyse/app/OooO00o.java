package com.cloud.tmc.miniapp.performanceanalyse.app;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO00o {
    public int OooO;
    public final String OooO00o;
    public String OooO0O0;
    public final Map<String, Long> OooO0OO;
    public final Map<String, Long> OooO0Oo;
    public final Map<String, com.cloud.tmc.miniapp.performanceanalyse.page.OooO00o> OooO0o;
    public final Map<String, Long> OooO0o0;
    public int OooO0oO;
    public int OooO0oo;
    public int OooOO0;
    public boolean OooOO0O;
    public boolean OooOO0o;
    public boolean OooOOO0;

    public OooO00o(String str, String str2, Map<String, Long> map, Map<String, Long> map2, Map<String, Long> map3, Map<String, com.cloud.tmc.miniapp.performanceanalyse.page.OooO00o> map4, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        Intrinsics.h(str, "appId");
        Intrinsics.h(map, "stageStartMap");
        Intrinsics.h(map2, "stageEndMap");
        Intrinsics.h(map3, "stageTime");
        Intrinsics.h(map4, "pages");
        this.OooO00o = str;
        this.OooO0O0 = str2;
        this.OooO0OO = map;
        this.OooO0Oo = map2;
        this.OooO0o0 = map3;
        this.OooO0o = map4;
        this.OooO0oO = i;
        this.OooO0oo = i2;
        this.OooO = i3;
        this.OooOO0 = i4;
        this.OooOO0O = z;
        this.OooOO0o = z2;
        this.OooOOO0 = z3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OooO00o)) {
            return false;
        }
        OooO00o oooO00o = (OooO00o) obj;
        return Intrinsics.c(this.OooO00o, oooO00o.OooO00o) && Intrinsics.c(this.OooO0O0, oooO00o.OooO0O0) && Intrinsics.c(this.OooO0OO, oooO00o.OooO0OO) && Intrinsics.c(this.OooO0Oo, oooO00o.OooO0Oo) && Intrinsics.c(this.OooO0o0, oooO00o.OooO0o0) && Intrinsics.c(this.OooO0o, oooO00o.OooO0o) && this.OooO0oO == oooO00o.OooO0oO && this.OooO0oo == oooO00o.OooO0oo && this.OooO == oooO00o.OooO && this.OooOO0 == oooO00o.OooOO0 && this.OooOO0O == oooO00o.OooOO0O && this.OooOO0o == oooO00o.OooOO0o && this.OooOOO0 == oooO00o.OooOOO0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.OooO00o.hashCode() * 31;
        String str = this.OooO0O0;
        int hashCode2 = (this.OooOO0 + ((this.OooO + ((this.OooO0oo + ((this.OooO0oO + ((this.OooO0o.hashCode() + ((this.OooO0o0.hashCode() + ((this.OooO0Oo.hashCode() + ((this.OooO0OO.hashCode() + ((hashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z = this.OooOO0O;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z2 = this.OooOO0o;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z3 = this.OooOOO0;
        return i4 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        return "AppOpenPointData(appId=" + this.OooO00o + ", homePagePath=" + this.OooO0O0 + ", stageStartMap=" + this.OooO0OO + ", stageEndMap=" + this.OooO0Oo + ", stageTime=" + this.OooO0o0 + ", pages=" + this.OooO0o + ", updateAppInfoMode=" + this.OooO0oO + ", updateFrameworkInfoMode=" + this.OooO0oo + ", downloadAppMode=" + this.OooO + ", downloadFrameworkMode=" + this.OooOO0 + ", isAddHomePage=" + this.OooOO0O + ", isReport=" + this.OooOO0o + ", isOpenSuccess=" + this.OooOOO0 + ")";
    }
}
