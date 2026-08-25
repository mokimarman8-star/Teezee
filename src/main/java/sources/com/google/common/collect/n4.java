package com.google.common.collect;

import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
final class n4 {
    private final int a;
    private final Comparator b;
    private final Object[] c;
    private int d;
    private Object e;

    private n4(Comparator comparator, int i) {
        this.b = (Comparator) com.google.common.base.m.p(comparator, "comparator");
        this.a = i;
        com.google.common.base.m.f(i >= 0, "k (%s) must be >= 0", i);
        com.google.common.base.m.f(i <= 1073741823, "k (%s) must be <= Integer.MAX_VALUE / 2", i);
        this.c = new Object[com.google.common.math.d.b(i, 2)];
        this.d = 0;
        this.e = null;
    }

    public static n4 a(int i, Comparator comparator) {
        return new n4(comparator, i);
    }

    private int d(int i, int i2, int i3) {
        Object a = m3.a(this.c[i3]);
        Object[] objArr = this.c;
        objArr[i3] = objArr[i2];
        int i4 = i;
        while (i < i2) {
            if (this.b.compare(m3.a(this.c[i]), a) < 0) {
                e(i4, i);
                i4++;
            }
            i++;
        }
        Object[] objArr2 = this.c;
        objArr2[i2] = objArr2[i4];
        objArr2[i4] = a;
        return i4;
    }

    private void e(int i, int i2) {
        Object[] objArr = this.c;
        Object obj = objArr[i];
        objArr[i] = objArr[i2];
        objArr[i2] = obj;
    }

    private void g() {
        int i = (this.a * 2) - 1;
        int f = com.google.common.math.d.f(i, RoundingMode.CEILING) * 3;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            int d = d(i2, i, ((i2 + i) + 1) >>> 1);
            int i5 = this.a;
            if (d <= i5) {
                if (d >= i5) {
                    break;
                }
                i2 = Math.max(d, i2 + 1);
                i4 = d;
            } else {
                i = d - 1;
            }
            i3++;
            if (i3 >= f) {
                Arrays.sort(this.c, i2, i + 1, this.b);
                break;
            }
        }
        this.d = this.a;
        this.e = m3.a(this.c[i4]);
        while (true) {
            i4++;
            if (i4 >= this.a) {
                return;
            }
            if (this.b.compare(m3.a(this.c[i4]), m3.a(this.e)) > 0) {
                this.e = this.c[i4];
            }
        }
    }

    public void b(Object obj) {
        int i = this.a;
        if (i == 0) {
            return;
        }
        int i2 = this.d;
        if (i2 == 0) {
            this.c[0] = obj;
            this.e = obj;
            this.d = 1;
            return;
        }
        if (i2 < i) {
            Object[] objArr = this.c;
            this.d = i2 + 1;
            objArr[i2] = obj;
            if (this.b.compare(obj, m3.a(this.e)) > 0) {
                this.e = obj;
                return;
            }
            return;
        }
        if (this.b.compare(obj, m3.a(this.e)) < 0) {
            Object[] objArr2 = this.c;
            int i3 = this.d;
            int i4 = i3 + 1;
            this.d = i4;
            objArr2[i3] = obj;
            if (i4 == this.a * 2) {
                g();
            }
        }
    }

    public void c(Iterator it) {
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public List f() {
        Object[] objArr = this.c;
        Arrays.sort(objArr, 0, this.d, this.b);
        int i = this.d;
        int i2 = this.a;
        if (i > i2) {
            Object[] objArr2 = this.c;
            Arrays.fill(objArr2, i2, objArr2.length, (Object) null);
            int i3 = this.a;
            this.d = i3;
            this.e = this.c[i3 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(objArr, this.d)));
    }
}
