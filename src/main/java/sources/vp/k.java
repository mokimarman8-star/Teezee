package vp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class k implements f4.a {
    private final ConstraintLayout a;
    public final AppBarLayout b;
    public final RecyclerView c;
    public final TabLayout d;
    public final View e;
    public final ViewPager2 f;

    private k(ConstraintLayout constraintLayout, AppBarLayout appBarLayout, RecyclerView recyclerView, TabLayout tabLayout, View view, ViewPager2 viewPager2) {
        this.a = constraintLayout;
        this.b = appBarLayout;
        this.c = recyclerView;
        this.d = tabLayout;
        this.e = view;
        this.f = viewPager2;
    }

    public static k a(View view) {
        RecyclerView a;
        TabLayout a2;
        View a3;
        ViewPager2 a4;
        int i = R$id.appBarLayout;
        AppBarLayout a5 = f4.b.a(view, i);
        if (a5 == null || (a = f4.b.a(view, (i = R$id.rvRank))) == null || (a2 = f4.b.a(view, (i = R$id.tabs))) == null || (a3 = f4.b.a(view, (i = R$id.viewLine))) == null || (a4 = f4.b.a(view, (i = R$id.viewPager))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new k((ConstraintLayout) view, a5, a, a2, a3, a4);
    }

    public static k c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static k d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_search_values_layout, viewGroup, false);
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
