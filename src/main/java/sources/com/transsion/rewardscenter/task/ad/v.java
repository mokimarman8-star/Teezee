package com.transsion.rewardscenter.task.ad;

import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.gslb.BuildConfig;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class v {

    public static final class a extends v {
        private final BiddingIntermediateMaterialBean a;
        private NativeWrapperAdView b;
        private com.transsion.ad.bidding.base.r c;
        private com.transsion.ad.bidding.base.u d;
        private AdTaskState e;
        private String f;
        private boolean g;
        private boolean h;
        private long i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, NativeWrapperAdView nativeWrapperAdView, com.transsion.ad.bidding.base.r rVar, com.transsion.ad.bidding.base.u uVar, AdTaskState adTaskState, String str, boolean z, boolean z2, long j) {
            super(null);
            Intrinsics.h(biddingIntermediateMaterialBean, "adBean");
            Intrinsics.h(adTaskState, "adTaskState");
            Intrinsics.h(str, "packageName");
            this.a = biddingIntermediateMaterialBean;
            this.b = nativeWrapperAdView;
            this.c = rVar;
            this.d = uVar;
            this.e = adTaskState;
            this.f = str;
            this.g = z;
            this.h = z2;
            this.i = j;
        }

        public /* synthetic */ a(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, NativeWrapperAdView nativeWrapperAdView, com.transsion.ad.bidding.base.r rVar, com.transsion.ad.bidding.base.u uVar, AdTaskState adTaskState, String str, boolean z, boolean z2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(biddingIntermediateMaterialBean, (i & 2) != 0 ? null : nativeWrapperAdView, (i & 4) != 0 ? null : rVar, (i & 8) == 0 ? uVar : null, (i & 16) != 0 ? AdTaskState.NORMAL : adTaskState, (i & 32) != 0 ? BuildConfig.FLAVOR : str, (i & 64) != 0 ? false : z, (i & 128) == 0 ? z2 : false, (i & 256) != 0 ? 0L : j);
        }

        public final a a(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, NativeWrapperAdView nativeWrapperAdView, com.transsion.ad.bidding.base.r rVar, com.transsion.ad.bidding.base.u uVar, AdTaskState adTaskState, String str, boolean z, boolean z2, long j) {
            Intrinsics.h(biddingIntermediateMaterialBean, "adBean");
            Intrinsics.h(adTaskState, "adTaskState");
            Intrinsics.h(str, "packageName");
            return new a(biddingIntermediateMaterialBean, nativeWrapperAdView, rVar, uVar, adTaskState, str, z, z2, j);
        }

        public final BiddingIntermediateMaterialBean c() {
            return this.a;
        }

        public final com.transsion.ad.bidding.base.r d() {
            return this.c;
        }

        public final AdTaskState e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.a, aVar.a) && Intrinsics.c(this.b, aVar.b) && Intrinsics.c(this.c, aVar.c) && Intrinsics.c(this.d, aVar.d) && this.e == aVar.e && Intrinsics.c(this.f, aVar.f) && this.g == aVar.g && this.h == aVar.h && this.i == aVar.i;
        }

        public final boolean f() {
            return this.h;
        }

        public final long g() {
            return this.i;
        }

        public final NativeWrapperAdView h() {
            return this.b;
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            NativeWrapperAdView nativeWrapperAdView = this.b;
            int hashCode2 = (hashCode + (nativeWrapperAdView == null ? 0 : nativeWrapperAdView.hashCode())) * 31;
            com.transsion.ad.bidding.base.r rVar = this.c;
            int hashCode3 = (hashCode2 + (rVar == null ? 0 : rVar.hashCode())) * 31;
            com.transsion.ad.bidding.base.u uVar = this.d;
            return ((((((((((hashCode3 + (uVar != null ? uVar.hashCode() : 0)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + androidx.compose.foundation.e.a(this.g)) * 31) + androidx.compose.foundation.e.a(this.h)) * 31) + androidx.collection.s.a(this.i);
        }

        public final String i() {
            return this.f;
        }

        public final com.transsion.ad.bidding.base.u j() {
            return this.d;
        }

        public final boolean k() {
            return this.g;
        }

        public final void l(com.transsion.ad.bidding.base.r rVar) {
            this.c = rVar;
        }

        public final void m(AdTaskState adTaskState) {
            Intrinsics.h(adTaskState, "<set-?>");
            this.e = adTaskState;
        }

        public final void n(boolean z) {
            this.h = z;
        }

        public final void o(long j) {
            this.i = j;
        }

        public final void p(NativeWrapperAdView nativeWrapperAdView) {
            this.b = nativeWrapperAdView;
        }

        public final void q(com.transsion.ad.bidding.base.u uVar) {
            this.d = uVar;
        }

        public String toString() {
            return "RegularItem(adBean=" + this.a + ", nativeAdView=" + this.b + ", adLayoutProvider=" + this.c + ", sspLayoutProvider=" + this.d + ", adTaskState=" + this.e + ", packageName=" + this.f + ", isPullNewAd=" + this.g + ", bind=" + this.h + ", downloadStartTime=" + this.i + ")";
        }
    }

    public static final class b extends v {
        private final AdTaskState a;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b() {
            this(r0, 1, r0);
            AdTaskState adTaskState = null;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AdTaskState adTaskState) {
            super(null);
            Intrinsics.h(adTaskState, "adTaskState");
            this.a = adTaskState;
        }

        public /* synthetic */ b(AdTaskState adTaskState, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? AdTaskState.NORMAL : adTaskState);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.a == ((b) obj).a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "RewardItem(adTaskState=" + this.a + ")";
        }
    }

    public static final class c extends v {
        private final BiddingIntermediateMaterialBean a;
        private NativeWrapperAdView b;
        private com.transsion.ad.bidding.base.r c;
        private com.transsion.ad.bidding.base.u d;
        private AdTaskState e;
        private String f;
        private boolean g;
        private long h;
        private long i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, NativeWrapperAdView nativeWrapperAdView, com.transsion.ad.bidding.base.r rVar, com.transsion.ad.bidding.base.u uVar, AdTaskState adTaskState, String str, boolean z, long j, long j2) {
            super(null);
            Intrinsics.h(biddingIntermediateMaterialBean, "adBean");
            Intrinsics.h(adTaskState, "adTaskState");
            Intrinsics.h(str, "packageName");
            this.a = biddingIntermediateMaterialBean;
            this.b = nativeWrapperAdView;
            this.c = rVar;
            this.d = uVar;
            this.e = adTaskState;
            this.f = str;
            this.g = z;
            this.h = j;
            this.i = j2;
        }

        public /* synthetic */ c(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, NativeWrapperAdView nativeWrapperAdView, com.transsion.ad.bidding.base.r rVar, com.transsion.ad.bidding.base.u uVar, AdTaskState adTaskState, String str, boolean z, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(biddingIntermediateMaterialBean, (i & 2) != 0 ? null : nativeWrapperAdView, (i & 4) != 0 ? null : rVar, (i & 8) == 0 ? uVar : null, (i & 16) != 0 ? AdTaskState.NORMAL : adTaskState, (i & 32) != 0 ? BuildConfig.FLAVOR : str, (i & 64) != 0 ? false : z, (i & 128) != 0 ? 0L : j, (i & 256) == 0 ? j2 : 0L);
        }

        public final c a(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, NativeWrapperAdView nativeWrapperAdView, com.transsion.ad.bidding.base.r rVar, com.transsion.ad.bidding.base.u uVar, AdTaskState adTaskState, String str, boolean z, long j, long j2) {
            Intrinsics.h(biddingIntermediateMaterialBean, "adBean");
            Intrinsics.h(adTaskState, "adTaskState");
            Intrinsics.h(str, "packageName");
            return new c(biddingIntermediateMaterialBean, nativeWrapperAdView, rVar, uVar, adTaskState, str, z, j, j2);
        }

        public final BiddingIntermediateMaterialBean c() {
            return this.a;
        }

        public final com.transsion.ad.bidding.base.r d() {
            return this.c;
        }

        public final AdTaskState e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.c(this.a, cVar.a) && Intrinsics.c(this.b, cVar.b) && Intrinsics.c(this.c, cVar.c) && Intrinsics.c(this.d, cVar.d) && this.e == cVar.e && Intrinsics.c(this.f, cVar.f) && this.g == cVar.g && this.h == cVar.h && this.i == cVar.i;
        }

        public final boolean f() {
            return this.g;
        }

        public final long g() {
            return this.i;
        }

        public final NativeWrapperAdView h() {
            return this.b;
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            NativeWrapperAdView nativeWrapperAdView = this.b;
            int hashCode2 = (hashCode + (nativeWrapperAdView == null ? 0 : nativeWrapperAdView.hashCode())) * 31;
            com.transsion.ad.bidding.base.r rVar = this.c;
            int hashCode3 = (hashCode2 + (rVar == null ? 0 : rVar.hashCode())) * 31;
            com.transsion.ad.bidding.base.u uVar = this.d;
            return ((((((((((hashCode3 + (uVar != null ? uVar.hashCode() : 0)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + androidx.compose.foundation.e.a(this.g)) * 31) + androidx.collection.s.a(this.h)) * 31) + androidx.collection.s.a(this.i);
        }

        public final String i() {
            return this.f;
        }

        public final long j() {
            return this.h;
        }

        public final com.transsion.ad.bidding.base.u k() {
            return this.d;
        }

        public final void l(com.transsion.ad.bidding.base.r rVar) {
            this.c = rVar;
        }

        public final void m(AdTaskState adTaskState) {
            Intrinsics.h(adTaskState, "<set-?>");
            this.e = adTaskState;
        }

        public final void n(boolean z) {
            this.g = z;
        }

        public final void o(long j) {
            this.i = j;
        }

        public final void p(NativeWrapperAdView nativeWrapperAdView) {
            this.b = nativeWrapperAdView;
        }

        public final void q(long j) {
            this.h = j;
        }

        public final void r(com.transsion.ad.bidding.base.u uVar) {
            this.d = uVar;
        }

        public String toString() {
            return "StageItem(adBean=" + this.a + ", nativeAdView=" + this.b + ", adLayoutProvider=" + this.c + ", sspLayoutProvider=" + this.d + ", adTaskState=" + this.e + ", packageName=" + this.f + ", bind=" + this.g + ", playedTime=" + this.h + ", downloadStartTime=" + this.i + ")";
        }
    }

    private v() {
    }

    public /* synthetic */ v(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
