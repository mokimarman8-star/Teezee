package sj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.view.TitleLayout;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.R$layout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i implements f4.a {
    private final LinearLayoutCompat a;
    public final RecyclerView b;
    public final TitleLayout c;

    private i(LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, TitleLayout titleLayout) {
        this.a = linearLayoutCompat;
        this.b = recyclerView;
        this.c = titleLayout;
    }

    public static i a(View view) {
        TitleLayout a;
        int i = R$id.rv_game_list;
        RecyclerView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.title_layout))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new i((LinearLayoutCompat) view, a2, a);
    }

    public static i c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static i d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R$layout.fragment_game_center, viewGroup, false);
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
