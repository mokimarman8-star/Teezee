package com.transsnet.login;

import com.transsnet.loginapi.bean.UserInfo;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class m implements Runnable {
    public final /* synthetic */ q a;
    public final /* synthetic */ UserInfo b;

    public /* synthetic */ m(q qVar, UserInfo userInfo) {
        this.a = qVar;
        this.b = userInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q.q(this.a, this.b);
    }
}
