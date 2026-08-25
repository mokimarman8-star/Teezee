package com.google.zxing.datamatrix.encoder;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class h extends c {
    h() {
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    int c(char c, StringBuilder sb2) {
        if (c == ' ') {
            sb2.append((char) 3);
            return 1;
        }
        if (c >= '0' && c <= '9') {
            sb2.append((char) (c - ','));
            return 1;
        }
        if (c >= 'a' && c <= 'z') {
            sb2.append((char) (c - 'S'));
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
        if (c >= '[' && c <= '_') {
            sb2.append((char) 1);
            sb2.append((char) (c - 'E'));
            return 2;
        }
        if (c == '`') {
            sb2.append((char) 2);
            sb2.append((char) 0);
            return 2;
        }
        if (c <= 'Z') {
            sb2.append((char) 2);
            sb2.append((char) (c - '@'));
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

    @Override // com.google.zxing.datamatrix.encoder.c
    public int f() {
        return 2;
    }
}
