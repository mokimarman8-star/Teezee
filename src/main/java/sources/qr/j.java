package qr;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.shorttv.R;
import com.transsion.shorttv_pugc.base.widget.TnTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class j implements f4.a {
    private final ConstraintLayout a;
    public final TnTextView b;
    public final RecyclerView c;
    public final TnTextView d;

    private j(ConstraintLayout constraintLayout, TnTextView tnTextView, RecyclerView recyclerView, TnTextView tnTextView2) {
        this.a = constraintLayout;
        this.b = tnTextView;
        this.c = recyclerView;
        this.d = tnTextView2;
    }

    public static j a(View view) {
        RecyclerView a;
        TnTextView a2;
        int i = R.id.main_operation_movie_more_text;
        TnTextView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R.id.main_operation_movie_rank_recycler))) == null || (a2 = f4.b.a(view, (i = R.id.main_operation_movie_rank_title))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new j((ConstraintLayout) view, a3, a, a2);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
