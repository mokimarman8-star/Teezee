package com.transsion.player.shorttv.preload;

import androidx.collection.s;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c {
    private final boolean a;
    private final long b;

    public c(boolean z, long j) {
        this.a = z;
        this.b = j;
    }

    public final boolean a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a == cVar.a && this.b == cVar.b;
    }

    public int hashCode() {
        return (androidx.compose.foundation.e.a(this.a) * 31) + s.a(this.b);
    }

    public String toString() {
        return "VideoPreloadConfig(enable=" + this.a + ", cacheByte=" + this.b + ")";
    }
}
