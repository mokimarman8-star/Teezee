package fp;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.room.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h0 implements f4.a {
    private final View a;
    public final RecyclerView b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;

    private h0(View view, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = view;
        this.b = recyclerView;
        this.c = appCompatTextView;
        this.d = appCompatTextView2;
    }

    public static h0 a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        int i = R$id.recyclerView;
        RecyclerView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.tv_more))) == null || (a2 = f4.b.a(view, (i = R$id.tv_title))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new h0(view, a3, a, a2);
    }

    public View getRoot() {
        return this.a;
    }
}
