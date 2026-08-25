package v7;

import d8.c;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class b implements a {
    private static String b(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 10);
        String[] split = str.split(c.a);
        int length = split.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(c.a);
            }
            String str2 = split[i];
            sb.append((char) 9553);
            sb.append(str2);
        }
        return sb.toString();
    }

    @Override // u7.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        String[] strArr2 = new String[strArr.length];
        int i = 0;
        for (String str : strArr) {
            if (str != null) {
                strArr2[i] = str;
                i++;
            }
        }
        if (i == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("╔═══════════════════════════════════════════════════════════════════════════════════════════════════");
        sb.append(c.a);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(b(strArr2[i2]));
            if (i2 != i - 1) {
                sb.append(c.a);
                sb.append("╟───────────────────────────────────────────────────────────────────────────────────────────────────");
                sb.append(c.a);
            } else {
                sb.append(c.a);
                sb.append("╚═══════════════════════════════════════════════════════════════════════════════════════════════════");
            }
        }
        return sb.toString();
    }
}
