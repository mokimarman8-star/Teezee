package ci;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public final class q {
    public static final q a = new q();

    private q() {
    }

    public final void a(View view) {
        ViewParent parent = view != null ? view.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
    }
}
