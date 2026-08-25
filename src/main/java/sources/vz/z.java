package vz;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public final class z {
    private final byte[] a;
    private final int b;

    z(byte[] bArr, int i) {
        this.a = bArr;
        this.b = i;
    }

    static void d(z zVar, d dVar) {
        if (zVar == null) {
            dVar.g(0);
            return;
        }
        byte[] bArr = zVar.a;
        int i = zVar.b;
        dVar.h(bArr, i, (bArr[i] * 2) + 1);
    }

    public int a() {
        return this.a[this.b];
    }

    public int b(int i) {
        return this.a[this.b + (i * 2) + 1];
    }

    public int c(int i) {
        return this.a[this.b + (i * 2) + 2];
    }

    public String toString() {
        int a = a();
        StringBuilder sb = new StringBuilder(a * 2);
        for (int i = 0; i < a; i++) {
            int b = b(i);
            if (b == 0) {
                sb.append('[');
            } else if (b == 1) {
                sb.append('.');
            } else if (b == 2) {
                sb.append('*');
            } else {
                if (b != 3) {
                    throw new AssertionError();
                }
                sb.append(c(i));
                sb.append(';');
            }
        }
        return sb.toString();
    }
}
