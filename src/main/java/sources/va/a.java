package va;

import android.content.Context;
import android.graphics.Color;
import com.google.android.material.R;
import za.b;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class a {
    private static final int f = (int) Math.round(5.1000000000000005d);
    private final boolean a;
    private final int b;
    private final int c;
    private final int d;
    private final float e;

    public a(Context context) {
        this(b.b(context, R.attr.elevationOverlayEnabled, false), com.google.android.material.color.b.b(context, R.attr.elevationOverlayColor, 0), com.google.android.material.color.b.b(context, R.attr.elevationOverlayAccentColor, 0), com.google.android.material.color.b.b(context, R.attr.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    public a(boolean z, int i, int i2, int i3, float f2) {
        this.a = z;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f2;
    }

    private boolean f(int i) {
        return z0.b.p(i, 255) == this.d;
    }

    public float a(float f2) {
        if (this.e <= 0.0f || f2 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f2 / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i, float f2) {
        int i2;
        float a = a(f2);
        int alpha = Color.alpha(i);
        int j = com.google.android.material.color.b.j(z0.b.p(i, 255), this.b, a);
        if (a > 0.0f && (i2 = this.c) != 0) {
            j = com.google.android.material.color.b.i(j, z0.b.p(i2, f));
        }
        return z0.b.p(j, alpha);
    }

    public int c(int i, float f2) {
        return (this.a && f(i)) ? b(i, f2) : i;
    }

    public int d(float f2) {
        return c(this.d, f2);
    }

    public boolean e() {
        return this.a;
    }
}
