package com.cloud.hisavana.sdk.common.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/cloud/hisavana/sdk/common/bean/AdActiveInfo;", "", "packageName", "", "ecpm", "", "imageUrl", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)V", "getEcpm", "()Ljava/lang/Double;", "setEcpm", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "getPackageName", "setPackageName", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;)Lcom/cloud/hisavana/sdk/common/bean/AdActiveInfo;", "equals", "", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final /* data */ class AdActiveInfo {
    private Double ecpm;
    private String imageUrl;
    private String packageName;

    public AdActiveInfo() {
        this(null, null, null, 7, null);
    }

    public AdActiveInfo(String str, Double d, String str2) {
        this.packageName = str;
        this.ecpm = d;
        this.imageUrl = str2;
    }

    public /* synthetic */ AdActiveInfo(String str, Double d, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : d, (i & 4) != 0 ? null : str2);
    }

    public static /* synthetic */ AdActiveInfo copy$default(AdActiveInfo adActiveInfo, String str, Double d, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = adActiveInfo.packageName;
        }
        if ((i & 2) != 0) {
            d = adActiveInfo.ecpm;
        }
        if ((i & 4) != 0) {
            str2 = adActiveInfo.imageUrl;
        }
        return adActiveInfo.copy(str, d, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final Double getEcpm() {
        return this.ecpm;
    }

    /* renamed from: component3, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final AdActiveInfo copy(String packageName, Double ecpm, String imageUrl) {
        return new AdActiveInfo(packageName, ecpm, imageUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdActiveInfo)) {
            return false;
        }
        AdActiveInfo adActiveInfo = (AdActiveInfo) other;
        return Intrinsics.c(this.packageName, adActiveInfo.packageName) && Intrinsics.c(this.ecpm, adActiveInfo.ecpm) && Intrinsics.c(this.imageUrl, adActiveInfo.imageUrl);
    }

    public final Double getEcpm() {
        return this.ecpm;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        String str = this.packageName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Double d = this.ecpm;
        int hashCode2 = (hashCode + (d == null ? 0 : d.hashCode())) * 31;
        String str2 = this.imageUrl;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setEcpm(Double d) {
        this.ecpm = d;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final void setPackageName(String str) {
        this.packageName = str;
    }

    public String toString() {
        return "AdActiveInfo(packageName=" + this.packageName + ", ecpm=" + this.ecpm + ", imageUrl=" + this.imageUrl + ')';
    }
}
