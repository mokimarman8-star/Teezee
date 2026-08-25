package vz;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
final class p {
    final q a;
    final q b;
    final q c;
    final int d;
    final String e;
    p f;

    p(p pVar, q qVar, q qVar2) {
        this(qVar, qVar2, pVar.c, pVar.d, pVar.e);
        this.f = pVar.f;
    }

    p(q qVar, q qVar2, q qVar3, int i, String str) {
        this.a = qVar;
        this.b = qVar2;
        this.c = qVar3;
        this.d = i;
        this.e = str;
    }

    static int a(p pVar) {
        int i = 0;
        while (pVar != null) {
            i++;
            pVar = pVar.f;
        }
        return i;
    }

    static int b(p pVar) {
        return (a(pVar) * 8) + 2;
    }

    static void c(p pVar, d dVar) {
        dVar.k(a(pVar));
        while (pVar != null) {
            dVar.k(pVar.a.d).k(pVar.b.d).k(pVar.c.d).k(pVar.d);
            pVar = pVar.f;
        }
    }

    static p d(p pVar, q qVar, q qVar2) {
        if (pVar == null) {
            return null;
        }
        p d = d(pVar.f, qVar, qVar2);
        pVar.f = d;
        q qVar3 = pVar.a;
        int i = qVar3.d;
        q qVar4 = pVar.b;
        int i2 = qVar4.d;
        int i3 = qVar.d;
        int i4 = qVar2 == null ? Integer.MAX_VALUE : qVar2.d;
        if (i3 >= i2 || i4 <= i) {
            return pVar;
        }
        if (i3 <= i) {
            return i4 >= i2 ? d : new p(pVar, qVar2, qVar4);
        }
        if (i4 >= i2) {
            return new p(pVar, qVar3, qVar);
        }
        pVar.f = new p(pVar, qVar2, qVar4);
        return new p(pVar, pVar.a, qVar);
    }
}
