package androidx.datastore.flow;

import androidx.core.view.inputmethod.EditorInfoCompat;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.FileReadScope", f = "FileStorage.kt", l = {169, 178}, m = "readData$suspendImpl")
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class FileReadScope$readData$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileReadScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileReadScope$readData$1(FileReadScope fileReadScope, Continuation<? super FileReadScope$readData$1> continuation) {
        super(continuation);
        this.this$0 = fileReadScope;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        return FileReadScope.i(this.this$0, this);
    }
}
