package lm;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.transsion.moviedetail.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class x implements f4.a {
    private final LinearLayout a;
    public final FrameLayout b;
    public final FrameLayout c;

    private x(LinearLayout linearLayout, FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.a = linearLayout;
        this.b = frameLayout;
        this.c = frameLayout2;
    }

    public static x a(View view) {
        int i = R$id.fl_empty_View;
        FrameLayout frameLayout = (FrameLayout) f4.b.a(view, i);
        if (frameLayout != null) {
            i = R$id.fl_room;
            FrameLayout frameLayout2 = (FrameLayout) f4.b.a(view, i);
            if (frameLayout2 != null) {
                return new x((LinearLayout) view, frameLayout, frameLayout2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.a;
    }
}
