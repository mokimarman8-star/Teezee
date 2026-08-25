package androidx.compose.ui.scrollcapture;

import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.scrollcapture.RelativeScroller", f = "ComposeScrollCaptureCallback.android.kt", l = {306}, m = "scrollBy")
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class RelativeScroller$scrollBy$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RelativeScroller this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RelativeScroller$scrollBy$1(RelativeScroller relativeScroller, Continuation<? super RelativeScroller$scrollBy$1> continuation) {
        super(continuation);
        this.this$0 = relativeScroller;
    }

    public final Object invokeSuspend(Object obj) {
        Object e5;
        this.result = obj;
        this.label |= EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        e5 = this.this$0.e(0.0f, this);
        return e5;
    }
}
