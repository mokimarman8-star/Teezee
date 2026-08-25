package bx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.transsnet.downloader.R;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class p0 implements f4.a {
    private final FrameLayout a;
    public final FrameLayout b;
    public final CoordinatorLayout c;
    public final MagicIndicator d;
    public final RecyclerView e;
    public final AppBarLayout f;
    public final ViewPager2 g;

    private p0(FrameLayout frameLayout, FrameLayout frameLayout2, CoordinatorLayout coordinatorLayout, MagicIndicator magicIndicator, RecyclerView recyclerView, AppBarLayout appBarLayout, ViewPager2 viewPager2) {
        this.a = frameLayout;
        this.b = frameLayout2;
        this.c = coordinatorLayout;
        this.d = magicIndicator;
        this.e = recyclerView;
        this.f = appBarLayout;
        this.g = viewPager2;
    }

    public static p0 a(View view) {
        CoordinatorLayout a;
        MagicIndicator a2;
        RecyclerView a3;
        AppBarLayout a4;
        ViewPager2 a5;
        int i = R.id.fl_all_only;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout == null || (a = f4.b.a(view, (i = R.id.ll_content))) == null || (a2 = f4.b.a(view, (i = R.id.magicIndicator))) == null || (a3 = f4.b.a(view, (i = R.id.rv_empty_foryou))) == null || (a4 = f4.b.a(view, (i = R.id.ugcDownloadAppBarLayout))) == null || (a5 = f4.b.a(view, (i = R.id.view_pager))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new p0((FrameLayout) view, frameLayout, a, a2, a3, a4, a5);
    }

    public static p0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static p0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_ugc_downloaded_app, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.a;
    }
}
