package com.bytedance.sdk.openadsdk.sU;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.os.Vibrator;
import java.lang.ref.WeakReference;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class TEQ {
    public static WeakReference<Sj> Sj;
    protected static final float[] sP = new float[3];
    protected static final float[] TKC = new float[3];
    protected static final float[] EjP = new float[9];
    protected static final float[] HiB = new float[3];

    public static void EjP(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<Sj> weakReference = Sj;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th) {
            Jcg.Sj("SensorHub", "startListenRotationVector err", th);
        }
    }

    public static void Sj(Context context, long j) {
        if (context == null) {
            return;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(j);
    }

    public static void Sj(Context context, SensorEventListener sensorEventListener) {
    }

    public static void Sj(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<Sj> weakReference = Sj;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th) {
            Jcg.Sj("SensorHub", "startListenAccelerometer error", th);
        }
    }

    public static void Sj(Sj sj) {
        Sj = new WeakReference<>(sj);
    }

    public static void TKC(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<Sj> weakReference = Sj;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th) {
            Jcg.Sj("SensorHub", "startListenLinearAcceleration error", th);
        }
    }

    public static void sP(Context context, SensorEventListener sensorEventListener, int i) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<Sj> weakReference = Sj;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th) {
            Jcg.Sj("SensorHub", "startListenGyroscope error", th);
        }
    }
}
