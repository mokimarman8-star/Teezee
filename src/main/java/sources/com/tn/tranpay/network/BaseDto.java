package com.tn.tranpay.network;

import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/tn/tranpay/network/BaseDto;", "T", "Ljava/io/Serializable;", "()V", TmcConstants.BRIDGE_RESPONSE_ERROR_CODE_KEY, "", TmcConstants.KEY_BRIDGE_RESULT_DATA, "(ILjava/lang/Object;)V", "getCode", "()I", "setCode", "(I)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "toString", "", "lib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class BaseDto<T> implements Serializable {

    @SerializedName(TmcConstants.BRIDGE_RESPONSE_ERROR_CODE_KEY)
    private int code;

    @SerializedName(TmcConstants.KEY_BRIDGE_RESULT_DATA)
    private T data;

    public BaseDto() {
    }

    public BaseDto(int i, T t) {
        this.code = i;
        this.data = t;
    }

    public final int getCode() {
        return this.code;
    }

    public final T getData() {
        return this.data;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setData(T t) {
        this.data = t;
    }

    public String toString() {
        return "BaseDto(code='" + this.code + "', data=" + this.data + ")";
    }
}
