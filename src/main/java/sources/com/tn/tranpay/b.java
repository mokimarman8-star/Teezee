package com.tn.tranpay;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class b {
    public static final a c = new a(null);
    private final int a;
    private final String b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ b b(a aVar, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                str2 = null;
            }
            return aVar.a(i, str, str2);
        }

        public final b a(int i, String str, String str2) {
            Intrinsics.h(str, "debugMessage");
            if (str2 != null) {
                str = str + " and serverCode: " + str2;
            }
            return new b(i, str);
        }
    }

    public b(int i, String str) {
        Intrinsics.h(str, "debugMessage");
        this.a = i;
        this.b = str;
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public String toString() {
        return "Response Code: " + this.a + ", Debug Message: " + this.b;
    }
}
