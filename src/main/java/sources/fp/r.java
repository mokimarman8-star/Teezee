package fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class r implements f4.a {
    private final SwipeRefreshLayout a;
    public final RecyclerView b;
    public final SwipeRefreshLayout c;

    private r(SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout2) {
        this.a = swipeRefreshLayout;
        this.b = recyclerView;
        this.c = swipeRefreshLayout2;
    }

    public static r a(View view) {
        int i = R$id.recyclerView;
        RecyclerView a = f4.b.a(view, i);
        if (a == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view;
        return new r(swipeRefreshLayout, a, swipeRefreshLayout);
    }

    public static r c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static r d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_room_list, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SwipeRefreshLayout getRoot() {
        return this.a;
    }
}
