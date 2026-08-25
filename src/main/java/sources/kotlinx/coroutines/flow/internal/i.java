package kotlinx.coroutines.flow.internal;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public abstract class i {
    public static final void a(AbortFlowException abortFlowException, Object obj) {
        if (abortFlowException.owner != obj) {
            throw abortFlowException;
        }
    }
}
