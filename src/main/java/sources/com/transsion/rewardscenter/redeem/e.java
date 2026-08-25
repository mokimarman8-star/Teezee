package com.transsion.rewardscenter.redeem;

import com.transsion.rewardscenterapi.LotteryPrize;
import com.transsion.rewardscenterapi.SkuPoint;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class e {

    public static final class a extends e {
        private final LotteryPrize a;
        private final boolean b;
        private final SkuPoint c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LotteryPrize lotteryPrize, boolean z, SkuPoint skuPoint) {
            super(null);
            Intrinsics.h(lotteryPrize, "lotteryPrize");
            this.a = lotteryPrize;
            this.b = z;
            this.c = skuPoint;
        }

        public final boolean a() {
            return this.b;
        }

        public final LotteryPrize b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.a, aVar.a) && this.b == aVar.b && Intrinsics.c(this.c, aVar.c);
        }

        public int hashCode() {
            int hashCode = ((this.a.hashCode() * 31) + androidx.compose.foundation.e.a(this.b)) * 31;
            SkuPoint skuPoint = this.c;
            return hashCode + (skuPoint == null ? 0 : skuPoint.hashCode());
        }

        public String toString() {
            return "LotteryItem(lotteryPrize=" + this.a + ", hasPaid=" + this.b + ", skuPoint=" + this.c + ")";
        }
    }

    public static final class b extends e {
        private final SkuPoint a;
        private final boolean b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SkuPoint skuPoint, boolean z) {
            super(null);
            Intrinsics.h(skuPoint, "skuPoint");
            this.a = skuPoint;
            this.b = z;
        }

        public final boolean a() {
            return this.b;
        }

        public final SkuPoint b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.c(this.a, bVar.a) && this.b == bVar.b;
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + androidx.compose.foundation.e.a(this.b);
        }

        public String toString() {
            return "SkuItem(skuPoint=" + this.a + ", hasPaid=" + this.b + ")";
        }
    }

    public static final class c extends e {
        private final String a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            Intrinsics.h(str, "title");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.c(this.a, ((c) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "TitleItem(title=" + this.a + ")";
        }
    }

    private e() {
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
