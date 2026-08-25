package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.i1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
abstract /* synthetic */ class l {
    public static final void a(r rVar, Throwable th) {
        if (th != null) {
            r0 = th instanceof CancellationException ? (CancellationException) th : null;
            if (r0 == null) {
                r0 = i1.a("Channel was consumed, consumer had failed", th);
            }
        }
        rVar.cancel(r0);
    }
}
