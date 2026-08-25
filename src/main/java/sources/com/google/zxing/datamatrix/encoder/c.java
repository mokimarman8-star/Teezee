package com.google.zxing.datamatrix.encoder;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
class c implements e {
    c() {
    }

    private int b(f fVar, StringBuilder sb2, StringBuilder sb3, int i) {
        int length = sb2.length();
        sb2.delete(length - i, length);
        fVar.d--;
        int c = c(fVar.c(), sb3);
        fVar.k();
        return c;
    }

    private static String e(CharSequence charSequence) {
        int charAt = (charSequence.charAt(0) * 1600) + (charSequence.charAt(1) * '(') + charSequence.charAt(2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }

    static void h(f fVar, StringBuilder sb2) {
        fVar.s(e(sb2));
        sb2.delete(0, 3);
    }

    @Override // com.google.zxing.datamatrix.encoder.e
    public void a(f fVar) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!fVar.i()) {
                break;
            }
            char c = fVar.c();
            fVar.d++;
            int c2 = c(c, sb2);
            int a = fVar.a() + ((sb2.length() / 3) * 2);
            fVar.q(a);
            int a2 = fVar.g().a() - a;
            if (!fVar.i()) {
                StringBuilder sb3 = new StringBuilder();
                if (sb2.length() % 3 == 2 && a2 != 2) {
                    c2 = b(fVar, sb2, sb3, c2);
                }
                while (sb2.length() % 3 == 1 && (c2 > 3 || a2 != 1)) {
                    c2 = b(fVar, sb2, sb3, c2);
                }
            } else if (sb2.length() % 3 == 0 && g.n(fVar.d(), fVar.d, f()) != f()) {
                fVar.o(0);
                break;
            }
        }
        g(fVar, sb2);
    }

    int c(char c, StringBuilder sb2) {
        if (c == ' ') {
            sb2.append((char) 3);
            return 1;
        }
        if (c >= '0' && c <= '9') {
            sb2.append((char) (c - ','));
            return 1;
        }
        if (c >= 'A' && c <= 'Z') {
            sb2.append((char) (c - '3'));
            return 1;
        }
        if (c < ' ') {
            sb2.append((char) 0);
            sb2.append(c);
            return 2;
        }
        if (c <= '/') {
            sb2.append((char) 1);
            sb2.append((char) (c - '!'));
            return 2;
        }
        if (c <= '@') {
            sb2.append((char) 1);
            sb2.append((char) (c - '+'));
            return 2;
        }
        if (c <= '_') {
            sb2.append((char) 1);
            sb2.append((char) (c - 'E'));
            return 2;
        }
        if (c > 127) {
            sb2.append("\u0001\u001e");
            return c((char) (c - 128), sb2) + 2;
        }
        sb2.append((char) 2);
        sb2.append((char) (c - '`'));
        return 2;
    }

    void d(f fVar) {
        StringBuilder sb2 = new StringBuilder();
        int i = fVar.d;
        int i2 = 0;
        int i3 = 0;
        while (fVar.i()) {
            char c = fVar.c();
            fVar.d++;
            i3 = c(c, sb2);
            if (sb2.length() % 3 == 0) {
                i = fVar.d;
                i2 = sb2.length();
            }
        }
        if (i2 != sb2.length()) {
            int a = fVar.a() + ((sb2.length() / 3) * 2) + 1;
            fVar.q(a);
            int a2 = fVar.g().a() - a;
            int length = sb2.length() % 3;
            if ((length == 2 && a2 != 2) || (length == 1 && (i3 > 3 || a2 != 1))) {
                sb2.setLength(i2);
                fVar.d = i;
            }
        }
        if (sb2.length() > 0) {
            fVar.r((char) 230);
        }
        g(fVar, sb2);
    }

    public int f() {
        return 1;
    }

    void g(f fVar, StringBuilder sb2) {
        int length = (sb2.length() / 3) * 2;
        int length2 = sb2.length() % 3;
        int a = fVar.a() + length;
        fVar.q(a);
        int a2 = fVar.g().a() - a;
        if (length2 == 2) {
            sb2.append((char) 0);
            while (sb2.length() >= 3) {
                h(fVar, sb2);
            }
            if (fVar.i()) {
                fVar.r((char) 254);
            }
        } else if (a2 == 1 && length2 == 1) {
            while (sb2.length() >= 3) {
                h(fVar, sb2);
            }
            if (fVar.i()) {
                fVar.r((char) 254);
            }
            fVar.d--;
        } else {
            if (length2 != 0) {
                throw new IllegalStateException("Unexpected case. Please report!");
            }
            while (sb2.length() >= 3) {
                h(fVar, sb2);
            }
            if (a2 > 0 || fVar.i()) {
                fVar.r((char) 254);
            }
        }
        fVar.o(0);
    }
}
