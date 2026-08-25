package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class w implements f4.a {
    private final ConstraintLayout a;
    public final View b;
    public final h0 c;
    public final Guideline d;
    public final RecyclerView e;
    public final SwipeRefreshLayout f;

    private w(ConstraintLayout constraintLayout, View view, h0 h0Var, Guideline guideline, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout) {
        this.a = constraintLayout;
        this.b = view;
        this.c = h0Var;
        this.d = guideline;
        this.e = recyclerView;
        this.f = swipeRefreshLayout;
    }

    public static w a(View view) {
        View a;
        RecyclerView a2;
        SwipeRefreshLayout a3;
        int i = R.id.sub_operation_header_bg;
        View a4 = f4.b.a(view, i);
        if (a4 != null && (a = f4.b.a(view, (i = R.id.sub_operation_loading))) != null) {
            h0 a5 = h0.a(a);
            i = R.id.sub_operation_main_guide;
            Guideline a6 = f4.b.a(view, i);
            if (a6 != null && (a2 = f4.b.a(view, (i = R.id.sub_operation_main_recycler))) != null && (a3 = f4.b.a(view, (i = R.id.sub_operation_main_refresh))) != null) {
                return new w((ConstraintLayout) view, a4, a5, a6, a2, a3);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static w c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static w d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_sub_tab, viewGroup, false);
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
