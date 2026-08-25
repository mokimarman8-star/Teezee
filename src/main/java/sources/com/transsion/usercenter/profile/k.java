package com.transsion.usercenter.profile;

import com.transsion.usercenterapi.UpdateResultEvent;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class k implements Function1 {
    public final /* synthetic */ xu.j0 a;
    public final /* synthetic */ ProfileFragment b;

    public /* synthetic */ k(xu.j0 j0Var, ProfileFragment profileFragment) {
        this.a = j0Var;
        this.b = profileFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ProfileFragment.p0(this.a, this.b, (UpdateResultEvent) obj);
    }
}
