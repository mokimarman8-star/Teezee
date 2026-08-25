package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsnet.downloader.R;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class o0 implements f4.a {
    private final ConstraintLayout a;
    public final CoordinatorLayout b;
    public final FrameLayout c;
    public final FrameLayout d;
    public final LinearLayout e;
    public final MagicIndicator f;
    public final AppCompatTextView g;
    public final ViewPager2 h;

    private o0(ConstraintLayout constraintLayout, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout, MagicIndicator magicIndicator, AppCompatTextView appCompatTextView, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = coordinatorLayout;
        this.c = frameLayout;
        this.d = frameLayout2;
        this.e = linearLayout;
        this.f = magicIndicator;
        this.g = appCompatTextView;
        this.h = viewPager2;
    }

    public static o0 a(View view) {
        MagicIndicator a;
        AppCompatTextView a2;
        ViewPager2 a3;
        int i = R.id.cl_root;
        CoordinatorLayout a4 = f4.b.a(view, i);
        if (a4 != null) {
            i = R.id.flAppDownloadAd;
            FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
            if (frameLayout != null) {
                i = R.id.flTopCardAd;
                FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
                if (frameLayout2 != null) {
                    i = R.id.llTabLayout;
                    LinearLayout linearLayout = (LinearLayout) f4.b.a(view, i);
                    if (linearLayout != null && (a = f4.b.a(view, (i = R.id.magic_indicator))) != null && (a2 = f4.b.a(view, (i = R.id.tvTitleAll))) != null && (a3 = f4.b.a(view, (i = R.id.view_pager))) != null) {
                        return new o0((ConstraintLayout) view, a4, frameLayout, frameLayout2, linearLayout, a, a2, a3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static o0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static o0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_ugc_download_manager, viewGroup, false);
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
