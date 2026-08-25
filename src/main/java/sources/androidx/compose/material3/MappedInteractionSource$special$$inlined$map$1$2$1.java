package androidx.compose.material3;

import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1$2", f = "MappedInteractionSource.kt", l = {223}, m = "emit")
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class MappedInteractionSource$special$$inlined$map$1$2$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public MappedInteractionSource$special$$inlined$map$1$2$1(d dVar, Continuation continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        throw null;
    }
}
