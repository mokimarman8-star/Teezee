package iu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class j implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final ShapeableImageView c;
    public final RecyclerView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;
    public final BLTextView g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;
    public final View k;

    private j(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, BLTextView bLTextView, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, View view) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = shapeableImageView;
        this.d = recyclerView;
        this.e = appCompatTextView;
        this.f = appCompatTextView2;
        this.g = bLTextView;
        this.h = appCompatTextView3;
        this.i = appCompatTextView4;
        this.j = appCompatTextView5;
        this.k = view;
    }

    public static j a(View view) {
        ShapeableImageView a;
        RecyclerView a2;
        AppCompatTextView a3;
        AppCompatTextView a4;
        BLTextView a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        View a9;
        int i = R$id.ivClose;
        AppCompatImageView a10 = f4.b.a(view, i);
        if (a10 == null || (a = f4.b.a(view, (i = R$id.ivUserCover))) == null || (a2 = f4.b.a(view, (i = R$id.recyclerTag))) == null || (a3 = f4.b.a(view, (i = R$id.tvDes))) == null || (a4 = f4.b.a(view, (i = R$id.tvDesTitle))) == null || (a5 = f4.b.a(view, (i = R$id.tvFollow))) == null || (a6 = f4.b.a(view, (i = R$id.tvPageTitle))) == null || (a7 = f4.b.a(view, (i = R$id.tvTitle))) == null || (a8 = f4.b.a(view, (i = R$id.tvUsername))) == null || (a9 = f4.b.a(view, (i = R$id.vTitleLine))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new j((ConstraintLayout) view, a10, a, a2, a3, a4, a5, a6, a7, a8, a9);
    }

    public static j c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static j d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_ugc_video_detail_info_dialog, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
