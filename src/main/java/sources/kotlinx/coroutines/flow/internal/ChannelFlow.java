package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.n;
import kotlinx.coroutines.channels.p;
import kotlinx.coroutines.channels.r;
import kotlinx.coroutines.flow.a;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;

/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public abstract class ChannelFlow implements j {
    public final CoroutineContext a;
    public final int b;
    public final BufferOverflow c;

    public ChannelFlow(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        this.a = coroutineContext;
        this.b = i;
        this.c = bufferOverflow;
    }

    static /* synthetic */ Object h(ChannelFlow channelFlow, b bVar, Continuation continuation) {
        Object e = o0.e(new ChannelFlow$collect$2(bVar, channelFlow, null), continuation);
        return e == IntrinsicsKt.f() ? e : Unit.a;
    }

    public Object a(b bVar, Continuation continuation) {
        return h(this, bVar, continuation);
    }

    public a d(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow) {
        CoroutineContext plus = coroutineContext.plus(this.a);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i2 = this.b;
            if (i2 != -3) {
                if (i != -3) {
                    if (i2 != -2) {
                        if (i != -2) {
                            i += i2;
                            if (i < 0) {
                                i = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i = i2;
            }
            bufferOverflow = this.c;
        }
        return (Intrinsics.c(plus, this.a) && i == this.b && bufferOverflow == this.c) ? this : j(plus, i, bufferOverflow);
    }

    protected String g() {
        return null;
    }

    protected abstract Object i(p pVar, Continuation continuation);

    protected abstract ChannelFlow j(CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow);

    public a k() {
        return null;
    }

    public final Function2 l() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    public final int m() {
        int i = this.b;
        if (i == -3) {
            return -2;
        }
        return i;
    }

    public r n(n0 n0Var) {
        return n.b(n0Var, this.a, m(), this.c, CoroutineStart.ATOMIC, (Function1) null, l(), 16, (Object) null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String g = g();
        if (g != null) {
            arrayList.add(g);
        }
        if (this.a != EmptyCoroutineContext.INSTANCE) {
            arrayList.add("context=" + this.a);
        }
        if (this.b != -3) {
            arrayList.add("capacity=" + this.b);
        }
        if (this.c != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.c);
        }
        return p0.a(this) + '[' + CollectionsKt.s0(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + ']';
    }
}
