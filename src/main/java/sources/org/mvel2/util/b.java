package org.mvel2.util;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class b {
    public static int a(char c, int i, int i2, char[] cArr) {
        int i3 = i2 + i;
        while (i < i3) {
            if (cArr[i] == c) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int b(char c, int i, int i2, char[] cArr) {
        for (int i3 = (i + i2) - 1; i3 >= 0; i3--) {
            if (cArr[i3] == c) {
                return i3;
            }
        }
        return -1;
    }
}
