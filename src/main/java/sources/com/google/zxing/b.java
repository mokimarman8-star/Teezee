package com.google.zxing;

import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class b {
    private final a a;
    private kd.b b;

    public b(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.a = aVar;
    }

    public kd.b a() {
        if (this.b == null) {
            this.b = this.a.b();
        }
        return this.b;
    }

    public kd.a b(int i, kd.a aVar) {
        return this.a.c(i, aVar);
    }

    public int c() {
        return this.a.d();
    }

    public int d() {
        return this.a.f();
    }

    public boolean e() {
        return this.a.e().f();
    }

    public b f() {
        return new b(this.a.a(this.a.e().g()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (NotFoundException unused) {
            return TtmlNode.ANONYMOUS_REGION_ID;
        }
    }
}
