package ya;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.material.R;
import com.google.logging.type.LogSeverity;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public abstract class a {
    private final TimeInterpolator a;
    protected final View b;
    protected final int c;
    protected final int d;
    protected final int e;
    private androidx.activity.b f;

    public a(View view) {
        this.b = view;
        Context context = view.getContext();
        this.a = j.g(context, R.attr.motionEasingStandardDecelerateInterpolator, PathInterpolatorCompat.create(0.0f, 0.0f, 0.0f, 1.0f));
        this.c = j.f(context, R.attr.motionDurationMedium2, LogSeverity.NOTICE_VALUE);
        this.d = j.f(context, R.attr.motionDurationShort3, 150);
        this.e = j.f(context, R.attr.motionDurationShort2, 100);
    }

    public float a(float f) {
        return this.a.getInterpolation(f);
    }

    protected androidx.activity.b b() {
        if (this.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        androidx.activity.b bVar = this.f;
        this.f = null;
        return bVar;
    }

    public androidx.activity.b c() {
        androidx.activity.b bVar = this.f;
        this.f = null;
        return bVar;
    }

    protected void d(androidx.activity.b bVar) {
        this.f = bVar;
    }

    protected androidx.activity.b e(androidx.activity.b bVar) {
        if (this.f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        androidx.activity.b bVar2 = this.f;
        this.f = bVar;
        return bVar2;
    }
}
