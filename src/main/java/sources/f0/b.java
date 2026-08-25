package f0;

import androidx.collection.s;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final float f15196a;

    /* renamed from: b, reason: collision with root package name */
    private final float f15197b;

    /* renamed from: c, reason: collision with root package name */
    private final long f15198c;

    /* renamed from: d, reason: collision with root package name */
    private final int f15199d;

    public b(float f5, float f6, long j5, int i5) {
        this.f15196a = f5;
        this.f15197b = f6;
        this.f15198c = j5;
        this.f15199d = i5;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (bVar.f15196a == this.f15196a && bVar.f15197b == this.f15197b && bVar.f15198c == this.f15198c && bVar.f15199d == this.f15199d) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.f15196a) * 31) + Float.floatToIntBits(this.f15197b)) * 31) + s.a(this.f15198c)) * 31) + this.f15199d;
    }

    public String toString() {
        return "RotaryScrollEvent(verticalScrollPixels=" + this.f15196a + ",horizontalScrollPixels=" + this.f15197b + ",uptimeMillis=" + this.f15198c + ",deviceId=" + this.f15199d + ')';
    }
}
