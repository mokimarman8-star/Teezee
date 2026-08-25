package m6;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public final class d implements b {
    @Override // m6.b
    public Animator[] a(View view) {
        Intrinsics.h(view, "view");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", view.getMeasuredHeight(), 0.0f);
        ofFloat.setDuration(400L);
        ofFloat.setInterpolator(new DecelerateInterpolator(1.3f));
        Intrinsics.g(ofFloat, "animator");
        return new Animator[]{ofFloat};
    }
}
