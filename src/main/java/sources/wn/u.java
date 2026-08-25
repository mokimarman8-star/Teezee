package wn;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.view.ImmScaleView;
import com.transsion.postdetail.ui.view.ImmSpeedView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class u implements f4.a {
    public final TextView A;
    public final TextView B;
    public final View C;
    public final View D;
    public final View E;
    public final SimpleSubtitleView F;
    public final SimpleSubtitleView G;
    public final k0 H;
    public final ConstraintLayout I;
    public final AppCompatTextView J;
    public final AppCompatImageView K;
    public final Group L;
    public final AppCompatImageView M;
    public final SecondariesSeekBar N;
    public final AppCompatTextView O;
    public final TextView P;
    public final TextView Q;
    public final FrameLayout R;
    public final ViewStub S;
    public final ViewStub T;
    public final ViewStub U;
    public final ViewStub V;
    private final ConstraintLayout a;
    public final jj.e b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final LinearLayoutCompat e;
    public final ShapeableImageView f;
    public final AppCompatImageView g;
    public final AppCompatTextView h;
    public final ImmScaleView i;
    public final FrameLayout j;
    public final AppCompatTextView k;
    public final ConstraintLayout l;
    public final View m;
    public final View n;
    public final tn.a o;
    public final jt.j p;
    public final LinearLayout q;
    public final FrameLayout r;
    public final TextView s;
    public final AppCompatTextView t;
    public final AppCompatTextView u;
    public final TextView v;
    public final ImmSpeedView w;
    public final AppCompatTextView x;
    public final AppCompatTextView y;
    public final AppCompatTextView z;

    private u(ConstraintLayout constraintLayout, jj.e eVar, FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayoutCompat linearLayoutCompat, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, ImmScaleView immScaleView, FrameLayout frameLayout3, AppCompatTextView appCompatTextView2, ConstraintLayout constraintLayout2, View view, View view2, tn.a aVar, jt.j jVar, LinearLayout linearLayout, FrameLayout frameLayout4, TextView textView, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, TextView textView2, ImmSpeedView immSpeedView, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, AppCompatTextView appCompatTextView7, TextView textView3, TextView textView4, View view3, View view4, View view5, SimpleSubtitleView simpleSubtitleView, SimpleSubtitleView simpleSubtitleView2, k0 k0Var, ConstraintLayout constraintLayout3, AppCompatTextView appCompatTextView8, AppCompatImageView appCompatImageView2, Group group, AppCompatImageView appCompatImageView3, SecondariesSeekBar secondariesSeekBar, AppCompatTextView appCompatTextView9, TextView textView5, TextView textView6, FrameLayout frameLayout5, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3, ViewStub viewStub4) {
        this.a = constraintLayout;
        this.b = eVar;
        this.c = frameLayout;
        this.d = frameLayout2;
        this.e = linearLayoutCompat;
        this.f = shapeableImageView;
        this.g = appCompatImageView;
        this.h = appCompatTextView;
        this.i = immScaleView;
        this.j = frameLayout3;
        this.k = appCompatTextView2;
        this.l = constraintLayout2;
        this.m = view;
        this.n = view2;
        this.o = aVar;
        this.p = jVar;
        this.q = linearLayout;
        this.r = frameLayout4;
        this.s = textView;
        this.t = appCompatTextView3;
        this.u = appCompatTextView4;
        this.v = textView2;
        this.w = immSpeedView;
        this.x = appCompatTextView5;
        this.y = appCompatTextView6;
        this.z = appCompatTextView7;
        this.A = textView3;
        this.B = textView4;
        this.C = view3;
        this.D = view4;
        this.E = view5;
        this.F = simpleSubtitleView;
        this.G = simpleSubtitleView2;
        this.H = k0Var;
        this.I = constraintLayout3;
        this.J = appCompatTextView8;
        this.K = appCompatImageView2;
        this.L = group;
        this.M = appCompatImageView3;
        this.N = secondariesSeekBar;
        this.O = appCompatTextView9;
        this.P = textView5;
        this.Q = textView6;
        this.R = frameLayout5;
        this.S = viewStub;
        this.T = viewStub2;
        this.U = viewStub3;
        this.V = viewStub4;
    }

    public static u a(View view) {
        LinearLayoutCompat a;
        ShapeableImageView a2;
        AppCompatImageView a3;
        AppCompatTextView a4;
        AppCompatTextView a5;
        View a6;
        View a7;
        AppCompatTextView a8;
        AppCompatTextView a9;
        AppCompatTextView a10;
        AppCompatTextView a11;
        AppCompatTextView a12;
        View a13;
        View a14;
        View a15;
        SimpleSubtitleView a16;
        SimpleSubtitleView a17;
        View a18;
        AppCompatTextView a19;
        AppCompatImageView a20;
        Group a21;
        AppCompatImageView a22;
        SecondariesSeekBar a23;
        AppCompatTextView a24;
        int i = R$id.centerControlLayout;
        View a25 = f4.b.a(view, i);
        if (a25 != null) {
            jj.e a26 = jj.e.a(a25);
            i = R$id.flPlaying10AdGroup;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R$id.flRootSubtitle;
                FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                if (frameLayout2 != null && (a = f4.b.a(view, (i = R$id.flSubtitle))) != null && (a2 = f4.b.a(view, (i = R$id.iv_brand_ad_logo))) != null && (a3 = f4.b.a(view, (i = R$id.iv_feedback))) != null && (a4 = f4.b.a(view, (i = R$id.iv_lock))) != null) {
                    i = R$id.iv_play_scale;
                    ImmScaleView immScaleView = (ImmScaleView) f4.b.a(view, i);
                    if (immScaleView != null) {
                        i = R$id.land_phone_bar;
                        FrameLayout frameLayout3 = (FrameLayout) f4.b.a(view, i);
                        if (frameLayout3 != null && (a5 = f4.b.a(view, (i = R$id.land_phone_time))) != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            i = R$id.land_view1;
                            View a27 = f4.b.a(view, i);
                            if (a27 != null && (a6 = f4.b.a(view, (i = R$id.land_view2))) != null && (a7 = f4.b.a(view, (i = R$id.layout_bv))) != null) {
                                tn.a a28 = tn.a.a(a7);
                                i = R$id.layout_sync_adjust;
                                View a29 = f4.b.a(view, i);
                                if (a29 != null) {
                                    jt.j a30 = jt.j.a(a29);
                                    i = R$id.ll_play_scale;
                                    LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                                    if (linearLayout != null) {
                                        i = R$id.sub_pop_container;
                                        FrameLayout frameLayout4 = (FrameLayout) f4.b.a(view, i);
                                        if (frameLayout4 != null) {
                                            i = R$id.tvHelpTip;
                                            TextView textView = (TextView) f4.b.a(view, i);
                                            if (textView != null && (a8 = f4.b.a(view, (i = R$id.tv_language))) != null && (a9 = f4.b.a(view, (i = R$id.tvPlayNext))) != null) {
                                                i = R$id.tv_play_scale;
                                                TextView textView2 = (TextView) f4.b.a(view, i);
                                                if (textView2 != null) {
                                                    i = R$id.tvPlaySpeed;
                                                    ImmSpeedView immSpeedView = (ImmSpeedView) f4.b.a(view, i);
                                                    if (immSpeedView != null && (a10 = f4.b.a(view, (i = R$id.tvPressSpeed))) != null && (a11 = f4.b.a(view, (i = R$id.tvRotate))) != null && (a12 = f4.b.a(view, (i = R$id.tvSubtitleSetting))) != null) {
                                                        i = R$id.tv_toast_1;
                                                        TextView textView3 = (TextView) f4.b.a(view, i);
                                                        if (textView3 != null) {
                                                            i = R$id.tv_toast_2;
                                                            TextView textView4 = (TextView) f4.b.a(view, i);
                                                            if (textView4 != null && (a13 = f4.b.a(view, (i = R$id.v_gesture))) != null && (a14 = f4.b.a(view, (i = R$id.v_space_end))) != null && (a15 = f4.b.a(view, (i = R$id.v_space_start))) != null && (a16 = f4.b.a(view, (i = R$id.vSubtitleBottom))) != null && (a17 = f4.b.a(view, (i = R$id.vSubtitleTop))) != null && (a18 = f4.b.a(view, (i = R$id.vd_include_load))) != null) {
                                                                k0 a31 = k0.a(a18);
                                                                i = R$id.vd_land_bottom_controller;
                                                                ConstraintLayout a32 = f4.b.a(view, i);
                                                                if (a32 != null && (a19 = f4.b.a(view, (i = R$id.vd_land_center_progress))) != null && (a20 = f4.b.a(view, (i = R$id.vd_land_iv_back))) != null && (a21 = f4.b.a(view, (i = R$id.vd_land_toolbar))) != null && (a22 = f4.b.a(view, (i = R$id.vd_pause))) != null && (a23 = f4.b.a(view, (i = R$id.vd_seekbar))) != null && (a24 = f4.b.a(view, (i = R$id.vd_title))) != null) {
                                                                    i = R$id.vd_video_duration;
                                                                    TextView textView5 = (TextView) f4.b.a(view, i);
                                                                    if (textView5 != null) {
                                                                        i = R$id.vd_video_time;
                                                                        TextView textView6 = (TextView) f4.b.a(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R$id.video_land_surface;
                                                                            FrameLayout frameLayout5 = (FrameLayout) f4.b.a(view, i);
                                                                            if (frameLayout5 != null) {
                                                                                i = R$id.vs_forward;
                                                                                ViewStub viewStub = (ViewStub) f4.b.a(view, i);
                                                                                if (viewStub != null) {
                                                                                    i = R$id.vs_forward_guide;
                                                                                    ViewStub viewStub2 = (ViewStub) f4.b.a(view, i);
                                                                                    if (viewStub2 != null) {
                                                                                        i = R$id.vs_load_failed;
                                                                                        ViewStub viewStub3 = (ViewStub) f4.b.a(view, i);
                                                                                        if (viewStub3 != null) {
                                                                                            i = R$id.vs_replay;
                                                                                            ViewStub viewStub4 = (ViewStub) f4.b.a(view, i);
                                                                                            if (viewStub4 != null) {
                                                                                                return new u(constraintLayout, a26, frameLayout, frameLayout2, a, a2, a3, a4, immScaleView, frameLayout3, a5, constraintLayout, a27, a6, a28, a30, linearLayout, frameLayout4, textView, a8, a9, textView2, immSpeedView, a10, a11, a12, textView3, textView4, a13, a14, a15, a16, a17, a31, a32, a19, a20, a21, a22, a23, a24, textView5, textView6, frameLayout5, viewStub, viewStub2, viewStub3, viewStub4);
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

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
