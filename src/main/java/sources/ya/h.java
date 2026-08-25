package ya;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import com.google.android.material.R;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.f0;

/* loaded from: /home/user/Teezee-git/app_source/classes5.dex */
public class h extends ya.a {
    private final float g;
    private final float h;
    private float i;
    private Rect j;
    private Rect k;
    private Integer l;

    class a extends AnimatorListenerAdapter {
        final /* synthetic */ View a;

        a(View view) {
            this.a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.a;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public h(View view) {
        super(view);
        Resources resources = view.getResources();
        this.g = resources.getDimension(R.dimen.m3_back_progress_main_container_min_edge_gap);
        this.h = resources.getDimension(R.dimen.m3_back_progress_main_container_max_translation_y);
    }

    private ValueAnimator h(final ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(clippableRoundedCornerLayout.getCornerRadius(), k());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ya.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                h.q(clippableRoundedCornerLayout, valueAnimator);
            }
        });
        return ofFloat;
    }

    private AnimatorSet i(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.b, (Property<View, Float>) View.TRANSLATION_Y, 0.0f));
        animatorSet.addListener(new a(view));
        return animatorSet;
    }

    private int n() {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 31 || (rootWindowInsets = this.b.getRootWindowInsets()) == null) {
            return 0;
        }
        return Math.max(Math.max(o(rootWindowInsets, 0), o(rootWindowInsets, 1)), Math.max(o(rootWindowInsets, 3), o(rootWindowInsets, 2)));
    }

    private int o(WindowInsets windowInsets, int i) {
        RoundedCorner a2 = com.google.android.material.bottomsheet.a.a(windowInsets, i);
        if (a2 != null) {
            return com.google.android.material.bottomsheet.b.a(a2);
        }
        return 0;
    }

    private boolean p() {
        int[] iArr = new int[2];
        this.b.getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(ClippableRoundedCornerLayout clippableRoundedCornerLayout, ValueAnimator valueAnimator) {
        clippableRoundedCornerLayout.updateCornerRadius(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private void r() {
        this.i = 0.0f;
        this.j = null;
        this.k = null;
    }

    public void g(View view) {
        if (super.b() == null) {
            return;
        }
        AnimatorSet i = i(view);
        View view2 = this.b;
        if (view2 instanceof ClippableRoundedCornerLayout) {
            i.playTogether(h((ClippableRoundedCornerLayout) view2));
        }
        i.setDuration(this.e);
        i.start();
        r();
    }

    public void j(long j, View view) {
        AnimatorSet i = i(view);
        i.setDuration(j);
        i.start();
        r();
    }

    public int k() {
        if (this.l == null) {
            this.l = Integer.valueOf(p() ? n() : 0);
        }
        return this.l.intValue();
    }

    public Rect l() {
        return this.k;
    }

    public Rect m() {
        return this.j;
    }

    public void s(float f, View view) {
        this.j = f0.c(this.b);
        if (view != null) {
            this.k = f0.b(this.b, view);
        }
        this.i = f;
    }

    public void t(androidx.activity.b bVar, View view) {
        super.d(bVar);
        s(bVar.c(), view);
    }

    public void u(float f, boolean z, float f2, float f3) {
        float a2 = a(f);
        float width = this.b.getWidth();
        float height = this.b.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float a3 = qa.a.a(1.0f, 0.9f, a2);
        float a4 = qa.a.a(0.0f, Math.max(0.0f, ((width - (0.9f * width)) / 2.0f) - this.g), a2) * (z ? 1 : -1);
        float min = Math.min(Math.max(0.0f, ((height - (a3 * height)) / 2.0f) - this.g), this.h);
        float f4 = f2 - this.i;
        float a5 = qa.a.a(0.0f, min, Math.abs(f4) / height) * Math.signum(f4);
        this.b.setScaleX(a3);
        this.b.setScaleY(a3);
        this.b.setTranslationX(a4);
        this.b.setTranslationY(a5);
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.b;
        if (clippableRoundedCornerLayout instanceof ClippableRoundedCornerLayout) {
            clippableRoundedCornerLayout.updateCornerRadius(qa.a.a(k(), f3, a2));
        }
    }

    public void v(androidx.activity.b bVar, View view, float f) {
        if (super.e(bVar) == null) {
            return;
        }
        if (view != null && view.getVisibility() != 4) {
            view.setVisibility(4);
        }
        u(bVar.a(), bVar.b() == 0, bVar.c(), f);
    }
}
