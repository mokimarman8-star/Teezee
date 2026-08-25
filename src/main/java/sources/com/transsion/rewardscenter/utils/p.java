package com.transsion.rewardscenter.utils;

import com.transsion.rewardscenter.R$layout;
import fh.b;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public abstract class p {
    public static final void a(boolean z, String str) {
        Intrinsics.h(str, "string");
        if (z) {
            b.a.h(fh.b.a, R$layout.toast_success_layout, str, 17, 0, 0, 24, (Object) null);
        } else {
            b.a.h(fh.b.a, R$layout.toast_warning_layout, str, 17, 0, 0, 24, (Object) null);
        }
    }
}
