package com.transsnet.flow.event;

import androidx.annotation.Keep;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aJ\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b\bH\u0007¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"T", "Landroidx/lifecycle/u;", "Landroidx/lifecycle/Lifecycle$State;", "minState", "Lkotlin/Function2;", "Lkotlinx/coroutines/n0;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/t1;", "launchWhenStateAtLeast", "(Landroidx/lifecycle/u;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/t1;", "FlowEvent_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes.dex */
public final class EventUtilsKt {
    @Keep
    public static final <T> t1 launchWhenStateAtLeast(u uVar, Lifecycle.State state, Function2<? super n0, ? super Continuation<? super T>, ? extends Object> function2) {
        Intrinsics.h(uVar, "<this>");
        Intrinsics.h(state, "minState");
        Intrinsics.h(function2, "block");
        return i.d(v.a(uVar), (CoroutineContext) null, (CoroutineStart) null, new EventUtilsKt$launchWhenStateAtLeast$1(uVar, state, function2, null), 3, (Object) null);
    }
}
