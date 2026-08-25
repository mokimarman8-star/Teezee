package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLFrameLayout;
import com.tn.lib.view.RoomJoinAnimationView;
import com.tn.lib.view.expand.ExpandView;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.PileLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class l0 implements f4.a {
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final ConstraintLayout c;
    public final ExpandView d;
    public final BLFrameLayout e;
    public final FrameLayout f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    public final ShapeableImageView i;
    public final AppCompatImageView j;
    public final View k;
    public final ImageView l;
    public final LinearLayout m;
    public final MagicIndicator n;
    public final PileLayout o;
    public final LinearLayout p;
    public final AppCompatTextView q;
    public final AppCompatTextView r;
    public final RoomJoinAnimationView s;
    public final RoomJoinAnimationView t;
    public final View u;
    public final View v;
    public final TnTextView w;
    public final ViewPager2 x;

    private l0(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, ConstraintLayout constraintLayout2, ExpandView expandView, BLFrameLayout bLFrameLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView3, View view, ImageView imageView, LinearLayout linearLayout, MagicIndicator magicIndicator, PileLayout pileLayout, LinearLayout linearLayout2, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, RoomJoinAnimationView roomJoinAnimationView, RoomJoinAnimationView roomJoinAnimationView2, View view2, View view3, TnTextView tnTextView, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = constraintLayout2;
        this.d = expandView;
        this.e = bLFrameLayout;
        this.f = frameLayout;
        this.g = appCompatImageView;
        this.h = appCompatImageView2;
        this.i = shapeableImageView;
        this.j = appCompatImageView3;
        this.k = view;
        this.l = imageView;
        this.m = linearLayout;
        this.n = magicIndicator;
        this.o = pileLayout;
        this.p = linearLayout2;
        this.q = appCompatTextView;
        this.r = appCompatTextView2;
        this.s = roomJoinAnimationView;
        this.t = roomJoinAnimationView2;
        this.u = view2;
        this.v = view3;
        this.w = tnTextView;
        this.x = viewPager2;
    }

    public static l0 a(View view) {
        ConstraintLayout a;
        ExpandView a2;
        BLFrameLayout a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        ShapeableImageView a6;
        AppCompatImageView a7;
        View a8;
        MagicIndicator a9;
        PileLayout a10;
        AppCompatTextView a11;
        AppCompatTextView a12;
        RoomJoinAnimationView a13;
        RoomJoinAnimationView a14;
        View a15;
        View a16;
        TnTextView a17;
        ViewPager2 a18;
        int i = R$id.app_bar;
        AppBarLayout a19 = f4.b.a(view, i);
        if (a19 != null && (a = f4.b.a(view, (i = R$id.cl_top_content))) != null && (a2 = f4.b.a(view, (i = R$id.ev_room_des))) != null && (a3 = f4.b.a(view, (i = R$id.fl_tab))) != null) {
            i = R$id.flTabBg;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null && (a4 = f4.b.a(view, (i = R$id.iv_back))) != null && (a5 = f4.b.a(view, (i = R$id.iv_publish))) != null && (a6 = f4.b.a(view, (i = R$id.iv_room_cover))) != null && (a7 = f4.b.a(view, (i = R$id.iv_share))) != null && (a8 = f4.b.a(view, (i = R$id.iv_top_bg))) != null) {
                i = R$id.iv_top_bg_mask;
                ImageView imageView = (ImageView) f4.b.a(view, i);
                if (imageView != null) {
                    i = R$id.ll_header_root;
                    LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                    if (linearLayout != null && (a9 = f4.b.a(view, (i = R$id.magic_indicator))) != null && (a10 = f4.b.a(view, (i = R$id.pl_member_ic))) != null) {
                        i = R$id.titleContainer;
                        LinearLayout linearLayout2 = (LinearLayout) f4.b.a(view, i);
                        if (linearLayout2 != null && (a11 = f4.b.a(view, (i = R$id.tv_member))) != null && (a12 = f4.b.a(view, (i = R$id.tv_title))) != null && (a13 = f4.b.a(view, (i = R$id.v_join))) != null && (a14 = f4.b.a(view, (i = R$id.v_join_collapsed))) != null && (a15 = f4.b.a(view, (i = R$id.v_title_bar_bg))) != null && (a16 = f4.b.a(view, (i = R$id.v_top_bg_color))) != null && (a17 = f4.b.a(view, (i = R$id.videoCountText))) != null && (a18 = f4.b.a(view, (i = R$id.view_pager))) != null) {
                            return new l0((ConstraintLayout) view, a19, a, a2, a3, frameLayout, a4, a5, a6, a7, a8, imageView, linearLayout, a9, a10, linearLayout2, a11, a12, a13, a14, a15, a16, a17, a18);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static l0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static l0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_user_profile, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
