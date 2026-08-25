package lm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.CustomTextViewGroup;
import com.transsion.moviedetail.view.InfoExtendView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class p implements f4.a {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final FrameLayout c;
    public final InfoExtendView d;
    public final AppCompatImageView e;
    public final ShapeableImageView f;
    public final View g;
    public final AppCompatImageView h;
    public final LinearLayout i;
    public final AppCompatImageView j;
    public final CustomTextViewGroup k;
    public final LinearLayoutCompat l;
    public final AppCompatTextView m;
    public final CustomTextViewGroup n;
    public final AppCompatTextView o;
    public final AppCompatTextView p;
    public final CustomTextViewGroup q;
    public final CustomTextViewGroup r;
    public final View s;
    public final View t;

    private p(ConstraintLayout constraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, InfoExtendView infoExtendView, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, View view, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, AppCompatImageView appCompatImageView3, CustomTextViewGroup customTextViewGroup, LinearLayoutCompat linearLayoutCompat, AppCompatTextView appCompatTextView, CustomTextViewGroup customTextViewGroup2, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, CustomTextViewGroup customTextViewGroup3, CustomTextViewGroup customTextViewGroup4, View view2, View view3) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = frameLayout2;
        this.d = infoExtendView;
        this.e = appCompatImageView;
        this.f = shapeableImageView;
        this.g = view;
        this.h = appCompatImageView2;
        this.i = linearLayout;
        this.j = appCompatImageView3;
        this.k = customTextViewGroup;
        this.l = linearLayoutCompat;
        this.m = appCompatTextView;
        this.n = customTextViewGroup2;
        this.o = appCompatTextView2;
        this.p = appCompatTextView3;
        this.q = customTextViewGroup3;
        this.r = customTextViewGroup4;
        this.s = view2;
        this.t = view3;
    }

    public static p a(View view) {
        AppCompatImageView a;
        ShapeableImageView a2;
        View a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        LinearLayoutCompat a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        AppCompatTextView a9;
        View a10;
        View a11;
        int i = R$id.fl_starring;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null) {
            i = R$id.game_container;
            FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
            if (frameLayout2 != null) {
                i = R$id.infoExtendView;
                InfoExtendView infoExtendView = (InfoExtendView) f4.b.a(view, i);
                if (infoExtendView != null && (a = f4.b.a(view, (i = R$id.ivMovieContent))) != null && (a2 = f4.b.a(view, (i = R$id.ivMovieCover))) != null && (a3 = f4.b.a(view, (i = R$id.ivMovieCoverMask))) != null && (a4 = f4.b.a(view, (i = R$id.iv_score))) != null) {
                    i = R$id.ll_score;
                    LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                    if (linearLayout != null && (a5 = f4.b.a(view, (i = R$id.tv_close))) != null) {
                        i = R$id.tv_country;
                        CustomTextViewGroup customTextViewGroup = (CustomTextViewGroup) f4.b.a(view, i);
                        if (customTextViewGroup != null && (a6 = f4.b.a(view, (i = R$id.tv_header_toolbar))) != null && (a7 = f4.b.a(view, (i = R$id.tvMovieTitle))) != null) {
                            i = R$id.tv_restrict;
                            CustomTextViewGroup customTextViewGroup2 = (CustomTextViewGroup) f4.b.a(view, i);
                            if (customTextViewGroup2 != null && (a8 = f4.b.a(view, (i = R$id.tv_score))) != null && (a9 = f4.b.a(view, (i = R$id.tv_seasons))) != null) {
                                i = R$id.tv_time;
                                CustomTextViewGroup customTextViewGroup3 = (CustomTextViewGroup) f4.b.a(view, i);
                                if (customTextViewGroup3 != null) {
                                    i = R$id.tv_type;
                                    CustomTextViewGroup customTextViewGroup4 = (CustomTextViewGroup) f4.b.a(view, i);
                                    if (customTextViewGroup4 != null && (a10 = f4.b.a(view, (i = R$id.v_seasons_line))) != null && (a11 = f4.b.a(view, (i = R$id.view_separator))) != null) {
                                        return new p((ConstraintLayout) view, frameLayout, frameLayout2, infoExtendView, a, a2, a3, a4, linearLayout, a5, customTextViewGroup, a6, a7, customTextViewGroup2, a8, a9, customTextViewGroup3, customTextViewGroup4, a10, a11);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static p c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static p d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subject_detail_info_dialog, viewGroup, false);
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
