package bx;

import android.view.View;
import com.noober.background.view.BLView;
import com.tn.lib.widget.TnTextView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class h1 implements f4.a {
    private final View a;
    public final TnTextView b;
    public final BLView c;

    private h1(View view, TnTextView tnTextView, BLView bLView) {
        this.a = view;
        this.b = tnTextView;
        this.c = bLView;
    }

    public static h1 a(View view) {
        BLView a;
        int i = R.id.tv_title;
        TnTextView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R.id.v_dot))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new h1(view, a2, a);
    }

    public View getRoot() {
        return this.a;
    }
}
