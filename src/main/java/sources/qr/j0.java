package qr;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLView;
import com.transsion.shorttv.R;
import com.transsion.shorttv_pugc.base.widget.NestedScrollableHost;
import com.transsion.shorttv_pugc.base.widget.TnTextView;
import com.transsion.shorttv_pugc.base.widget.expand.ExpandView;
import com.transsion.shorttv_pugc.ui.widget.ShortTvAdView;
import com.transsion.shorttv_pugc.ui.widget.ShortTvVideoProgressDragGestureView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j0 implements f4.a {
    public final AppCompatTextView A;
    public final AppCompatTextView B;
    public final AppCompatTextView C;
    public final TextView D;
    public final AppCompatTextView E;
    public final AppCompatTextView F;
    public final TnTextView G;
    public final BLView H;
    public final ShortTvVideoProgressDragGestureView I;
    public final SimpleSubtitleView J;
    public final ViewStub K;
    private final View a;
    public final BLView b;
    public final ExpandView c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final Group f;
    public final View g;
    public final AppCompatImageView h;
    public final AppCompatImageView i;
    public final AppCompatImageView j;
    public final AppCompatImageView k;
    public final AppCompatImageView l;
    public final ShapeableImageView m;
    public final AppCompatImageView n;
    public final FrameLayout o;
    public final LinearLayout p;
    public final NestedScrollableHost q;
    public final ProgressBar r;
    public final Space s;
    public final RecyclerView t;
    public final AppCompatSeekBar u;
    public final ShortTvAdView v;
    public final ConstraintLayout w;
    public final AppCompatTextView x;
    public final AppCompatTextView y;
    public final AppCompatTextView z;

    private j0(View view, BLView bLView, ExpandView expandView, FrameLayout frameLayout, FrameLayout frameLayout2, Group group, View view2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView6, FrameLayout frameLayout3, LinearLayout linearLayout, NestedScrollableHost nestedScrollableHost, ProgressBar progressBar, Space space, RecyclerView recyclerView, AppCompatSeekBar appCompatSeekBar, ShortTvAdView shortTvAdView, ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, TextView textView, AppCompatTextView appCompatTextView7, AppCompatTextView appCompatTextView8, TnTextView tnTextView, BLView bLView2, ShortTvVideoProgressDragGestureView shortTvVideoProgressDragGestureView, SimpleSubtitleView simpleSubtitleView, ViewStub viewStub) {
        this.a = view;
        this.b = bLView;
        this.c = expandView;
        this.d = frameLayout;
        this.e = frameLayout2;
        this.f = group;
        this.g = view2;
        this.h = appCompatImageView;
        this.i = appCompatImageView2;
        this.j = appCompatImageView3;
        this.k = appCompatImageView4;
        this.l = appCompatImageView5;
        this.m = shapeableImageView;
        this.n = appCompatImageView6;
        this.o = frameLayout3;
        this.p = linearLayout;
        this.q = nestedScrollableHost;
        this.r = progressBar;
        this.s = space;
        this.t = recyclerView;
        this.u = appCompatSeekBar;
        this.v = shortTvAdView;
        this.w = constraintLayout;
        this.x = appCompatTextView;
        this.y = appCompatTextView2;
        this.z = appCompatTextView3;
        this.A = appCompatTextView4;
        this.B = appCompatTextView5;
        this.C = appCompatTextView6;
        this.D = textView;
        this.E = appCompatTextView7;
        this.F = appCompatTextView8;
        this.G = tnTextView;
        this.H = bLView2;
        this.I = shortTvVideoProgressDragGestureView;
        this.J = simpleSubtitleView;
        this.K = viewStub;
    }

    public static j0 a(View view) {
        ExpandView a;
        Group a2;
        View a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        AppCompatImageView a6;
        AppCompatImageView a7;
        AppCompatImageView a8;
        ShapeableImageView a9;
        AppCompatImageView a10;
        NestedScrollableHost a11;
        RecyclerView a12;
        AppCompatSeekBar a13;
        ShortTvAdView a14;
        ConstraintLayout a15;
        AppCompatTextView a16;
        AppCompatTextView a17;
        AppCompatTextView a18;
        AppCompatTextView a19;
        AppCompatTextView a20;
        AppCompatTextView a21;
        AppCompatTextView a22;
        AppCompatTextView a23;
        TnTextView a24;
        BLView a25;
        ShortTvVideoProgressDragGestureView a26;
        SimpleSubtitleView a27;
        int i = R.id.bottom_background;
        BLView a28 = f4.b.a(view, i);
        if (a28 != null && (a = f4.b.a(view, (i = R.id.ev_post_des))) != null) {
            i = R.id.fl_container;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R.id.flSubtitle;
                FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                if (frameLayout2 != null && (a2 = f4.b.a(view, (i = R.id.group_content))) != null && (a3 = f4.b.a(view, (i = R.id.group_content_bg))) != null && (a4 = f4.b.a(view, (i = R.id.iv_back))) != null && (a5 = f4.b.a(view, (i = R.id.iv_cover))) != null && (a6 = f4.b.a(view, (i = R.id.iv_download))) != null && (a7 = f4.b.a(view, (i = R.id.iv_play_status))) != null && (a8 = f4.b.a(view, (i = R.id.iv_share))) != null && (a9 = f4.b.a(view, (i = R.id.iv_short_cover))) != null && (a10 = f4.b.a(view, (i = R.id.iv_subscribe))) != null) {
                    i = R.id.layout_tv_episode;
                    FrameLayout frameLayout3 = (FrameLayout) f4.b.a(view, i);
                    if (frameLayout3 != null) {
                        i = R.id.ll_ctr;
                        LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                        if (linearLayout != null && (a11 = f4.b.a(view, (i = R.id.ns_post_des))) != null) {
                            i = R.id.progress_bar;
                            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                            if (progressBar != null) {
                                i = R.id.progress_guideline;
                                Space space = (Space) f4.b.a(view, i);
                                if (space != null && (a12 = f4.b.a(view, (i = R.id.rv_tags))) != null && (a13 = f4.b.a(view, (i = R.id.seek_bar))) != null && (a14 = f4.b.a(view, (i = R.id.shortTvAdView))) != null && (a15 = f4.b.a(view, (i = R.id.tool_bar))) != null && (a16 = f4.b.a(view, (i = R.id.tv_comment))) != null && (a17 = f4.b.a(view, (i = R.id.tv_episode))) != null && (a18 = f4.b.a(view, (i = R.id.tv_favorite))) != null && (a19 = f4.b.a(view, (i = R.id.tv_language))) != null && (a20 = f4.b.a(view, (i = R.id.tv_like))) != null && (a21 = f4.b.a(view, (i = R.id.tv_name))) != null) {
                                    i = R.id.tv_progress_des;
                                    TextView textView = (TextView) f4.b.a(view, i);
                                    if (textView != null && (a22 = f4.b.a(view, (i = R.id.tv_resolution))) != null && (a23 = f4.b.a(view, (i = R.id.tv_speed))) != null && (a24 = f4.b.a(view, (i = R.id.tv_title))) != null && (a25 = f4.b.a(view, (i = R.id.up_background))) != null && (a26 = f4.b.a(view, (i = R.id.v_progress_gesture))) != null && (a27 = f4.b.a(view, (i = R.id.vSubtitle))) != null) {
                                        i = R.id.vs_unlock;
                                        ViewStub viewStub = (ViewStub) f4.b.a(view, i);
                                        if (viewStub != null) {
                                            return new j0(view, a28, a, frameLayout, frameLayout2, a2, a3, a4, a5, a6, a7, a8, a9, a10, frameLayout3, linearLayout, a11, progressBar, space, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, textView, a22, a23, a24, a25, a26, a27, viewStub);
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
