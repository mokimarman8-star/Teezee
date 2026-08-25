package com.transsion.publish.adapter;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b extends RecyclerView.a0 {
    private TextView a;
    private TextView b;
    private FrameLayout c;
    private ImageView d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        Intrinsics.h(view, "itemView");
        View findViewById = view.findViewById(R$id.tv_title);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.tv_desc);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R$id.rl_close);
        Intrinsics.g(findViewById3, "findViewById(...)");
        this.c = (FrameLayout) findViewById3;
        View findViewById4 = view.findViewById(R$id.iv_play);
        Intrinsics.g(findViewById4, "findViewById(...)");
        this.d = (ImageView) findViewById4;
    }

    public final ImageView f() {
        return this.d;
    }

    public final FrameLayout g() {
        return this.c;
    }

    public final TextView h() {
        return this.b;
    }

    public final TextView i() {
        return this.a;
    }
}
