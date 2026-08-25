package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.tabs.TabLayout;
import com.tn.lib.view.NoTouchToolBar;
import com.tn.lib.widget.TnTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.widget.MyRoomView;
import com.transsion.wrapperad.view.NativeSlideshowView;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class j0 implements f4.a {
    public final NativeSlideshowView A;
    public final LinearLayoutCompat B;
    public final View C;
    public final View D;
    public final TabLayout E;
    public final NoTouchToolBar F;
    public final ConstraintLayout G;
    public final TnTextView H;
    public final TnTextView I;
    public final TnTextView J;
    public final TnTextView K;
    public final TnTextView L;
    public final TnTextView M;
    public final AppCompatTextView N;
    public final View O;
    public final AppCompatImageView P;
    public final View Q;
    public final View R;
    public final ViewPager2 S;
    public final View T;
    public final View U;
    public final View V;
    public final View W;
    public final View X;
    public final View Y;
    private final LinearLayoutCompat a;
    public final AppBarLayout b;
    public final AppCompatImageView c;
    public final CollapsingToolbarLayout d;
    public final View e;
    public final r0 f;
    public final ShapeableImageView g;
    public final AppCompatImageView h;
    public final TnTextView i;
    public final AppCompatImageView j;
    public final AppCompatImageView k;
    public final AppCompatImageView l;
    public final AppCompatImageView m;
    public final AppCompatImageView n;
    public final AppCompatImageView o;
    public final AppCompatImageView p;
    public final AppCompatImageView q;
    public final ShapeableImageView r;
    public final AppCompatImageView s;
    public final AppCompatImageView t;
    public final LinearLayoutCompat u;
    public final LinearLayoutCompat v;
    public final LinearLayoutCompat w;
    public final MyRoomView x;
    public final MyRoomView y;
    public final MyRoomView z;

    private j0(LinearLayoutCompat linearLayoutCompat, AppBarLayout appBarLayout, AppCompatImageView appCompatImageView, CollapsingToolbarLayout collapsingToolbarLayout, View view, r0 r0Var, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView2, TnTextView tnTextView, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, AppCompatImageView appCompatImageView6, AppCompatImageView appCompatImageView7, AppCompatImageView appCompatImageView8, AppCompatImageView appCompatImageView9, AppCompatImageView appCompatImageView10, ShapeableImageView shapeableImageView2, AppCompatImageView appCompatImageView11, AppCompatImageView appCompatImageView12, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, LinearLayoutCompat linearLayoutCompat4, MyRoomView myRoomView, MyRoomView myRoomView2, MyRoomView myRoomView3, NativeSlideshowView nativeSlideshowView, LinearLayoutCompat linearLayoutCompat5, View view2, View view3, TabLayout tabLayout, NoTouchToolBar noTouchToolBar, ConstraintLayout constraintLayout, TnTextView tnTextView2, TnTextView tnTextView3, TnTextView tnTextView4, TnTextView tnTextView5, TnTextView tnTextView6, TnTextView tnTextView7, AppCompatTextView appCompatTextView, View view4, AppCompatImageView appCompatImageView13, View view5, View view6, ViewPager2 viewPager2, View view7, View view8, View view9, View view10, View view11, View view12) {
        this.a = linearLayoutCompat;
        this.b = appBarLayout;
        this.c = appCompatImageView;
        this.d = collapsingToolbarLayout;
        this.e = view;
        this.f = r0Var;
        this.g = shapeableImageView;
        this.h = appCompatImageView2;
        this.i = tnTextView;
        this.j = appCompatImageView3;
        this.k = appCompatImageView4;
        this.l = appCompatImageView5;
        this.m = appCompatImageView6;
        this.n = appCompatImageView7;
        this.o = appCompatImageView8;
        this.p = appCompatImageView9;
        this.q = appCompatImageView10;
        this.r = shapeableImageView2;
        this.s = appCompatImageView11;
        this.t = appCompatImageView12;
        this.u = linearLayoutCompat2;
        this.v = linearLayoutCompat3;
        this.w = linearLayoutCompat4;
        this.x = myRoomView;
        this.y = myRoomView2;
        this.z = myRoomView3;
        this.A = nativeSlideshowView;
        this.B = linearLayoutCompat5;
        this.C = view2;
        this.D = view3;
        this.E = tabLayout;
        this.F = noTouchToolBar;
        this.G = constraintLayout;
        this.H = tnTextView2;
        this.I = tnTextView3;
        this.J = tnTextView4;
        this.K = tnTextView5;
        this.L = tnTextView6;
        this.M = tnTextView7;
        this.N = appCompatTextView;
        this.O = view4;
        this.P = appCompatImageView13;
        this.Q = view5;
        this.R = view6;
        this.S = viewPager2;
        this.T = view7;
        this.U = view8;
        this.V = view9;
        this.W = view10;
        this.X = view11;
        this.Y = view12;
    }

    public static j0 a(View view) {
        AppCompatImageView a;
        CollapsingToolbarLayout a2;
        View a3;
        View a4;
        AppCompatImageView a5;
        TnTextView a6;
        AppCompatImageView a7;
        AppCompatImageView a8;
        AppCompatImageView a9;
        AppCompatImageView a10;
        AppCompatImageView a11;
        AppCompatImageView a12;
        AppCompatImageView a13;
        AppCompatImageView a14;
        ShapeableImageView a15;
        AppCompatImageView a16;
        AppCompatImageView a17;
        LinearLayoutCompat a18;
        LinearLayoutCompat a19;
        View a20;
        View a21;
        TabLayout a22;
        NoTouchToolBar a23;
        ConstraintLayout a24;
        TnTextView a25;
        TnTextView a26;
        TnTextView a27;
        TnTextView a28;
        TnTextView a29;
        TnTextView a30;
        AppCompatTextView a31;
        View a32;
        AppCompatImageView a33;
        View a34;
        View a35;
        ViewPager2 a36;
        View a37;
        View a38;
        View a39;
        View a40;
        View a41;
        View a42;
        int i = R$id.appbar;
        AppBarLayout a43 = f4.b.a(view, i);
        if (a43 != null && (a = f4.b.a(view, (i = R$id.area1_bg))) != null && (a2 = f4.b.a(view, (i = R$id.collapsing))) != null && (a3 = f4.b.a(view, (i = R$id.divider))) != null && (a4 = f4.b.a(view, (i = R$id.entranceLayout))) != null) {
            r0 a44 = r0.a(a4);
            i = R$id.iv_avatar;
            ShapeableImageView a45 = f4.b.a(view, i);
            if (a45 != null && (a5 = f4.b.a(view, (i = R$id.iv_back))) != null && (a6 = f4.b.a(view, (i = R$id.iv_back_black))) != null && (a7 = f4.b.a(view, (i = R$id.iv_more))) != null && (a8 = f4.b.a(view, (i = R$id.iv_more_blank))) != null && (a9 = f4.b.a(view, (i = R$id.iv_notice))) != null && (a10 = f4.b.a(view, (i = R$id.iv_notice_blank))) != null && (a11 = f4.b.a(view, (i = R$id.iv_qr_code))) != null && (a12 = f4.b.a(view, (i = R$id.iv_qr_code_blank))) != null && (a13 = f4.b.a(view, (i = R$id.iv_setting))) != null && (a14 = f4.b.a(view, (i = R$id.iv_setting_blank))) != null && (a15 = f4.b.a(view, (i = R$id.iv_title_avatar))) != null && (a16 = f4.b.a(view, (i = R$id.iv_update))) != null && (a17 = f4.b.a(view, (i = R$id.iv_update_blank))) != null && (a18 = f4.b.a(view, (i = R$id.llBlock))) != null) {
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
                i = R$id.llTopLayout;
                LinearLayoutCompat a46 = f4.b.a(view, i);
                if (a46 != null) {
                    i = R$id.myRoomView1;
                    MyRoomView myRoomView = (MyRoomView) f4.b.a(view, i);
                    if (myRoomView != null) {
                        i = R$id.myRoomView2;
                        MyRoomView myRoomView2 = (MyRoomView) f4.b.a(view, i);
                        if (myRoomView2 != null) {
                            i = R$id.myRoomView3;
                            MyRoomView myRoomView3 = (MyRoomView) f4.b.a(view, i);
                            if (myRoomView3 != null) {
                                i = R$id.nativeSlideshowView;
                                NativeSlideshowView nativeSlideshowView = (NativeSlideshowView) f4.b.a(view, i);
                                if (nativeSlideshowView != null && (a19 = f4.b.a(view, (i = R$id.scroll_area2))) != null && (a20 = f4.b.a(view, (i = R$id.setting_blank_red_tips))) != null && (a21 = f4.b.a(view, (i = R$id.setting_red_tips))) != null && (a22 = f4.b.a(view, (i = R$id.tabs))) != null && (a23 = f4.b.a(view, (i = R$id.toolbar))) != null && (a24 = f4.b.a(view, (i = R$id.top_layout))) != null && (a25 = f4.b.a(view, (i = R$id.tvBlocked))) != null && (a26 = f4.b.a(view, (i = R$id.tv_edit))) != null && (a27 = f4.b.a(view, (i = R$id.tv_gender))) != null && (a28 = f4.b.a(view, (i = R$id.tv_login))) != null && (a29 = f4.b.a(view, (i = R$id.tv_title_user_name))) != null && (a30 = f4.b.a(view, (i = R$id.tv_user_id))) != null && (a31 = f4.b.a(view, (i = R$id.tv_user_name))) != null && (a32 = f4.b.a(view, (i = R$id.update_blank_red_tips))) != null && (a33 = f4.b.a(view, (i = R$id.update_red_tips))) != null && (a34 = f4.b.a(view, (i = R$id.v_area2_bg))) != null && (a35 = f4.b.a(view, (i = R$id.viewLine))) != null && (a36 = f4.b.a(view, (i = R$id.view_pager))) != null && (a37 = f4.b.a(view, (i = R$id.viewPlaceholder1))) != null && (a38 = f4.b.a(view, (i = R$id.viewPlaceholder2))) != null && (a39 = f4.b.a(view, (i = R$id.viewPlaceholder3))) != null && (a40 = f4.b.a(view, (i = R$id.view_red))) != null && (a41 = f4.b.a(view, (i = R$id.view_red_blank))) != null && (a42 = f4.b.a(view, (i = R$id.viewTheCover))) != null) {
                                    return new j0(linearLayoutCompat, a43, a, a2, a3, a44, a45, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, linearLayoutCompat, a46, myRoomView, myRoomView2, myRoomView3, nativeSlideshowView, a19, a20, a21, a22, a23, a24, a25, a26, a27, a28, a29, a30, a31, a32, a33, a34, a35, a36, a37, a38, a39, a40, a41, a42);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static j0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static j0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_profile, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
