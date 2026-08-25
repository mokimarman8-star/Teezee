package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.home.R;
import com.transsion.wrapperad.view.BiddingFloatingIrregularView;
import com.transsion.wrapperad.view.secondfloor.CustomSwipeRefreshLayout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class x implements f4.a {
    private final FrameLayout a;
    public final BiddingFloatingIrregularView b;
    public final h0 c;
    public final RecyclerView d;
    public final CustomSwipeRefreshLayout e;
    public final View f;

    private x(FrameLayout frameLayout, BiddingFloatingIrregularView biddingFloatingIrregularView, h0 h0Var, RecyclerView recyclerView, CustomSwipeRefreshLayout customSwipeRefreshLayout, View view) {
        this.a = frameLayout;
        this.b = biddingFloatingIrregularView;
        this.c = h0Var;
        this.d = recyclerView;
        this.e = customSwipeRefreshLayout;
        this.f = view;
    }

    public static x a(View view) {
        View a;
        CustomSwipeRefreshLayout a2;
        View a3;
        int i = R.id.floatingIrregularView;
        BiddingFloatingIrregularView a4 = f4.b.a(view, i);
        if (a4 != null && (a = f4.b.a(view, (i = R.id.loading_bg))) != null) {
            h0 a5 = h0.a(a);
            i = R.id.recycleView;
            RecyclerView a6 = f4.b.a(view, i);
            if (a6 != null && (a2 = f4.b.a(view, (i = R.id.swipe_refresh))) != null && (a3 = f4.b.a(view, (i = R.id.trending_header_bg))) != null) {
                return new x((FrameLayout) view, a4, a5, a6, a2, a3);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static x c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static x d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_trending, viewGroup, false);
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
