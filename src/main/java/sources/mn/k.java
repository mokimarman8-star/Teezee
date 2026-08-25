package mn;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.member.LongVodResolutionMemberTipView;
import com.transsion.postdetail.ui.view.ImmScaleView;
import com.transsion.postdetail.ui.view.ImmSpeedView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k implements f4.a {
    public final ImmSpeedView A;
    public final View B;
    public final View C;
    public final FrameLayout D;
    public final TextView E;
    public final ViewStub F;
    public final ViewStub G;
    private final ConstraintLayout a;
    public final AppCompatImageView b;
    public final jj.e c;
    public final ConstraintLayout d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final FrameLayout g;
    public final Group h;
    public final ShapeableImageView i;
    public final AppCompatImageView j;
    public final AppCompatImageView k;
    public final AppCompatTextView l;
    public final AppCompatImageView m;
    public final ImmScaleView n;
    public final View o;
    public final View p;
    public final LinearLayout q;
    public final LongVodResolutionMemberTipView r;
    public final f s;
    public final SecondariesSeekBar t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final AppCompatTextView x;
    public final AppCompatTextView y;
    public final TextView z;

    private k(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, jj.e eVar, ConstraintLayout constraintLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, Group group, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView4, ImmScaleView immScaleView, View view, View view2, LinearLayout linearLayout, LongVodResolutionMemberTipView longVodResolutionMemberTipView, f fVar, SecondariesSeekBar secondariesSeekBar, TextView textView, TextView textView2, TextView textView3, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, TextView textView4, ImmSpeedView immSpeedView, View view3, View view4, FrameLayout frameLayout4, TextView textView5, ViewStub viewStub, ViewStub viewStub2) {
        this.a = constraintLayout;
        this.b = appCompatImageView;
        this.c = eVar;
        this.d = constraintLayout2;
        this.e = frameLayout;
        this.f = frameLayout2;
        this.g = frameLayout3;
        this.h = group;
        this.i = shapeableImageView;
        this.j = appCompatImageView2;
        this.k = appCompatImageView3;
        this.l = appCompatTextView;
        this.m = appCompatImageView4;
        this.n = immScaleView;
        this.o = view;
        this.p = view2;
        this.q = linearLayout;
        this.r = longVodResolutionMemberTipView;
        this.s = fVar;
        this.t = secondariesSeekBar;
        this.u = textView;
        this.v = textView2;
        this.w = textView3;
        this.x = appCompatTextView2;
        this.y = appCompatTextView3;
        this.z = textView4;
        this.A = immSpeedView;
        this.B = view3;
        this.C = view4;
        this.D = frameLayout4;
        this.E = textView5;
        this.F = viewStub;
        this.G = viewStub2;
    }

    public static k a(View view) {
        View a;
        Group a2;
        ShapeableImageView a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        AppCompatTextView a6;
        AppCompatImageView a7;
        View a8;
        View a9;
        View a10;
        AppCompatTextView a11;
        AppCompatTextView a12;
        View a13;
        View a14;
        int i = R$id.ad_close_view;
        AppCompatImageView a15 = f4.b.a(view, i);
        if (a15 != null && (a = f4.b.a(view, (i = R$id.centerControlLayout))) != null) {
            jj.e a16 = jj.e.a(a);
            i = R$id.cl_bottom_control;
            ConstraintLayout a17 = f4.b.a(view, i);
            if (a17 != null) {
                i = R$id.fl_native_ad;
                FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                if (frameLayout != null) {
                    i = R$id.fl_playing_10_ad_group;
                    FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                    if (frameLayout2 != null) {
                        i = R$id.game_container;
                        FrameLayout frameLayout3 = (FrameLayout) f4.b.a(view, i);
                        if (frameLayout3 != null && (a2 = f4.b.a(view, (i = R$id.group_control_pk))) != null && (a3 = f4.b.a(view, (i = R$id.iv_brand_ad_logo))) != null && (a4 = f4.b.a(view, (i = R$id.iv_game_close))) != null && (a5 = f4.b.a(view, (i = R$id.iv_land_pause))) != null && (a6 = f4.b.a(view, (i = R$id.iv_lock))) != null && (a7 = f4.b.a(view, (i = R$id.iv_play))) != null) {
                            i = R$id.iv_play_scale;
                            ImmScaleView immScaleView = (ImmScaleView) f4.b.a(view, i);
                            if (immScaleView != null && (a8 = f4.b.a(view, (i = R$id.land_gradient_bottom))) != null && (a9 = f4.b.a(view, (i = R$id.land_gradient_top))) != null) {
                                i = R$id.ll_play_scale;
                                LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                                if (linearLayout != null) {
                                    i = R$id.memberTip;
                                    LongVodResolutionMemberTipView longVodResolutionMemberTipView = (LongVodResolutionMemberTipView) f4.b.a(view, i);
                                    if (longVodResolutionMemberTipView != null && (a10 = f4.b.a(view, (i = R$id.operatorLayout))) != null) {
                                        f a18 = f.a(a10);
                                        i = R$id.seek_bar_land;
                                        SecondariesSeekBar a19 = f4.b.a(view, i);
                                        if (a19 != null) {
                                            i = R$id.tv_land_bitrate;
                                            TextView textView = (TextView) f4.b.a(view, i);
                                            if (textView != null) {
                                                i = R$id.tv_land_cur_time;
                                                TextView textView2 = (TextView) f4.b.a(view, i);
                                                if (textView2 != null) {
                                                    i = R$id.tv_land_total_time;
                                                    TextView textView3 = (TextView) f4.b.a(view, i);
                                                    if (textView3 != null && (a11 = f4.b.a(view, (i = R$id.tv_language))) != null && (a12 = f4.b.a(view, (i = R$id.tvPlayNext))) != null) {
                                                        i = R$id.tv_play_scale;
                                                        TextView textView4 = (TextView) f4.b.a(view, i);
                                                        if (textView4 != null) {
                                                            i = R$id.tv_play_speed;
                                                            ImmSpeedView immSpeedView = (ImmSpeedView) f4.b.a(view, i);
                                                            if (immSpeedView != null && (a13 = f4.b.a(view, (i = R$id.v_land_space_end))) != null && (a14 = f4.b.a(view, (i = R$id.v_land_space_start))) != null) {
                                                                i = R$id.v_native_ad;
                                                                FrameLayout frameLayout4 = (FrameLayout) f4.b.a(view, i);
                                                                if (frameLayout4 != null) {
                                                                    i = R$id.v_native_ad_countdown;
                                                                    TextView textView5 = (TextView) f4.b.a(view, i);
                                                                    if (textView5 != null) {
                                                                        i = R$id.vs_forward;
                                                                        ViewStub viewStub = (ViewStub) f4.b.a(view, i);
                                                                        if (viewStub != null) {
                                                                            i = R$id.vs_forward_guide;
                                                                            ViewStub viewStub2 = (ViewStub) f4.b.a(view, i);
                                                                            if (viewStub2 != null) {
                                                                                return new k((ConstraintLayout) view, a15, a16, a17, frameLayout, frameLayout2, frameLayout3, a2, a3, a4, a5, a6, a7, immScaleView, a8, a9, linearLayout, longVodResolutionMemberTipView, a18, a19, textView, textView2, textView3, a11, a12, textView4, immSpeedView, a13, a14, frameLayout4, textView5, viewStub, viewStub2);
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
