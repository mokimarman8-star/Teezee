package an;

import android.view.View;
import com.noober.background.view.BLView;
import com.tn.lib.widget.TnTextView;
import com.transsion.play.detail.R$id;
import f4.b;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class a implements f4.a {
    private final View a;
    public final TnTextView b;
    public final BLView c;

    private a(View view, TnTextView tnTextView, BLView bLView) {
        this.a = view;
        this.b = tnTextView;
        this.c = bLView;
    }

    public static a a(View view) {
        BLView a;
        int i = R$id.tv_title;
        TnTextView a2 = b.a(view, i);
        if (a2 == null || (a = b.a(view, (i = R$id.v_dot))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new a(view, a2, a);
    }

    public View getRoot() {
        return this.a;
    }
}
