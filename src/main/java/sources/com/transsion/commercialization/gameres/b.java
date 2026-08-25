package com.transsion.commercialization.gameres;

import android.content.Context;
import com.transsion.bean.GameInfoType;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements wj.b {
    @Override // wj.b
    public void a(Context context, String str, GameInfoType gameInfoType, String str2, Function1 function1) {
        Intrinsics.h(context, "context");
        Intrinsics.h(str, "pageName");
        Intrinsics.h(gameInfoType, "type");
        Intrinsics.h(str2, "itemId");
        Intrinsics.h(function1, "callback");
        a.a.a(gameInfoType).a(context, str, str2, function1);
    }
}
