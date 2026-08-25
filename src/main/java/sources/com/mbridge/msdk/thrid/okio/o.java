package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class o {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    o f;
    o g;

    o() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    o(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    public final o a(int i) {
        o a;
        if (i <= 0 || i > this.c - this.b) {
            throw new IllegalArgumentException();
        }
        if (i >= 1024) {
            a = c();
        } else {
            a = p.a();
            System.arraycopy(this.a, this.b, a.a, 0, i);
        }
        a.c = a.b + i;
        this.b += i;
        this.g.a(a);
        return a;
    }

    public final o a(o oVar) {
        oVar.g = this;
        oVar.f = this.f;
        this.f.g = oVar;
        this.f = oVar;
        return oVar;
    }

    public final void a() {
        o oVar = this.g;
        if (oVar == this) {
            throw new IllegalStateException();
        }
        if (oVar.e) {
            int i = this.c - this.b;
            if (i > (8192 - oVar.c) + (oVar.d ? 0 : oVar.b)) {
                return;
            }
            a(oVar, i);
            b();
            p.a(this);
        }
    }

    public final void a(o oVar, int i) {
        if (!oVar.e) {
            throw new IllegalArgumentException();
        }
        int i2 = oVar.c;
        int i3 = i2 + i;
        if (i3 > 8192) {
            if (oVar.d) {
                throw new IllegalArgumentException();
            }
            int i4 = oVar.b;
            if (i3 - i4 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = oVar.a;
            System.arraycopy(bArr, i4, bArr, 0, i2 - i4);
            oVar.c -= oVar.b;
            oVar.b = 0;
        }
        System.arraycopy(this.a, this.b, oVar.a, oVar.c, i);
        oVar.c += i;
        this.b += i;
    }

    @Nullable
    public final o b() {
        o oVar = this.f;
        o oVar2 = oVar != this ? oVar : null;
        o oVar3 = this.g;
        oVar3.f = oVar;
        this.f.g = oVar3;
        this.f = null;
        this.g = null;
        return oVar2;
    }

    final o c() {
        this.d = true;
        return new o(this.a, this.b, this.c, true, false);
    }
}
