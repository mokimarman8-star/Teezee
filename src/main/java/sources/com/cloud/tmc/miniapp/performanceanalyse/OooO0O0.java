package com.cloud.tmc.miniapp.performanceanalyse;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooO0O0 {
    public int OooO;
    public final String OooO00o;
    public String OooO0O0;
    public final Map<String, Long> OooO0OO;
    public final Map<String, Long> OooO0Oo;
    public int OooO0o;
    public final Map<String, OooOO0> OooO0o0;
    public int OooO0oO;
    public int OooO0oo;
    public boolean OooOO0;
    public String OooOO0O;
    public String OooOO0o;
    public String OooOOO;
    public String OooOOO0;
    public boolean OooOOOO;

    public OooO0O0(String str, String str2, Map<String, Long> map, Map<String, Long> map2, Map<String, OooOO0> map3, int i, int i2, int i3, int i4, boolean z, String str3, String str4, String str5, String str6, boolean z2) {
        Intrinsics.h(str, "appId");
        Intrinsics.h(map, "chainsStartMap");
        Intrinsics.h(map2, "chainsEndMap");
        Intrinsics.h(map3, "pages");
        Intrinsics.h(str3, "h5ProgressCollectList");
        Intrinsics.h(str4, "isDomContentLoaded");
        Intrinsics.h(str5, "navigationType");
        Intrinsics.h(str6, "homePageRandomIdByGAId");
        this.OooO00o = str;
        this.OooO0O0 = str2;
        this.OooO0OO = map;
        this.OooO0Oo = map2;
        this.OooO0o0 = map3;
        this.OooO0o = i;
        this.OooO0oO = i2;
        this.OooO0oo = i3;
        this.OooO = i4;
        this.OooOO0 = z;
        this.OooOO0O = str3;
        this.OooOO0o = str4;
        this.OooOOO0 = str5;
        this.OooOOO = str6;
        this.OooOOOO = z2;
    }

    public final boolean OooO() {
        return this.OooOOOO;
    }

    public final Map<String, Long> OooO00o() {
        return this.OooO0Oo;
    }

    public final void OooO00o(boolean z) {
        this.OooOO0 = z;
    }

    public final Map<String, Long> OooO0O0() {
        return this.OooO0OO;
    }

    public final int OooO0OO() {
        return this.OooO0oO;
    }

    public final int OooO0Oo() {
        return this.OooO0o;
    }

    public final String OooO0o() {
        return this.OooO0O0;
    }

    public final String OooO0o0() {
        return this.OooOO0O;
    }

    public final String OooO0oO() {
        return this.OooOOO;
    }

    public final String OooO0oo() {
        return this.OooOOO0;
    }

    public final Map<String, OooOO0> OooOO0() {
        return this.OooO0o0;
    }

    public final int OooOO0O() {
        return this.OooO;
    }

    public final int OooOO0o() {
        return this.OooO0oo;
    }

    public final boolean OooOOO() {
        return this.OooOO0;
    }

    public final String OooOOO0() {
        return this.OooOO0o;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OooO0O0)) {
            return false;
        }
        OooO0O0 oooO0O0 = (OooO0O0) obj;
        return Intrinsics.c(this.OooO00o, oooO0O0.OooO00o) && Intrinsics.c(this.OooO0O0, oooO0O0.OooO0O0) && Intrinsics.c(this.OooO0OO, oooO0O0.OooO0OO) && Intrinsics.c(this.OooO0Oo, oooO0O0.OooO0Oo) && Intrinsics.c(this.OooO0o0, oooO0O0.OooO0o0) && this.OooO0o == oooO0O0.OooO0o && this.OooO0oO == oooO0O0.OooO0oO && this.OooO0oo == oooO0O0.OooO0oo && this.OooO == oooO0O0.OooO && this.OooOO0 == oooO0O0.OooOO0 && Intrinsics.c(this.OooOO0O, oooO0O0.OooOO0O) && Intrinsics.c(this.OooOO0o, oooO0O0.OooOO0o) && Intrinsics.c(this.OooOOO0, oooO0O0.OooOOO0) && Intrinsics.c(this.OooOOO, oooO0O0.OooOOO) && this.OooOOOO == oooO0O0.OooOOOO;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.OooO00o.hashCode() * 31;
        String str = this.OooO0O0;
        int hashCode2 = (this.OooO + ((this.OooO0oo + ((this.OooO0oO + ((this.OooO0o + ((this.OooO0o0.hashCode() + ((this.OooO0Oo.hashCode() + ((this.OooO0OO.hashCode() + ((hashCode + (str == null ? 0 : str.hashCode())) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z = this.OooOO0;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode3 = (this.OooOOO.hashCode() + ((this.OooOOO0.hashCode() + ((this.OooOO0o.hashCode() + ((this.OooOO0O.hashCode() + ((hashCode2 + i) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z2 = this.OooOOOO;
        return hashCode3 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "AppChainData(appId=" + this.OooO00o + ", homePagePath=" + this.OooO0O0 + ", chainsStartMap=" + this.OooO0OO + ", chainsEndMap=" + this.OooO0Oo + ", pages=" + this.OooO0o0 + ", downloadFrameworkMode=" + this.OooO0o + ", downloadAppMode=" + this.OooO0oO + ", zipFrameworkMode=" + this.OooO0oo + ", zipAppMode=" + this.OooO + ", isReport=" + this.OooOO0 + ", h5ProgressCollectList=" + this.OooOO0O + ", isDomContentLoaded=" + this.OooOO0o + ", navigationType=" + this.OooOOO0 + ", homePageRandomIdByGAId=" + this.OooOOO + ", offScreenRender=" + this.OooOOOO + ")";
    }
}
