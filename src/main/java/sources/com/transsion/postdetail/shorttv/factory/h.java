package com.transsion.postdetail.shorttv.factory;

import android.content.Context;
import android.content.Intent;
import com.therouter.TheRouter;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h implements ur.i {
    private final qx.a c() {
        return (qx.a) TheRouter.d(qx.a.class, new Object[0]);
    }

    @Override // ur.i
    public boolean a() {
        qx.a c = c();
        return c != null && c.a();
    }

    @Override // ur.i
    public Intent b(Context context) {
        Intrinsics.h(context, "context");
        qx.a c = c();
        if (c != null) {
            return c.p(context);
        }
        return null;
    }

    @Override // ur.i
    public String getUserId() {
        UserInfo i;
        qx.a c = c();
        if (c == null || (i = c.i()) == null) {
            return null;
        }
        return i.getUserId();
    }
}
