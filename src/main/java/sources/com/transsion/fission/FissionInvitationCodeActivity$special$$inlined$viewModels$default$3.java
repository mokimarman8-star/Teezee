package com.transsion.fission;

import androidx.activity.ComponentActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroidx/lifecycle/t0;", "VM", "Lp1/a;", "invoke", "()Lp1/a;", "androidx/activity/ActivityViewModelLazyKt$viewModels$4", "<anonymous>"}, k = 3, mv = {2, 1, 0})
/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class FissionInvitationCodeActivity$special$$inlined$viewModels$default$3 extends Lambda implements Function0<p1.a> {
    final /* synthetic */ Function0 $extrasProducer;
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FissionInvitationCodeActivity$special$$inlined$viewModels$default$3(Function0 function0, ComponentActivity componentActivity) {
        super(0);
        this.$extrasProducer = function0;
        this.$this_viewModels = componentActivity;
    }

    public final p1.a invoke() {
        p1.a aVar;
        Function0 function0 = this.$extrasProducer;
        return (function0 == null || (aVar = (p1.a) function0.invoke()) == null) ? this.$this_viewModels.getDefaultViewModelCreationExtras() : aVar;
    }
}
