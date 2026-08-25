package com.bytedance.adsdk.sP.Jcg;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.bytedance.adsdk.sP.Jcg;

/* loaded from: /home/user/Teezee-git/app_source/classes3.dex */
public class Sj<T> {
    public PointF Dq;
    public final Interpolator EjP;
    private int Fmk;
    public final Interpolator HiB;
    public Float Jcg;
    public final T Sj;
    private final Jcg TEQ;
    public final Interpolator TKC;
    private float Ym;
    private float Zq;
    private float aa;
    public T sP;
    private int sef;
    public PointF uA;
    private float uvD;
    public final float vS;

    public Sj(Jcg jcg, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.Ym = -3987645.8f;
        this.aa = -3987645.8f;
        this.Fmk = 784923401;
        this.sef = 784923401;
        this.Zq = Float.MIN_VALUE;
        this.uvD = Float.MIN_VALUE;
        this.Dq = null;
        this.uA = null;
        this.TEQ = jcg;
        this.Sj = t;
        this.sP = t2;
        this.TKC = interpolator;
        this.EjP = null;
        this.HiB = null;
        this.vS = f;
        this.Jcg = f2;
    }

    public Sj(Jcg jcg, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float f, Float f2) {
        this.Ym = -3987645.8f;
        this.aa = -3987645.8f;
        this.Fmk = 784923401;
        this.sef = 784923401;
        this.Zq = Float.MIN_VALUE;
        this.uvD = Float.MIN_VALUE;
        this.Dq = null;
        this.uA = null;
        this.TEQ = jcg;
        this.Sj = t;
        this.sP = t2;
        this.TKC = null;
        this.EjP = interpolator;
        this.HiB = interpolator2;
        this.vS = f;
        this.Jcg = f2;
    }

    protected Sj(Jcg jcg, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.Ym = -3987645.8f;
        this.aa = -3987645.8f;
        this.Fmk = 784923401;
        this.sef = 784923401;
        this.Zq = Float.MIN_VALUE;
        this.uvD = Float.MIN_VALUE;
        this.Dq = null;
        this.uA = null;
        this.TEQ = jcg;
        this.Sj = t;
        this.sP = t2;
        this.TKC = interpolator;
        this.EjP = interpolator2;
        this.HiB = interpolator3;
        this.vS = f;
        this.Jcg = f2;
    }

    public Sj(T t) {
        this.Ym = -3987645.8f;
        this.aa = -3987645.8f;
        this.Fmk = 784923401;
        this.sef = 784923401;
        this.Zq = Float.MIN_VALUE;
        this.uvD = Float.MIN_VALUE;
        this.Dq = null;
        this.uA = null;
        this.TEQ = null;
        this.Sj = t;
        this.sP = t;
        this.TKC = null;
        this.EjP = null;
        this.HiB = null;
        this.vS = Float.MIN_VALUE;
        this.Jcg = Float.valueOf(Float.MAX_VALUE);
    }

    private Sj(T t, T t2) {
        this.Ym = -3987645.8f;
        this.aa = -3987645.8f;
        this.Fmk = 784923401;
        this.sef = 784923401;
        this.Zq = Float.MIN_VALUE;
        this.uvD = Float.MIN_VALUE;
        this.Dq = null;
        this.uA = null;
        this.TEQ = null;
        this.Sj = t;
        this.sP = t2;
        this.TKC = null;
        this.EjP = null;
        this.HiB = null;
        this.vS = Float.MIN_VALUE;
        this.Jcg = Float.valueOf(Float.MAX_VALUE);
    }

    public int Dq() {
        if (this.Fmk == 784923401) {
            this.Fmk = ((Integer) this.Sj).intValue();
        }
        return this.Fmk;
    }

    public float EjP() {
        if (this.TEQ == null) {
            return 1.0f;
        }
        if (this.uvD == Float.MIN_VALUE) {
            if (this.Jcg == null) {
                this.uvD = 1.0f;
            } else {
                this.uvD = TKC() + ((this.Jcg.floatValue() - this.vS) / this.TEQ.dNu());
            }
        }
        return this.uvD;
    }

    public boolean HiB() {
        return this.TKC == null && this.EjP == null && this.HiB == null;
    }

    public float Jcg() {
        if (this.aa == -3987645.8f) {
            this.aa = ((Float) this.sP).floatValue();
        }
        return this.aa;
    }

    public Sj<T> Sj(T t, T t2) {
        return new Sj<>(t, t2);
    }

    public boolean Sj(float f) {
        return f >= TKC() && f < EjP();
    }

    public float TKC() {
        Jcg jcg = this.TEQ;
        if (jcg == null) {
            return 0.0f;
        }
        if (this.Zq == Float.MIN_VALUE) {
            this.Zq = (this.vS - jcg.vS()) / this.TEQ.dNu();
        }
        return this.Zq;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.Sj + ", endValue=" + this.sP + ", startFrame=" + this.vS + ", endFrame=" + this.Jcg + ", interpolator=" + this.TKC + '}';
    }

    public int uA() {
        if (this.sef == 784923401) {
            this.sef = ((Integer) this.sP).intValue();
        }
        return this.sef;
    }

    public float vS() {
        if (this.Ym == -3987645.8f) {
            this.Ym = ((Float) this.Sj).floatValue();
        }
        return this.Ym;
    }
}
