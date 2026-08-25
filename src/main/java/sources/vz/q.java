package vz;

import org.mvel2.ast.ASTNode;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class q {
    static final q n = new q();
    short a;
    private short b;
    private int[] c;
    int d;
    private int[] e;
    short f;
    short g;
    short h;
    short i;
    n j;
    q k;
    k l;
    q m;

    private void b(int i, int i2, int i3) {
        if (this.e == null) {
            this.e = new int[6];
        }
        int[] iArr = this.e;
        int i4 = iArr[0];
        if (i4 + 2 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.e = iArr2;
        }
        int[] iArr3 = this.e;
        iArr3[i4 + 1] = i;
        int i6 = i4 + 2;
        iArr3[i6] = i2 | i3;
        iArr3[0] = i6;
    }

    private q g(q qVar) {
        for (k kVar = this.l; kVar != null; kVar = kVar.c) {
            if ((this.a & 16) == 0 || kVar != this.l.c) {
                q qVar2 = kVar.b;
                if (qVar2.m == null) {
                    qVar2.m = qVar;
                    qVar = qVar2;
                }
            }
        }
        return qVar;
    }

    final void a(r rVar, boolean z) {
        short s;
        rVar.o(this);
        if (!z || (s = this.b) == 0) {
            return;
        }
        rVar.q(s & 65535, this);
        if (this.c == null) {
            return;
        }
        int i = 1;
        while (true) {
            int[] iArr = this.c;
            if (i > iArr[0]) {
                return;
            }
            rVar.q(iArr[i], this);
            i++;
        }
    }

    final void c(int i) {
        if (this.b == 0) {
            this.b = (short) i;
            return;
        }
        if (this.c == null) {
            this.c = new int[4];
        }
        int[] iArr = this.c;
        int i2 = iArr[0] + 1;
        iArr[0] = i2;
        if (i2 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 4];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.c = iArr2;
        }
        this.c[i2] = i;
    }

    final void d(q qVar) {
        q qVar2 = n;
        this.m = qVar2;
        q qVar3 = qVar2;
        q qVar4 = this;
        while (qVar4 != n) {
            q qVar5 = qVar4.m;
            qVar4.m = qVar3;
            if ((qVar4.a & 64) != 0 && qVar4.i != qVar.i) {
                qVar4.l = new k(qVar4.g, qVar.l.b, qVar4.l);
            }
            qVar3 = qVar4;
            qVar4 = qVar4.g(qVar5);
        }
        while (qVar3 != n) {
            q qVar6 = qVar3.m;
            qVar3.m = null;
            qVar3 = qVar6;
        }
    }

    final q e() {
        n nVar = this.j;
        return nVar == null ? this : nVar.a;
    }

    final void f(short s) {
        this.m = n;
        q qVar = this;
        while (qVar != n) {
            q qVar2 = qVar.m;
            qVar.m = null;
            if (qVar.i == 0) {
                qVar.i = s;
                qVar = qVar.g(qVar2);
            } else {
                qVar = qVar2;
            }
        }
    }

    final void h(d dVar, int i, boolean z) {
        if ((this.a & 4) != 0) {
            if (z) {
                dVar.i(this.d - i);
                return;
            } else {
                dVar.k(this.d - i);
                return;
            }
        }
        if (z) {
            b(i, ASTNode.DISCARD, dVar.b);
            dVar.i(-1);
        } else {
            b(i, ASTNode.DEOP, dVar.b);
            dVar.k(-1);
        }
    }

    final boolean i(byte[] bArr, int i) {
        this.a = (short) (this.a | 4);
        this.d = i;
        int[] iArr = this.e;
        boolean z = false;
        if (iArr == null) {
            return false;
        }
        for (int i2 = iArr[0]; i2 > 0; i2 -= 2) {
            int[] iArr2 = this.e;
            int i3 = iArr2[i2 - 1];
            int i4 = iArr2[i2];
            int i6 = i - i3;
            int i7 = 268435455 & i4;
            if ((i4 & (-268435456)) == 268435456) {
                if (i6 < -32768 || i6 > 32767) {
                    int i8 = bArr[i3] & 255;
                    if (i8 < 198) {
                        bArr[i3] = (byte) (i8 + 49);
                    } else {
                        bArr[i3] = (byte) (i8 + 20);
                    }
                    z = true;
                }
                bArr[i7] = (byte) (i6 >>> 8);
                bArr[i7 + 1] = (byte) i6;
            } else {
                bArr[i7] = (byte) (i6 >>> 24);
                bArr[i7 + 1] = (byte) (i6 >>> 16);
                bArr[i7 + 2] = (byte) (i6 >>> 8);
                bArr[i7 + 3] = (byte) i6;
            }
        }
        return z;
    }

    public String toString() {
        return "L" + System.identityHashCode(this);
    }
}
