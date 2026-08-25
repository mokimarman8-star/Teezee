package eh;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.widget.R$id;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class g implements f4.a {
    private final ConstraintLayout a;
    public final ConstraintLayout b;
    public final View c;
    public final View d;
    public final View e;

    private g(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view, View view2, View view3) {
        this.a = constraintLayout;
        this.b = constraintLayout2;
        this.c = view;
        this.d = view2;
        this.e = view3;
    }

    public static g a(View view) {
        View a;
        View a2;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R$id.view1;
        View a3 = f4.b.a(view, i);
        if (a3 == null || (a = f4.b.a(view, (i = R$id.view2))) == null || (a2 = f4.b.a(view, (i = R$id.view3))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }
        return new g(constraintLayout, constraintLayout, a3, a, a2);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
