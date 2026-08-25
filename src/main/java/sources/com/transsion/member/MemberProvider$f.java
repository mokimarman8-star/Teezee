package com.transsion.member;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.memberapi.MemberTaskInfo;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
final class MemberProvider$f implements yx.f {
    final /* synthetic */ MemberProvider a;

    MemberProvider$f(MemberProvider memberProvider) {
        this.a = memberProvider;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void accept(BaseDto baseDto) {
        Intrinsics.h(baseDto, "it");
        MemberTaskInfo memberTaskInfo = (MemberTaskInfo) baseDto.getData();
        if (memberTaskInfo != null) {
            MemberProvider memberProvider = this.a;
            w.a.b().putString("MEMBER_TASK_JSON", com.blankj.utilcode.util.o.j(memberTaskInfo));
            MemberProvider.Q(memberProvider, memberTaskInfo);
            MemberProvider.O(memberProvider, MemberProvider.J(memberProvider));
        }
    }
}
