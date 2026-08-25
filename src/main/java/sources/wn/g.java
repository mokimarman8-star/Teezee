package wn;

import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.postdetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class g implements f4.a {
    private final LinearLayout a;
    public final AppCompatTextView b;
    public final AppCompatTextView c;

    private g(LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.a = linearLayout;
        this.b = appCompatTextView;
        this.c = appCompatTextView2;
    }

    public static g a(View view) {
        AppCompatTextView a;
        int i = R$id.post_cancel;
        AppCompatTextView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R$id.post_confirm))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new g((LinearLayout) view, a2, a);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
