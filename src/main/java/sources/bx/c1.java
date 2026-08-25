package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLFrameLayout;
import com.noober.background.view.BLLinearLayout;
import com.transsion.wrapperad.view.DownloadMovieAdView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class c1 implements f4.a {
    public final ProgressBar A;
    private final FrameLayout a;
    public final ConstraintLayout b;
    public final LinearLayoutCompat c;
    public final BLLinearLayout d;
    public final BLConstraintLayout e;
    public final View f;
    public final View g;
    public final BLFrameLayout h;
    public final AppCompatImageView i;
    public final AppCompatImageView j;
    public final ImageView k;
    public final ImageView l;
    public final ImageView m;
    public final LinearLayout n;
    public final ProgressBar o;
    public final RecyclerView p;
    public final RecyclerView q;
    public final AppCompatTextView r;
    public final AppCompatTextView s;
    public final TextView t;
    public final AppCompatTextView u;
    public final AppCompatTextView v;
    public final AppCompatTextView w;
    public final AppCompatTextView x;
    public final View y;
    public final DownloadMovieAdView z;

    private c1(FrameLayout frameLayout, ConstraintLayout constraintLayout, LinearLayoutCompat linearLayoutCompat, BLLinearLayout bLLinearLayout, BLConstraintLayout bLConstraintLayout, View view, View view2, BLFrameLayout bLFrameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, ProgressBar progressBar, RecyclerView recyclerView, RecyclerView recyclerView2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, View view3, DownloadMovieAdView downloadMovieAdView, ProgressBar progressBar2) {
        this.a = frameLayout;
        this.b = constraintLayout;
        this.c = linearLayoutCompat;
        this.d = bLLinearLayout;
        this.e = bLConstraintLayout;
        this.f = view;
        this.g = view2;
        this.h = bLFrameLayout;
        this.i = appCompatImageView;
        this.j = appCompatImageView2;
        this.k = imageView;
        this.l = imageView2;
        this.m = imageView3;
        this.n = linearLayout;
        this.o = progressBar;
        this.p = recyclerView;
        this.q = recyclerView2;
        this.r = appCompatTextView;
        this.s = appCompatTextView2;
        this.t = textView;
        this.u = appCompatTextView3;
        this.v = appCompatTextView4;
        this.w = appCompatTextView5;
        this.x = appCompatTextView6;
        this.y = view3;
        this.z = downloadMovieAdView;
        this.A = progressBar2;
    }

    public static c1 a(View view) {
        LinearLayoutCompat a;
        BLLinearLayout a2;
        BLConstraintLayout a3;
        View a4;
        View a5;
        BLFrameLayout a6;
        AppCompatImageView a7;
        AppCompatImageView a8;
        RecyclerView a9;
        RecyclerView a10;
        AppCompatTextView a11;
        AppCompatTextView a12;
        AppCompatTextView a13;
        AppCompatTextView a14;
        AppCompatTextView a15;
        AppCompatTextView a16;
        View a17;
        int i = R.id.bottomBar;
        ConstraintLayout a18 = f4.b.a(view, i);
        if (a18 != null && (a = f4.b.a(view, (i = R.id.btnDownload))) != null && (a2 = f4.b.a(view, (i = R.id.btnResolution))) != null && (a3 = f4.b.a(view, (i = R.id.clContent))) != null && (a4 = f4.b.a(view, (i = R.id.dividerLine))) != null && (a5 = f4.b.a(view, (i = R.id.dividerLine1))) != null && (a6 = f4.b.a(view, (i = R.id.flLoading))) != null && (a7 = f4.b.a(view, (i = R.id.ivBtnDownloadIcon))) != null && (a8 = f4.b.a(view, (i = R.id.ivCheck))) != null) {
            i = R.id.ivClose;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null) {
                i = R.id.ivResolutionArrow;
                ImageView imageView2 = (ImageView) f4.b.a(view, i);
                if (imageView2 != null) {
                    i = R.id.ivResolutionIcon;
                    ImageView imageView3 = (ImageView) f4.b.a(view, i);
                    if (imageView3 != null) {
                        i = R.id.llNotNet;
                        LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                        if (linearLayout != null) {
                            i = R.id.progressBarBtnDownload;
                            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                            if (progressBar != null && (a9 = f4.b.a(view, (i = R.id.recyclerView))) != null && (a10 = f4.b.a(view, (i = R.id.rvTabs))) != null && (a11 = f4.b.a(view, (i = R.id.tvBtnDownload))) != null && (a12 = f4.b.a(view, (i = R.id.tv_no_network_content))) != null) {
                                i = R.id.tvResolution;
                                TextView textView = (TextView) f4.b.a(view, i);
                                if (textView != null && (a13 = f4.b.a(view, (i = R.id.tv_retry))) != null && (a14 = f4.b.a(view, (i = R.id.tvSelectAll))) != null && (a15 = f4.b.a(view, (i = R.id.tv_tips))) != null && (a16 = f4.b.a(view, (i = R.id.tvTitle))) != null && (a17 = f4.b.a(view, (i = R.id.vContentGap))) != null) {
                                    i = R.id.viewAd;
                                    DownloadMovieAdView downloadMovieAdView = (DownloadMovieAdView) f4.b.a(view, i);
                                    if (downloadMovieAdView != null) {
                                        i = R.id.view_load;
                                        ProgressBar progressBar2 = (ProgressBar) f4.b.a(view, i);
                                        if (progressBar2 != null) {
                                            return new c1((FrameLayout) view, a18, a, a2, a3, a4, a5, a6, a7, a8, imageView, imageView2, imageView3, linearLayout, progressBar, a9, a10, a11, a12, textView, a13, a14, a15, a16, a17, downloadMovieAdView, progressBar2);
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

    public static c1 c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.ugc_dialog_download_page, viewGroup, false);
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
