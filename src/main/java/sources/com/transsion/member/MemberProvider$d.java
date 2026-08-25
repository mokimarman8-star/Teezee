package com.transsion.member;

import com.transsion.memberapi.MemberAdTaskInfo;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MemberProvider$d extends dg.a {
    final /* synthetic */ im.d d;

    MemberProvider$d(im.d dVar) {
        this.d = dVar;
    }

    public void a(String str, String str2) {
        a.a.b("fetchMemberAdTaskInfo onFailure:" + str + ", " + str2);
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(MemberAdTaskInfo memberAdTaskInfo) {
        super.c(memberAdTaskInfo);
        a.a.b("fetchMemberAdTaskInfo onSuccess:" + memberAdTaskInfo);
        im.d dVar = this.d;
        if (dVar != null) {
            dVar.a(memberAdTaskInfo, false);
        }
    }
}
