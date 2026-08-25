package a8;

import d8.c;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public class a implements b {
    @Override // u7.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder(256);
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return null;
        }
        if (stackTraceElementArr.length == 1) {
            return "\t─ " + stackTraceElementArr[0].toString();
        }
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (i != length - 1) {
                sb.append("\t├ ");
                sb.append(stackTraceElementArr[i].toString());
                sb.append(c.a);
            } else {
                sb.append("\t└ ");
                sb.append(stackTraceElementArr[i].toString());
            }
        }
        return sb.toString();
    }
}
