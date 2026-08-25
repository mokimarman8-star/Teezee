package com.vungle.ads.internal.model;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e {
    private final String description;
    private final boolean errorIsTerminal;
    private final boolean isRetryCode;

    public e(String description, boolean z, boolean z2) {
        Intrinsics.h(description, "description");
        this.description = description;
        this.errorIsTerminal = z;
        this.isRetryCode = z2;
    }

    public /* synthetic */ e(String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2);
    }

    public static /* synthetic */ e copy$default(e eVar, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = eVar.description;
        }
        if ((i & 2) != 0) {
            z = eVar.errorIsTerminal;
        }
        if ((i & 4) != 0) {
            z2 = eVar.isRetryCode;
        }
        return eVar.copy(str, z, z2);
    }

    public final String component1() {
        return this.description;
    }

    public final boolean component2() {
        return this.errorIsTerminal;
    }

    public final boolean component3() {
        return this.isRetryCode;
    }

    public final e copy(String description, boolean z, boolean z2) {
        Intrinsics.h(description, "description");
        return new e(description, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.c(this.description, eVar.description) && this.errorIsTerminal == eVar.errorIsTerminal && this.isRetryCode == eVar.isRetryCode;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean getErrorIsTerminal() {
        return this.errorIsTerminal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.description.hashCode() * 31;
        boolean z = this.errorIsTerminal;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.isRetryCode;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public final boolean isRetryCode() {
        return this.isRetryCode;
    }

    public String toString() {
        return "ErrorInfo(description=" + this.description + ", errorIsTerminal=" + this.errorIsTerminal + ", isRetryCode=" + this.isRetryCode + ')';
    }
}
