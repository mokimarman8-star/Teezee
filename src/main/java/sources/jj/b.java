package jj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.baseui.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class b implements f4.a {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final SwipeRefreshLayout c;
    public final RecyclerView d;
    public final TitleLayout e;

    private b(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, TitleLayout titleLayout) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = swipeRefreshLayout;
        this.d = recyclerView;
        this.e = titleLayout;
    }

    public static b a(View view) {
        RecyclerView a;
        TitleLayout a2;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.mRefreshLayout;
        SwipeRefreshLayout a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R.id.mRv))) == null || (a2 = f4.b.a(view, (i = R.id.mTitleLayout))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new b(constraintLayout, constraintLayout, a3, a, a2);
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.base_list_fragment_layout, viewGroup, false);
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
