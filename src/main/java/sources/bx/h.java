package bx;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h implements f4.a {
    private final LinearLayout a;
    public final RecyclerView b;
    public final AppCompatTextView c;

    private h(LinearLayout linearLayout, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        this.a = linearLayout;
        this.b = recyclerView;
        this.c = appCompatTextView;
    }

    public static h a(View view) {
        AppCompatTextView a;
        int i = R.id.recycler_view;
        RecyclerView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R.id.tv_cancel))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new h((LinearLayout) view, a2, a);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
