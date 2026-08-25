package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.BlurredSectorView;
import com.transsion.home.R;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h implements f4.a {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final FrameLayout e;
    public final ConstraintLayout f;
    public final TnTextView g;
    public final MagicIndicator h;
    public final BlurredSectorView i;
    public final View j;
    public final ViewPager2 k;

    private h(ConstraintLayout constraintLayout, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, FrameLayout frameLayout2, ConstraintLayout constraintLayout2, TnTextView tnTextView, MagicIndicator magicIndicator, BlurredSectorView blurredSectorView, View view, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = frameLayout2;
        this.f = constraintLayout2;
        this.g = tnTextView;
        this.h = magicIndicator;
        this.i = blurredSectorView;
        this.j = view;
        this.k = viewPager2;
    }

    public static h a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        ConstraintLayout a3;
        TnTextView a4;
        MagicIndicator a5;
        View a6;
        ViewPager2 a7;
        int i = R.id.bottom_op_container;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null && (a = f4.b.a(view, (i = R.id.bottom_op_mb_logo))) != null && (a2 = f4.b.a(view, (i = R.id.bottom_op_search_appstore))) != null) {
            i = R.id.bottom_op_search_gamestore;
            FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
            if (frameLayout2 != null && (a3 = f4.b.a(view, (i = R.id.bottom_op_search_liner))) != null && (a4 = f4.b.a(view, (i = R.id.bottom_op_search_text))) != null && (a5 = f4.b.a(view, (i = R.id.magicIndicator))) != null) {
                i = R.id.trending_bottom_bg;
                BlurredSectorView blurredSectorView = (BlurredSectorView) f4.b.a(view, i);
                if (blurredSectorView != null && (a6 = f4.b.a(view, (i = R.id.viewLine))) != null && (a7 = f4.b.a(view, (i = R.id.viewPager))) != null) {
                    return new h((ConstraintLayout) view, frameLayout, a, a2, frameLayout2, a3, a4, a5, blurredSectorView, a6, a7);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bottom_op, viewGroup, false);
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
