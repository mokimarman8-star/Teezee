package com.transsion.wrapperad.view.cardpage;

import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f {
    private final NativeWrapperAdView a;
    private final BiddingIntermediateMaterialBean b;
    private NativeCardPageAdHelper c;
    private boolean d;
    private boolean e;

    public f(NativeWrapperAdView nativeView, BiddingIntermediateMaterialBean adBean, NativeCardPageAdHelper nativeCardPageAdHelper, boolean z, boolean z2) {
        Intrinsics.h(nativeView, "nativeView");
        Intrinsics.h(adBean, "adBean");
        this.a = nativeView;
        this.b = adBean;
        this.c = nativeCardPageAdHelper;
        this.d = z;
        this.e = z2;
    }

    public /* synthetic */ f(NativeWrapperAdView nativeWrapperAdView, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, NativeCardPageAdHelper nativeCardPageAdHelper, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(nativeWrapperAdView, biddingIntermediateMaterialBean, (i & 4) != 0 ? null : nativeCardPageAdHelper, (i & 8) != 0 ? false : z, (i & 16) != 0 ? true : z2);
    }

    public final BiddingIntermediateMaterialBean a() {
        return this.b;
    }

    public final boolean b() {
        return this.d;
    }

    public final NativeCardPageAdHelper c() {
        return this.c;
    }

    public final NativeWrapperAdView d() {
        return this.a;
    }

    public final boolean e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return Intrinsics.c(this.a, fVar.a) && Intrinsics.c(this.b, fVar.b) && Intrinsics.c(this.c, fVar.c) && this.d == fVar.d && this.e == fVar.e;
    }

    public final void f(boolean z) {
        this.d = z;
    }

    public final void g(NativeCardPageAdHelper nativeCardPageAdHelper) {
        this.c = nativeCardPageAdHelper;
    }

    public final void h(boolean z) {
        this.e = z;
    }

    public int hashCode() {
        int hashCode = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        NativeCardPageAdHelper nativeCardPageAdHelper = this.c;
        return ((((hashCode + (nativeCardPageAdHelper == null ? 0 : nativeCardPageAdHelper.hashCode())) * 31) + androidx.compose.foundation.e.a(this.d)) * 31) + androidx.compose.foundation.e.a(this.e);
    }

    public String toString() {
        return "NativeCardPageData(nativeView=" + this.a + ", adBean=" + this.b + ", helper=" + this.c + ", bind=" + this.d + ", showGuide=" + this.e + ")";
    }
}
