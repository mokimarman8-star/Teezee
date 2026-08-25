package vp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f implements f4.a {
    private final RelativeLayout a;
    public final RecyclerView b;
    public final ImageView c;

    private f(RelativeLayout relativeLayout, RecyclerView recyclerView, ImageView imageView) {
        this.a = relativeLayout;
        this.b = recyclerView;
        this.c = imageView;
    }

    public static f a(View view) {
        int i = R$id.search_rank_pager_recycler;
        RecyclerView a = f4.b.a(view, i);
        if (a != null) {
            i = R$id.search_rank_pager_type;
            ImageView imageView = (ImageView) f4.b.a(view, i);
            if (imageView != null) {
                return new f((RelativeLayout) view, a, imageView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static f c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_search_rank_pager, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public RelativeLayout getRoot() {
        return this.a;
    }
}
