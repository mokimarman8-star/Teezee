package vp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search_pugc.widget.NoInterceptRecyclerView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h implements f4.a {
    private final ConstraintLayout a;
    public final RecyclerView b;
    public final NoInterceptRecyclerView c;
    public final ProgressBar d;

    private h(ConstraintLayout constraintLayout, RecyclerView recyclerView, NoInterceptRecyclerView noInterceptRecyclerView, ProgressBar progressBar) {
        this.a = constraintLayout;
        this.b = recyclerView;
        this.c = noInterceptRecyclerView;
        this.d = progressBar;
    }

    public static h a(View view) {
        int i = R$id.search_result_list_recycler;
        RecyclerView a = f4.b.a(view, i);
        if (a != null) {
            i = R$id.search_result_list_tabs;
            NoInterceptRecyclerView noInterceptRecyclerView = (NoInterceptRecyclerView) f4.b.a(view, i);
            if (noInterceptRecyclerView != null) {
                i = R$id.search_result_tab_progress_bar;
                ProgressBar progressBar = (ProgressBar) f4.b.a(view, i);
                if (progressBar != null) {
                    return new h((ConstraintLayout) view, a, noInterceptRecyclerView, progressBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static h c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static h d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_search_result_list, viewGroup, false);
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
