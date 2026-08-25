package androidx.datastore.flow;

import kotlin.coroutines.Continuation;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class StorageConnectionKt {
    public static final Object a(x xVar, Continuation continuation) {
        return xVar.d(new StorageConnectionKt$readData$2(null), continuation);
    }
}
