package bx;

import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLFrameLayout;
import com.tn.lib.view.CircleProgressBar;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class z0 implements f4.a {
    private final ConstraintLayout a;
    public final BLFrameLayout b;
    public final ImageView c;
    public final AppCompatImageView d;
    public final View e;
    public final CircleProgressBar f;
    public final RecyclerView g;
    public final AppCompatTextView h;
    public final AppCompatTextView i;
    public final AppCompatTextView j;
    public final AppCompatTextView k;
    public final View l;
    public final View m;

    private z0(ConstraintLayout constraintLayout, BLFrameLayout bLFrameLayout, ImageView imageView, AppCompatImageView appCompatImageView, View view, CircleProgressBar circleProgressBar, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, View view2, View view3) {
        this.a = constraintLayout;
        this.b = bLFrameLayout;
        this.c = imageView;
        this.d = appCompatImageView;
        this.e = view;
        this.f = circleProgressBar;
        this.g = recyclerView;
        this.h = appCompatTextView;
        this.i = appCompatTextView2;
        this.j = appCompatTextView3;
        this.k = appCompatTextView4;
        this.l = view2;
        this.m = view3;
    }

    public static z0 a(View view) {
        AppCompatImageView a;
        View a2;
        CircleProgressBar a3;
        RecyclerView a4;
        AppCompatTextView a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        View a9;
        View a10;
        int i = R.id.fl_loading;
        BLFrameLayout a11 = f4.b.a(view, i);
        if (a11 != null) {
            i = R.id.iv_close;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null && (a = f4.b.a(view, (i = R.id.iv_save_close))) != null && (a2 = f4.b.a(view, (i = R.id.line))) != null && (a3 = f4.b.a(view, (i = R.id.progress_bar))) != null && (a4 = f4.b.a(view, (i = R.id.recycler_view))) != null && (a5 = f4.b.a(view, (i = R.id.tv_btn_confirm))) != null && (a6 = f4.b.a(view, (i = R.id.tv_progress))) != null && (a7 = f4.b.a(view, (i = R.id.tv_tips))) != null && (a8 = f4.b.a(view, (i = R.id.tv_title))) != null && (a9 = f4.b.a(view, (i = R.id.v_bottom))) != null && (a10 = f4.b.a(view, (i = R.id.v_loading_intercept))) != null) {
                return new z0((ConstraintLayout) view, a11, imageView, a, a2, a3, a4, a5, a6, a7, a8, a9, a10);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
