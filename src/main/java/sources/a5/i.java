package a5;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class i {
    private final String[] a;
    private final int b;

    public i(int i) {
        this.b = i - 1;
        this.a = new String[i];
        a("$ref", 0, 4, 1185263);
        String str = com.alibaba.fastjson.a.DEFAULT_TYPE_KEY;
        a(str, 0, str.length(), com.alibaba.fastjson.a.DEFAULT_TYPE_KEY.hashCode());
    }

    private static String d(String str, int i, int i2) {
        char[] cArr = new char[i2];
        str.getChars(i, i2 + i, cArr, 0);
        return new String(cArr);
    }

    public String a(String str, int i, int i2, int i3) {
        return b(str, i, i2, i3, false);
    }

    public String b(String str, int i, int i2, int i3, boolean z) {
        int i4 = this.b & i3;
        String str2 = this.a[i4];
        if (str2 == null) {
            if (i2 != str.length()) {
                str = d(str, i, i2);
            }
            String intern = str.intern();
            this.a[i4] = intern;
            return intern;
        }
        if (i3 == str2.hashCode() && i2 == str2.length() && str.startsWith(str2, i)) {
            return str2;
        }
        String d = d(str, i, i2);
        if (z) {
            this.a[i4] = d;
        }
        return d;
    }

    public String c(char[] cArr, int i, int i2, int i3) {
        int i4 = this.b & i3;
        String str = this.a[i4];
        if (str == null) {
            String intern = new String(cArr, i, i2).intern();
            this.a[i4] = intern;
            return intern;
        }
        if (i3 == str.hashCode() && i2 == str.length()) {
            for (int i8 = 0; i8 < i2; i8++) {
                if (cArr[i + i8] == str.charAt(i8)) {
                }
            }
            return str;
        }
        return new String(cArr, i, i2);
    }
}
