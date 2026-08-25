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
public final class t implements f4.a {
    private final ConstraintLayout a;
    public final RecyclerView b;
    public final RecyclerView c;
    public final SwipeRefreshLayout d;

    private t(ConstraintLayout constraintLayout, RecyclerView recyclerView, RecyclerView recyclerView2, SwipeRefreshLayout swipeRefreshLayout) {
        this.a = constraintLayout;
        this.b = recyclerView;
        this.c = recyclerView2;
        this.d = swipeRefreshLayout;
    }

    public static t a(View view) {
        RecyclerView a;
        SwipeRefreshLayout a2;
        int i = R$id.avatar_recyclerView;
        RecyclerView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.feed_recyclerView))) == null || (a2 = f4.b.a(view, (i = R$id.swipe_refresh))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new t((ConstraintLayout) view, a3, a, a2);
    }

    public static t c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static t d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subscription_detail, viewGroup, false);
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
