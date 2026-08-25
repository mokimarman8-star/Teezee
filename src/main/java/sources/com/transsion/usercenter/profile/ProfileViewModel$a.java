package com.transsion.usercenter.profile;

import com.transsion.usercenter.profile.bean.ProfileEntranceInfo;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class ProfileViewModel$a extends dg.a {
    final /* synthetic */ ProfileViewModel d;

    ProfileViewModel$a(ProfileViewModel profileViewModel) {
        this.d = profileViewModel;
    }

    public void a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("fetchEntrance: error:");
        sb.append(str2);
        this.d.l().q((Object) null);
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(ProfileEntranceInfo profileEntranceInfo) {
        super.c(profileEntranceInfo);
        this.d.l().q(profileEntranceInfo);
    }
}
