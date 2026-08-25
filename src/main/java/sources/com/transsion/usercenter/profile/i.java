package com.transsion.usercenter.profile;

import com.google.android.material.appbar.AppBarLayout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class i implements AppBarLayout.g {
    public final /* synthetic */ ProfileFragment a;
    public final /* synthetic */ xu.j0 b;

    public /* synthetic */ i(ProfileFragment profileFragment, xu.j0 j0Var) {
        this.a = profileFragment;
        this.b = j0Var;
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        ProfileFragment.e0(this.a, this.b, appBarLayout, i);
    }
}
