package io.reactivex.rxjava3.internal.util;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f {
    final float a;
    int b;
    int c;
    int d;
    Object[] e;

    public f() {
        this(16, 0.75f);
    }

    public f(int i, float f) {
        this.a = f;
        int a = g.a(i);
        this.b = a - 1;
        this.d = (int) (f * a);
        this.e = new Object[a];
    }

    static int c(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public boolean a(Object obj) {
        Object obj2;
        Object[] objArr = this.e;
        int i = this.b;
        int c = c(obj.hashCode()) & i;
        Object obj3 = objArr[c];
        if (obj3 != null) {
            if (obj3.equals(obj)) {
                return false;
            }
            do {
                c = (c + 1) & i;
                obj2 = objArr[c];
                if (obj2 == null) {
                }
            } while (!obj2.equals(obj));
            return false;
        }
        objArr[c] = obj;
        int i2 = this.c + 1;
        this.c = i2;
        if (i2 >= this.d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.e;
    }

    void d() {
        Object obj;
        Object[] objArr = this.e;
        int length = objArr.length;
        int i = length << 1;
        int i2 = i - 1;
        Object[] objArr2 = new Object[i];
        int i3 = this.c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                this.b = i2;
                this.d = (int) (i * this.a);
                this.e = objArr2;
                return;
            }
            do {
                length--;
                obj = objArr[length];
            } while (obj == null);
            int c = c(obj.hashCode()) & i2;
            if (objArr2[c] != null) {
                do {
                    c = (c + 1) & i2;
                } while (objArr2[c] != null);
            }
            objArr2[c] = objArr[length];
            i3 = i4;
        }
    }

    public boolean e(Object obj) {
        Object obj2;
        Object[] objArr = this.e;
        int i = this.b;
        int c = c(obj.hashCode()) & i;
        Object obj3 = objArr[c];
        if (obj3 == null) {
            return false;
        }
        if (obj3.equals(obj)) {
            return f(c, objArr, i);
        }
        do {
            c = (c + 1) & i;
            obj2 = objArr[c];
            if (obj2 == null) {
                return false;
            }
        } while (!obj2.equals(obj));
        return f(c, objArr, i);
    }

    boolean f(int i, Object[] objArr, int i2) {
        int i3;
        Object obj;
        this.c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                obj = objArr[i3];
                if (obj == null) {
                    objArr[i] = null;
                    return true;
                }
                int c = c(obj.hashCode()) & i2;
                if (i > i3) {
                    if (i >= c && c > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < c && c <= i3) {
                    i4 = i3 + 1;
                }
            }
            objArr[i] = obj;
            i = i3;
        }
    }
}
