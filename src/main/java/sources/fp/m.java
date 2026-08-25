package fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tn.lib.view.AdvRecyclerView;
import com.tn.lib.view.TitleLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class m implements f4.a {
    private final LinearLayoutCompat a;
    public final AdvRecyclerView b;
    public final SwipeRefreshLayout c;
    public final TitleLayout d;

    private m(LinearLayoutCompat linearLayoutCompat, AdvRecyclerView advRecyclerView, SwipeRefreshLayout swipeRefreshLayout, TitleLayout titleLayout) {
        this.a = linearLayoutCompat;
        this.b = advRecyclerView;
        this.c = swipeRefreshLayout;
        this.d = titleLayout;
    }

    public static m a(View view) {
        SwipeRefreshLayout a;
        TitleLayout a2;
        int i = R$id.rv_room;
        AdvRecyclerView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.swipe_refresh))) == null || (a2 = f4.b.a(view, (i = R$id.tool_bar))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new m((LinearLayoutCompat) view, a3, a, a2);
    }

    public static m c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static m d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_room, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.a;
    }
}
