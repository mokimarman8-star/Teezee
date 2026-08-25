package wn;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.TnTextView;
import com.transsion.postdetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f0 implements f4.a {
    private final View a;
    public final RecyclerView b;
    public final TnTextView c;
    public final TnTextView d;

    private f0(View view, RecyclerView recyclerView, TnTextView tnTextView, TnTextView tnTextView2) {
        this.a = view;
        this.b = recyclerView;
        this.c = tnTextView;
        this.d = tnTextView2;
    }

    public static f0 a(View view) {
        TnTextView a;
        TnTextView a2;
        int i = R$id.recycler_view;
        RecyclerView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.tv_title))) == null || (a2 = f4.b.a(view, (i = R$id.tv_title_trending))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new f0(view, a3, a, a2);
    }

    public View getRoot() {
        return this.a;
    }
}
