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
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.view.LocalVideoMiddleHeaderView;
import com.transsion.publish.view.PublishStateView;
import com.transsion.wrapperad.view.cardpage.NativeCardPageView;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class w implements f4.a {
    public final TextView A;
    public final AppCompatTextView B;
    public final TextView C;
    public final TextView D;
    public final TextView E;
    public final View F;
    public final SimpleSubtitleView G;
    public final SimpleSubtitleView H;
    public final LinearLayout I;
    public final AppCompatTextView J;
    public final AppCompatImageView K;
    public final Group L;
    public final AppCompatImageView M;
    public final AppCompatImageView N;
    public final SecondariesSeekBar O;
    public final LinearLayout P;
    public final TextView Q;
    public final FrameLayout R;
    public final View S;
    public final ViewStub T;
    public final ViewStub U;
    public final ViewStub V;
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final CoordinatorLayout c;
    public final FrameLayout d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final FrameLayout g;
    public final LinearLayoutCompat h;
    public final View i;
    public final AppCompatImageView j;
    public final AppCompatImageView k;
    public final PublishStateView l;
    public final View m;
    public final View n;
    public final tn.a o;
    public final jt.j p;
    public final MagicIndicator q;
    public final ConstraintLayout r;
    public final NativeCardPageView s;
    public final ViewPager2 t;
    public final LocalVideoMiddleHeaderView u;
    public final FrameLayout v;
    public final CollapsingToolbarLayout w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    private w(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, LinearLayoutCompat linearLayoutCompat, View view, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, PublishStateView publishStateView, View view2, View view3, tn.a aVar, jt.j jVar, MagicIndicator magicIndicator, ConstraintLayout constraintLayout2, NativeCardPageView nativeCardPageView, ViewPager2 viewPager2, LocalVideoMiddleHeaderView localVideoMiddleHeaderView, FrameLayout frameLayout5, CollapsingToolbarLayout collapsingToolbarLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, AppCompatTextView appCompatTextView, TextView textView5, TextView textView6, TextView textView7, View view4, SimpleSubtitleView simpleSubtitleView, SimpleSubtitleView simpleSubtitleView2, LinearLayout linearLayout, AppCompatTextView appCompatTextView2, AppCompatImageView appCompatImageView3, Group group, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, SecondariesSeekBar secondariesSeekBar, LinearLayout linearLayout2, TextView textView8, FrameLayout frameLayout6, View view5, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = coordinatorLayout;
        this.d = frameLayout;
        this.e = frameLayout2;
        this.f = frameLayout3;
        this.g = frameLayout4;
        this.h = linearLayoutCompat;
        this.i = view;
        this.j = appCompatImageView;
        this.k = appCompatImageView2;
        this.l = publishStateView;
        this.m = view2;
        this.n = view3;
        this.o = aVar;
        this.p = jVar;
        this.q = magicIndicator;
        this.r = constraintLayout2;
        this.s = nativeCardPageView;
        this.t = viewPager2;
        this.u = localVideoMiddleHeaderView;
        this.v = frameLayout5;
        this.w = collapsingToolbarLayout;
        this.x = textView;
        this.y = textView2;
        this.z = textView3;
        this.A = textView4;
        this.B = appCompatTextView;
        this.C = textView5;
        this.D = textView6;
        this.E = textView7;
        this.F = view4;
        this.G = simpleSubtitleView;
        this.H = simpleSubtitleView2;
        this.I = linearLayout;
        this.J = appCompatTextView2;
        this.K = appCompatImageView3;
        this.L = group;
        this.M = appCompatImageView4;
        this.N = appCompatImageView5;
        this.O = secondariesSeekBar;
        this.P = linearLayout2;
        this.Q = textView8;
        this.R = frameLayout6;
        this.S = view5;
        this.T = viewStub;
        this.U = viewStub2;
        this.V = viewStub3;
    }

    public static w a(View view) {
        CoordinatorLayout a;
        LinearLayoutCompat a2;
        View a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        View a6;
        View a7;
        View a8;
        ViewPager2 a9;
        CollapsingToolbarLayout a10;
        AppCompatTextView a11;
        View a12;
        SimpleSubtitleView a13;
        SimpleSubtitleView a14;
        AppCompatTextView a15;
        AppCompatImageView a16;
        Group a17;
        AppCompatImageView a18;
        AppCompatImageView a19;
        SecondariesSeekBar a20;
        View a21;
        int i = R$id.appBar;
        AppBarLayout a22 = f4.b.a(view, i);
        if (a22 != null && (a = f4.b.a(view, (i = R$id.cdl))) != null) {
            i = R$id.fl_content_loading;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R$id.fl_download_tips;
                FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                if (frameLayout2 != null) {
                    i = R$id.flRootSubtitle;
                    FrameLayout frameLayout3 = (FrameLayout) f4.b.a(view, i);
                    if (frameLayout3 != null) {
                        i = R$id.fl_series_list_container;
                        FrameLayout frameLayout4 = (FrameLayout) f4.b.a(view, i);
                        if (frameLayout4 != null && (a2 = f4.b.a(view, (i = R$id.flSubtitle))) != null && (a3 = f4.b.a(view, (i = R$id.guideline))) != null && (a4 = f4.b.a(view, (i = R$id.iv_feedback))) != null && (a5 = f4.b.a(view, (i = R$id.iv_float))) != null) {
                            i = R$id.ivPublish;
                            PublishStateView publishStateView = (PublishStateView) f4.b.a(view, i);
                            if (publishStateView != null && (a6 = f4.b.a(view, (i = R$id.land_view1))) != null && (a7 = f4.b.a(view, (i = R$id.land_view2))) != null && (a8 = f4.b.a(view, (i = R$id.layout_bv))) != null) {
                                tn.a a23 = tn.a.a(a8);
                                i = R$id.layout_sync_adjust;
                                View a24 = f4.b.a(view, i);
                                if (a24 != null) {
                                    jt.j a25 = jt.j.a(a24);
                                    i = R$id.magic_indicator;
                                    MagicIndicator a26 = f4.b.a(view, i);
                                    if (a26 != null) {
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                        i = R$id.nativeSlideshowView;
                                        NativeCardPageView a27 = f4.b.a(view, i);
                                        if (a27 != null && (a9 = f4.b.a(view, (i = R$id.rec_view_pager))) != null) {
                                            i = R$id.resourceHeaderView;
                                            LocalVideoMiddleHeaderView localVideoMiddleHeaderView = (LocalVideoMiddleHeaderView) f4.b.a(view, i);
                                            if (localVideoMiddleHeaderView != null) {
                                                i = R$id.subjectDetailLayout;
                                                FrameLayout frameLayout5 = (FrameLayout) f4.b.a(view, i);
                                                if (frameLayout5 != null && (a10 = f4.b.a(view, (i = R$id.toolbar_layout))) != null) {
                                                    i = R$id.tv_download_btn;
                                                    TextView textView = (TextView) f4.b.a(view, i);
                                                    if (textView != null) {
                                                        i = R$id.tv_download_tips;
                                                        TextView textView2 = (TextView) f4.b.a(view, i);
                                                        if (textView2 != null) {
                                                            i = R$id.tvHelpTip;
                                                            TextView textView3 = (TextView) f4.b.a(view, i);
                                                            if (textView3 != null) {
                                                                i = R$id.tv_loading;
                                                                TextView textView4 = (TextView) f4.b.a(view, i);
                                                                if (textView4 != null && (a11 = f4.b.a(view, (i = R$id.tvPressSpeed))) != null) {
                                                                    i = R$id.tv_speed;
                                                                    TextView textView5 = (TextView) f4.b.a(view, i);
                                                                    if (textView5 != null) {
                                                                        i = R$id.tv_toast_1;
                                                                        TextView textView6 = (TextView) f4.b.a(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R$id.tv_toast_2;
                                                                            TextView textView7 = (TextView) f4.b.a(view, i);
                                                                            if (textView7 != null && (a12 = f4.b.a(view, (i = R$id.v_gesture))) != null && (a13 = f4.b.a(view, (i = R$id.vSubtitleBottom))) != null && (a14 = f4.b.a(view, (i = R$id.vSubtitleTop))) != null) {
                                                                                i = R$id.vd_land_bottom_controller;
                                                                                LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                                                                                if (linearLayout != null && (a15 = f4.b.a(view, (i = R$id.vd_land_center_progress))) != null && (a16 = f4.b.a(view, (i = R$id.vd_land_iv_back))) != null && (a17 = f4.b.a(view, (i = R$id.vd_land_toolbar))) != null && (a18 = f4.b.a(view, (i = R$id.vd_pause))) != null && (a19 = f4.b.a(view, (i = R$id.vd_screen_change))) != null && (a20 = f4.b.a(view, (i = R$id.vd_seekbar))) != null) {
                                                                                    i = R$id.vd_surface_loading;
                                                                                    LinearLayout linearLayout2 = (LinearLayout) f4.b.a(view, i);
                                                                                    if (linearLayout2 != null) {
                                                                                        i = R$id.vd_video_time;
                                                                                        TextView textView8 = (TextView) f4.b.a(view, i);
                                                                                        if (textView8 != null) {
                                                                                            i = R$id.video_land_surface;
                                                                                            FrameLayout frameLayout6 = (FrameLayout) f4.b.a(view, i);
                                                                                            if (frameLayout6 != null && (a21 = f4.b.a(view, (i = R$id.video_middle_player_bg))) != null) {
                                                                                                i = R$id.vs_forward_middle;
                                                                                                ViewStub viewStub = (ViewStub) f4.b.a(view, i);
                                                                                                if (viewStub != null) {
                                                                                                    i = R$id.vs_load_failed;
                                                                                                    ViewStub viewStub2 = (ViewStub) f4.b.a(view, i);
                                                                                                    if (viewStub2 != null) {
                                                                                                        i = R$id.vs_replay;
                                                                                                        ViewStub viewStub3 = (ViewStub) f4.b.a(view, i);
                                                                                                        if (viewStub3 != null) {
                                                                                                            return new w(constraintLayout, a22, a, frameLayout, frameLayout2, frameLayout3, frameLayout4, a2, a3, a4, a5, publishStateView, a6, a7, a23, a25, a26, constraintLayout, a27, a9, localVideoMiddleHeaderView, frameLayout5, a10, textView, textView2, textView3, textView4, a11, textView5, textView6, textView7, a12, a13, a14, linearLayout, a15, a16, a17, a18, a19, a20, linearLayout2, textView8, frameLayout6, a21, viewStub, viewStub2, viewStub3);
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
