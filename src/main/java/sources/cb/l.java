package cb;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class l implements d {
    private final float a;

    public l(float f) {
        this.a = f;
    }

    private static float b(RectF rectF) {
        return Math.min(rectF.width(), rectF.height());
    }

    @Override // cb.d
    public float a(RectF rectF) {
        return this.a * b(rectF);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof l) && this.a == ((l) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
