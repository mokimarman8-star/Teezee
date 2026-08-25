package com.transsion.rewardscenterapi;

import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.transsion.gslb.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/transsion/rewardscenterapi/Banner;", "Ljava/io/Serializable;", "enable", BuildConfig.FLAVOR, "imageUrl", BuildConfig.FLAVOR, "skuId", "sku", "Lcom/transsion/rewardscenterapi/SkuPoint;", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Lcom/transsion/rewardscenterapi/SkuPoint;)V", "getEnable", "()Z", "getImageUrl", "()Ljava/lang/String;", "getSkuId", "getSku", "()Lcom/transsion/rewardscenterapi/SkuPoint;", "component1", "component2", "component3", "component4", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "RewardsCenterApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* data */ class Banner implements Serializable {
    private final boolean enable;
    private final String imageUrl;
    private final SkuPoint sku;
    private final String skuId;

    public Banner() {
        this(false, null, null, null, 15, null);
    }

    public Banner(boolean z, String str, String str2, SkuPoint skuPoint) {
        this.enable = z;
        this.imageUrl = str;
        this.skuId = str2;
        this.sku = skuPoint;
    }

    public /* synthetic */ Banner(boolean z, String str, String str2, SkuPoint skuPoint, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : skuPoint);
    }

    public static /* synthetic */ Banner copy$default(Banner banner, boolean z, String str, String str2, SkuPoint skuPoint, int i, Object obj) {
        if ((i & 1) != 0) {
            z = banner.enable;
        }
        if ((i & 2) != 0) {
            str = banner.imageUrl;
        }
        if ((i & 4) != 0) {
            str2 = banner.skuId;
        }
        if ((i & 8) != 0) {
            skuPoint = banner.sku;
        }
        return banner.copy(z, str, str2, skuPoint);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: component2, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSkuId() {
        return this.skuId;
    }

    /* renamed from: component4, reason: from getter */
    public final SkuPoint getSku() {
        return this.sku;
    }

    public final Banner copy(boolean enable, String imageUrl, String skuId, SkuPoint sku) {
        return new Banner(enable, imageUrl, skuId, sku);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Banner)) {
            return false;
        }
        Banner banner = (Banner) other;
        return this.enable == banner.enable && Intrinsics.c(this.imageUrl, banner.imageUrl) && Intrinsics.c(this.skuId, banner.skuId) && Intrinsics.c(this.sku, banner.sku);
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final SkuPoint getSku() {
        return this.sku;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public int hashCode() {
        int a = e.a(this.enable) * 31;
        String str = this.imageUrl;
        int hashCode = (a + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.skuId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        SkuPoint skuPoint = this.sku;
        return hashCode2 + (skuPoint != null ? skuPoint.hashCode() : 0);
    }

    public String toString() {
        return "Banner(enable=" + this.enable + ", imageUrl=" + this.imageUrl + ", skuId=" + this.skuId + ", sku=" + this.sku + ")";
    }
}
