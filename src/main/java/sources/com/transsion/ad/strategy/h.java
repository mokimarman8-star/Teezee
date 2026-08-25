package com.transsion.ad.strategy;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h {
    public static final h a = new h();

    private h() {
    }

    public final void a(View view) {
        Intrinsics.h(view, "view");
        if (com.transsion.ad.scene.b.a.l()) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }
}
