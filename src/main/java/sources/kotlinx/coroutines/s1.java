package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class s1 extends w1 {
    private final Function1 e;

    public s1(Function1 function1) {
        this.e = function1;
    }

    @Override // kotlinx.coroutines.w1
    public boolean u() {
        return false;
    }

    @Override // kotlinx.coroutines.w1
    public void v(Throwable th) {
        this.e.invoke(th);
    }
}
