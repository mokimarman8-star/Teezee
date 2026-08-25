package cb;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class c implements d {
    private final float a;

    public c(float f) {
        this.a = f;
    }

    public static c b(a aVar) {
        return new c(aVar.b());
    }

    private static float c(RectF rectF) {
        return Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
    }

    @Override // cb.d
    public float a(RectF rectF) {
        return Math.min(this.a, c(rectF));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && this.a == ((c) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
