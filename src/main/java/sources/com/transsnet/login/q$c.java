package com.transsnet.login;

import com.tn.lib.net.bean.BaseDto;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class q$c implements yx.f {
    final /* synthetic */ q a;

    q$c(q qVar) {
        this.a = qVar;
    }

    @Override // yx.f
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(BaseDto it) {
        Intrinsics.h(it, "it");
        this.a.c((UserInfo) it.getData());
    }
}
