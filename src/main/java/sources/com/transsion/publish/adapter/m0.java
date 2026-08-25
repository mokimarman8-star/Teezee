package com.transsion.publish.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m0 extends RecyclerView.a0 {
    private ImageView a;
    private View b;
    private TextView c;
    private TextView d;
    private View e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(View view) {
        super(view);
        Intrinsics.h(view, "itemView");
        View findViewById = view.findViewById(R$id.sv_item_cover);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.a = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R$id.sv_item_layer);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(R$id.sv_item_duration);
        Intrinsics.g(findViewById3, "findViewById(...)");
        this.c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R$id.tv_select);
        Intrinsics.g(findViewById4, "findViewById(...)");
        this.d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R$id.rl_select);
        Intrinsics.g(findViewById5, "findViewById(...)");
        this.e = findViewById5;
    }

    public final ImageView f() {
        return this.a;
    }

    public final View g() {
        return this.b;
    }

    public final View h() {
        return this.e;
    }

    public final TextView i() {
        return this.c;
    }

    public final TextView j() {
        return this.d;
    }
}
