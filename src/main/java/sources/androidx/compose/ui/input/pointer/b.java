package androidx.compose.ui.input.pointer;

import kotlin.coroutines.Continuation;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract /* synthetic */ class b {
    public static /* synthetic */ Object a(c cVar, PointerEventPass pointerEventPass, Continuation continuation, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitPointerEvent");
        }
        if ((i5 & 1) != 0) {
            pointerEventPass = PointerEventPass.Main;
        }
        return cVar.m0(pointerEventPass, continuation);
    }
}
