package com.transsion.usercenter.profile.bean;

import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.google.gson.annotations.SerializedName;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Keep
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/transsion/usercenter/profile/bean/ToggleSubscriptionRequest;", HttpUrl.FRAGMENT_ENCODE_SET, "targetUID", HttpUrl.FRAGMENT_ENCODE_SET, "subscribe", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;Z)V", "getTargetUID", "()Ljava/lang/String;", "getSubscribe", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* data */ class ToggleSubscriptionRequest {

    @SerializedName("subscribe")
    private final boolean subscribe;

    @SerializedName("targetUID")
    private final String targetUID;

    public ToggleSubscriptionRequest(String targetUID, boolean z) {
        Intrinsics.h(targetUID, "targetUID");
        this.targetUID = targetUID;
        this.subscribe = z;
    }

    public static /* synthetic */ ToggleSubscriptionRequest copy$default(ToggleSubscriptionRequest toggleSubscriptionRequest, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toggleSubscriptionRequest.targetUID;
        }
        if ((i & 2) != 0) {
            z = toggleSubscriptionRequest.subscribe;
        }
        return toggleSubscriptionRequest.copy(str, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTargetUID() {
        return this.targetUID;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSubscribe() {
        return this.subscribe;
    }

    public final ToggleSubscriptionRequest copy(String targetUID, boolean subscribe) {
        Intrinsics.h(targetUID, "targetUID");
        return new ToggleSubscriptionRequest(targetUID, subscribe);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToggleSubscriptionRequest)) {
            return false;
        }
        ToggleSubscriptionRequest toggleSubscriptionRequest = (ToggleSubscriptionRequest) other;
        return Intrinsics.c(this.targetUID, toggleSubscriptionRequest.targetUID) && this.subscribe == toggleSubscriptionRequest.subscribe;
    }

    public final boolean getSubscribe() {
        return this.subscribe;
    }

    public final String getTargetUID() {
        return this.targetUID;
    }

    public int hashCode() {
        return (this.targetUID.hashCode() * 31) + e.a(this.subscribe);
    }

    public String toString() {
        return "ToggleSubscriptionRequest(targetUID=" + this.targetUID + ", subscribe=" + this.subscribe + ")";
    }
}
