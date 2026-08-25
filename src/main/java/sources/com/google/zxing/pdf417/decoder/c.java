package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.k;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class c {
    private final kd.b a;
    private final k b;
    private final k c;
    private final k d;
    private final k e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;

    c(c cVar) {
        this.a = cVar.a;
        this.b = cVar.b;
        this.c = cVar.c;
        this.d = cVar.d;
        this.e = cVar.e;
        this.f = cVar.f;
        this.g = cVar.g;
        this.h = cVar.h;
        this.i = cVar.i;
    }

    c(kd.b bVar, k kVar, k kVar2, k kVar3, k kVar4) {
        boolean z = kVar == null || kVar2 == null;
        boolean z2 = kVar3 == null || kVar4 == null;
        if (z && z2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (z) {
            kVar = new k(0.0f, kVar3.d());
            kVar2 = new k(0.0f, kVar4.d());
        } else if (z2) {
            kVar3 = new k(bVar.n() - 1, kVar.d());
            kVar4 = new k(bVar.n() - 1, kVar2.d());
        }
        this.a = bVar;
        this.b = kVar;
        this.c = kVar2;
        this.d = kVar3;
        this.e = kVar4;
        this.f = (int) Math.min(kVar.c(), kVar2.c());
        this.g = (int) Math.max(kVar3.c(), kVar4.c());
        this.h = (int) Math.min(kVar.d(), kVar3.d());
        this.i = (int) Math.max(kVar2.d(), kVar4.d());
    }

    static c j(c cVar, c cVar2) {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.a, cVar.b, cVar.c, cVar2.d, cVar2.e);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    c a(int i, int i2, boolean z) {
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        k kVar5 = this.b;
        k kVar6 = this.c;
        k kVar7 = this.d;
        k kVar8 = this.e;
        if (i > 0) {
            k kVar9 = z ? kVar5 : kVar7;
            int d = ((int) kVar9.d()) - i;
            if (d < 0) {
                d = 0;
            }
            k kVar10 = new k(kVar9.c(), d);
            if (!z) {
                kVar2 = kVar10;
                kVar = kVar5;
                if (i2 <= 0) {
                    k kVar11 = z ? this.c : this.e;
                    int d2 = ((int) kVar11.d()) + i2;
                    if (d2 >= this.a.k()) {
                        d2 = this.a.k() - 1;
                    }
                    k kVar12 = new k(kVar11.c(), d2);
                    if (!z) {
                        kVar4 = kVar12;
                        kVar3 = kVar6;
                        return new c(this.a, kVar, kVar3, kVar2, kVar4);
                    }
                    kVar3 = kVar12;
                } else {
                    kVar3 = kVar6;
                }
                kVar4 = kVar8;
                return new c(this.a, kVar, kVar3, kVar2, kVar4);
            }
            kVar = kVar10;
        } else {
            kVar = kVar5;
        }
        kVar2 = kVar7;
        if (i2 <= 0) {
        }
        kVar4 = kVar8;
        return new c(this.a, kVar, kVar3, kVar2, kVar4);
    }

    k b() {
        return this.c;
    }

    k c() {
        return this.e;
    }

    int d() {
        return this.g;
    }

    int e() {
        return this.i;
    }

    int f() {
        return this.f;
    }

    int g() {
        return this.h;
    }

    k h() {
        return this.b;
    }

    k i() {
        return this.d;
    }
}
