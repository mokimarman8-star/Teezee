package dh;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: /home/user/Teezee-git/app_source/classes4.dex */
public final class a extends h {
    private final Float q;
    private final Float r;
    private final DecelerateInterpolator s;

    public a(Context context, Float f, Float f2) {
        super(context);
        this.q = f;
        this.r = f2;
        this.s = new DecelerateInterpolator(f2 != null ? f2.floatValue() : 1.0f);
    }

    protected void o(View view, RecyclerView.x xVar, RecyclerView.w.a aVar) {
        Intrinsics.h(view, "targetView");
        Intrinsics.h(xVar, "state");
        Intrinsics.h(aVar, "action");
        int t = t(view, z());
        int u = u(view, B());
        int w = w((int) Math.sqrt((t * t) + (u * u)));
        if (w > 0) {
            aVar.d(-t, -u, w, this.s);
        }
    }

    protected float v(DisplayMetrics displayMetrics) {
        Intrinsics.h(displayMetrics, "displayMetrics");
        Float f = this.q;
        return (f != null ? f.floatValue() : 25.0f) / displayMetrics.densityDpi;
    }
}
