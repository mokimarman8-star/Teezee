package com.transsion.transfer.impl.entity;

import androidx.annotation.Keep;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

@Keep
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000e\u0010\u0013\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ2\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00028\u0000HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/transsion/transfer/impl/entity/TransferResponse;", "T", HttpUrl.FRAGMENT_ENCODE_SET, "code", HttpUrl.FRAGMENT_ENCODE_SET, "errorMsg", HttpUrl.FRAGMENT_ENCODE_SET, "data", "<init>", "(ILjava/lang/String;Ljava/lang/Object;)V", "getCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Object;)Lcom/transsion/transfer/impl/entity/TransferResponse;", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", "toString", "Transfer_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* data */ class TransferResponse<T> {
    private final int code;
    private final T data;
    private final String errorMsg;

    public TransferResponse(int i, String errorMsg, T t) {
        Intrinsics.h(errorMsg, "errorMsg");
        this.code = i;
        this.errorMsg = errorMsg;
        this.data = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransferResponse copy$default(TransferResponse transferResponse, int i, String str, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = transferResponse.code;
        }
        if ((i2 & 2) != 0) {
            str = transferResponse.errorMsg;
        }
        if ((i2 & 4) != 0) {
            obj = transferResponse.data;
        }
        return transferResponse.copy(i, str, obj);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final T component3() {
        return this.data;
    }

    public final TransferResponse<T> copy(int code, String errorMsg, T data) {
        Intrinsics.h(errorMsg, "errorMsg");
        return new TransferResponse<>(code, errorMsg, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransferResponse)) {
            return false;
        }
        TransferResponse transferResponse = (TransferResponse) other;
        return this.code == transferResponse.code && Intrinsics.c(this.errorMsg, transferResponse.errorMsg) && Intrinsics.c(this.data, transferResponse.data);
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public int hashCode() {
        int hashCode = ((this.code * 31) + this.errorMsg.hashCode()) * 31;
        T t = this.data;
        return hashCode + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "TransferResponse(code=" + this.code + ", errorMsg=" + this.errorMsg + ", data=" + this.data + ")";
    }
}
