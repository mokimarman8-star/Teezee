package fp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class u implements f4.a {
    private final ConstraintLayout a;
    public final View b;
    public final RecyclerView c;
    public final ImageView d;
    public final ConstraintLayout e;
    public final SwipeRefreshLayout f;
    public final TextView g;

    private u(ConstraintLayout constraintLayout, View view, RecyclerView recyclerView, ImageView imageView, ConstraintLayout constraintLayout2, SwipeRefreshLayout swipeRefreshLayout, TextView textView) {
        this.a = constraintLayout;
        this.b = view;
        this.c = recyclerView;
        this.d = imageView;
        this.e = constraintLayout2;
        this.f = swipeRefreshLayout;
        this.g = textView;
    }

    public static u a(View view) {
        RecyclerView a;
        ConstraintLayout a2;
        SwipeRefreshLayout a3;
        int i = R$id.divider_line;
        View a4 = f4.b.a(view, i);
        if (a4 != null && (a = f4.b.a(view, (i = R$id.followingsRecyclerView))) != null) {
            i = R$id.iv_back;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null && (a2 = f4.b.a(view, (i = R$id.mTitleLayout))) != null && (a3 = f4.b.a(view, (i = R$id.swipe_refresh))) != null) {
                i = R$id.tv_title;
                TextView textView = (TextView) f4.b.a(view, i);
                if (textView != null) {
                    return new u((ConstraintLayout) view, a4, a, imageView, a2, a3, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static u c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static u d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_subscription_list, viewGroup, false);
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
