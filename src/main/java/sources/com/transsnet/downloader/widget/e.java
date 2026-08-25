package com.transsnet.downloader.widget;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e {
    private final String a;
    private boolean b;

    public e(String name, boolean z) {
        Intrinsics.h(name, "name");
        this.a = name;
        this.b = z;
    }

    public final String a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public final void c(boolean z) {
        this.b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return Intrinsics.c(this.a, eVar.a) && this.b == eVar.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + androidx.compose.foundation.e.a(this.b);
    }

    public String toString() {
        return "DownloadGridTabBean(name=" + this.a + ", isSelected=" + this.b + ")";
    }
}
