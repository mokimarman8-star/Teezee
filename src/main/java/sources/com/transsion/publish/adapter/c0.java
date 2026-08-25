package com.transsion.publish.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c0 extends RecyclerView.a0 {
    private ImageView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private View f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(View view) {
        super(view);
        Intrinsics.h(view, "itemView");
        View findViewById = view.findViewById(R$id.sv_item_cover);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.a = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R$id.tv_title);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.tv_desc);
        Intrinsics.g(findViewById3, "findViewById(...)");
        this.c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R$id.tv_select);
        Intrinsics.g(findViewById4, "findViewById(...)");
        this.d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R$id.iv_play);
        Intrinsics.g(findViewById5, "findViewById(...)");
        this.e = (ImageView) findViewById5;
        View findViewById6 = view.findViewById(R$id.view_masking);
        Intrinsics.g(findViewById6, "findViewById(...)");
        this.f = findViewById6;
    }

    public final ImageView f() {
        return this.e;
    }

    public final TextView g() {
        return this.c;
    }

    public final TextView h() {
        return this.d;
    }

    public final TextView i() {
        return this.b;
    }

    public final View j() {
        return this.f;
    }
}
