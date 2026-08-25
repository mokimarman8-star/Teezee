package com.cloud.tmc.miniapp.performanceanalyse;

import com.cloud.tmc.kernel.framework.FrameworkConstants;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class OooOO0 {
    public final String OooO00o;
    public String OooO0O0;
    public final Map<String, Long> OooO0OO;
    public final Map<String, Long> OooO0Oo;
    public String OooO0o;
    public String OooO0o0;
    public String OooO0oO;

    public OooOO0(String str, String str2, Map<String, Long> map, Map<String, Long> map2, String str3, String str4, String str5) {
        Intrinsics.h(str, FrameworkConstants.GLOBAL_DATA_KEY_PAGE_PATH);
        Intrinsics.h(str2, "renderId");
        Intrinsics.h(map, "chainsStartMap");
        Intrinsics.h(map2, "chainsEndMap");
        Intrinsics.h(str3, "h5ProgressCollectList");
        Intrinsics.h(str4, "isDomContentLoaded");
        Intrinsics.h(str5, "navigationType");
        this.OooO00o = str;
        this.OooO0O0 = str2;
        this.OooO0OO = map;
        this.OooO0Oo = map2;
        this.OooO0o0 = str3;
        this.OooO0o = str4;
        this.OooO0oO = str5;
    }

    public final Map<String, Long> OooO00o() {
        return this.OooO0Oo;
    }

    public final Map<String, Long> OooO0O0() {
        return this.OooO0OO;
    }

    public final String OooO0OO() {
        return this.OooO0o0;
    }

    public final String OooO0Oo() {
        return this.OooO0oO;
    }

    public final String OooO0o() {
        return this.OooO0o;
    }

    public final String OooO0o0() {
        return this.OooO0O0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OooOO0)) {
            return false;
        }
        OooOO0 oooOO0 = (OooOO0) obj;
        return Intrinsics.c(this.OooO00o, oooOO0.OooO00o) && Intrinsics.c(this.OooO0O0, oooOO0.OooO0O0) && Intrinsics.c(this.OooO0OO, oooOO0.OooO0OO) && Intrinsics.c(this.OooO0Oo, oooOO0.OooO0Oo) && Intrinsics.c(this.OooO0o0, oooOO0.OooO0o0) && Intrinsics.c(this.OooO0o, oooOO0.OooO0o) && Intrinsics.c(this.OooO0oO, oooOO0.OooO0oO);
    }

    public int hashCode() {
        return this.OooO0oO.hashCode() + ((this.OooO0o.hashCode() + ((this.OooO0o0.hashCode() + ((this.OooO0Oo.hashCode() + ((this.OooO0OO.hashCode() + ((this.OooO0O0.hashCode() + (this.OooO00o.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "PageChainData(pagePath=" + this.OooO00o + ", renderId=" + this.OooO0O0 + ", chainsStartMap=" + this.OooO0OO + ", chainsEndMap=" + this.OooO0Oo + ", h5ProgressCollectList=" + this.OooO0o0 + ", isDomContentLoaded=" + this.OooO0o + ", navigationType=" + this.OooO0oO + ")";
    }
}
