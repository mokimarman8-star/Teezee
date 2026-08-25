package com.tn.tranpay.bean;

import com.cloud.tmc.kernel.constants.TmcConstants;
import com.tn.tranpay.network.BaseContent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/tn/tranpay/bean/PrePayContent;", "Lcom/tn/tranpay/network/BaseContent;", "()V", TmcConstants.KEY_BRIDGE_RESULT_DATA, "Lcom/tn/tranpay/bean/PrePayInfoBean;", "getData", "()Lcom/tn/tranpay/bean/PrePayInfoBean;", "setData", "(Lcom/tn/tranpay/bean/PrePayInfoBean;)V", "lib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class PrePayContent extends BaseContent {
    private PrePayInfoBean data;

    public final PrePayInfoBean getData() {
        return this.data;
    }

    public final void setData(PrePayInfoBean prePayInfoBean) {
        this.data = prePayInfoBean;
    }
}
