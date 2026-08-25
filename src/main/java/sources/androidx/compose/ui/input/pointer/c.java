package androidx.compose.ui.input.pointer;

import androidx.compose.ui.platform.o2;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public interface c extends o0.e {
    Object N(long j5, Function2 function2, Continuation continuation);

    long X();

    Object e0(long j5, Function2 function2, Continuation continuation);

    o2 getViewConfiguration();

    long k();

    Object m0(PointerEventPass pointerEventPass, Continuation continuation);

    o n0();
}
