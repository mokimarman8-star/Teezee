package com.transsion.usercenter.profile;

import androidx.viewpager2.widget.ViewPager2;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ProfileFragment$c extends ViewPager2.OnPageChangeCallback {
    final /* synthetic */ ProfileFragment a;

    ProfileFragment$c(ProfileFragment profileFragment) {
        this.a = profileFragment;
    }

    public void onPageSelected(int i) {
        super.onPageSelected(i);
        ProfileFragment.y0(this.a, i);
    }
}
