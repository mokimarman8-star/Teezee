package hy;

import hy.c;
import hy.e;
import hy.f;
import hy.g;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public class a {
    private static final List j;
    int b;
    byte[] e;
    int f;
    InputStream g;
    private boolean[] i;
    byte[] a = new byte[8000];
    short[] c = new short[256];
    boolean d = false;
    private boolean h = false;

    /* renamed from: hy.a$a, reason: collision with other inner class name */
    private static class C0061a {
        h a;
        boolean b;

        C0061a(h hVar, boolean z) {
            this.a = hVar;
            this.b = z;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C0061a(new d(), true));
        arrayList.add(new C0061a(new e.a(), true));
        arrayList.add(new C0061a(new e.b(), true));
        arrayList.add(new C0061a(new e.d(), true));
        arrayList.add(new C0061a(new e.C0063e(), true));
        arrayList.add(new C0061a(new f.d(), true));
        arrayList.add(new C0061a(new c.b(), true));
        arrayList.add(new C0061a(new c.a(), true));
        arrayList.add(new C0061a(new c.C0062c(), true));
        arrayList.add(new C0061a(new f.c(), true));
        arrayList.add(new C0061a(new f.b.a(), true));
        arrayList.add(new C0061a(new f.b.C0064b(), true));
        arrayList.add(new C0061a(new f.a(), true));
        arrayList.add(new C0061a(new g.a(), true));
        arrayList.add(new C0061a(new g.b(), true));
        arrayList.add(new C0061a(new g.d(), true));
        arrayList.add(new C0061a(new g.f(), true));
        arrayList.add(new C0061a(new g.h(), true));
        arrayList.add(new C0061a(new g.j(), true));
        arrayList.add(new C0061a(new g.k(), true));
        arrayList.add(new C0061a(new g.u(), true));
        arrayList.add(new C0061a(new g.v(), true));
        arrayList.add(new C0061a(new g.t(), true));
        arrayList.add(new C0061a(new g.m(), true));
        arrayList.add(new C0061a(new g.s(), false));
        arrayList.add(new C0061a(new g.r(), false));
        arrayList.add(new C0061a(new g.p(), false));
        arrayList.add(new C0061a(new g.o(), false));
        j = Collections.unmodifiableList(arrayList);
    }

    private void a() {
        int i;
        int i2;
        if (this.h) {
            int i3 = 0;
            i = 0;
            i2 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < this.f; i4++) {
                byte[] bArr = this.a;
                if (i3 >= bArr.length) {
                    break;
                }
                byte b = this.e[i4];
                if (b == 60) {
                    if (z) {
                        i2++;
                    }
                    i++;
                    z = true;
                }
                if (!z) {
                    bArr[i3] = b;
                    i3++;
                }
                if (b == 62) {
                    z = false;
                }
            }
            this.b = i3;
        } else {
            i = 0;
            i2 = 0;
        }
        if (i < 5 || i / 5 < i2 || (this.b < 100 && this.f > 600)) {
            int i5 = this.f;
            if (i5 > 8000) {
                i5 = 8000;
            }
            int i6 = 0;
            while (i6 < i5) {
                this.a[i6] = this.e[i6];
                i6++;
            }
            this.b = i6;
        }
        Arrays.fill(this.c, (short) 0);
        for (int i7 = 0; i7 < this.b; i7++) {
            int i8 = this.a[i7] & 255;
            short[] sArr = this.c;
            sArr[i8] = (short) (sArr[i8] + 1);
        }
        this.d = false;
        for (int i9 = 128; i9 <= 159; i9++) {
            if (this.c[i9] != 0) {
                this.d = true;
                return;
            }
        }
    }

    public b b() {
        b[] c = c();
        if (c == null || c.length == 0) {
            return null;
        }
        return c[0];
    }

    public b[] c() {
        b c;
        ArrayList arrayList = new ArrayList();
        a();
        int i = 0;
        while (true) {
            List list = j;
            if (i >= list.size()) {
                Collections.sort(arrayList);
                Collections.reverse(arrayList);
                return (b[]) arrayList.toArray(new b[arrayList.size()]);
            }
            C0061a c0061a = (C0061a) list.get(i);
            boolean[] zArr = this.i;
            if ((zArr != null ? zArr[i] : c0061a.b) && (c = c0061a.a.c(this)) != null) {
                arrayList.add(c);
            }
            i++;
        }
    }

    public a d(byte[] bArr) {
        this.e = bArr;
        this.f = bArr.length;
        return this;
    }
}
