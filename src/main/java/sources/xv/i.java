package xv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;
import com.transsion.wrapperad.view.cardpage.NativeCardPageView;
import com.transsnet.downloader.widget.DownloadView;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class i implements f4.a {
    private final ConstraintLayout a;
    public final BubbleTextView b;
    public final AppBarLayout c;
    public final DownloadView d;
    public final CoordinatorLayout e;
    public final FrameLayout f;
    public final FrameLayout g;
    public final FrameLayout h;
    public final FrameLayout i;
    public final AppCompatImageView j;
    public final AppCompatImageView k;
    public final mn.h l;
    public final MagicIndicator m;
    public final NativeCardPageView n;
    public final ViewPager2 o;
    public final FrameLayout p;
    public final FrameLayout q;
    public final CollapsingToolbarLayout r;
    public final GradientTextView s;
    public final View t;
    public final View u;

    private i(ConstraintLayout constraintLayout, BubbleTextView bubbleTextView, AppBarLayout appBarLayout, DownloadView downloadView, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, mn.h hVar, MagicIndicator magicIndicator, NativeCardPageView nativeCardPageView, ViewPager2 viewPager2, FrameLayout frameLayout5, FrameLayout frameLayout6, CollapsingToolbarLayout collapsingToolbarLayout, GradientTextView gradientTextView, View view, View view2) {
        this.a = constraintLayout;
        this.b = bubbleTextView;
        this.c = appBarLayout;
        this.d = downloadView;
        this.e = coordinatorLayout;
        this.f = frameLayout;
        this.g = frameLayout2;
        this.h = frameLayout3;
        this.i = frameLayout4;
        this.j = appCompatImageView;
        this.k = appCompatImageView2;
        this.l = hVar;
        this.m = magicIndicator;
        this.n = nativeCardPageView;
        this.o = viewPager2;
        this.p = frameLayout5;
        this.q = frameLayout6;
        this.r = collapsingToolbarLayout;
        this.s = gradientTextView;
        this.t = view;
        this.u = view2;
    }

    public static i a(View view) {
        AppBarLayout a;
        DownloadView a2;
        CoordinatorLayout a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        View a6;
        ViewPager2 a7;
        CollapsingToolbarLayout a8;
        GradientTextView a9;
        View a10;
        View a11;
        int i = R$id.activity_tip;
        BubbleTextView a12 = f4.b.a(view, i);
        if (a12 != null && (a = f4.b.a(view, (i = R$id.appBar))) != null && (a2 = f4.b.a(view, (i = R$id.btn_download))) != null && (a3 = f4.b.a(view, (i = R$id.cdl))) != null) {
            i = R$id.fl_bottom_dialog_container;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R$id.fl_full_player_container;
                FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                if (frameLayout2 != null) {
                    i = R$id.fl_player;
                    FrameLayout frameLayout3 = (FrameLayout) f4.b.a(view, i);
                    if (frameLayout3 != null) {
                        i = R$id.game_container;
                        FrameLayout frameLayout4 = (FrameLayout) f4.b.a(view, i);
                        if (frameLayout4 != null && (a4 = f4.b.a(view, (i = R$id.ivBack))) != null && (a5 = f4.b.a(view, (i = R$id.iv_publish))) != null && (a6 = f4.b.a(view, (i = R$id.layout_sync_adjust))) != null) {
                            mn.h a13 = mn.h.a(a6);
                            i = R$id.magic_indicator;
                            MagicIndicator a14 = f4.b.a(view, i);
                            if (a14 != null) {
                                i = R$id.nativeSlideshowView;
                                NativeCardPageView nativeCardPageView = (NativeCardPageView) f4.b.a(view, i);
                                if (nativeCardPageView != null && (a7 = f4.b.a(view, (i = R$id.rec_view_pager))) != null) {
                                    i = R$id.resourceDetectorGroup;
                                    FrameLayout frameLayout5 = (FrameLayout) f4.b.a(view, i);
                                    if (frameLayout5 != null) {
                                        i = R$id.subjectDetailLayout;
                                        FrameLayout frameLayout6 = (FrameLayout) f4.b.a(view, i);
                                        if (frameLayout6 != null && (a8 = f4.b.a(view, (i = R$id.toolbar_layout))) != null && (a9 = f4.b.a(view, (i = R$id.tv_post))) != null && (a10 = f4.b.a(view, (i = R$id.v_player_bottom_space))) != null && (a11 = f4.b.a(view, (i = R$id.v_top_space))) != null) {
                                            return new i((ConstraintLayout) view, a12, a, a2, a3, frameLayout, frameLayout2, frameLayout3, frameLayout4, a4, a5, a13, a14, nativeCardPageView, a7, frameLayout5, frameLayout6, a8, a9, a10, a11);
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

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_video_detail, viewGroup, false);
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
