package com.google.firebase.sessions;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class p {
    private final String a;
    private final int b;
    private final int c;
    private final boolean d;

    public p(String str, int i, int i2, boolean z) {
        Intrinsics.h(str, "processName");
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = z;
    }

    public final int a() {
        return this.c;
    }

    public final int b() {
        return this.b;
    }

    public final String c() {
        return this.a;
    }

    public final boolean d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return Intrinsics.c(this.a, pVar.a) && this.b == pVar.b && this.c == pVar.c && this.d == pVar.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31;
        boolean z = this.d;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "ProcessDetails(processName=" + this.a + ", pid=" + this.b + ", importance=" + this.c + ", isDefaultProcess=" + this.d + ')';
    }
}
