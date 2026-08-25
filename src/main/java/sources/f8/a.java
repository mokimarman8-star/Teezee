package f8;

import s7.e;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class a {
    private static final String a;

    static {
        String name = e.class.getName();
        a = name.substring(0, name.lastIndexOf(46) + 1);
    }

    private static StackTraceElement[] a(StackTraceElement[] stackTraceElementArr, int i) {
        int length = stackTraceElementArr.length;
        if (i > 0) {
            length = Math.min(i, length);
        }
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[length];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, length);
        return stackTraceElementArr2;
    }

    public static StackTraceElement[] b(StackTraceElement[] stackTraceElementArr, String str, int i) {
        return a(c(stackTraceElementArr, str), i);
    }

    private static StackTraceElement[] c(StackTraceElement[] stackTraceElementArr, String str) {
        int i;
        int length = stackTraceElementArr.length;
        for (int i2 = length - 1; i2 >= 0; i2--) {
            String className = stackTraceElementArr[i2].getClassName();
            if (className.startsWith(a) || (str != null && className.startsWith(str))) {
                i = i2 + 1;
                break;
            }
        }
        i = 0;
        int i3 = length - i;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i3];
        System.arraycopy(stackTraceElementArr, i, stackTraceElementArr2, 0, i3);
        return stackTraceElementArr2;
    }
}
