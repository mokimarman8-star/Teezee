package k7;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.cloud.tmc.integration.params.TmcStartParams;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class e implements SensorEventListener {
    private final SensorManager a;
    private float[] b;
    private float c;
    private float[] d;
    private float e;
    private float f;
    private float[] g;
    private float h;
    private float[] i;
    private float[] j;
    private final AtomicBoolean k;

    private static class b {
        private static final e a = new e();
    }

    private e() {
        this.b = new float[0];
        this.d = new float[0];
        this.g = new float[0];
        this.i = new float[0];
        this.j = new float[0];
        this.k = new AtomicBoolean(false);
        this.a = (SensorManager) com.cloud.sdk.commonutil.util.e.a().getSystemService("sensor");
    }

    public static e e() {
        return b.a;
    }

    public static Bundle k() {
        Bundle bundle = new Bundle();
        try {
            bundle.putFloatArray("ots", e().h());
            bundle.putFloat(TmcStartParams.KEY_LANDSCAPE_SHORT, e().f());
            bundle.putFloatArray("ms", e().g());
            bundle.putFloat("pxs", e().j());
            bundle.putFloat("tps", e().l());
            bundle.putFloatArray("gs", e().d());
            bundle.putFloat("pss", e().i());
            bundle.putFloatArray("gvs", e().c());
            bundle.putFloatArray("ams", e().b());
        } catch (Exception e) {
            k7.a.r0(Log.getStackTraceString(e));
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        this.k.set(true);
        this.a.unregisterListener(this);
    }

    public static void q() {
        try {
            try {
                try {
                    e().o();
                    e().p();
                } catch (Exception e) {
                    k7.a.r0(Log.getStackTraceString(e));
                    e().p();
                }
            } catch (Exception e2) {
                k7.a.r0(Log.getStackTraceString(e2));
            }
        } catch (Throwable th) {
            try {
                e().p();
            } catch (Exception e3) {
                k7.a.r0(Log.getStackTraceString(e3));
            }
            throw th;
        }
    }

    public float[] b() {
        return this.j;
    }

    public float[] c() {
        return this.i;
    }

    public float[] d() {
        return this.g;
    }

    public float f() {
        return this.c;
    }

    public float[] g() {
        return this.d;
    }

    public float[] h() {
        return this.b;
    }

    public float i() {
        return this.h;
    }

    public float j() {
        return this.e;
    }

    public float l() {
        return this.f;
    }

    public boolean m() {
        return this.k.get();
    }

    public void o() {
        SensorManager sensorManager = this.a;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(3), 3);
        SensorManager sensorManager2 = this.a;
        sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(4), 3);
        SensorManager sensorManager3 = this.a;
        sensorManager3.registerListener(this, sensorManager3.getDefaultSensor(9), 3);
        SensorManager sensorManager4 = this.a;
        sensorManager4.registerListener(this, sensorManager4.getDefaultSensor(1), 3);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor;
        float[] fArr;
        if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || (fArr = sensorEvent.values) == null || fArr.length < 1) {
            return;
        }
        switch (sensor.getType()) {
            case 1:
                this.j = sensorEvent.values;
                break;
            case 2:
                this.d = sensorEvent.values;
                break;
            case 3:
                this.b = sensorEvent.values;
                break;
            case 4:
                this.g = sensorEvent.values;
                break;
            case 5:
                this.c = sensorEvent.values[0];
                break;
            case 6:
                this.h = sensorEvent.values[0];
                break;
            case 7:
                this.f = sensorEvent.values[0];
                break;
            case 8:
                this.e = sensorEvent.values[0];
                break;
            case 9:
                this.i = sensorEvent.values;
                break;
        }
    }

    public void p() {
        if (Looper.myLooper() == null) {
            return;
        }
        new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: k7.d
            @Override // java.lang.Runnable
            public final void run() {
                e.this.n();
            }
        }, 1000L);
    }
}
