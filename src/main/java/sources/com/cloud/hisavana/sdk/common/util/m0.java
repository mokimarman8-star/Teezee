package com.cloud.hisavana.sdk.common.util;

import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public abstract /* synthetic */ class m0 {
    public static /* synthetic */ BigDecimal a(BigDecimal bigDecimal) {
        return bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
    }
}
