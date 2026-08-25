package fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.RoomJoinAnimationView;
import com.tn.lib.view.expand.ExpandView;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.baseui.widget.PileLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class o implements f4.a {
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final ConstraintLayout c;
    public final ExpandView d;
    public final FrameLayout e;
    public final Group f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    public final ShapeableImageView i;
    public final AppCompatImageView j;
    public final ImageView k;
    public final LinearLayout l;
    public final MagicIndicator m;
    public final PileLayout n;
    public final AppCompatTextView o;
    public final GradientTextView p;
    public final AppCompatTextView q;
    public final RoomJoinAnimationView r;
    public final View s;
    public final ViewPager2 t;

    private o(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, ConstraintLayout constraintLayout2, ExpandView expandView, FrameLayout frameLayout, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ShapeableImageView shapeableImageView, AppCompatImageView appCompatImageView3, ImageView imageView, LinearLayout linearLayout, MagicIndicator magicIndicator, PileLayout pileLayout, AppCompatTextView appCompatTextView, GradientTextView gradientTextView, AppCompatTextView appCompatTextView2, RoomJoinAnimationView roomJoinAnimationView, View view, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = constraintLayout2;
        this.d = expandView;
        this.e = frameLayout;
        this.f = group;
        this.g = appCompatImageView;
        this.h = appCompatImageView2;
        this.i = shapeableImageView;
        this.j = appCompatImageView3;
        this.k = imageView;
        this.l = linearLayout;
        this.m = magicIndicator;
        this.n = pileLayout;
        this.o = appCompatTextView;
        this.p = gradientTextView;
        this.q = appCompatTextView2;
        this.r = roomJoinAnimationView;
        this.s = view;
        this.t = viewPager2;
    }

    public static o a(View view) {
        ConstraintLayout a;
        ExpandView a2;
        Group a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        ShapeableImageView a6;
        AppCompatImageView a7;
        MagicIndicator a8;
        AppCompatTextView a9;
        AppCompatTextView a10;
        RoomJoinAnimationView a11;
        View a12;
        ViewPager2 a13;
        int i = R$id.app_bar;
        AppBarLayout a14 = f4.b.a(view, i);
        if (a14 != null && (a = f4.b.a(view, (i = R$id.cl_top_content))) != null && (a2 = f4.b.a(view, (i = R$id.ev_room_des))) != null) {
            i = R$id.fl_tab;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null && (a3 = f4.b.a(view, (i = R$id.group_member))) != null && (a4 = f4.b.a(view, (i = R$id.iv_back))) != null && (a5 = f4.b.a(view, (i = R$id.iv_publish))) != null && (a6 = f4.b.a(view, (i = R$id.iv_room_cover))) != null && (a7 = f4.b.a(view, (i = R$id.iv_share))) != null) {
                i = R$id.iv_top_bg;
                ImageView imageView = (ImageView) f4.b.a(view, i);
                if (imageView != null) {
                    i = R$id.ll_header_root;
                    LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                    if (linearLayout != null && (a8 = f4.b.a(view, (i = R$id.magic_indicator))) != null) {
                        i = R$id.pl_member_ic;
                        PileLayout pileLayout = (PileLayout) f4.b.a(view, i);
                        if (pileLayout != null && (a9 = f4.b.a(view, (i = R$id.tv_member))) != null) {
                            i = R$id.tv_post;
                            GradientTextView gradientTextView = (GradientTextView) f4.b.a(view, i);
                            if (gradientTextView != null && (a10 = f4.b.a(view, (i = R$id.tv_title))) != null && (a11 = f4.b.a(view, (i = R$id.v_join))) != null && (a12 = f4.b.a(view, (i = R$id.v_title_bar_bg))) != null && (a13 = f4.b.a(view, (i = R$id.view_pager))) != null) {
                                return new o((ConstraintLayout) view, a14, a, a2, frameLayout, a3, a4, a5, a6, a7, imageView, linearLayout, a8, pileLayout, a9, gradientTextView, a10, a11, a12, a13);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static o c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static o d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_room_detail_new, viewGroup, false);
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
