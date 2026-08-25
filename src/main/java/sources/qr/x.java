package qr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.widget.SafeRecyclerView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class x implements f4.a {
    private final ConstraintLayout a;
    public final SafeRecyclerView b;
    public final SwipeRefreshLayout c;
    public final View d;
    public final Space e;
    public final View f;
    public final View g;

    private x(ConstraintLayout constraintLayout, SafeRecyclerView safeRecyclerView, SwipeRefreshLayout swipeRefreshLayout, View view, Space space, View view2, View view3) {
        this.a = constraintLayout;
        this.b = safeRecyclerView;
        this.c = swipeRefreshLayout;
        this.d = view;
        this.e = space;
        this.f = view2;
        this.g = view3;
    }

    public static x a(View view) {
        SwipeRefreshLayout a;
        View a2;
        View a3;
        View a4;
        int i = R.id.recycler_view;
        SafeRecyclerView safeRecyclerView = (SafeRecyclerView) f4.b.a(view, i);
        if (safeRecyclerView != null && (a = f4.b.a(view, (i = R.id.swipe_refresh))) != null && (a2 = f4.b.a(view, (i = R.id.top_bg))) != null) {
            i = R.id.top_guideline;
            Space space = (Space) f4.b.a(view, i);
            if (space != null && (a3 = f4.b.a(view, (i = R.id.v_bar_space))) != null && (a4 = f4.b.a(view, (i = R.id.v_top_bg))) != null) {
                return new x((ConstraintLayout) view, safeRecyclerView, a, a2, space, a3, a4);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static x c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static x d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.short_tv_fragment_discover, viewGroup, false);
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
