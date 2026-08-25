package wn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class p implements f4.a {
    private final FrameLayout a;
    public final RecyclerView b;
    public final SwipeRefreshLayout c;

    private p(FrameLayout frameLayout, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout) {
        this.a = frameLayout;
        this.b = recyclerView;
        this.c = swipeRefreshLayout;
    }

    public static p a(View view) {
        SwipeRefreshLayout a;
        int i = R$id.recyclerView;
        RecyclerView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.swipeRefresh))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new p((FrameLayout) view, a2, a);
    }

    public static p c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static p d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_room_post, viewGroup, false);
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
