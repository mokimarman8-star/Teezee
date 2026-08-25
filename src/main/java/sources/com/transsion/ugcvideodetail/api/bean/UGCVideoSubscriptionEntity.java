package com.transsion.ugcvideodetail.api.bean;

import androidx.annotation.Keep;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import kotlin.Metadata;
import okhttp3.HttpUrl;

@Keep
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/transsion/ugcvideodetail/api/bean/UGCVideoSubscriptionEntity;", "Ljava/io/Serializable;", "<init>", "()V", "targetUID", HttpUrl.FRAGMENT_ENCODE_SET, "getTargetUID", "()Ljava/lang/String;", "setTargetUID", "(Ljava/lang/String;)V", "subscribe", HttpUrl.FRAGMENT_ENCODE_SET, "getSubscribe", "()Z", "setSubscribe", "(Z)V", "UGCVideoDetailApi_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class UGCVideoSubscriptionEntity implements Serializable {
    private boolean subscribe = true;
    private String targetUID;

    public final boolean getSubscribe() {
        return this.subscribe;
    }

    public final String getTargetUID() {
        return this.targetUID;
    }

    public final void setSubscribe(boolean z) {
        this.subscribe = z;
    }

    public final void setTargetUID(String str) {
        this.targetUID = str;
    }
}
