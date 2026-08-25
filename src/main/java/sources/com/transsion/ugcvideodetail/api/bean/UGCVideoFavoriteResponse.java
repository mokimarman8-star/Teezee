package com.transsion.ugcvideodetail.api.bean;

import androidx.annotation.Keep;
import androidx.compose.foundation.e;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import kotlin.Metadata;
import okhttp3.HttpUrl;

@Keep
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/transsion/ugcvideodetail/api/bean/UGCVideoFavoriteResponse;", "Ljava/io/Serializable;", "isAffected", HttpUrl.FRAGMENT_ENCODE_SET, "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "UGCVideoDetailApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* data */ class UGCVideoFavoriteResponse implements Serializable {
    private final boolean isAffected;

    public UGCVideoFavoriteResponse(boolean z) {
        this.isAffected = z;
    }

    public static /* synthetic */ UGCVideoFavoriteResponse copy$default(UGCVideoFavoriteResponse uGCVideoFavoriteResponse, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = uGCVideoFavoriteResponse.isAffected;
        }
        return uGCVideoFavoriteResponse.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsAffected() {
        return this.isAffected;
    }

    public final UGCVideoFavoriteResponse copy(boolean isAffected) {
        return new UGCVideoFavoriteResponse(isAffected);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UGCVideoFavoriteResponse) && this.isAffected == ((UGCVideoFavoriteResponse) other).isAffected;
    }

    public int hashCode() {
        return e.a(this.isAffected);
    }

    public final boolean isAffected() {
        return this.isAffected;
    }

    public String toString() {
        return "UGCVideoFavoriteResponse(isAffected=" + this.isAffected + ")";
    }
}
