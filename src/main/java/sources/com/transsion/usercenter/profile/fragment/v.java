package com.transsion.usercenter.profile.fragment;

import androidx.lifecycle.c0;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final /* synthetic */ class v implements c0, FunctionAdapter {
    private final /* synthetic */ Function1 a;

    v(Function1 function) {
        Intrinsics.h(function, "function");
        this.a = function;
    }

    @Override // kotlin.jvm.internal.FunctionAdapter
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
