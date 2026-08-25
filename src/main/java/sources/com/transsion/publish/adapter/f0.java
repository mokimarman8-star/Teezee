package com.transsion.publish.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f0 extends RecyclerView.a0 {
    private ImageView a;
    private TextView b;
    private View c;
    private View d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(View view) {
        super(view);
        Intrinsics.h(view, "itemView");
        View findViewById = view.findViewById(R$id.sv_item_cover);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.a = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R$id.tv_select);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.view_masking);
        Intrinsics.g(findViewById3, "findViewById(...)");
        this.c = findViewById3;
        View findViewById4 = view.findViewById(R$id.rl_select);
        Intrinsics.g(findViewById4, "findViewById(...)");
        this.d = findViewById4;
    }

    public final ImageView f() {
        return this.a;
    }

    public final View g() {
        return this.d;
    }

    public final TextView h() {
        return this.b;
    }

    public final View i() {
        return this.c;
    }
}
