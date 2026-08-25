package gm;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class l implements f4.a {
    private final ConstraintLayout a;

    private l(ConstraintLayout constraintLayout) {
        this.a = constraintLayout;
    }

    public static l a(View view) {
        if (view != null) {
            return new l((ConstraintLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.a;
    }
}
