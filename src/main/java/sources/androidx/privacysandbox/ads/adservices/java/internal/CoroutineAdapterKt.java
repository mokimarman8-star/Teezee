package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.r;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.r0;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class CoroutineAdapterKt {
    public static final r b(final r0 r0Var, final Object obj) {
        Intrinsics.h(r0Var, "<this>");
        r a5 = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.privacysandbox.ads.adservices.java.internal.a
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                Object d5;
                d5 = CoroutineAdapterKt.d(r0Var, obj, aVar);
                return d5;
            }
        });
        Intrinsics.g(a5, "getFuture { completer ->…        }\n    }\n    tag\n}");
        return a5;
    }

    public static /* synthetic */ r c(r0 r0Var, Object obj, int i5, Object obj2) {
        if ((i5 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return b(r0Var, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d(final r0 r0Var, Object obj, final CallbackToFutureAdapter.a aVar) {
        Intrinsics.h(r0Var, "$this_asListenableFuture");
        Intrinsics.h(aVar, "completer");
        r0Var.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$asListenableFuture$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                invoke((Throwable) obj2);
                return Unit.a;
            }

            public final void invoke(Throwable th) {
                if (th == null) {
                    CallbackToFutureAdapter.a.this.b(r0Var.d());
                } else if (th instanceof CancellationException) {
                    CallbackToFutureAdapter.a.this.c();
                } else {
                    CallbackToFutureAdapter.a.this.e(th);
                }
            }
        });
        return obj;
    }
}
