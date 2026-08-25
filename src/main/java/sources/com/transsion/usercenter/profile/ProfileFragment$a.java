package com.transsion.usercenter.profile;

import android.os.Bundle;
import com.transsnet.loginapi.bean.UserInfo;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ProfileFragment$a {
    private ProfileFragment$a() {
    }

    public /* synthetic */ ProfileFragment$a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final ProfileFragment a(String str, UserInfo userInfo) {
        ProfileFragment profileFragment = new ProfileFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("userInfo", userInfo);
        bundle.putString("userId", str);
        profileFragment.setArguments(bundle);
        return profileFragment;
    }
}
