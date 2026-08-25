package com.transsion.usercenter.laboratory;

import com.transsion.ad.db.mcc.LocalMcc;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g1 {
    private boolean a;
    private final LocalMcc b;

    public g1(boolean z, LocalMcc localMcc) {
        Intrinsics.h(localMcc, "localMcc");
        this.a = z;
        this.b = localMcc;
    }

    public final LocalMcc a() {
        return this.b;
    }

    public final boolean b() {
        return this.a;
    }

    public final void c(boolean z) {
        this.a = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g1)) {
            return false;
        }
        g1 g1Var = (g1) obj;
        return this.a == g1Var.a && Intrinsics.c(this.b, g1Var.b);
    }

    public int hashCode() {
        return (androidx.compose.foundation.e.a(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "NationalInformationEntity(isChecked=" + this.a + ", localMcc=" + this.b + ")";
    }
}
