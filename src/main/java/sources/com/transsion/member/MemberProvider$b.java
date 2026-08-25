package com.transsion.member;

import com.transsion.memberapi.GlobalTaskInfo;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MemberProvider$b extends dg.a {
    final /* synthetic */ MemberProvider d;

    MemberProvider$b(MemberProvider memberProvider) {
        this.d = memberProvider;
    }

    public void a(String str, String str2) {
        a.a.b("fetchGlobalTasks failed, code: " + str + ", message: " + str2);
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(GlobalTaskInfo globalTaskInfo) {
        super.c(globalTaskInfo);
        if (globalTaskInfo == null) {
            a.a.b("fetchGlobalTasks data error");
            return;
        }
        a.a.a("fetchGlobalTasks succeed " + globalTaskInfo.getTaskInfo());
        MemberProvider.M(this.d).setValue(globalTaskInfo.getTaskInfo());
        MemberProvider.K(this.d).setValue(Boolean.valueOf(globalTaskInfo.getTaskInfo() != null));
        hm.k.a.T(globalTaskInfo.getGlobalTaskConf());
    }
}
