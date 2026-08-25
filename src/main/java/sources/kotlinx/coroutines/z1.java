package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class z1 extends i2 {
    private final Continuation a;

    public z1(CoroutineContext coroutineContext, Function2 function2) {
        super(coroutineContext, false);
        this.a = IntrinsicsKt.a(function2, this, this);
    }

    protected void onStart() {
        py.a.b(this.a, this);
    }
}
