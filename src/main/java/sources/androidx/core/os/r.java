package androidx.core.os;

import android.os.OutcomeReceiver;
import kotlin.coroutines.Continuation;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class r {
    public static final OutcomeReceiver a(Continuation continuation) {
        return q.a(new ContinuationOutcomeReceiver(continuation));
    }
}
