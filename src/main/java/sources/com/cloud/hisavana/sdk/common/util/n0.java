package com.cloud.hisavana.sdk.common.util;

import com.cloud.hisavana.sdk.b4;
import java.math.BigDecimal;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class n0 {
    public static final n0 a = new n0();

    private n0() {
    }

    public static final double a(Double d) {
        if (d == null) {
            return 0.0d;
        }
        try {
            return m0.a(BigDecimal.valueOf(d.doubleValue()).divide(new BigDecimal(100))).doubleValue();
        } catch (Exception e) {
            b4.b().w("UnitUtil", "cents convert to dollar fail, reason is " + e.getMessage());
            return 0.0d;
        }
    }

    public static final double b(Double d) {
        if (d == null) {
            return 0.0d;
        }
        try {
            BigDecimal valueOf = BigDecimal.valueOf(d.doubleValue());
            Intrinsics.g(valueOf, "valueOf(...)");
            return m0.a(valueOf.multiply(BigDecimal.valueOf(100L))).doubleValue();
        } catch (Exception e) {
            b4.b().w("UnitUtil", "dollar convert to cents fail, reason is " + e.getMessage());
            return 0.0d;
        }
    }
}
