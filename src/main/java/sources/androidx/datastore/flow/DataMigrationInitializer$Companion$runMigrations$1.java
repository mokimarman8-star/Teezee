package androidx.datastore.flow;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.datastore.flow.DataMigrationInitializer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.datastore.core.DataMigrationInitializer$Companion", f = "DataMigrationInitializer.kt", l = {MotionEventCompat.AXIS_GENERIC_11, 57}, m = "runMigrations")
/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class DataMigrationInitializer$Companion$runMigrations$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataMigrationInitializer.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataMigrationInitializer$Companion$runMigrations$1(DataMigrationInitializer.Companion companion, Continuation<? super DataMigrationInitializer$Companion$runMigrations$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    public final Object invokeSuspend(Object obj) {
        Object c5;
        this.result = obj;
        this.label |= EditorInfoCompat.IME_FLAG_FORCE_ASCII;
        c5 = this.this$0.c(null, null, this);
        return c5;
    }
}
