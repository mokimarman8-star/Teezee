package iu;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.baseui.widget.NestedScrollableHost;
import com.transsion.shorttv.ui.widget.ShortTvVideoProgressDragGestureView;
import com.transsion.ugcvideodetail.R$id;
import com.transsion.ugcvideodetail.widget.UGCImmRingLoadingView;
import com.transsion.ugcvideodetail.widget.expand.UGCImmExpandView;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class r implements f4.a {
    public final AppCompatTextView A;
    public final AppCompatTextView B;
    public final AppCompatTextView C;
    public final AppCompatTextView D;
    public final TextView E;
    public final BLTextView F;
    public final TextView G;
    public final AppCompatTextView H;
    public final BLView I;
    public final FrameLayout J;
    public final UGCImmRingLoadingView K;
    public final ShortTvVideoProgressDragGestureView L;
    public final SimpleSubtitleView M;
    private final View a;
    public final BLView b;
    public final UGCImmExpandView c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final FrameLayout g;
    public final View h;
    public final Group i;
    public final AppCompatImageView j;
    public final AppCompatImageView k;
    public final AppCompatImageView l;
    public final AppCompatImageView m;
    public final AppCompatImageView n;
    public final AppCompatTextView o;
    public final AppCompatImageView p;
    public final ShapeableImageView q;
    public final ConstraintLayout r;
    public final FrameLayout s;
    public final NestedScrollableHost t;
    public final ProgressBar u;
    public final SecondariesSeekBar v;
    public final Space w;
    public final RecyclerView x;
    public final SecondariesSeekBar y;
    public final AppCompatTextView z;

    private r(View view, BLView bLView, UGCImmExpandView uGCImmExpandView, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, View view2, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView6, ShapeableImageView shapeableImageView, ConstraintLayout constraintLayout, FrameLayout frameLayout5, NestedScrollableHost nestedScrollableHost, ProgressBar progressBar, SecondariesSeekBar secondariesSeekBar, Space space, RecyclerView recyclerView, SecondariesSeekBar secondariesSeekBar2, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, TextView textView, BLTextView bLTextView, TextView textView2, AppCompatTextView appCompatTextView7, BLView bLView2, FrameLayout frameLayout6, UGCImmRingLoadingView uGCImmRingLoadingView, ShortTvVideoProgressDragGestureView shortTvVideoProgressDragGestureView, SimpleSubtitleView simpleSubtitleView) {
        this.a = view;
        this.b = bLView;
        this.c = uGCImmExpandView;
        this.d = frameLayout;
        this.e = frameLayout2;
        this.f = frameLayout3;
        this.g = frameLayout4;
        this.h = view2;
        this.i = group;
        this.j = appCompatImageView;
        this.k = appCompatImageView2;
        this.l = appCompatImageView3;
        this.m = appCompatImageView4;
        this.n = appCompatImageView5;
        this.o = appCompatTextView;
        this.p = appCompatImageView6;
        this.q = shapeableImageView;
        this.r = constraintLayout;
        this.s = frameLayout5;
        this.t = nestedScrollableHost;
        this.u = progressBar;
        this.v = secondariesSeekBar;
        this.w = space;
        this.x = recyclerView;
        this.y = secondariesSeekBar2;
        this.z = appCompatTextView2;
        this.A = appCompatTextView3;
        this.B = appCompatTextView4;
        this.C = appCompatTextView5;
        this.D = appCompatTextView6;
        this.E = textView;
        this.F = bLTextView;
        this.G = textView2;
        this.H = appCompatTextView7;
        this.I = bLView2;
        this.J = frameLayout6;
        this.K = uGCImmRingLoadingView;
        this.L = shortTvVideoProgressDragGestureView;
        this.M = simpleSubtitleView;
    }

    public static r a(View view) {
        View a;
        Group a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        AppCompatImageView a6;
        AppCompatImageView a7;
        AppCompatTextView a8;
        AppCompatImageView a9;
        ShapeableImageView a10;
        ConstraintLayout a11;
        NestedScrollableHost a12;
        SecondariesSeekBar a13;
        RecyclerView a14;
        SecondariesSeekBar a15;
        AppCompatTextView a16;
        AppCompatTextView a17;
        AppCompatTextView a18;
        AppCompatTextView a19;
        AppCompatTextView a20;
        BLTextView a21;
        AppCompatTextView a22;
        BLView a23;
        SimpleSubtitleView a24;
        int i = R$id.bottomUgcImmBackground;
        BLView a25 = f4.b.a(view, i);
        if (a25 != null) {
            i = R$id.evUgcImmPostDes;
            UGCImmExpandView uGCImmExpandView = (UGCImmExpandView) f4.b.a(view, i);
            if (uGCImmExpandView != null) {
                i = R$id.flUgcImmContainer;
                FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                if (frameLayout != null) {
                    i = R$id.flUgcImmDownload;
                    FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                    if (frameLayout2 != null) {
                        i = R$id.flUgcImmSubscribe;
                        FrameLayout frameLayout3 = (FrameLayout) f4.b.a(view, i);
                        if (frameLayout3 != null) {
                            i = R$id.flUgcImmSubtitle;
                            FrameLayout frameLayout4 = (FrameLayout) f4.b.a(view, i);
                            if (frameLayout4 != null && (a = f4.b.a(view, (i = R$id.groupUgcImmContentBg))) != null && (a2 = f4.b.a(view, (i = R$id.groupUgcImmControl))) != null && (a3 = f4.b.a(view, (i = R$id.ivUgcImmCover))) != null && (a4 = f4.b.a(view, (i = R$id.ivUgcImmDownload))) != null && (a5 = f4.b.a(view, (i = R$id.ivUgcImmEp))) != null && (a6 = f4.b.a(view, (i = R$id.ivUgcImmEpTitleIc))) != null && (a7 = f4.b.a(view, (i = R$id.ivUgcImmPlayStatus))) != null && (a8 = f4.b.a(view, (i = R$id.ivUgcImmShare))) != null && (a9 = f4.b.a(view, (i = R$id.ivUgcImmSubscribe))) != null && (a10 = f4.b.a(view, (i = R$id.ivUgcImmUserCover))) != null && (a11 = f4.b.a(view, (i = R$id.layoutUgcImmTvEpisode))) != null) {
                                i = R$id.layoutUgcImmTvSearch;
                                FrameLayout frameLayout5 = (FrameLayout) f4.b.a(view, i);
                                if (frameLayout5 != null && (a12 = f4.b.a(view, (i = R$id.nsUgcImmPostDes))) != null) {
                                    i = R$id.pbUgcImmSubscribeLoading;
                                    ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                                    if (progressBar != null && (a13 = f4.b.a(view, (i = R$id.progressUgcImmBar))) != null) {
                                        i = R$id.progressUgcImmGuideline;
                                        Space space = (Space) f4.b.a(view, i);
                                        if (space != null && (a14 = f4.b.a(view, (i = R$id.rvUgcImmTags))) != null && (a15 = f4.b.a(view, (i = R$id.seekUgcImmBar))) != null && (a16 = f4.b.a(view, (i = R$id.tvUgcImmComment))) != null && (a17 = f4.b.a(view, (i = R$id.tvUgcImmEp))) != null && (a18 = f4.b.a(view, (i = R$id.tvUgcImmEpTitle))) != null && (a19 = f4.b.a(view, (i = R$id.tvUgcImmFavorite))) != null && (a20 = f4.b.a(view, (i = R$id.tvUgcImmLike))) != null) {
                                            i = R$id.tvUgcImmProgressDes;
                                            TextView textView = (TextView) f4.b.a(view, i);
                                            if (textView != null && (a21 = f4.b.a(view, (i = R$id.tvUgcImmTopSpeed))) != null) {
                                                i = R$id.tvUgcImmTvSearch;
                                                TextView textView2 = (TextView) f4.b.a(view, i);
                                                if (textView2 != null && (a22 = f4.b.a(view, (i = R$id.tvUgcImmUserName))) != null && (a23 = f4.b.a(view, (i = R$id.upUgcImmBackground))) != null) {
                                                    i = R$id.vTopStatus;
                                                    FrameLayout frameLayout6 = (FrameLayout) f4.b.a(view, i);
                                                    if (frameLayout6 != null) {
                                                        i = R$id.vUgcImmDownloadLoading;
                                                        UGCImmRingLoadingView uGCImmRingLoadingView = (UGCImmRingLoadingView) f4.b.a(view, i);
                                                        if (uGCImmRingLoadingView != null) {
                                                            i = R$id.vUgcImmProgressGesture;
                                                            ShortTvVideoProgressDragGestureView shortTvVideoProgressDragGestureView = (ShortTvVideoProgressDragGestureView) f4.b.a(view, i);
                                                            if (shortTvVideoProgressDragGestureView != null && (a24 = f4.b.a(view, (i = R$id.vUgcImmSubtitle))) != null) {
                                                                return new r(view, a25, uGCImmExpandView, frameLayout, frameLayout2, frameLayout3, frameLayout4, a, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, frameLayout5, a12, progressBar, a13, space, a14, a15, a16, a17, a18, a19, a20, textView, a21, textView2, a22, a23, frameLayout6, uGCImmRingLoadingView, shortTvVideoProgressDragGestureView, a24);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
