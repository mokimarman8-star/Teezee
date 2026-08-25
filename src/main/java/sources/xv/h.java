package xv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetail.view.CustomTextViewGroup;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h implements f4.a {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final AppCompatImageView c;
    public final ShapeableImageView d;
    public final AppCompatImageView e;
    public final AppCompatImageView f;
    public final LinearLayout g;
    public final CustomTextViewGroup h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;
    public final CustomTextViewGroup k;
    public final AppCompatTextView l;
    public final CustomTextViewGroup m;
    public final AppCompatTextView n;
    public final CustomTextViewGroup o;
    public final CustomTextViewGroup p;
    public final View q;
    public final View r;

    private h(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayout linearLayout, CustomTextViewGroup customTextViewGroup, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, CustomTextViewGroup customTextViewGroup2, AppCompatTextView appCompatTextView3, CustomTextViewGroup customTextViewGroup3, AppCompatTextView appCompatTextView4, CustomTextViewGroup customTextViewGroup4, CustomTextViewGroup customTextViewGroup5, View view, View view2) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = appCompatImageView;
        this.d = shapeableImageView;
        this.e = appCompatImageView2;
        this.f = appCompatImageView3;
        this.g = linearLayout;
        this.h = customTextViewGroup;
        this.i = appCompatTextView;
        this.j = appCompatTextView2;
        this.k = customTextViewGroup2;
        this.l = appCompatTextView3;
        this.m = customTextViewGroup3;
        this.n = appCompatTextView4;
        this.o = customTextViewGroup4;
        this.p = customTextViewGroup5;
        this.q = view;
        this.r = view2;
    }

    public static h a(View view) {
        AppCompatImageView a;
        ShapeableImageView a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        CustomTextViewGroup a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        CustomTextViewGroup a8;
        AppCompatTextView a9;
        CustomTextViewGroup a10;
        AppCompatTextView a11;
        CustomTextViewGroup a12;
        CustomTextViewGroup a13;
        View a14;
        View a15;
        int i = R$id.extension_container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null && (a = f4.b.a(view, (i = R$id.ivMovieContent))) != null && (a2 = f4.b.a(view, (i = R$id.ivMovieCover))) != null && (a3 = f4.b.a(view, (i = R$id.iv_preview))) != null && (a4 = f4.b.a(view, (i = R$id.iv_score))) != null) {
            i = R$id.ll_score;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null && (a5 = f4.b.a(view, (i = R$id.tv_country))) != null && (a6 = f4.b.a(view, (i = R$id.tvMovieInfo))) != null && (a7 = f4.b.a(view, (i = R$id.tvMovieTitle))) != null && (a8 = f4.b.a(view, (i = R$id.tv_restrict))) != null && (a9 = f4.b.a(view, (i = R$id.tv_score))) != null && (a10 = f4.b.a(view, (i = R$id.tv_seasons))) != null && (a11 = f4.b.a(view, (i = R$id.tv_seasons_2))) != null && (a12 = f4.b.a(view, (i = R$id.tv_time))) != null && (a13 = f4.b.a(view, (i = R$id.tv_type))) != null && (a14 = f4.b.a(view, (i = R$id.v_detail_hot_zone))) != null && (a15 = f4.b.a(view, (i = R$id.v_seasons_line_2))) != null) {
                return new h((ConstraintLayout) view, frameLayout, a, a2, a3, a4, linearLayout, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subject_header, viewGroup, false);
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
