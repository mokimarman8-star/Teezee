package wn;

import android.view.View;
import com.tn.lib.view.expand.ExpandView;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class h0 implements f4.a {
    private final ExpandView a;
    public final ExpandView b;

    private h0(ExpandView expandView, ExpandView expandView2) {
        this.a = expandView;
        this.b = expandView2;
    }

    public static h0 a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ExpandView expandView = (ExpandView) view;
        return new h0(expandView, expandView);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ExpandView getRoot() {
        return this.a;
    }
}
