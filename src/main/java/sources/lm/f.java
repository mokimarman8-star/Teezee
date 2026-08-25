package lm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.moviedetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f implements f4.a {
    private final RecyclerView a;
    public final RecyclerView b;

    private f(RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.a = recyclerView;
        this.b = recyclerView2;
    }

    public static f a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        RecyclerView recyclerView = (RecyclerView) view;
        return new f(recyclerView, recyclerView);
    }

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_for_you, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RecyclerView getRoot() {
        return this.a;
    }
}
