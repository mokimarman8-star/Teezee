package fp;

import android.view.View;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.tn.lib.widget.TnTextView;
import com.transsion.room.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class e0 implements f4.a {
    private final View a;
    public final BLTextView b;
    public final TnTextView c;
    public final BLView d;

    private e0(View view, BLTextView bLTextView, TnTextView tnTextView, BLView bLView) {
        this.a = view;
        this.b = bLTextView;
        this.c = tnTextView;
        this.d = bLView;
    }

    public static e0 a(View view) {
        TnTextView a;
        BLView a2;
        int i = R$id.tv_badge;
        BLTextView a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.tv_title))) == null || (a2 = f4.b.a(view, (i = R$id.v_badge))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new e0(view, a3, a, a2);
    }

    public View getRoot() {
        return this.a;
    }
}
