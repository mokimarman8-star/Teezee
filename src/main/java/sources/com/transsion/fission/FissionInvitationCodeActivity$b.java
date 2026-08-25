package com.transsion.fission;

import androidx.lifecycle.c0;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class FissionInvitationCodeActivity$b implements c0, FunctionAdapter {
    private final /* synthetic */ Function1 a;

    FissionInvitationCodeActivity$b(Function1 function1) {
        Intrinsics.h(function1, "function");
        this.a = function1;
    }

    public final Function a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final /* synthetic */ void onChanged(Object obj) {
        this.a.invoke(obj);
    }
}
