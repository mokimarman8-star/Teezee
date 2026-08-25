package com.transsion.usercenter.profile;

import com.transsion.usercenter.profile.bean.ProfileInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ProfileViewModel$d extends dg.a {
    final /* synthetic */ ProfileViewModel d;

    ProfileViewModel$d(ProfileViewModel profileViewModel) {
        this.d = profileViewModel;
    }

    public void a(String str, String str2) {
        ProfileViewModel.g(this.d).q((Object) null);
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(ProfileInfo profileInfo) {
        super.c(profileInfo);
        ProfileViewModel.g(this.d).q(profileInfo);
    }

    public void onSubscribe(io.reactivex.rxjava3.disposables.c d) {
        Intrinsics.h(d, "d");
        super.onSubscribe(d);
        ProfileViewModel.h(this.d, d);
    }
}
