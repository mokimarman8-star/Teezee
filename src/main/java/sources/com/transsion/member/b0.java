package com.transsion.member;

import com.transsion.memberapi.TaskRewards;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final /* synthetic */ class b0 implements Function1 {
    public final /* synthetic */ MemberProvider a;
    public final /* synthetic */ Function0 b;

    public /* synthetic */ b0(MemberProvider memberProvider, Function0 function0) {
        this.a = memberProvider;
        this.b = function0;
    }

    public final Object invoke(Object obj) {
        return MemberProvider.G(this.a, this.b, (TaskRewards) obj);
    }
}
