package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public abstract class KeyCycleOscillator {

    /* renamed from: a, reason: collision with root package name */
    private androidx.constraintlayout.core.motion.utils.b f5680a;

    /* renamed from: b, reason: collision with root package name */
    private a f5681b;

    /* renamed from: c, reason: collision with root package name */
    private String f5682c;

    /* renamed from: d, reason: collision with root package name */
    private int f5683d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f5684e = null;

    /* renamed from: f, reason: collision with root package name */
    public int f5685f = 0;

    /* renamed from: g, reason: collision with root package name */
    ArrayList f5686g = new ArrayList();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        private final int f5687a;

        /* renamed from: b, reason: collision with root package name */
        g f5688b;

        /* renamed from: c, reason: collision with root package name */
        private final int f5689c;

        /* renamed from: d, reason: collision with root package name */
        private final int f5690d;

        /* renamed from: e, reason: collision with root package name */
        private final int f5691e;

        /* renamed from: f, reason: collision with root package name */
        float[] f5692f;

        /* renamed from: g, reason: collision with root package name */
        double[] f5693g;

        /* renamed from: h, reason: collision with root package name */
        float[] f5694h;

        /* renamed from: i, reason: collision with root package name */
        float[] f5695i;

        /* renamed from: j, reason: collision with root package name */
        float[] f5696j;

        /* renamed from: k, reason: collision with root package name */
        float[] f5697k;

        /* renamed from: l, reason: collision with root package name */
        int f5698l;

        /* renamed from: m, reason: collision with root package name */
        androidx.constraintlayout.core.motion.utils.b f5699m;

        /* renamed from: n, reason: collision with root package name */
        double[] f5700n;

        /* renamed from: o, reason: collision with root package name */
        double[] f5701o;

        /* renamed from: p, reason: collision with root package name */
        float f5702p;

        a(int i5, String str, int i6, int i7) {
            g gVar = new g();
            this.f5688b = gVar;
            this.f5689c = 0;
            this.f5690d = 1;
            this.f5691e = 2;
            this.f5698l = i5;
            this.f5687a = i6;
            gVar.g(i5, str);
            this.f5692f = new float[i7];
            this.f5693g = new double[i7];
            this.f5694h = new float[i7];
            this.f5695i = new float[i7];
            this.f5696j = new float[i7];
            this.f5697k = new float[i7];
        }

        public double a(float f5) {
            androidx.constraintlayout.core.motion.utils.b bVar = this.f5699m;
            if (bVar != null) {
                double d5 = f5;
                bVar.g(d5, this.f5701o);
                this.f5699m.d(d5, this.f5700n);
            } else {
                double[] dArr = this.f5701o;
                dArr[0] = 0.0d;
                dArr[1] = 0.0d;
                dArr[2] = 0.0d;
            }
            double d6 = f5;
            double e5 = this.f5688b.e(d6, this.f5700n[1]);
            double d7 = this.f5688b.d(d6, this.f5700n[1], this.f5701o[1]);
            double[] dArr2 = this.f5701o;
            return dArr2[0] + (e5 * dArr2[2]) + (d7 * this.f5700n[2]);
        }

        public double b(float f5) {
            androidx.constraintlayout.core.motion.utils.b bVar = this.f5699m;
            if (bVar != null) {
                bVar.d(f5, this.f5700n);
            } else {
                double[] dArr = this.f5700n;
                dArr[0] = this.f5695i[0];
                dArr[1] = this.f5696j[0];
                dArr[2] = this.f5692f[0];
            }
            double[] dArr2 = this.f5700n;
            return dArr2[0] + (this.f5688b.e(f5, dArr2[1]) * this.f5700n[2]);
        }

        public void c(int i5, int i6, float f5, float f6, float f7, float f8) {
            this.f5693g[i5] = i6 / 100.0d;
            this.f5694h[i5] = f5;
            this.f5695i[i5] = f6;
            this.f5696j[i5] = f7;
            this.f5692f[i5] = f8;
        }

        public void d(float f5) {
            this.f5702p = f5;
            double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, this.f5693g.length, 3);
            float[] fArr = this.f5692f;
            this.f5700n = new double[fArr.length + 2];
            this.f5701o = new double[fArr.length + 2];
            if (this.f5693g[0] > 0.0d) {
                this.f5688b.a(0.0d, this.f5694h[0]);
            }
            double[] dArr2 = this.f5693g;
            int length = dArr2.length - 1;
            if (dArr2[length] < 1.0d) {
                this.f5688b.a(1.0d, this.f5694h[length]);
            }
            for (int i5 = 0; i5 < dArr.length; i5++) {
                double[] dArr3 = dArr[i5];
                dArr3[0] = this.f5695i[i5];
                dArr3[1] = this.f5696j[i5];
                dArr3[2] = this.f5692f[i5];
                this.f5688b.a(this.f5693g[i5], this.f5694h[i5]);
            }
            this.f5688b.f();
            double[] dArr4 = this.f5693g;
            if (dArr4.length > 1) {
                this.f5699m = androidx.constraintlayout.core.motion.utils.b.a(0, dArr4, dArr);
            } else {
                this.f5699m = null;
            }
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        int f5703a;

        /* renamed from: b, reason: collision with root package name */
        float f5704b;

        /* renamed from: c, reason: collision with root package name */
        float f5705c;

        /* renamed from: d, reason: collision with root package name */
        float f5706d;

        /* renamed from: e, reason: collision with root package name */
        float f5707e;

        public b(int i5, float f5, float f6, float f7, float f8) {
            this.f5703a = i5;
            this.f5704b = f8;
            this.f5705c = f6;
            this.f5706d = f5;
            this.f5707e = f7;
        }
    }

    public float a(float f5) {
        return (float) this.f5681b.b(f5);
    }

    public float b(float f5) {
        return (float) this.f5681b.a(f5);
    }

    protected void c(Object obj) {
    }

    public void d(int i5, int i6, String str, int i7, float f5, float f6, float f7, float f8) {
        this.f5686g.add(new b(i5, f5, f6, f7, f8));
        if (i7 != -1) {
            this.f5685f = i7;
        }
        this.f5683d = i6;
        this.f5684e = str;
    }

    public void e(int i5, int i6, String str, int i7, float f5, float f6, float f7, float f8, Object obj) {
        this.f5686g.add(new b(i5, f5, f6, f7, f8));
        if (i7 != -1) {
            this.f5685f = i7;
        }
        this.f5683d = i6;
        c(obj);
        this.f5684e = str;
    }

    public void f(String str) {
        this.f5682c = str;
    }

    public void g(float f5) {
        int size = this.f5686g.size();
        if (size == 0) {
            return;
        }
        Collections.sort(this.f5686g, new Comparator<b>() { // from class: androidx.constraintlayout.core.motion.utils.KeyCycleOscillator.1
            @Override // java.util.Comparator
            public int compare(b bVar, b bVar2) {
                return Integer.compare(bVar.f5703a, bVar2.f5703a);
            }
        });
        double[] dArr = new double[size];
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, 3);
        this.f5681b = new a(this.f5683d, this.f5684e, this.f5685f, size);
        Iterator it = this.f5686g.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            float f6 = bVar.f5706d;
            dArr[i5] = f6 * 0.01d;
            double[] dArr3 = dArr2[i5];
            float f7 = bVar.f5704b;
            dArr3[0] = f7;
            float f8 = bVar.f5705c;
            dArr3[1] = f8;
            float f9 = bVar.f5707e;
            dArr3[2] = f9;
            this.f5681b.c(i5, bVar.f5703a, f6, f8, f9, f7);
            i5++;
            dArr2 = dArr2;
        }
        this.f5681b.d(f5);
        this.f5680a = androidx.constraintlayout.core.motion.utils.b.a(0, dArr, dArr2);
    }

    public boolean h() {
        return this.f5685f == 1;
    }

    public String toString() {
        String str = this.f5682c;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator it = this.f5686g.iterator();
        while (it.hasNext()) {
            str = str + "[" + ((b) it.next()).f5703a + " , " + decimalFormat.format(r3.f5704b) + "] ";
        }
        return str;
    }
}
