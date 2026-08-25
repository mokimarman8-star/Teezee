package com.transsion.member;

import com.transsion.member.bean.request.MemberPromoCodeRes;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i0 {
    private final boolean a;
    private final String b;
    private final String c;
    private final MemberPromoCodeRes d;

    public i0(boolean z, String str, String str2, MemberPromoCodeRes memberPromoCodeRes) {
        this.a = z;
        this.b = str;
        this.c = str2;
        this.d = memberPromoCodeRes;
    }

    public final String a() {
        return this.b;
    }

    public final MemberPromoCodeRes b() {
        return this.d;
    }

    public final boolean c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return false;
        }
        i0 i0Var = (i0) obj;
        return this.a == i0Var.a && Intrinsics.c(this.b, i0Var.b) && Intrinsics.c(this.c, i0Var.c) && Intrinsics.c(this.d, i0Var.d);
    }

    public int hashCode() {
        int a = androidx.compose.foundation.e.a(this.a) * 31;
        String str = this.b;
        int hashCode = (a + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        MemberPromoCodeRes memberPromoCodeRes = this.d;
        return hashCode2 + (memberPromoCodeRes != null ? memberPromoCodeRes.hashCode() : 0);
    }

    public String toString() {
        return "PromoCodeRes(res=" + this.a + ", code=" + this.b + ", message=" + this.c + ", data=" + this.d + ")";
    }
}
