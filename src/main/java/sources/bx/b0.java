package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.noober.background.view.BLFrameLayout;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b0 implements f4.a {
    private final FrameLayout a;
    public final LinearLayoutCompat b;
    public final CoordinatorLayout c;
    public final BLFrameLayout d;
    public final FrameLayout e;
    public final AppCompatImageView f;
    public final AppCompatImageView g;
    public final ImageView h;
    public final View i;
    public final LinearLayout j;
    public final ProgressBar k;
    public final ProgressBar l;
    public final TabLayout m;
    public final AppCompatTextView n;
    public final AppCompatTextView o;
    public final AppCompatTextView p;
    public final AppCompatTextView q;
    public final AppCompatTextView r;
    public final AppCompatTextView s;
    public final View t;
    public final View u;
    public final ProgressBar v;
    public final ViewPager2 w;

    private b0(FrameLayout frameLayout, LinearLayoutCompat linearLayoutCompat, CoordinatorLayout coordinatorLayout, BLFrameLayout bLFrameLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ImageView imageView, View view, LinearLayout linearLayout, ProgressBar progressBar, ProgressBar progressBar2, TabLayout tabLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, View view2, View view3, ProgressBar progressBar3, ViewPager2 viewPager2) {
        this.a = frameLayout;
        this.b = linearLayoutCompat;
        this.c = coordinatorLayout;
        this.d = bLFrameLayout;
        this.e = frameLayout2;
        this.f = appCompatImageView;
        this.g = appCompatImageView2;
        this.h = imageView;
        this.i = view;
        this.j = linearLayout;
        this.k = progressBar;
        this.l = progressBar2;
        this.m = tabLayout;
        this.n = appCompatTextView;
        this.o = appCompatTextView2;
        this.p = appCompatTextView3;
        this.q = appCompatTextView4;
        this.r = appCompatTextView5;
        this.s = appCompatTextView6;
        this.t = view2;
        this.u = view3;
        this.v = progressBar3;
        this.w = viewPager2;
    }

    public static b0 a(View view) {
        CoordinatorLayout a;
        BLFrameLayout a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        View a5;
        TabLayout a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        AppCompatTextView a9;
        AppCompatTextView a10;
        AppCompatTextView a11;
        AppCompatTextView a12;
        View a13;
        View a14;
        ViewPager2 a15;
        int i = R.id.btn_download;
        LinearLayoutCompat a16 = f4.b.a(view, i);
        if (a16 != null && (a = f4.b.a(view, (i = R.id.cl_root))) != null && (a2 = f4.b.a(view, (i = R.id.fl_loading))) != null) {
            i = R.id.fl_select_all_bg;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null && (a3 = f4.b.a(view, (i = R.id.iv_btn_download_icon))) != null && (a4 = f4.b.a(view, (i = R.id.iv_check))) != null) {
                i = R.id.iv_close;
                ImageView imageView = (ImageView) f4.b.a(view, i);
                if (imageView != null && (a5 = f4.b.a(view, (i = R.id.line))) != null) {
                    i = R.id.ll_not_net;
                    LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                    if (linearLayout != null) {
                        i = R.id.progress_bar_btn_download;
                        ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                        if (progressBar != null) {
                            i = R.id.progress_bar_select_all;
                            ProgressBar progressBar2 = (ProgressBar) f4.b.a(view, i);
                            if (progressBar2 != null && (a6 = f4.b.a(view, (i = R.id.subjectTab))) != null && (a7 = f4.b.a(view, (i = R.id.tv_btn_download))) != null && (a8 = f4.b.a(view, (i = R.id.tv_no_network_content))) != null && (a9 = f4.b.a(view, (i = R.id.tv_retry))) != null && (a10 = f4.b.a(view, (i = R.id.tv_select_all))) != null && (a11 = f4.b.a(view, (i = R.id.tv_tips))) != null && (a12 = f4.b.a(view, (i = R.id.tv_title))) != null && (a13 = f4.b.a(view, (i = R.id.v_bottom))) != null && (a14 = f4.b.a(view, (i = R.id.v_content_gap))) != null) {
                                i = R.id.view_load;
                                ProgressBar progressBar3 = (ProgressBar) f4.b.a(view, i);
                                if (progressBar3 != null && (a15 = f4.b.a(view, (i = R.id.vp_content))) != null) {
                                    return new b0((FrameLayout) view, a16, a, a2, frameLayout, a3, a4, imageView, a5, linearLayout, progressBar, progressBar2, a6, a7, a8, a9, a10, a11, a12, a13, a14, progressBar3, a15);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static b0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_download_res_multi, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
