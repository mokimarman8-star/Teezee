package com.transsion.member;

import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class MemberProvider$h extends dg.a {
    final /* synthetic */ Function1 d;

    MemberProvider$h(Function1 function1) {
        this.d = function1;
    }

    public void a(String str, String str2) {
        a.a.b("Upload operation stat failed " + str + ", " + str2);
        Function1 function1 = this.d;
        if (function1 != null) {
            function1.invoke((Object) null);
        }
    }

    public void c(Object obj) {
        super.c(obj);
        a.a.b("Upload operation stat succeed " + obj);
        Function1 function1 = this.d;
        if (function1 != null) {
            function1.invoke("ok");
        }
    }
}
