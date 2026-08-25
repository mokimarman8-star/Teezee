package fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CheckInAnimationView;
import com.tn.lib.view.ToolBarCheckInAnimationView;
import com.tn.lib.view.expand.ExpandView;
import com.transsion.baseui.widget.PileLayout;
import com.transsion.publish.view.PublishStateView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class n implements f4.a {
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final AppCompatImageView c;
    public final ConstraintLayout d;
    public final CoordinatorLayout e;
    public final AppCompatImageView f;
    public final ShapeableImageView g;
    public final PublishStateView h;
    public final ShapeableImageView i;
    public final ShapeableImageView j;
    public final AppCompatImageView k;
    public final d0 l;
    public final PileLayout m;
    public final ConstraintLayout n;
    public final Toolbar o;
    public final FrameLayout p;
    public final CollapsingToolbarLayout q;
    public final ToolBarCheckInAnimationView r;
    public final TextView s;
    public final CheckInAnimationView t;
    public final TextView u;
    public final AppCompatTextView v;
    public final ExpandView w;
    public final AppCompatTextView x;
    public final AppCompatTextView y;
    public final ViewPager2 z;

    private n(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2, CoordinatorLayout coordinatorLayout, AppCompatImageView appCompatImageView2, ShapeableImageView shapeableImageView, PublishStateView publishStateView, ShapeableImageView shapeableImageView2, ShapeableImageView shapeableImageView3, AppCompatImageView appCompatImageView3, d0 d0Var, PileLayout pileLayout, ConstraintLayout constraintLayout3, Toolbar toolbar, FrameLayout frameLayout, CollapsingToolbarLayout collapsingToolbarLayout, ToolBarCheckInAnimationView toolBarCheckInAnimationView, TextView textView, CheckInAnimationView checkInAnimationView, TextView textView2, AppCompatTextView appCompatTextView, ExpandView expandView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = appCompatImageView;
        this.d = constraintLayout2;
        this.e = coordinatorLayout;
        this.f = appCompatImageView2;
        this.g = shapeableImageView;
        this.h = publishStateView;
        this.i = shapeableImageView2;
        this.j = shapeableImageView3;
        this.k = appCompatImageView3;
        this.l = d0Var;
        this.m = pileLayout;
        this.n = constraintLayout3;
        this.o = toolbar;
        this.p = frameLayout;
        this.q = collapsingToolbarLayout;
        this.r = toolBarCheckInAnimationView;
        this.s = textView;
        this.t = checkInAnimationView;
        this.u = textView2;
        this.v = appCompatTextView;
        this.w = expandView;
        this.x = appCompatTextView2;
        this.y = appCompatTextView3;
        this.z = viewPager2;
    }

    public static n a(View view) {
        AppCompatImageView a;
        ConstraintLayout a2;
        CoordinatorLayout a3;
        AppCompatImageView a4;
        ShapeableImageView a5;
        ShapeableImageView a6;
        ShapeableImageView a7;
        AppCompatImageView a8;
        View a9;
        CollapsingToolbarLayout a10;
        ToolBarCheckInAnimationView a11;
        CheckInAnimationView a12;
        AppCompatTextView a13;
        ExpandView a14;
        AppCompatTextView a15;
        AppCompatTextView a16;
        ViewPager2 a17;
        int i = R$id.app_bar;
        AppBarLayout a18 = f4.b.a(view, i);
        if (a18 != null && (a = f4.b.a(view, (i = R$id.bg_transparent))) != null && (a2 = f4.b.a(view, (i = R$id.cl_bar))) != null && (a3 = f4.b.a(view, (i = R$id.content))) != null && (a4 = f4.b.a(view, (i = R$id.iv_back))) != null && (a5 = f4.b.a(view, (i = R$id.iv_cover_small))) != null) {
            i = R$id.ivPublish;
            PublishStateView publishStateView = (PublishStateView) f4.b.a(view, i);
            if (publishStateView != null && (a6 = f4.b.a(view, (i = R$id.iv_room_blur_cover))) != null && (a7 = f4.b.a(view, (i = R$id.iv_room_cover))) != null && (a8 = f4.b.a(view, (i = R$id.iv_share))) != null && (a9 = f4.b.a(view, (i = R$id.ll_tab_room))) != null) {
                d0 a19 = d0.a(a9);
                i = R$id.pl_member_ic;
                PileLayout pileLayout = (PileLayout) f4.b.a(view, i);
                if (pileLayout != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R$id.toolbar;
                    Toolbar a20 = f4.b.a(view, i);
                    if (a20 != null) {
                        i = R$id.toolbar_frame;
                        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
                        if (frameLayout != null && (a10 = f4.b.a(view, (i = R$id.toolbar_layout))) != null && (a11 = f4.b.a(view, (i = R$id.toolbarTvCheckIn))) != null) {
                            i = R$id.toolbar_tv_edit;
                            TextView textView = (TextView) f4.b.a(view, i);
                            if (textView != null && (a12 = f4.b.a(view, (i = R$id.tvCheckIn))) != null) {
                                i = R$id.tv_edit;
                                TextView textView2 = (TextView) f4.b.a(view, i);
                                if (textView2 != null && (a13 = f4.b.a(view, (i = R$id.tv_member_count))) != null && (a14 = f4.b.a(view, (i = R$id.tv_room_info_desc))) != null && (a15 = f4.b.a(view, (i = R$id.tv_room_title))) != null && (a16 = f4.b.a(view, (i = R$id.tv_title))) != null && (a17 = f4.b.a(view, (i = R$id.view_pager))) != null) {
                                    return new n(constraintLayout, a18, a, a2, a3, a4, a5, publishStateView, a6, a7, a8, a19, pileLayout, constraintLayout, a20, frameLayout, a10, a11, textView, a12, textView2, a13, a14, a15, a16, a17);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static n c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_room_detail, viewGroup, false);
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
