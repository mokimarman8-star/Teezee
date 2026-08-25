package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public interface r {
    Object c();

    void cancel(CancellationException cancellationException);

    Object e(Continuation continuation);

    Object g(Continuation continuation);

    f iterator();
}
