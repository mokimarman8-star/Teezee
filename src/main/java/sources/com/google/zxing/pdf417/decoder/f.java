package com.google.zxing.pdf417.decoder;

import java.util.Formatter;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class f {
    private final c a;
    private final d[] b;

    f(c cVar) {
        this.a = new c(cVar);
        this.b = new d[(cVar.e() - cVar.g()) + 1];
    }

    final c a() {
        return this.a;
    }

    final d b(int i) {
        return this.b[e(i)];
    }

    final d c(int i) {
        d dVar;
        d dVar2;
        d b = b(i);
        if (b != null) {
            return b;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int e = e(i) - i2;
            if (e >= 0 && (dVar2 = this.b[e]) != null) {
                return dVar2;
            }
            int e2 = e(i) + i2;
            d[] dVarArr = this.b;
            if (e2 < dVarArr.length && (dVar = dVarArr[e2]) != null) {
                return dVar;
            }
        }
        return null;
    }

    final d[] d() {
        return this.b;
    }

    final int e(int i) {
        return i - this.a.g();
    }

    final void f(int i, d dVar) {
        this.b[e(i)] = dVar;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i = 0;
            for (d dVar : this.b) {
                if (dVar == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i));
                    i++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
                    i++;
                }
            }
            String formatter2 = formatter.toString();
            formatter.close();
            return formatter2;
        } catch (Throwable th) {
            try {
                formatter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
