package lm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.InfoExtendView;
import com.transsion.moviedetail.view.MovieDetailShareView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements f4.a {
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final CoordinatorLayout c;
    public final InfoExtendView d;
    public final AppCompatImageView e;
    public final ShapeableImageView f;
    public final AppCompatImageView g;
    public final MovieDetailShareView h;
    public final AppCompatImageView i;
    public final AppCompatImageView j;
    public final RecyclerView k;
    public final Space l;
    public final Toolbar m;
    public final CollapsingToolbarLayout n;
    public final TextView o;
    public final AppCompatTextView p;
    public final AppCompatTextView q;
    public final AppCompatTextView r;

    private c(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout, InfoExtendView infoExtendView, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView2, MovieDetailShareView movieDetailShareView, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, RecyclerView recyclerView, Space space, Toolbar toolbar, CollapsingToolbarLayout collapsingToolbarLayout, TextView textView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = coordinatorLayout;
        this.d = infoExtendView;
        this.e = appCompatImageView;
        this.f = shapeableImageView;
        this.g = appCompatImageView2;
        this.h = movieDetailShareView;
        this.i = appCompatImageView3;
        this.j = appCompatImageView4;
        this.k = recyclerView;
        this.l = space;
        this.m = toolbar;
        this.n = collapsingToolbarLayout;
        this.o = textView;
        this.p = appCompatTextView;
        this.q = appCompatTextView2;
        this.r = appCompatTextView3;
    }

    public static c a(View view) {
        CoordinatorLayout a;
        AppCompatImageView a2;
        ShapeableImageView a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        AppCompatImageView a6;
        RecyclerView a7;
        Toolbar a8;
        CollapsingToolbarLayout a9;
        AppCompatTextView a10;
        AppCompatTextView a11;
        AppCompatTextView a12;
        int i = R$id.appBar;
        AppBarLayout a13 = f4.b.a(view, i);
        if (a13 != null && (a = f4.b.a(view, (i = R$id.cdl))) != null) {
            i = R$id.infoExtendView;
            InfoExtendView infoExtendView = (InfoExtendView) f4.b.a(view, i);
            if (infoExtendView != null && (a2 = f4.b.a(view, (i = R$id.ivBack))) != null && (a3 = f4.b.a(view, (i = R$id.ivCoverSmall))) != null && (a4 = f4.b.a(view, (i = R$id.ivDownload))) != null) {
                i = R$id.ivShare;
                MovieDetailShareView movieDetailShareView = (MovieDetailShareView) f4.b.a(view, i);
                if (movieDetailShareView != null && (a5 = f4.b.a(view, (i = R$id.iv_staff))) != null && (a6 = f4.b.a(view, (i = R$id.iv_want_see))) != null && (a7 = f4.b.a(view, (i = R$id.rv))) != null) {
                    i = R$id.f14sp;
                    Space space = (Space) f4.b.a(view, i);
                    if (space != null && (a8 = f4.b.a(view, (i = R$id.toolbar))) != null && (a9 = f4.b.a(view, (i = R$id.toolbar_layout))) != null) {
                        i = R$id.tv_filmography;
                        TextView textView = (TextView) f4.b.a(view, i);
                        if (textView != null && (a10 = f4.b.a(view, (i = R$id.tv_staff_desc))) != null && (a11 = f4.b.a(view, (i = R$id.tv_staff_name))) != null && (a12 = f4.b.a(view, (i = R$id.tvTitle))) != null) {
                            return new c((ConstraintLayout) view, a13, a, infoExtendView, a2, a3, a4, movieDetailShareView, a5, a6, a7, space, a8, a9, textView, a10, a11, a12);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_movie_staff, viewGroup, false);
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
