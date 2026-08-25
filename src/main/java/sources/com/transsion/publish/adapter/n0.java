package com.transsion.publish.adapter;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.publish.R$id;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n0 extends RecyclerView.a0 {
    private ShapeableImageView a;
    private AppCompatTextView b;
    private AppCompatTextView c;
    private AppCompatImageView d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(View view) {
        super(view);
        Intrinsics.h(view, "itemView");
        ShapeableImageView findViewById = view.findViewById(R$id.ivCover);
        Intrinsics.g(findViewById, "findViewById(...)");
        this.a = findViewById;
        AppCompatTextView findViewById2 = view.findViewById(R$id.tvSubjectTitle);
        Intrinsics.g(findViewById2, "findViewById(...)");
        this.b = findViewById2;
        AppCompatTextView findViewById3 = view.findViewById(R$id.tvSubjectYear);
        Intrinsics.g(findViewById3, "findViewById(...)");
        this.c = findViewById3;
        AppCompatImageView findViewById4 = view.findViewById(R$id.iv_publish_subject_delete);
        Intrinsics.g(findViewById4, "findViewById(...)");
        this.d = findViewById4;
    }

    public final ShapeableImageView f() {
        return this.a;
    }

    public final AppCompatImageView g() {
        return this.d;
    }

    public final AppCompatTextView h() {
        return this.c;
    }

    public final AppCompatTextView i() {
        return this.b;
    }
}
