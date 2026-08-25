package kotlinx.coroutines.flow;

import kotlin.coroutines.Continuation;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface w0 extends b1, b {
    boolean b(Object obj);

    h1 c();

    @Override // kotlinx.coroutines.flow.b
    Object emit(Object obj, Continuation continuation);

    void f();
}
