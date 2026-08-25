package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /home/user/Teezee-git/app_source/classes2.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f469c;

    /* renamed from: d, reason: collision with root package name */
    ViewPropertyAnimatorListener f470d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f471e;

    /* renamed from: b, reason: collision with root package name */
    private long f468b = -1;

    /* renamed from: f, reason: collision with root package name */
    private final ViewPropertyAnimatorListenerAdapter f472f = new a();

    /* renamed from: a, reason: collision with root package name */
    final ArrayList f467a = new ArrayList();

    class a extends ViewPropertyAnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f473a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f474b = 0;

        a() {
        }

        void a() {
            this.f474b = 0;
            this.f473a = false;
            h.this.b();
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            int i5 = this.f474b + 1;
            this.f474b = i5;
            if (i5 == h.this.f467a.size()) {
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = h.this.f470d;
                if (viewPropertyAnimatorListener != null) {
                    viewPropertyAnimatorListener.onAnimationEnd(null);
                }
                a();
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view) {
            if (this.f473a) {
                return;
            }
            this.f473a = true;
            ViewPropertyAnimatorListener viewPropertyAnimatorListener = h.this.f470d;
            if (viewPropertyAnimatorListener != null) {
                viewPropertyAnimatorListener.onAnimationStart(null);
            }
        }
    }

    public void a() {
        if (this.f471e) {
            Iterator it = this.f467a.iterator();
            while (it.hasNext()) {
                ((ViewPropertyAnimatorCompat) it.next()).cancel();
            }
            this.f471e = false;
        }
    }

    void b() {
        this.f471e = false;
    }

    public h c(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat) {
        if (!this.f471e) {
            this.f467a.add(viewPropertyAnimatorCompat);
        }
        return this;
    }

    public h d(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat, ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2) {
        this.f467a.add(viewPropertyAnimatorCompat);
        viewPropertyAnimatorCompat2.setStartDelay(viewPropertyAnimatorCompat.getDuration());
        this.f467a.add(viewPropertyAnimatorCompat2);
        return this;
    }

    public h e(long j5) {
        if (!this.f471e) {
            this.f468b = j5;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f471e) {
            this.f469c = interpolator;
        }
        return this;
    }

    public h g(ViewPropertyAnimatorListener viewPropertyAnimatorListener) {
        if (!this.f471e) {
            this.f470d = viewPropertyAnimatorListener;
        }
        return this;
    }

    public void h() {
        if (this.f471e) {
            return;
        }
        Iterator it = this.f467a.iterator();
        while (it.hasNext()) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = (ViewPropertyAnimatorCompat) it.next();
            long j5 = this.f468b;
            if (j5 >= 0) {
                viewPropertyAnimatorCompat.setDuration(j5);
            }
            Interpolator interpolator = this.f469c;
            if (interpolator != null) {
                viewPropertyAnimatorCompat.setInterpolator(interpolator);
            }
            if (this.f470d != null) {
                viewPropertyAnimatorCompat.setListener(this.f472f);
            }
            viewPropertyAnimatorCompat.start();
        }
        this.f471e = true;
    }
}
