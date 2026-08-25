package qk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tn.lib.widget.TnTextView;
import com.transsion.home.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class o implements f4.a {
    private final FrameLayout a;
    public final ViewStub b;
    public final ViewStub c;
    public final ViewStub d;
    public final RecyclerView e;
    public final SwipeRefreshLayout f;
    public final TnTextView g;

    private o(FrameLayout frameLayout, ViewStub viewStub, ViewStub viewStub2, ViewStub viewStub3, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, TnTextView tnTextView) {
        this.a = frameLayout;
        this.b = viewStub;
        this.c = viewStub2;
        this.d = viewStub3;
        this.e = recyclerView;
        this.f = swipeRefreshLayout;
        this.g = tnTextView;
    }

    public static o a(View view) {
        RecyclerView a;
        SwipeRefreshLayout a2;
        TnTextView a3;
        int i = R.id.loading_stub;
        ViewStub viewStub = (ViewStub) f4.b.a(view, i);
        if (viewStub != null) {
            i = R.id.no_network_stub;
            ViewStub viewStub2 = (ViewStub) f4.b.a(view, i);
            if (viewStub2 != null) {
                i = R.id.no_result_stub;
                ViewStub viewStub3 = (ViewStub) f4.b.a(view, i);
                if (viewStub3 != null && (a = f4.b.a(view, (i = R.id.recycler_view))) != null && (a2 = f4.b.a(view, (i = R.id.swipe_refresh))) != null && (a3 = f4.b.a(view, (i = R.id.tv_selected_tags))) != null) {
                    return new o((FrameLayout) view, viewStub, viewStub2, viewStub3, a, a2, a3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static o c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static o d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_hashtag_page, viewGroup, false);
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
