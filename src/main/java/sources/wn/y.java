package wn;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.view.ImmSpeedView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class y implements f4.a {
    public final AppCompatTextView A;
    public final TextView B;
    public final TextView C;
    public final FrameLayout D;
    public final ViewStub E;
    public final ViewStub F;
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final LinearLayoutCompat c;
    public final AppCompatImageView d;
    public final View e;
    public final View f;
    public final tn.a g;
    public final jt.j h;
    public final ConstraintLayout i;
    public final TextView j;
    public final AppCompatTextView k;
    public final ImmSpeedView l;
    public final AppCompatTextView m;
    public final AppCompatTextView n;
    public final TextView o;
    public final TextView p;
    public final View q;
    public final SimpleSubtitleView r;
    public final SimpleSubtitleView s;
    public final k0 t;
    public final AppCompatImageView u;
    public final ConstraintLayout v;
    public final AppCompatTextView w;
    public final Group x;
    public final AppCompatImageView y;
    public final SecondariesSeekBar z;

    private y(ConstraintLayout constraintLayout, FrameLayout frameLayout, LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, View view, View view2, tn.a aVar, jt.j jVar, ConstraintLayout constraintLayout2, TextView textView, AppCompatTextView appCompatTextView, ImmSpeedView immSpeedView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, TextView textView2, TextView textView3, View view3, SimpleSubtitleView simpleSubtitleView, SimpleSubtitleView simpleSubtitleView2, k0 k0Var, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout3, AppCompatTextView appCompatTextView4, Group group, AppCompatImageView appCompatImageView3, SecondariesSeekBar secondariesSeekBar, AppCompatTextView appCompatTextView5, TextView textView4, TextView textView5, FrameLayout frameLayout2, ViewStub viewStub, ViewStub viewStub2) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = linearLayoutCompat;
        this.d = appCompatImageView;
        this.e = view;
        this.f = view2;
        this.g = aVar;
        this.h = jVar;
        this.i = constraintLayout2;
        this.j = textView;
        this.k = appCompatTextView;
        this.l = immSpeedView;
        this.m = appCompatTextView2;
        this.n = appCompatTextView3;
        this.o = textView2;
        this.p = textView3;
        this.q = view3;
        this.r = simpleSubtitleView;
        this.s = simpleSubtitleView2;
        this.t = k0Var;
        this.u = appCompatImageView2;
        this.v = constraintLayout3;
        this.w = appCompatTextView4;
        this.x = group;
        this.y = appCompatImageView3;
        this.z = secondariesSeekBar;
        this.A = appCompatTextView5;
        this.B = textView4;
        this.C = textView5;
        this.D = frameLayout2;
        this.E = viewStub;
        this.F = viewStub2;
    }

    public static y a(View view) {
        LinearLayoutCompat a;
        AppCompatImageView a2;
        View a3;
        View a4;
        View a5;
        AppCompatTextView a6;
        AppCompatTextView a7;
        AppCompatTextView a8;
        View a9;
        SimpleSubtitleView a10;
        SimpleSubtitleView a11;
        View a12;
        ConstraintLayout a13;
        AppCompatTextView a14;
        Group a15;
        AppCompatImageView a16;
        SecondariesSeekBar a17;
        AppCompatTextView a18;
        int i = R$id.flRootSubtitle;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null && (a = f4.b.a(view, (i = R$id.flSubtitle))) != null && (a2 = f4.b.a(view, (i = R$id.iv_feedback))) != null && (a3 = f4.b.a(view, (i = R$id.land_view1))) != null && (a4 = f4.b.a(view, (i = R$id.land_view2))) != null && (a5 = f4.b.a(view, (i = R$id.layout_bv))) != null) {
            tn.a a19 = tn.a.a(a5);
            i = R$id.layout_sync_adjust;
            View a20 = f4.b.a(view, i);
            if (a20 != null) {
                jt.j a21 = jt.j.a(a20);
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R$id.tvHelpTip;
                TextView textView = (TextView) f4.b.a(view, i);
                if (textView != null && (a6 = f4.b.a(view, (i = R$id.tv_language))) != null) {
                    i = R$id.tv_play_speed;
                    ImmSpeedView immSpeedView = (ImmSpeedView) f4.b.a(view, i);
                    if (immSpeedView != null && (a7 = f4.b.a(view, (i = R$id.tvPressSpeed))) != null && (a8 = f4.b.a(view, (i = R$id.tvRotate))) != null) {
                        i = R$id.tv_toast_1;
                        TextView textView2 = (TextView) f4.b.a(view, i);
                        if (textView2 != null) {
                            i = R$id.tv_toast_2;
                            TextView textView3 = (TextView) f4.b.a(view, i);
                            if (textView3 != null && (a9 = f4.b.a(view, (i = R$id.v_gesture))) != null && (a10 = f4.b.a(view, (i = R$id.vSubtitleBottom))) != null && (a11 = f4.b.a(view, (i = R$id.vSubtitleTop))) != null && (a12 = f4.b.a(view, (i = R$id.vd_include_load))) != null) {
                                k0 a22 = k0.a(a12);
                                i = R$id.vd_iv_back;
                                AppCompatImageView a23 = f4.b.a(view, i);
                                if (a23 != null && (a13 = f4.b.a(view, (i = R$id.vd_land_bottom_controller))) != null && (a14 = f4.b.a(view, (i = R$id.vd_land_center_progress))) != null && (a15 = f4.b.a(view, (i = R$id.vd_land_toolbar))) != null && (a16 = f4.b.a(view, (i = R$id.vd_pause))) != null && (a17 = f4.b.a(view, (i = R$id.vd_seekbar))) != null && (a18 = f4.b.a(view, (i = R$id.vd_title))) != null) {
                                    i = R$id.vd_video_duration;
                                    TextView textView4 = (TextView) f4.b.a(view, i);
                                    if (textView4 != null) {
                                        i = R$id.vd_video_time;
                                        TextView textView5 = (TextView) f4.b.a(view, i);
                                        if (textView5 != null) {
                                            i = R$id.video_portrait_surface;
                                            FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                                            if (frameLayout2 != null) {
                                                i = R$id.vs_load_failed;
                                                ViewStub viewStub = (ViewStub) f4.b.a(view, i);
                                                if (viewStub != null) {
                                                    i = R$id.vs_replay;
                                                    ViewStub viewStub2 = (ViewStub) f4.b.a(view, i);
                                                    if (viewStub2 != null) {
                                                        return new y(constraintLayout, frameLayout, a, a2, a3, a4, a19, a21, constraintLayout, textView, a6, immSpeedView, a7, a8, textView2, textView3, a9, a10, a11, a22, a23, a13, a14, a15, a16, a17, a18, textView4, textView5, frameLayout2, viewStub, viewStub2);
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
