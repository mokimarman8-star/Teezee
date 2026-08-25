package r9;

import com.google.android.exoplayer2.util.d0;
import i9.m;
import i9.o;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
final class e {
    private final f a = new f();
    private final d0 b = new d0(new byte[65025], 0);
    private int c = -1;
    private int d;
    private boolean e;

    e() {
    }

    private int a(int i) {
        int i2;
        int i3 = 0;
        this.d = 0;
        do {
            int i4 = this.d;
            int i5 = i + i4;
            f fVar = this.a;
            if (i5 >= fVar.g) {
                break;
            }
            int[] iArr = fVar.j;
            this.d = i4 + 1;
            i2 = iArr[i4 + i];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    public f b() {
        return this.a;
    }

    public d0 c() {
        return this.b;
    }

    public boolean d(m mVar) {
        int i;
        com.google.android.exoplayer2.util.a.g(mVar != null);
        if (this.e) {
            this.e = false;
            this.b.L(0);
        }
        while (!this.e) {
            if (this.c < 0) {
                if (!this.a.c(mVar) || !this.a.a(mVar, true)) {
                    return false;
                }
                f fVar = this.a;
                int i2 = fVar.h;
                if ((fVar.b & 1) == 1 && this.b.f() == 0) {
                    i2 += a(0);
                    i = this.d;
                } else {
                    i = 0;
                }
                if (!o.e(mVar, i2)) {
                    return false;
                }
                this.c = i;
            }
            int a = a(this.c);
            int i3 = this.c + this.d;
            if (a > 0) {
                d0 d0Var = this.b;
                d0Var.c(d0Var.f() + a);
                if (!o.d(mVar, this.b.d(), this.b.f(), a)) {
                    return false;
                }
                d0 d0Var2 = this.b;
                d0Var2.O(d0Var2.f() + a);
                this.e = this.a.j[i3 + (-1)] != 255;
            }
            if (i3 == this.a.g) {
                i3 = -1;
            }
            this.c = i3;
        }
        return true;
    }

    public void e() {
        this.a.b();
        this.b.L(0);
        this.c = -1;
        this.e = false;
    }

    public void f() {
        if (this.b.d().length == 65025) {
            return;
        }
        d0 d0Var = this.b;
        d0Var.N(Arrays.copyOf(d0Var.d(), Math.max(65025, this.b.f())), this.b.f());
    }
}
