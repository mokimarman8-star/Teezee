package qr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.shorttv.R;
import com.transsion.shorttv._channel.ui.widget.ShortTvPopupFilterView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a0 implements f4.a {
    private final LinearLayout a;
    public final d0 b;
    public final RecyclerView c;
    public final ShortTvPopupFilterView d;
    public final View e;
    public final View f;
    public final SwipeRefreshLayout g;

    private a0(LinearLayout linearLayout, d0 d0Var, RecyclerView recyclerView, ShortTvPopupFilterView shortTvPopupFilterView, View view, View view2, SwipeRefreshLayout swipeRefreshLayout) {
        this.a = linearLayout;
        this.b = d0Var;
        this.c = recyclerView;
        this.d = shortTvPopupFilterView;
        this.e = view;
        this.f = view2;
        this.g = swipeRefreshLayout;
    }

    public static a0 a(View view) {
        View a;
        View a2;
        SwipeRefreshLayout a3;
        int i = R.id.ll_tab_movie;
        View a4 = f4.b.a(view, i);
        if (a4 != null) {
            d0 a5 = d0.a(a4);
            i = R.id.movie_list;
            RecyclerView a6 = f4.b.a(view, i);
            if (a6 != null) {
                i = R.id.popup_filter_view;
                ShortTvPopupFilterView shortTvPopupFilterView = (ShortTvPopupFilterView) f4.b.a(view, i);
                if (shortTvPopupFilterView != null && (a = f4.b.a(view, (i = R.id.popup_filter_view_linear))) != null && (a2 = f4.b.a(view, (i = R.id.sub_movie_header_bg))) != null && (a3 = f4.b.a(view, (i = R.id.swipe_refresh))) != null) {
                    return new a0((LinearLayout) view, a5, a6, shortTvPopupFilterView, a, a2, a3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static a0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static a0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.short_tv_fragment_movie, viewGroup, false);
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
