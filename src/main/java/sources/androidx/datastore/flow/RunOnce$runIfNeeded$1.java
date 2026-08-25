package androidx.datastore.flow;

import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.RunOnce", f = "DataStoreImpl.kt", l = {544, 497}, m = "runIfNeeded")
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class RunOnce$runIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RunOnce this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RunOnce$runIfNeeded$1(RunOnce runOnce, Continuation<? super RunOnce$runIfNeeded$1> continuation) {
        super(continuation);
        this.this$0 = runOnce;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        return this.this$0.c(this);
    }
}
