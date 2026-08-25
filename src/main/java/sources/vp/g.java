package vp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g implements f4.a {
    private final ConstraintLayout a;
    public final FrameLayout b;
    public final MagicIndicator c;
    public final View d;
    public final ProgressBar e;
    public final ViewPager2 f;

    private g(ConstraintLayout constraintLayout, FrameLayout frameLayout, MagicIndicator magicIndicator, View view, ProgressBar progressBar, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = frameLayout;
        this.c = magicIndicator;
        this.d = view;
        this.e = progressBar;
        this.f = viewPager2;
    }

    public static g a(View view) {
        MagicIndicator a;
        View a2;
        ViewPager2 a3;
        int i = R$id.search_result_empty_view;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null && (a = f4.b.a(view, (i = R$id.search_result_magic_indicator))) != null && (a2 = f4.b.a(view, (i = R$id.search_result_magic_indicator_divider))) != null) {
            i = R$id.search_result_progress_bar;
            ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
            if (progressBar != null && (a3 = f4.b.a(view, (i = R$id.search_result_view_pager))) != null) {
                return new g((ConstraintLayout) view, frameLayout, a, a2, progressBar, a3);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static g c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_search_result, viewGroup, false);
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
