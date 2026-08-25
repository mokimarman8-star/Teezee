package qr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.widget.TnTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class p implements f4.a {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final AppCompatImageView c;
    public final SwipeRefreshLayout d;
    public final RecyclerView e;
    public final TnTextView f;

    private p(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, TnTextView tnTextView) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = appCompatImageView;
        this.d = swipeRefreshLayout;
        this.e = recyclerView;
        this.f = tnTextView;
    }

    public static p a(View view) {
        SwipeRefreshLayout a;
        RecyclerView a2;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.iv_back;
        AppCompatImageView a3 = f4.b.a(view, i);
        if (a3 != null && (a = f4.b.a(view, (i = R.id.mRefreshLayout))) != null && (a2 = f4.b.a(view, (i = R.id.mRv))) != null) {
            i = R.id.tv_title;
            TnTextView tnTextView = (TnTextView) f4.b.a(view, i);
            if (tnTextView != null) {
                return new p(constraintLayout, constraintLayout, a3, a, a2, tnTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static p c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static p d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.short_tv_base_list_fragment_layout, viewGroup, false);
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
