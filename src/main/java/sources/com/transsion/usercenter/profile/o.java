package com.transsion.usercenter.profile;

import com.transsnet.loginapi.bean.UserInfo;
import kotlin.jvm.functions.Function0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class o implements Function0 {
    public final /* synthetic */ ProfileFragment a;
    public final /* synthetic */ UserInfo b;

    public /* synthetic */ o(ProfileFragment profileFragment, UserInfo userInfo) {
        this.a = profileFragment;
        this.b = userInfo;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return ProfileFragment.q0(this.a, this.b);
    }
}
