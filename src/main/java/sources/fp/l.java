package fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l implements f4.a {
    private final ConstraintLayout a;
    public final SwipeRefreshLayout b;
    public final RecyclerView c;

    private l(ConstraintLayout constraintLayout, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView) {
        this.a = constraintLayout;
        this.b = swipeRefreshLayout;
        this.c = recyclerView;
    }

    public static l a(View view) {
        RecyclerView a;
        int i = R$id.swipe_refresh;
        SwipeRefreshLayout a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.waterfallRecyclerView))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new l((ConstraintLayout) view, a2, a);
    }

    public static l c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static l d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_likes_detail, viewGroup, false);
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
