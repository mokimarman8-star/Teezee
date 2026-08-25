package com.transsion.member;

import com.transsion.memberapi.MemberDetail;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MemberProvider$e extends dg.a {
    final /* synthetic */ MemberProvider d;

    MemberProvider$e(MemberProvider memberProvider) {
        this.d = memberProvider;
    }

    public void a(String str, String str2) {
        a.a.b("Fetch member detail failed " + str + ", " + str2);
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(MemberDetail memberDetail) {
        super.c(memberDetail);
        if (memberDetail == null) {
            a.a.b("Fetch member detail failed");
            return;
        }
        a.a.a("Fetch member detail succeed " + memberDetail);
        MemberProvider.P(this.d, memberDetail);
        w.a.b().putString("MEMBER_JSON", com.blankj.utilcode.util.o.j(MemberProvider.L(this.d)));
    }
}
