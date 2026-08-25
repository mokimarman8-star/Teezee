package iu;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.ugcvideodetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class q implements f4.a {
    private final View a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;
    public final RecyclerView d;

    private q(View view, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, RecyclerView recyclerView) {
        this.a = view;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
        this.d = recyclerView;
    }

    public static q a(View view) {
        AppCompatTextView a;
        RecyclerView a2;
        int i = R$id.tvAll;
        AppCompatTextView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.tvTitle))) == null || (a2 = f4.b.a(view, (i = R$id.ugcDetailPlayListRv))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new q(view, a3, a, a2);
    }

    public View getRoot() {
        return this.a;
    }
}
