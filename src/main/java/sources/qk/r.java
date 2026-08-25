package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r implements f4.a {
    private final CoordinatorLayout a;
    public final AppBarLayout b;
    public final AppCompatImageView c;
    public final AppCompatImageView d;
    public final RecyclerView e;
    public final Toolbar f;
    public final AppCompatTextView g;
    public final AppCompatTextView h;

    private r(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, RecyclerView recyclerView, Toolbar toolbar, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = coordinatorLayout;
        this.b = appBarLayout;
        this.c = appCompatImageView;
        this.d = appCompatImageView2;
        this.e = recyclerView;
        this.f = toolbar;
        this.g = appCompatTextView;
        this.h = appCompatTextView2;
    }

    public static r a(View view) {
        AppCompatImageView a;
        AppCompatImageView a2;
        RecyclerView a3;
        Toolbar a4;
        AppCompatTextView a5;
        AppCompatTextView a6;
        int i = R.id.app_bar;
        AppBarLayout a7 = f4.b.a(view, i);
        if (a7 == null || (a = f4.b.a(view, (i = R.id.ivBack))) == null || (a2 = f4.b.a(view, (i = R.id.iv_cover))) == null || (a3 = f4.b.a(view, (i = R.id.recycler_view))) == null || (a4 = f4.b.a(view, (i = R.id.toolbar))) == null || (a5 = f4.b.a(view, (i = R.id.tvTitle))) == null || (a6 = f4.b.a(view, (i = R.id.tvTitle_expand))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new r((CoordinatorLayout) view, a7, a, a2, a3, a4, a5, a6);
    }

    public static r c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static r d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_play_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout getRoot() {
        return this.a;
    }
}
