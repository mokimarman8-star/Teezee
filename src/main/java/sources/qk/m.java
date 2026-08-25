package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m implements f4.a {
    private final LinearLayout a;
    public final a0 b;
    public final RecyclerView c;
    public final SwipeRefreshLayout d;

    private m(LinearLayout linearLayout, a0 a0Var, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout) {
        this.a = linearLayout;
        this.b = a0Var;
        this.c = recyclerView;
        this.d = swipeRefreshLayout;
    }

    public static m a(View view) {
        SwipeRefreshLayout a;
        int i = R.id.ll_tab_filter;
        View a2 = f4.b.a(view, i);
        if (a2 != null) {
            a0 a3 = a0.a(a2);
            int i2 = R.id.movie_list;
            RecyclerView a4 = f4.b.a(view, i2);
            if (a4 != null && (a = f4.b.a(view, (i2 = R.id.swipe_refresh))) != null) {
                return new m((LinearLayout) view, a3, a4, a);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static m c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static m d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_filter, viewGroup, false);
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
