package com.transsnet.login;

import com.tn.lib.net.bean.BaseDto;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class q$b implements yx.h {
    final /* synthetic */ q a;

    q$b(q qVar) {
        this.a = qVar;
    }

    @Override // yx.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final BaseDto apply(BaseDto it) {
        Intrinsics.h(it, "it");
        UserInfo userInfo = (UserInfo) it.getData();
        if (userInfo != null) {
            UserInfo x = q.x(this.a);
            userInfo.setToken(x != null ? x.getToken() : null);
        }
        return it;
    }
}
