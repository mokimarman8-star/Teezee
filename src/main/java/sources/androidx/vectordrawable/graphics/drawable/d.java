package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class d {
    public static Interpolator a(Context context, int i5) {
        return AnimationUtils.loadInterpolator(context, i5);
    }
}
