package com.transsion.member;

import com.transsion.memberapi.TaskRewards;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MemberProvider$a extends dg.a {
    final /* synthetic */ Function2 d;
    final /* synthetic */ Function1 e;

    MemberProvider$a(Function2 function2, Function1 function1) {
        this.d = function2;
        this.e = function1;
    }

    public void a(String str, String str2) {
        a.a.b("claimTaskReward error:" + str2);
        Function2 function2 = this.d;
        if (function2 != null) {
            function2.invoke(str, str2);
        }
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(TaskRewards taskRewards) {
        a.a.a("claimTaskReward success");
        Function1 function1 = this.e;
        if (function1 != null) {
            function1.invoke(taskRewards);
        }
    }
}
