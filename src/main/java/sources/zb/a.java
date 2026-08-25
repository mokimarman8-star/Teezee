package zb;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a implements d {
    private final int a;
    private final d[] b;
    private final b c;

    public a(int i, d... dVarArr) {
        this.a = i;
        this.b = dVarArr;
        this.c = new b(i);
    }

    @Override // zb.d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = stackTraceElementArr;
        for (d dVar : this.b) {
            if (stackTraceElementArr2.length <= this.a) {
                break;
            }
            stackTraceElementArr2 = dVar.a(stackTraceElementArr);
        }
        return stackTraceElementArr2.length > this.a ? this.c.a(stackTraceElementArr2) : stackTraceElementArr2;
    }
}
