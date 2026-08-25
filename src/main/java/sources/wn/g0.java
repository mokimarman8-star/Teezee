package wn;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.view.ClipLoading;
import com.transsion.postdetail.ui.view.VideoProgressDragGestureView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g0 implements f4.a {
    private final View a;
    public final BLView b;
    public final ClipLoading c;
    public final FrameLayout d;
    public final Group e;
    public final AppCompatImageView f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    public final AppCompatImageView i;
    public final ShapeableImageView j;
    public final ShapeableImageView k;
    public final LinearLayout l;
    public final ProgressBar m;
    public final Space n;
    public final AppCompatSeekBar o;
    public final AppCompatTextView p;
    public final AppCompatTextView q;
    public final AppCompatTextView r;
    public final AppCompatTextView s;
    public final AppCompatTextView t;
    public final BLTextView u;
    public final AppCompatTextView v;
    public final BLView w;
    public final VideoProgressDragGestureView x;

    private g0(View view, BLView bLView, ClipLoading clipLoading, FrameLayout frameLayout, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, LinearLayout linearLayout, ProgressBar progressBar, Space space, AppCompatSeekBar appCompatSeekBar, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, BLTextView bLTextView, AppCompatTextView appCompatTextView6, BLView bLView2, VideoProgressDragGestureView videoProgressDragGestureView) {
        this.a = view;
        this.b = bLView;
        this.c = clipLoading;
        this.d = frameLayout;
        this.e = group;
        this.f = appCompatImageView;
        this.g = appCompatImageView2;
        this.h = appCompatImageView3;
        this.i = appCompatImageView4;
        this.j = shapeableImageView;
        this.k = shapeableImageView2;
        this.l = linearLayout;
        this.m = progressBar;
        this.n = space;
        this.o = appCompatSeekBar;
        this.p = appCompatTextView;
        this.q = appCompatTextView2;
        this.r = appCompatTextView3;
        this.s = appCompatTextView4;
        this.t = appCompatTextView5;
        this.u = bLTextView;
        this.v = appCompatTextView6;
        this.w = bLView2;
        this.x = videoProgressDragGestureView;
    }

    public static g0 a(View view) {
        Group a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        ShapeableImageView a6;
        ShapeableImageView a7;
        AppCompatSeekBar a8;
        AppCompatTextView a9;
        AppCompatTextView a10;
        AppCompatTextView a11;
        AppCompatTextView a12;
        AppCompatTextView a13;
        BLTextView a14;
        AppCompatTextView a15;
        BLView a16;
        int i = R$id.bottom_background;
        BLView a17 = f4.b.a(view, i);
        if (a17 != null) {
            i = R$id.cl_loading;
            ClipLoading clipLoading = (ClipLoading) f4.b.a(view, i);
            if (clipLoading != null) {
                i = R$id.fl_container;
                FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                if (frameLayout != null && (a = f4.b.a(view, (i = R$id.group_content))) != null && (a2 = f4.b.a(view, (i = R$id.iv_cover))) != null && (a3 = f4.b.a(view, (i = R$id.iv_download))) != null && (a4 = f4.b.a(view, (i = R$id.iv_pause))) != null && (a5 = f4.b.a(view, (i = R$id.iv_share))) != null && (a6 = f4.b.a(view, (i = R$id.iv_short_cover))) != null && (a7 = f4.b.a(view, (i = R$id.iv_video_avatar))) != null) {
                    i = R$id.llOperationLayout;
                    LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                    if (linearLayout != null) {
                        i = R$id.progress_bar;
                        ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                        if (progressBar != null) {
                            i = R$id.progress_guideline;
                            Space space = (Space) f4.b.a(view, i);
                            if (space != null && (a8 = f4.b.a(view, (i = R$id.seek_bar))) != null && (a9 = f4.b.a(view, (i = R$id.tv_comment))) != null && (a10 = f4.b.a(view, (i = R$id.tv_desc))) != null && (a11 = f4.b.a(view, (i = R$id.tv_favorite))) != null && (a12 = f4.b.a(view, (i = R$id.tv_like))) != null && (a13 = f4.b.a(view, (i = R$id.tv_progress_des))) != null && (a14 = f4.b.a(view, (i = R$id.tv_short_tv_ep))) != null && (a15 = f4.b.a(view, (i = R$id.tv_title))) != null && (a16 = f4.b.a(view, (i = R$id.up_background))) != null) {
                                i = R$id.v_progress_gesture;
                                VideoProgressDragGestureView videoProgressDragGestureView = (VideoProgressDragGestureView) f4.b.a(view, i);
                                if (videoProgressDragGestureView != null) {
                                    return new g0(view, a17, clipLoading, frameLayout, a, a2, a3, a4, a5, a6, a7, linearLayout, progressBar, space, a8, a9, a10, a11, a12, a13, a14, a15, a16, videoProgressDragGestureView);
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
