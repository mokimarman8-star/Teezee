package com.transsion.startup;

import kotlin.jvm.functions.Function1;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class StartupManager$i extends dg.a {
    final /* synthetic */ Function1 d;

    StartupManager$i(Function1 function1) {
        this.d = function1;
    }

    public void a(String str, String str2) {
        this.d.invoke(Boolean.FALSE);
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void c(String str) {
        super.c(str);
        this.d.invoke(Boolean.TRUE);
    }
}
