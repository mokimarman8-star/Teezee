package com.transsion.baseui.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h {
    public static final a a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String b(String str) {
            long parseLong = Long.parseLong(str);
            if (parseLong < 0) {
                return "-";
            }
            if (parseLong < 1000) {
                return str.toString();
            }
            if (1000 <= parseLong && parseLong < 1000001) {
                return new BigDecimal(str).divide(new BigDecimal("1000")).setScale(1, RoundingMode.HALF_UP) + "k";
            }
            if (parseLong < 1000000) {
                return str.toString();
            }
            return new BigDecimal(str).divide(new BigDecimal("1000000")).setScale(1, RoundingMode.HALF_UP) + "m";
        }

        public final String a(String str) {
            if (str == null) {
                return "0";
            }
            try {
                return b(str);
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }
    }
}
