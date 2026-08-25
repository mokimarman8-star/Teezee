package bx;

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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLView;
import com.transsnet.downloader.R;
import com.transsnet.downloader.widget.DownloadInfoExtendView;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class f0 implements f4.a {
    public final AppCompatTextView A;
    public final AppCompatTextView B;
    public final AppCompatTextView C;
    public final AppCompatTextView D;
    public final View E;
    public final View F;
    public final BLView G;
    public final ProgressBar H;
    private final BLConstraintLayout a;
    public final AppBarLayout b;
    public final View c;
    public final LinearLayoutCompat d;
    public final CoordinatorLayout e;
    public final BLFrameLayout f;
    public final FrameLayout g;
    public final FrameLayout h;
    public final DownloadInfoExtendView i;
    public final AppCompatImageView j;
    public final AppCompatImageView k;
    public final ImageView l;
    public final ShapeableImageView m;
    public final BLImageView n;
    public final BLImageView o;
    public final ProgressBar p;
    public final ProgressBar q;
    public final RecyclerView r;
    public final RecyclerView s;
    public final TabLayout t;
    public final View u;
    public final AppCompatTextView v;
    public final AppCompatTextView w;
    public final TextView x;
    public final AppCompatTextView y;
    public final AppCompatTextView z;

    private f0(BLConstraintLayout bLConstraintLayout, AppBarLayout appBarLayout, View view, LinearLayoutCompat linearLayoutCompat, CoordinatorLayout coordinatorLayout, BLFrameLayout bLFrameLayout, FrameLayout frameLayout, FrameLayout frameLayout2, DownloadInfoExtendView downloadInfoExtendView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ImageView imageView, ShapeableImageView shapeableImageView, BLImageView bLImageView, BLImageView bLImageView2, ProgressBar progressBar, ProgressBar progressBar2, RecyclerView recyclerView, RecyclerView recyclerView2, TabLayout tabLayout, View view2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, View view3, View view4, BLView bLView, ProgressBar progressBar3) {
        this.a = bLConstraintLayout;
        this.b = appBarLayout;
        this.c = view;
        this.d = linearLayoutCompat;
        this.e = coordinatorLayout;
        this.f = bLFrameLayout;
        this.g = frameLayout;
        this.h = frameLayout2;
        this.i = downloadInfoExtendView;
        this.j = appCompatImageView;
        this.k = appCompatImageView2;
        this.l = imageView;
        this.m = shapeableImageView;
        this.n = bLImageView;
        this.o = bLImageView2;
        this.p = progressBar;
        this.q = progressBar2;
        this.r = recyclerView;
        this.s = recyclerView2;
        this.t = tabLayout;
        this.u = view2;
        this.v = appCompatTextView;
        this.w = appCompatTextView2;
        this.x = textView;
        this.y = appCompatTextView3;
        this.z = appCompatTextView4;
        this.A = appCompatTextView5;
        this.B = appCompatTextView6;
        this.C = appCompatTextView7;
        this.D = appCompatTextView8;
        this.E = view3;
        this.F = view4;
        this.G = bLView;
        this.H = progressBar3;
    }

    public static f0 a(View view) {
        View a;
        LinearLayoutCompat a2;
        CoordinatorLayout a3;
        BLFrameLayout a4;
        AppCompatImageView a5;
        AppCompatImageView a6;
        ShapeableImageView a7;
        BLImageView a8;
        BLImageView a9;
        RecyclerView a10;
        RecyclerView a11;
        TabLayout a12;
        View a13;
        AppCompatTextView a14;
        AppCompatTextView a15;
        AppCompatTextView a16;
        AppCompatTextView a17;
        AppCompatTextView a18;
        AppCompatTextView a19;
        AppCompatTextView a20;
        AppCompatTextView a21;
        View a22;
        View a23;
        BLView a24;
        int i = R.id.app_bar_layout;
        AppBarLayout a25 = f4.b.a(view, i);
        if (a25 != null && (a = f4.b.a(view, (i = R.id.bottom_line))) != null && (a2 = f4.b.a(view, (i = R.id.btn_download))) != null && (a3 = f4.b.a(view, (i = R.id.cl_root))) != null && (a4 = f4.b.a(view, (i = R.id.fl_download_loading))) != null) {
            i = R.id.fl_select_all_bg;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R.id.fl_state;
                FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                if (frameLayout2 != null) {
                    i = R.id.iev_info;
                    DownloadInfoExtendView downloadInfoExtendView = (DownloadInfoExtendView) f4.b.a(view, i);
                    if (downloadInfoExtendView != null && (a5 = f4.b.a(view, (i = R.id.iv_btn_download_icon))) != null && (a6 = f4.b.a(view, (i = R.id.iv_check))) != null) {
                        i = R.id.iv_close;
                        ImageView imageView = (ImageView) f4.b.a(view, i);
                        if (imageView != null && (a7 = f4.b.a(view, (i = R.id.iv_cover))) != null && (a8 = f4.b.a(view, (i = R.id.iv_favorite))) != null && (a9 = f4.b.a(view, (i = R.id.iv_share))) != null) {
                            i = R.id.progress_bar_btn_download;
                            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                            if (progressBar != null) {
                                i = R.id.progress_bar_select_all;
                                ProgressBar progressBar2 = (ProgressBar) f4.b.a(view, i);
                                if (progressBar2 != null && (a10 = f4.b.a(view, (i = R.id.recycler_view))) != null && (a11 = f4.b.a(view, (i = R.id.recycler_view_tags))) != null && (a12 = f4.b.a(view, (i = R.id.tab_ep_title))) != null && (a13 = f4.b.a(view, (i = R.id.title_line))) != null && (a14 = f4.b.a(view, (i = R.id.tv_btn_download))) != null && (a15 = f4.b.a(view, (i = R.id.tv_download_ep_count))) != null) {
                                    i = R.id.tv_download_title;
                                    TextView textView = (TextView) f4.b.a(view, i);
                                    if (textView != null && (a16 = f4.b.a(view, (i = R.id.tv_genre))) != null && (a17 = f4.b.a(view, (i = R.id.tv_play_title))) != null && (a18 = f4.b.a(view, (i = R.id.tv_select_all))) != null && (a19 = f4.b.a(view, (i = R.id.tv_tips))) != null && (a20 = f4.b.a(view, (i = R.id.tv_title))) != null && (a21 = f4.b.a(view, (i = R.id.tv_title_2))) != null && (a22 = f4.b.a(view, (i = R.id.v_bottom))) != null && (a23 = f4.b.a(view, (i = R.id.v_content_gap))) != null && (a24 = f4.b.a(view, (i = R.id.v_play))) != null) {
                                        i = R.id.view_load;
                                        ProgressBar progressBar3 = (ProgressBar) f4.b.a(view, i);
                                        if (progressBar3 != null) {
                                            return new f0((BLConstraintLayout) view, a25, a, a2, a3, a4, frameLayout, frameLayout2, downloadInfoExtendView, a5, a6, imageView, a7, a8, a9, progressBar, progressBar2, a10, a11, a12, a13, a14, a15, textView, a16, a17, a18, a19, a20, a21, a22, a23, a24, progressBar3);
                                        }
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

    public static f0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_download_res_short_tv, viewGroup, false);
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
