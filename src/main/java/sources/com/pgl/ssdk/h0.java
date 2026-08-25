package com.pgl.ssdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class h0 implements SensorEventListener {
    private static final float[] a = {999999.0f, 999999.0f, 999999.0f};
    public static boolean b = true;
    private static volatile h0 c;
    private final Context i;
    private Sensor d = null;
    private Sensor e = null;
    private Sensor f = null;
    private volatile boolean g = false;
    private volatile boolean h = false;
    private AtomicReference<a> j = new AtomicReference<>();
    private long k = 999999;

    private static class a {
        public long a;
        public float[] b = null;
        public float[] c = null;
        public float[] d = null;

        public a(long j) {
            this.a = j;
        }
    }

    private h0(Context context) {
        this.i = context;
    }

    public static h0 a(Context context) {
        if (c == null) {
            synchronized (h0.class) {
                try {
                    if (c == null) {
                        c = new h0(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        if (b) {
            c.c();
        }
        return c;
    }

    private static void a(Object[] objArr) {
        Float valueOf = Float.valueOf(999999.0f);
        objArr[0] = valueOf;
        objArr[1] = valueOf;
        objArr[2] = valueOf;
        objArr[3] = 999999L;
        float[] fArr = a;
        objArr[4] = fArr;
        objArr[5] = fArr;
    }

    private static void a(Object[] objArr, a aVar) {
        float[] fArr = aVar.b;
        if (fArr != null) {
            float[] fArr2 = aVar.c;
            float[] a2 = fArr2 != null ? a(objArr, fArr, fArr2) : a(objArr, fArr);
            objArr[0] = Float.valueOf(a2[0]);
            objArr[1] = Float.valueOf(a2[1]);
            objArr[2] = Float.valueOf(a2[2]);
            objArr[4] = aVar.b;
        } else {
            objArr[0] = Float.valueOf(999999.0f);
            objArr[1] = Float.valueOf(999999.0f);
            objArr[2] = Float.valueOf(999999.0f);
            objArr[4] = a;
        }
        objArr[3] = Long.valueOf(aVar.a);
        float[] fArr3 = aVar.d;
        if (fArr3 != null) {
            objArr[5] = fArr3;
        } else {
            objArr[5] = a;
        }
    }

    private static float[] a(Object[] objArr, float[] fArr) {
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float sqrt = 1.0f / ((float) Math.sqrt(((f * f) + (f2 * f2)) + (f3 * f3)));
        return new float[]{999999.0f, (((float) Math.toDegrees((float) Math.asin(-(f2 * sqrt)))) + 360.0f) % 360.0f, (((float) Math.toDegrees((float) Math.atan2(-(f * sqrt), f3 * sqrt))) + 360.0f) % 360.0f};
    }

    private static float[] a(Object[] objArr, float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[9];
        SensorManager.getRotationMatrix(fArr3, new float[9], fArr, fArr2);
        SensorManager.getOrientation(fArr3, new float[3]);
        return new float[]{(((float) Math.toDegrees(r2[0])) + 360.0f) % 360.0f, (((float) Math.toDegrees(r2[1])) + 360.0f) % 360.0f, (((float) Math.toDegrees(r2[2])) + 360.0f) % 360.0f};
    }

    private void c() {
        if (this.h) {
            return;
        }
        try {
            SensorManager sensorManager = (SensorManager) this.i.getApplicationContext().getSystemService("sensor");
            if (sensorManager != null) {
                this.d = sensorManager.getDefaultSensor(1);
                this.e = sensorManager.getDefaultSensor(2);
                this.f = sensorManager.getDefaultSensor(4);
            }
        } catch (Exception unused) {
        }
        this.h = true;
    }

    private void e() {
        this.k = -1L;
        this.g = false;
        try {
            SensorManager sensorManager = (SensorManager) this.i.getApplicationContext().getSystemService("sensor");
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
        } catch (Exception unused) {
        }
    }

    public void a() {
        if (!b || this.g) {
            return;
        }
        d();
    }

    public Object[] b() {
        Object[] objArr = new Object[6];
        a aVar = this.j.get();
        if (!b || aVar == null) {
            a(objArr);
            return objArr;
        }
        int i = 0;
        do {
            if ((this.d == null || aVar.b != null) && ((this.e == null || aVar.c != null) && (this.f == null || aVar.d != null))) {
                break;
            }
            w0.a(50L);
            i++;
        } while (i <= 20);
        e();
        this.g = false;
        a(objArr, aVar);
        this.j.set(null);
        return objArr;
    }

    public boolean d() {
        if (this.d != null) {
            try {
                SensorManager sensorManager = (SensorManager) this.i.getApplicationContext().getSystemService("sensor");
                if (sensorManager != null) {
                    boolean registerListener = sensorManager.registerListener(this, this.d, 1);
                    Sensor sensor = this.e;
                    if (sensor != null) {
                        sensorManager.registerListener(this, sensor, 1);
                    }
                    Sensor sensor2 = this.f;
                    if (sensor2 != null) {
                        sensorManager.registerListener(this, sensor2, 1);
                    }
                    if (registerListener) {
                        long currentTimeMillis = System.currentTimeMillis();
                        this.k = currentTimeMillis;
                        this.j.set(new a(currentTimeMillis));
                        this.g = true;
                    } else {
                        e();
                    }
                }
            } catch (Throwable unused) {
                e();
            }
        }
        return this.g;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        a aVar = this.j.get();
        if (aVar == null) {
            return;
        }
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            if (aVar.b == null) {
                aVar.b = sensorEvent.values;
            }
        } else if (type == 2) {
            if (aVar.c == null) {
                aVar.c = sensorEvent.values;
            }
        } else if (type == 4 && aVar.d == null) {
            aVar.d = sensorEvent.values;
        }
    }
}
