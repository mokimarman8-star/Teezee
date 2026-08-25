package com.airbnb.lottie.parser.moshi;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
abstract class a {
    static String a(int i5, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = iArr[i6];
            if (i7 == 1 || i7 == 2) {
                sb.append('[');
                sb.append(iArr2[i6]);
                sb.append(']');
            } else if (i7 == 3 || i7 == 4 || i7 == 5) {
                sb.append('.');
                String str = strArr[i6];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }
}
