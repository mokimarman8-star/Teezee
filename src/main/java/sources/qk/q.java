package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.home.R;
import com.transsion.home.view.filter.popup.PopupFilterView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class q implements f4.a {
    private final LinearLayout a;
    public final b0 b;
    public final RecyclerView c;
    public final PopupFilterView d;
    public final View e;
    public final View f;
    public final SwipeRefreshLayout g;

    private q(LinearLayout linearLayout, b0 b0Var, RecyclerView recyclerView, PopupFilterView popupFilterView, View view, View view2, SwipeRefreshLayout swipeRefreshLayout) {
        this.a = linearLayout;
        this.b = b0Var;
        this.c = recyclerView;
        this.d = popupFilterView;
        this.e = view;
        this.f = view2;
        this.g = swipeRefreshLayout;
    }

    public static q a(View view) {
        View a;
        View a2;
        SwipeRefreshLayout a3;
        int i = R.id.ll_tab_movie;
        View a4 = f4.b.a(view, i);
        if (a4 != null) {
            b0 a5 = b0.a(a4);
            i = R.id.movie_list;
            RecyclerView a6 = f4.b.a(view, i);
            if (a6 != null) {
                i = R.id.popup_filter_view;
                PopupFilterView popupFilterView = (PopupFilterView) f4.b.a(view, i);
                if (popupFilterView != null && (a = f4.b.a(view, (i = R.id.popup_filter_view_linear))) != null && (a2 = f4.b.a(view, (i = R.id.sub_movie_header_bg))) != null && (a3 = f4.b.a(view, (i = R.id.swipe_refresh))) != null) {
                    return new q((LinearLayout) view, a5, a6, popupFilterView, a, a2, a3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static q c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static q d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_movie, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
