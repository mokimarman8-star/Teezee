package qr;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.shorttv.R;
import com.transsion.shorttv.base.widget.HorizontalRecyclerview2;
import com.transsion.shorttv.base.widget.TnTextView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i0 implements f4.a {
    private final View a;
    public final HorizontalRecyclerview2 b;
    public final AppCompatTextView c;
    public final TnTextView d;
    public final AppCompatTextView e;

    private i0(View view, HorizontalRecyclerview2 horizontalRecyclerview2, AppCompatTextView appCompatTextView, TnTextView tnTextView, AppCompatTextView appCompatTextView2) {
        this.a = view;
        this.b = horizontalRecyclerview2;
        this.c = appCompatTextView;
        this.d = tnTextView;
        this.e = appCompatTextView2;
    }

    public static i0 a(View view) {
        AppCompatTextView a;
        AppCompatTextView a2;
        int i = R.id.recycler_view;
        HorizontalRecyclerview2 horizontalRecyclerview2 = (HorizontalRecyclerview2) f4.b.a(view, i);
        if (horizontalRecyclerview2 != null && (a = f4.b.a(view, (i = R.id.tv_title))) != null) {
            i = R.id.tv_title_trending;
            TnTextView tnTextView = (TnTextView) f4.b.a(view, i);
            if (tnTextView != null && (a2 = f4.b.a(view, (i = R.id.tv_view_all))) != null) {
                return new i0(view, horizontalRecyclerview2, a, tnTextView, a2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
