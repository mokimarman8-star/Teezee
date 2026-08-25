package xu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class b implements f4.a {
    private final LinearLayoutCompat a;
    public final RecyclerView b;
    public final SwipeRefreshLayout c;
    public final TitleLayout d;

    private b(LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TitleLayout titleLayout) {
        this.a = linearLayoutCompat;
        this.b = recyclerView;
        this.c = swipeRefreshLayout;
        this.d = titleLayout;
    }

    public static b a(View view) {
        SwipeRefreshLayout a;
        TitleLayout a2;
        int i = R$id.rvFollow;
        RecyclerView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.swipeRefresh))) == null || (a2 = f4.b.a(view, (i = R$id.titleLayout))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new b((LinearLayoutCompat) view, a3, a, a2);
    }

    public static b c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.activity_follow, viewGroup, false);
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
