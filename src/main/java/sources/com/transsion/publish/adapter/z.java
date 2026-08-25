package com.transsion.publish.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class z extends RecyclerView.a0 {
    private TextView a;
    private View b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(View view) {
        super(view);
        Intrinsics.h(view, "itemView");
        View findViewById = view.findViewById(R$id.tvLocation);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R$id.iv_publish_location_delete);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.b = findViewById2;
    }

    public final View f() {
        return this.b;
    }

    public final TextView g() {
        return this.a;
    }
}
