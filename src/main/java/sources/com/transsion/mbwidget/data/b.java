package com.transsion.mbwidget.data;

import com.transsion.moviedetailapi.bean.Subject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b {
    private final int a;
    private final Subject b;

    public b(int i, Subject subject) {
        Intrinsics.h(subject, "subject");
        this.a = i;
        this.b = subject;
    }

    public final int a() {
        return this.a;
    }

    public final Subject b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && Intrinsics.c(this.b, bVar.b);
    }

    public int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public String toString() {
        return "ShowItem(position=" + this.a + ", subject=" + this.b + ")";
    }
}
