package lm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class t implements f4.a {
    private final ConstraintLayout a;
    public final Barrier b;
    public final View c;
    public final AppCompatImageView d;
    public final ShapeableImageView e;
    public final View f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    public final LinearLayout i;
    public final AppCompatTextView j;
    public final AppCompatTextView k;
    public final AppCompatTextView l;
    public final AppCompatTextView m;
    public final AppCompatTextView n;
    public final AppCompatTextView o;

    private t(ConstraintLayout constraintLayout, Barrier barrier, View view, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, View view2, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6) {
        this.a = constraintLayout;
        this.b = barrier;
        this.c = view;
        this.d = appCompatImageView;
        this.e = shapeableImageView;
        this.f = view2;
        this.g = appCompatImageView2;
        this.h = appCompatImageView3;
        this.i = linearLayout;
        this.j = appCompatTextView;
        this.k = appCompatTextView2;
        this.l = appCompatTextView3;
        this.m = appCompatTextView4;
        this.n = appCompatTextView5;
        this.o = appCompatTextView6;
    }

    public static t a(View view) {
        View a;
        AppCompatImageView a2;
        ShapeableImageView a3;
        View a4;
        AppCompatImageView a5;
        AppCompatImageView a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        AppCompatTextView a9;
        AppCompatTextView a10;
        AppCompatTextView a11;
        AppCompatTextView a12;
        int i = R$id.barrierMovieCoverBottom;
        Barrier a13 = f4.b.a(view, i);
        if (a13 != null && (a = f4.b.a(view, (i = R$id.ivCoverZoom))) != null && (a2 = f4.b.a(view, (i = R$id.ivMovieContent))) != null && (a3 = f4.b.a(view, (i = R$id.ivMovieCover))) != null && (a4 = f4.b.a(view, (i = R$id.ivMovieCoverMask))) != null && (a5 = f4.b.a(view, (i = R$id.iv_score))) != null && (a6 = f4.b.a(view, (i = R$id.iv_subtitle_tag))) != null) {
            i = R$id.ll_score;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null && (a7 = f4.b.a(view, (i = R$id.tvMovieContent))) != null && (a8 = f4.b.a(view, (i = R$id.tvMovieTitle))) != null && (a9 = f4.b.a(view, (i = R$id.tv_score))) != null && (a10 = f4.b.a(view, (i = R$id.tv_subtitle_more))) != null && (a11 = f4.b.a(view, (i = R$id.tv_subtitle_tag))) != null && (a12 = f4.b.a(view, (i = R$id.tv_time))) != null) {
                return new t((ConstraintLayout) view, a13, a, a2, a3, a4, a5, a6, linearLayout, a7, a8, a9, a10, a11, a12);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static t c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static t d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subject_movie_header, viewGroup, false);
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
