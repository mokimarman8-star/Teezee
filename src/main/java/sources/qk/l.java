package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l implements f4.a {
    private final ConstraintLayout a;
    public final View b;
    public final ImageView c;
    public final View d;
    public final RecyclerView e;
    public final SwipeRefreshLayout f;
    public final TitleLayout g;

    private l(ConstraintLayout constraintLayout, View view, ImageView imageView, View view2, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TitleLayout titleLayout) {
        this.a = constraintLayout;
        this.b = view;
        this.c = imageView;
        this.d = view2;
        this.e = recyclerView;
        this.f = swipeRefreshLayout;
        this.g = titleLayout;
    }

    public static l a(View view) {
        View a;
        RecyclerView a2;
        SwipeRefreshLayout a3;
        TitleLayout a4;
        int i = R.id.film_list_color_mask;
        View a5 = f4.b.a(view, i);
        if (a5 != null) {
            i = R.id.film_list_cover;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null && (a = f4.b.a(view, (i = R.id.film_list_gradient))) != null && (a2 = f4.b.a(view, (i = R.id.recycler_view))) != null && (a3 = f4.b.a(view, (i = R.id.swipe_refresh))) != null && (a4 = f4.b.a(view, (i = R.id.tool_bar))) != null) {
                return new l((ConstraintLayout) view, a5, imageView, a, a2, a3, a4);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static l c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static l d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_film_list, viewGroup, false);
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
