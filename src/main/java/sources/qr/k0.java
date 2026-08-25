package qr;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.transsion.shorttv.R;
import com.transsion.shorttv.ad.playeroverlayad.ShortTvPlayerOverlayAdContainer;
import com.transsion.shorttv.base.widget.NestedScrollableHost;
import com.transsion.shorttv.base.widget.TnTextView;
import com.transsion.shorttv.base.widget.expand.ExpandView;
import com.transsion.shorttv.ui.widget.ShortTvVideoProgressDragGestureView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k0 implements f4.a {
    public final AppCompatTextView A;
    public final AppCompatTextView B;
    public final AppCompatTextView C;
    public final AppCompatTextView D;
    public final AppCompatTextView E;
    public final AppCompatTextView F;
    public final TnTextView G;
    public final BLTextView H;
    public final BLView I;
    public final ShortTvVideoProgressDragGestureView J;
    public final SimpleSubtitleView K;
    public final ViewStub L;
    public final ViewStub M;
    private final View a;
    public final ShortTvPlayerOverlayAdContainer b;
    public final BLView c;
    public final ExpandView d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final Group g;
    public final Group h;
    public final Group i;
    public final AppCompatImageView j;
    public final AppCompatImageView k;
    public final AppCompatImageView l;
    public final AppCompatImageView m;
    public final AppCompatImageView n;
    public final ShapeableImageView o;
    public final LinearLayout p;
    public final LinearLayout q;
    public final NestedScrollableHost r;
    public final ProgressBar s;
    public final Space t;
    public final AppCompatSeekBar u;
    public final ConstraintLayout v;
    public final AppCompatTextView w;
    public final AppCompatTextView x;
    public final AppCompatTextView y;
    public final AppCompatTextView z;

    private k0(View view, ShortTvPlayerOverlayAdContainer shortTvPlayerOverlayAdContainer, BLView bLView, ExpandView expandView, FrameLayout frameLayout, FrameLayout frameLayout2, Group group, Group group2, Group group3, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, ShapeableImageView shapeableImageView, LinearLayout linearLayout, LinearLayout linearLayout2, NestedScrollableHost nestedScrollableHost, ProgressBar progressBar, Space space, AppCompatSeekBar appCompatSeekBar, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, AppCompatTextView appCompatTextView9, AppCompatTextView appCompatTextView10, TnTextView tnTextView, BLTextView bLTextView, BLView bLView2, ShortTvVideoProgressDragGestureView shortTvVideoProgressDragGestureView, SimpleSubtitleView simpleSubtitleView, ViewStub viewStub, ViewStub viewStub2) {
        this.a = view;
        this.b = shortTvPlayerOverlayAdContainer;
        this.c = bLView;
        this.d = expandView;
        this.e = frameLayout;
        this.f = frameLayout2;
        this.g = group;
        this.h = group2;
        this.i = group3;
        this.j = appCompatImageView;
        this.k = appCompatImageView2;
        this.l = appCompatImageView3;
        this.m = appCompatImageView4;
        this.n = appCompatImageView5;
        this.o = shapeableImageView;
        this.p = linearLayout;
        this.q = linearLayout2;
        this.r = nestedScrollableHost;
        this.s = progressBar;
        this.t = space;
        this.u = appCompatSeekBar;
        this.v = constraintLayout;
        this.w = appCompatTextView;
        this.x = appCompatTextView2;
        this.y = appCompatTextView3;
        this.z = appCompatTextView4;
        this.A = appCompatTextView5;
        this.B = appCompatTextView6;
        this.C = appCompatTextView7;
        this.D = appCompatTextView8;
        this.E = appCompatTextView9;
        this.F = appCompatTextView10;
        this.G = tnTextView;
        this.H = bLTextView;
        this.I = bLView2;
        this.J = shortTvVideoProgressDragGestureView;
        this.K = simpleSubtitleView;
        this.L = viewStub;
        this.M = viewStub2;
    }

    public static k0 a(View view) {
        BLView a;
        Group a2;
        Group a3;
        Group a4;
        AppCompatImageView a5;
        AppCompatImageView a6;
        AppCompatImageView a7;
        AppCompatImageView a8;
        AppCompatImageView a9;
        ShapeableImageView a10;
        AppCompatSeekBar a11;
        ConstraintLayout a12;
        AppCompatTextView a13;
        AppCompatTextView a14;
        AppCompatTextView a15;
        AppCompatTextView a16;
        AppCompatTextView a17;
        AppCompatTextView a18;
        AppCompatTextView a19;
        AppCompatTextView a20;
        AppCompatTextView a21;
        AppCompatTextView a22;
        BLTextView a23;
        BLView a24;
        ShortTvVideoProgressDragGestureView a25;
        SimpleSubtitleView a26;
        int i = R.id.ad_overlay_container_view;
        ShortTvPlayerOverlayAdContainer shortTvPlayerOverlayAdContainer = (ShortTvPlayerOverlayAdContainer) f4.b.a(view, i);
        if (shortTvPlayerOverlayAdContainer != null && (a = f4.b.a(view, (i = R.id.bottom_background))) != null) {
            i = R.id.ev_post_des;
            ExpandView expandView = (ExpandView) f4.b.a(view, i);
            if (expandView != null) {
                i = R.id.fl_container;
                FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                if (frameLayout != null) {
                    i = R.id.flSubtitle;
                    FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                    if (frameLayout2 != null && (a2 = f4.b.a(view, (i = R.id.fm_group_content))) != null && (a3 = f4.b.a(view, (i = R.id.group_content))) != null && (a4 = f4.b.a(view, (i = R.id.group_pay_lock_hide))) != null && (a5 = f4.b.a(view, (i = R.id.iv_back))) != null && (a6 = f4.b.a(view, (i = R.id.iv_cover))) != null && (a7 = f4.b.a(view, (i = R.id.iv_download))) != null && (a8 = f4.b.a(view, (i = R.id.iv_play_status))) != null && (a9 = f4.b.a(view, (i = R.id.iv_share))) != null && (a10 = f4.b.a(view, (i = R.id.iv_short_cover))) != null) {
                        i = R.id.ll_ctr;
                        LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                        if (linearLayout != null) {
                            i = R.id.ll_download_guide_bubble;
                            LinearLayout linearLayout2 = (LinearLayout) f4.b.a(view, i);
                            if (linearLayout2 != null) {
                                i = R.id.ns_post_des;
                                NestedScrollableHost nestedScrollableHost = (NestedScrollableHost) f4.b.a(view, i);
                                if (nestedScrollableHost != null) {
                                    i = R.id.progress_bar;
                                    ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                                    if (progressBar != null) {
                                        i = R.id.progress_guideline;
                                        Space space = (Space) f4.b.a(view, i);
                                        if (space != null && (a11 = f4.b.a(view, (i = R.id.seek_bar))) != null && (a12 = f4.b.a(view, (i = R.id.tool_bar))) != null && (a13 = f4.b.a(view, (i = R.id.tv_audio))) != null && (a14 = f4.b.a(view, (i = R.id.tv_download_guide_text))) != null && (a15 = f4.b.a(view, (i = R.id.tv_episode))) != null && (a16 = f4.b.a(view, (i = R.id.tv_favorite))) != null && (a17 = f4.b.a(view, (i = R.id.tv_language))) != null && (a18 = f4.b.a(view, (i = R.id.tv_name))) != null && (a19 = f4.b.a(view, (i = R.id.tv_progress_des))) != null && (a20 = f4.b.a(view, (i = R.id.tv_resolution))) != null && (a21 = f4.b.a(view, (i = R.id.tv_speed))) != null && (a22 = f4.b.a(view, (i = R.id.tv_subtitles))) != null) {
                                            i = R.id.tv_title;
                                            TnTextView tnTextView = (TnTextView) f4.b.a(view, i);
                                            if (tnTextView != null && (a23 = f4.b.a(view, (i = R.id.tv_watch_free_countdown))) != null && (a24 = f4.b.a(view, (i = R.id.up_background))) != null && (a25 = f4.b.a(view, (i = R.id.v_progress_gesture))) != null && (a26 = f4.b.a(view, (i = R.id.vSubtitle))) != null) {
                                                i = R.id.vs_locked;
                                                ViewStub viewStub = (ViewStub) f4.b.a(view, i);
                                                if (viewStub != null) {
                                                    i = R.id.vs_unlock;
                                                    ViewStub viewStub2 = (ViewStub) f4.b.a(view, i);
                                                    if (viewStub2 != null) {
                                                        return new k0(view, shortTvPlayerOverlayAdContainer, a, expandView, frameLayout, frameLayout2, a2, a3, a4, a5, a6, a7, a8, a9, a10, linearLayout, linearLayout2, nestedScrollableHost, progressBar, space, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, tnTextView, a23, a24, a25, a26, viewStub, viewStub2);
                                                    }
                                                }
                                            }
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

    public View getRoot() {
        return this.a;
    }
}
