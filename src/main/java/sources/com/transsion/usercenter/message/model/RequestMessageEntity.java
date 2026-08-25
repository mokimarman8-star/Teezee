package com.transsion.usercenter.message.model;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/transsion/usercenter/message/model/RequestMessageEntity;", "Ljava/io/Serializable;", "page", HttpUrl.FRAGMENT_ENCODE_SET, "perPage", HttpUrl.FRAGMENT_ENCODE_SET, "type", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getPage", "()Ljava/lang/String;", "setPage", "(Ljava/lang/String;)V", "getPerPage", "()I", "setPerPage", "(I)V", "getType", "setType", "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class RequestMessageEntity implements Serializable {
    private String page;
    private int perPage;
    private String type;

    public RequestMessageEntity(String page, int i, String type) {
        Intrinsics.h(page, "page");
        Intrinsics.h(type, "type");
        this.page = HttpUrl.FRAGMENT_ENCODE_SET;
        this.type = HttpUrl.FRAGMENT_ENCODE_SET;
        this.page = page.toString();
        this.perPage = i;
        this.type = type;
    }

    public final String getPage() {
        return this.page;
    }

    public final int getPerPage() {
        return this.perPage;
    }

    public final String getType() {
        return this.type;
    }

    public final void setPage(String str) {
        Intrinsics.h(str, "<set-?>");
        this.page = str;
    }

    public final void setPerPage(int i) {
        this.perPage = i;
    }

    public final void setType(String str) {
        Intrinsics.h(str, "<set-?>");
        this.type = str;
    }
}
