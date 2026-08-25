package cb;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public final class a implements d {
    private final float a;

    public a(float f) {
        this.a = f;
    }

    @Override // cb.d
    public float a(RectF rectF) {
        return this.a;
    }

    public float b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.a == ((a) obj).a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.a)});
    }
}
