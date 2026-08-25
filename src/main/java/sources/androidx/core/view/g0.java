package androidx.core.view;

import android.view.MotionEvent;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
class g0 {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f7239a = new float[20];

    /* renamed from: b, reason: collision with root package name */
    private final long[] f7240b = new long[20];

    /* renamed from: c, reason: collision with root package name */
    private float f7241c = 0.0f;

    /* renamed from: d, reason: collision with root package name */
    private int f7242d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f7243e = 0;

    g0() {
    }

    private void b() {
        this.f7242d = 0;
        this.f7241c = 0.0f;
    }

    private float e() {
        long[] jArr;
        long j5;
        int i5 = this.f7242d;
        if (i5 < 2) {
            return 0.0f;
        }
        int i6 = this.f7243e;
        int i7 = ((i6 + 20) - (i5 - 1)) % 20;
        long j6 = this.f7240b[i6];
        while (true) {
            jArr = this.f7240b;
            j5 = jArr[i7];
            if (j6 - j5 <= 100) {
                break;
            }
            this.f7242d--;
            i7 = (i7 + 1) % 20;
        }
        int i8 = this.f7242d;
        if (i8 < 2) {
            return 0.0f;
        }
        if (i8 == 2) {
            int i9 = (i7 + 1) % 20;
            if (j5 == jArr[i9]) {
                return 0.0f;
            }
            return this.f7239a[i9] / (r2 - j5);
        }
        float f5 = 0.0f;
        int i10 = 0;
        for (int i11 = 0; i11 < this.f7242d - 1; i11++) {
            int i12 = i11 + i7;
            long[] jArr2 = this.f7240b;
            long j7 = jArr2[i12 % 20];
            int i13 = (i12 + 1) % 20;
            if (jArr2[i13] != j7) {
                i10++;
                float f6 = f(f5);
                float f7 = this.f7239a[i13] / (this.f7240b[i13] - j7);
                f5 += (f7 - f6) * Math.abs(f7);
                if (i10 == 1) {
                    f5 *= 0.5f;
                }
            }
        }
        return f(f5);
    }

    private static float f(float f5) {
        return (f5 < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f5) * 2.0f));
    }

    void a(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.f7242d != 0 && eventTime - this.f7240b[this.f7243e] > 40) {
            b();
        }
        int i5 = (this.f7243e + 1) % 20;
        this.f7243e = i5;
        int i6 = this.f7242d;
        if (i6 != 20) {
            this.f7242d = i6 + 1;
        }
        this.f7239a[i5] = motionEvent.getAxisValue(26);
        this.f7240b[this.f7243e] = eventTime;
    }

    void c(int i5, float f5) {
        float e5 = e() * i5;
        this.f7241c = e5;
        if (e5 < (-Math.abs(f5))) {
            this.f7241c = -Math.abs(f5);
        } else if (this.f7241c > Math.abs(f5)) {
            this.f7241c = Math.abs(f5);
        }
    }

    float d(int i5) {
        if (i5 != 26) {
            return 0.0f;
        }
        return this.f7241c;
    }
}
