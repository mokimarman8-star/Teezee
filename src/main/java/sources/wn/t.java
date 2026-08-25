package wn;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Barrier;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.tn.lib.view.expand.ExpandView;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.baseui.widget.NestedScrollableHost;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.view.ClipLoading;
import com.transsion.postdetail.ui.view.VideoProgressDragGestureView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class t implements f4.a {
    public final GradientTextView A;
    public final AppCompatTextView B;
    public final AppCompatTextView C;
    public final AppCompatTextView D;
    public final AppCompatTextView E;
    public final BLTextView F;
    public final AppCompatTextView G;
    public final BLView H;
    public final View I;
    public final VideoProgressDragGestureView J;
    private final View a;
    public final Barrier b;
    public final BLView c;
    public final BLConstraintLayout d;
    public final ClipLoading e;
    public final ShapeableImageView f;
    public final ExpandView g;
    public final FrameLayout h;
    public final AppCompatImageView i;
    public final AppCompatImageView j;
    public final ShapeableImageView k;
    public final AppCompatImageView l;
    public final AppCompatImageView m;
    public final AppCompatImageView n;
    public final AppCompatImageView o;
    public final ShapeableImageView p;
    public final ShapeableImageView q;
    public final z r;
    public final LinearLayout s;
    public final NestedScrollableHost t;
    public final ProgressBar u;
    public final Space v;
    public final AppCompatSeekBar w;
    public final AppCompatTextView x;
    public final AppCompatTextView y;
    public final AppCompatTextView z;

    private t(View view, Barrier barrier, BLView bLView, BLConstraintLayout bLConstraintLayout, ClipLoading clipLoading, ShapeableImageView shapeableImageView, ExpandView expandView, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ShapeableImageView shapeableImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, AppCompatImageView appCompatImageView6, ShapeableImageView shapeableImageView3, ShapeableImageView shapeableImageView4, z zVar, LinearLayout linearLayout, NestedScrollableHost nestedScrollableHost, ProgressBar progressBar, Space space, AppCompatSeekBar appCompatSeekBar, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, GradientTextView gradientTextView, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, BLTextView bLTextView, AppCompatTextView appCompatTextView8, BLView bLView2, View view2, VideoProgressDragGestureView videoProgressDragGestureView) {
        this.a = view;
        this.b = barrier;
        this.c = bLView;
        this.d = bLConstraintLayout;
        this.e = clipLoading;
        this.f = shapeableImageView;
        this.g = expandView;
        this.h = frameLayout;
        this.i = appCompatImageView;
        this.j = appCompatImageView2;
        this.k = shapeableImageView2;
        this.l = appCompatImageView3;
        this.m = appCompatImageView4;
        this.n = appCompatImageView5;
        this.o = appCompatImageView6;
        this.p = shapeableImageView3;
        this.q = shapeableImageView4;
        this.r = zVar;
        this.s = linearLayout;
        this.t = nestedScrollableHost;
        this.u = progressBar;
        this.v = space;
        this.w = appCompatSeekBar;
        this.x = appCompatTextView;
        this.y = appCompatTextView2;
        this.z = appCompatTextView3;
        this.A = gradientTextView;
        this.B = appCompatTextView4;
        this.C = appCompatTextView5;
        this.D = appCompatTextView6;
        this.E = appCompatTextView7;
        this.F = bLTextView;
        this.G = appCompatTextView8;
        this.H = bLView2;
        this.I = view2;
        this.J = videoProgressDragGestureView;
    }

    public static t a(View view) {
        BLView a;
        BLConstraintLayout a2;
        ShapeableImageView a3;
        ExpandView a4;
        AppCompatImageView a5;
        AppCompatImageView a6;
        ShapeableImageView a7;
        AppCompatImageView a8;
        AppCompatImageView a9;
        AppCompatImageView a10;
        AppCompatImageView a11;
        ShapeableImageView a12;
        ShapeableImageView a13;
        View a14;
        AppCompatSeekBar a15;
        AppCompatTextView a16;
        AppCompatTextView a17;
        AppCompatTextView a18;
        AppCompatTextView a19;
        AppCompatTextView a20;
        AppCompatTextView a21;
        AppCompatTextView a22;
        BLTextView a23;
        AppCompatTextView a24;
        BLView a25;
        View a26;
        int i = R$id.barrier;
        Barrier a27 = f4.b.a(view, i);
        if (a27 != null && (a = f4.b.a(view, (i = R$id.bottom_background))) != null && (a2 = f4.b.a(view, (i = R$id.clHotComment))) != null) {
            i = R$id.cl_loading;
            ClipLoading clipLoading = (ClipLoading) f4.b.a(view, i);
            if (clipLoading != null && (a3 = f4.b.a(view, (i = R$id.commentCover))) != null && (a4 = f4.b.a(view, (i = R$id.ev_post_des))) != null) {
                i = R$id.fl_container;
                FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                if (frameLayout != null && (a5 = f4.b.a(view, (i = R$id.iv_cover))) != null && (a6 = f4.b.a(view, (i = R$id.iv_download))) != null && (a7 = f4.b.a(view, (i = R$id.ivHotCommentAvatar))) != null && (a8 = f4.b.a(view, (i = R$id.ivHotCommentIcon))) != null && (a9 = f4.b.a(view, (i = R$id.ivHotLike))) != null && (a10 = f4.b.a(view, (i = R$id.iv_pause))) != null && (a11 = f4.b.a(view, (i = R$id.iv_save))) != null && (a12 = f4.b.a(view, (i = R$id.iv_short_cover))) != null && (a13 = f4.b.a(view, (i = R$id.iv_video_avatar))) != null && (a14 = f4.b.a(view, (i = R$id.layout_subject_room))) != null) {
                    z a28 = z.a(a14);
                    i = R$id.llOperationLayout;
                    LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                    if (linearLayout != null) {
                        i = R$id.nsPostDes;
                        NestedScrollableHost nestedScrollableHost = (NestedScrollableHost) f4.b.a(view, i);
                        if (nestedScrollableHost != null) {
                            i = R$id.progress_bar;
                            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                            if (progressBar != null) {
                                i = R$id.progress_guideline;
                                Space space = (Space) f4.b.a(view, i);
                                if (space != null && (a15 = f4.b.a(view, (i = R$id.seek_bar))) != null && (a16 = f4.b.a(view, (i = R$id.tv_comment))) != null && (a17 = f4.b.a(view, (i = R$id.tv_favorite))) != null && (a18 = f4.b.a(view, (i = R$id.tvHotCommentContent))) != null) {
                                    i = R$id.tvHotCommentTitle;
                                    GradientTextView gradientTextView = (GradientTextView) f4.b.a(view, i);
                                    if (gradientTextView != null && (a19 = f4.b.a(view, (i = R$id.tvHotLikeCount))) != null && (a20 = f4.b.a(view, (i = R$id.tv_like))) != null && (a21 = f4.b.a(view, (i = R$id.tv_progress_des))) != null && (a22 = f4.b.a(view, (i = R$id.tv_share))) != null && (a23 = f4.b.a(view, (i = R$id.tvShortTvEp))) != null && (a24 = f4.b.a(view, (i = R$id.tvTitle))) != null && (a25 = f4.b.a(view, (i = R$id.up_background))) != null && (a26 = f4.b.a(view, (i = R$id.vHotLike))) != null) {
                                        i = R$id.v_progress_gesture;
                                        VideoProgressDragGestureView videoProgressDragGestureView = (VideoProgressDragGestureView) f4.b.a(view, i);
                                        if (videoProgressDragGestureView != null) {
                                            return new t(view, a27, a, a2, clipLoading, a3, a4, frameLayout, a5, a6, a7, a8, a9, a10, a11, a12, a13, a28, linearLayout, nestedScrollableHost, progressBar, space, a15, a16, a17, a18, gradientTextView, a19, a20, a21, a22, a23, a24, a25, a26, videoProgressDragGestureView);
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
