package com.transsion.publish.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c extends RecyclerView.a0 {
    private ImageView a;
    private View b;
    private View c;
    private TextView d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(View view) {
        super(view);
        Intrinsics.e(view);
        this.a = (ImageView) view.findViewById(R$id.iv_photo);
        this.b = view.findViewById(R$id.iv_clear);
        this.c = view.findViewById(R$id.rl_add);
        this.d = (TextView) view.findViewById(R$id.tv_number);
    }

    public final View f() {
        return this.c;
    }

    public final View g() {
        return this.b;
    }

    public final ImageView h() {
        return this.a;
    }

    public final TextView i() {
        return this.d;
    }
}
