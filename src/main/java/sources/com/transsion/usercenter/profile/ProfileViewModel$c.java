package com.transsion.usercenter.profile;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.usercenter.profile.bean.ProfileInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
final class ProfileViewModel$c implements yx.f {
    public static final ProfileViewModel$c a = new ProfileViewModel$c();

    ProfileViewModel$c() {
    }

    @Override // yx.f
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(BaseDto it) {
        Intrinsics.h(it, "it");
        ProfileInfo profileInfo = (ProfileInfo) it.getData();
        if (profileInfo != null) {
            e0.a.b().putString("PROFILE_JSON", com.blankj.utilcode.util.o.j(profileInfo));
        }
    }
}
