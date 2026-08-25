package com.bytedance.sdk.openadsdk.core.Ym.Sj;

import androidx.annotation.NonNull;
import com.cloud.hisavana.abtestkit.db.ABContentProvider;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public enum Sj {
    XML_PARSING_ERROR(100),
    SCHEMA_VALIDATION_ERROR(101),
    WRAPPER_TIMEOUT(301),
    NO_ADS_VAST_RESPONSE(303),
    GENERAL_LINEAR_AD_ERROR(ABContentProvider.LOCAL_AB_SUCCESS),
    GENERAL_COMPANION_AD_ERROR(600),
    UNDEFINED_ERROR(900);

    private final int Dq;

    Sj(int i) {
        this.Dq = i;
    }

    @NonNull
    public String Sj() {
        return String.valueOf(this.Dq);
    }
}
