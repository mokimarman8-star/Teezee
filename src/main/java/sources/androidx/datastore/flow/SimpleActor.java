package androidx.datastore.flow;

import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.d;
import kotlinx.coroutines.channels.g;
import kotlinx.coroutines.channels.h;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class SimpleActor {

    /* renamed from: a, reason: collision with root package name */
    private final n0 f7454a;

    /* renamed from: b, reason: collision with root package name */
    private final Function2 f7455b;

    /* renamed from: c, reason: collision with root package name */
    private final d f7456c;

    /* renamed from: d, reason: collision with root package name */
    private final C0190b f7457d;

    public SimpleActor(n0 n0Var, final Function1 function1, final Function2 function2, Function2 function22) {
        Intrinsics.h(n0Var, "scope");
        Intrinsics.h(function1, "onComplete");
        Intrinsics.h(function2, "onUndeliveredElement");
        Intrinsics.h(function22, "consumeMessage");
        this.f7454a = n0Var;
        this.f7455b = function22;
        this.f7456c = g.b(DescriptorProtos$Edition.EDITION_MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.f7457d = new C0190b(0);
        t1 t1Var = n0Var.getCoroutineContext().get(t1.m1);
        if (t1Var != null) {
            t1Var.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.datastore.core.SimpleActor.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.a;
                }

                public final void invoke(Throwable th) {
                    Unit unit;
                    function1.invoke(th);
                    this.f7456c.i(th);
                    do {
                        Object f5 = h.f(this.f7456c.c());
                        if (f5 != null) {
                            function2.invoke(f5, th);
                            unit = Unit.a;
                        } else {
                            unit = null;
                        }
                    } while (unit != null);
                }
            });
        }
    }

    public final void e(Object obj) {
        Object a5 = this.f7456c.a(obj);
        if (a5 instanceof h.a) {
            Throwable e5 = h.e(a5);
            if (e5 != null) {
                throw e5;
            }
            throw new ClosedSendChannelException("Channel was closed normally");
        }
        if (!h.i(a5)) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.f7457d.c() == 0) {
            i.d(this.f7454a, (CoroutineContext) null, (CoroutineStart) null, new SimpleActor$offer$2(this, null), 3, (Object) null);
        }
    }
}
