package qr;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.shorttv.R;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class f implements f4.a {
    private final View a;
    public final RecyclerView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;

    private f(View view, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = view;
        this.b = recyclerView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
    }

    public static f a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        int i = R.id.recycler_view;
        RecyclerView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R.id.tv_title))) == null || (a2 = f4.b.a(view, (i = R.id.tv_view_all))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new f(view, a3, a, a2);
    }

    public View getRoot() {
        return this.a;
    }
}
