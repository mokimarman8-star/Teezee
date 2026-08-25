package com.transsion.shorttv_pugc.ui.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;
import qr.e0;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b extends RecyclerView.a0 {
    private final e0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        Intrinsics.h(view, "view");
        e0 a = e0.a(view);
        Intrinsics.g(a, "bind(...)");
        this.a = a;
    }

    public final e0 f() {
        return this.a;
    }
}
