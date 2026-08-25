package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final b f6933a;

    private static class a extends b {

        /* renamed from: e, reason: collision with root package name */
        private static HandlerThread f6934e;

        /* renamed from: f, reason: collision with root package name */
        private static Handler f6935f;

        /* renamed from: a, reason: collision with root package name */
        int f6936a;

        /* renamed from: b, reason: collision with root package name */
        SparseIntArray[] f6937b = new SparseIntArray[9];

        /* renamed from: c, reason: collision with root package name */
        private final ArrayList f6938c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        Window.OnFrameMetricsAvailableListener f6939d = new WindowOnFrameMetricsAvailableListenerC0046a();

        /* renamed from: androidx.core.app.g$a$a, reason: collision with other inner class name */
        class WindowOnFrameMetricsAvailableListenerC0046a implements Window.OnFrameMetricsAvailableListener {
            WindowOnFrameMetricsAvailableListenerC0046a() {
            }

            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i5) {
                a aVar = a.this;
                if ((aVar.f6936a & 1) != 0) {
                    aVar.e(aVar.f6937b[0], frameMetrics.getMetric(8));
                }
                a aVar2 = a.this;
                if ((aVar2.f6936a & 2) != 0) {
                    aVar2.e(aVar2.f6937b[1], frameMetrics.getMetric(1));
                }
                a aVar3 = a.this;
                if ((aVar3.f6936a & 4) != 0) {
                    aVar3.e(aVar3.f6937b[2], frameMetrics.getMetric(3));
                }
                a aVar4 = a.this;
                if ((aVar4.f6936a & 8) != 0) {
                    aVar4.e(aVar4.f6937b[3], frameMetrics.getMetric(4));
                }
                a aVar5 = a.this;
                if ((aVar5.f6936a & 16) != 0) {
                    aVar5.e(aVar5.f6937b[4], frameMetrics.getMetric(5));
                }
                a aVar6 = a.this;
                if ((aVar6.f6936a & 64) != 0) {
                    aVar6.e(aVar6.f6937b[6], frameMetrics.getMetric(7));
                }
                a aVar7 = a.this;
                if ((aVar7.f6936a & 32) != 0) {
                    aVar7.e(aVar7.f6937b[5], frameMetrics.getMetric(6));
                }
                a aVar8 = a.this;
                if ((aVar8.f6936a & 128) != 0) {
                    aVar8.e(aVar8.f6937b[7], frameMetrics.getMetric(0));
                }
                a aVar9 = a.this;
                if ((aVar9.f6936a & 256) != 0) {
                    aVar9.e(aVar9.f6937b[8], frameMetrics.getMetric(2));
                }
            }
        }

        a(int i5) {
            this.f6936a = i5;
        }

        @Override // androidx.core.app.g.b
        public void a(Activity activity) {
            if (f6934e == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                f6934e = handlerThread;
                handlerThread.start();
                f6935f = new Handler(f6934e.getLooper());
            }
            for (int i5 = 0; i5 <= 8; i5++) {
                SparseIntArray[] sparseIntArrayArr = this.f6937b;
                if (sparseIntArrayArr[i5] == null && (this.f6936a & (1 << i5)) != 0) {
                    sparseIntArrayArr[i5] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f6939d, f6935f);
            this.f6938c.add(new WeakReference(activity));
        }

        @Override // androidx.core.app.g.b
        public SparseIntArray[] b() {
            return this.f6937b;
        }

        @Override // androidx.core.app.g.b
        public SparseIntArray[] c(Activity activity) {
            Iterator it = this.f6938c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference weakReference = (WeakReference) it.next();
                if (weakReference.get() == activity) {
                    this.f6938c.remove(weakReference);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f6939d);
            return this.f6937b;
        }

        @Override // androidx.core.app.g.b
        public SparseIntArray[] d() {
            SparseIntArray[] sparseIntArrayArr = this.f6937b;
            this.f6937b = new SparseIntArray[9];
            return sparseIntArrayArr;
        }

        void e(SparseIntArray sparseIntArray, long j5) {
            if (sparseIntArray != null) {
                int i5 = (int) ((500000 + j5) / 1000000);
                if (j5 >= 0) {
                    sparseIntArray.put(i5, sparseIntArray.get(i5) + 1);
                }
            }
        }
    }

    private static class b {
        b() {
        }

        public void a(Activity activity) {
        }

        public SparseIntArray[] b() {
            return null;
        }

        public SparseIntArray[] c(Activity activity) {
            return null;
        }

        public SparseIntArray[] d() {
            return null;
        }
    }

    public g() {
        this(1);
    }

    public g(int i5) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f6933a = new a(i5);
        } else {
            this.f6933a = new b();
        }
    }

    public void a(Activity activity) {
        this.f6933a.a(activity);
    }

    public SparseIntArray[] b() {
        return this.f6933a.b();
    }

    public SparseIntArray[] c(Activity activity) {
        return this.f6933a.c(activity);
    }

    public SparseIntArray[] d() {
        return this.f6933a.d();
    }
}
