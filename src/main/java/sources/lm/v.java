package lm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class v implements f4.a {
    private final ConstraintLayout a;
    public final View b;
    public final ConstraintLayout c;
    public final AppCompatImageView d;
    public final RecyclerView e;
    public final AppCompatTextView f;
    public final AppCompatTextView g;

    private v(ConstraintLayout constraintLayout, View view, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = constraintLayout;
        this.b = view;
        this.c = constraintLayout2;
        this.d = appCompatImageView;
        this.e = recyclerView;
        this.f = appCompatTextView;
        this.g = appCompatTextView2;
    }

    public static v a(View view) {
        RecyclerView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        int i = R$id.divider;
        View a4 = f4.b.a(view, i);
        if (a4 != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R$id.iv_close;
            AppCompatImageView a5 = f4.b.a(view, i);
            if (a5 != null && (a = f4.b.a(view, (i = R$id.rv))) != null && (a2 = f4.b.a(view, (i = R$id.tv_all_episodes))) != null && (a3 = f4.b.a(view, (i = R$id.tv_title))) != null) {
                return new v(constraintLayout, a4, constraintLayout, a5, a, a2, a3);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static v c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static v d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_video_detail_seasons, viewGroup, false);
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
