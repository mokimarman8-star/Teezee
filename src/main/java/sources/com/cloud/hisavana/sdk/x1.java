package com.cloud.hisavana.sdk;

import com.cloud.tmc.integration.MiniAppConfigHelper;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class x1 {
    static Object[] d;
    static int e;
    static Object[] f;
    static int g;
    int[] a = m1.a;
    Object[] b = m1.c;
    int c = 0;

    private static int e(int[] iArr, int i, int i2) {
        try {
            return m1.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private void h(int i) {
        if (i == 8) {
            synchronized (u4.class) {
                try {
                    Object[] objArr = f;
                    if (objArr != null) {
                        this.b = objArr;
                        f = (Object[]) objArr[0];
                        this.a = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        g--;
                        return;
                    }
                } finally {
                }
            }
        } else if (i == 4) {
            synchronized (u4.class) {
                try {
                    Object[] objArr2 = d;
                    if (objArr2 != null) {
                        this.b = objArr2;
                        d = (Object[]) objArr2[0];
                        this.a = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        e--;
                        return;
                    }
                } finally {
                }
            }
        }
        this.a = new int[i];
        this.b = new Object[i << 1];
    }

    private static void i(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (u4.class) {
                try {
                    if (g < 10) {
                        objArr[0] = f;
                        objArr[1] = iArr;
                        for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                            objArr[i2] = null;
                        }
                        f = objArr;
                        g++;
                    }
                } finally {
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (u4.class) {
                try {
                    if (e < 10) {
                        objArr[0] = d;
                        objArr[1] = iArr;
                        for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        d = objArr;
                        e++;
                    }
                } finally {
                }
            }
        }
    }

    int a() {
        int i = this.c;
        if (i == 0) {
            return -1;
        }
        int e2 = e(this.a, i, 0);
        if (e2 < 0 || this.b[e2 << 1] == null) {
            return e2;
        }
        int i2 = e2 + 1;
        while (i2 < i && this.a[i2] == 0) {
            if (this.b[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = e2 - 1; i3 >= 0 && this.a[i3] == 0; i3--) {
            if (this.b[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public int c(Object obj) {
        return obj == null ? a() : d(obj, obj.hashCode());
    }

    public void clear() {
        int i = this.c;
        if (i > 0) {
            int[] iArr = this.a;
            Object[] objArr = this.b;
            this.a = m1.a;
            this.b = m1.c;
            this.c = 0;
            i(iArr, objArr, i);
        }
        if (this.c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return c(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return j(obj) >= 0;
    }

    int d(Object obj, int i) {
        int i2 = this.c;
        if (i2 == 0) {
            return -1;
        }
        int e2 = e(this.a, i2, i);
        if (e2 < 0 || obj.equals(this.b[e2 << 1])) {
            return e2;
        }
        int i3 = e2 + 1;
        while (i3 < i2 && this.a[i3] == i) {
            if (obj.equals(this.b[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = e2 - 1; i4 >= 0 && this.a[i4] == i; i4--) {
            if (obj.equals(this.b[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x1) {
            x1 x1Var = (x1) obj;
            if (size() != x1Var.size()) {
                return false;
            }
            for (int i = 0; i < this.c; i++) {
                try {
                    Object l = l(i);
                    Object n = n(i);
                    Object obj2 = x1Var.get(l);
                    if (n == null) {
                        if (obj2 != null || !x1Var.containsKey(l)) {
                            return false;
                        }
                    } else if (!n.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.c; i2++) {
                try {
                    Object l2 = l(i2);
                    Object n2 = n(i2);
                    Object obj3 = map.get(l2);
                    if (n2 == null) {
                        if (obj3 != null || !map.containsKey(l2)) {
                            return false;
                        }
                    } else if (!n2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public Object f(int i, Object obj) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.b;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public Object get(Object obj) {
        int c = c(obj);
        if (c >= 0) {
            return this.b[(c << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.a;
        Object[] objArr = this.b;
        int i = this.c;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public boolean isEmpty() {
        return this.c <= 0;
    }

    int j(Object obj) {
        int i = this.c * 2;
        Object[] objArr = this.b;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public void k(int i) {
        int i2 = this.c;
        int[] iArr = this.a;
        if (iArr.length < i) {
            Object[] objArr = this.b;
            h(i);
            if (this.c > 0) {
                System.arraycopy(iArr, 0, this.a, 0, i2);
                System.arraycopy(objArr, 0, this.b, 0, i2 << 1);
            }
            i(iArr, objArr, i2);
        }
        if (this.c != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public Object l(int i) {
        return this.b[i << 1];
    }

    public Object m(int i) {
        Object[] objArr = this.b;
        int i2 = i << 1;
        Object obj = objArr[i2 + 1];
        int i3 = this.c;
        int i4 = 0;
        if (i3 <= 1) {
            i(this.a, objArr, i3);
            this.a = m1.a;
            this.b = m1.c;
        } else {
            int i8 = i3 - 1;
            int[] iArr = this.a;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i < i8) {
                    int i9 = i + 1;
                    int i10 = i8 - i;
                    System.arraycopy(iArr, i9, iArr, i, i10);
                    Object[] objArr2 = this.b;
                    System.arraycopy(objArr2, i9 << 1, objArr2, i2, i10 << 1);
                }
                Object[] objArr3 = this.b;
                int i11 = i8 << 1;
                objArr3[i11] = null;
                objArr3[i11 + 1] = null;
            } else {
                h(i3 > 8 ? i3 + (i3 >> 1) : 8);
                if (i3 != this.c) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.a, 0, i);
                    System.arraycopy(objArr, 0, this.b, 0, i2);
                }
                if (i < i8) {
                    int i12 = i + 1;
                    int i13 = i8 - i;
                    System.arraycopy(iArr, i12, this.a, i, i13);
                    System.arraycopy(objArr, i12 << 1, this.b, i2, i13 << 1);
                }
            }
            i4 = i8;
        }
        if (i3 != this.c) {
            throw new ConcurrentModificationException();
        }
        this.c = i4;
        return obj;
    }

    public Object n(int i) {
        return this.b[(i << 1) + 1];
    }

    public Object put(Object obj, Object obj2) {
        int i;
        int d2;
        int i2 = this.c;
        if (obj == null) {
            d2 = a();
            i = 0;
        } else {
            int hashCode = obj.hashCode();
            i = hashCode;
            d2 = d(obj, hashCode);
        }
        if (d2 >= 0) {
            int i3 = (d2 << 1) + 1;
            Object[] objArr = this.b;
            Object obj3 = objArr[i3];
            objArr[i3] = obj2;
            return obj3;
        }
        int i4 = ~d2;
        int[] iArr = this.a;
        if (i2 >= iArr.length) {
            int i8 = 8;
            if (i2 >= 8) {
                i8 = (i2 >> 1) + i2;
            } else if (i2 < 4) {
                i8 = 4;
            }
            Object[] objArr2 = this.b;
            h(i8);
            if (i2 != this.c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.b, 0, objArr2.length);
            }
            i(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.a;
            int i9 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i9, i2 - i4);
            Object[] objArr3 = this.b;
            System.arraycopy(objArr3, i4 << 1, objArr3, i9 << 1, (this.c - i4) << 1);
        }
        int i10 = this.c;
        if (i2 == i10) {
            int[] iArr4 = this.a;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.b;
                int i11 = i4 << 1;
                objArr4[i11] = obj;
                objArr4[i11 + 1] = obj2;
                this.c = i10 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public Object remove(Object obj) {
        int c = c(obj);
        if (c >= 0) {
            return m(c);
        }
        return null;
    }

    public int size() {
        return this.c;
    }

    public String toString() {
        if (isEmpty()) {
            return MiniAppConfigHelper.DEFAULT_KEY_CORS_LIST;
        }
        StringBuilder sb = new StringBuilder(this.c * 28);
        sb.append('{');
        for (int i = 0; i < this.c; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            Object l = l(i);
            if (l != this) {
                sb.append(l);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object n = n(i);
            if (n != this) {
                sb.append(n);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
