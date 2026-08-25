package wn;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.TnTextView;
import com.transsion.postdetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e0 implements f4.a {
    private final View a;
    public final RecyclerView b;
    public final AppCompatTextView c;
    public final TnTextView d;
    public final AppCompatTextView e;

    private e0(View view, RecyclerView recyclerView, AppCompatTextView appCompatTextView, TnTextView tnTextView, AppCompatTextView appCompatTextView2) {
        this.a = view;
        this.b = recyclerView;
        this.c = appCompatTextView;
        this.d = tnTextView;
        this.e = appCompatTextView2;
    }

    public static e0 a(View view) {
        AppCompatTextView a;
        TnTextView a2;
        AppCompatTextView a3;
        int i = R$id.recycler_view;
        RecyclerView a4 = f4.b.a(view, i);
        if (a4 == null || (a = f4.b.a(view, (i = R$id.tv_title))) == null || (a2 = f4.b.a(view, (i = R$id.tv_title_trending))) == null || (a3 = f4.b.a(view, (i = R$id.tv_view_all))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new e0(view, a4, a, a2, a3);
    }

    public View getRoot() {
        return this.a;
    }
}
