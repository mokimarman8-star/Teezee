package qr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.Group;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLView;
import com.transsion.shorttv.R;
import com.transsion.shorttv.ui.widget.ShortTvDownloadInfoExtendView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class z implements f4.a {
    public final AppCompatTextView A;
    public final AppCompatTextView B;
    public final AppCompatTextView C;
    public final AppCompatTextView D;
    public final AppCompatTextView E;
    public final View F;
    public final View G;
    public final BLView H;
    public final ProgressBar I;
    private final BLConstraintLayout a;
    public final AppBarLayout b;
    public final View c;
    public final LinearLayoutCompat d;
    public final Group e;
    public final CoordinatorLayout f;
    public final BLFrameLayout g;
    public final FrameLayout h;
    public final FrameLayout i;
    public final ShortTvDownloadInfoExtendView j;
    public final AppCompatImageView k;
    public final AppCompatImageView l;
    public final ImageView m;
    public final ShapeableImageView n;
    public final BLImageView o;
    public final BLImageView p;
    public final ProgressBar q;
    public final ProgressBar r;
    public final RecyclerView s;
    public final RecyclerView t;
    public final TabLayout u;
    public final View v;
    public final AppCompatTextView w;
    public final AppCompatTextView x;
    public final TextView y;
    public final AppCompatTextView z;

    private z(BLConstraintLayout bLConstraintLayout, AppBarLayout appBarLayout, View view, LinearLayoutCompat linearLayoutCompat, Group group, CoordinatorLayout coordinatorLayout, BLFrameLayout bLFrameLayout, FrameLayout frameLayout, FrameLayout frameLayout2, ShortTvDownloadInfoExtendView shortTvDownloadInfoExtendView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ImageView imageView, ShapeableImageView shapeableImageView, BLImageView bLImageView, BLImageView bLImageView2, ProgressBar progressBar, ProgressBar progressBar2, RecyclerView recyclerView, RecyclerView recyclerView2, TabLayout tabLayout, View view2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, View view3, View view4, BLView bLView, ProgressBar progressBar3) {
        this.a = bLConstraintLayout;
        this.b = appBarLayout;
        this.c = view;
        this.d = linearLayoutCompat;
        this.e = group;
        this.f = coordinatorLayout;
        this.g = bLFrameLayout;
        this.h = frameLayout;
        this.i = frameLayout2;
        this.j = shortTvDownloadInfoExtendView;
        this.k = appCompatImageView;
        this.l = appCompatImageView2;
        this.m = imageView;
        this.n = shapeableImageView;
        this.o = bLImageView;
        this.p = bLImageView2;
        this.q = progressBar;
        this.r = progressBar2;
        this.s = recyclerView;
        this.t = recyclerView2;
        this.u = tabLayout;
        this.v = view2;
        this.w = appCompatTextView;
        this.x = appCompatTextView2;
        this.y = textView;
        this.z = appCompatTextView3;
        this.A = appCompatTextView4;
        this.B = appCompatTextView5;
        this.C = appCompatTextView6;
        this.D = appCompatTextView7;
        this.E = appCompatTextView8;
        this.F = view3;
        this.G = view4;
        this.H = bLView;
        this.I = progressBar3;
    }

    public static z a(View view) {
        View a;
        LinearLayoutCompat a2;
        Group a3;
        CoordinatorLayout a4;
        BLFrameLayout a5;
        ShortTvDownloadInfoExtendView a6;
        AppCompatImageView a7;
        AppCompatImageView a8;
        ShapeableImageView a9;
        BLImageView a10;
        BLImageView a11;
        RecyclerView a12;
        RecyclerView a13;
        TabLayout a14;
        View a15;
        AppCompatTextView a16;
        AppCompatTextView a17;
        AppCompatTextView a18;
        AppCompatTextView a19;
        AppCompatTextView a20;
        AppCompatTextView a21;
        AppCompatTextView a22;
        AppCompatTextView a23;
        View a24;
        View a25;
        BLView a26;
        int i = R.id.app_bar_layout;
        AppBarLayout a27 = f4.b.a(view, i);
        if (a27 != null && (a = f4.b.a(view, (i = R.id.bottom_line))) != null && (a2 = f4.b.a(view, (i = R.id.btn_download))) != null && (a3 = f4.b.a(view, (i = R.id.btn_group))) != null && (a4 = f4.b.a(view, (i = R.id.cl_root))) != null && (a5 = f4.b.a(view, (i = R.id.fl_download_loading))) != null) {
            i = R.id.fl_select_all_bg;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R.id.fl_state;
                FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                if (frameLayout2 != null && (a6 = f4.b.a(view, (i = R.id.iev_info))) != null && (a7 = f4.b.a(view, (i = R.id.iv_btn_download_icon))) != null && (a8 = f4.b.a(view, (i = R.id.iv_check))) != null) {
                    i = R.id.iv_close;
                    ImageView imageView = (ImageView) f4.b.a(view, i);
                    if (imageView != null && (a9 = f4.b.a(view, (i = R.id.iv_cover))) != null && (a10 = f4.b.a(view, (i = R.id.iv_favorite))) != null && (a11 = f4.b.a(view, (i = R.id.iv_share))) != null) {
                        i = R.id.progress_bar_btn_download;
                        ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                        if (progressBar != null) {
                            i = R.id.progress_bar_select_all;
                            ProgressBar progressBar2 = (ProgressBar) f4.b.a(view, i);
                            if (progressBar2 != null && (a12 = f4.b.a(view, (i = R.id.recycler_view))) != null && (a13 = f4.b.a(view, (i = R.id.recycler_view_tags))) != null && (a14 = f4.b.a(view, (i = R.id.tab_ep_title))) != null && (a15 = f4.b.a(view, (i = R.id.title_line))) != null && (a16 = f4.b.a(view, (i = R.id.tv_btn_download))) != null && (a17 = f4.b.a(view, (i = R.id.tv_download_ep_count))) != null) {
                                i = R.id.tv_download_title;
                                TextView textView = (TextView) f4.b.a(view, i);
                                if (textView != null && (a18 = f4.b.a(view, (i = R.id.tv_genre))) != null && (a19 = f4.b.a(view, (i = R.id.tv_play_title))) != null && (a20 = f4.b.a(view, (i = R.id.tv_select_all))) != null && (a21 = f4.b.a(view, (i = R.id.tv_tips))) != null && (a22 = f4.b.a(view, (i = R.id.tv_title))) != null && (a23 = f4.b.a(view, (i = R.id.tv_title_2))) != null && (a24 = f4.b.a(view, (i = R.id.v_bottom))) != null && (a25 = f4.b.a(view, (i = R.id.v_content_gap))) != null && (a26 = f4.b.a(view, (i = R.id.v_play))) != null) {
                                    i = R.id.view_load;
                                    ProgressBar progressBar3 = (ProgressBar) f4.b.a(view, i);
                                    if (progressBar3 != null) {
                                        return new z((BLConstraintLayout) view, a27, a, a2, a3, a4, a5, frameLayout, frameLayout2, a6, a7, a8, imageView, a9, a10, a11, progressBar, progressBar2, a12, a13, a14, a15, a16, a17, textView, a18, a19, a20, a21, a22, a23, a24, a25, a26, progressBar3);
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

    public static z c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static z d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.short_tv_fragment_download_res, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLConstraintLayout getRoot() {
        return this.a;
    }
}
