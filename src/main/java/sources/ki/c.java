package ki;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.audio.R$id;
import com.transsion.audio.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class c implements f4.a {
    private final LinearLayoutCompat a;
    public final AppCompatImageView b;
    public final ShapeableImageView c;
    public final LinearLayoutCompat d;
    public final RecyclerView e;
    public final SwipeRefreshLayout f;
    public final AppCompatTextView g;

    private c(LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView, ShapeableImageView shapeableImageView, LinearLayoutCompat linearLayoutCompat2, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, AppCompatTextView appCompatTextView) {
        this.a = linearLayoutCompat;
        this.b = appCompatImageView;
        this.c = shapeableImageView;
        this.d = linearLayoutCompat2;
        this.e = recyclerView;
        this.f = swipeRefreshLayout;
        this.g = appCompatTextView;
    }

    public static c a(View view) {
        ShapeableImageView a;
        LinearLayoutCompat a2;
        RecyclerView a3;
        SwipeRefreshLayout a4;
        AppCompatTextView a5;
        int i = R$id.iv_enter;
        AppCompatImageView a6 = f4.b.a(view, i);
        if (a6 == null || (a = f4.b.a(view, (i = R$id.iv_subject_cover))) == null || (a2 = f4.b.a(view, (i = R$id.ll_subject))) == null || (a3 = f4.b.a(view, (i = R$id.rv_list))) == null || (a4 = f4.b.a(view, (i = R$id.swipe_refresh))) == null || (a5 = f4.b.a(view, (i = R$id.tv_subject_name))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new c((LinearLayoutCompat) view, a6, a, a2, a3, a4, a5);
    }

    public static c c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static c d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_relate_subject, viewGroup, false);
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
