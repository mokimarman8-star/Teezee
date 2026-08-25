package com.tn.tranpay.event;

import androidx.annotation.Keep;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.t0;
import androidx.lifecycle.u;
import androidx.lifecycle.u0;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.h1;
import kotlinx.coroutines.flow.w0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.t1;

@Keep
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\u0011\u001a\u00020\u000f\"\b\b\u0000\u0010\f*\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012JS\u0010\u001a\u001a\u00020\u0019\"\b\b\u0000\u0010\f*\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u001a\u0010\u001bJA\u0010\u001c\u001a\u00020\u000f\"\b\b\u0000\u0010\f*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010 \u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b$\u0010#J\u0015\u0010&\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b&\u0010'R<\u0010*\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0(j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R<\u0010,\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0(j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010+\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lcom/tn/tranpay/event/FlowEventBus;", "Landroidx/lifecycle/t0;", "<init>", "()V", "", "eventName", "", "isSticky", "Lkotlinx/coroutines/flow/w0;", "", "getEventFlow", "(Ljava/lang/String;Z)Lkotlinx/coroutines/flow/w0;", "T", "value", "Lkotlin/Function1;", "", "onReceived", "invokeReceived", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Landroidx/lifecycle/u;", "lifecycleOwner", "Landroidx/lifecycle/Lifecycle$State;", "minState", "Lkotlinx/coroutines/i0;", "dispatcher", "Lkotlinx/coroutines/t1;", "observeEvent", "(Landroidx/lifecycle/u;Ljava/lang/String;Landroidx/lifecycle/Lifecycle$State;Lkotlinx/coroutines/i0;ZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/t1;", "observeWithoutLifecycle", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "postEvent", "(Ljava/lang/String;Ljava/lang/Object;J)V", "removeStickEvent", "(Ljava/lang/String;)V", "clearStickEvent", "", "getEventObserverCount", "(Ljava/lang/String;)I", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "eventFlows", "Ljava/util/HashMap;", "stickyEventFlows", "lib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class FlowEventBus extends t0 {
    private final HashMap<String, w0> eventFlows = new HashMap<>();
    private final HashMap<String, w0> stickyEventFlows = new HashMap<>();

    static final class a implements kotlinx.coroutines.flow.b {
        final /* synthetic */ Function1 b;

        a(Function1 function1) {
            this.b = function1;
        }

        public final Object emit(Object obj, Continuation continuation) {
            FlowEventBus.this.invokeReceived(obj, this.b);
            return Unit.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final w0 getEventFlow(String eventName, boolean isSticky) {
        w0 w0Var = isSticky ? this.stickyEventFlows.get(eventName) : this.eventFlows.get(eventName);
        if (w0Var == null) {
            w0Var = c1.b(isSticky ? 1 : 0, Integer.MAX_VALUE, (BufferOverflow) null, 4, (Object) null);
            if (isSticky) {
                this.stickyEventFlows.put(eventName, w0Var);
            } else {
                this.eventFlows.put(eventName, w0Var);
            }
        }
        return w0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void invokeReceived(Object value, Function1<? super T, Unit> onReceived) {
        try {
            Intrinsics.f(value, "null cannot be cast to non-null type T of com.tn.tranpay.event.FlowEventBus.invokeReceived");
            onReceived.invoke(value);
        } catch (ClassCastException e) {
            String message = e.getMessage();
            if (message != null) {
                lh.a.c(lh.a.a, "class cast error on message received: " + message, null, 2, null);
            }
        } catch (Exception e2) {
            String message2 = e2.getMessage();
            if (message2 != null) {
                lh.a.c(lh.a.a, "error on message received: " + message2, null, 2, null);
            }
        }
    }

    public final void clearStickEvent(String eventName) {
        Intrinsics.h(eventName, "eventName");
        w0 w0Var = this.stickyEventFlows.get(eventName);
        if (w0Var != null) {
            w0Var.f();
        }
    }

    public final int getEventObserverCount(String eventName) {
        h1 c;
        h1 c2;
        Intrinsics.h(eventName, "eventName");
        w0 w0Var = this.stickyEventFlows.get(eventName);
        int i = 0;
        int intValue = (w0Var == null || (c2 = w0Var.c()) == null) ? 0 : ((Number) c2.getValue()).intValue();
        w0 w0Var2 = this.eventFlows.get(eventName);
        if (w0Var2 != null && (c = w0Var2.c()) != null) {
            i = ((Number) c.getValue()).intValue();
        }
        return intValue + i;
    }

    public final <T> t1 observeEvent(u lifecycleOwner, String eventName, Lifecycle.State minState, i0 dispatcher, boolean isSticky, Function1<? super T, Unit> onReceived) {
        Intrinsics.h(lifecycleOwner, "lifecycleOwner");
        Intrinsics.h(eventName, "eventName");
        Intrinsics.h(minState, "minState");
        Intrinsics.h(dispatcher, "dispatcher");
        Intrinsics.h(onReceived, "onReceived");
        return EventUtilsKt.launchWhenStateAtLeast(lifecycleOwner, minState, new FlowEventBus$observeEvent$1(this, eventName, isSticky, dispatcher, onReceived, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object observeWithoutLifecycle(String str, boolean z, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        FlowEventBus$observeWithoutLifecycle$1 flowEventBus$observeWithoutLifecycle$1;
        int i;
        if (continuation instanceof FlowEventBus$observeWithoutLifecycle$1) {
            flowEventBus$observeWithoutLifecycle$1 = (FlowEventBus$observeWithoutLifecycle$1) continuation;
            int i2 = flowEventBus$observeWithoutLifecycle$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                flowEventBus$observeWithoutLifecycle$1.label = i2 - Integer.MIN_VALUE;
                Object obj = flowEventBus$observeWithoutLifecycle$1.result;
                Object f = IntrinsicsKt.f();
                i = flowEventBus$observeWithoutLifecycle$1.label;
                if (i != 0) {
                    ResultKt.b(obj);
                    w0 eventFlow = getEventFlow(str, z);
                    a aVar = new a(function1);
                    flowEventBus$observeWithoutLifecycle$1.label = 1;
                    if (eventFlow.a(aVar, flowEventBus$observeWithoutLifecycle$1) == f) {
                        return f;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                throw new KotlinNothingValueException();
            }
        }
        flowEventBus$observeWithoutLifecycle$1 = new FlowEventBus$observeWithoutLifecycle$1(this, continuation);
        Object obj2 = flowEventBus$observeWithoutLifecycle$1.result;
        Object f2 = IntrinsicsKt.f();
        i = flowEventBus$observeWithoutLifecycle$1.label;
        if (i != 0) {
        }
        throw new KotlinNothingValueException();
    }

    public final void postEvent(String eventName, Object value, long timeMillis) {
        Intrinsics.h(eventName, "eventName");
        Intrinsics.h(value, "value");
        lh.a.c(lh.a.a, "post Event:" + eventName, null, 2, null);
        Iterator it = CollectionsKt.p(new w0[]{getEventFlow(eventName, false), getEventFlow(eventName, true)}).iterator();
        while (it.hasNext()) {
            i.d(u0.a(this), (CoroutineContext) null, (CoroutineStart) null, new FlowEventBus$postEvent$1$1(timeMillis, (w0) it.next(), value, null), 3, (Object) null);
        }
    }

    public final void removeStickEvent(String eventName) {
        Intrinsics.h(eventName, "eventName");
        this.stickyEventFlows.remove(eventName);
    }
}
