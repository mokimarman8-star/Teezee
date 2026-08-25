package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract /* synthetic */ class n {

    public static final class a implements kotlinx.coroutines.flow.a {
        final /* synthetic */ Object a;

        public a(Object obj) {
            this.a = obj;
        }

        @Override // kotlinx.coroutines.flow.a
        public Object a(b bVar, Continuation continuation) {
            Object emit = bVar.emit(this.a, continuation);
            return emit == IntrinsicsKt.f() ? emit : Unit.a;
        }
    }

    public static final kotlinx.coroutines.flow.a a(Function2 function2) {
        return new a1(function2);
    }

    public static final kotlinx.coroutines.flow.a b(Object obj) {
        return new a(obj);
    }
}
