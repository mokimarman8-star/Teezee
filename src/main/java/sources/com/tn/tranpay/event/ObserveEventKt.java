package com.tn.tranpay.event;

import androidx.annotation.Keep;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a7\u0010\u0006\u001a\u0004\u0018\u00010\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0014\b\b\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\b"}, d2 = {"T", "Landroidx/lifecycle/u;", "Lkotlin/Function1;", "", "onReceived", "Lkotlinx/coroutines/t1;", "observeEvent", "(Landroidx/lifecycle/u;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/t1;", "lib_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class ObserveEventKt {
    @Keep
    public static final /* synthetic */ <T> t1 observeEvent(u uVar, Function1<? super T, Unit> function1) {
        Intrinsics.h(uVar, "<this>");
        Intrinsics.h(function1, "onReceived");
        if (!a.a.c()) {
            lh.a.e(lh.a.a, "TranPay SDK not initialized, cannot observe event. Please call TranPay.configure() in Application.onCreate()", null, 2, null);
            return null;
        }
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        Intrinsics.n(4, "T");
        String name = Object.class.getName();
        Intrinsics.g(name, "T::class.java.name");
        return flowEventBus.observeEvent(uVar, name, Lifecycle.State.CREATED, y0.c().p(), false, function1);
    }
}
