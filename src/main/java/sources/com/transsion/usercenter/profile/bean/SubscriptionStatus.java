package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.google.gson.annotations.SerializedName;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.HttpUrl;

@Keep
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/transsion/usercenter/profile/bean/SubscriptionStatus;", HttpUrl.FRAGMENT_ENCODE_SET, "isSubscribed", HttpUrl.FRAGMENT_ENCODE_SET, "isMutual", "<init>", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* data */ class SubscriptionStatus {

    @SerializedName("isMutual")
    private final boolean isMutual;

    @SerializedName("isSubscribed")
    private final boolean isSubscribed;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SubscriptionStatus() {
        this(r2, r2, 3, null);
        boolean z = false;
    }

    public SubscriptionStatus(boolean z, boolean z2) {
        this.isSubscribed = z;
        this.isMutual = z2;
    }

    public /* synthetic */ SubscriptionStatus(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }

    public static /* synthetic */ SubscriptionStatus copy$default(SubscriptionStatus subscriptionStatus, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = subscriptionStatus.isSubscribed;
        }
        if ((i & 2) != 0) {
            z2 = subscriptionStatus.isMutual;
        }
        return subscriptionStatus.copy(z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsSubscribed() {
        return this.isSubscribed;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsMutual() {
        return this.isMutual;
    }

    public final SubscriptionStatus copy(boolean isSubscribed, boolean isMutual) {
        return new SubscriptionStatus(isSubscribed, isMutual);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionStatus)) {
            return false;
        }
        SubscriptionStatus subscriptionStatus = (SubscriptionStatus) other;
        return this.isSubscribed == subscriptionStatus.isSubscribed && this.isMutual == subscriptionStatus.isMutual;
    }

    public int hashCode() {
        return (e.a(this.isSubscribed) * 31) + e.a(this.isMutual);
    }

    public final boolean isMutual() {
        return this.isMutual;
    }

    public final boolean isSubscribed() {
        return this.isSubscribed;
    }

    public String toString() {
        return "SubscriptionStatus(isSubscribed=" + this.isSubscribed + ", isMutual=" + this.isMutual + ")";
    }
}
