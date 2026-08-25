package qr;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.widget.TnTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class o0 implements f4.a {
    private final ConstraintLayout a;
    public final TnTextView b;
    public final RecyclerView c;
    public final TnTextView d;

    private o0(ConstraintLayout constraintLayout, TnTextView tnTextView, RecyclerView recyclerView, TnTextView tnTextView2) {
        this.a = constraintLayout;
        this.b = tnTextView;
        this.c = recyclerView;
        this.d = tnTextView2;
    }

    public static o0 a(View view) {
        RecyclerView a;
        int i = R.id.main_operation_movie_more_text;
        TnTextView tnTextView = (TnTextView) f4.b.a(view, i);
        if (tnTextView != null && (a = f4.b.a(view, (i = R.id.main_operation_movie_rank_recycler))) != null) {
            i = R.id.main_operation_movie_rank_title;
            TnTextView tnTextView2 = (TnTextView) f4.b.a(view, i);
            if (tnTextView2 != null) {
                return new o0((ConstraintLayout) view, tnTextView, a, tnTextView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
