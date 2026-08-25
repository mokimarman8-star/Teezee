package androidx.compose.ui.scrollcapture;

import android.os.CancellationSignal;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class ComposeScrollCaptureCallback_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final t1 c(n0 n0Var, final CancellationSignal cancellationSignal, Function2 function2) {
        final t1 d5 = kotlinx.coroutines.i.d(n0Var, (CoroutineContext) null, (CoroutineStart) null, function2, 3, (Object) null);
        d5.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback_androidKt$launchWithCancellationSignal$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.a;
            }

            public final void invoke(Throwable th) {
                if (th != null) {
                    cancellationSignal.cancel();
                }
            }
        });
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.compose.ui.scrollcapture.d
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                ComposeScrollCaptureCallback_androidKt.d(d5);
            }
        });
        return d5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(t1 t1Var) {
        t1.a.b(t1Var, (CancellationException) null, 1, (Object) null);
    }
}
