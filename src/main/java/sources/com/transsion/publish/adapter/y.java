package com.transsion.publish.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class y extends RecyclerView.a0 {
    private ImageView a;
    private TextView b;
    private View c;
    private View d;
    private View e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(View view) {
        super(view);
        Intrinsics.h(view, "itemView");
        View findViewById = view.findViewById(R$id.iv_cover);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.a = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R$id.tv_title);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.tv_desc);
        Intrinsics.g(findViewById3, "findViewById(...)");
        this.c = findViewById3;
        View findViewById4 = view.findViewById(R$id.rl_close);
        Intrinsics.g(findViewById4, "findViewById(...)");
        this.d = findViewById4;
        View findViewById5 = view.findViewById(R$id.layout);
        Intrinsics.g(findViewById5, "findViewById(...)");
        this.e = findViewById5;
    }

    public final View f() {
        return this.d;
    }

    public final TextView g() {
        return this.b;
    }
}
