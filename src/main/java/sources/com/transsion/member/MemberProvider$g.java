package com.transsion.member;

import com.transsion.memberapi.MemberTaskInfo;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MemberProvider$g extends dg.a {
    final /* synthetic */ MemberProvider d;
    final /* synthetic */ im.d e;

    MemberProvider$g(MemberProvider memberProvider, im.d dVar) {
        this.d = memberProvider;
        this.e = dVar;
    }

    public void a(String str, String str2) {
        a.a.b("MemberProvider --> fetchMemberTaskInfo onFailure:" + str + ", " + str2);
        hm.k.a.S(MemberProvider.N(this.d));
        im.d dVar = this.e;
        if (dVar != null) {
            dVar.b(MemberProvider.N(this.d), true);
        }
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(MemberTaskInfo memberTaskInfo) {
        super.c(memberTaskInfo);
        a.a.b("MemberProvider --> fetchMemberTaskInfo onSuccess:" + memberTaskInfo);
        hm.k.a.S(memberTaskInfo);
        im.d dVar = this.e;
        if (dVar != null) {
            dVar.b(memberTaskInfo, false);
        }
    }
}
