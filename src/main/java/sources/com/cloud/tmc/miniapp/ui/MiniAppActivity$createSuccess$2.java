package com.cloud.tmc.miniapp.ui;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public /* synthetic */ class MiniAppActivity$createSuccess$2 extends FunctionReferenceImpl implements Function3<String, String, String, Unit> {
    public MiniAppActivity$createSuccess$2(Object obj) {
        super(3, obj, MiniAppActivity.class, "showOpenAppDialog", "showOpenAppDialog(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((String) obj, (String) obj2, (String) obj3);
        return Unit.a;
    }

    public final void invoke(String str, String str2, String str3) {
        Intrinsics.h(str, "p0");
        Intrinsics.h(str2, "p1");
        Intrinsics.h(str3, "p2");
        ((MiniAppActivity) ((CallableReference) this).receiver).showOpenAppDialog(str, str2, str3);
    }
}
