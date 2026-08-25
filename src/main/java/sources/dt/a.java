package dt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.tabs.TabLayout;
import com.transsion.subroom.R;
import com.transsion.wrapperad.view.secondfloor.SecondFloorArcCoverView;
import com.transsion.wrapperad.view.secondfloor.TrendingTwoLevelIrregularView;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class a implements f4.a {
    private final ConstraintLayout a;
    public final SecondFloorArcCoverView b;
    public final View c;
    public final FrameLayout d;
    public final Group e;
    public final View f;
    public final ImageView g;
    public final View h;
    public final View i;
    public final ImageView j;
    public final TrendingTwoLevelIrregularView k;
    public final ImageView l;
    public final TabLayout m;

    private a(ConstraintLayout constraintLayout, SecondFloorArcCoverView secondFloorArcCoverView, View view, FrameLayout frameLayout, Group group, View view2, ImageView imageView, View view3, View view4, ImageView imageView2, TrendingTwoLevelIrregularView trendingTwoLevelIrregularView, ImageView imageView3, TabLayout tabLayout) {
        this.a = constraintLayout;
        this.b = secondFloorArcCoverView;
        this.c = view;
        this.d = frameLayout;
        this.e = group;
        this.f = view2;
        this.g = imageView;
        this.h = view3;
        this.i = view4;
        this.j = imageView2;
        this.k = trendingTwoLevelIrregularView;
        this.l = imageView3;
        this.m = tabLayout;
    }

    public static a a(View view) {
        View a;
        Group a2;
        View a3;
        View a4;
        View a5;
        TabLayout a6;
        int i = R.id.arcCover;
        SecondFloorArcCoverView secondFloorArcCoverView = (SecondFloorArcCoverView) f4.b.a(view, i);
        if (secondFloorArcCoverView != null && (a = f4.b.a(view, (i = R.id.centerBg))) != null) {
            i = R.id.container;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null && (a2 = f4.b.a(view, (i = R.id.largeBottomBg))) != null && (a3 = f4.b.a(view, (i = R.id.leftBg))) != null) {
                i = R.id.leftTwoBg;
                ImageView imageView = (ImageView) f4.b.a(view, i);
                if (imageView != null && (a4 = f4.b.a(view, (i = R.id.main_bottom_view))) != null && (a5 = f4.b.a(view, (i = R.id.rightBg))) != null) {
                    i = R.id.rightTwoBg;
                    ImageView imageView2 = (ImageView) f4.b.a(view, i);
                    if (imageView2 != null) {
                        i = R.id.secondFloorAdView;
                        TrendingTwoLevelIrregularView trendingTwoLevelIrregularView = (TrendingTwoLevelIrregularView) f4.b.a(view, i);
                        if (trendingTwoLevelIrregularView != null) {
                            i = R.id.tabBg;
                            ImageView imageView3 = (ImageView) f4.b.a(view, i);
                            if (imageView3 != null && (a6 = f4.b.a(view, (i = R.id.tab_bottom))) != null) {
                                return new a((ConstraintLayout) view, secondFloorArcCoverView, a, frameLayout, a2, a3, imageView, a4, a5, imageView2, trendingTwoLevelIrregularView, imageView3, a6);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static a c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_main, viewGroup, false);
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
