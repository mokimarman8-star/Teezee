package androidx.media3.exoplayer.video.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
final class b implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f11924a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    private final float[] f11925b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    private final float[] f11926c = new float[16];

    /* renamed from: d, reason: collision with root package name */
    private final float[] f11927d = new float[3];

    /* renamed from: e, reason: collision with root package name */
    private final Display f11928e;

    /* renamed from: f, reason: collision with root package name */
    private final a[] f11929f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f11930g;

    public interface a {
        void a(float[] fArr, float f5);
    }

    public b(Display display, a... aVarArr) {
        this.f11928e = display;
        this.f11929f = aVarArr;
    }

    private float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.f11925b);
        SensorManager.getOrientation(this.f11925b, this.f11927d);
        return this.f11927d[2];
    }

    private void b(float[] fArr, float f5) {
        for (a aVar : this.f11929f) {
            aVar.a(fArr, f5);
        }
    }

    private void c(float[] fArr) {
        if (!this.f11930g) {
            androidx.media3.exoplayer.video.spherical.a.a(this.f11926c, fArr);
            this.f11930g = true;
        }
        float[] fArr2 = this.f11925b;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f11925b, 0, this.f11926c, 0);
    }

    private void d(float[] fArr, int i5) {
        if (i5 != 0) {
            int i6 = 129;
            int i7 = 1;
            if (i5 == 1) {
                i7 = 129;
                i6 = 2;
            } else if (i5 == 2) {
                i7 = 130;
            } else {
                if (i5 != 3) {
                    throw new IllegalStateException();
                }
                i6 = 130;
            }
            float[] fArr2 = this.f11925b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f11925b, i6, i7, fArr);
        }
    }

    private static void e(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i5) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f11924a, sensorEvent.values);
        d(this.f11924a, this.f11928e.getRotation());
        float a5 = a(this.f11924a);
        e(this.f11924a);
        c(this.f11924a);
        b(this.f11924a, a5);
    }
}
