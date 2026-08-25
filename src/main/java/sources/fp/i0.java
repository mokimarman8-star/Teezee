package fp;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.room.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class i0 implements f4.a {
    private final View a;
    public final View b;
    public final RecyclerView c;
    public final TextView d;
    public final AppCompatTextView e;
    public final AppCompatTextView f;

    private i0(View view, View view2, RecyclerView recyclerView, TextView textView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = view;
        this.b = view2;
        this.c = recyclerView;
        this.d = textView;
        this.e = appCompatTextView;
        this.f = appCompatTextView2;
    }

    public static i0 a(View view) {
        RecyclerView a;
        AppCompatTextView a2;
        AppCompatTextView a3;
        int i = R$id.all_bg;
        View a4 = f4.b.a(view, i);
        if (a4 != null && (a = f4.b.a(view, (i = R$id.recyclerView))) != null) {
            i = R$id.tv_banner;
            TextView textView = (TextView) f4.b.a(view, i);
            if (textView != null && (a2 = f4.b.a(view, (i = R$id.tvMore))) != null && (a3 = f4.b.a(view, (i = R$id.tv_title))) != null) {
                return new i0(view, a4, a, textView, a2, a3);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public View getRoot() {
        return this.a;
    }
}
