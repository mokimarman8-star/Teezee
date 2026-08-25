package com.alibaba.fastjson;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public enum PropertyNamingStrategy {
    CamelCase,
    PascalCase,
    SnakeCase,
    KebabCase,
    NoChange,
    NeverUseThisValueExceptDefaultValue;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14644a;

        static {
            int[] iArr = new int[PropertyNamingStrategy.values().length];
            f14644a = iArr;
            try {
                iArr[PropertyNamingStrategy.SnakeCase.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14644a[PropertyNamingStrategy.KebabCase.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14644a[PropertyNamingStrategy.PascalCase.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14644a[PropertyNamingStrategy.CamelCase.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14644a[PropertyNamingStrategy.NoChange.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14644a[PropertyNamingStrategy.NeverUseThisValueExceptDefaultValue.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public String translate(String str) {
        char charAt;
        int i5 = a.f14644a[ordinal()];
        int i6 = 0;
        if (i5 == 1) {
            StringBuilder sb = new StringBuilder();
            while (i6 < str.length()) {
                char charAt2 = str.charAt(i6);
                if (charAt2 < 'A' || charAt2 > 'Z') {
                    sb.append(charAt2);
                } else {
                    char c5 = (char) (charAt2 + ' ');
                    if (i6 > 0) {
                        sb.append('_');
                    }
                    sb.append(c5);
                }
                i6++;
            }
            return sb.toString();
        }
        if (i5 == 2) {
            StringBuilder sb2 = new StringBuilder();
            while (i6 < str.length()) {
                char charAt3 = str.charAt(i6);
                if (charAt3 < 'A' || charAt3 > 'Z') {
                    sb2.append(charAt3);
                } else {
                    char c6 = (char) (charAt3 + ' ');
                    if (i6 > 0) {
                        sb2.append('-');
                    }
                    sb2.append(c6);
                }
                i6++;
            }
            return sb2.toString();
        }
        if (i5 != 3) {
            if (i5 != 4 || (charAt = str.charAt(0)) < 'A' || charAt > 'Z') {
                return str;
            }
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] + ' ');
            return new String(charArray);
        }
        char charAt4 = str.charAt(0);
        if (charAt4 < 'a' || charAt4 > 'z') {
            return str;
        }
        char[] charArray2 = str.toCharArray();
        charArray2[0] = (char) (charArray2[0] - ' ');
        return new String(charArray2);
    }
}
