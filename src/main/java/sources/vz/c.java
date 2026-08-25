package vz;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class c {
    public final String a;
    private byte[] b;
    c c;

    static final class a {
        private int a;
        private c[] b = new c[6];

        a() {
        }

        private void a(c cVar) {
            int i = this.a;
            c[] cVarArr = this.b;
            if (i >= cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length + 6];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, i);
                this.b = cVarArr2;
            }
            c[] cVarArr3 = this.b;
            int i2 = this.a;
            this.a = i2 + 1;
            cVarArr3[i2] = cVar;
        }

        private boolean c(c cVar) {
            for (int i = 0; i < this.a; i++) {
                if (this.b[i].a.equals(cVar.a)) {
                    return true;
                }
            }
            return false;
        }

        void b(c cVar) {
            while (cVar != null) {
                if (!c(cVar)) {
                    a(cVar);
                }
                cVar = cVar.c;
            }
        }

        c[] d() {
            int i = this.a;
            c[] cVarArr = new c[i];
            System.arraycopy(this.b, 0, cVarArr, 0, i);
            return cVarArr;
        }
    }

    protected c(String str) {
        this.a = str;
    }

    final int a(x xVar) {
        return b(xVar, null, 0, -1, -1);
    }

    final int b(x xVar, byte[] bArr, int i, int i2, int i3) {
        g gVar = xVar.a;
        int i4 = 0;
        for (c cVar = this; cVar != null; cVar = cVar.c) {
            xVar.D(cVar.a);
            i4 += cVar.h(gVar, bArr, i, i2, i3).b + 6;
        }
        return i4;
    }

    final int c() {
        int i = 0;
        for (c cVar = this; cVar != null; cVar = cVar.c) {
            i++;
        }
        return i;
    }

    public boolean d() {
        return false;
    }

    final void e(x xVar, d dVar) {
        f(xVar, null, 0, -1, -1, dVar);
    }

    final void f(x xVar, byte[] bArr, int i, int i2, int i3, d dVar) {
        g gVar = xVar.a;
        for (c cVar = this; cVar != null; cVar = cVar.c) {
            d h = cVar.h(gVar, bArr, i, i2, i3);
            dVar.k(xVar.D(cVar.a)).i(h.b);
            dVar.h(h.a, 0, h.b);
        }
    }

    protected c g(e eVar, int i, int i2, char[] cArr, int i3, q[] qVarArr) {
        c cVar = new c(this.a);
        byte[] bArr = new byte[i2];
        cVar.b = bArr;
        System.arraycopy(eVar.a, i, bArr, 0, i2);
        return cVar;
    }

    protected d h(g gVar, byte[] bArr, int i, int i2, int i3) {
        return new d(this.b);
    }
}
