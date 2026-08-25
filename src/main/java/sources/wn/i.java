package wn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i implements f4.a {
    private final ConstraintLayout a;
    public final View b;
    public final ImageView c;
    public final ConstraintLayout d;
    public final SwipeRefreshLayout e;
    public final TextView f;
    public final RecyclerView g;

    private i(ConstraintLayout constraintLayout, View view, ImageView imageView, ConstraintLayout constraintLayout2, SwipeRefreshLayout swipeRefreshLayout, TextView textView, RecyclerView recyclerView) {
        this.a = constraintLayout;
        this.b = view;
        this.c = imageView;
        this.d = constraintLayout2;
        this.e = swipeRefreshLayout;
        this.f = textView;
        this.g = recyclerView;
    }

    public static i a(View view) {
        ConstraintLayout a;
        SwipeRefreshLayout a2;
        RecyclerView a3;
        int i = R$id.divider_line;
        View a4 = f4.b.a(view, i);
        if (a4 != null) {
            i = R$id.iv_back;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null && (a = f4.b.a(view, (i = R$id.mTitleLayout))) != null && (a2 = f4.b.a(view, (i = R$id.swipe_refresh))) != null) {
                i = R$id.tv_title;
                TextView textView = (TextView) f4.b.a(view, i);
                if (textView != null && (a3 = f4.b.a(view, (i = R$id.waterfallRecyclerView))) != null) {
                    return new i((ConstraintLayout) view, a4, imageView, a, a2, textView, a3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_favorite_detail, viewGroup, false);
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
