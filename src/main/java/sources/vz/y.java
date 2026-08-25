package vz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public final class y {
    public static final y e = new y(0, "VZCBSIFJD", 0, 1);
    public static final y f = new y(1, "VZCBSIFJD", 1, 2);
    public static final y g = new y(2, "VZCBSIFJD", 2, 3);
    public static final y h = new y(3, "VZCBSIFJD", 3, 4);
    public static final y i = new y(4, "VZCBSIFJD", 4, 5);
    public static final y j = new y(5, "VZCBSIFJD", 5, 6);
    public static final y k = new y(6, "VZCBSIFJD", 6, 7);
    public static final y l = new y(7, "VZCBSIFJD", 7, 8);
    public static final y m = new y(8, "VZCBSIFJD", 8, 9);
    private final int a;
    private final String b;
    private final int c;
    private final int d;

    private y(int i2, String str, int i3, int i4) {
        this.a = i2;
        this.b = str;
        this.c = i3;
        this.d = i4;
    }

    private static void a(Class cls, StringBuilder sb) {
        char c;
        while (cls.isArray()) {
            sb.append('[');
            cls = cls.getComponentType();
        }
        if (!cls.isPrimitive()) {
            sb.append('L');
            String name = cls.getName();
            int length = name.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = name.charAt(i2);
                if (charAt == '.') {
                    charAt = '/';
                }
                sb.append(charAt);
            }
            sb.append(';');
            return;
        }
        if (cls == Integer.TYPE) {
            c = 'I';
        } else if (cls == Void.TYPE) {
            c = 'V';
        } else if (cls == Boolean.TYPE) {
            c = 'Z';
        } else if (cls == Byte.TYPE) {
            c = 'B';
        } else if (cls == Character.TYPE) {
            c = 'C';
        } else if (cls == Short.TYPE) {
            c = 'S';
        } else if (cls == Double.TYPE) {
            c = 'D';
        } else if (cls == Float.TYPE) {
            c = 'F';
        } else {
            if (cls != Long.TYPE) {
                throw new AssertionError();
            }
            c = 'J';
        }
        sb.append(c);
    }

    public static y[] b(String str) {
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (str.charAt(i4) != ')') {
            while (str.charAt(i4) == '[') {
                i4++;
            }
            int i6 = i4 + 1;
            i4 = str.charAt(i4) == 'L' ? str.indexOf(59, i6) + 1 : i6;
            i3++;
        }
        y[] yVarArr = new y[i3];
        int i7 = 1;
        while (str.charAt(i7) != ')') {
            int i8 = i7;
            while (str.charAt(i8) == '[') {
                i8++;
            }
            int i9 = i8 + 1;
            if (str.charAt(i8) == 'L') {
                i9 = str.indexOf(59, i9) + 1;
            }
            yVarArr[i2] = o(str, i7, i9);
            i2++;
            i7 = i9;
        }
        return yVarArr;
    }

    public static int c(String str) {
        char charAt = str.charAt(1);
        int i2 = 1;
        int i3 = 1;
        while (charAt != ')') {
            if (charAt == 'J' || charAt == 'D') {
                i2++;
                i3 += 2;
            } else {
                while (str.charAt(i2) == '[') {
                    i2++;
                }
                int i4 = i2 + 1;
                if (str.charAt(i2) == 'L') {
                    i4 = str.indexOf(59, i4) + 1;
                }
                i3++;
                i2 = i4;
            }
            charAt = str.charAt(i2);
        }
        char charAt2 = str.charAt(i2 + 1);
        if (charAt2 == 'V') {
            return i3 << 2;
        }
        return (i3 << 2) | ((charAt2 == 'J' || charAt2 == 'D') ? 2 : 1);
    }

    public static String d(Constructor constructor) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (Class<?> cls : constructor.getParameterTypes()) {
            a(cls, sb);
        }
        sb.append(")V");
        return sb.toString();
    }

    public static String f(Class cls) {
        StringBuilder sb = new StringBuilder();
        a(cls, sb);
        return sb.toString();
    }

    public static String h(Class cls) {
        return cls.getName().replace('.', '/');
    }

    public static String i(Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (Class<?> cls : method.getParameterTypes()) {
            a(cls, sb);
        }
        sb.append(')');
        a(method.getReturnType(), sb);
        return sb.toString();
    }

    public static y j(String str) {
        return new y(11, str, 0, str.length());
    }

    public static y k(String str) {
        return new y(str.charAt(0) == '[' ? 9 : 12, str, 0, str.length());
    }

    public static y m(Class cls) {
        if (!cls.isPrimitive()) {
            return n(f(cls));
        }
        if (cls == Integer.TYPE) {
            return j;
        }
        if (cls == Void.TYPE) {
            return e;
        }
        if (cls == Boolean.TYPE) {
            return f;
        }
        if (cls == Byte.TYPE) {
            return h;
        }
        if (cls == Character.TYPE) {
            return g;
        }
        if (cls == Short.TYPE) {
            return i;
        }
        if (cls == Double.TYPE) {
            return m;
        }
        if (cls == Float.TYPE) {
            return k;
        }
        if (cls == Long.TYPE) {
            return l;
        }
        throw new AssertionError();
    }

    public static y n(String str) {
        return o(str, 0, str.length());
    }

    private static y o(String str, int i2, int i3) {
        char charAt = str.charAt(i2);
        if (charAt == '(') {
            return new y(11, str, i2, i3);
        }
        if (charAt == 'F') {
            return k;
        }
        if (charAt == 'L') {
            return new y(10, str, i2 + 1, i3 - 1);
        }
        if (charAt == 'S') {
            return i;
        }
        if (charAt == 'V') {
            return e;
        }
        if (charAt == 'I') {
            return j;
        }
        if (charAt == 'J') {
            return l;
        }
        if (charAt == 'Z') {
            return f;
        }
        if (charAt == '[') {
            return new y(9, str, i2, i3);
        }
        switch (charAt) {
            case 'B':
                return h;
            case 'C':
                return g;
            case 'D':
                return m;
            default:
                throw new IllegalArgumentException();
        }
    }

    public String e() {
        int i2 = this.a;
        if (i2 == 10) {
            return this.b.substring(this.c - 1, this.d + 1);
        }
        if (i2 != 12) {
            return this.b.substring(this.c, this.d);
        }
        StringBuilder sb = new StringBuilder();
        sb.append('L');
        sb.append((CharSequence) this.b, this.c, this.d);
        sb.append(';');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        int i2 = this.a;
        if (i2 == 12) {
            i2 = 10;
        }
        int i3 = yVar.a;
        if (i2 != (i3 != 12 ? i3 : 10)) {
            return false;
        }
        int i4 = this.c;
        int i6 = this.d;
        int i7 = yVar.c;
        if (i6 - i4 != yVar.d - i7) {
            return false;
        }
        while (i4 < i6) {
            if (this.b.charAt(i4) != yVar.b.charAt(i7)) {
                return false;
            }
            i4++;
            i7++;
        }
        return true;
    }

    public String g() {
        return this.b.substring(this.c, this.d);
    }

    public int hashCode() {
        int i2 = this.a;
        int i3 = (i2 == 12 ? 10 : i2) * 13;
        if (i2 >= 9) {
            int i4 = this.d;
            for (int i6 = this.c; i6 < i4; i6++) {
                i3 = (i3 + this.b.charAt(i6)) * 17;
            }
        }
        return i3;
    }

    public int l() {
        int i2 = this.a;
        if (i2 == 12) {
            return 10;
        }
        return i2;
    }

    public String toString() {
        return e();
    }
}
