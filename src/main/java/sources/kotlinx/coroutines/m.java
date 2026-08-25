package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface m extends e2 {

    public static final class a implements m {
        private final Function1 a;

        public a(Function1 function1) {
            this.a = function1;
        }

        @Override // kotlinx.coroutines.m
        public void a(Throwable th) {
            this.a.invoke(th);
        }

        public String toString() {
            return "CancelHandler.UserSupplied[" + p0.a(this.a) + '@' + p0.b(this) + ']';
        }
    }

    void a(Throwable th);
}
