package g00;

import org.mvel2.util.m;

/* loaded from: /home/user/Teezee-git/app_source/classes8.dex */
public class d {
    public static int a(char[] cArr, int i) {
        int length = cArr.length;
        while (i != length) {
            char c = cArr[i];
            if (c != '(') {
                if (c != ';') {
                    if (c != '[' && c != '{') {
                        if (c != '}') {
                            i++;
                        }
                    }
                }
                return i;
            }
            i = m.c(cArr, i, c);
            i++;
        }
        return i;
    }
}
