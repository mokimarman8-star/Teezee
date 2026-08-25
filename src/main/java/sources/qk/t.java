package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class t implements f4.a {
    private final ConstraintLayout a;
    public final RecyclerView b;
    public final ConstraintLayout c;

    private t(ConstraintLayout constraintLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout2) {
        this.a = constraintLayout;
        this.b = recyclerView;
        this.c = constraintLayout2;
    }

    public static t a(View view) {
        ConstraintLayout a;
        int i = R.id.rank_all_list_recycler;
        RecyclerView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R.id.rank_list_loading_frame))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new t((ConstraintLayout) view, a2, a);
    }

    public static t c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static t d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_rank_list, viewGroup, false);
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
