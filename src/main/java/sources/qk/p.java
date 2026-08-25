package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextSwitcher;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.BlurredSectorView;
import com.transsion.home.R;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class p implements f4.a {
    private final ConstraintLayout a;
    public final AppCompatImageButton b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final ConstraintLayout e;
    public final AppCompatImageView f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    public final AppCompatImageView i;
    public final ConstraintLayout j;
    public final MagicIndicator k;
    public final FrameLayout l;
    public final TextSwitcher m;
    public final BlurredSectorView n;
    public final TnTextView o;
    public final TnTextView p;
    public final TnTextView q;
    public final ConstraintLayout r;
    public final ViewPager2 s;

    private p(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, FrameLayout frameLayout, FrameLayout frameLayout2, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, ConstraintLayout constraintLayout3, MagicIndicator magicIndicator, FrameLayout frameLayout3, TextSwitcher textSwitcher, BlurredSectorView blurredSectorView, TnTextView tnTextView, TnTextView tnTextView2, TnTextView tnTextView3, ConstraintLayout constraintLayout4, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = appCompatImageButton;
        this.c = frameLayout;
        this.d = frameLayout2;
        this.e = constraintLayout2;
        this.f = appCompatImageView;
        this.g = appCompatImageView2;
        this.h = appCompatImageView3;
        this.i = appCompatImageView4;
        this.j = constraintLayout3;
        this.k = magicIndicator;
        this.l = frameLayout3;
        this.m = textSwitcher;
        this.n = blurredSectorView;
        this.o = tnTextView;
        this.p = tnTextView2;
        this.q = tnTextView3;
        this.r = constraintLayout4;
        this.s = viewPager2;
    }

    public static p a(View view) {
        ConstraintLayout a;
        AppCompatImageView a2;
        AppCompatImageView a3;
        AppCompatImageView a4;
        AppCompatImageView a5;
        ConstraintLayout a6;
        MagicIndicator a7;
        TnTextView a8;
        TnTextView a9;
        TnTextView a10;
        ConstraintLayout a11;
        ViewPager2 a12;
        int i = R.id.btn_tab_menu;
        AppCompatImageButton a13 = f4.b.a(view, i);
        if (a13 != null) {
            i = R.id.flGameCenter;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R.id.flPhoneCenter;
                FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                if (frameLayout2 != null && (a = f4.b.a(view, (i = R.id.gradeSelectorContainer))) != null && (a2 = f4.b.a(view, (i = R.id.ivGradeArrow))) != null && (a3 = f4.b.a(view, (i = R.id.iv_mb_logo))) != null && (a4 = f4.b.a(view, (i = R.id.ivNovelEnter))) != null && (a5 = f4.b.a(view, (i = R.id.ivUpdateApp))) != null && (a6 = f4.b.a(view, (i = R.id.ll_tab))) != null && (a7 = f4.b.a(view, (i = R.id.magic_indicator))) != null) {
                    i = R.id.search_left_container;
                    FrameLayout frameLayout3 = (FrameLayout) f4.b.a(view, i);
                    if (frameLayout3 != null) {
                        i = R.id.text_switcher;
                        TextSwitcher textSwitcher = (TextSwitcher) f4.b.a(view, i);
                        if (textSwitcher != null) {
                            i = R.id.trending_bottom_bg;
                            BlurredSectorView blurredSectorView = (BlurredSectorView) f4.b.a(view, i);
                            if (blurredSectorView != null && (a8 = f4.b.a(view, (i = R.id.tvGradeName))) != null && (a9 = f4.b.a(view, (i = R.id.tv_search))) != null && (a10 = f4.b.a(view, (i = R.id.tv_search_button))) != null && (a11 = f4.b.a(view, (i = R.id.tv_search_container))) != null && (a12 = f4.b.a(view, (i = R.id.view_pager))) != null) {
                                return new p((ConstraintLayout) view, a13, frameLayout, frameLayout2, a, a2, a3, a4, a5, a6, a7, frameLayout3, textSwitcher, blurredSectorView, a8, a9, a10, a11, a12);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static p c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static p d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_home, viewGroup, false);
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
