package com.transsion.usercenter.profile;

import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final /* synthetic */ class s implements View.OnClickListener {
    public final /* synthetic */ TabLayout.Tab a;
    public final /* synthetic */ ProfileFragment b;

    public /* synthetic */ s(TabLayout.Tab tab, ProfileFragment profileFragment) {
        this.a = tab;
        this.b = profileFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ProfileFragment.a0(this.a, this.b, view);
    }
}
