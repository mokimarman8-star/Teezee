package qr;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.shorttv.R;
import com.transsion.shorttv_pugc.base.widget.HorizontalRecyclerview2;
import com.transsion.shorttv_pugc.base.widget.TnTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g implements f4.a {
    private final View a;
    public final HorizontalRecyclerview2 b;
    public final AppCompatTextView c;
    public final TnTextView d;
    public final AppCompatTextView e;

    private g(View view, HorizontalRecyclerview2 horizontalRecyclerview2, AppCompatTextView appCompatTextView, TnTextView tnTextView, AppCompatTextView appCompatTextView2) {
        this.a = view;
        this.b = horizontalRecyclerview2;
        this.c = appCompatTextView;
        this.d = tnTextView;
        this.e = appCompatTextView2;
    }

    public static g a(View view) {
        AppCompatTextView a;
        TnTextView a2;
        AppCompatTextView a3;
        int i = R.id.recycler_view;
        HorizontalRecyclerview2 a4 = f4.b.a(view, i);
        if (a4 == null || (a = f4.b.a(view, (i = R.id.tv_title))) == null || (a2 = f4.b.a(view, (i = R.id.tv_title_trending))) == null || (a3 = f4.b.a(view, (i = R.id.tv_view_all))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new g(view, a4, a, a2, a3);
    }

    public View getRoot() {
        return this.a;
    }
}
