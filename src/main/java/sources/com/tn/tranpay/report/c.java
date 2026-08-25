package com.tn.tranpay.report;

import java.util.HashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class c {
    private final String a;
    private final boolean b;
    private final HashMap c;
    private String d;
    private boolean e;
    private boolean f;
    private long g;
    private boolean h;
    private String i;

    public c(String str, boolean z) {
        Intrinsics.h(str, "pageName");
        this.a = str;
        this.b = z;
        this.c = new HashMap();
        this.f = true;
        this.g = -1L;
    }

    public /* synthetic */ c(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? true : z);
    }

    public final String a() {
        return this.d;
    }

    public final boolean b() {
        return this.b;
    }

    public final boolean c() {
        return this.e;
    }

    public final boolean d() {
        return this.f;
    }

    public final String e() {
        return this.i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.c(this.a, cVar.a) && this.b == cVar.b;
    }

    public final String f() {
        return this.a;
    }

    public final HashMap g() {
        return this.c;
    }

    public final long h() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        boolean z = this.b;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public final boolean i() {
        return this.h;
    }

    public final void j(boolean z) {
        this.h = z;
    }

    public final void k(long j) {
        this.g = j;
    }

    public String toString() {
        return "LogViewConfig(pageName=" + this.a + ", needAddToPageFrom=" + this.b + ")";
    }
}
