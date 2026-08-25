package xv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g implements f4.a {
    private final ConstraintLayout a;
    public final Barrier b;
    public final AppCompatImageView c;
    public final ShapeableImageView d;
    public final View e;
    public final AppCompatImageView f;
    public final AppCompatImageView g;
    public final LinearLayout h;
    public final LinearLayoutCompat i;
    public final AppCompatTextView j;
    public final AppCompatTextView k;
    public final AppCompatTextView l;
    public final AppCompatTextView m;
    public final AppCompatTextView n;
    public final AppCompatTextView o;

    private g(ConstraintLayout constraintLayout, Barrier barrier, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, View view, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayout linearLayout, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6) {
        this.a = constraintLayout;
        this.b = barrier;
        this.c = appCompatImageView;
        this.d = shapeableImageView;
        this.e = view;
        this.f = appCompatImageView2;
        this.g = appCompatImageView3;
        this.h = linearLayout;
        this.i = linearLayoutCompat;
        this.j = appCompatTextView;
        this.k = appCompatTextView2;
        this.l = appCompatTextView3;
        this.m = appCompatTextView4;
        this.n = appCompatTextView5;
        this.o = appCompatTextView6;
    }

    public static g a(View view) {
        AppCompatImageView a;
        ShapeableImageView a2;
        View a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        LinearLayoutCompat a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        AppCompatTextView a9;
        AppCompatTextView a10;
        AppCompatTextView a11;
        AppCompatTextView a12;
        int i = R$id.barrierMovieCoverBottom;
        Barrier a13 = f4.b.a(view, i);
        if (a13 != null && (a = f4.b.a(view, (i = R$id.ivMovieContent))) != null && (a2 = f4.b.a(view, (i = R$id.ivMovieCover))) != null && (a3 = f4.b.a(view, (i = R$id.ivMovieCoverMask))) != null && (a4 = f4.b.a(view, (i = R$id.iv_score))) != null && (a5 = f4.b.a(view, (i = R$id.iv_subtitle_tag))) != null) {
            i = R$id.ll_score;
            LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
            if (linearLayout != null && (a6 = f4.b.a(view, (i = R$id.tv_header_toolbar))) != null && (a7 = f4.b.a(view, (i = R$id.tvMovieContent))) != null && (a8 = f4.b.a(view, (i = R$id.tvMovieTitle))) != null && (a9 = f4.b.a(view, (i = R$id.tv_score))) != null && (a10 = f4.b.a(view, (i = R$id.tv_subtitle_more))) != null && (a11 = f4.b.a(view, (i = R$id.tv_subtitle_tag))) != null && (a12 = f4.b.a(view, (i = R$id.tv_time))) != null) {
                return new g((ConstraintLayout) view, a13, a, a2, a3, a4, a5, linearLayout, a6, a7, a8, a9, a10, a11, a12);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subject_detail_info, viewGroup, false);
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
