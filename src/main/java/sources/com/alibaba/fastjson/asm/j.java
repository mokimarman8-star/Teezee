package com.alibaba.fastjson.asm;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class j {

    /* renamed from: e, reason: collision with root package name */
    public static final j f14709e = new j(0, null, 1443168256, 1);

    /* renamed from: f, reason: collision with root package name */
    public static final j f14710f = new j(1, null, 1509950721, 1);

    /* renamed from: g, reason: collision with root package name */
    public static final j f14711g = new j(2, null, 1124075009, 1);

    /* renamed from: h, reason: collision with root package name */
    public static final j f14712h = new j(3, null, 1107297537, 1);

    /* renamed from: i, reason: collision with root package name */
    public static final j f14713i = new j(4, null, 1392510721, 1);

    /* renamed from: j, reason: collision with root package name */
    public static final j f14714j = new j(5, null, 1224736769, 1);

    /* renamed from: k, reason: collision with root package name */
    public static final j f14715k = new j(6, null, 1174536705, 1);

    /* renamed from: l, reason: collision with root package name */
    public static final j f14716l = new j(7, null, 1241579778, 1);

    /* renamed from: m, reason: collision with root package name */
    public static final j f14717m = new j(8, null, 1141048066, 1);

    /* renamed from: a, reason: collision with root package name */
    protected final int f14718a;

    /* renamed from: b, reason: collision with root package name */
    private final char[] f14719b;

    /* renamed from: c, reason: collision with root package name */
    private final int f14720c;

    /* renamed from: d, reason: collision with root package name */
    private final int f14721d;

    private j(int i5, char[] cArr, int i6, int i7) {
        this.f14718a = i5;
        this.f14719b = cArr;
        this.f14720c = i6;
        this.f14721d = i7;
    }

    static j[] a(String str) {
        char[] charArray = str.toCharArray();
        int i5 = 1;
        int i6 = 1;
        int i7 = 0;
        while (true) {
            int i8 = i6 + 1;
            char c5 = charArray[i6];
            if (c5 == ')') {
                break;
            }
            if (c5 == 'L') {
                while (true) {
                    i6 = i8 + 1;
                    if (charArray[i8] == ';') {
                        break;
                    }
                    i8 = i6;
                }
                i7++;
            } else {
                if (c5 != '[') {
                    i7++;
                }
                i6 = i8;
            }
        }
        j[] jVarArr = new j[i7];
        int i9 = 0;
        while (charArray[i5] != ')') {
            j h5 = h(charArray, i5);
            jVarArr[i9] = h5;
            i5 += h5.f14721d + (h5.f14718a == 10 ? 2 : 0);
            i9++;
        }
        return jVarArr;
    }

    public static int b(String str) {
        int i5;
        int i6 = 1;
        int i7 = 1;
        int i8 = 1;
        while (true) {
            i5 = i7 + 1;
            char charAt = str.charAt(i7);
            if (charAt == ')') {
                break;
            }
            if (charAt == 'L') {
                while (true) {
                    i7 = i5 + 1;
                    if (str.charAt(i5) == ';') {
                        break;
                    }
                    i5 = i7;
                }
                i8++;
            } else {
                i8 = (charAt == 'D' || charAt == 'J') ? i8 + 2 : i8 + 1;
                i7 = i5;
            }
        }
        char charAt2 = str.charAt(i5);
        int i9 = i8 << 2;
        if (charAt2 == 'V') {
            i6 = 0;
        } else if (charAt2 == 'D' || charAt2 == 'J') {
            i6 = 2;
        }
        return i9 | i6;
    }

    private int e() {
        int i5 = 1;
        while (this.f14719b[this.f14720c + i5] == '[') {
            i5++;
        }
        return i5;
    }

    public static j g(String str) {
        return h(str.toCharArray(), 0);
    }

    private static j h(char[] cArr, int i5) {
        char c5;
        char c6 = cArr[i5];
        if (c6 == 'F') {
            return f14715k;
        }
        if (c6 == 'S') {
            return f14713i;
        }
        if (c6 == 'V') {
            return f14709e;
        }
        if (c6 == 'I') {
            return f14714j;
        }
        if (c6 == 'J') {
            return f14716l;
        }
        if (c6 == 'Z') {
            return f14710f;
        }
        if (c6 != '[') {
            switch (c6) {
                case 'B':
                    return f14712h;
                case 'C':
                    return f14711g;
                case 'D':
                    return f14717m;
                default:
                    int i6 = 1;
                    while (cArr[i5 + i6] != ';') {
                        i6++;
                    }
                    return new j(10, cArr, i5 + 1, i6 - 1);
            }
        }
        int i7 = 1;
        while (true) {
            c5 = cArr[i5 + i7];
            if (c5 != '[') {
                break;
            }
            i7++;
        }
        if (c5 == 'L') {
            do {
                i7++;
            } while (cArr[i5 + i7] != ';');
        }
        return new j(9, cArr, i5, i7 + 1);
    }

    protected String c() {
        switch (this.f14718a) {
            case 0:
                return "void";
            case 1:
                return "boolean";
            case 2:
                return "char";
            case 3:
                return "byte";
            case 4:
                return "short";
            case 5:
                return "int";
            case 6:
                return "float";
            case 7:
                return "long";
            case 8:
                return "double";
            case 9:
                StringBuilder sb = new StringBuilder(h(this.f14719b, this.f14720c + e()).c());
                for (int e5 = e(); e5 > 0; e5--) {
                    sb.append("[]");
                }
                return sb.toString();
            default:
                return new String(this.f14719b, this.f14720c, this.f14721d).replace('/', '.');
        }
    }

    String d() {
        return new String(this.f14719b, this.f14720c, this.f14721d);
    }

    public String f() {
        return new String(this.f14719b, this.f14720c, this.f14721d);
    }
}
