package com.transsion.audio.view;

import android.R;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.therouter.TheRouter;
import com.transsion.audio.fragment.AudioBottomSheetFragment;
import com.transsion.audio.view.EnFloatingView;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.gslb.BuildConfig;
import ep.b$a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/user/Teezee-git/app_source/classes6.dex */
public class d {
    private FloatingMagnetView a;
    private WeakReference b;
    private final List c;
    private String d;
    private AudioBean e;

    class a implements EnFloatingView.f {
        final /* synthetic */ FrameLayout a;

        a(FrameLayout frameLayout) {
            this.a = frameLayout;
        }

        @Override // com.transsion.audio.view.EnFloatingView.f
        public void a(ViewGroup viewGroup) {
            d dVar = d.this;
            dVar.i((ViewGroup) dVar.b.get());
            for (b$a b_a : d.this.c) {
                if (b_a != null) {
                    b_a.onRemove();
                }
            }
            d.this.w(8);
        }

        @Override // com.transsion.audio.view.EnFloatingView.f
        public void b(ViewGroup viewGroup) {
            AudioBottomSheetFragment.INSTANCE.a(d.this.e).show(this.a.getContext().getSupportFragmentManager(), "dialog");
        }
    }

    private static class b {
        private static final d a = new d();
    }

    private d() {
        this.d = BuildConfig.FLAVOR;
        this.e = null;
        this.c = new ArrayList();
    }

    private void e(View view) {
        FrameLayout n;
        if (n() == null || (n = n()) == null) {
            return;
        }
        n.addView(view);
    }

    private void j(Activity activity, AudioBean audioBean) {
        if (this.a == null) {
            EnFloatingView enFloatingView = new EnFloatingView(activity);
            this.a = enFloatingView;
            e(enFloatingView);
        } else {
            w(0);
            if (!((ep.a) TheRouter.d(ep.a.class, new Object[0])).b(audioBean) && this.a.isPackUp()) {
                this.a.expanded();
            }
        }
    }

    public static d k() {
        return b.a;
    }

    private FrameLayout l(Activity activity) {
        if (activity == null) {
            return null;
        }
        try {
            return (FrameLayout) activity.getWindow().getDecorView().findViewById(R.id.content);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private FrameLayout n() {
        WeakReference weakReference = this.b;
        if (weakReference == null) {
            return null;
        }
        return (FrameLayout) weakReference.get();
    }

    public d d(Activity activity, AudioBean audioBean) {
        j(activity, audioBean);
        return this;
    }

    public d f(Activity activity) {
        g(activity, l(activity));
        return this;
    }

    public void g(Activity activity, FrameLayout frameLayout) {
        FloatingMagnetView floatingMagnetView;
        String simpleName = activity.getClass().getSimpleName();
        if (!TextUtils.equals(this.d, simpleName)) {
            this.d = simpleName;
            FloatingMagnetView floatingMagnetView2 = this.a;
            if (floatingMagnetView2 != null) {
                floatingMagnetView2.packUp();
            }
        }
        if (frameLayout == null || (floatingMagnetView = this.a) == null) {
            this.b = new WeakReference(frameLayout);
            return;
        }
        floatingMagnetView.setOnOptionListener(new a(frameLayout));
        if (this.a.getParent() == frameLayout) {
            return;
        }
        if (this.a.getParent() != null) {
            ((ViewGroup) this.a.getParent()).removeView(this.a);
        }
        this.a.attach(activity);
        this.b = new WeakReference(frameLayout);
        frameLayout.addView(this.a);
    }

    public d h(Activity activity) {
        i(l(activity));
        return this;
    }

    public void i(ViewGroup viewGroup) {
        FloatingMagnetView floatingMagnetView = this.a;
        if (floatingMagnetView != null && viewGroup != null && ViewCompat.isAttachedToWindow(floatingMagnetView)) {
            viewGroup.removeView(this.a);
        }
        if (n() == viewGroup) {
            this.b = null;
        }
    }

    public AudioBean m() {
        return this.e;
    }

    public Boolean o() {
        return Boolean.valueOf(this.a.getVisibility() == 8);
    }

    public d p(Long l, Long l2) {
        if (this.a != null) {
            int longValue = (int) (((l.longValue() * 1.0f) / l2.longValue()) * 100.0f);
            if (longValue > 100) {
                longValue = 100;
            }
            this.a.onProgress(longValue);
        }
        return this;
    }

    public d q(int i) {
        FloatingMagnetView floatingMagnetView = this.a;
        if (floatingMagnetView != null) {
            floatingMagnetView.onStateChanged(i);
        }
        return this;
    }

    public void r() {
        FloatingMagnetView floatingMagnetView = this.a;
        if (floatingMagnetView != null) {
            floatingMagnetView.packUp();
        }
    }

    public void s() {
        FloatingMagnetView floatingMagnetView = this.a;
        if (floatingMagnetView != null) {
            floatingMagnetView.packUpAnimation();
        }
    }

    public d t(AudioBean audioBean) {
        if (audioBean != null) {
            this.e = audioBean;
            wf.a.a.c("EnFloatingView", "prepare..mEnFloatingView.." + this.a, false);
            FloatingMagnetView floatingMagnetView = this.a;
            if (floatingMagnetView != null) {
                floatingMagnetView.prepare();
            }
        }
        return this;
    }

    public void u(b$a b_a) {
        this.c.remove(b_a);
    }

    public void v(b$a b_a) {
        this.c.add(b_a);
    }

    public d w(int i) {
        FloatingMagnetView floatingMagnetView = this.a;
        if (floatingMagnetView != null && floatingMagnetView.getVisibility() != i) {
            this.a.setVisibility(i);
        }
        return this;
    }

    public void x(String str) {
        m().setTitle(str);
    }
}
