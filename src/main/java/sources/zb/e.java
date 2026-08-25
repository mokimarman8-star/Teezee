package zb;

import java.util.Stack;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class e {
    public final String a;
    public final String b;
    public final StackTraceElement[] c;
    public final e d;

    private e(String str, String str2, StackTraceElement[] stackTraceElementArr, e eVar) {
        this.a = str;
        this.b = str2;
        this.c = stackTraceElementArr;
        this.d = eVar;
    }

    public static e a(Throwable th, d dVar) {
        Stack stack = new Stack();
        while (th != null) {
            stack.push(th);
            th = th.getCause();
        }
        e eVar = null;
        while (!stack.isEmpty()) {
            Throwable th2 = (Throwable) stack.pop();
            eVar = new e(th2.getLocalizedMessage(), th2.getClass().getName(), dVar.a(th2.getStackTrace()), eVar);
        }
        return eVar;
    }
}
