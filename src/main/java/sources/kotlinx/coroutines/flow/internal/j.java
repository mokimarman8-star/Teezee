package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface j extends kotlinx.coroutines.flow.a {

    public static final class a {
        public static /* synthetic */ kotlinx.coroutines.flow.a a(j jVar, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fuse");
            }
            if ((i2 & 1) != 0) {
                coroutineContext = EmptyCoroutineContext.INSTANCE;
            }
            if ((i2 & 2) != 0) {
                i = -3;
            }
            if ((i2 & 4) != 0) {
                bufferOverflow = BufferOverflow.SUSPEND;
            }
            return jVar.d(coroutineContext, i, bufferOverflow);
        }
    }

    kotlinx.coroutines.flow.a d(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow);
}
