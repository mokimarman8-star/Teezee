package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class o0 {
    private static final String[] a;
    private static final byte[] b;

    static {
        String[] strArr = new String[93];
        for (int i = 0; i < 32; i++) {
            strArr[i] = "\\u" + e(i >> 12) + e(i >> 8) + e(i >> 4) + e(i);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        a = strArr;
        byte[] bArr = new byte[93];
        for (int i2 = 0; i2 < 32; i2++) {
            bArr[i2] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        b = bArr;
    }

    public static final byte[] a() {
        return b;
    }

    public static final String[] b() {
        return a;
    }

    public static final void c(StringBuilder sb, String value) {
        Intrinsics.h(sb, "<this>");
        Intrinsics.h(value, "value");
        sb.append('\"');
        int length = value.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = value.charAt(i2);
            String[] strArr = a;
            if (charAt < strArr.length && strArr[charAt] != null) {
                sb.append((CharSequence) value, i, i2);
                sb.append(strArr[charAt]);
                i = i2 + 1;
            }
        }
        if (i != 0) {
            sb.append((CharSequence) value, i, value.length());
        } else {
            sb.append(value);
        }
        sb.append('\"');
    }

    public static final Boolean d(String str) {
        Intrinsics.h(str, "<this>");
        if (StringsKt.H(str, "true", true)) {
            return Boolean.TRUE;
        }
        if (StringsKt.H(str, "false", true)) {
            return Boolean.FALSE;
        }
        return null;
    }

    private static final char e(int i) {
        int i2 = i & 15;
        return (char) (i2 < 10 ? i2 + 48 : i2 + 87);
    }
}
