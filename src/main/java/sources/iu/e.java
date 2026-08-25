package iu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ugcvideodetail.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class e implements f4.a {
    private final RecyclerView a;
    public final RecyclerView b;

    private e(RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.a = recyclerView;
        this.b = recyclerView2;
    }

    public static e a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        RecyclerView recyclerView = (RecyclerView) view;
        return new e(recyclerView, recyclerView);
    }

    public static e c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_ugc_detail_rv, viewGroup, false);
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
