package lm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLTextView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.WatchModeTipsView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;
    public final AppCompatTextView e;
    public final BLTextView f;
    public final FrameLayout g;
    public final LinearLayout h;
    public final ProgressBar i;
    public final WatchModeTipsView j;
    public final RecyclerView k;
    public final BLTextView l;
    public final BLTextView m;

    private m(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, BLTextView bLTextView, FrameLayout frameLayout, LinearLayout linearLayout, ProgressBar progressBar, WatchModeTipsView watchModeTipsView, RecyclerView recyclerView, BLTextView bLTextView2, BLTextView bLTextView3) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
        this.e = appCompatTextView3;
        this.f = bLTextView;
        this.g = frameLayout;
        this.h = linearLayout;
        this.i = progressBar;
        this.j = watchModeTipsView;
        this.k = recyclerView;
        this.l = bLTextView2;
        this.m = bLTextView3;
    }

    public static m a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        BLTextView a4;
        RecyclerView a5;
        BLTextView a6;
        BLTextView a7;
        int i = R$id.innerIcon;
        AppCompatImageView a8 = f4.b.a(view, i);
        if (a8 != null && (a = f4.b.a(view, (i = R$id.innerTvInfo))) != null && (a2 = f4.b.a(view, (i = R$id.innerTvName))) != null && (a3 = f4.b.a(view, (i = R$id.innerTvTitle))) != null && (a4 = f4.b.a(view, (i = R$id.iv_seasons))) != null) {
            i = R$id.lf_loading;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R$id.llLanguage;
                LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                if (linearLayout != null) {
                    i = R$id.load_view;
                    ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                    if (progressBar != null) {
                        i = R$id.modeTipsLayout;
                        WatchModeTipsView watchModeTipsView = (WatchModeTipsView) f4.b.a(view, i);
                        if (watchModeTipsView != null && (a5 = f4.b.a(view, (i = R$id.resourceRv))) != null && (a6 = f4.b.a(view, (i = R$id.tvLanguage))) != null && (a7 = f4.b.a(view, (i = R$id.tv_more))) != null) {
                            return new m((ConstraintLayout) view, a8, a, a2, a3, a4, frameLayout, linearLayout, progressBar, watchModeTipsView, a5, a6, a7);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static m c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static m d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_resource_detector_layout, viewGroup, false);
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
