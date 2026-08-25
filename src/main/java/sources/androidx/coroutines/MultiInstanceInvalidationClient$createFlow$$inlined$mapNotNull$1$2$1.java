package androidx.coroutines;

import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2", f = "MultiInstanceInvalidationClient.android.kt", l = {239}, m = "emit")
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ o this$0;

    public MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1(o oVar, Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        throw null;
    }
}
