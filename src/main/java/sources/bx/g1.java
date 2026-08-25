package bx;

import android.view.View;
import com.noober.background.view.BLView;
import com.transsion.baseui.widget.GradientTextView;
import com.transsnet.downloader.R;

/* loaded from: /home/user/Teezee-git/app_source/classes7.dex */
public final class g1 implements f4.a {
    private final View a;
    public final GradientTextView b;
    public final BLView c;

    private g1(View view, GradientTextView gradientTextView, BLView bLView) {
        this.a = view;
        this.b = gradientTextView;
        this.c = bLView;
    }

    public static g1 a(View view) {
        BLView a;
        int i = R.id.tv_title;
        GradientTextView a2 = f4.b.a(view, i);
        if (a2 == null || (a = f4.b.a(view, (i = R.id.v_dot))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new g1(view, a2, a);
    }

    public View getRoot() {
        return this.a;
    }
}
