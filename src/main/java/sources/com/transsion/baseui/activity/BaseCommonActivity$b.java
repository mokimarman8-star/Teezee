package com.transsion.baseui.activity;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class BaseCommonActivity$b implements Function2 {
    final /* synthetic */ BaseCommonActivity a;

    BaseCommonActivity$b(BaseCommonActivity baseCommonActivity) {
        this.a = baseCommonActivity;
    }

    public final void a(androidx.compose.runtime.i iVar, int i) {
        if ((i & 3) == 2 && iVar.h()) {
            iVar.G();
            return;
        }
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(-541145127, i, -1, "com.transsion.baseui.activity.BaseCommonActivity.getEnterHomeView.<anonymous>.<anonymous> (BaseCommonActivity.kt:205)");
        }
        this.a.EnterHomeView(iVar, 0);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        a((androidx.compose.runtime.i) obj, ((Number) obj2).intValue());
        return Unit.a;
    }
}
